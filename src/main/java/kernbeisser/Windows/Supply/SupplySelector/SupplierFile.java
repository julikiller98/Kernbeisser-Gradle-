package kernbeisser.Windows.Supply.SupplySelector;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.*;
import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.ObjectTable.Columns.Columns;
import kernbeisser.CustomComponents.ObjectTable.ObjectTable;
import kernbeisser.DBConnection.DBConnection;
import kernbeisser.DBEntities.Articles;
import kernbeisser.DBEntities.ShoppingItem;
import kernbeisser.DBEntities.Supplier;
import kernbeisser.Enums.ArticleCatalogState;
import kernbeisser.Tasks.ArticleComparedToCatalogEntry;
import kernbeisser.Tasks.Catalog.Catalog;
import kernbeisser.Windows.Supply.SupplyController;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.Setter;
import lombok.SneakyThrows;

@AllArgsConstructor
@Data
@Setter(AccessLevel.NONE)
public class SupplierFile {
  private final FileHeader header;
  private final List<LineContent> contents;
  private final Instant createDate;
  private final File origin;

  @SneakyThrows
  public static SupplierFile parse(File file) {
    List<String> lines = Files.readAllLines(file.toPath(), Catalog.DEFAULT_ENCODING);
    return new SupplierFile(
        FileHeader.parseLine(lines.get(0)),
        LineContent.parseContents(lines, 1),
        Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime().toInstant(),
        file);
  }

  public Collection<LineContent> getNotInCatalog() {
    @Cleanup EntityManager em = DBConnection.getEntityManager();
    @Cleanup("commit")
    EntityTransaction et = em.getTransaction();
    et.begin();
    Supplier kkSupplier = Supplier.getKKSupplier();
    return contents.stream()
        .filter(e -> Articles.getBySuppliersItemNumber(kkSupplier, e.getKkNumber()).isPresent())
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public Collection<ShoppingItem> collectShoppingItems(JComponent errorDisplayComponent) {

    List<ArticleCatalogState> irrelevantCatalogStates =
        Collections.singletonList(ArticleCatalogState.BARCODE_CHANGED);
    List<ArticleCatalogState> noBarcodeCatalogStates =
        Arrays.asList(
            ArticleCatalogState.BARCODE_CONFLICT_SAME_SUPPLIER,
            ArticleCatalogState.BARCODE_CONFLICT_OTHER_SUPPLIER);
    Supplier kkSupplier = Supplier.getKKSupplier();
    Collection<ShoppingItem> shoppingItems = new ArrayList<>();
    Collection<ArticleComparedToCatalogEntry> collectErrors = new ArrayList<>();
    for (LineContent content : contents) {
      if (!SupplyController.shouldBecomeShoppingItem(content)) {
        continue;
      }
      boolean noBarcode = false;
      ArticleComparedToCatalogEntry comparison = content.getComparedToCatalog();
      if (comparison != null) {
        ArticleCatalogState comparisonResultType = comparison.getResultType();
        if (irrelevantCatalogStates.contains(comparisonResultType)) {
          collectErrors.add(comparison);
          continue;
        }
        noBarcode = noBarcodeCatalogStates.contains(comparisonResultType);
        if (noBarcode) {
          collectErrors.add(comparison);
        }
      }
      shoppingItems.add(SupplyController.createShoppingItem(kkSupplier, content, noBarcode));
    }
    if (!collectErrors.isEmpty()) {
      ObjectTable<ArticleComparedToCatalogEntry> errors =
          new ObjectTable<>(
              collectErrors,
              Columns.<ArticleComparedToCatalogEntry>create(
                      "KK-Nummer", e -> e.getArticle().getSuppliersItemNumber())
                  .withSorter(Column.NUMBER_SORTER),
              Columns.<ArticleComparedToCatalogEntry>create(
                      "KB-Nummer", e -> e.getArticle().getKbNumber())
                  .withSorter(Column.NUMBER_SORTER),
              Columns.<ArticleComparedToCatalogEntry>create(
                      "Artikel", e -> e.getArticle().getName())
                  .withPreferredWidth(150),
              Columns.create("Fehler", this::comparisonErrorMessage).withPreferredWidth(350));
      JScrollPane errorPane = new JScrollPane(errors);
      Dimension thisSize = errorDisplayComponent.getSize();
      errorPane.setPreferredSize(
          new Dimension((int) (thisSize.getWidth() * 0.8), (int) (thisSize.getHeight() * 0.8)));

      JOptionPane.showMessageDialog(
          errorDisplayComponent,
          errorPane,
          "Bei der Übernahme der Artikel sind Fehler aufgetreten",
          JOptionPane.WARNING_MESSAGE);
    }
    return shoppingItems;
  }

  private String comparisonErrorMessage(ArticleComparedToCatalogEntry compared) {
    String message;
    switch (compared.getResultType()) {
      case BARCODE_CHANGED:
        message =
            "geänderter Barcode! Evtl. wurde die Artikelnummer durch den Lieferanten für einen neuen Artikel vergeben? Der Artikel wird daher nicht geändert!";
        break;
      case BARCODE_CONFLICT_SAME_SUPPLIER:
        message =
            String.format(
                "Barcode %d ist beim KB-Artikel %d vorhanden und wird daher nicht übernommen!",
                compared.getCatalogEntry().getEanLadenEinheit(),
                compared.getConflictingArticle().getKbNumber());
        break;
      case BARCODE_CONFLICT_OTHER_SUPPLIER:
        message =
            String.format(
                "Barcode %d ist schon beim KB-Artikel %d des Lieferanten %s vorhanden und wird daher nicht übernommen!",
                compared.getCatalogEntry().getEanLadenEinheit(),
                compared.getConflictingArticle().getKbNumber(),
                compared.getConflictingArticle().getSupplier().getName());
        break;
      default:
        message = "";
    }
    return message;
  }

  public int hashCode() {
    return header.getId().hashCode();
  }
}

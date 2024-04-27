package kernbeisser.Forms.FormImplemetations.Shelf;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import java.util.Set;
import javax.swing.*;
import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.ObjectTable.Columns.Columns;
import kernbeisser.CustomComponents.ObjectTable.ObjectTable;
import kernbeisser.DBEntities.Article;
import kernbeisser.DBEntities.PriceList;
import kernbeisser.DBEntities.Shelf;
import kernbeisser.Forms.ObjectForm.Components.AccessCheckingCollectionEditor;
import kernbeisser.Forms.ObjectForm.Components.AccessCheckingField;
import kernbeisser.Forms.ObjectForm.Components.DataListener;
import kernbeisser.Forms.ObjectForm.ObjectForm;
import kernbeisser.Useful.Icons;
import kernbeisser.Windows.CollectionView.CollectionView;
import kernbeisser.Windows.MVC.IView;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class ShelfView implements IView<ShelfController> {
  private JPanel main;
  private ObjectTable<PriceList> shelfPriceLists;
  private ObjectTable<Article> shelfExtraArticles;
  private AccessCheckingField<Shelf, String> shelfLocation;
  private AccessCheckingField<Shelf, String> shelfComment;
  private AccessCheckingCollectionEditor<Shelf, Set<PriceList>, PriceList> editShelfPriceLists;
  private AccessCheckingCollectionEditor<Shelf, Set<Article>, Article> extraArticles;
  private AccessCheckingField<Shelf, Integer> shelfNo;
  private JLabel extraArticleLabel;
  @Getter private ObjectForm<Shelf> objectForm;

  private ObjectForm<Shelf> createObjectForm() {
    return new ObjectForm<>(
        shelfLocation,
        shelfNo,
        shelfComment,
        editShelfPriceLists,
        extraArticles,
        new DataListener<>(Shelf::getPriceLists, shelfPriceLists::setObjects),
        new DataListener<>(Shelf::getArticles, shelfExtraArticles::setObjects));
  }

  @Override
  public void initialize(ShelfController controller) {
    objectForm = createObjectForm();
    objectForm.setObjectDistinction("Das Regal");
    objectForm.registerUniqueCheck(shelfNo, controller::isShelfNoUniqe);
    objectForm.registerUniqueCheck(shelfLocation, controller::isLocationUniqe);
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  private void refreshPriceListTable() {
    shelfPriceLists.setObjects(editShelfPriceLists.getData());
  }

  public void refreshExtraArticleTable() {
    shelfExtraArticles.setObjects(extraArticles.getData());
  }

  private void createUIComponents() {
    shelfPriceLists = new ObjectTable<>(Columns.create("Name", PriceList::getName));
    editShelfPriceLists =
        new AccessCheckingCollectionEditor<>(
                Shelf::getPriceLists,
                PriceList.onlyWithContent(),
                Columns.create("Name", PriceList::getName))
            .withCloseEvent(this::refreshPriceListTable)
            .withSearchbox(CollectionView.AVAILABLE);
    shelfExtraArticles =
        new ObjectTable<>(
            Columns.create("Artikelname", Article::getName),
            Columns.create("Artikelnummer", Article::getKbNumber).withSorter(Column.NUMBER_SORTER),
            Columns.create("Artikelpreisliste", Article::getPriceList));
    extraArticles =
        new AccessCheckingCollectionEditor<>(
                Shelf::getArticles,
                ShelfController.getAllArticleSource(),
                Columns.create("Artikelname", Article::getName),
                Columns.create("Artikelnummer", Article::getKbNumber)
                    .withSorter(Column.NUMBER_SORTER),
                Columns.create("Artikelpreisliste", Article::getPriceList))
            .withCloseEvent(this::refreshExtraArticleTable)
            .withSearchbox(CollectionView.AVAILABLE);
    shelfComment =
        new AccessCheckingField<>(Shelf::getComment, Shelf::setComment, AccessCheckingField.NONE);
    shelfLocation =
        new AccessCheckingField<>(Shelf::getLocation, Shelf::setLocation, AccessCheckingField.NONE);
    shelfNo =
        new AccessCheckingField<>(
            Shelf::getShelfNo, Shelf::setShelfNo, AccessCheckingField.UNSIGNED_INT_FORMER);
    extraArticleLabel = new JLabel("Extra Artikel");
    extraArticleLabel.setIcon(Icons.barcodeIcon);
  }

  // @spotless:off

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /** Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        main = new JPanel();
        main.setLayout(new GridLayoutManager(8, 6, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Beschreibung");
        main.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        main.add(spacer1, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        main.add(spacer2, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Regalkommentar");
        main.add(label2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Preislisten");
        main.add(label3, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        main.add(scrollPane1, new GridConstraints(5, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane1.setViewportView(shelfPriceLists);
        main.add(shelfLocation, new GridConstraints(1, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        main.add(shelfComment, new GridConstraints(3, 1, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        editShelfPriceLists.setText("Regalpreislisten bearbeiten");
        main.add(editShelfPriceLists, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        main.add(scrollPane2, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        scrollPane2.setViewportView(shelfExtraArticles);
        extraArticleLabel.setText("Extra Artikel");
        main.add(extraArticleLabel, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        extraArticles.setText("Extra Artikel bearbeiten");
        main.add(extraArticles, new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        main.add(shelfNo, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Regal-Nr.");
        main.add(label4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /** @noinspection ALL */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }

    // @spotless:on
}

package kernbeisser.Windows.EditArticles;

import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;

import java.awt.event.KeyEvent;
import javax.persistence.NoResultException;
import kernbeisser.CustomComponents.BarcodeCapture;
import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.ObjectTable.Columns.Columns;
import kernbeisser.CustomComponents.ObjectTable.Columns.CustomizableColumn;
import kernbeisser.CustomComponents.ObjectTree.ObjectTree;
import kernbeisser.CustomComponents.SearchBox.Filters.ArticleFilter;
import kernbeisser.DBEntities.*;
import kernbeisser.Enums.Mode;
import kernbeisser.Enums.PermissionKey;
import kernbeisser.Forms.FormImplemetations.Article.ArticleController;
import kernbeisser.Forms.ObjectView.ObjectViewController;
import kernbeisser.Forms.ObjectView.ObjectViewView;
import kernbeisser.Security.Key;
import kernbeisser.Useful.Date;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.MVC.ComponentController.ComponentController;
import kernbeisser.Windows.MVC.Controller;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.PrintLabels.PrintLabelsController;
import kernbeisser.Windows.ViewContainers.SubWindow;
import lombok.var;
import org.jetbrains.annotations.NotNull;

public class EditArticlesController extends Controller<EditArticlesView, EditArticlesModel> {

  private final ObjectViewController<Article> objectViewController;

  private final BarcodeCapture capture;

  private final ArticleFilter articleFilter = new ArticleFilter(this::refreshList);

  private String formatArticleSurcharge(Article article) {
    return article.getSurchargeGroup().getName()
        + " ("
        + Math.round(article.getSurchargeGroup().getSurcharge() * 100)
        + "%)";
  }

  @Key(PermissionKey.ACTION_OPEN_EDIT_ARTICLES)
  public EditArticlesController() {
    super(new EditArticlesModel());
    var lastDeliveries = Articles.getLastDeliveries();
    objectViewController =
        new ObjectViewController<>(
            "Artikel bearbeiten",
            new ArticleController(),
            articleFilter::searchable,
            true,
            new CustomizableColumn<>("Name", Article::getName)
                .withDefaultFilter()
                .withColumnAdjustor(column -> column.setPreferredWidth(350))
                .withHorizontalAlignment(LEFT),
            new CustomizableColumn<Article>(
                    "Packungsgröße", e -> e.getAmount() + e.getMetricUnits().getShortName())
                .withHorizontalAlignment(RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            Columns.create("Ladennummer", Article::getKbNumber, RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            Columns.create("Lieferant", Article::getSupplier, LEFT)
                .withDefaultFilter()
                .withColumnAdjustor(e -> e.setPreferredWidth(150)),
            Columns.create("Hersteller", Article::getProducer, LEFT)
                .withDefaultFilter()
                .withColumnAdjustor(e -> e.setPreferredWidth(100)),
            Columns.create("Lieferantennummer", Article::getSuppliersItemNumber, RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            new CustomizableColumn<Article>("Auswiegware", e -> e.isWeighable() ? "Ja" : "Nein")
                .withDefaultFilter(),
            new CustomizableColumn<Article>(
                    "Nettopreis", e -> String.format("%.2f€", e.getNetPrice()))
                .withHorizontalAlignment(RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            new CustomizableColumn<Article>(
                    "Verkaufspreis",
                    e -> String.format("%.2f€", Articles.calculateArticleRetailPrice(e, 0, false)))
                .withHorizontalAlignment(RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            Columns.create("Einzelpfand", e -> String.format("%.2f€", e.getSingleDeposit()), RIGHT),
            new CustomizableColumn<Article>("MwSt.", e -> e.getVat().getName())
                .withHorizontalAlignment(RIGHT)
                .withDefaultFilter(),
            new CustomizableColumn<Article>(
                    "Gebindegröße", e -> String.format("%.3f", e.getContainerSize()))
                .withHorizontalAlignment(RIGHT)
                .withSorter(Column.NUMBER_SORTER),
            Columns.create("Preisliste", Article::getPriceList, LEFT)
                .withColumnAdjustor(e -> e.setPreferredWidth(200))
                .withDefaultFilter(),
            Columns.<Article>create(
                    "Zuschlaggruppe", e -> e.getSurchargeGroup().getNameWithSurcharge(), LEFT)
                .withDefaultFilter(),
            Columns.create("Barcode", Article::getBarcode, RIGHT),
            Columns.<Article>create(
                    "Letzte Lief.",
                    a ->
                        Date.safeDateFormat(lastDeliveries.get(a.getKbNumber()), Date.INSTANT_DATE))
                .withSorter(Column.DATE_SORTER(Date.INSTANT_DATE)));
    this.capture =
        new BarcodeCapture(
            e ->
                objectViewController.openForm(
                    Articles.getByBarcode(Long.parseLong(e)).orElseThrow(NoResultException::new),
                    Mode.EDIT));
    objectViewController.addComponents(articleFilter.createFilterCheckboxes());
    objectViewController.setForceExtraButtonState(false);
  }

  void refreshList() {
    objectViewController.search();
  }

  @Override
  protected boolean processKeyboardInput(KeyEvent e) {
    return capture.processKeyEvent(e);
  }

  @NotNull
  @Override
  public EditArticlesModel getModel() {
    return model;
  }

  @Override
  public void fillView(EditArticlesView editArticlesView) {
    objectViewController.setSearch("");
    if (Tools.canInvoke(PrintLabelsController::new)) {
      objectViewController.addButton(
          PrintLabelsController.getLaunchButton(getView().traceViewContainer()));
    }
    refreshList();
  }

  public ObjectViewView<Article> getObjectView() {
    return objectViewController.getView();
  }

  void openPriceListSelection() {
    var view = getView();
    ObjectTree<PriceList> priceListObjectTree = new ObjectTree<>(PriceList.getPriceListsAsNode());
    priceListObjectTree.addSelectionListener(
        e -> {
          objectViewController.setSearch(e.toString());
          objectViewController.search();
          IView.traceViewContainer(priceListObjectTree.getParent()).requestClose();
        });
    new ComponentController(priceListObjectTree, "Preisliste auswählen:")
        .openIn(new SubWindow(view.traceViewContainer()));
  }
}
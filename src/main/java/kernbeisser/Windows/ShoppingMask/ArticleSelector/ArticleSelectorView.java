package kernbeisser.Windows.ShoppingMask.ArticleSelector;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import kernbeisser.CustomComponents.ObjectTable.RowFilter;
import kernbeisser.CustomComponents.SearchBox.SearchBoxController;
import kernbeisser.CustomComponents.SearchBox.SearchBoxView;
import kernbeisser.DBEntities.Article;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.MVC.Linked;
import org.jetbrains.annotations.NotNull;

public class ArticleSelectorView implements IView<ArticleSelectorController> {

  private JPanel main;
  private JButton chooseButton;
  private SearchBoxView<Article> searchBox;

  @Linked private ArticleSelectorController controller;

  @Linked private SearchBoxController<Article> searchBoxController;

  private void createUIComponents() {
    searchBox = searchBoxController.getView();
  }

  @Override
  public void initialize(ArticleSelectorController controller) {
    chooseButton.addActionListener(e -> controller.choose());
  }

  @Override
  public @NotNull Dimension getSize() {
    return new Dimension(700, 600);
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  @Override
  public Component getFocusOnInitialize() {
    return searchBoxController.getView().getFocusOnInitialize();
  }

  public void setRowFilter(RowFilter<Article> articleRowFilter) {
    searchBox.setRowFilter(articleRowFilter);
  }

  {
    // GUI initializer generated by IntelliJ IDEA GUI Designer
    // >>> IMPORTANT!! <<<
    // DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR
   * call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    createUIComponents();
    main = new JPanel();
    main.setLayout(new GridLayoutManager(4, 1, new Insets(5, 5, 5, 5), -1, -1));
    main.add(
        searchBox.$$$getRootComponent$$$(),
        new GridConstraints(
            2,
            0,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            null,
            null,
            null,
            0,
            false));
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
    main.add(
        panel1,
        new GridConstraints(
            3,
            0,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null,
            null,
            null,
            0,
            false));
    chooseButton = new JButton();
    chooseButton.setText("Auswählen");
    panel1.add(
        chooseButton,
        new GridConstraints(
            0,
            1,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            null,
            null,
            0,
            false));
    final Spacer spacer1 = new Spacer();
    panel1.add(
        spacer1,
        new GridConstraints(
            0,
            0,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW,
            1,
            null,
            null,
            new Dimension(-1, 50),
            0,
            false));
    final JLabel label1 = new JLabel();
    Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
    if (label1Font != null) label1.setFont(label1Font);
    label1.setText("Artikel auswählen");
    main.add(
        label1,
        new GridConstraints(
            0,
            0,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            null,
            new Dimension(-1, 50),
            0,
            false));
    final JLabel label2 = new JLabel();
    Font label2Font = this.$$$getFont$$$(null, Font.ITALIC, -1, label2.getFont());
    if (label2Font != null) label2.setFont(label2Font);
    label2.setText(
        "<html>Sucht nach Namensbestandteil, vollständiger Artikelnummer (KB und Lieferant) sowie nach den letzten Stellen des Barcodes (beliebig lang)</html>");
    label2.setToolTipText(
        "Sucht nach Namensbestandteil, vollständiger Artikelnummer (KB und Lieferant) sowie nach den letzten Stellen des Barcodes (beliebig lang)");
    main.add(
        label2,
        new GridConstraints(
            1,
            0,
            1,
            1,
            GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            1,
            null,
            null,
            null,
            0,
            false));
  }

  /** @noinspection ALL */
  private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
    if (currentFont == null) return null;
    String resultName;
    if (fontName == null) {
      resultName = currentFont.getName();
    } else {
      Font testFont = new Font(fontName, Font.PLAIN, 10);
      if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
        resultName = fontName;
      } else {
        resultName = currentFont.getName();
      }
    }
    Font font =
        new Font(
            resultName,
            style >= 0 ? style : currentFont.getStyle(),
            size >= 0 ? size : currentFont.getSize());
    boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
    Font fontWithFallback =
        isMac
            ? new Font(font.getFamily(), font.getStyle(), font.getSize())
            : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
    return fontWithFallback instanceof FontUIResource
        ? fontWithFallback
        : new FontUIResource(fontWithFallback);
  }

  /** @noinspection ALL */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }
}

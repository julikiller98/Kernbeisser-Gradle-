package kernbeisser.Windows.PrintLabels;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.*;
import kernbeisser.DBEntities.Article;
import kernbeisser.Windows.CollectionView.CollectionController;
import kernbeisser.Windows.CollectionView.CollectionView;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.MVC.Linked;
import org.jetbrains.annotations.NotNull;

public class PrintLabelsView implements IView<PrintLabelsController> {

  private JPanel main;
  private CollectionView collectionView;
  private JButton printSheetInfo;

  @Linked
  private CollectionController<Article> articles;

  @Override
  public void initialize(PrintLabelsController controller) {
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  private void createUIComponents() {
    collectionView = articles.getView();
  }

  public boolean confirmChanges() {
    return JOptionPane.showConfirmDialog(
        getContent(),
        "Soll ich mir die ausgewählten Etiketten für den Ausdruck merken?",
        "Später drucken",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE)
        == JOptionPane.YES_OPTION;
  }

  @Override
  public String getTitle() {
    return "Etiketten Zusammenstellen";
  }

  public void refreshView() {
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
    main.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    main.setMaximumSize(new Dimension(-1, -1));
    main.setRequestFocusEnabled(true);
    main.add(collectionView.$$$getRootComponent$$$(),
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null,
            null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }
}

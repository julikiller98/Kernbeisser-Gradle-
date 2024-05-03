package kernbeisser.Forms.FormEditor;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import javax.swing.*;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import kernbeisser.Enums.Mode;
import kernbeisser.Useful.ActuallyCloneable;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.MVC.IView;
import org.jetbrains.annotations.NotNull;

public class FormEditorView<V extends ActuallyCloneable> implements IView<FormEditorController<V>> {

  private JButton saveButton;
  private JPanel contentPage;
  private JPanel main;
  private JButton cancel;
  private FormEditorController<V> controller;

  public JPanel getContentPage() {
    return contentPage;
  }

  @Override
  public void initialize(FormEditorController<V> controller) {
    this.controller = controller;
    saveButton.addActionListener(actionEvent -> controller.submit());
    cancel.addActionListener(e -> this.back());
  }

  void setMode(Mode mode) {
    switch (mode) {
      case EDIT:
        saveButton.setText("Änderungen speichern");
        saveButton.setIcon(
            IconFontSwing.buildIcon(
                FontAwesome.PENCIL, Tools.scaleWithLabelScalingFactor(15), new Color(0x04A0E8)));
        saveButton.setForeground(new Color(0x04A0E8));
        break;
      case ADD:
        saveButton.setText("Neu Aufnehmen");
        saveButton.setIcon(
            IconFontSwing.buildIcon(
                FontAwesome.CHECK, Tools.scaleWithLabelScalingFactor(15), new Color(0x04E858)));
        saveButton.setForeground(new Color(0x04E858));
        break;
    }
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  @Override
  public @NotNull Dimension getSize() {
    return Tools.floatingSubwindowSize(controller);
  }

  @Override
  public String getTitle() {
    return controller.getModel().getForm().getView().getTitle();
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
    main = new JPanel();
    main.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 5), -1, -1));
    main.setMaximumSize(new Dimension(-1, -1));
    main.setMinimumSize(new Dimension(-1, -1));
    main.setPreferredSize(new Dimension(-1, -1));
    final JScrollPane scrollPane1 = new JScrollPane();
    main.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    contentPage = new JPanel();
    contentPage.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    scrollPane1.setViewportView(contentPage);
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
    main.add(panel1, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    saveButton = new JButton();
    saveButton.setText("Speichern");
    panel1.add(saveButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer1 = new Spacer();
    panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    cancel = new JButton();
    cancel.setText("Abbrechen");
    panel1.add(cancel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer2 = new Spacer();
    main.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
  }

  /** @noinspection ALL */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }

  // @spotless:on
}

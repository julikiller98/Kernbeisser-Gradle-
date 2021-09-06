package kernbeisser.Windows.EditUserSetting;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import javax.swing.*;
import kernbeisser.Enums.Theme;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.MVC.Linked;
import org.jetbrains.annotations.NotNull;

public class EditUserSettingView implements IView<EditUserSettingController> {

  private JButton commit;
  private JComboBox<Theme> themes;
  private JSlider fontSize;
  private JPanel main;
  private JLabel exampleText;
  private JCheckBox openMultipleShoppingMasks;
  @Linked
  private EditUserSettingController controller;

  public void setThemes(Theme[] values) {
    themes.removeAllItems();
    for (Theme value : values) {
      themes.addItem(value);
    }
  }

  @Override
  public void initialize(EditUserSettingController controller) {
    fontSize.addChangeListener(e -> controller.fontChanged());
    commit.addActionListener(e -> controller.commit());
    themes.addActionListener(e -> controller.refreshTheme());
    openMultipleShoppingMasks.addActionListener(controller);
  }

  float getFontSize() {
    return fontSize.getValue() / 100.f;
  }

  void setExampleTextFont(Font font) {
    exampleText.setFont(font);
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  @Override
  public String getTitle() {
    return "Benutzerspezifische Einstellungen";
  }

  public Theme getTheme() {
    return themes.getItemAt(themes.getSelectedIndex());
  }

  public void setSelectedTheme(Theme enumValue) {
    themes.setSelectedItem(enumValue);
  }

  public void setFontSize(float v) {
    fontSize.setValue(Math.round(v * 100));
  }

  public boolean isAllowMultipleShoppingMasksSelected() {
    return openMultipleShoppingMasks.isSelected();
  }

  public void setAllowMultipleShoppingMasks(boolean b) {
    openMultipleShoppingMasks.setSelected(b);
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
    main = new JPanel();
    main.setLayout(new GridLayoutManager(7, 3, new Insets(10, 10, 10, 10), -1, -1));
    commit = new JButton();
    commit.setText("Fertig");
    main.add(commit, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_SOUTH,
        GridConstraints.FILL_HORIZONTAL,
        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer1 = new Spacer();
    main.add(spacer1, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null,
        0, false));
    final JLabel label1 = new JLabel();
    label1.setText("Theme");
    main.add(label1,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    themes = new JComboBox();
    main.add(themes, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final JLabel label2 = new JLabel();
    label2.setText("Schriftgröße");
    main.add(label2,
        new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    fontSize = new JSlider();
    fontSize.setEnabled(false);
    fontSize.setMaximum(150);
    fontSize.setMinimum(50);
    fontSize.setPaintLabels(false);
    fontSize.setValue(100);
    main.add(fontSize, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer2 = new Spacer();
    main.add(spacer2, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0,
        false));
    final Spacer spacer3 = new Spacer();
    main.add(spacer3, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null,
        0, false));
    exampleText = new JLabel();
    exampleText.setText("Beispieltext");
    main.add(exampleText,
        new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0,
            false));
    openMultipleShoppingMasks = new JCheckBox();
    openMultipleShoppingMasks.setActionCommand("allowMultipleShoppingMasks");
    openMultipleShoppingMasks.setText("Das öffnen von mehren Einkaufsmasken erlauben");
    main.add(openMultipleShoppingMasks,
        new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }
}

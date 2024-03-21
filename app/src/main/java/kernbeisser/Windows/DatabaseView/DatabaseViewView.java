package kernbeisser.Windows.DatabaseView;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import java.awt.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import kernbeisser.CustomComponents.ComboBox.AdvancedComboBox;
import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.ObjectTable.ObjectTable;
import kernbeisser.Windows.MVC.IView;
import org.jetbrains.annotations.NotNull;

public class DatabaseViewView implements IView<DatabaseViewController> {
  private JPanel main;
  private AdvancedComboBox<Class<?>> entitySelection;
  private ObjectTable<Object> entityTable;
  private JButton exportToCsv;
  private JTextField filter;

  @Override
  public void initialize(DatabaseViewController controller) {
    exportToCsv.addActionListener(
        (actionEvent) -> {
          controller.exportToCsv(entityTable);
        });
    entitySelection.addSelectionListener(
        (clazz) -> {
          controller.selectClass(clazz);
        });
    filter.addActionListener(
        (actionEvent) -> {
          entitySelection.getSelected().ifPresent(controller::selectClass);
        });
  }

  String getFilter() {
    return filter.getText();
  }

  void setSelectionEntities(List<Class<?>> classes) {
    entitySelection.setItems(classes);
  }

  void setColumns(List<Column<Object>> columns) {
    entityTable.setColumns(columns);
  }

  @Override
  public @NotNull JComponent getContent() {
    return main;
  }

  private void createUIComponents() {
    entityTable = new ObjectTable<Object>();
    entitySelection = new AdvancedComboBox<>(Class::getSimpleName);
  }

  public void messageCouldNotSaveCSV(IOException e) {
    message(
        "Die CSV-Datei konnte nicht exportiert werden!\nFehler: " + e.getMessage(),
        "Fehler beim Exportieren der CSV-Datei");
  }

  public boolean confirmOverrideOfFile(String name) {
    return confirmDialog(
        "Sind sie sich sicher das sie die Datei " + name + " überschreiben wollen?",
        "Datei existiert bereits!");
  }

  public void setEntities(Collection<Object> allOfClass) {
    entityTable.setObjects(allOfClass);
  }

  @Override
  public String getTitle() {
    return "Datenbank";
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
    main.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
    main.add(
        panel1,
        new GridConstraints(
            2,
            0,
            1,
            2,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null,
            null,
            null,
            0,
            false));
    final JScrollPane scrollPane1 = new JScrollPane();
    scrollPane1.setHorizontalScrollBarPolicy(32);
    panel1.add(
        scrollPane1,
        new GridConstraints(
            0,
            0,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            null,
            null,
            null,
            0,
            false));
    entityTable.setAutoResizeMode(0);
    scrollPane1.setViewportView(entityTable);
    exportToCsv = new JButton();
    exportToCsv.setText("Als CSV-Datei exportieren");
    panel1.add(
        exportToCsv,
        new GridConstraints(
            1,
            0,
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
    main.add(
        entitySelection,
        new GridConstraints(
            1,
            0,
            1,
            1,
            GridConstraints.ANCHOR_NORTH,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            null,
            null,
            0,
            false));
    final Spacer spacer1 = new Spacer();
    main.add(
        spacer1,
        new GridConstraints(
            2,
            2,
            1,
            1,
            GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_VERTICAL,
            1,
            GridConstraints.SIZEPOLICY_WANT_GROW,
            null,
            null,
            null,
            0,
            false));
    filter = new JTextField();
    main.add(
        filter,
        new GridConstraints(
            1,
            1,
            1,
            1,
            GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            new Dimension(150, -1),
            null,
            0,
            false));
    final JLabel label1 = new JLabel();
    label1.setText("Filter");
    main.add(
        label1,
        new GridConstraints(
            0,
            1,
            1,
            1,
            GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            null,
            null,
            0,
            false));
    final JLabel label2 = new JLabel();
    label2.setText("Datenbank Objekt");
    main.add(
        label2,
        new GridConstraints(
            0,
            0,
            1,
            1,
            GridConstraints.ANCHOR_WEST,
            GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_FIXED,
            GridConstraints.SIZEPOLICY_FIXED,
            null,
            null,
            null,
            0,
            false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return main;
  }
}

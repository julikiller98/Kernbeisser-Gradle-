package kernbeisser.Forms.FormEditor;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import kernbeisser.Enums.Mode;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.MVC.IView;
import kernbeisser.Windows.ViewContainers.SubWindow;
import org.jetbrains.annotations.NotNull;

public class FormEditorView<V> implements IView<FormEditorController<V>> {

  private JButton saveButton;
  private JPanel contentPage;
  private JPanel main;
  private JButton cancel;
  private FormEditorController controller;

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
        saveButton.setText("Bearbeitung abschließen");
        saveButton.setIcon(
            IconFontSwing.buildIcon(
                FontAwesome.PENCIL, Tools.scaleWithLabelScalingFactor(15), new Color(0x04A0E8)));
        saveButton.setForeground(new Color(0x04A0E8));
        break;
      case ADD:
        saveButton.setText("Speichern");
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
    SubWindow parent = (SubWindow) controller.getContainer();
    Dimension maxSize = parent.getParent().getSize();
    return new Dimension((int) (maxSize.width * .8), (int) (maxSize.height * .8));
  }
}

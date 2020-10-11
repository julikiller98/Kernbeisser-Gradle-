package kernbeisser.CustomComponents.AccessChecking;

import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.*;
import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.Exeptions.CannotParseException;
import kernbeisser.Exeptions.PermissionKeyRequiredException;
import kernbeisser.Useful.Tools;
import kernbeisser.Windows.CollectionView.CollectionController;
import kernbeisser.Windows.Window;
import kernbeisser.Windows.WindowImpl.SubWindow;

public class AccessCheckingCollectionEditor<P, C extends Collection<V>, V> extends JButton
    implements Bounded<P, C> {
  private final Getter<P, C> getter;
  private final Setter<P, C> setter;
  private boolean changed = false;

  private boolean editable;

  private C data;

  private final Column<V>[] columns;

  private final Collection<V> values;

  public AccessCheckingCollectionEditor(
      Getter<P, C> getter, Setter<P, C> setter, Collection<V> values, Column<V>... columns) {
    this.values = values;
    this.getter = getter;
    this.setter = setter;
    this.columns = columns;
    addActionListener(this::trigger);
  }

  void trigger(ActionEvent event) {
    new CollectionController<V>(data, values, editable, columns)
        .openAsWindow((Window) SwingUtilities.getWindowAncestor(this), SubWindow::new);
  }

  @Override
  public void inputChanged() {
    changed = true;
  }

  @Override
  public boolean isInputChanged() {
    return changed;
  }

  @Override
  public void setObjectData(P data) {
    try {
      this.data = getter.get(data);
    } catch (PermissionKeyRequiredException e) {
      editable = false;
    }
  }

  @Override
  public void writeInto(P p) throws CannotParseException {
    try {
      setter.set(p, data);
    } catch (PermissionKeyRequiredException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void markWrongInput() {
    Tools.showUnexpectedErrorWarning(new Exception("Unknown error happened"));
  }

  @Override
  public Getter<P, C> getGetter() {
    return getter;
  }

  @Override
  public Setter<P, C> getSetter() {
    return setter;
  }

  @Override
  public void setReadable(boolean b) {
    setEnabled(b);
  }

  @Override
  public void setWriteable(boolean b) {
    editable = b;
  }

  @Override
  public boolean validInput() {
    return true;
  }
}

package kernbeisser.Windows.Selector;

import kernbeisser.CustomComponents.ObjectTable.Column;
import kernbeisser.CustomComponents.SearchBox.SearchBoxController;
import kernbeisser.Enums.Key;
import kernbeisser.Windows.Controller;
import kernbeisser.Windows.Searchable;
import kernbeisser.Windows.WindowImpl.SubWindow;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class SelectorController <T> implements Controller<SelectorView<T>,SelectorModel<T>> {
    private final SelectorModel<T> model;
    private final SelectorView<T> view;

    public SelectorController(String title, Collection<T> currentValues, Searchable<T> searchable, Column<T> ... columns) {
        this.view = new SelectorView<T>(this);
        this.model = new SelectorModel<T>(currentValues,title,searchable,columns);
    }


    @Override
    public @NotNull SelectorView<T> getView() {
        return view;
    }

    @Override
    public @NotNull SelectorModel<T> getModel() {
        return model;
    }

    @Override
    public void fillUI() {
        view.setObjects(model.getCurrentValues());
        view.setColumns(model.getColumns());
        view.setTitle(model.getTitle());
    }

    @Override
    public Key[] getRequiredKeys() {
        return new Key[0];
    }


    public void remove() {
        model.getCurrentValues().remove(view.getSelectedValue());
        view.removeValue(view.getSelectedValue());
    }

    public void add() {
        SearchBoxController<T> controller = new SearchBoxController<T>(model.getSearchable(), model.getColumns());
        controller.addDoubleClickListener(view::addValue);
        controller.addSelectionListener(view::addValue);
        controller.openAsWindow(view.getWindow(), SubWindow::new);
    }
}

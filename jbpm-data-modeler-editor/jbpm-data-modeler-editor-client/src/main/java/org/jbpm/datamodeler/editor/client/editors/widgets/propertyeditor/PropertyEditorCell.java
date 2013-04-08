package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;

import com.google.gwt.cell.client.AbstractEditableCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;

import java.util.List;
import java.util.Set;


public class PropertyEditorCell extends AbstractEditableCell<PropertyEditorValue, PropertyEditorValue> implements PropertyEditorListener {

    PropertyEditorConfig config = new PropertyEditorConfig();

    CellTable cellTable;

    public PropertyEditorCell(CellTable cellTable, PropertyEditorConfig config) {
        this.cellTable = cellTable;
        this.config = config;
    }

    @Override
    public Set<String> getConsumedEvents() {
        return config.getConsumedEvents();
    }

    @Override
    public boolean isEditing(Context context, Element parent, PropertyEditorValue value) {

        Cell cell = config.getBestSuitedCell(value);
        if (cell != null) {
            return cell.isEditing(context, parent,  value.getValue());
        }
        return false;
    }

    @Override
    public void render(Context context, PropertyEditorValue value, SafeHtmlBuilder sb) {

        Cell cell = config.getBestSuitedCell(value);
        if (cell != null) {
            cell.render(context, value.getValue(), sb);
        }
    }

    @Override
    public void onBrowserEvent(Context context, Element parent, PropertyEditorValue value, NativeEvent event, ValueUpdater<PropertyEditorValue> propertyEditorValueValueUpdater) {

        Cell cell = config.getBestSuitedCell(value);
        if (cell != null /*&& acceptsEvent(cell, event)*/) {
            PropertyEditorValueUpdater updater = new PropertyEditorValueUpdater(value, this);
            cell.onBrowserEvent(context, parent, value.getValue(), event, updater);
            if (value.needsRedraw) {
                cellTable.redrawRow(context.getIndex());
                value.needsRedraw = false;
            }
        }
    }

    @Override
    public boolean resetFocus(Context context, Element parent, PropertyEditorValue value) {

        Cell cell = config.getBestSuitedCell(value);
        if (cell != null) {
            return cell.resetFocus(context, parent, value.getValue());
        }
        return false;
    }

    @Override
    public void setValue(Context context, Element parent, PropertyEditorValue value) {

        Cell cell = config.getBestSuitedCell(value);
        if (cell != null) {
           cell.setValue(context, parent, value.getValue());
        }
    }

    @Override
    public boolean doBeforePropertyChange(PropertyEditor source, String propertyName, Object pendingValue, Object currentValue, List<PropertyChangeError> errors) {
        if (config.getPropertyEditorListener() != null) {
            return config.getPropertyEditorListener().doBeforePropertyChange(source, propertyName, pendingValue, currentValue, errors);
        }
        return true;
    }

    @Override
    public void onPropertyChange(PropertyEditor source, String propertyName, Object newValue, Object currentValue) {
        if (config.getPropertyEditorListener() != null) {
            config.getPropertyEditorListener().onPropertyChange(source, propertyName, newValue, currentValue);
        }
    }

    private boolean acceptsEvent(Cell cell, NativeEvent event) {
        Set<String> consumedEvents = cell != null ? cell.getConsumedEvents() : null;
        if (consumedEvents != null && event != null) {
            return consumedEvents.contains(event.getType());
        }
        return false;
    }
}
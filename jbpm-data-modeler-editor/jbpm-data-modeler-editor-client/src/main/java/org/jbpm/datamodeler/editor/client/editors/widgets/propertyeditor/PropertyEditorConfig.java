package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;

import com.google.gwt.cell.client.*;

import java.util.*;

public class PropertyEditorConfig {

    DatePickerCell dateCell = new DatePickerCell();

    TextInputCell textCell = new TextInputCell();

    CheckboxCell booleanCell = new CheckboxCell();

    Set<String> consumedEvents = new HashSet<String>();

    Map<Class, Cell> typeCellMap = new HashMap<Class, Cell>();

    Map<String, Cell> nameCellMap = new HashMap<String, Cell>();
    
    PropertyEditorListener propertyEditorListener;

    public PropertyEditorConfig() {
        //default configuration
        setCell(String.class, textCell);
        setCell(Date.class, dateCell);
        setCell(Boolean.class, booleanCell);
    }

    public void setCell(String propertyName, Cell cell) {
        nameCellMap.put(propertyName, cell);
        consumedEvents.addAll(cell.getConsumedEvents());
    }

    public void setCell(Class type, Cell cell) {
        typeCellMap.put(type, cell);
        consumedEvents.addAll(cell.getConsumedEvents());
    }

    public Set<String> getConsumedEvents() {
        return consumedEvents;
    }

    public Cell getBestSuitedCell(PropertyEditorValue value) {
        Cell cell = null;
        if (value != null && value.getName() != null) {
            cell = nameCellMap.get(value.getName());
            if (cell == null) {
                //do an extra try by type
                cell = typeCellMap.get(value.getValue().getClass());
            }
        }

        if (cell != null) {
            return cell;
        } else {
            //default cell
            return new TextCell();
        }
    }

    public PropertyEditorListener getPropertyEditorListener() {
        return propertyEditorListener;
    }

    public void setPropertyEditorListener(PropertyEditorListener propertyEditorListener) {
        this.propertyEditorListener = propertyEditorListener;
    }
}
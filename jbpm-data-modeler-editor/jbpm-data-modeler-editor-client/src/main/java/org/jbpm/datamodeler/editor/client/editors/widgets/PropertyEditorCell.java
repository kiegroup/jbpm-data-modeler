package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.google.gwt.cell.client.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import java.util.*;


public class PropertyEditorCell extends AbstractEditableCell<PropertyEditorValue, PropertyEditorValue> {

    DatePickerCell dateCell = new DatePickerCell();

    TextInputCell textCell = new TextInputCell();

    CheckboxCell booleanCell = new CheckboxCell();

    Set<String> consumedEvents = new HashSet<String>();

    public PropertyEditorCell() {
        consumedEvents.addAll(dateCell.getConsumedEvents());
        consumedEvents.addAll(textCell.getConsumedEvents());
        consumedEvents.addAll(booleanCell.getConsumedEvents());
    }

    @Override
    public Set<String> getConsumedEvents() {
        return consumedEvents;
    }


    @Override
    public boolean isEditing(Context context, Element parent, PropertyEditorValue value) {

        if (value.isString()) {
            textCell.isEditing(context, parent, (String) value.getValue());
        } else if (value.isDate()) {
            dateCell.isEditing(context, parent, (Date) value.getValue());
        } else if (value.isBoolean()) {
            booleanCell.isEditing(context, parent, (Boolean) value.getValue());
        }
        return false;
    }

    @Override
    public void render(Context context, PropertyEditorValue value, SafeHtmlBuilder sb) {
        if (value.isString()) {
            textCell.render(context, (String)value.getValue(), sb);
        } else if (value.isDate()) {
            dateCell.render(context, (Date)value.getValue(), sb);
        } else if (value.isBoolean()) {
            booleanCell.render(context, (Boolean)value.getValue(), sb);
        }
    }


    @Override
    public void onBrowserEvent(Context context, Element parent, PropertyEditorValue value, NativeEvent event, ValueUpdater<PropertyEditorValue> propertyEditorValueValueUpdater) {
        if (value.isString()) {
            //TODO add extra filter to know if this cell wants to listen the current event
            textCell.onBrowserEvent(context, parent, (String) value.getValue(), event, new StringValueUpdater(value));
        } else if (value.isDate()) {
            dateCell.onBrowserEvent(context, parent, (Date) value.getValue(), event, new DateValueUpdater(value));
        } else if (value.isBoolean()) {
            booleanCell.onBrowserEvent(context, parent, (Boolean) value.getValue(), event, new BooleanValueUpdater(value));
        }
    }

    @Override
    public boolean resetFocus(Context context, Element parent, PropertyEditorValue value) {
        if (value.isString()) {
            return textCell.resetFocus(context, parent, (String) value.getValue());
        } else if (value.isDate()) {
            return dateCell.resetFocus(context, parent, (Date) value.getValue());
        } else if (value.isBoolean()) {
            return booleanCell.resetFocus(context, parent, (Boolean) value.getValue());
        }
        return false;
    }

    @Override
    public void setValue(Context context, Element parent, PropertyEditorValue value) {

        if (value.isString()) {
            textCell.setValue(context, parent, (String) value.getValue());
        } else if (value.isDate()) {
            dateCell.setValue(context, parent, (Date) value.getValue());
        } else if (value.isBoolean()) {
            booleanCell.setValue(context, parent, (Boolean) value.getValue());
        }
    }
}
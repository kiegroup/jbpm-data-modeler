package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.google.gwt.cell.client.FieldUpdater;

public class PropertyEditorFieldUpdater implements FieldUpdater<PropertyEditorValue, PropertyEditorValue> {

    /**
     *
     * @param index
     *
     * @param object object to be updated
     *
     * @param value new value
     */
    @Override
    public void update(int index, PropertyEditorValue object, PropertyEditorValue value) {
        object.setValue(value.getValue());
    }

}

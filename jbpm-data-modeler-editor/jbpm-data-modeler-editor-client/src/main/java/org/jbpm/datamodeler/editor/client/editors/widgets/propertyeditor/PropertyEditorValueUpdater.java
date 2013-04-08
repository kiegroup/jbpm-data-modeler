package org.jbpm.datamodeler.editor.client.editors.widgets.propertyeditor;

import com.google.gwt.cell.client.ValueUpdater;

public class PropertyEditorValueUpdater implements ValueUpdater {

    PropertyEditorValue editorValue;

    PropertyEditorListener listener;

    public PropertyEditorValueUpdater(PropertyEditorValue editorValue, PropertyEditorListener listener) {
        this.editorValue = editorValue;
        this.listener = listener;
    }

    public PropertyEditorValueUpdater(PropertyEditorValue editorValue) {
        this.editorValue = editorValue;
    }

    public PropertyEditorValue getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(PropertyEditorValue editorValue) {
        this.editorValue = editorValue;
    }

    public PropertyEditorListener getListener() {
        return listener;
    }

    public void setListener(PropertyEditorListener listener) {
        this.listener = listener;
    }

    @Override
    public void update(Object value) {
        editorValue.setPendingValue(value);
        boolean canChange = true;
        if (listener != null) {
            canChange = listener.doBeforePropertyChange(null, editorValue.getName(), editorValue.getPendingValue(), editorValue.getValue(), editorValue.getErrors());
        }

        if (!canChange) {
            editorValue.setHasError(true);
            editorValue.setNeedsRedraw(true);
        } else {
            if (editorValue.isHasError()) {
                editorValue.setHasError(false);
                editorValue.setNeedsRedraw(true);
            }
            updateValue(value);
        }
        editorValue.setNeedsRedraw(true);
    }

    protected void updateValue(Object value) {
        editorValue.setOldValue(editorValue.getValue());
        editorValue.setValue(value);
        if (listener != null) {
            listener.onPropertyChange(null, editorValue.getName(), editorValue.getValue(), editorValue.getOldValue());
        }
    }
}

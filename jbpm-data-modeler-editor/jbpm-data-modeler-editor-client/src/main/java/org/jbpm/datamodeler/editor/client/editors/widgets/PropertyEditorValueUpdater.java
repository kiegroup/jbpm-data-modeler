package org.jbpm.datamodeler.editor.client.editors.widgets;

public class PropertyEditorValueUpdater {

    PropertyEditorValue editorValue;

    public PropertyEditorValueUpdater(PropertyEditorValue editorValue) {
        this.editorValue = editorValue;
    }

    public PropertyEditorValue getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(PropertyEditorValue editorValue) {
        this.editorValue = editorValue;
    }
    
    protected void updateValue(Object value) {
        editorValue.setValue(value);
    }

}

package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.google.gwt.cell.client.ValueUpdater;

public class BooleanValueUpdater extends PropertyEditorValueUpdater implements ValueUpdater<Boolean> {

    public BooleanValueUpdater(PropertyEditorValue editorValue) {
        super(editorValue);
    }

    @Override
    public void update(Boolean value) {
        super.updateValue(value);
    }
}

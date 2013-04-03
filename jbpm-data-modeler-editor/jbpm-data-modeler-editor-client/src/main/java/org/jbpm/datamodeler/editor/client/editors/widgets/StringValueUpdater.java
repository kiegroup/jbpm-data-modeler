package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.google.gwt.cell.client.ValueUpdater;

public class StringValueUpdater extends PropertyEditorValueUpdater implements ValueUpdater<String> {

    public StringValueUpdater(PropertyEditorValue editorValue) {
        super(editorValue);
    }

    @Override
    public void update(String value) {
        super.updateValue(value);
    }
}

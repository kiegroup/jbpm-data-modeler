package org.jbpm.datamodeler.editor.client.editors.widgets;

import com.google.gwt.cell.client.ValueUpdater;

import java.util.Date;

public class DateValueUpdater extends PropertyEditorValueUpdater implements ValueUpdater<Date> {

    public DateValueUpdater(PropertyEditorValue editorValue) {
        super(editorValue);
    }

    @Override
    public void update(Date value) {
        super.updateValue(value);
    }
}

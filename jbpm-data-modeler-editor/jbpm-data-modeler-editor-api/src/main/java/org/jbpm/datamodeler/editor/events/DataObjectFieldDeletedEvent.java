package org.jbpm.datamodeler.editor.events;

import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

public class DataObjectFieldDeletedEvent extends DataModelerEvent {

    public DataObjectFieldDeletedEvent() {
    }

    public DataObjectFieldDeletedEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, ObjectPropertyTO currentField) {
        super(source, currentModel, currentDataObject);
        setCurrentField(currentField);
    }
}

package org.jbpm.datamodeler.editor.events;


import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

public class DataObjectFieldCreatedEvent extends DataModelerEvent {

    public DataObjectFieldCreatedEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, ObjectPropertyTO currentField) {
        super(source, currentModel, currentDataObject);
        setCurrentField(currentField);
    }
}

package org.jbpm.datamodeler.editor.events;

import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

public class DataObjectDeletedEvent extends DataModelerEvent {

    public DataObjectDeletedEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject) {
        super(source, currentModel, currentDataObject);
    }
}

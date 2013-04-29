package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

@Portable
public class DataObjectCreatedEvent extends DataModelerEvent {

    public DataObjectCreatedEvent() {
    }

    public DataObjectCreatedEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject) {
        super(source, currentModel, currentDataObject);
    }
}

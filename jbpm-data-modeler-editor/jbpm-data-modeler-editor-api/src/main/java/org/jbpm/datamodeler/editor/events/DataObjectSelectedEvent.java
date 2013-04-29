package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

@Portable
public class DataObjectSelectedEvent extends DataModelerEvent {

    public DataObjectSelectedEvent() {
    }

    public DataObjectSelectedEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject) {
        super(source, currentModel, currentDataObject);
    }
}

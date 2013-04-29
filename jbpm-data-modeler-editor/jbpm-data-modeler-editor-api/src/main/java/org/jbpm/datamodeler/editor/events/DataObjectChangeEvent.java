package org.jbpm.datamodeler.editor.events;


import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

@Portable
public class DataObjectChangeEvent extends DataModelerPropertyChangeEvent {

    public DataObjectChangeEvent() {
    }

    public DataObjectChangeEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, String propertyName, Object oldValue, Object newValue) {
        super(source, currentModel, currentDataObject, propertyName, oldValue, newValue);
    }
}

package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;

@Portable
public class DataModelerPropertyChangeEvent extends DataModelerEvent {

    private String propertyName;

    private Object oldValue;

    private Object newValue;

    public DataModelerPropertyChangeEvent() {
    }

    public DataModelerPropertyChangeEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, String propertyName, Object oldValue, Object newValue) {
        super(source, currentModel, currentDataObject);
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}

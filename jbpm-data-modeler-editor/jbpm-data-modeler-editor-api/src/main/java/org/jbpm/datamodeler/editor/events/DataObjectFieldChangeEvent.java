package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

@Portable
public class DataObjectFieldChangeEvent extends DataModelerPropertyChangeEvent {

    public DataObjectFieldChangeEvent() {
    }

    public DataObjectFieldChangeEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, ObjectPropertyTO currentField, String propertyName, Object oldValue, Object newValue) {
        super(source, currentModel, currentDataObject, propertyName, oldValue, newValue);
        setCurrentField(currentField);
    }
}

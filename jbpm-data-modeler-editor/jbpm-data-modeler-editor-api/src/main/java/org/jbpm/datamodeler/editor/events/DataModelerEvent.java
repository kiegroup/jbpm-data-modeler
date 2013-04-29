package org.jbpm.datamodeler.editor.events;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

@Portable
public class DataModelerEvent {

    protected DataModelTO currentModel;

    protected DataObjectTO currentDataObject;

    protected ObjectPropertyTO currentField;

    protected String source;
    
    public static final String DATA_MODEL_BROWSER = "DATA_MODEL_BROWSER";

    public static final String DATA_MODEL_BREAD_CRUMB = "DATA_MODEL_BREAD_CRUMB";

    public static final String DATA_OBJECT_BROWSER = "DATA_OBJECT_BROWSER";

    public static final String DATA_OBJECT_FIELD_EDITOR = "DATA_OBJECT_FIELD_EDITOR";

    public static final String DATA_OBJECT_EDITOR = "DATA_OBJECT_EDITOR";


    public DataModelerEvent() {
    }

    public DataModelerEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject) {
        this.source = source;
        this.currentModel = currentModel;
        this.currentDataObject = currentDataObject;
    }

    public DataModelerEvent(String source, DataModelTO currentModel, DataObjectTO currentDataObject, ObjectPropertyTO currentField) {
        this.source = source;
        this.currentModel = currentModel;
        this.currentDataObject = currentDataObject;
        this.currentField = currentField;
    }

    public DataModelTO getCurrentModel() {
        return currentModel;
    }

    public void setCurrentModel(DataModelTO currentModel) {
        this.currentModel = currentModel;
    }

    public DataObjectTO getCurrentDataObject() {
        return currentDataObject;
    }

    public void setCurrentDataObject(DataObjectTO currentDataObject) {
        this.currentDataObject = currentDataObject;
    }

    public ObjectPropertyTO getCurrentField() {
        return currentField;
    }

    public void setCurrentField(ObjectPropertyTO currentField) {
        this.currentField = currentField;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFrom(DataModelTO dataModel) {
        return dataModel != null && dataModel == getCurrentModel();
    }

    public boolean isFrom(String source) {
        if (source != null) {
            return source.equals(this.source);
        }
        return source == this.source;
    }
}

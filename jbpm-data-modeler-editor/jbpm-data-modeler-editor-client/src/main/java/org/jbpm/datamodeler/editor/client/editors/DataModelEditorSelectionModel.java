package org.jbpm.datamodeler.editor.client.editors;


import org.jbpm.datamodeler.editor.model.DataModelTO;
import org.jbpm.datamodeler.editor.model.DataObjectTO;
import org.jbpm.datamodeler.editor.model.ObjectPropertyTO;

public class DataModelEditorSelectionModel {
    
    DataModelTO selectedModel;
    
    DataObjectTO selectedObject;
    
    ObjectPropertyTO selectedProperty;

    public DataModelTO getSelectedModel() {
        return selectedModel;
    }

    public void setSelectedModel(DataModelTO selectedModel) {
        this.selectedModel = selectedModel;
    }

    public DataObjectTO getSelectedObject() {
        return selectedObject;
    }

    public void setSelectedObject(DataObjectTO selectedObject) {
        this.selectedObject = selectedObject;
    }

    public ObjectPropertyTO getSelectedProperty() {
        return selectedProperty;
    }

    public void setSelectedProperty(ObjectPropertyTO selectedProperty) {
        this.selectedProperty = selectedProperty;
    }
}

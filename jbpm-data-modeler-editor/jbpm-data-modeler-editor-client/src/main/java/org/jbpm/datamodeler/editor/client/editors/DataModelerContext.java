package org.jbpm.datamodeler.editor.client.editors;


import org.jbpm.datamodeler.editor.model.AnnotationDefinitionTO;
import org.jbpm.datamodeler.editor.model.DataModelTO;

import java.util.Map;

public class DataModelerContext {

    private DataModelTO dataModel;

    private DataModelHelper helper;

    Map<String, AnnotationDefinitionTO> annotationDefinitions;

    private boolean dirty = false;

    public DataModelerContext(DataModelTO dataModel, Map<String, AnnotationDefinitionTO> annotationDefinitions) {
        this(dataModel);
        this.annotationDefinitions = annotationDefinitions;
    }

    public DataModelerContext(DataModelTO dataModel) {
        this.dataModel = dataModel;
        helper = new DataModelHelper(dataModel);
    }

    public DataModelTO getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelTO dataModel) {
        this.dataModel = dataModel;
    }

    public DataModelHelper getHelper() {
        return helper;
    }

    public void setHelper(DataModelHelper helper) {
        this.helper = helper;
    }

    public Map<String, AnnotationDefinitionTO> getAnnotationDefinitions() {
        return annotationDefinitions;
    }

    public void setAnnotationDefinitions(Map<String, AnnotationDefinitionTO> annotationDefinitions) {
        this.annotationDefinitions = annotationDefinitions;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}

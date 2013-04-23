package org.jbpm.datamodeler.editor.client.validation;

import org.jbpm.datamodeler.editor.model.DataModelTO;

public interface DataObjectReferencingListener {
    void notifyDataObjectReferenced(String objectClassName, String subjectClassName);
    void notifyDataObjectUnReferenced(String objectClassName, String subjectClassName);
    void notifyDataObjectDeleted(String objectClassName);
    void notifyDataModelSelected(DataModelTO model);
}

package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.util.List;

@Portable
public class DataModelHelper {
    public void dataModelChanged() {}

    public void dataObjectReferenced(String objectClassName, String subjectClassName) {}

    public void dataObjectUnReferenced(String objectClassName, String subjectClassName) {}

    public void dataObjectDeleted(String objectClassName) {}

    public void dataObjectCreated(String objectClassName) {}

    public void dataObjectSelected(String objectClassName) {}

    public void dataObjectUnSelected(String objectClassName) {}

    public Boolean isDataObjectReferenced(String objectClassName) {return Boolean.FALSE;}

    public Boolean objectCanBeDeleted(String className) {return Boolean.FALSE;}

    public List<String> getExclusiveClassList() {return null;}
}

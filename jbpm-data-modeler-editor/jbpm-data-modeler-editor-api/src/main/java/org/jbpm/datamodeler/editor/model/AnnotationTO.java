package org.jbpm.datamodeler.editor.model;

import org.jboss.errai.common.client.api.annotations.Portable;

import java.util.HashMap;
import java.util.Map;

@Portable
public class AnnotationTO {

    private String className;

    private String name;

    private AnnotationDefinitionTO annotationDefinition;

    private Map<String, Object> values = new HashMap<String, Object>();

    public AnnotationTO() {
    }

    public AnnotationTO(AnnotationDefinitionTO annotationDefinition) {
        this.annotationDefinition = annotationDefinition;
        this.className = annotationDefinition.getClassName();
        this.name = annotationDefinition.getName();
    }

    public Object getValue(String annotationMemberName) {
        return values.get(annotationMemberName);
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValue(String annotationMemberName, Object value) {
        values.put(annotationMemberName,  value);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnnotationDefinitionTO getAnnotationDefinition() {
        return annotationDefinition;
    }

    public void setAnnotationDefinition(AnnotationDefinitionTO annotationDefinition) {
        this.annotationDefinition = annotationDefinition;
    }
}

package org.jbpm.datamodeler.editor.model;


import org.jboss.errai.common.client.api.annotations.Portable;

import java.util.ArrayList;
import java.util.List;

@Portable
public class AnnotationDefinitionTO {

    private String className;

    private String name;

    private boolean marker;

    private String shortDescription;
    
    private String description;

    private boolean objectAnnotation;

    private boolean propertyAnnotation;
    
    public static final String ROLE_ANNOTATION = "@Role";
    
    public static final String POSITION_ANNOTATON = "@Position";

    public static final String LABEL_ANNOTATION = "@Label";

    public static final String DESCRIPTION_ANNOTATION = "@Description";

    public static final String EQUALS_ANNOTATION = "@Equals";
    
    public static final String VALUE_PARAM = "value";

    private List<AnnotationMemberDefinitionTO> annotationMembers = new ArrayList<AnnotationMemberDefinitionTO>();

    public AnnotationDefinitionTO() {
    }

    public AnnotationDefinitionTO(String name, String className, String shortDescription, String description, boolean objectAnnotation, boolean propertyAnnotation) {
        this.name = name;
        this.className = className;
        this.shortDescription = shortDescription;
        this.description = description;
        this.objectAnnotation = objectAnnotation;
        this.propertyAnnotation = propertyAnnotation;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isMarker() {
        return annotationMembers == null || annotationMembers.size() == 0;
    }

    public void setMarker(boolean marker) {
        this.marker = marker;
    }

    public boolean getMarker() {
        return isMarker();
    }

    public List<AnnotationMemberDefinitionTO> getAnnotationMembers() {
        return annotationMembers;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isObjectAnnotation() {
        return objectAnnotation;
    }

    public void setObjectAnnotation(boolean objectAnnotation) {
        this.objectAnnotation = objectAnnotation;
    }

    public boolean isPropertyAnnotation() {
        return propertyAnnotation;
    }

    public void setPropertyAnnotation(boolean propertyAnnotation) {
        this.propertyAnnotation = propertyAnnotation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addMember(AnnotationMemberDefinitionTO memberDefinitionTO) {
        annotationMembers.add(memberDefinitionTO);
    }
}

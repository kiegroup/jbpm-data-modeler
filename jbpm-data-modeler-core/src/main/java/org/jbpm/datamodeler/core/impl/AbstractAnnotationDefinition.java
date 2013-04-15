package org.jbpm.datamodeler.core.impl;

import org.jbpm.datamodeler.core.AnnotationDefinition;
import org.jbpm.datamodeler.core.AnnotationMemberDefinition;

import java.util.ArrayList;
import java.util.List;


public class AbstractAnnotationDefinition implements AnnotationDefinition {
    
    protected String name;

    protected String shortDescription;

    protected String description;
    
    protected String className;

    protected List<AnnotationMemberDefinition> annotationMembers = new ArrayList<AnnotationMemberDefinition> ();

    protected AbstractAnnotationDefinition(String name, String className, String shortDescription, String description) {
        this.name = name;
        this.className = className;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<AnnotationMemberDefinition> getAnnotationMembers() {
        return annotationMembers;
    }

    protected void addMember(AnnotationMemberDefinition annotationMember) {
        annotationMembers.add(annotationMember);
    }

    @Override
    public boolean isMarker() {
        return annotationMembers != null && annotationMembers.size() > 0;
    }

    @Override
    public String getClassName() {
        return className;
    }
}

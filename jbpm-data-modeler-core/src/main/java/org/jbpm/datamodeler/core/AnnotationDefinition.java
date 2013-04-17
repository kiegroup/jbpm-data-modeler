package org.jbpm.datamodeler.core;

import java.util.List;

public interface AnnotationDefinition extends HasClassName {

    /**
     * Annotation unique identifier e.g. @DataObject, @Equals, @Entity, @Column
     *
     * @return
     */
    String getName();

    /**
     * A marker annotation has no members.
     *
     * @return true if the given annotation is a marker annotation, false in any other case.
     *
     */
    boolean isMarker();

    /**
     *
     * @return Annotation's short description.
     */
    String getShortDescription();

    /**
     * 
     * @return Annotation's long description.
     * 
     */
    String getDescription();


    /**
     * Set of supported parameters by this attribute.
     *
     * @return
     */
    List<AnnotationMemberDefinition> getAnnotationMembers();

    /**
     *
     * @return true if the annotation applies to objects, false in any other case.
     */
    boolean isObjectAnnotation();


    /**
     *
     * @return true if the annotation applies to properties, false in any other case.
     */
    boolean isPropertyAnnotation();


    /**
     *
     * @param name
     *
     * @return true if the annotation has a member with the given name, false in any other case.
     */
    boolean hasMember(String name);
       
}

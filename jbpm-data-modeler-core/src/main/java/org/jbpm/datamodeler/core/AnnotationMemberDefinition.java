package org.jbpm.datamodeler.core;

public interface AnnotationMemberDefinition extends HasClassName {

    /**
     * Annotation unique identifier e.g. name, size, quantity
     *
     * @return
     */
    String getName();

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


    Object defaultValue();


    boolean isArray();

}

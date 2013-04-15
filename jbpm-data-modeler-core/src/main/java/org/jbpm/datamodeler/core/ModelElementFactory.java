package org.jbpm.datamodeler.core;

/**
 * This interface is for internal use. Clients that wants to create a data model should
 * use the ModelFactory.
 *
 */
public interface ModelElementFactory {

    public DataObject newDataObject(String packageName, String name);

    public ObjectProperty newProperty(String name, String className, boolean multiple);

    public Annotation newAttribute(AnnotationDefinition annotationDefinition);
}

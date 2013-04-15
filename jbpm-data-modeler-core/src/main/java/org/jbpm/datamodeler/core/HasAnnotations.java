package org.jbpm.datamodeler.core;


import java.util.List;

public interface HasAnnotations {

    List<Annotation> getAnnotations();
    
    Annotation getAnnotation(String annotationName);

    void addAnnotation(Annotation annotation);
    
    Annotation removeAnnotation(String annotationName);

}

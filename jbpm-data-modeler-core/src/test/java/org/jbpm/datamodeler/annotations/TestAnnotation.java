package org.jbpm.datamodeler.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test annotation only for parser testing.
 *
 * For testing we are using java 1.5 annotations specification.
 *
 * Each method declaration defines an element of the annotation type. Method declarations must not have any parameters
 * or a throws clause.
 * Annotation methods return types are restricted to
 * primitives, String, Class, enums, annotations,
 * and arrays of the preceding types.
 * Methods can have default values.
 *
 */

@Target({
    //all types are welcome because it's a test annotation.
    ElementType.TYPE,
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.PARAMETER,
    ElementType.CONSTRUCTOR,
    ElementType.LOCAL_VARIABLE,
    ElementType.PACKAGE})

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {

    String name() default "";
    
    String[] children() default {"child1, child2, child3"};
    
    int size() default 0;

    boolean enabled() default false;

}

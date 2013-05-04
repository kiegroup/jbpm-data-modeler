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
public @interface TestTypesAnnotation {

    String stringValue() default "";
    
    byte byteValue() default 0;

    short shortValue() default 0;

    int intValue() default 0;

    long longValue() default 0;

    float floatValue() default 0;

    double doubleValue() default 0;

    char charValue() default '\u0000';

    boolean booleanValue() default false;

    ElementType enumValue() default ElementType.TYPE;

}

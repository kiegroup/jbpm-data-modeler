package org.jbpm.datamodeler.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public @interface BasicAnnotation {

    String value() default "";

}
package org.jbpm.datamodeler.annotations;

import java.lang.annotation.ElementType;

@TestTypesAnnotation(
        stringValue = "string value element",
        byteValue = 1,
        shortValue = 2,
        intValue = 3,
        longValue = 4,
        floatValue = 5,
        doubleValue = 6,
        charValue = '\u0000',
        booleanValue = true,
        enumValue = ElementType.TYPE
)
public class TestTypesAnnotationJava {
}

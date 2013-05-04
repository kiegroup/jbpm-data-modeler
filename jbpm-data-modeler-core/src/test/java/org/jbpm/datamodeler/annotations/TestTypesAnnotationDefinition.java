package org.jbpm.datamodeler.annotations;


import org.jbpm.datamodeler.core.impl.AbstractAnnotationDefinition;
import org.jbpm.datamodeler.core.impl.AnnotationMemberDefinitionImpl;

import java.lang.annotation.ElementType;

public class TestTypesAnnotationDefinition extends AbstractAnnotationDefinition {

    public TestTypesAnnotationDefinition() {
        super("@TestTypesAnnotation", TestTypesAnnotation.class.getName(), "TestTypesAnnotation", "TestTypesAnnotation annotation", true, true);
        addMember(new AnnotationMemberDefinitionImpl("stringValue", String.class.getName(), false, "", "stringValue", "stringValue"));

        addMember(new AnnotationMemberDefinitionImpl("byteValue", Byte.class.getName(), false, "", "byteValue", "byteValue"));

        addMember(new AnnotationMemberDefinitionImpl("shortValue", Short.class.getName(), false, "", "shortValue", "shortValue"));

        addMember(new AnnotationMemberDefinitionImpl("intValue", Integer.class.getName(), false, "", "intValue", "intValue"));

        addMember(new AnnotationMemberDefinitionImpl("longValue", Long.class.getName(), false, "", "longValue", "longValue"));

        addMember(new AnnotationMemberDefinitionImpl("floatValue", Float.class.getName(), false, "", "floatValue", "floatValue"));

        addMember(new AnnotationMemberDefinitionImpl("doubleValue", Double.class.getName(), false, "", "doubleValue", "doubleValue"));

        addMember(new AnnotationMemberDefinitionImpl("charValue", Character.class.getName(), false, "", "charValue", "charValue"));

        addMember(new AnnotationMemberDefinitionImpl("booleanValue", Boolean.class.getName(), false, "", "booleanValue", "booleanValue"));

        addMember(new AnnotationMemberDefinitionImpl("enumValue", ElementType.class.getName(), true, "", "enumValue", "enumValue"));
    }
    
    public static TestTypesAnnotationDefinition getInstance() {
        return new TestTypesAnnotationDefinition();
    }

}

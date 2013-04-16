package org.jbpm.datamodeler.codegen.parser.tokens;

public class AnnotationValuePairToken extends Token {
            
    private String name;
    
    private String value;
    
    public static final String ANNOTATION_VALUE_PAIR_TOKEN = "ANNOTATION_VALUE_PAIR_TOKEN";

    public AnnotationValuePairToken() {
        super(ANNOTATION_VALUE_PAIR_TOKEN);
    }

    public AnnotationValuePairToken(String name, String value) {
        this();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

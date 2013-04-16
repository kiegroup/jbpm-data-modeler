package org.jbpm.datamodeler.codegen.parser.tokens;

public class AnnotationToken extends Token {

    private String name;

    private TokenList<AnnotationValuePairToken> valuePairs = new TokenList<AnnotationValuePairToken>();

    public static final String ANNOTATION_TOKEN = "ANNOTATION_TOKEN";

    public AnnotationToken() {
        super(ANNOTATION_TOKEN);
    }

    public AnnotationToken(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TokenList<AnnotationValuePairToken> getValuePairs() {
        return valuePairs;
    }

    public void setValuePairs(TokenList<AnnotationValuePairToken> valuePairs) {
        this.valuePairs = valuePairs;
    }
}
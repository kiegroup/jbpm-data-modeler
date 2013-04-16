package org.jbpm.datamodeler.codegen.parser.tokens;

public class DataObjectPropertyToken extends Token {

    private String type;

    private String name;

    private TokenList<ModifierToken> modifiers = new TokenList<ModifierToken>();

    private TokenList<AnnotationToken> annotations = new TokenList<AnnotationToken>();
    
    public static final String DATA_OBJECT_PROPERTY_TOKEN = "DATA_OBJECT_PROPERTY_TOKEN";

    public DataObjectPropertyToken() {
        super(DATA_OBJECT_PROPERTY_TOKEN);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TokenList<ModifierToken> getModifiers() {
        return modifiers;
    }

    public void setModifiers(TokenList<ModifierToken> modifiers) {
        this.modifiers = modifiers;
    }

    public TokenList<AnnotationToken> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(TokenList<AnnotationToken> annotations) {
        this.annotations = annotations;
    }
}

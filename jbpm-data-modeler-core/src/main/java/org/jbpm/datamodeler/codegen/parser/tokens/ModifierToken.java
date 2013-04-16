package org.jbpm.datamodeler.codegen.parser.tokens;

public class ModifierToken extends Token {

    public static final String MODIFIER_TOKEN = "MODIFIER_TOKEN";

    private String modifier;

    public ModifierToken() {
        super(MODIFIER_TOKEN);
    }

    public ModifierToken(String modifier) {
        this();
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}

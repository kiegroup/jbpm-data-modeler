package org.jbpm.datamodeler.codegen.parser.tokens;

public class ImplementsToken extends Token {

    public static final String IMPLEMENTS_TOKEN = "IMPLEMENTS_TOKEN";

    private String implementedInterface;

    public ImplementsToken() {
        super(IMPLEMENTS_TOKEN);
    }

    public ImplementsToken(String implementedInterface) {
        this();
        this.implementedInterface = implementedInterface;
    }

    public String getImplementedInterface() {
        return implementedInterface;
    }

    public void setImplementedInterface(String implementedInterface) {
        this.implementedInterface = implementedInterface;
    }
}

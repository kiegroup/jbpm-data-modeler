package org.jbpm.datamodeler.codegen.parser.tokens;

public abstract class Token {

    private String id;

    protected Token(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

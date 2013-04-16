package org.jbpm.datamodeler.codegen.parser.tokens;


public class ImportToken extends Token {

    public static final String IMPORT_TOKEN = "IMPORT_TOKEN";

    private String importSentence;

    public ImportToken() {
        super(IMPORT_TOKEN);
    }

    public ImportToken(String importSentence) {
        this();
        this.importSentence = importSentence;
    }

    public String getImportSentence() {
        return importSentence;
    }

    public void setImportSentence(String importSentence) {
        this.importSentence = importSentence;
    }
}

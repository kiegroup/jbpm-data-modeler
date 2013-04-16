package org.jbpm.datamodeler.codegen.parser.tokens;


public class DataObjectToken extends Token {

    private TokenList<ImportToken> imports = new TokenList<ImportToken>();

    private TokenList<ModifierToken> classModifiers = new TokenList<ModifierToken>();

    private String packageName;

    private String className;

    private String superClassName;

    private TokenList<ImplementsToken> implementedInterfaces = new TokenList<ImplementsToken>();

    private TokenList<DataObjectPropertyToken> properties = new TokenList<DataObjectPropertyToken>();

    private TokenList<AnnotationToken> annotations = new TokenList<AnnotationToken>();
    
    public static final String DATA_OBJECT_TOKEN = "DATA_OBJECT_TOKEN";

    public DataObjectToken() {
        super(DATA_OBJECT_TOKEN);
    }

    public TokenList<ModifierToken> getClassModifiers() {
        return classModifiers;
    }

    public TokenList<ImportToken> getImports() {
        return imports;
    }

    public void setImports(TokenList<ImportToken> imports) {
        this.imports = imports;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public TokenList<ImplementsToken> getImplementedInterfaces() {
        return implementedInterfaces;
    }

    public void setImplementedInterfaces(TokenList<ImplementsToken> implementedInterfaces) {
        this.implementedInterfaces = implementedInterfaces;
    }

    public TokenList<DataObjectPropertyToken> getProperties() {
        return properties;
    }

    public void setProperties(TokenList<DataObjectPropertyToken> properties) {
        this.properties = properties;
    }

    public void addImplementedInterface(ImplementsToken interfaceDef) {
        implementedInterfaces.add(interfaceDef);
    }

    public TokenList<AnnotationToken> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(TokenList<AnnotationToken> annotations) {
        this.annotations = annotations;
    }
}

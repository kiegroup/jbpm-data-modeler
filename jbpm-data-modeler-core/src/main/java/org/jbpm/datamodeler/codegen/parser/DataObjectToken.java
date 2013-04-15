package org.jbpm.datamodeler.codegen.parser;

import java.util.ArrayList;
import java.util.List;

public class DataObjectToken {

    private List<String> imports = new ArrayList<String>();

    private List<ModifierToken> classModifiers = new ArrayList<ModifierToken>();

    private String packageName;

    private String className;

    private String superClassName;

    private List<String> implementedInterfaces = new ArrayList<String>();

    private List<DataObjectPropertyToken> properties = new ArrayList<DataObjectPropertyToken>();

    private List<AnnotationToken> annotations = new ArrayList<AnnotationToken>();

    public DataObjectToken() {
    }

    public List<ModifierToken> getClassModifiers() {
        return classModifiers;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(ArrayList<String> imports) {
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

    public List<String> getImplementedInterfaces() {
        return implementedInterfaces;
    }

    public void setImplementedInterfaces(List<String> implementedInterfaces) {
        this.implementedInterfaces = implementedInterfaces;
    }

    public List<DataObjectPropertyToken> getProperties() {
        return properties;
    }

    public void setProperties(List<DataObjectPropertyToken> properties) {
        this.properties = properties;
    }

    public void addImport(String importDef) {
        imports.add(importDef);
    }

    public void addPropertyToken(DataObjectPropertyToken propertyToken) {
        properties.add(propertyToken);
    }
    
    public void addImplementedInterface(String interfaceDef) {
        implementedInterfaces.add(interfaceDef);
    }

    public List<AnnotationToken> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<AnnotationToken> annotations) {
        this.annotations = annotations;
    }
    
    public AnnotationToken getLastAnnotation() {
        if (annotations.size() > 0) {
            return annotations.get(annotations.size()-1);
        }
        return null;
    }
}

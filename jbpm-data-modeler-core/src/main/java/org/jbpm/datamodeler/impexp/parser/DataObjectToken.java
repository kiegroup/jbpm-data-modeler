package org.jbpm.datamodeler.impexp.parser;

import java.util.ArrayList;
import java.util.List;

public class DataObjectToken {

    private ArrayList<String> imports = new ArrayList<String>();

    private String classModifiers;

    private String packageName;

    private String className;

    private String superClassName;

    private List<String> implementedInterfaces = new ArrayList<String>();

    private ArrayList<DataObjectPropertyToken> properties = new ArrayList<DataObjectPropertyToken>();

    public DataObjectToken() {
    }

    public String getClassModifiers() {
        return classModifiers;
    }

    public void setClassModifiers(String classModifiers) {
        this.classModifiers = classModifiers;
    }

    public ArrayList<String> getImports() {
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

    public ArrayList<DataObjectPropertyToken> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<DataObjectPropertyToken> properties) {
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
}

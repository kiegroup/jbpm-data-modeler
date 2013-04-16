package org.jbpm.datamodeler.codegen.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.jbpm.datamodeler.codegen.parser.tokens.*;
import org.junit.Before;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public abstract class ParserBaseTest {

    DataModelParser parser;

    String fileName;

    DataObjectToken dataObjectToken;

    List<ImportToken> imports = new ArrayList<ImportToken>();

    List<ImplementsToken> interfaceImplementations = new ArrayList<ImplementsToken>();

    List<AnnotationToken> classAnnotations = new ArrayList<AnnotationToken>();

    String superClassName = null;

    String className = null;
    
    String packageName = null;

    List<ModifierToken> classModifiers = new ArrayList<ModifierToken>();

    List<DataObjectPropertyToken> properties = new ArrayList<DataObjectPropertyToken>();

    public ParserBaseTest(String fileName) {
        this.fileName = fileName;
    }

    public abstract void loadTestModel();

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = ParserBaseTest.class.getResourceAsStream(fileName);
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);
        parser = new DataModelParser(antlrInputStream);

        loadTestModel();
    }

    @org.junit.Test
    public void testFile() throws Exception {
        dataObjectToken = parser.parse();

        assertNotNull("dataObjectToken couldn't be read from file: " + fileName, dataObjectToken);
        assertNotNull("parsed class name cannot be null.");

        testImports();
        testPackage();
        testClassName();
        testClassModifiers();
        testSuperClass();
        testImplementedInterfaces();
        testClassAnnotations();

        testProperties();
    }

    public void testImports() {
        assertEquals("expected imports count differs from parsed imports count.", imports.size(), dataObjectToken.getImports().size());
        for (int i = 0; i < imports.size(); i++) {
            assertEquals("expected import differs from parsed import.", imports.get(i).getImportSentence(), dataObjectToken.getImports().get(i).getImportSentence());
        }
    }

    public void testPackage() {
        assertEquals("Expected packagName differs from parsed package name.", packageName, dataObjectToken.getPackageName());
    }

    public void testSuperClass() {
        assertEquals("Expected superClassName differs from parsed super class name.",  superClassName, dataObjectToken.getSuperClassName());
    }

    public void testClassName() {
        assertEquals("Expected className differs from parsed class name.", className, dataObjectToken.getClassName());
    }

    public void testClassAnnotations() {
        assertEquals("expected class annotations number differs from parsed class annotations.", classAnnotations.size(), dataObjectToken.getAnnotations().size());
        for (int i = 0; i < classAnnotations.size() ; i++) {
            testAnnotation(classAnnotations.get(i), dataObjectToken.getAnnotations().get(i));
        }
    }

    public void testImplementedInterfaces() {
        assertEquals("expected implemented interfaces count differs from parsed implemented interfaces count.", interfaceImplementations.size(), dataObjectToken.getImplementedInterfaces().size());
        for (int i = 0; i < interfaceImplementations.size(); i++) {
            assertEquals("expected interface implementation differs from parsed interface implementation.",
                    interfaceImplementations.get(i).getImplementedInterface(),
                    dataObjectToken.getImplementedInterfaces().get(i).getImplementedInterface());
        }
    }

    public void testAnnotation(AnnotationToken expected, AnnotationToken parsed) {
        assertEquals("expected annotation name differs from parsed annotation name.", expected.getName(), parsed.getName());
        assertEquals("expected annotation value pairs count differ from parsed annotation value pairs count.", expected.getValuePairs().size(), parsed.getValuePairs().size());
        for (int i = 0; i < expected.getValuePairs().size(); i++) {
            testAnnotationValuePair(expected.getValuePairs().get(i), parsed.getValuePairs().get(i));
        }
    }

    public void testAnnotationValuePair(AnnotationValuePairToken expected, AnnotationValuePairToken parsed) {
        assertEquals("expected annotation value pair name differs from parsed annotation value pair name.", expected.getName(), parsed.getName());
        assertEquals("expected annotation value pair value differs from parsed annotation value pair value.", expected.getValue(), parsed.getValue());
    }

    public void testClassModifiers() {
        assertEquals("expected class modifiers number differs from parsed class modifiers number", classModifiers.size(), dataObjectToken.getClassModifiers().size());
        for (int i = 0; i < classModifiers.size(); i++) {
            assertEquals("expected class modifier differs from parsed class modifier.", classModifiers.get(i).getModifier(), dataObjectToken.getClassModifiers().get(i).getModifier());
        }
    }

    public void testProperties() {
        assertEquals("expected properties count differs from parsed properties count.", properties.size(), dataObjectToken.getProperties().size());
        for (int i = 0; i < properties.size(); i++) {
            testProprety(properties.get(i), dataObjectToken.getProperties().get(i));
        }
    }

    public void testProprety(DataObjectPropertyToken expected, DataObjectPropertyToken parsed) {
        assertEquals("expected property name differs from parsed property name.", expected.getName(), parsed.getName());
        assertEquals("expected property type differs from parsed property type.", expected.getType(), parsed.getType());
        assertEquals("expected property modifiers count differs from parsed property modifiers count.", expected.getModifiers().size(), parsed.getModifiers().size());
        for (int i = 0; i < expected.getModifiers().size(); i++) {
            assertEquals("expected modifier for a property differs from parsed modifier.", expected.getModifiers().get(i).getModifier(), parsed.getModifiers().get(i).getModifier());
        }
        assertEquals("expected property annotations count differs from parsed annotations count.", expected.getAnnotations().size(), parsed.getAnnotations().size());
        for (int i = 0; i < expected.getAnnotations().size(); i++) {
            testAnnotation(expected.getAnnotations().get(i), parsed.getAnnotations().get(i));
        }
    }

    public DataModelParser getParser() {
        return parser;
    }

    public void setParser(DataModelParser parser) {
        this.parser = parser;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public DataObjectToken getDataObjectToken() {
        return dataObjectToken;
    }

    public void setDataObjectToken(DataObjectToken dataObjectToken) {
        this.dataObjectToken = dataObjectToken;
    }

    public List<ImportToken> getImports() {
        return imports;
    }

    public void setImports(List<ImportToken> imports) {
        this.imports = imports;
    }

    public List<ImplementsToken> getInterfaceImplementations() {
        return interfaceImplementations;
    }

    public void setInterfaceImplementations(List<ImplementsToken> interfaceImplementations) {
        this.interfaceImplementations = interfaceImplementations;
    }

    public List<AnnotationToken> getClassAnnotations() {
        return classAnnotations;
    }

    public void setClassAnnotations(List<AnnotationToken> classAnnotations) {
        this.classAnnotations = classAnnotations;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ModifierToken> getClassModifiers() {
        return classModifiers;
    }

    public void setClassModifiers(List<ModifierToken> classModifiers) {
        this.classModifiers = classModifiers;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void addClassAnnotation(String name, String[][] valuePairs) {
        AnnotationToken annotationToken = new AnnotationToken(name);
        for (int i = 0; (valuePairs != null) && (valuePairs.length > 0)  &&  (i < valuePairs.length); i++) {
            if (valuePairs[i].length > 1) {
                annotationToken.getValuePairs().add(new AnnotationValuePairToken(valuePairs[i][0], valuePairs[i][1]));
            }
        }
        classAnnotations.add(annotationToken);
    }

    public DataObjectPropertyToken addProperty(String name, String type, String[] modifiers) {
        DataObjectPropertyToken propertyToken = new DataObjectPropertyToken();
        propertyToken.setName(name);
        propertyToken.setType(type);
        for (int i = 0; modifiers != null && i < modifiers.length; i++) {
            propertyToken.getModifiers().add(new ModifierToken(modifiers[i]));
        }
        properties.add(propertyToken);
        return propertyToken;
    }

    public void addPropertyAnnotation(DataObjectPropertyToken propertyToken, String name, String[][] valuePairs) {
        AnnotationToken annotationToken = new AnnotationToken(name);
        for (int i = 0; (valuePairs != null) && (valuePairs.length > 0)  &&  (i < valuePairs.length); i++) {
            if (valuePairs[i].length > 1) {
                annotationToken.getValuePairs().add(new AnnotationValuePairToken(valuePairs[i][0], valuePairs[i][1]));
            }
        }
        propertyToken.getAnnotations().add(annotationToken);
    }

    public void addClassModifier(String modifier) {
        classModifiers.add(new ModifierToken(modifier));
    }
    
    public void addImport(String importSentence) {
        imports.add(new ImportToken(importSentence));
    }

    public void addInterfaceImplementation(String interfaceSef) {
        interfaceImplementations.add(new ImplementsToken(interfaceSef));
    }

    public String toAnnotatedParamFormat(String value) {
        if (value == null) return null;
        
        StringBuffer buffer = new StringBuffer("\"");
        buffer.append(value);
        buffer.append("\"");
        return buffer.toString();
    }
}

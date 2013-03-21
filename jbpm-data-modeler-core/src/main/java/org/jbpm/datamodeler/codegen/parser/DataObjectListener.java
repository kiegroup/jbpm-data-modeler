package org.jbpm.datamodeler.codegen.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DataObjectListener extends JavaBaseListener {

    private static final Logger logger = LoggerFactory.getLogger(DataObjectListener.class);

    JavaParser parser;

    private DataObjectToken dataObjectToken = new DataObjectToken();

    //internal use. At the moment this flag indicates that the parser is reading a property declaration, and not
    //an internal block variable.
    private boolean declaringProperty = false;

    public DataObjectListener(JavaParser parser) {
        this.parser = parser;
    }

    public DataObjectToken getDataObjectToken() {
        return dataObjectToken;
    }

    @Override
    public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        printCurrentToken("enterPackageDeclaration", ctx);

        String packageName = ctx.qualifiedName().getText();
        dataObjectToken.setPackageName(packageName);
    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        printCurrentToken("enterImportDeclaration", ctx);

        String fullToken = parser.getTokenStream().getText(ctx);
        String currentImport = ctx.qualifiedName().getText();
        if (fullToken.endsWith(".*;")) {
            currentImport = currentImport + ".*";
        }
        dataObjectToken.addImport(currentImport);
    }

    @Override
    public void enterNormalClassDeclaration(JavaParser.NormalClassDeclarationContext ctx) {
        printCurrentToken("enterNormalClassDeclaration", ctx);

        String className = ctx.Identifier().getText();
        String superClassName = ctx.type() != null ? ctx.type().getText() : null;

        List<JavaParser.TypeContext> implementedInterfaces = ctx.typeList() != null ? ctx.typeList().type() : null;
        if (implementedInterfaces != null) {
            for (JavaParser.TypeContext element : implementedInterfaces) {
                dataObjectToken.addImplementedInterface(element.getText());
            }
        }

        dataObjectToken.setClassName(className);
        dataObjectToken.setSuperClassName(superClassName);
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        printCurrentToken("enterMethodDeclaration", ctx);
    }

    @Override
    public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
    }

    @Override
    public void enterClassBodyDeclaration(JavaParser.ClassBodyDeclarationContext ctx) {
        printCurrentToken("enterClassBodyDeclaration", ctx);

        String classModifiers = ctx.modifiers().getText();
        dataObjectToken.setClassModifiers(classModifiers);
    }

    @Override
    public void enterClassOrInterfaceModifiers(JavaParser.ClassOrInterfaceModifiersContext ctx) {
        List<JavaParser.ClassOrInterfaceModifierContext> modifiers = ctx.classOrInterfaceModifier();
        JavaParser.AnnotationContext annotation;

        for (JavaParser.ClassOrInterfaceModifierContext modifier : modifiers) {
            if ((annotation = modifier.annotation()) != null) {
                logger.debug("A: " + annotation.annotationName().Identifier());
                logger.debug("A1: " + annotation.getText());

            } else {
                logger.debug("B:" + modifier.getText());
            }
        }

        printCurrentToken("enterClassOrInterfaceModifiers", ctx);
    }

    @Override
    public void enterMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {
        printCurrentToken("enterMemberDeclaration", ctx);

        if (ctx.methodDeclaration() != null) {
            if (logger.isDebugEnabled()) logger.debug("Starting method declaration, at the moment we ignore methods");
        } else {
            String type = ctx.type().getText();

            if (logger.isDebugEnabled()) logger.debug("Starting field declaration, type: " + type);

            DataObjectPropertyToken newProperty = new DataObjectPropertyToken();
            newProperty.setType(type);
            
            dataObjectToken.addPropertyToken(newProperty);
            declaringProperty = true;
        }
    }

    public void exitMemberDeclaration(JavaParser.MemberDeclarationContext ctx) {
        if (ctx.methodDeclaration() != null) {
            if (logger.isDebugEnabled()) logger.debug("Closing starting method declaration");
        } else {
            if (logger.isDebugEnabled()) logger.debug("Closing field declaration");
            declaringProperty = false;
        }
    }

    @Override
    public void enterVariableDeclarator(JavaParser.VariableDeclaratorContext ctx) {
        printCurrentToken("enterVariableDeclarator", ctx);
        if (declaringProperty) {
            String name = ctx.variableDeclaratorId().Identifier().getText();
            dataObjectToken.getProperties().get(dataObjectToken.getProperties().size()-1).setName(name);
        }
    }

    void printCurrentToken(String flag,  ParserRuleContext ctx) {

        TokenStream tokens = parser.getTokenStream(); // need parser to get tokens
        String text = tokens.getText(ctx);
        if (logger.isDebugEnabled()) logger.debug(flag + ":" + text);
    }
}
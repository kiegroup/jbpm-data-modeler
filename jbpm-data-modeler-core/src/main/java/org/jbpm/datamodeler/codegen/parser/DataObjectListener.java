package org.jbpm.datamodeler.codegen.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.jbpm.datamodeler.codegen.parser.grammars.modelerv1.DataModelerBaseListener;
import org.jbpm.datamodeler.codegen.parser.grammars.modelerv1.DataModelerParser;
import org.jbpm.datamodeler.codegen.parser.tokens.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.StringTokenizer;

public class DataObjectListener extends DataModelerBaseListener {

    private static final Logger logger = LoggerFactory.getLogger(DataObjectListener.class);

    DataModelerParser parser;

    private DataObjectToken dataObjectToken = new DataObjectToken();

    //internal use. At the moment this flag indicates that the parser is reading a property declaration, and not
    //an internal block variable.
    private boolean declaringProperty = false;

    //flag indicating that class definition is being processed, by default the parser starts recognising a class.
    private boolean declaringClassModifiers = true;

    //flag indicating that a normal class declaration started. (It means the class itself)
    private boolean declaringClass = false;

    //flag indicating that class body is being processed.
    private boolean declaringClassBody = false;

    //remember the modifiers for the next coming up class member.
    //by definition the grammar has the following clause modifiers memberDecl so first comes
    //the modifiers an then the given class member.
    private TokenList<ModifierToken> currentClassMemberModifiers = new TokenList<ModifierToken>();

    //same as currentClassMemberModifiers remember annotations for the next memberDecl to be processed.
    private TokenList<AnnotationToken> currentClassMemberAnnotations = new TokenList<AnnotationToken>();

    //flag to control if an annotation is in the default value form @TheAnnotation("something") or
    //in the form @TheAnnotation(value="something")
    private boolean currentAnnotationValuePairsIsPending = false;

    //same as currentClassMemberModifiers, currentClassMemberAnnotations, remember the type for the next memberDecl
    //to be precessed.
    private String currentClassMemberType;

    public DataObjectListener(DataModelerParser parser) {
        this.parser = parser;
    }

    public DataObjectToken getDataObjectToken() {
        return dataObjectToken;
    }

    /**
     * Process package declaration.
     *
     */
    @Override
    public void enterPackageDeclaration(DataModelerParser.PackageDeclarationContext ctx) {
        printCurrentToken("enterPackageDeclaration", ctx);

        String packageName = ctx.qualifiedName().getText();
        dataObjectToken.setPackageName(packageName);
    }

    /**
     * Process import declarations.
     *
     */
    @Override
    public void enterImportDeclaration(DataModelerParser.ImportDeclarationContext ctx) {
        printCurrentToken("enterImportDeclaration", ctx);

        String fullToken = parser.getTokenStream().getText(ctx);
        String currentImport = ctx.qualifiedName().getText();
        if (fullToken.endsWith(".*;")) {
            currentImport = currentImport + ".*";
        }
        dataObjectToken.getImports().add(new ImportToken(currentImport));
    }

    /**
     * Process class modifiers and annotations.
     * e.g.  @DataObject public final
     *
     * @param ctx
     */
    @Override
    public void enterClassOrInterfaceModifiers(DataModelerParser.ClassOrInterfaceModifiersContext ctx) {
        List<DataModelerParser.ClassOrInterfaceModifierContext> modifiers = ctx.classOrInterfaceModifier();
        DataModelerParser.AnnotationContext annotation;

        for (DataModelerParser.ClassOrInterfaceModifierContext modifier : modifiers) {
            if ((annotation = modifier.annotation()) != null) {
                //Class level annotations will processed later in specific Annotiation method
            } else {
                //the modifier is the text itself
                getDataObjectToken().getClassModifiers().add(new ModifierToken(modifier.getText()));
            }
        }
        printCurrentToken("enterClassOrInterfaceModifiers", ctx);
    }

    /**
     * Class modifiers processing has finished.
     *
     */
    @Override
    public void exitClassOrInterfaceModifiers(DataModelerParser.ClassOrInterfaceModifiersContext ctx) {
        printCurrentToken("exitClassOrInterfaceModifiers", ctx);
        //remember that class modifiers section has finished.
        declaringClassModifiers = false;
    }

    @Override
    public void enterClassDeclaration(DataModelerParser.ClassDeclarationContext ctx) {
        printCurrentToken("enterClassDeclaration", ctx);
        declaringClass = true;
    }

    @Override
    public void enterNormalClassDeclaration(DataModelerParser.NormalClassDeclarationContext ctx) {
        printCurrentToken("enterNormalClassDeclaration", ctx);

        if (declaringClass) {
            String className = ctx.Identifier().getText();
            String superClassName = ctx.type() != null ? ctx.type().getText() : null;

            List<DataModelerParser.TypeContext> implementedInterfaces = ctx.typeList() != null ? ctx.typeList().type() : null;
            if (implementedInterfaces != null) {
                for (DataModelerParser.TypeContext element : implementedInterfaces) {
                    dataObjectToken.getImplementedInterfaces().add(new ImplementsToken(element.getText()));
                }
            }

            dataObjectToken.setClassName(className);
            dataObjectToken.setSuperClassName(superClassName);
        }
    }

    /**
     * Class body processing has started. From this moment the parser start to read class members,
     *
     * classBody :
     *      : '{' classBodyDeclaration * '}'
     *      ;
     *
     * classBodyDeclaration
     *      : ';'
     *      |  modifiers memberDecl1
     *
     * @param ctx
     */
    @Override
    public void enterClassBodyDeclaration(DataModelerParser.ClassBodyDeclarationContext ctx) {
        printCurrentToken("enterClassBodyDeclaration", ctx);

        declaringClassBody = true;

        //clean the buffer to collect modifiers and annotations for the next class member to be parsed and avoid
        //conflicts with the previously parsed member.
        currentClassMemberType = null;
        currentClassMemberModifiers.clear();
        currentClassMemberAnnotations.clear();
    }

    @Override
    public void exitClassBodyDeclaration(DataModelerParser.ClassBodyDeclarationContext ctx) {
        printCurrentToken("exitClassBodyDeclaration", ctx);

        //maybe this cleaning is redundant
        currentClassMemberType = null;
        currentClassMemberModifiers.clear();
        currentClassMemberAnnotations.clear();
        declaringClassBody = false;
    }

    @Override
    public void enterModifiers(DataModelerParser.ModifiersContext ctx) {
        if (declaringClassBody) {
            //nothing special to do here, modifier will be collected in enterModifier method.
        }
    }

    @Override
    public void enterModifier(DataModelerParser.ModifierContext ctx) {
        if (declaringClassBody) {
            //if a classBodyDeclaration is in process, we must record the modifiers. This modifiers will be
            //the modifiers for the next method or variable declaration.

            if (ctx.annotation() != null) {
                //by definition annotations are modifiers too, but they are processed separately. That's why we don't
                //process annotation definition here.
            } else {
                if (ctx.getText() != null) {
                    //remember the modifiers for the next class member to be defined.
                    //at the moment it can be a class variable or a method definition.
                    currentClassMemberModifiers.add(new ModifierToken(ctx.getText()));
                }
            }
        }
    }

    @Override
    public void enterGenericMethodOrConstructorDecl(DataModelerParser.GenericMethodOrConstructorDeclContext ctx) {
        //by the moment genericMethodOrConstructorDec1 are not being parsed
        //so there's nothing to do here.
    }

    @Override
    public void enterVoidMethodDeclaratorRest(DataModelerParser.VoidMethodDeclaratorRestContext ctx) {
        //by the moment voidMethodDeclaratorRest are not being parsed
        //so there's nothing to do here.
    }

    @Override
    public void enterConstructorDeclaratorRest(DataModelerParser.ConstructorDeclaratorRestContext ctx) {
        //by the moment constructorDeclaratorRest are not being parsed
        //so there's nothing to do here.
    }

    @Override
    public void enterMethodDeclaration(DataModelerParser.MethodDeclarationContext ctx) {
        //methods are not parsed, so there's nothing to do here by the moment.
    }

    @Override
    public void exitMethodDeclaration(DataModelerParser.MethodDeclarationContext ctx) {
        //methods are not parsed, so there's nothing to do here by the moment.
    }

    /**
     * By grammar definition a member declaration can have the following form
     *
     * memberDeclaration
     *      :   type ( methodDeclaration | fieldDeclaration )
     *
     * @param ctx
     */
    @Override
    public void enterMemberDeclaration(DataModelerParser.MemberDeclarationContext ctx) {
        printCurrentToken("enterMemberDeclaration", ctx);
        if (ctx.methodDeclaration() != null) {
            if (logger.isDebugEnabled()) logger.debug("Starting method declaration, at the moment we ignore methods");
        } else {

            //a fieldDeclaration is starting.
            String type = ctx.type().getText();
            currentClassMemberType = type;

            if (logger.isDebugEnabled()) logger.debug("Starting field declaration, type: " + type);

            //important.
            //by definition we can have something like this.
            // int a, b, c = 2, d;
            // where a, b, c and d has the same type.
            // to that's we can't create the property yet.
            // Instead properties will be created in the variableDeclarator method.

            //event thought we must remember that we are processing fieldDeclarations.
            declaringProperty = true;
        }
    }

    @Override
    public void exitMemberDeclaration(DataModelerParser.MemberDeclarationContext ctx) {
        if (ctx.methodDeclaration() != null) {
            if (logger.isDebugEnabled()) logger.debug("Closing starting method declaration");
        } else {
            if (logger.isDebugEnabled()) logger.debug("Closing field declaration");
            declaringProperty = false;
        }
    }

    @Override
    public void enterVariableDeclarator(DataModelerParser.VariableDeclaratorContext ctx) {
        printCurrentToken("enterVariableDeclarator", ctx);
        if (declaringClassBody && declaringProperty) {
            //for every variableDeclarator add a new property with the same type and modifiers.
            // because class fields can come in the form public int a, b, c, d;

            //Don't worry about the case when we have something like this
            // public int a;
            // int b;
            // int c;
            // because in this case the parse will recognize have a different field declaration.

            String name = ctx.variableDeclaratorId().Identifier().getText();
            if (name != null && !"".equals(name)) {

                DataObjectPropertyToken newProperty = new DataObjectPropertyToken();
                newProperty.setName(name);
                newProperty.getModifiers().addAll(currentClassMemberModifiers);
                newProperty.getAnnotations().addAll(currentClassMemberAnnotations);
                newProperty.setType(currentClassMemberType);

                dataObjectToken.getProperties().add(newProperty);
            }
        }
    }

    @Override
    public void enterAnnotation(DataModelerParser.AnnotationContext ctx) {
        printCurrentToken("enterAnnotation", ctx);
        if (declaringClassModifiers) {
            //current annotation belongs to the current class
            getDataObjectToken().getAnnotations().add(new AnnotationToken(null));
            currentAnnotationValuePairsIsPending = true;
        } else if (declaringClassBody) {
            //current annotation belongs to the class member.
            currentClassMemberAnnotations.add(new AnnotationToken(null));
            currentAnnotationValuePairsIsPending = true;
        }
    }

    @Override
    public void enterAnnotationName(DataModelerParser.AnnotationNameContext ctx) {
        printCurrentToken("enterAnnotationName", ctx);
        if (declaringClassModifiers) {
            AnnotationToken currentAnnotation = getDataObjectToken().getAnnotations().getLast();
            if (currentAnnotation != null) {
                currentAnnotation.setName(ctx.getText());
            }
        } else if (declaringClassBody) {
            AnnotationToken currentAnnotation = currentClassMemberAnnotations.getLast();
            if (currentAnnotation != null) {
                currentAnnotation.setName(ctx.getText());
            }
        }
    }

    @Override
    public void enterElementValuePairs(DataModelerParser.ElementValuePairsContext ctx) {
        printCurrentToken("enterElementValuePairs", ctx);
    }

    @Override
    public void exitElementValuePairs(DataModelerParser.ElementValuePairsContext ctx) {
        printCurrentToken("exitElementValuePairs", ctx);
    }

    @Override
    public void enterElementValuePair(DataModelerParser.ElementValuePairContext ctx) {

        printCurrentToken("enterElementValuePair", ctx);

        //with current definition we only support value pairs in the form name="value"
        //TODO add more fine grained processing for annotation value pairs
        AnnotationValuePairToken valuePair = parseValuePair(getTokenText(ctx));

        if (declaringClassModifiers && valuePair != null) {
            currentAnnotationValuePairsIsPending = false;
            AnnotationToken currentAnnotation = getDataObjectToken().getAnnotations().getLast();
            if (currentAnnotation != null) {
                currentAnnotation.getValuePairs().add(valuePair);
            }
        } else if (declaringClassBody && valuePair != null) {
            currentAnnotationValuePairsIsPending = false;
            AnnotationToken currentAnnotation = currentClassMemberAnnotations.getLast();
            if (currentAnnotation != null) {
                currentAnnotation.getValuePairs().add(valuePair);
            }
        }
    }

    @Override
    public void enterElementValue(DataModelerParser.ElementValueContext ctx) {

        if (declaringClassModifiers && currentAnnotationValuePairsIsPending) {
            //whe are processing an annotation and a value comes before a value pair, so the situation
            //is than we have an annotation using the defalut value set style. Something in the form
            // @TheAnnotation("someValue") that must be interpreted the same as
            // @TheAnnotation(value = "someValue").

            currentAnnotationValuePairsIsPending = false;
            AnnotationToken currentAnnotation = getDataObjectToken().getAnnotations().getLast();
            String value = ctx.getText();
            if (currentAnnotation != null && value != null) {
                currentAnnotation.getValuePairs().add(new AnnotationValuePairToken("value", value));
            }
        } else if (declaringClassBody && currentAnnotationValuePairsIsPending) {
            
            currentAnnotationValuePairsIsPending = false;
            AnnotationToken currentAnnotation = currentClassMemberAnnotations.getLast();
            String value = ctx.getText();
            if (currentAnnotation != null && value != null) {
                currentAnnotation.getValuePairs().add(new AnnotationValuePairToken("value", value));
            }
        }
    }

    private AnnotationValuePairToken parseValuePair(String valuePair) {
        logger.debug("Starting AnnotationValuePair parsing for valuePair: " + valuePair);

        AnnotationValuePairToken annotationValuePairToken = new AnnotationValuePairToken();
        StringTokenizer tokenizer = new StringTokenizer(valuePair, "=");
        if (tokenizer.hasMoreTokens()) {
            annotationValuePairToken.setName(tokenizer.nextToken());
            if (tokenizer.hasMoreTokens()) {
                annotationValuePairToken.setValue(tokenizer.nextToken());
            } else {
                annotationValuePairToken = null;
                logger.warn("valuePair value seems to be mal formed, value is not present");
            }
        } else {
            annotationValuePairToken = null;
            logger.warn("valuePair seems to be mal formed and couldn't be parsed");
        }
                
        return annotationValuePairToken;        
    }

    private String getTokenText(ParserRuleContext ctx) {
        TokenStream tokens = parser.getTokenStream(); // need parser to get tokens
        return tokens.getText(ctx);
    }

    private void printCurrentToken(String flag,  ParserRuleContext ctx) {

        if (logger.isDebugEnabled()) {
            TokenStream tokens = parser.getTokenStream(); // need parser to get tokens
            String text = tokens.getText(ctx);
            logger.debug(flag + ":" + getTokenText(ctx));
        }
    }
}
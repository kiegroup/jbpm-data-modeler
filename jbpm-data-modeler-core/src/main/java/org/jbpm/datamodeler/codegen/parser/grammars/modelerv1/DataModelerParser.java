// Generated from /home/wmedvede/development/projects/jbpm-data-modeler/jbpm-data-modeler-core/src/main/java/org/jbpm/datamodeler/codegen/parser/grammars/modelerv1/DataModeler.g4 by ANTLR 4.0


package org.jbpm.datamodeler.codegen.parser.grammars.modelerv1;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DataModelerParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__88=1, T__87=2, T__86=3, T__85=4, T__84=5, T__83=6, T__82=7, T__81=8, 
		T__80=9, T__79=10, T__78=11, T__77=12, T__76=13, T__75=14, T__74=15, T__73=16, 
		T__72=17, T__71=18, T__70=19, T__69=20, T__68=21, T__67=22, T__66=23, 
		T__65=24, T__64=25, T__63=26, T__62=27, T__61=28, T__60=29, T__59=30, 
		T__58=31, T__57=32, T__56=33, T__55=34, T__54=35, T__53=36, T__52=37, 
		T__51=38, T__50=39, T__49=40, T__48=41, T__47=42, T__46=43, T__45=44, 
		T__44=45, T__43=46, T__42=47, T__41=48, T__40=49, T__39=50, T__38=51, 
		T__37=52, T__36=53, T__35=54, T__34=55, T__33=56, T__32=57, T__31=58, 
		T__30=59, T__29=60, T__28=61, T__27=62, T__26=63, T__25=64, T__24=65, 
		T__23=66, T__22=67, T__21=68, T__20=69, T__19=70, T__18=71, T__17=72, 
		T__16=73, T__15=74, T__14=75, T__13=76, T__12=77, T__11=78, T__10=79, 
		T__9=80, T__8=81, T__7=82, T__6=83, T__5=84, T__4=85, T__3=86, T__2=87, 
		T__1=88, T__0=89, HexLiteral=90, DecimalLiteral=91, OctalLiteral=92, FloatingPointLiteral=93, 
		CharacterLiteral=94, StringLiteral=95, ENUM=96, ASSERT=97, Identifier=98, 
		WS=99, COMMENT=100, LINE_COMMENT=101;
	public static final String[] tokenNames = {
		"<INVALID>", "'interface'", "'&'", "'*'", "'['", "'<'", "'--'", "'false'", 
		"'continue'", "'!='", "'double'", "'abstract'", "'boolean'", "'}'", "'float'", 
		"'char'", "'strictfp'", "'case'", "'super'", "'do'", "'%'", "'*='", "')'", 
		"'throw'", "'@'", "'='", "'null'", "'throws'", "'|='", "'new'", "'class'", 
		"'finally'", "'|'", "'transient'", "'!'", "'long'", "'short'", "']'", 
		"'-='", "'public'", "'default'", "'synchronized'", "','", "'while'", "'-'", 
		"'('", "':'", "'if'", "'&='", "'int'", "'private'", "'?'", "'try'", "'void'", 
		"'package'", "'...'", "'{'", "'break'", "'native'", "'+='", "'extends'", 
		"'^='", "'final'", "'else'", "'catch'", "'true'", "'static'", "'++'", 
		"'import'", "'byte'", "'^'", "'.'", "'+'", "'protected'", "'for'", "'return'", 
		"'volatile'", "';'", "'&&'", "'this'", "'||'", "'>'", "'implements'", 
		"'%='", "'switch'", "'/='", "'/'", "'=='", "'~'", "'instanceof'", "HexLiteral", 
		"DecimalLiteral", "OctalLiteral", "FloatingPointLiteral", "CharacterLiteral", 
		"StringLiteral", "'enum'", "'assert'", "Identifier", "WS", "COMMENT", 
		"LINE_COMMENT"
	};
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_classOrInterfaceDeclaration = 3, RULE_classOrInterfaceModifiers = 4, 
		RULE_classOrInterfaceModifier = 5, RULE_modifiers = 6, RULE_classDeclaration = 7, 
		RULE_normalClassDeclaration = 8, RULE_typeParameters = 9, RULE_typeParameter = 10, 
		RULE_typeBound = 11, RULE_enumDeclaration = 12, RULE_enumBody = 13, RULE_enumConstants = 14, 
		RULE_enumConstant = 15, RULE_enumBodyDeclarations = 16, RULE_interfaceDeclaration = 17, 
		RULE_normalInterfaceDeclaration = 18, RULE_typeList = 19, RULE_classBody = 20, 
		RULE_interfaceBody = 21, RULE_classBodyDeclaration = 22, RULE_memberDecl = 23, 
		RULE_memberDeclaration = 24, RULE_genericMethodOrConstructorDecl = 25, 
		RULE_genericMethodOrConstructorRest = 26, RULE_methodDeclaration = 27, 
		RULE_fieldDeclaration = 28, RULE_interfaceBodyDeclaration = 29, RULE_interfaceMemberDecl = 30, 
		RULE_interfaceMethodOrFieldDecl = 31, RULE_interfaceMethodOrFieldRest = 32, 
		RULE_methodDeclaratorRest = 33, RULE_voidMethodDeclaratorRest = 34, RULE_interfaceMethodDeclaratorRest = 35, 
		RULE_interfaceGenericMethodDecl = 36, RULE_voidInterfaceMethodDeclaratorRest = 37, 
		RULE_constructorDeclaratorRest = 38, RULE_constantDeclarator = 39, RULE_variableDeclarators = 40, 
		RULE_variableDeclarator = 41, RULE_constantDeclaratorsRest = 42, RULE_constantDeclaratorRest = 43, 
		RULE_variableDeclaratorId = 44, RULE_variableInitializer = 45, RULE_arrayInitializer = 46, 
		RULE_modifier = 47, RULE_packageOrTypeName = 48, RULE_enumConstantName = 49, 
		RULE_typeName = 50, RULE_type = 51, RULE_classOrInterfaceType = 52, RULE_primitiveType = 53, 
		RULE_variableModifier = 54, RULE_typeArguments = 55, RULE_typeArgument = 56, 
		RULE_qualifiedNameList = 57, RULE_formalParameters = 58, RULE_formalParameterDecls = 59, 
		RULE_formalParameterDeclsRest = 60, RULE_methodBody = 61, RULE_constructorBody = 62, 
		RULE_explicitConstructorInvocation = 63, RULE_qualifiedName = 64, RULE_literal = 65, 
		RULE_integerLiteral = 66, RULE_booleanLiteral = 67, RULE_annotations = 68, 
		RULE_annotation = 69, RULE_annotationName = 70, RULE_elementValuePairs = 71, 
		RULE_elementValuePair = 72, RULE_elementValue = 73, RULE_elementValueArrayInitializer = 74, 
		RULE_annotationTypeDeclaration = 75, RULE_annotationTypeBody = 76, RULE_annotationTypeElementDeclaration = 77, 
		RULE_annotationTypeElementRest = 78, RULE_annotationMethodOrConstantRest = 79, 
		RULE_annotationMethodRest = 80, RULE_annotationConstantRest = 81, RULE_defaultValue = 82, 
		RULE_block = 83, RULE_blockStatement = 84, RULE_localVariableDeclarationStatement = 85, 
		RULE_localVariableDeclaration = 86, RULE_variableModifiers = 87, RULE_statement = 88, 
		RULE_catches = 89, RULE_catchClause = 90, RULE_formalParameter = 91, RULE_switchBlockStatementGroups = 92, 
		RULE_switchBlockStatementGroup = 93, RULE_switchLabel = 94, RULE_forControl = 95, 
		RULE_forInit = 96, RULE_enhancedForControl = 97, RULE_forUpdate = 98, 
		RULE_parExpression = 99, RULE_expressionList = 100, RULE_statementExpression = 101, 
		RULE_constantExpression = 102, RULE_expression = 103, RULE_primary = 104, 
		RULE_creator = 105, RULE_createdName = 106, RULE_innerCreator = 107, RULE_explicitGenericInvocation = 108, 
		RULE_arrayCreatorRest = 109, RULE_classCreatorRest = 110, RULE_nonWildcardTypeArguments = 111, 
		RULE_arguments = 112;
	public static final String[] ruleNames = {
		"compilationUnit", "packageDeclaration", "importDeclaration", "classOrInterfaceDeclaration", 
		"classOrInterfaceModifiers", "classOrInterfaceModifier", "modifiers", 
		"classDeclaration", "normalClassDeclaration", "typeParameters", "typeParameter", 
		"typeBound", "enumDeclaration", "enumBody", "enumConstants", "enumConstant", 
		"enumBodyDeclarations", "interfaceDeclaration", "normalInterfaceDeclaration", 
		"typeList", "classBody", "interfaceBody", "classBodyDeclaration", "memberDecl", 
		"memberDeclaration", "genericMethodOrConstructorDecl", "genericMethodOrConstructorRest", 
		"methodDeclaration", "fieldDeclaration", "interfaceBodyDeclaration", "interfaceMemberDecl", 
		"interfaceMethodOrFieldDecl", "interfaceMethodOrFieldRest", "methodDeclaratorRest", 
		"voidMethodDeclaratorRest", "interfaceMethodDeclaratorRest", "interfaceGenericMethodDecl", 
		"voidInterfaceMethodDeclaratorRest", "constructorDeclaratorRest", "constantDeclarator", 
		"variableDeclarators", "variableDeclarator", "constantDeclaratorsRest", 
		"constantDeclaratorRest", "variableDeclaratorId", "variableInitializer", 
		"arrayInitializer", "modifier", "packageOrTypeName", "enumConstantName", 
		"typeName", "type", "classOrInterfaceType", "primitiveType", "variableModifier", 
		"typeArguments", "typeArgument", "qualifiedNameList", "formalParameters", 
		"formalParameterDecls", "formalParameterDeclsRest", "methodBody", "constructorBody", 
		"explicitConstructorInvocation", "qualifiedName", "literal", "integerLiteral", 
		"booleanLiteral", "annotations", "annotation", "annotationName", "elementValuePairs", 
		"elementValuePair", "elementValue", "elementValueArrayInitializer", "annotationTypeDeclaration", 
		"annotationTypeBody", "annotationTypeElementDeclaration", "annotationTypeElementRest", 
		"annotationMethodOrConstantRest", "annotationMethodRest", "annotationConstantRest", 
		"defaultValue", "block", "blockStatement", "localVariableDeclarationStatement", 
		"localVariableDeclaration", "variableModifiers", "statement", "catches", 
		"catchClause", "formalParameter", "switchBlockStatementGroups", "switchBlockStatementGroup", 
		"switchLabel", "forControl", "forInit", "enhancedForControl", "forUpdate", 
		"parExpression", "expressionList", "statementExpression", "constantExpression", 
		"expression", "primary", "creator", "createdName", "innerCreator", "explicitGenericInvocation", 
		"arrayCreatorRest", "classCreatorRest", "nonWildcardTypeArguments", "arguments"
	};

	@Override
	public String getGrammarFileName() { return "DataModeler.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }




	public DataModelerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompilationUnitContext extends ParserRuleContext {
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public TerminalNode EOF() { return getToken(DataModelerParser.EOF, 0); }
		public ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() {
			return getRuleContext(ClassOrInterfaceDeclarationContext.class,0);
		}
		public AnnotationsContext annotations() {
			return getRuleContext(AnnotationsContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			setState(249);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226); annotations();
				{
				setState(227); packageDeclaration();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==68) {
					{
					{
					setState(228); importDeclaration();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234); classOrInterfaceDeclaration();
				}
				setState(235); match(EOF);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				_la = _input.LA(1);
				if (_la==54) {
					{
					setState(237); packageDeclaration();
					}
				}

				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==68) {
					{
					{
					setState(240); importDeclaration();
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246); classOrInterfaceDeclaration();
				setState(247); match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(54);
			setState(252); qualifiedName();
			setState(253); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportDeclarationContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(68);
			setState(257);
			_la = _input.LA(1);
			if (_la==66) {
				{
				setState(256); match(66);
				}
			}

			setState(259); qualifiedName();
			setState(262);
			_la = _input.LA(1);
			if (_la==71) {
				{
				setState(260); match(71);
				setState(261); match(3);
				}
			}

			setState(264); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public ClassOrInterfaceModifiersContext classOrInterfaceModifiers() {
			return getRuleContext(ClassOrInterfaceModifiersContext.class,0);
		}
		public ClassOrInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassOrInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassOrInterfaceDeclaration(this);
		}
	}

	public final ClassOrInterfaceDeclarationContext classOrInterfaceDeclaration() throws RecognitionException {
		ClassOrInterfaceDeclarationContext _localctx = new ClassOrInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classOrInterfaceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); classOrInterfaceModifiers();
			setState(267); classDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceModifiersContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassOrInterfaceModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassOrInterfaceModifiers(this);
		}
	}

	public final ClassOrInterfaceModifiersContext classOrInterfaceModifiers() throws RecognitionException {
		ClassOrInterfaceModifiersContext _localctx = new ClassOrInterfaceModifiersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classOrInterfaceModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (11 - 11)) | (1L << (16 - 11)) | (1L << (24 - 11)) | (1L << (39 - 11)) | (1L << (50 - 11)) | (1L << (62 - 11)) | (1L << (66 - 11)) | (1L << (73 - 11)))) != 0)) {
				{
				{
				setState(269); classOrInterfaceModifier();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassOrInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassOrInterfaceModifier(this);
		}
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classOrInterfaceModifier);
		try {
			setState(283);
			switch (_input.LA(1)) {
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(275); annotation();
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 2);
				{
				setState(276); match(39);
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 3);
				{
				setState(277); match(73);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 4);
				{
				setState(278); match(50);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 5);
				{
				setState(279); match(11);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 6);
				{
				setState(280); match(66);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 7);
				{
				setState(281); match(62);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 8);
				{
				setState(282); match(16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifiersContext extends ParserRuleContext {
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitModifiers(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_modifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(285); modifier();
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclarationContext extends ParserRuleContext {
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); normalClassDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalClassDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public NormalClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterNormalClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitNormalClassDeclaration(this);
		}
	}

	public final NormalClassDeclarationContext normalClassDeclaration() throws RecognitionException {
		NormalClassDeclarationContext _localctx = new NormalClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_normalClassDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(30);
			setState(294); match(Identifier);
			setState(296);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(295); typeParameters();
				}
			}

			setState(300);
			_la = _input.LA(1);
			if (_la==60) {
				{
				setState(298); match(60);
				setState(299); type();
				}
			}

			setState(304);
			_la = _input.LA(1);
			if (_la==82) {
				{
				setState(302); match(82);
				setState(303); typeList();
				}
			}

			setState(306); classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParametersContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308); match(5);
			setState(309); typeParameter();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(310); match(42);
				setState(311); typeParameter();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeParameterContext extends ParserRuleContext {
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(Identifier);
			setState(322);
			_la = _input.LA(1);
			if (_la==60) {
				{
				setState(320); match(60);
				setState(321); typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeBoundContext extends ParserRuleContext {
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeBound(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); type();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(325); match(2);
				setState(326); type();
				}
				}
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(DataModelerParser.ENUM, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332); match(ENUM);
			setState(333); match(Identifier);
			setState(336);
			_la = _input.LA(1);
			if (_la==82) {
				{
				setState(334); match(82);
				setState(335); typeList();
				}
			}

			setState(338); enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext {
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340); match(56);
			setState(342);
			_la = _input.LA(1);
			if (_la==24 || _la==Identifier) {
				{
				setState(341); enumConstants();
				}
			}

			setState(345);
			_la = _input.LA(1);
			if (_la==42) {
				{
				setState(344); match(42);
				}
			}

			setState(348);
			_la = _input.LA(1);
			if (_la==77) {
				{
				setState(347); enumBodyDeclarations();
				}
			}

			setState(350); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantsContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumConstants(this);
		}
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(352); enumConstant();
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(353); match(42);
					setState(354); enumConstant();
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AnnotationsContext annotations() {
			return getRuleContext(AnnotationsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumConstant(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if (_la==24) {
				{
				setState(360); annotations();
				}
			}

			setState(363); match(Identifier);
			setState(365);
			_la = _input.LA(1);
			if (_la==45) {
				{
				setState(364); arguments();
				}
			}

			setState(368);
			_la = _input.LA(1);
			if (_la==56) {
				{
				setState(367); classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumBodyDeclarations(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); match(77);
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 39) | (1L << 41) | (1L << 49) | (1L << 50) | (1L << 53) | (1L << 58) | (1L << 62))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (66 - 66)) | (1L << (69 - 66)) | (1L << (73 - 66)) | (1L << (76 - 66)) | (1L << (77 - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(371); classBodyDeclaration();
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interfaceDeclaration);
		try {
			setState(379);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(377); normalInterfaceDeclaration();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				setState(378); annotationTypeDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitNormalInterfaceDeclaration(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381); match(1);
			setState(382); match(Identifier);
			setState(384);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(383); typeParameters();
				}
			}

			setState(388);
			_la = _input.LA(1);
			if (_la==60) {
				{
				setState(386); match(60);
				setState(387); typeList();
				}
			}

			setState(390); interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeListContext extends ParserRuleContext {
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeList(this);
		}
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392); type();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(393); match(42);
				setState(394); type();
				}
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyContext extends ParserRuleContext {
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400); match(56);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 39) | (1L << 41) | (1L << 49) | (1L << 50) | (1L << 53) | (1L << 58) | (1L << 62))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (66 - 66)) | (1L << (69 - 66)) | (1L << (73 - 66)) | (1L << (76 - 66)) | (1L << (77 - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(401); classBodyDeclaration();
				}
				}
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(407); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyContext extends ParserRuleContext {
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409); match(56);
			setState(413);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 5) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 30) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 39) | (1L << 41) | (1L << 49) | (1L << 50) | (1L << 53) | (1L << 58) | (1L << 62))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (66 - 66)) | (1L << (69 - 66)) | (1L << (73 - 66)) | (1L << (76 - 66)) | (1L << (77 - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(410); interfaceBodyDeclaration();
				}
				}
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(416); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public MemberDeclContext memberDecl() {
			return getRuleContext(MemberDeclContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_classBodyDeclaration);
		try {
			setState(422);
			switch (_input.LA(1)) {
			case 77:
				enterOuterAlt(_localctx, 1);
				{
				setState(418); match(77);
				}
				break;
			case 5:
			case 10:
			case 11:
			case 12:
			case 14:
			case 15:
			case 16:
			case 24:
			case 33:
			case 35:
			case 36:
			case 39:
			case 41:
			case 49:
			case 50:
			case 53:
			case 58:
			case 62:
			case 66:
			case 69:
			case 73:
			case 76:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(419); modifiers();
				setState(420); memberDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclContext extends ParserRuleContext {
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public GenericMethodOrConstructorDeclContext genericMethodOrConstructorDecl() {
			return getRuleContext(GenericMethodOrConstructorDeclContext.class,0);
		}
		public ConstructorDeclaratorRestContext constructorDeclaratorRest() {
			return getRuleContext(ConstructorDeclaratorRestContext.class,0);
		}
		public VoidMethodDeclaratorRestContext voidMethodDeclaratorRest() {
			return getRuleContext(VoidMethodDeclaratorRestContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public MemberDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterMemberDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitMemberDecl(this);
		}
	}

	public final MemberDeclContext memberDecl() throws RecognitionException {
		MemberDeclContext _localctx = new MemberDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_memberDecl);
		try {
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(424); genericMethodOrConstructorDecl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(425); memberDeclaration();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(426); match(53);
				setState(427); match(Identifier);
				setState(428); voidMethodDeclaratorRest();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(429); match(Identifier);
				setState(430); constructorDeclaratorRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberDeclarationContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitMemberDeclaration(this);
		}
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_memberDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433); type();
			setState(436);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(434); methodDeclaration();
				}
				break;

			case 2:
				{
				setState(435); fieldDeclaration();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericMethodOrConstructorDeclContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public GenericMethodOrConstructorRestContext genericMethodOrConstructorRest() {
			return getRuleContext(GenericMethodOrConstructorRestContext.class,0);
		}
		public GenericMethodOrConstructorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodOrConstructorDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterGenericMethodOrConstructorDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitGenericMethodOrConstructorDecl(this);
		}
	}

	public final GenericMethodOrConstructorDeclContext genericMethodOrConstructorDecl() throws RecognitionException {
		GenericMethodOrConstructorDeclContext _localctx = new GenericMethodOrConstructorDeclContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_genericMethodOrConstructorDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438); typeParameters();
			setState(439); genericMethodOrConstructorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericMethodOrConstructorRestContext extends ParserRuleContext {
		public ConstructorDeclaratorRestContext constructorDeclaratorRest() {
			return getRuleContext(ConstructorDeclaratorRestContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public MethodDeclaratorRestContext methodDeclaratorRest() {
			return getRuleContext(MethodDeclaratorRestContext.class,0);
		}
		public GenericMethodOrConstructorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodOrConstructorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterGenericMethodOrConstructorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitGenericMethodOrConstructorRest(this);
		}
	}

	public final GenericMethodOrConstructorRestContext genericMethodOrConstructorRest() throws RecognitionException {
		GenericMethodOrConstructorRestContext _localctx = new GenericMethodOrConstructorRestContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_genericMethodOrConstructorRest);
		try {
			setState(449);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				switch (_input.LA(1)) {
				case 10:
				case 12:
				case 14:
				case 15:
				case 35:
				case 36:
				case 49:
				case 69:
				case Identifier:
					{
					setState(441); type();
					}
					break;
				case 53:
					{
					setState(442); match(53);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(445); match(Identifier);
				setState(446); methodDeclaratorRest();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(447); match(Identifier);
				setState(448); constructorDeclaratorRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public MethodDeclaratorRestContext methodDeclaratorRest() {
			return getRuleContext(MethodDeclaratorRestContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_methodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451); match(Identifier);
			setState(452); methodDeclaratorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclarationContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454); variableDeclarators();
			setState(455); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public InterfaceMemberDeclContext interfaceMemberDecl() {
			return getRuleContext(InterfaceMemberDeclContext.class,0);
		}
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceBodyDeclaration(this);
		}
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_interfaceBodyDeclaration);
		try {
			setState(461);
			switch (_input.LA(1)) {
			case 1:
			case 5:
			case 10:
			case 11:
			case 12:
			case 14:
			case 15:
			case 16:
			case 24:
			case 30:
			case 33:
			case 35:
			case 36:
			case 39:
			case 41:
			case 49:
			case 50:
			case 53:
			case 58:
			case 62:
			case 66:
			case 69:
			case 73:
			case 76:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(457); modifiers();
				setState(458); interfaceMemberDecl();
				}
				break;
			case 77:
				enterOuterAlt(_localctx, 2);
				{
				setState(460); match(77);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMemberDeclContext extends ParserRuleContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public InterfaceGenericMethodDeclContext interfaceGenericMethodDecl() {
			return getRuleContext(InterfaceGenericMethodDeclContext.class,0);
		}
		public InterfaceMethodOrFieldDeclContext interfaceMethodOrFieldDecl() {
			return getRuleContext(InterfaceMethodOrFieldDeclContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public VoidInterfaceMethodDeclaratorRestContext voidInterfaceMethodDeclaratorRest() {
			return getRuleContext(VoidInterfaceMethodDeclaratorRestContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public InterfaceMemberDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceMemberDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceMemberDecl(this);
		}
	}

	public final InterfaceMemberDeclContext interfaceMemberDecl() throws RecognitionException {
		InterfaceMemberDeclContext _localctx = new InterfaceMemberDeclContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_interfaceMemberDecl);
		try {
			setState(470);
			switch (_input.LA(1)) {
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(463); interfaceMethodOrFieldDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 2);
				{
				setState(464); interfaceGenericMethodDecl();
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 3);
				{
				setState(465); match(53);
				setState(466); match(Identifier);
				setState(467); voidInterfaceMethodDeclaratorRest();
				}
				break;
			case 1:
			case 24:
				enterOuterAlt(_localctx, 4);
				{
				setState(468); interfaceDeclaration();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 5);
				{
				setState(469); classDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodOrFieldDeclContext extends ParserRuleContext {
		public InterfaceMethodOrFieldRestContext interfaceMethodOrFieldRest() {
			return getRuleContext(InterfaceMethodOrFieldRestContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public InterfaceMethodOrFieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodOrFieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceMethodOrFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceMethodOrFieldDecl(this);
		}
	}

	public final InterfaceMethodOrFieldDeclContext interfaceMethodOrFieldDecl() throws RecognitionException {
		InterfaceMethodOrFieldDeclContext _localctx = new InterfaceMethodOrFieldDeclContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_interfaceMethodOrFieldDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); type();
			setState(473); match(Identifier);
			setState(474); interfaceMethodOrFieldRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodOrFieldRestContext extends ParserRuleContext {
		public InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() {
			return getRuleContext(InterfaceMethodDeclaratorRestContext.class,0);
		}
		public ConstantDeclaratorsRestContext constantDeclaratorsRest() {
			return getRuleContext(ConstantDeclaratorsRestContext.class,0);
		}
		public InterfaceMethodOrFieldRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodOrFieldRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceMethodOrFieldRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceMethodOrFieldRest(this);
		}
	}

	public final InterfaceMethodOrFieldRestContext interfaceMethodOrFieldRest() throws RecognitionException {
		InterfaceMethodOrFieldRestContext _localctx = new InterfaceMethodOrFieldRestContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_interfaceMethodOrFieldRest);
		try {
			setState(480);
			switch (_input.LA(1)) {
			case 4:
			case 25:
				enterOuterAlt(_localctx, 1);
				{
				setState(476); constantDeclaratorsRest();
				setState(477); match(77);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 2);
				{
				setState(479); interfaceMethodDeclaratorRest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclaratorRestContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitMethodDeclaratorRest(this);
		}
	}

	public final MethodDeclaratorRestContext methodDeclaratorRest() throws RecognitionException {
		MethodDeclaratorRestContext _localctx = new MethodDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_methodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482); formalParameters();
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(483); match(4);
				setState(484); match(37);
				}
				}
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(490); match(27);
				setState(491); qualifiedNameList();
				}
			}

			setState(496);
			switch (_input.LA(1)) {
			case 56:
				{
				setState(494); methodBody();
				}
				break;
			case 77:
				{
				setState(495); match(77);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidMethodDeclaratorRestContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public VoidMethodDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVoidMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVoidMethodDeclaratorRest(this);
		}
	}

	public final VoidMethodDeclaratorRestContext voidMethodDeclaratorRest() throws RecognitionException {
		VoidMethodDeclaratorRestContext _localctx = new VoidMethodDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_voidMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498); formalParameters();
			setState(501);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(499); match(27);
				setState(500); qualifiedNameList();
				}
			}

			setState(505);
			switch (_input.LA(1)) {
			case 56:
				{
				setState(503); methodBody();
				}
				break;
			case 77:
				{
				setState(504); match(77);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclaratorRestContext extends ParserRuleContext {
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public InterfaceMethodDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceMethodDeclaratorRest(this);
		}
	}

	public final InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() throws RecognitionException {
		InterfaceMethodDeclaratorRestContext _localctx = new InterfaceMethodDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_interfaceMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507); formalParameters();
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(508); match(4);
				setState(509); match(37);
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(517);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(515); match(27);
				setState(516); qualifiedNameList();
				}
			}

			setState(519); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceGenericMethodDeclContext extends ParserRuleContext {
		public InterfaceMethodDeclaratorRestContext interfaceMethodDeclaratorRest() {
			return getRuleContext(InterfaceMethodDeclaratorRestContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public InterfaceGenericMethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceGenericMethodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInterfaceGenericMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInterfaceGenericMethodDecl(this);
		}
	}

	public final InterfaceGenericMethodDeclContext interfaceGenericMethodDecl() throws RecognitionException {
		InterfaceGenericMethodDeclContext _localctx = new InterfaceGenericMethodDeclContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_interfaceGenericMethodDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521); typeParameters();
			setState(524);
			switch (_input.LA(1)) {
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
			case Identifier:
				{
				setState(522); type();
				}
				break;
			case 53:
				{
				setState(523); match(53);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(526); match(Identifier);
			setState(527); interfaceMethodDeclaratorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidInterfaceMethodDeclaratorRestContext extends ParserRuleContext {
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public VoidInterfaceMethodDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidInterfaceMethodDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVoidInterfaceMethodDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVoidInterfaceMethodDeclaratorRest(this);
		}
	}

	public final VoidInterfaceMethodDeclaratorRestContext voidInterfaceMethodDeclaratorRest() throws RecognitionException {
		VoidInterfaceMethodDeclaratorRestContext _localctx = new VoidInterfaceMethodDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_voidInterfaceMethodDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529); formalParameters();
			setState(532);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(530); match(27);
				setState(531); qualifiedNameList();
				}
			}

			setState(534); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorDeclaratorRestContext extends ParserRuleContext {
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstructorDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstructorDeclaratorRest(this);
		}
	}

	public final ConstructorDeclaratorRestContext constructorDeclaratorRest() throws RecognitionException {
		ConstructorDeclaratorRestContext _localctx = new ConstructorDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_constructorDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536); formalParameters();
			setState(539);
			_la = _input.LA(1);
			if (_la==27) {
				{
				setState(537); match(27);
				setState(538); qualifiedNameList();
				}
			}

			setState(541); constructorBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public ConstantDeclaratorRestContext constantDeclaratorRest() {
			return getRuleContext(ConstantDeclaratorRestContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstantDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstantDeclarator(this);
		}
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_constantDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543); match(Identifier);
			setState(544); constantDeclaratorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableDeclarators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableDeclarators(this);
		}
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546); variableDeclarator();
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(547); match(42);
				setState(548); variableDeclarator();
				}
				}
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableDeclarator(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554); variableDeclaratorId();
			setState(557);
			_la = _input.LA(1);
			if (_la==25) {
				{
				setState(555); match(25);
				setState(556); variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorsRestContext extends ParserRuleContext {
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorRestContext constantDeclaratorRest() {
			return getRuleContext(ConstantDeclaratorRestContext.class,0);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public ConstantDeclaratorsRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaratorsRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstantDeclaratorsRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstantDeclaratorsRest(this);
		}
	}

	public final ConstantDeclaratorsRestContext constantDeclaratorsRest() throws RecognitionException {
		ConstantDeclaratorsRestContext _localctx = new ConstantDeclaratorsRestContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_constantDeclaratorsRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559); constantDeclaratorRest();
			setState(564);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(560); match(42);
				setState(561); constantDeclarator();
				}
				}
				setState(566);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantDeclaratorRestContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ConstantDeclaratorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaratorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstantDeclaratorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstantDeclaratorRest(this);
		}
	}

	public final ConstantDeclaratorRestContext constantDeclaratorRest() throws RecognitionException {
		ConstantDeclaratorRestContext _localctx = new ConstantDeclaratorRestContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_constantDeclaratorRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(567); match(4);
				setState(568); match(37);
				}
				}
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(574); match(25);
			setState(575); variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableDeclaratorId(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577); match(Identifier);
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(578); match(4);
				setState(579); match(37);
				}
				}
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_variableInitializer);
		try {
			setState(587);
			switch (_input.LA(1)) {
			case 56:
				enterOuterAlt(_localctx, 1);
				{
				setState(585); arrayInitializer();
				}
				break;
			case 6:
			case 7:
			case 10:
			case 12:
			case 14:
			case 15:
			case 18:
			case 26:
			case 29:
			case 34:
			case 35:
			case 36:
			case 44:
			case 45:
			case 49:
			case 53:
			case 65:
			case 67:
			case 69:
			case 72:
			case 79:
			case 88:
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
			case FloatingPointLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(586); expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(589); match(56);
			setState(601);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53) | (1L << 56))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(590); variableInitializer();
				setState(595);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(591); match(42);
						setState(592); variableInitializer();
						}
						} 
					}
					setState(597);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
				}
				setState(599);
				_la = _input.LA(1);
				if (_la==42) {
					{
					setState(598); match(42);
					}
				}

				}
			}

			setState(603); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_modifier);
		try {
			setState(617);
			switch (_input.LA(1)) {
			case 24:
				enterOuterAlt(_localctx, 1);
				{
				setState(605); annotation();
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 2);
				{
				setState(606); match(39);
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 3);
				{
				setState(607); match(73);
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 4);
				{
				setState(608); match(50);
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 5);
				{
				setState(609); match(66);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 6);
				{
				setState(610); match(11);
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 7);
				{
				setState(611); match(62);
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 8);
				{
				setState(612); match(58);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 9);
				{
				setState(613); match(41);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 10);
				{
				setState(614); match(33);
				}
				break;
			case 76:
				enterOuterAlt(_localctx, 11);
				{
				setState(615); match(76);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 12);
				{
				setState(616); match(16);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageOrTypeNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public PackageOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterPackageOrTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitPackageOrTypeName(this);
		}
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_packageOrTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnumConstantName(this);
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623); qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_type);
		try {
			int _alt;
			setState(641);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(625); classOrInterfaceType();
				setState(630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(626); match(4);
						setState(627); match(37);
						}
						} 
					}
					setState(632);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				}
				break;
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
				enterOuterAlt(_localctx, 2);
				{
				setState(633); primitiveType();
				setState(638);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(634); match(4);
						setState(635); match(37);
						}
						} 
					}
					setState(640);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public TerminalNode Identifier(int i) {
			return getToken(DataModelerParser.Identifier, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public List<TerminalNode> Identifier() { return getTokens(DataModelerParser.Identifier); }
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassOrInterfaceType(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(643); match(Identifier);
			setState(645);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(644); typeArguments();
				}
				break;
			}
			setState(654);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(647); match(71);
					setState(648); match(Identifier);
					setState(650);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						setState(649); typeArguments();
						}
						break;
					}
					}
					} 
				}
				setState(656);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			_la = _input.LA(1);
			if ( !(((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (10 - 10)) | (1L << (12 - 10)) | (1L << (14 - 10)) | (1L << (15 - 10)) | (1L << (35 - 10)) | (1L << (36 - 10)) | (1L << (49 - 10)) | (1L << (69 - 10)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableModifier(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_variableModifier);
		try {
			setState(661);
			switch (_input.LA(1)) {
			case 62:
				enterOuterAlt(_localctx, 1);
				{
				setState(659); match(62);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				setState(660); annotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentsContext extends ParserRuleContext {
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663); match(5);
			setState(664); typeArgument();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(665); match(42);
				setState(666); typeArgument();
				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(672); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitTypeArgument(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_typeArgument);
		int _la;
		try {
			setState(680);
			switch (_input.LA(1)) {
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(674); type();
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 2);
				{
				setState(675); match(51);
				setState(678);
				_la = _input.LA(1);
				if (_la==18 || _la==60) {
					{
					setState(676);
					_la = _input.LA(1);
					if ( !(_la==18 || _la==60) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(677); type();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameListContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterQualifiedNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitQualifiedNameList(this);
		}
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682); qualifiedName();
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(683); match(42);
				setState(684); qualifiedName();
				}
				}
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public FormalParameterDeclsContext formalParameterDecls() {
			return getRuleContext(FormalParameterDeclsContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690); match(45);
			setState(692);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 24) | (1L << 35) | (1L << 36) | (1L << 49) | (1L << 62))) != 0) || _la==69 || _la==Identifier) {
				{
				setState(691); formalParameterDecls();
				}
			}

			setState(694); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterDeclsContext extends ParserRuleContext {
		public FormalParameterDeclsRestContext formalParameterDeclsRest() {
			return getRuleContext(FormalParameterDeclsRestContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
			return getRuleContext(VariableModifiersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalParameterDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterFormalParameterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitFormalParameterDecls(this);
		}
	}

	public final FormalParameterDeclsContext formalParameterDecls() throws RecognitionException {
		FormalParameterDeclsContext _localctx = new FormalParameterDeclsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_formalParameterDecls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696); variableModifiers();
			setState(697); type();
			setState(698); formalParameterDeclsRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterDeclsRestContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public FormalParameterDeclsContext formalParameterDecls() {
			return getRuleContext(FormalParameterDeclsContext.class,0);
		}
		public FormalParameterDeclsRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterDeclsRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterFormalParameterDeclsRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitFormalParameterDeclsRest(this);
		}
	}

	public final FormalParameterDeclsRestContext formalParameterDeclsRest() throws RecognitionException {
		FormalParameterDeclsRestContext _localctx = new FormalParameterDeclsRestContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_formalParameterDeclsRest);
		int _la;
		try {
			setState(707);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(700); variableDeclaratorId();
				setState(703);
				_la = _input.LA(1);
				if (_la==42) {
					{
					setState(701); match(42);
					setState(702); formalParameterDecls();
					}
				}

				}
				break;
			case 55:
				enterOuterAlt(_localctx, 2);
				{
				setState(705); match(55);
				setState(706); variableDeclaratorId();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(709); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorBodyContext extends ParserRuleContext {
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
			return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstructorBody(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711); match(56);
			setState(713);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(712); explicitConstructorInvocation();
				}
				break;
			}
			setState(718);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 19) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 41) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 49) | (1L << 52) | (1L << 53) | (1L << 56) | (1L << 57) | (1L << 62))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (74 - 65)) | (1L << (75 - 65)) | (1L << (77 - 65)) | (1L << (79 - 65)) | (1L << (84 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (ASSERT - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				{
				setState(715); blockStatement();
				}
				}
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(721); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitExplicitConstructorInvocation(this);
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(739);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(724);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(723); nonWildcardTypeArguments();
					}
				}

				setState(726);
				_la = _input.LA(1);
				if ( !(_la==18 || _la==79) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(727); arguments();
				setState(728); match(77);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(730); primary();
				setState(731); match(71);
				setState(733);
				_la = _input.LA(1);
				if (_la==5) {
					{
					setState(732); nonWildcardTypeArguments();
					}
				}

				setState(735); match(18);
				setState(736); arguments();
				setState(737); match(77);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(DataModelerParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(DataModelerParser.Identifier); }
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitQualifiedName(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(741); match(Identifier);
			setState(746);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(742); match(71);
					setState(743); match(Identifier);
					}
					} 
				}
				setState(748);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(DataModelerParser.StringLiteral, 0); }
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public TerminalNode CharacterLiteral() { return getToken(DataModelerParser.CharacterLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(DataModelerParser.FloatingPointLiteral, 0); }
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_literal);
		try {
			setState(755);
			switch (_input.LA(1)) {
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
				enterOuterAlt(_localctx, 1);
				{
				setState(749); integerLiteral();
				}
				break;
			case FloatingPointLiteral:
				enterOuterAlt(_localctx, 2);
				{
				setState(750); match(FloatingPointLiteral);
				}
				break;
			case CharacterLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(751); match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(752); match(StringLiteral);
				}
				break;
			case 7:
			case 65:
				enterOuterAlt(_localctx, 5);
				{
				setState(753); booleanLiteral();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 6);
				{
				setState(754); match(26);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode HexLiteral() { return getToken(DataModelerParser.HexLiteral, 0); }
		public TerminalNode DecimalLiteral() { return getToken(DataModelerParser.DecimalLiteral, 0); }
		public TerminalNode OctalLiteral() { return getToken(DataModelerParser.OctalLiteral, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitIntegerLiteral(this);
		}
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			_la = _input.LA(1);
			if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & ((1L << (HexLiteral - 90)) | (1L << (DecimalLiteral - 90)) | (1L << (OctalLiteral - 90)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			_la = _input.LA(1);
			if ( !(_la==7 || _la==65) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationsContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public AnnotationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotations(this);
		}
	}

	public final AnnotationsContext annotations() throws RecognitionException {
		AnnotationsContext _localctx = new AnnotationsContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_annotations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(762); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(761); annotation();
				}
				}
				setState(764); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==24 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public AnnotationNameContext annotationName() {
			return getRuleContext(AnnotationNameContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766); match(24);
			setState(767); annotationName();
			setState(774);
			_la = _input.LA(1);
			if (_la==45) {
				{
				setState(768); match(45);
				setState(771);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(769); elementValuePairs();
					}
					break;

				case 2:
					{
					setState(770); elementValue();
					}
					break;
				}
				setState(773); match(22);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationNameContext extends ParserRuleContext {
		public TerminalNode Identifier(int i) {
			return getToken(DataModelerParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(DataModelerParser.Identifier); }
		public AnnotationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationName(this);
		}
	}

	public final AnnotationNameContext annotationName() throws RecognitionException {
		AnnotationNameContext _localctx = new AnnotationNameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_annotationName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776); match(Identifier);
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==71) {
				{
				{
				setState(777); match(71);
				setState(778); match(Identifier);
				}
				}
				setState(783);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairsContext extends ParserRuleContext {
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterElementValuePairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitElementValuePairs(this);
		}
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784); elementValuePair();
			setState(789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(785); match(42);
				setState(786); elementValuePair();
				}
				}
				setState(791);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValuePairContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitElementValuePair(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792); match(Identifier);
			setState(793); match(25);
			setState(794); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueContext extends ParserRuleContext {
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitElementValue(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_elementValue);
		try {
			setState(799);
			switch (_input.LA(1)) {
			case 6:
			case 7:
			case 10:
			case 12:
			case 14:
			case 15:
			case 18:
			case 26:
			case 29:
			case 34:
			case 35:
			case 36:
			case 44:
			case 45:
			case 49:
			case 53:
			case 65:
			case 67:
			case 69:
			case 72:
			case 79:
			case 88:
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
			case FloatingPointLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(796); expression(0);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 2);
				{
				setState(797); annotation();
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 3);
				{
				setState(798); elementValueArrayInitializer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitElementValueArrayInitializer(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(801); match(56);
			setState(810);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 24) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53) | (1L << 56))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(802); elementValue();
				setState(807);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(803); match(42);
						setState(804); elementValue();
						}
						} 
					}
					setState(809);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				}
				}
			}

			setState(813);
			_la = _input.LA(1);
			if (_la==42) {
				{
				setState(812); match(42);
				}
			}

			setState(815); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationTypeDeclaration(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817); match(24);
			setState(818); match(1);
			setState(819); match(Identifier);
			setState(820); annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationTypeBody(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822); match(56);
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 10) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 16) | (1L << 24) | (1L << 30) | (1L << 33) | (1L << 35) | (1L << 36) | (1L << 39) | (1L << 41) | (1L << 49) | (1L << 50) | (1L << 58) | (1L << 62))) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & ((1L << (66 - 66)) | (1L << (69 - 66)) | (1L << (73 - 66)) | (1L << (76 - 66)) | (1L << (ENUM - 66)) | (1L << (Identifier - 66)))) != 0)) {
				{
				{
				setState(823); annotationTypeElementDeclaration();
				}
				}
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(829); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationTypeElementDeclaration(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_annotationTypeElementDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831); modifiers();
			setState(832); annotationTypeElementRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationTypeElementRestContext extends ParserRuleContext {
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationTypeElementRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationTypeElementRest(this);
		}
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_annotationTypeElementRest);
		int _la;
		try {
			setState(854);
			switch (_input.LA(1)) {
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(834); type();
				setState(835); annotationMethodOrConstantRest();
				setState(836); match(77);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 2);
				{
				setState(838); normalClassDeclaration();
				setState(840);
				_la = _input.LA(1);
				if (_la==77) {
					{
					setState(839); match(77);
					}
				}

				}
				break;
			case 1:
				enterOuterAlt(_localctx, 3);
				{
				setState(842); normalInterfaceDeclaration();
				setState(844);
				_la = _input.LA(1);
				if (_la==77) {
					{
					setState(843); match(77);
					}
				}

				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(846); enumDeclaration();
				setState(848);
				_la = _input.LA(1);
				if (_la==77) {
					{
					setState(847); match(77);
					}
				}

				}
				break;
			case 24:
				enterOuterAlt(_localctx, 5);
				{
				setState(850); annotationTypeDeclaration();
				setState(852);
				_la = _input.LA(1);
				if (_la==77) {
					{
					setState(851); match(77);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext {
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationMethodOrConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationMethodOrConstantRest(this);
		}
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_annotationMethodOrConstantRest);
		try {
			setState(858);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(856); annotationMethodRest();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(857); annotationConstantRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationMethodRestContext extends ParserRuleContext {
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationMethodRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationMethodRest(this);
		}
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860); match(Identifier);
			setState(861); match(45);
			setState(862); match(22);
			setState(864);
			_la = _input.LA(1);
			if (_la==40) {
				{
				setState(863); defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationConstantRestContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterAnnotationConstantRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitAnnotationConstantRest(this);
		}
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitDefaultValue(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868); match(40);
			setState(869); elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(871); match(56);
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 19) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 41) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 49) | (1L << 52) | (1L << 53) | (1L << 56) | (1L << 57) | (1L << 62))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (74 - 65)) | (1L << (75 - 65)) | (1L << (77 - 65)) | (1L << (79 - 65)) | (1L << (84 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (ASSERT - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				{
				setState(872); blockStatement();
				}
				}
				setState(877);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(878); match(13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_blockStatement);
		try {
			setState(882);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(880); localVariableDeclarationStatement();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(881); statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitLocalVariableDeclarationStatement(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884); localVariableDeclaration();
			setState(885); match(77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public VariableModifiersContext variableModifiers() {
			return getRuleContext(VariableModifiersContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitLocalVariableDeclaration(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_localVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887); variableModifiers();
			setState(888); type();
			setState(889); variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableModifiersContext extends ParserRuleContext {
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterVariableModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitVariableModifiers(this);
		}
	}

	public final VariableModifiersContext variableModifiers() throws RecognitionException {
		VariableModifiersContext _localctx = new VariableModifiersContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_variableModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24 || _la==62) {
				{
				{
				setState(891); variableModifier();
				}
				}
				setState(896);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public SwitchBlockStatementGroupsContext switchBlockStatementGroups() {
			return getRuleContext(SwitchBlockStatementGroupsContext.class,0);
		}
		public TerminalNode ASSERT() { return getToken(DataModelerParser.ASSERT, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_statement);
		int _la;
		try {
			setState(976);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(897); block();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(898); match(ASSERT);
				setState(899); expression(0);
				setState(902);
				_la = _input.LA(1);
				if (_la==46) {
					{
					setState(900); match(46);
					setState(901); expression(0);
					}
				}

				setState(904); match(77);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(906); match(47);
				setState(907); parExpression();
				setState(908); statement();
				setState(911);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(909); match(63);
					setState(910); statement();
					}
					break;
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(913); match(74);
				setState(914); match(45);
				setState(915); forControl();
				setState(916); match(22);
				setState(917); statement();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(919); match(43);
				setState(920); parExpression();
				setState(921); statement();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(923); match(19);
				setState(924); statement();
				setState(925); match(43);
				setState(926); parExpression();
				setState(927); match(77);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(929); match(52);
				setState(930); block();
				setState(938);
				switch (_input.LA(1)) {
				case 64:
					{
					setState(931); catches();
					setState(934);
					_la = _input.LA(1);
					if (_la==31) {
						{
						setState(932); match(31);
						setState(933); block();
						}
					}

					}
					break;
				case 31:
					{
					setState(936); match(31);
					setState(937); block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(940); match(84);
				setState(941); parExpression();
				setState(942); match(56);
				setState(943); switchBlockStatementGroups();
				setState(944); match(13);
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(946); match(41);
				setState(947); parExpression();
				setState(948); block();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(950); match(75);
				setState(952);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(951); expression(0);
					}
				}

				setState(954); match(77);
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(955); match(23);
				setState(956); expression(0);
				setState(957); match(77);
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(959); match(57);
				setState(961);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(960); match(Identifier);
					}
				}

				setState(963); match(77);
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(964); match(8);
				setState(966);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(965); match(Identifier);
					}
				}

				setState(968); match(77);
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(969); match(77);
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(970); statementExpression();
				setState(971); match(77);
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(973); match(Identifier);
				setState(974); match(46);
				setState(975); statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchesContext extends ParserRuleContext {
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public CatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitCatches(this);
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978); catchClause();
			setState(982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==64) {
				{
				{
				setState(979); catchClause();
				}
				}
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchClauseContext extends ParserRuleContext {
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(985); match(64);
			setState(986); match(45);
			setState(987); formalParameter();
			setState(988); match(22);
			setState(989); block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
			return getRuleContext(VariableModifiersContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991); variableModifiers();
			setState(992); type();
			setState(993); variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupsContext extends ParserRuleContext {
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroups; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterSwitchBlockStatementGroups(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitSwitchBlockStatementGroups(this);
		}
	}

	public final SwitchBlockStatementGroupsContext switchBlockStatementGroups() throws RecognitionException {
		SwitchBlockStatementGroupsContext _localctx = new SwitchBlockStatementGroupsContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_switchBlockStatementGroups);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(995); switchBlockStatementGroup();
					}
					} 
				}
				setState(1000);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			}
			setState(1004);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==17 || _la==40) {
				{
				{
				setState(1001); switchLabel();
				}
				}
				setState(1006);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitSwitchBlockStatementGroup(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1007); switchLabel();
				}
				}
				setState(1010); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==17 || _la==40 );
			setState(1013); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1012); blockStatement();
				}
				}
				setState(1015); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 8) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 19) | (1L << 23) | (1L << 24) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 41) | (1L << 43) | (1L << 44) | (1L << 45) | (1L << 47) | (1L << 49) | (1L << 52) | (1L << 53) | (1L << 56) | (1L << 57) | (1L << 62))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (74 - 65)) | (1L << (75 - 65)) | (1L << (77 - 65)) | (1L << (79 - 65)) | (1L << (84 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (ASSERT - 65)) | (1L << (Identifier - 65)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchLabelContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitSwitchLabel(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_switchLabel);
		try {
			setState(1027);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1017); match(17);
				setState(1018); constantExpression();
				setState(1019); match(46);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1021); match(17);
				setState(1022); enumConstantName();
				setState(1023); match(46);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1025); match(40);
				setState(1026); match(46);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForControlContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitForControl(this);
		}
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_forControl);
		int _la;
		try {
			setState(1041);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1029); enhancedForControl();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1031);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 24) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53) | (1L << 62))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(1030); forInit();
					}
				}

				setState(1033); match(77);
				setState(1035);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(1034); expression(0);
					}
				}

				setState(1037); match(77);
				setState(1039);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
					{
					setState(1038); forUpdate();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_forInit);
		try {
			setState(1045);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1043); localVariableDeclaration();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1044); expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnhancedForControlContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableModifiersContext variableModifiers() {
			return getRuleContext(VariableModifiersContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterEnhancedForControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitEnhancedForControl(this);
		}
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_enhancedForControl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047); variableModifiers();
			setState(1048); type();
			setState(1049); match(Identifier);
			setState(1050); match(46);
			setState(1051); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1053); expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitParExpression(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1055); match(45);
			setState(1056); expression(0);
			setState(1057); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1059); expression(0);
			setState(1064);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(1060); match(42);
				setState(1061); expression(0);
				}
				}
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitStatementExpression(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_statementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1067); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1069); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public int _p;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressionContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState, _p);
		ExpressionContext _prevctx = _localctx;
		int _startState = 206;
		enterRecursionRule(_localctx, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1072);
				_la = _input.LA(1);
				if ( !(_la==6 || _la==44 || _la==67 || _la==72) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1073); expression(17);
				}
				break;

			case 2:
				{
				setState(1074);
				_la = _input.LA(1);
				if ( !(_la==34 || _la==88) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(1075); expression(16);
				}
				break;

			case 3:
				{
				setState(1076); match(45);
				setState(1077); type();
				setState(1078); match(22);
				setState(1079); expression(15);
				}
				break;

			case 4:
				{
				setState(1081); primary();
				}
				break;

			case 5:
				{
				setState(1082); match(29);
				setState(1083); creator();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1210);
					switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1086);
						if (!(13 >= _localctx._p)) throw new FailedPredicateException(this, "13 >= $_p");
						setState(1087);
						_la = _input.LA(1);
						if ( !(_la==3 || _la==20 || _la==86) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1088); expression(14);
						}
						break;

					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1089);
						if (!(12 >= _localctx._p)) throw new FailedPredicateException(this, "12 >= $_p");
						setState(1090);
						_la = _input.LA(1);
						if ( !(_la==44 || _la==72) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1091); expression(13);
						}
						break;

					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1092);
						if (!(11 >= _localctx._p)) throw new FailedPredicateException(this, "11 >= $_p");
						setState(1100);
						switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
						case 1:
							{
							setState(1093); match(5);
							setState(1094); match(5);
							}
							break;

						case 2:
							{
							setState(1095); match(81);
							setState(1096); match(81);
							setState(1097); match(81);
							}
							break;

						case 3:
							{
							setState(1098); match(81);
							setState(1099); match(81);
							}
							break;
						}
						setState(1102); expression(12);
						}
						break;

					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1103);
						if (!(10 >= _localctx._p)) throw new FailedPredicateException(this, "10 >= $_p");
						setState(1110);
						switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
						case 1:
							{
							setState(1104); match(5);
							setState(1105); match(25);
							}
							break;

						case 2:
							{
							setState(1106); match(81);
							setState(1107); match(25);
							}
							break;

						case 3:
							{
							setState(1108); match(81);
							}
							break;

						case 4:
							{
							setState(1109); match(5);
							}
							break;
						}
						setState(1112); expression(11);
						}
						break;

					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1113);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(1114);
						_la = _input.LA(1);
						if ( !(_la==9 || _la==87) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(1115); expression(9);
						}
						break;

					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1116);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(1117); match(2);
						setState(1118); expression(8);
						}
						break;

					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1119);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(1120); match(70);
						setState(1121); expression(7);
						}
						break;

					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1122);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(1123); match(32);
						setState(1124); expression(6);
						}
						break;

					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1125);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(1126); match(78);
						setState(1127); expression(5);
						}
						break;

					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1128);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(1129); match(80);
						setState(1130); expression(4);
						}
						break;

					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1131);
						if (!(1 >= _localctx._p)) throw new FailedPredicateException(this, "1 >= $_p");
						setState(1151);
						switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
						case 1:
							{
							setState(1132); match(61);
							}
							break;

						case 2:
							{
							setState(1133); match(59);
							}
							break;

						case 3:
							{
							setState(1134); match(38);
							}
							break;

						case 4:
							{
							setState(1135); match(21);
							}
							break;

						case 5:
							{
							setState(1136); match(85);
							}
							break;

						case 6:
							{
							setState(1137); match(48);
							}
							break;

						case 7:
							{
							setState(1138); match(28);
							}
							break;

						case 8:
							{
							setState(1139); match(25);
							}
							break;

						case 9:
							{
							setState(1140); match(81);
							setState(1141); match(81);
							setState(1142); match(25);
							}
							break;

						case 10:
							{
							setState(1143); match(81);
							setState(1144); match(81);
							setState(1145); match(81);
							setState(1146); match(25);
							}
							break;

						case 11:
							{
							setState(1147); match(5);
							setState(1148); match(5);
							setState(1149); match(25);
							}
							break;

						case 12:
							{
							setState(1150); match(83);
							}
							break;
						}
						setState(1153); expression(1);
						}
						break;

					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1154);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(1155); match(51);
						setState(1156); expression(0);
						setState(1157); match(46);
						setState(1158); expression(3);
						}
						break;

					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1160);
						if (!(26 >= _localctx._p)) throw new FailedPredicateException(this, "26 >= $_p");
						setState(1161); match(71);
						setState(1162); match(Identifier);
						}
						break;

					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1163);
						if (!(25 >= _localctx._p)) throw new FailedPredicateException(this, "25 >= $_p");
						setState(1164); match(71);
						setState(1165); match(79);
						}
						break;

					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1166);
						if (!(24 >= _localctx._p)) throw new FailedPredicateException(this, "24 >= $_p");
						setState(1167); match(71);
						setState(1168); match(18);
						setState(1169); match(45);
						setState(1171);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(1170); expressionList();
							}
						}

						setState(1173); match(22);
						}
						break;

					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1174);
						if (!(23 >= _localctx._p)) throw new FailedPredicateException(this, "23 >= $_p");
						setState(1175); match(71);
						setState(1176); match(29);
						setState(1177); match(Identifier);
						setState(1178); match(45);
						setState(1180);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(1179); expressionList();
							}
						}

						setState(1182); match(22);
						}
						break;

					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1183);
						if (!(22 >= _localctx._p)) throw new FailedPredicateException(this, "22 >= $_p");
						setState(1184); match(71);
						setState(1185); match(18);
						setState(1186); match(71);
						setState(1187); match(Identifier);
						setState(1189);
						switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
						case 1:
							{
							setState(1188); arguments();
							}
							break;
						}
						}
						break;

					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1191);
						if (!(21 >= _localctx._p)) throw new FailedPredicateException(this, "21 >= $_p");
						setState(1192); match(71);
						setState(1193); explicitGenericInvocation();
						}
						break;

					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1194);
						if (!(20 >= _localctx._p)) throw new FailedPredicateException(this, "20 >= $_p");
						setState(1195); match(4);
						setState(1196); expression(0);
						setState(1197); match(37);
						}
						break;

					case 20:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1199);
						if (!(19 >= _localctx._p)) throw new FailedPredicateException(this, "19 >= $_p");
						setState(1200); match(45);
						setState(1202);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
							{
							setState(1201); expressionList();
							}
						}

						setState(1204); match(22);
						}
						break;

					case 21:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1205);
						if (!(18 >= _localctx._p)) throw new FailedPredicateException(this, "18 >= $_p");
						setState(1206);
						_la = _input.LA(1);
						if ( !(_la==6 || _la==67) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
						break;

					case 22:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState, _p);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1207);
						if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
						setState(1208); match(89);
						setState(1209); type();
						}
						break;
					}
					} 
				}
				setState(1214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_primary);
		try {
			setState(1230);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1215); match(45);
				setState(1216); expression(0);
				setState(1217); match(22);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1219); match(79);
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1220); match(18);
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1221); literal();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1222); match(Identifier);
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1223); type();
				setState(1224); match(71);
				setState(1225); match(30);
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1227); match(53);
				setState(1228); match(71);
				setState(1229); match(30);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitCreator(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_creator);
		try {
			setState(1241);
			switch (_input.LA(1)) {
			case 5:
				enterOuterAlt(_localctx, 1);
				{
				setState(1232); nonWildcardTypeArguments();
				setState(1233); createdName();
				setState(1234); classCreatorRest();
				}
				break;
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1236); createdName();
				setState(1239);
				switch (_input.LA(1)) {
				case 4:
					{
					setState(1237); arrayCreatorRest();
					}
					break;
				case 45:
					{
					setState(1238); classCreatorRest();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatedNameContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterCreatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitCreatedName(this);
		}
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_createdName);
		try {
			setState(1245);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1243); classOrInterfaceType();
				}
				break;
			case 10:
			case 12:
			case 14:
			case 15:
			case 35:
			case 36:
			case 49:
			case 69:
				enterOuterAlt(_localctx, 2);
				{
				setState(1244); primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InnerCreatorContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterInnerCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitInnerCreator(this);
		}
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1248);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(1247); nonWildcardTypeArguments();
				}
			}

			setState(1250); match(Identifier);
			setState(1251); classCreatorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(DataModelerParser.Identifier, 0); }
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterExplicitGenericInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitExplicitGenericInvocation(this);
		}
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1253); nonWildcardTypeArguments();
			setState(1254); match(Identifier);
			setState(1255); arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterArrayCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitArrayCreatorRest(this);
		}
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1257); match(4);
			setState(1285);
			switch (_input.LA(1)) {
			case 37:
				{
				setState(1258); match(37);
				setState(1263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==4) {
					{
					{
					setState(1259); match(4);
					setState(1260); match(37);
					}
					}
					setState(1265);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1266); arrayInitializer();
				}
				break;
			case 6:
			case 7:
			case 10:
			case 12:
			case 14:
			case 15:
			case 18:
			case 26:
			case 29:
			case 34:
			case 35:
			case 36:
			case 44:
			case 45:
			case 49:
			case 53:
			case 65:
			case 67:
			case 69:
			case 72:
			case 79:
			case 88:
			case HexLiteral:
			case DecimalLiteral:
			case OctalLiteral:
			case FloatingPointLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case Identifier:
				{
				setState(1267); expression(0);
				setState(1268); match(37);
				setState(1275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1269); match(4);
						setState(1270); expression(0);
						setState(1271); match(37);
						}
						} 
					}
					setState(1277);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				setState(1282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(1278); match(4);
						setState(1279); match(37);
						}
						} 
					}
					setState(1284);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterClassCreatorRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitClassCreatorRest(this);
		}
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1287); arguments();
			setState(1289);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1288); classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterNonWildcardTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitNonWildcardTypeArguments(this);
		}
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1291); match(5);
			setState(1292); typeList();
			setState(1293); match(81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataModelerListener ) ((DataModelerListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1295); match(45);
			setState(1297);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 6) | (1L << 7) | (1L << 10) | (1L << 12) | (1L << 14) | (1L << 15) | (1L << 18) | (1L << 26) | (1L << 29) | (1L << 34) | (1L << 35) | (1L << 36) | (1L << 44) | (1L << 45) | (1L << 49) | (1L << 53))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (65 - 65)) | (1L << (67 - 65)) | (1L << (69 - 65)) | (1L << (72 - 65)) | (1L << (79 - 65)) | (1L << (88 - 65)) | (1L << (HexLiteral - 65)) | (1L << (DecimalLiteral - 65)) | (1L << (OctalLiteral - 65)) | (1L << (FloatingPointLiteral - 65)) | (1L << (CharacterLiteral - 65)) | (1L << (StringLiteral - 65)) | (1L << (Identifier - 65)))) != 0)) {
				{
				setState(1296); expressionList();
				}
			}

			setState(1299); match(22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 103: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 13 >= _localctx._p;

		case 1: return 12 >= _localctx._p;

		case 2: return 11 >= _localctx._p;

		case 3: return 10 >= _localctx._p;

		case 4: return 8 >= _localctx._p;

		case 5: return 7 >= _localctx._p;

		case 6: return 6 >= _localctx._p;

		case 7: return 5 >= _localctx._p;

		case 8: return 4 >= _localctx._p;

		case 9: return 3 >= _localctx._p;

		case 10: return 1 >= _localctx._p;

		case 11: return 2 >= _localctx._p;

		case 12: return 26 >= _localctx._p;

		case 13: return 25 >= _localctx._p;

		case 14: return 24 >= _localctx._p;

		case 15: return 23 >= _localctx._p;

		case 17: return 21 >= _localctx._p;

		case 16: return 22 >= _localctx._p;

		case 19: return 19 >= _localctx._p;

		case 18: return 20 >= _localctx._p;

		case 21: return 9 >= _localctx._p;

		case 20: return 18 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\2\3g\u0518\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4"+
		")\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62"+
		"\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4"+
		";\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\t"+
		"F\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4"+
		"R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]"+
		"\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th"+
		"\4i\ti\4j\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\3\2\3\2\3"+
		"\2\7\2\u00e8\n\2\f\2\16\2\u00eb\13\2\3\2\3\2\3\2\3\2\5\2\u00f1\n\2\3\2"+
		"\7\2\u00f4\n\2\f\2\16\2\u00f7\13\2\3\2\3\2\3\2\5\2\u00fc\n\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\5\4\u0104\n\4\3\4\3\4\3\4\5\4\u0109\n\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\7\6\u0111\n\6\f\6\16\6\u0114\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7\u011e\n\7\3\b\7\b\u0121\n\b\f\b\16\b\u0124\13\b\3\t\3\t\3\n\3"+
		"\n\3\n\5\n\u012b\n\n\3\n\3\n\5\n\u012f\n\n\3\n\3\n\5\n\u0133\n\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\7\13\u013b\n\13\f\13\16\13\u013e\13\13\3\13\3\13"+
		"\3\f\3\f\3\f\5\f\u0145\n\f\3\r\3\r\3\r\7\r\u014a\n\r\f\r\16\r\u014d\13"+
		"\r\3\16\3\16\3\16\3\16\5\16\u0153\n\16\3\16\3\16\3\17\3\17\5\17\u0159"+
		"\n\17\3\17\5\17\u015c\n\17\3\17\5\17\u015f\n\17\3\17\3\17\3\20\3\20\3"+
		"\20\7\20\u0166\n\20\f\20\16\20\u0169\13\20\3\21\5\21\u016c\n\21\3\21\3"+
		"\21\5\21\u0170\n\21\3\21\5\21\u0173\n\21\3\22\3\22\7\22\u0177\n\22\f\22"+
		"\16\22\u017a\13\22\3\23\3\23\5\23\u017e\n\23\3\24\3\24\3\24\5\24\u0183"+
		"\n\24\3\24\3\24\5\24\u0187\n\24\3\24\3\24\3\25\3\25\3\25\7\25\u018e\n"+
		"\25\f\25\16\25\u0191\13\25\3\26\3\26\7\26\u0195\n\26\f\26\16\26\u0198"+
		"\13\26\3\26\3\26\3\27\3\27\7\27\u019e\n\27\f\27\16\27\u01a1\13\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\5\30\u01a9\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u01b2\n\31\3\32\3\32\3\32\5\32\u01b7\n\32\3\33\3\33\3\33\3"+
		"\34\3\34\5\34\u01be\n\34\3\34\3\34\3\34\3\34\5\34\u01c4\n\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\5\37\u01d0\n\37\3 \3 \3 \3 \3"+
		" \3 \3 \5 \u01d9\n \3!\3!\3!\3!\3\"\3\"\3\"\3\"\5\"\u01e3\n\"\3#\3#\3"+
		"#\7#\u01e8\n#\f#\16#\u01eb\13#\3#\3#\5#\u01ef\n#\3#\3#\5#\u01f3\n#\3$"+
		"\3$\3$\5$\u01f8\n$\3$\3$\5$\u01fc\n$\3%\3%\3%\7%\u0201\n%\f%\16%\u0204"+
		"\13%\3%\3%\5%\u0208\n%\3%\3%\3&\3&\3&\5&\u020f\n&\3&\3&\3&\3\'\3\'\3\'"+
		"\5\'\u0217\n\'\3\'\3\'\3(\3(\3(\5(\u021e\n(\3(\3(\3)\3)\3)\3*\3*\3*\7"+
		"*\u0228\n*\f*\16*\u022b\13*\3+\3+\3+\5+\u0230\n+\3,\3,\3,\7,\u0235\n,"+
		"\f,\16,\u0238\13,\3-\3-\7-\u023c\n-\f-\16-\u023f\13-\3-\3-\3-\3.\3.\3"+
		".\7.\u0247\n.\f.\16.\u024a\13.\3/\3/\5/\u024e\n/\3\60\3\60\3\60\3\60\7"+
		"\60\u0254\n\60\f\60\16\60\u0257\13\60\3\60\5\60\u025a\n\60\5\60\u025c"+
		"\n\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\5\61\u026c\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65"+
		"\u0277\n\65\f\65\16\65\u027a\13\65\3\65\3\65\3\65\7\65\u027f\n\65\f\65"+
		"\16\65\u0282\13\65\5\65\u0284\n\65\3\66\3\66\5\66\u0288\n\66\3\66\3\66"+
		"\3\66\5\66\u028d\n\66\7\66\u028f\n\66\f\66\16\66\u0292\13\66\3\67\3\67"+
		"\38\38\58\u0298\n8\39\39\39\39\79\u029e\n9\f9\169\u02a1\139\39\39\3:\3"+
		":\3:\3:\5:\u02a9\n:\5:\u02ab\n:\3;\3;\3;\7;\u02b0\n;\f;\16;\u02b3\13;"+
		"\3<\3<\5<\u02b7\n<\3<\3<\3=\3=\3=\3=\3>\3>\3>\5>\u02c2\n>\3>\3>\5>\u02c6"+
		"\n>\3?\3?\3@\3@\5@\u02cc\n@\3@\7@\u02cf\n@\f@\16@\u02d2\13@\3@\3@\3A\5"+
		"A\u02d7\nA\3A\3A\3A\3A\3A\3A\3A\5A\u02e0\nA\3A\3A\3A\3A\5A\u02e6\nA\3"+
		"B\3B\3B\7B\u02eb\nB\fB\16B\u02ee\13B\3C\3C\3C\3C\3C\3C\5C\u02f6\nC\3D"+
		"\3D\3E\3E\3F\6F\u02fd\nF\rF\16F\u02fe\3G\3G\3G\3G\3G\5G\u0306\nG\3G\5"+
		"G\u0309\nG\3H\3H\3H\7H\u030e\nH\fH\16H\u0311\13H\3I\3I\3I\7I\u0316\nI"+
		"\fI\16I\u0319\13I\3J\3J\3J\3J\3K\3K\3K\5K\u0322\nK\3L\3L\3L\3L\7L\u0328"+
		"\nL\fL\16L\u032b\13L\5L\u032d\nL\3L\5L\u0330\nL\3L\3L\3M\3M\3M\3M\3M\3"+
		"N\3N\7N\u033b\nN\fN\16N\u033e\13N\3N\3N\3O\3O\3O\3P\3P\3P\3P\3P\3P\5P"+
		"\u034b\nP\3P\3P\5P\u034f\nP\3P\3P\5P\u0353\nP\3P\3P\5P\u0357\nP\5P\u0359"+
		"\nP\3Q\3Q\5Q\u035d\nQ\3R\3R\3R\3R\5R\u0363\nR\3S\3S\3T\3T\3T\3U\3U\7U"+
		"\u036c\nU\fU\16U\u036f\13U\3U\3U\3V\3V\5V\u0375\nV\3W\3W\3W\3X\3X\3X\3"+
		"X\3Y\7Y\u037f\nY\fY\16Y\u0382\13Y\3Z\3Z\3Z\3Z\3Z\5Z\u0389\nZ\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3Z\5Z\u0392\nZ\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u03a9\nZ\3Z\3Z\5Z\u03ad\nZ\3Z\3Z\3Z\3Z\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3Z\3Z\5Z\u03bb\nZ\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u03c4\nZ\3Z\3Z\3Z"+
		"\5Z\u03c9\nZ\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u03d3\nZ\3[\3[\7[\u03d7\n[\f["+
		"\16[\u03da\13[\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3^\7^\u03e7\n^\f^\16"+
		"^\u03ea\13^\3^\7^\u03ed\n^\f^\16^\u03f0\13^\3_\6_\u03f3\n_\r_\16_\u03f4"+
		"\3_\6_\u03f8\n_\r_\16_\u03f9\3`\3`\3`\3`\3`\3`\3`\3`\3`\3`\5`\u0406\n"+
		"`\3a\3a\5a\u040a\na\3a\3a\5a\u040e\na\3a\3a\5a\u0412\na\5a\u0414\na\3"+
		"b\3b\5b\u0418\nb\3c\3c\3c\3c\3c\3c\3d\3d\3e\3e\3e\3e\3f\3f\3f\7f\u0429"+
		"\nf\ff\16f\u042c\13f\3g\3g\3h\3h\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3"+
		"i\5i\u043f\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\5i\u044f\ni\3"+
		"i\3i\3i\3i\3i\3i\3i\3i\5i\u0459\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3"+
		"i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3"+
		"i\3i\3i\3i\3i\5i\u0482\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3"+
		"i\3i\3i\3i\5i\u0496\ni\3i\3i\3i\3i\3i\3i\3i\5i\u049f\ni\3i\3i\3i\3i\3"+
		"i\3i\3i\5i\u04a8\ni\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\5i\u04b5\ni\3i\3"+
		"i\3i\3i\3i\3i\7i\u04bd\ni\fi\16i\u04c0\13i\3j\3j\3j\3j\3j\3j\3j\3j\3j"+
		"\3j\3j\3j\3j\3j\3j\5j\u04d1\nj\3k\3k\3k\3k\3k\3k\3k\5k\u04da\nk\5k\u04dc"+
		"\nk\3l\3l\5l\u04e0\nl\3m\5m\u04e3\nm\3m\3m\3m\3n\3n\3n\3n\3o\3o\3o\3o"+
		"\7o\u04f0\no\fo\16o\u04f3\13o\3o\3o\3o\3o\3o\3o\3o\7o\u04fc\no\fo\16o"+
		"\u04ff\13o\3o\3o\7o\u0503\no\fo\16o\u0506\13o\5o\u0508\no\3p\3p\5p\u050c"+
		"\np\3q\3q\3q\3q\3r\3r\5r\u0514\nr\3r\3r\3r\2s\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\2\r\b\f\f\16\16\20\21%&\63\63GG\4\24\24>>\4\24\24Q"+
		"Q\3\\^\4\t\tCC\6\b\b..EEJJ\4$$ZZ\5\5\5\26\26XX\4..JJ\4\13\13YY\4\b\bE"+
		"E\u0588\2\u00fb\3\2\2\2\4\u00fd\3\2\2\2\6\u0101\3\2\2\2\b\u010c\3\2\2"+
		"\2\n\u0112\3\2\2\2\f\u011d\3\2\2\2\16\u0122\3\2\2\2\20\u0125\3\2\2\2\22"+
		"\u0127\3\2\2\2\24\u0136\3\2\2\2\26\u0141\3\2\2\2\30\u0146\3\2\2\2\32\u014e"+
		"\3\2\2\2\34\u0156\3\2\2\2\36\u0162\3\2\2\2 \u016b\3\2\2\2\"\u0174\3\2"+
		"\2\2$\u017d\3\2\2\2&\u017f\3\2\2\2(\u018a\3\2\2\2*\u0192\3\2\2\2,\u019b"+
		"\3\2\2\2.\u01a8\3\2\2\2\60\u01b1\3\2\2\2\62\u01b3\3\2\2\2\64\u01b8\3\2"+
		"\2\2\66\u01c3\3\2\2\28\u01c5\3\2\2\2:\u01c8\3\2\2\2<\u01cf\3\2\2\2>\u01d8"+
		"\3\2\2\2@\u01da\3\2\2\2B\u01e2\3\2\2\2D\u01e4\3\2\2\2F\u01f4\3\2\2\2H"+
		"\u01fd\3\2\2\2J\u020b\3\2\2\2L\u0213\3\2\2\2N\u021a\3\2\2\2P\u0221\3\2"+
		"\2\2R\u0224\3\2\2\2T\u022c\3\2\2\2V\u0231\3\2\2\2X\u023d\3\2\2\2Z\u0243"+
		"\3\2\2\2\\\u024d\3\2\2\2^\u024f\3\2\2\2`\u026b\3\2\2\2b\u026d\3\2\2\2"+
		"d\u026f\3\2\2\2f\u0271\3\2\2\2h\u0283\3\2\2\2j\u0285\3\2\2\2l\u0293\3"+
		"\2\2\2n\u0297\3\2\2\2p\u0299\3\2\2\2r\u02aa\3\2\2\2t\u02ac\3\2\2\2v\u02b4"+
		"\3\2\2\2x\u02ba\3\2\2\2z\u02c5\3\2\2\2|\u02c7\3\2\2\2~\u02c9\3\2\2\2\u0080"+
		"\u02e5\3\2\2\2\u0082\u02e7\3\2\2\2\u0084\u02f5\3\2\2\2\u0086\u02f7\3\2"+
		"\2\2\u0088\u02f9\3\2\2\2\u008a\u02fc\3\2\2\2\u008c\u0300\3\2\2\2\u008e"+
		"\u030a\3\2\2\2\u0090\u0312\3\2\2\2\u0092\u031a\3\2\2\2\u0094\u0321\3\2"+
		"\2\2\u0096\u0323\3\2\2\2\u0098\u0333\3\2\2\2\u009a\u0338\3\2\2\2\u009c"+
		"\u0341\3\2\2\2\u009e\u0358\3\2\2\2\u00a0\u035c\3\2\2\2\u00a2\u035e\3\2"+
		"\2\2\u00a4\u0364\3\2\2\2\u00a6\u0366\3\2\2\2\u00a8\u0369\3\2\2\2\u00aa"+
		"\u0374\3\2\2\2\u00ac\u0376\3\2\2\2\u00ae\u0379\3\2\2\2\u00b0\u0380\3\2"+
		"\2\2\u00b2\u03d2\3\2\2\2\u00b4\u03d4\3\2\2\2\u00b6\u03db\3\2\2\2\u00b8"+
		"\u03e1\3\2\2\2\u00ba\u03e8\3\2\2\2\u00bc\u03f2\3\2\2\2\u00be\u0405\3\2"+
		"\2\2\u00c0\u0413\3\2\2\2\u00c2\u0417\3\2\2\2\u00c4\u0419\3\2\2\2\u00c6"+
		"\u041f\3\2\2\2\u00c8\u0421\3\2\2\2\u00ca\u0425\3\2\2\2\u00cc\u042d\3\2"+
		"\2\2\u00ce\u042f\3\2\2\2\u00d0\u043e\3\2\2\2\u00d2\u04d0\3\2\2\2\u00d4"+
		"\u04db\3\2\2\2\u00d6\u04df\3\2\2\2\u00d8\u04e2\3\2\2\2\u00da\u04e7\3\2"+
		"\2\2\u00dc\u04eb\3\2\2\2\u00de\u0509\3\2\2\2\u00e0\u050d\3\2\2\2\u00e2"+
		"\u0511\3\2\2\2\u00e4\u00e5\5\u008aF\2\u00e5\u00ed\5\4\3\2\u00e6\u00e8"+
		"\5\6\4\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00f0\5\b"+
		"\5\2\u00ed\u00ee\7\1\2\2\u00ee\u00fc\3\2\2\2\u00ef\u00f1\5\4\3\2\u00f0"+
		"\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\5\6"+
		"\4\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\5\b"+
		"\5\2\u00f9\u00fa\7\1\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00e4\3\2\2\2\u00fb"+
		"\u00f0\3\2\2\2\u00fc\3\3\2\2\2\u00fd\u00fe\78\2\2\u00fe\u00ff\5\u0082"+
		"B\2\u00ff\u0100\7O\2\2\u0100\5\3\2\2\2\u0101\u0103\7F\2\2\u0102\u0104"+
		"\7D\2\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"\u0108\5\u0082B\2\u0106\u0107\7I\2\2\u0107\u0109\7\5\2\2\u0108\u0106\3"+
		"\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7O\2\2\u010b"+
		"\7\3\2\2\2\u010c\u010d\5\n\6\2\u010d\u010e\5\20\t\2\u010e\t\3\2\2\2\u010f"+
		"\u0111\5\f\7\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0112\u0113\3\2\2\2\u0113\13\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u011e"+
		"\5\u008cG\2\u0116\u011e\7)\2\2\u0117\u011e\7K\2\2\u0118\u011e\7\64\2\2"+
		"\u0119\u011e\7\r\2\2\u011a\u011e\7D\2\2\u011b\u011e\7@\2\2\u011c\u011e"+
		"\7\22\2\2\u011d\u0115\3\2\2\2\u011d\u0116\3\2\2\2\u011d\u0117\3\2\2\2"+
		"\u011d\u0118\3\2\2\2\u011d\u0119\3\2\2\2\u011d\u011a\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011c\3\2\2\2\u011e\r\3\2\2\2\u011f\u0121\5`\61\2\u0120"+
		"\u011f\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\17\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\5\22\n\2\u0126\21"+
		"\3\2\2\2\u0127\u0128\7 \2\2\u0128\u012a\7d\2\2\u0129\u012b\5\24\13\2\u012a"+
		"\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012d\7>"+
		"\2\2\u012d\u012f\5h\65\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u0131\7T\2\2\u0131\u0133\5(\25\2\u0132\u0130\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\5*\26\2\u0135"+
		"\23\3\2\2\2\u0136\u0137\7\7\2\2\u0137\u013c\5\26\f\2\u0138\u0139\7,\2"+
		"\2\u0139\u013b\5\26\f\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2"+
		"\2\2\u013f\u0140\7S\2\2\u0140\25\3\2\2\2\u0141\u0144\7d\2\2\u0142\u0143"+
		"\7>\2\2\u0143\u0145\5\30\r\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\27\3\2\2\2\u0146\u014b\5h\65\2\u0147\u0148\7\4\2\2\u0148\u014a\5h\65"+
		"\2\u0149\u0147\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\31\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\7b\2\2\u014f"+
		"\u0152\7d\2\2\u0150\u0151\7T\2\2\u0151\u0153\5(\25\2\u0152\u0150\3\2\2"+
		"\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\5\34\17\2\u0155"+
		"\33\3\2\2\2\u0156\u0158\7:\2\2\u0157\u0159\5\36\20\2\u0158\u0157\3\2\2"+
		"\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u015c\7,\2\2\u015b\u015a"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015f\5\"\22\2"+
		"\u015e\u015d\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\7\17\2\2\u0161\35\3\2\2\2\u0162\u0167\5 \21\2\u0163\u0164\7,\2\2\u0164"+
		"\u0166\5 \21\2\u0165\u0163\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2"+
		"\2\2\u0167\u0168\3\2\2\2\u0168\37\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c"+
		"\5\u008aF\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2"+
		"\2\u016d\u016f\7d\2\2\u016e\u0170\5\u00e2r\2\u016f\u016e\3\2\2\2\u016f"+
		"\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\5*\26\2\u0172\u0171\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173!\3\2\2\2\u0174\u0178\7O\2\2\u0175\u0177"+
		"\5.\30\2\u0176\u0175\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179#\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017e\5&\24\2"+
		"\u017c\u017e\5\u0098M\2\u017d\u017b\3\2\2\2\u017d\u017c\3\2\2\2\u017e"+
		"%\3\2\2\2\u017f\u0180\7\3\2\2\u0180\u0182\7d\2\2\u0181\u0183\5\24\13\2"+
		"\u0182\u0181\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0185"+
		"\7>\2\2\u0185\u0187\5(\25\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u0189\5,\27\2\u0189\'\3\2\2\2\u018a\u018f\5h\65\2"+
		"\u018b\u018c\7,\2\2\u018c\u018e\5h\65\2\u018d\u018b\3\2\2\2\u018e\u0191"+
		"\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190)\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0196\7:\2\2\u0193\u0195\5.\30\2\u0194\u0193\3\2"+
		"\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\7\17\2\2\u019a+\3\2\2\2"+
		"\u019b\u019f\7:\2\2\u019c\u019e\5<\37\2\u019d\u019c\3\2\2\2\u019e\u01a1"+
		"\3\2\2\2\u019f\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a2\u01a3\7\17\2\2\u01a3-\3\2\2\2\u01a4\u01a9\7O\2\2"+
		"\u01a5\u01a6\5\16\b\2\u01a6\u01a7\5\60\31\2\u01a7\u01a9\3\2\2\2\u01a8"+
		"\u01a4\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a9/\3\2\2\2\u01aa\u01b2\5\64\33"+
		"\2\u01ab\u01b2\5\62\32\2\u01ac\u01ad\7\67\2\2\u01ad\u01ae\7d\2\2\u01ae"+
		"\u01b2\5F$\2\u01af\u01b0\7d\2\2\u01b0\u01b2\5N(\2\u01b1\u01aa\3\2\2\2"+
		"\u01b1\u01ab\3\2\2\2\u01b1\u01ac\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\61"+
		"\3\2\2\2\u01b3\u01b6\5h\65\2\u01b4\u01b7\58\35\2\u01b5\u01b7\5:\36\2\u01b6"+
		"\u01b4\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7\63\3\2\2\2\u01b8\u01b9\5\24\13"+
		"\2\u01b9\u01ba\5\66\34\2\u01ba\65\3\2\2\2\u01bb\u01be\5h\65\2\u01bc\u01be"+
		"\7\67\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2"+
		"\u01bf\u01c0\7d\2\2\u01c0\u01c4\5D#\2\u01c1\u01c2\7d\2\2\u01c2\u01c4\5"+
		"N(\2\u01c3\u01bd\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\67\3\2\2\2\u01c5\u01c6"+
		"\7d\2\2\u01c6\u01c7\5D#\2\u01c79\3\2\2\2\u01c8\u01c9\5R*\2\u01c9\u01ca"+
		"\7O\2\2\u01ca;\3\2\2\2\u01cb\u01cc\5\16\b\2\u01cc\u01cd\5> \2\u01cd\u01d0"+
		"\3\2\2\2\u01ce\u01d0\7O\2\2\u01cf\u01cb\3\2\2\2\u01cf\u01ce\3\2\2\2\u01d0"+
		"=\3\2\2\2\u01d1\u01d9\5@!\2\u01d2\u01d9\5J&\2\u01d3\u01d4\7\67\2\2\u01d4"+
		"\u01d5\7d\2\2\u01d5\u01d9\5L\'\2\u01d6\u01d9\5$\23\2\u01d7\u01d9\5\20"+
		"\t\2\u01d8\u01d1\3\2\2\2\u01d8\u01d2\3\2\2\2\u01d8\u01d3\3\2\2\2\u01d8"+
		"\u01d6\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9?\3\2\2\2\u01da\u01db\5h\65\2"+
		"\u01db\u01dc\7d\2\2\u01dc\u01dd\5B\"\2\u01ddA\3\2\2\2\u01de\u01df\5V,"+
		"\2\u01df\u01e0\7O\2\2\u01e0\u01e3\3\2\2\2\u01e1\u01e3\5H%\2\u01e2\u01de"+
		"\3\2\2\2\u01e2\u01e1\3\2\2\2\u01e3C\3\2\2\2\u01e4\u01e9\5v<\2\u01e5\u01e6"+
		"\7\6\2\2\u01e6\u01e8\7\'\2\2\u01e7\u01e5\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9"+
		"\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ee\3\2\2\2\u01eb\u01e9\3\2"+
		"\2\2\u01ec\u01ed\7\35\2\2\u01ed\u01ef\5t;\2\u01ee\u01ec\3\2\2\2\u01ee"+
		"\u01ef\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01f3\5|?\2\u01f1\u01f3\7O\2"+
		"\2\u01f2\u01f0\3\2\2\2\u01f2\u01f1\3\2\2\2\u01f3E\3\2\2\2\u01f4\u01f7"+
		"\5v<\2\u01f5\u01f6\7\35\2\2\u01f6\u01f8\5t;\2\u01f7\u01f5\3\2\2\2\u01f7"+
		"\u01f8\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01fc\5|?\2\u01fa\u01fc\7O\2"+
		"\2\u01fb\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fcG\3\2\2\2\u01fd\u0202"+
		"\5v<\2\u01fe\u01ff\7\6\2\2\u01ff\u0201\7\'\2\2\u0200\u01fe\3\2\2\2\u0201"+
		"\u0204\3\2\2\2\u0202\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0207\3\2"+
		"\2\2\u0204\u0202\3\2\2\2\u0205\u0206\7\35\2\2\u0206\u0208\5t;\2\u0207"+
		"\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\7O"+
		"\2\2\u020aI\3\2\2\2\u020b\u020e\5\24\13\2\u020c\u020f\5h\65\2\u020d\u020f"+
		"\7\67\2\2\u020e\u020c\3\2\2\2\u020e\u020d\3\2\2\2\u020f\u0210\3\2\2\2"+
		"\u0210\u0211\7d\2\2\u0211\u0212\5H%\2\u0212K\3\2\2\2\u0213\u0216\5v<\2"+
		"\u0214\u0215\7\35\2\2\u0215\u0217\5t;\2\u0216\u0214\3\2\2\2\u0216\u0217"+
		"\3\2\2\2\u0217\u0218\3\2\2\2\u0218\u0219\7O\2\2\u0219M\3\2\2\2\u021a\u021d"+
		"\5v<\2\u021b\u021c\7\35\2\2\u021c\u021e\5t;\2\u021d\u021b\3\2\2\2\u021d"+
		"\u021e\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u0220\5~@\2\u0220O\3\2\2\2\u0221"+
		"\u0222\7d\2\2\u0222\u0223\5X-\2\u0223Q\3\2\2\2\u0224\u0229\5T+\2\u0225"+
		"\u0226\7,\2\2\u0226\u0228\5T+\2\u0227\u0225\3\2\2\2\u0228\u022b\3\2\2"+
		"\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022aS\3\2\2\2\u022b\u0229"+
		"\3\2\2\2\u022c\u022f\5Z.\2\u022d\u022e\7\33\2\2\u022e\u0230\5\\/\2\u022f"+
		"\u022d\3\2\2\2\u022f\u0230\3\2\2\2\u0230U\3\2\2\2\u0231\u0236\5X-\2\u0232"+
		"\u0233\7,\2\2\u0233\u0235\5P)\2\u0234\u0232\3\2\2\2\u0235\u0238\3\2\2"+
		"\2\u0236\u0234\3\2\2\2\u0236\u0237\3\2\2\2\u0237W\3\2\2\2\u0238\u0236"+
		"\3\2\2\2\u0239\u023a\7\6\2\2\u023a\u023c\7\'\2\2\u023b\u0239\3\2\2\2\u023c"+
		"\u023f\3\2\2\2\u023d\u023b\3\2\2\2\u023d\u023e\3\2\2\2\u023e\u0240\3\2"+
		"\2\2\u023f\u023d\3\2\2\2\u0240\u0241\7\33\2\2\u0241\u0242\5\\/\2\u0242"+
		"Y\3\2\2\2\u0243\u0248\7d\2\2\u0244\u0245\7\6\2\2\u0245\u0247\7\'\2\2\u0246"+
		"\u0244\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2"+
		"\2\2\u0249[\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024e\5^\60\2\u024c\u024e"+
		"\5\u00d0i\2\u024d\u024b\3\2\2\2\u024d\u024c\3\2\2\2\u024e]\3\2\2\2\u024f"+
		"\u025b\7:\2\2\u0250\u0255\5\\/\2\u0251\u0252\7,\2\2\u0252\u0254\5\\/\2"+
		"\u0253\u0251\3\2\2\2\u0254\u0257\3\2\2\2\u0255\u0253\3\2\2\2\u0255\u0256"+
		"\3\2\2\2\u0256\u0259\3\2\2\2\u0257\u0255\3\2\2\2\u0258\u025a\7,\2\2\u0259"+
		"\u0258\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u025c\3\2\2\2\u025b\u0250\3\2"+
		"\2\2\u025b\u025c\3\2\2\2\u025c\u025d\3\2\2\2\u025d\u025e\7\17\2\2\u025e"+
		"_\3\2\2\2\u025f\u026c\5\u008cG\2\u0260\u026c\7)\2\2\u0261\u026c\7K\2\2"+
		"\u0262\u026c\7\64\2\2\u0263\u026c\7D\2\2\u0264\u026c\7\r\2\2\u0265\u026c"+
		"\7@\2\2\u0266\u026c\7<\2\2\u0267\u026c\7+\2\2\u0268\u026c\7#\2\2\u0269"+
		"\u026c\7N\2\2\u026a\u026c\7\22\2\2\u026b\u025f\3\2\2\2\u026b\u0260\3\2"+
		"\2\2\u026b\u0261\3\2\2\2\u026b\u0262\3\2\2\2\u026b\u0263\3\2\2\2\u026b"+
		"\u0264\3\2\2\2\u026b\u0265\3\2\2\2\u026b\u0266\3\2\2\2\u026b\u0267\3\2"+
		"\2\2\u026b\u0268\3\2\2\2\u026b\u0269\3\2\2\2\u026b\u026a\3\2\2\2\u026c"+
		"a\3\2\2\2\u026d\u026e\5\u0082B\2\u026ec\3\2\2\2\u026f\u0270\7d\2\2\u0270"+
		"e\3\2\2\2\u0271\u0272\5\u0082B\2\u0272g\3\2\2\2\u0273\u0278\5j\66\2\u0274"+
		"\u0275\7\6\2\2\u0275\u0277\7\'\2\2\u0276\u0274\3\2\2\2\u0277\u027a\3\2"+
		"\2\2\u0278\u0276\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u0284\3\2\2\2\u027a"+
		"\u0278\3\2\2\2\u027b\u0280\5l\67\2\u027c\u027d\7\6\2\2\u027d\u027f\7\'"+
		"\2\2\u027e\u027c\3\2\2\2\u027f\u0282\3\2\2\2\u0280\u027e\3\2\2\2\u0280"+
		"\u0281\3\2\2\2\u0281\u0284\3\2\2\2\u0282\u0280\3\2\2\2\u0283\u0273\3\2"+
		"\2\2\u0283\u027b\3\2\2\2\u0284i\3\2\2\2\u0285\u0287\7d\2\2\u0286\u0288"+
		"\5p9\2\u0287\u0286\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0290\3\2\2\2\u0289"+
		"\u028a\7I\2\2\u028a\u028c\7d\2\2\u028b\u028d\5p9\2\u028c\u028b\3\2\2\2"+
		"\u028c\u028d\3\2\2\2\u028d\u028f\3\2\2\2\u028e\u0289\3\2\2\2\u028f\u0292"+
		"\3\2\2\2\u0290\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291k\3\2\2\2\u0292"+
		"\u0290\3\2\2\2\u0293\u0294\t\2\2\2\u0294m\3\2\2\2\u0295\u0298\7@\2\2\u0296"+
		"\u0298\5\u008cG\2\u0297\u0295\3\2\2\2\u0297\u0296\3\2\2\2\u0298o\3\2\2"+
		"\2\u0299\u029a\7\7\2\2\u029a\u029f\5r:\2\u029b\u029c\7,\2\2\u029c\u029e"+
		"\5r:\2\u029d\u029b\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u029f"+
		"\u02a0\3\2\2\2\u02a0\u02a2\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2\u02a3\7S"+
		"\2\2\u02a3q\3\2\2\2\u02a4\u02ab\5h\65\2\u02a5\u02a8\7\65\2\2\u02a6\u02a7"+
		"\t\3\2\2\u02a7\u02a9\5h\65\2\u02a8\u02a6\3\2\2\2\u02a8\u02a9\3\2\2\2\u02a9"+
		"\u02ab\3\2\2\2\u02aa\u02a4\3\2\2\2\u02aa\u02a5\3\2\2\2\u02abs\3\2\2\2"+
		"\u02ac\u02b1\5\u0082B\2\u02ad\u02ae\7,\2\2\u02ae\u02b0\5\u0082B\2\u02af"+
		"\u02ad\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2"+
		"\2\2\u02b2u\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b4\u02b6\7/\2\2\u02b5\u02b7"+
		"\5x=\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02b8\3\2\2\2\u02b8"+
		"\u02b9\7\30\2\2\u02b9w\3\2\2\2\u02ba\u02bb\5\u00b0Y\2\u02bb\u02bc\5h\65"+
		"\2\u02bc\u02bd\5z>\2\u02bdy\3\2\2\2\u02be\u02c1\5Z.\2\u02bf\u02c0\7,\2"+
		"\2\u02c0\u02c2\5x=\2\u02c1\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c6"+
		"\3\2\2\2\u02c3\u02c4\79\2\2\u02c4\u02c6\5Z.\2\u02c5\u02be\3\2\2\2\u02c5"+
		"\u02c3\3\2\2\2\u02c6{\3\2\2\2\u02c7\u02c8\5\u00a8U\2\u02c8}\3\2\2\2\u02c9"+
		"\u02cb\7:\2\2\u02ca\u02cc\5\u0080A\2\u02cb\u02ca\3\2\2\2\u02cb\u02cc\3"+
		"\2\2\2\u02cc\u02d0\3\2\2\2\u02cd\u02cf\5\u00aaV\2\u02ce\u02cd\3\2\2\2"+
		"\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d3"+
		"\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d3\u02d4\7\17\2\2\u02d4\177\3\2\2\2\u02d5"+
		"\u02d7\5\u00e0q\2\u02d6\u02d5\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02d8"+
		"\3\2\2\2\u02d8\u02d9\t\4\2\2\u02d9\u02da\5\u00e2r\2\u02da\u02db\7O\2\2"+
		"\u02db\u02e6\3\2\2\2\u02dc\u02dd\5\u00d2j\2\u02dd\u02df\7I\2\2\u02de\u02e0"+
		"\5\u00e0q\2\u02df\u02de\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0\u02e1\3\2\2"+
		"\2\u02e1\u02e2\7\24\2\2\u02e2\u02e3\5\u00e2r\2\u02e3\u02e4\7O\2\2\u02e4"+
		"\u02e6\3\2\2\2\u02e5\u02d6\3\2\2\2\u02e5\u02dc\3\2\2\2\u02e6\u0081\3\2"+
		"\2\2\u02e7\u02ec\7d\2\2\u02e8\u02e9\7I\2\2\u02e9\u02eb\7d\2\2\u02ea\u02e8"+
		"\3\2\2\2\u02eb\u02ee\3\2\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02ed\3\2\2\2\u02ed"+
		"\u0083\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ef\u02f6\5\u0086D\2\u02f0\u02f6"+
		"\7_\2\2\u02f1\u02f6\7`\2\2\u02f2\u02f6\7a\2\2\u02f3\u02f6\5\u0088E\2\u02f4"+
		"\u02f6\7\34\2\2\u02f5\u02ef\3\2\2\2\u02f5\u02f0\3\2\2\2\u02f5\u02f1\3"+
		"\2\2\2\u02f5\u02f2\3\2\2\2\u02f5\u02f3\3\2\2\2\u02f5\u02f4\3\2\2\2\u02f6"+
		"\u0085\3\2\2\2\u02f7\u02f8\t\5\2\2\u02f8\u0087\3\2\2\2\u02f9\u02fa\t\6"+
		"\2\2\u02fa\u0089\3\2\2\2\u02fb\u02fd\5\u008cG\2\u02fc\u02fb\3\2\2\2\u02fd"+
		"\u02fe\3\2\2\2\u02fe\u02fc\3\2\2\2\u02fe\u02ff\3\2\2\2\u02ff\u008b\3\2"+
		"\2\2\u0300\u0301\7\32\2\2\u0301\u0308\5\u008eH\2\u0302\u0305\7/\2\2\u0303"+
		"\u0306\5\u0090I\2\u0304\u0306\5\u0094K\2\u0305\u0303\3\2\2\2\u0305\u0304"+
		"\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u0307\3\2\2\2\u0307\u0309\7\30\2\2"+
		"\u0308\u0302\3\2\2\2\u0308\u0309\3\2\2\2\u0309\u008d\3\2\2\2\u030a\u030f"+
		"\7d\2\2\u030b\u030c\7I\2\2\u030c\u030e\7d\2\2\u030d\u030b\3\2\2\2\u030e"+
		"\u0311\3\2\2\2\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310\u008f\3\2"+
		"\2\2\u0311\u030f\3\2\2\2\u0312\u0317\5\u0092J\2\u0313\u0314\7,\2\2\u0314"+
		"\u0316\5\u0092J\2\u0315\u0313\3\2\2\2\u0316\u0319\3\2\2\2\u0317\u0315"+
		"\3\2\2\2\u0317\u0318\3\2\2\2\u0318\u0091\3\2\2\2\u0319\u0317\3\2\2\2\u031a"+
		"\u031b\7d\2\2\u031b\u031c\7\33\2\2\u031c\u031d\5\u0094K\2\u031d\u0093"+
		"\3\2\2\2\u031e\u0322\5\u00d0i\2\u031f\u0322\5\u008cG\2\u0320\u0322\5\u0096"+
		"L\2\u0321\u031e\3\2\2\2\u0321\u031f\3\2\2\2\u0321\u0320\3\2\2\2\u0322"+
		"\u0095\3\2\2\2\u0323\u032c\7:\2\2\u0324\u0329\5\u0094K\2\u0325\u0326\7"+
		",\2\2\u0326\u0328\5\u0094K\2\u0327\u0325\3\2\2\2\u0328\u032b\3\2\2\2\u0329"+
		"\u0327\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u032d\3\2\2\2\u032b\u0329\3\2"+
		"\2\2\u032c\u0324\3\2\2\2\u032c\u032d\3\2\2\2\u032d\u032f\3\2\2\2\u032e"+
		"\u0330\7,\2\2\u032f\u032e\3\2\2\2\u032f\u0330\3\2\2\2\u0330\u0331\3\2"+
		"\2\2\u0331\u0332\7\17\2\2\u0332\u0097\3\2\2\2\u0333\u0334\7\32\2\2\u0334"+
		"\u0335\7\3\2\2\u0335\u0336\7d\2\2\u0336\u0337\5\u009aN\2\u0337\u0099\3"+
		"\2\2\2\u0338\u033c\7:\2\2\u0339\u033b\5\u009cO\2\u033a\u0339\3\2\2\2\u033b"+
		"\u033e\3\2\2\2\u033c\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033f\3\2"+
		"\2\2\u033e\u033c\3\2\2\2\u033f\u0340\7\17\2\2\u0340\u009b\3\2\2\2\u0341"+
		"\u0342\5\16\b\2\u0342\u0343\5\u009eP\2\u0343\u009d\3\2\2\2\u0344\u0345"+
		"\5h\65\2\u0345\u0346\5\u00a0Q\2\u0346\u0347\7O\2\2\u0347\u0359\3\2\2\2"+
		"\u0348\u034a\5\22\n\2\u0349\u034b\7O\2\2\u034a\u0349\3\2\2\2\u034a\u034b"+
		"\3\2\2\2\u034b\u0359\3\2\2\2\u034c\u034e\5&\24\2\u034d\u034f\7O\2\2\u034e"+
		"\u034d\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u0359\3\2\2\2\u0350\u0352\5\32"+
		"\16\2\u0351\u0353\7O\2\2\u0352\u0351\3\2\2\2\u0352\u0353\3\2\2\2\u0353"+
		"\u0359\3\2\2\2\u0354\u0356\5\u0098M\2\u0355\u0357\7O\2\2\u0356\u0355\3"+
		"\2\2\2\u0356\u0357\3\2\2\2\u0357\u0359\3\2\2\2\u0358\u0344\3\2\2\2\u0358"+
		"\u0348\3\2\2\2\u0358\u034c\3\2\2\2\u0358\u0350\3\2\2\2\u0358\u0354\3\2"+
		"\2\2\u0359\u009f\3\2\2\2\u035a\u035d\5\u00a2R\2\u035b\u035d\5\u00a4S\2"+
		"\u035c\u035a\3\2\2\2\u035c\u035b\3\2\2\2\u035d\u00a1\3\2\2\2\u035e\u035f"+
		"\7d\2\2\u035f\u0360\7/\2\2\u0360\u0362\7\30\2\2\u0361\u0363\5\u00a6T\2"+
		"\u0362\u0361\3\2\2\2\u0362\u0363\3\2\2\2\u0363\u00a3\3\2\2\2\u0364\u0365"+
		"\5R*\2\u0365\u00a5\3\2\2\2\u0366\u0367\7*\2\2\u0367\u0368\5\u0094K\2\u0368"+
		"\u00a7\3\2\2\2\u0369\u036d\7:\2\2\u036a\u036c\5\u00aaV\2\u036b\u036a\3"+
		"\2\2\2\u036c\u036f\3\2\2\2\u036d\u036b\3\2\2\2\u036d\u036e\3\2\2\2\u036e"+
		"\u0370\3\2\2\2\u036f\u036d\3\2\2\2\u0370\u0371\7\17\2\2\u0371\u00a9\3"+
		"\2\2\2\u0372\u0375\5\u00acW\2\u0373\u0375\5\u00b2Z\2\u0374\u0372\3\2\2"+
		"\2\u0374\u0373\3\2\2\2\u0375\u00ab\3\2\2\2\u0376\u0377\5\u00aeX\2\u0377"+
		"\u0378\7O\2\2\u0378\u00ad\3\2\2\2\u0379\u037a\5\u00b0Y\2\u037a\u037b\5"+
		"h\65\2\u037b\u037c\5R*\2\u037c\u00af\3\2\2\2\u037d\u037f\5n8\2\u037e\u037d"+
		"\3\2\2\2\u037f\u0382\3\2\2\2\u0380\u037e\3\2\2\2\u0380\u0381\3\2\2\2\u0381"+
		"\u00b1\3\2\2\2\u0382\u0380\3\2\2\2\u0383\u03d3\5\u00a8U\2\u0384\u0385"+
		"\7c\2\2\u0385\u0388\5\u00d0i\2\u0386\u0387\7\60\2\2\u0387\u0389\5\u00d0"+
		"i\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u038a\3\2\2\2\u038a"+
		"\u038b\7O\2\2\u038b\u03d3\3\2\2\2\u038c\u038d\7\61\2\2\u038d\u038e\5\u00c8"+
		"e\2\u038e\u0391\5\u00b2Z\2\u038f\u0390\7A\2\2\u0390\u0392\5\u00b2Z\2\u0391"+
		"\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u03d3\3\2\2\2\u0393\u0394\7L"+
		"\2\2\u0394\u0395\7/\2\2\u0395\u0396\5\u00c0a\2\u0396\u0397\7\30\2\2\u0397"+
		"\u0398\5\u00b2Z\2\u0398\u03d3\3\2\2\2\u0399\u039a\7-\2\2\u039a\u039b\5"+
		"\u00c8e\2\u039b\u039c\5\u00b2Z\2\u039c\u03d3\3\2\2\2\u039d\u039e\7\25"+
		"\2\2\u039e\u039f\5\u00b2Z\2\u039f\u03a0\7-\2\2\u03a0\u03a1\5\u00c8e\2"+
		"\u03a1\u03a2\7O\2\2\u03a2\u03d3\3\2\2\2\u03a3\u03a4\7\66\2\2\u03a4\u03ac"+
		"\5\u00a8U\2\u03a5\u03a8\5\u00b4[\2\u03a6\u03a7\7!\2\2\u03a7\u03a9\5\u00a8"+
		"U\2\u03a8\u03a6\3\2\2\2\u03a8\u03a9\3\2\2\2\u03a9\u03ad\3\2\2\2\u03aa"+
		"\u03ab\7!\2\2\u03ab\u03ad\5\u00a8U\2\u03ac\u03a5\3\2\2\2\u03ac\u03aa\3"+
		"\2\2\2\u03ad\u03d3\3\2\2\2\u03ae\u03af\7V\2\2\u03af\u03b0\5\u00c8e\2\u03b0"+
		"\u03b1\7:\2\2\u03b1\u03b2\5\u00ba^\2\u03b2\u03b3\7\17\2\2\u03b3\u03d3"+
		"\3\2\2\2\u03b4\u03b5\7+\2\2\u03b5\u03b6\5\u00c8e\2\u03b6\u03b7\5\u00a8"+
		"U\2\u03b7\u03d3\3\2\2\2\u03b8\u03ba\7M\2\2\u03b9\u03bb\5\u00d0i\2\u03ba"+
		"\u03b9\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u03d3\7O"+
		"\2\2\u03bd\u03be\7\31\2\2\u03be\u03bf\5\u00d0i\2\u03bf\u03c0\7O\2\2\u03c0"+
		"\u03d3\3\2\2\2\u03c1\u03c3\7;\2\2\u03c2\u03c4\7d\2\2\u03c3\u03c2\3\2\2"+
		"\2\u03c3\u03c4\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u03d3\7O\2\2\u03c6\u03c8"+
		"\7\n\2\2\u03c7\u03c9\7d\2\2\u03c8\u03c7\3\2\2\2\u03c8\u03c9\3\2\2\2\u03c9"+
		"\u03ca\3\2\2\2\u03ca\u03d3\7O\2\2\u03cb\u03d3\7O\2\2\u03cc\u03cd\5\u00cc"+
		"g\2\u03cd\u03ce\7O\2\2\u03ce\u03d3\3\2\2\2\u03cf\u03d0\7d\2\2\u03d0\u03d1"+
		"\7\60\2\2\u03d1\u03d3\5\u00b2Z\2\u03d2\u0383\3\2\2\2\u03d2\u0384\3\2\2"+
		"\2\u03d2\u038c\3\2\2\2\u03d2\u0393\3\2\2\2\u03d2\u0399\3\2\2\2\u03d2\u039d"+
		"\3\2\2\2\u03d2\u03a3\3\2\2\2\u03d2\u03ae\3\2\2\2\u03d2\u03b4\3\2\2\2\u03d2"+
		"\u03b8\3\2\2\2\u03d2\u03bd\3\2\2\2\u03d2\u03c1\3\2\2\2\u03d2\u03c6\3\2"+
		"\2\2\u03d2\u03cb\3\2\2\2\u03d2\u03cc\3\2\2\2\u03d2\u03cf\3\2\2\2\u03d3"+
		"\u00b3\3\2\2\2\u03d4\u03d8\5\u00b6\\\2\u03d5\u03d7\5\u00b6\\\2\u03d6\u03d5"+
		"\3\2\2\2\u03d7\u03da\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d9"+
		"\u00b5\3\2\2\2\u03da\u03d8\3\2\2\2\u03db\u03dc\7B\2\2\u03dc\u03dd\7/\2"+
		"\2\u03dd\u03de\5\u00b8]\2\u03de\u03df\7\30\2\2\u03df\u03e0\5\u00a8U\2"+
		"\u03e0\u00b7\3\2\2\2\u03e1\u03e2\5\u00b0Y\2\u03e2\u03e3\5h\65\2\u03e3"+
		"\u03e4\5Z.\2\u03e4\u00b9\3\2\2\2\u03e5\u03e7\5\u00bc_\2\u03e6\u03e5\3"+
		"\2\2\2\u03e7\u03ea\3\2\2\2\u03e8\u03e6\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9"+
		"\u03ee\3\2\2\2\u03ea\u03e8\3\2\2\2\u03eb\u03ed\5\u00be`\2\u03ec\u03eb"+
		"\3\2\2\2\u03ed\u03f0\3\2\2\2\u03ee\u03ec\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef"+
		"\u00bb\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f1\u03f3\5\u00be`\2\u03f2\u03f1"+
		"\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f4\u03f5\3\2\2\2\u03f5"+
		"\u03f7\3\2\2\2\u03f6\u03f8\5\u00aaV\2\u03f7\u03f6\3\2\2\2\u03f8\u03f9"+
		"\3\2\2\2\u03f9\u03f7\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u00bd\3\2\2\2\u03fb"+
		"\u03fc\7\23\2\2\u03fc\u03fd\5\u00ceh\2\u03fd\u03fe\7\60\2\2\u03fe\u0406"+
		"\3\2\2\2\u03ff\u0400\7\23\2\2\u0400\u0401\5d\63\2\u0401\u0402\7\60\2\2"+
		"\u0402\u0406\3\2\2\2\u0403\u0404\7*\2\2\u0404\u0406\7\60\2\2\u0405\u03fb"+
		"\3\2\2\2\u0405\u03ff\3\2\2\2\u0405\u0403\3\2\2\2\u0406\u00bf\3\2\2\2\u0407"+
		"\u0414\5\u00c4c\2\u0408\u040a\5\u00c2b\2\u0409\u0408\3\2\2\2\u0409\u040a"+
		"\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u040d\7O\2\2\u040c\u040e\5\u00d0i\2"+
		"\u040d\u040c\3\2\2\2\u040d\u040e\3\2\2\2\u040e\u040f\3\2\2\2\u040f\u0411"+
		"\7O\2\2\u0410\u0412\5\u00c6d\2\u0411\u0410\3\2\2\2\u0411\u0412\3\2\2\2"+
		"\u0412\u0414\3\2\2\2\u0413\u0407\3\2\2\2\u0413\u0409\3\2\2\2\u0414\u00c1"+
		"\3\2\2\2\u0415\u0418\5\u00aeX\2\u0416\u0418\5\u00caf\2\u0417\u0415\3\2"+
		"\2\2\u0417\u0416\3\2\2\2\u0418\u00c3\3\2\2\2\u0419\u041a\5\u00b0Y\2\u041a"+
		"\u041b\5h\65\2\u041b\u041c\7d\2\2\u041c\u041d\7\60\2\2\u041d\u041e\5\u00d0"+
		"i\2\u041e\u00c5\3\2\2\2\u041f\u0420\5\u00caf\2\u0420\u00c7\3\2\2\2\u0421"+
		"\u0422\7/\2\2\u0422\u0423\5\u00d0i\2\u0423\u0424\7\30\2\2\u0424\u00c9"+
		"\3\2\2\2\u0425\u042a\5\u00d0i\2\u0426\u0427\7,\2\2\u0427\u0429\5\u00d0"+
		"i\2\u0428\u0426\3\2\2\2\u0429\u042c\3\2\2\2\u042a\u0428\3\2\2\2\u042a"+
		"\u042b\3\2\2\2\u042b\u00cb\3\2\2\2\u042c\u042a\3\2\2\2\u042d\u042e\5\u00d0"+
		"i\2\u042e\u00cd\3\2\2\2\u042f\u0430\5\u00d0i\2\u0430\u00cf\3\2\2\2\u0431"+
		"\u0432\bi\1\2\u0432\u0433\t\7\2\2\u0433\u043f\5\u00d0i\2\u0434\u0435\t"+
		"\b\2\2\u0435\u043f\5\u00d0i\2\u0436\u0437\7/\2\2\u0437\u0438\5h\65\2\u0438"+
		"\u0439\7\30\2\2\u0439\u043a\5\u00d0i\2\u043a\u043f\3\2\2\2\u043b\u043f"+
		"\5\u00d2j\2\u043c\u043d\7\37\2\2\u043d\u043f\5\u00d4k\2\u043e\u0431\3"+
		"\2\2\2\u043e\u0434\3\2\2\2\u043e\u0436\3\2\2\2\u043e\u043b\3\2\2\2\u043e"+
		"\u043c\3\2\2\2\u043f\u04be\3\2\2\2\u0440\u0441\6i\2\3\u0441\u0442\t\t"+
		"\2\2\u0442\u04bd\5\u00d0i\2\u0443\u0444\6i\3\3\u0444\u0445\t\n\2\2\u0445"+
		"\u04bd\5\u00d0i\2\u0446\u044e\6i\4\3\u0447\u0448\7\7\2\2\u0448\u044f\7"+
		"\7\2\2\u0449\u044a\7S\2\2\u044a\u044b\7S\2\2\u044b\u044f\7S\2\2\u044c"+
		"\u044d\7S\2\2\u044d\u044f\7S\2\2\u044e\u0447\3\2\2\2\u044e\u0449\3\2\2"+
		"\2\u044e\u044c\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u04bd\5\u00d0i\2\u0451"+
		"\u0458\6i\5\3\u0452\u0453\7\7\2\2\u0453\u0459\7\33\2\2\u0454\u0455\7S"+
		"\2\2\u0455\u0459\7\33\2\2\u0456\u0459\7S\2\2\u0457\u0459\7\7\2\2\u0458"+
		"\u0452\3\2\2\2\u0458\u0454\3\2\2\2\u0458\u0456\3\2\2\2\u0458\u0457\3\2"+
		"\2\2\u0459\u045a\3\2\2\2\u045a\u04bd\5\u00d0i\2\u045b\u045c\6i\6\3\u045c"+
		"\u045d\t\13\2\2\u045d\u04bd\5\u00d0i\2\u045e\u045f\6i\7\3\u045f\u0460"+
		"\7\4\2\2\u0460\u04bd\5\u00d0i\2\u0461\u0462\6i\b\3\u0462\u0463\7H\2\2"+
		"\u0463\u04bd\5\u00d0i\2\u0464\u0465\6i\t\3\u0465\u0466\7\"\2\2\u0466\u04bd"+
		"\5\u00d0i\2\u0467\u0468\6i\n\3\u0468\u0469\7P\2\2\u0469\u04bd\5\u00d0"+
		"i\2\u046a\u046b\6i\13\3\u046b\u046c\7R\2\2\u046c\u04bd\5\u00d0i\2\u046d"+
		"\u0481\6i\f\3\u046e\u0482\7?\2\2\u046f\u0482\7=\2\2\u0470\u0482\7(\2\2"+
		"\u0471\u0482\7\27\2\2\u0472\u0482\7W\2\2\u0473\u0482\7\62\2\2\u0474\u0482"+
		"\7\36\2\2\u0475\u0482\7\33\2\2\u0476\u0477\7S\2\2\u0477\u0478\7S\2\2\u0478"+
		"\u0482\7\33\2\2\u0479\u047a\7S\2\2\u047a\u047b\7S\2\2\u047b\u047c\7S\2"+
		"\2\u047c\u0482\7\33\2\2\u047d\u047e\7\7\2\2\u047e\u047f\7\7\2\2\u047f"+
		"\u0482\7\33\2\2\u0480\u0482\7U\2\2\u0481\u046e\3\2\2\2\u0481\u046f\3\2"+
		"\2\2\u0481\u0470\3\2\2\2\u0481\u0471\3\2\2\2\u0481\u0472\3\2\2\2\u0481"+
		"\u0473\3\2\2\2\u0481\u0474\3\2\2\2\u0481\u0475\3\2\2\2\u0481\u0476\3\2"+
		"\2\2\u0481\u0479\3\2\2\2\u0481\u047d\3\2\2\2\u0481\u0480\3\2\2\2\u0482"+
		"\u0483\3\2\2\2\u0483\u04bd\5\u00d0i\2\u0484\u0485\6i\r\3\u0485\u0486\7"+
		"\65\2\2\u0486\u0487\5\u00d0i\2\u0487\u0488\7\60\2\2\u0488\u0489\5\u00d0"+
		"i\2\u0489\u04bd\3\2\2\2\u048a\u048b\6i\16\3\u048b\u048c\7I\2\2\u048c\u04bd"+
		"\7d\2\2\u048d\u048e\6i\17\3\u048e\u048f\7I\2\2\u048f\u04bd\7Q\2\2\u0490"+
		"\u0491\6i\20\3\u0491\u0492\7I\2\2\u0492\u0493\7\24\2\2\u0493\u0495\7/"+
		"\2\2\u0494\u0496\5\u00caf\2\u0495\u0494\3\2\2\2\u0495\u0496\3\2\2\2\u0496"+
		"\u0497\3\2\2\2\u0497\u04bd\7\30\2\2\u0498\u0499\6i\21\3\u0499\u049a\7"+
		"I\2\2\u049a\u049b\7\37\2\2\u049b\u049c\7d\2\2\u049c\u049e\7/\2\2\u049d"+
		"\u049f\5\u00caf\2\u049e\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a0"+
		"\3\2\2\2\u04a0\u04bd\7\30\2\2\u04a1\u04a2\6i\22\3\u04a2\u04a3\7I\2\2\u04a3"+
		"\u04a4\7\24\2\2\u04a4\u04a5\7I\2\2\u04a5\u04a7\7d\2\2\u04a6\u04a8\5\u00e2"+
		"r\2\u04a7\u04a6\3\2\2\2\u04a7\u04a8\3\2\2\2\u04a8\u04bd\3\2\2\2\u04a9"+
		"\u04aa\6i\23\3\u04aa\u04ab\7I\2\2\u04ab\u04bd\5\u00dan\2\u04ac\u04ad\6"+
		"i\24\3\u04ad\u04ae\7\6\2\2\u04ae\u04af\5\u00d0i\2\u04af\u04b0\7\'\2\2"+
		"\u04b0\u04bd\3\2\2\2\u04b1\u04b2\6i\25\3\u04b2\u04b4\7/\2\2\u04b3\u04b5"+
		"\5\u00caf\2\u04b4\u04b3\3\2\2\2\u04b4\u04b5\3\2\2\2\u04b5\u04b6\3\2\2"+
		"\2\u04b6\u04bd\7\30\2\2\u04b7\u04b8\6i\26\3\u04b8\u04bd\t\f\2\2\u04b9"+
		"\u04ba\6i\27\3\u04ba\u04bb\7[\2\2\u04bb\u04bd\5h\65\2\u04bc\u0440\3\2"+
		"\2\2\u04bc\u0443\3\2\2\2\u04bc\u0446\3\2\2\2\u04bc\u0451\3\2\2\2\u04bc"+
		"\u045b\3\2\2\2\u04bc\u045e\3\2\2\2\u04bc\u0461\3\2\2\2\u04bc\u0464\3\2"+
		"\2\2\u04bc\u0467\3\2\2\2\u04bc\u046a\3\2\2\2\u04bc\u046d\3\2\2\2\u04bc"+
		"\u0484\3\2\2\2\u04bc\u048a\3\2\2\2\u04bc\u048d\3\2\2\2\u04bc\u0490\3\2"+
		"\2\2\u04bc\u0498\3\2\2\2\u04bc\u04a1\3\2\2\2\u04bc\u04a9\3\2\2\2\u04bc"+
		"\u04ac\3\2\2\2\u04bc\u04b1\3\2\2\2\u04bc\u04b7\3\2\2\2\u04bc\u04b9\3\2"+
		"\2\2\u04bd\u04c0\3\2\2\2\u04be\u04bc\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf"+
		"\u00d1\3\2\2\2\u04c0\u04be\3\2\2\2\u04c1\u04c2\7/\2\2\u04c2\u04c3\5\u00d0"+
		"i\2\u04c3\u04c4\7\30\2\2\u04c4\u04d1\3\2\2\2\u04c5\u04d1\7Q\2\2\u04c6"+
		"\u04d1\7\24\2\2\u04c7\u04d1\5\u0084C\2\u04c8\u04d1\7d\2\2\u04c9\u04ca"+
		"\5h\65\2\u04ca\u04cb\7I\2\2\u04cb\u04cc\7 \2\2\u04cc\u04d1\3\2\2\2\u04cd"+
		"\u04ce\7\67\2\2\u04ce\u04cf\7I\2\2\u04cf\u04d1\7 \2\2\u04d0\u04c1\3\2"+
		"\2\2\u04d0\u04c5\3\2\2\2\u04d0\u04c6\3\2\2\2\u04d0\u04c7\3\2\2\2\u04d0"+
		"\u04c8\3\2\2\2\u04d0\u04c9\3\2\2\2\u04d0\u04cd\3\2\2\2\u04d1\u00d3\3\2"+
		"\2\2\u04d2\u04d3\5\u00e0q\2\u04d3\u04d4\5\u00d6l\2\u04d4\u04d5\5\u00de"+
		"p\2\u04d5\u04dc\3\2\2\2\u04d6\u04d9\5\u00d6l\2\u04d7\u04da\5\u00dco\2"+
		"\u04d8\u04da\5\u00dep\2\u04d9\u04d7\3\2\2\2\u04d9\u04d8\3\2\2\2\u04da"+
		"\u04dc\3\2\2\2\u04db\u04d2\3\2\2\2\u04db\u04d6\3\2\2\2\u04dc\u00d5\3\2"+
		"\2\2\u04dd\u04e0\5j\66\2\u04de\u04e0\5l\67\2\u04df\u04dd\3\2\2\2\u04df"+
		"\u04de\3\2\2\2\u04e0\u00d7\3\2\2\2\u04e1\u04e3\5\u00e0q\2\u04e2\u04e1"+
		"\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e5\7d\2\2\u04e5"+
		"\u04e6\5\u00dep\2\u04e6\u00d9\3\2\2\2\u04e7\u04e8\5\u00e0q\2\u04e8\u04e9"+
		"\7d\2\2\u04e9\u04ea\5\u00e2r\2\u04ea\u00db\3\2\2\2\u04eb\u0507\7\6\2\2"+
		"\u04ec\u04f1\7\'\2\2\u04ed\u04ee\7\6\2\2\u04ee\u04f0\7\'\2\2\u04ef\u04ed"+
		"\3\2\2\2\u04f0\u04f3\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2"+
		"\u04f4\3\2\2\2\u04f3\u04f1\3\2\2\2\u04f4\u0508\5^\60\2\u04f5\u04f6\5\u00d0"+
		"i\2\u04f6\u04fd\7\'\2\2\u04f7\u04f8\7\6\2\2\u04f8\u04f9\5\u00d0i\2\u04f9"+
		"\u04fa\7\'\2\2\u04fa\u04fc\3\2\2\2\u04fb\u04f7\3\2\2\2\u04fc\u04ff\3\2"+
		"\2\2\u04fd\u04fb\3\2\2\2\u04fd\u04fe\3\2\2\2\u04fe\u0504\3\2\2\2\u04ff"+
		"\u04fd\3\2\2\2\u0500\u0501\7\6\2\2\u0501\u0503\7\'\2\2\u0502\u0500\3\2"+
		"\2\2\u0503\u0506\3\2\2\2\u0504\u0502\3\2\2\2\u0504\u0505\3\2\2\2\u0505"+
		"\u0508\3\2\2\2\u0506\u0504\3\2\2\2\u0507\u04ec\3\2\2\2\u0507\u04f5\3\2"+
		"\2\2\u0508\u00dd\3\2\2\2\u0509\u050b\5\u00e2r\2\u050a\u050c\5*\26\2\u050b"+
		"\u050a\3\2\2\2\u050b\u050c\3\2\2\2\u050c\u00df\3\2\2\2\u050d\u050e\7\7"+
		"\2\2\u050e\u050f\5(\25\2\u050f\u0510\7S\2\2\u0510\u00e1\3\2\2\2\u0511"+
		"\u0513\7/\2\2\u0512\u0514\5\u00caf\2\u0513\u0512\3\2\2\2\u0513\u0514\3"+
		"\2\2\2\u0514\u0515\3\2\2\2\u0515\u0516\7\30\2\2\u0516\u00e3\3\2\2\2\u008e"+
		"\u00e9\u00f0\u00f5\u00fb\u0103\u0108\u0112\u011d\u0122\u012a\u012e\u0132"+
		"\u013c\u0144\u014b\u0152\u0158\u015b\u015e\u0167\u016b\u016f\u0172\u0178"+
		"\u017d\u0182\u0186\u018f\u0196\u019f\u01a8\u01b1\u01b6\u01bd\u01c3\u01cf"+
		"\u01d8\u01e2\u01e9\u01ee\u01f2\u01f7\u01fb\u0202\u0207\u020e\u0216\u021d"+
		"\u0229\u022f\u0236\u023d\u0248\u024d\u0255\u0259\u025b\u026b\u0278\u0280"+
		"\u0283\u0287\u028c\u0290\u0297\u029f\u02a8\u02aa\u02b1\u02b6\u02c1\u02c5"+
		"\u02cb\u02d0\u02d6\u02df\u02e5\u02ec\u02f5\u02fe\u0305\u0308\u030f\u0317"+
		"\u0321\u0329\u032c\u032f\u033c\u034a\u034e\u0352\u0356\u0358\u035c\u0362"+
		"\u036d\u0374\u0380\u0388\u0391\u03a8\u03ac\u03ba\u03c3\u03c8\u03d2\u03d8"+
		"\u03e8\u03ee\u03f4\u03f9\u0405\u0409\u040d\u0411\u0413\u0417\u042a\u043e"+
		"\u044e\u0458\u0481\u0495\u049e\u04a7\u04b4\u04bc\u04be\u04d0\u04d9\u04db"+
		"\u04df\u04e2\u04f1\u04fd\u0504\u0507\u050b\u0513";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}
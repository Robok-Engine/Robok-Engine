// Generated from Java8.g4 by ANTLR 4.13.2
package robok.diagnostic.logic;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Java8Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, INTERFACE=28, LONG=29, 
		NATIVE=30, NEW=31, PACKAGE=32, PRIVATE=33, PROTECTED=34, PUBLIC=35, RETURN=36, 
		SHORT=37, STATIC=38, STRICTFP=39, SUPER=40, SWITCH=41, SYNCHRONIZED=42, 
		THIS=43, THROW=44, THROWS=45, TRANSIENT=46, TRY=47, VOID=48, VOLATILE=49, 
		WHILE=50, IntegerLiteral=51, FloatingPointLiteral=52, BooleanLiteral=53, 
		CharacterLiteral=54, StringLiteral=55, NullLiteral=56, LPAREN=57, RPAREN=58, 
		LBRACE=59, RBRACE=60, LBRACK=61, RBRACK=62, SEMI=63, COMMA=64, DOT=65, 
		ASSIGN=66, GT=67, LT=68, BANG=69, TILDE=70, QUESTION=71, COLON=72, EQUAL=73, 
		LE=74, GE=75, NOTEQUAL=76, AND=77, OR=78, INC=79, DEC=80, ADD=81, SUB=82, 
		MUL=83, DIV=84, BITAND=85, BITOR=86, CARET=87, MOD=88, ARROW=89, COLONCOLON=90, 
		ADD_ASSIGN=91, SUB_ASSIGN=92, MUL_ASSIGN=93, DIV_ASSIGN=94, AND_ASSIGN=95, 
		OR_ASSIGN=96, XOR_ASSIGN=97, MOD_ASSIGN=98, LSHIFT_ASSIGN=99, RSHIFT_ASSIGN=100, 
		URSHIFT_ASSIGN=101, Identifier=102, AT=103, ELLIPSIS=104, WS=105, COMMENT=106, 
		LINE_COMMENT=107;
	public static final int
		RULE_literal = 0, RULE_primitiveType = 1, RULE_numericType = 2, RULE_integralType = 3, 
		RULE_floatingPointType = 4, RULE_referenceType = 5, RULE_classOrInterfaceType = 6, 
		RULE_classType = 7, RULE_classType_lf_classOrInterfaceType = 8, RULE_classType_lfno_classOrInterfaceType = 9, 
		RULE_interfaceType = 10, RULE_interfaceType_lf_classOrInterfaceType = 11, 
		RULE_interfaceType_lfno_classOrInterfaceType = 12, RULE_typeVariable = 13, 
		RULE_arrayType = 14, RULE_dims = 15, RULE_typeParameter = 16, RULE_typeParameterModifier = 17, 
		RULE_typeBound = 18, RULE_additionalBound = 19, RULE_typeArguments = 20, 
		RULE_typeArgumentList = 21, RULE_typeArgument = 22, RULE_wildcard = 23, 
		RULE_wildcardBounds = 24, RULE_packageName = 25, RULE_typeName = 26, RULE_packageOrTypeName = 27, 
		RULE_expressionName = 28, RULE_methodName = 29, RULE_ambiguousName = 30, 
		RULE_compilationUnit = 31, RULE_packageDeclaration = 32, RULE_packageModifier = 33, 
		RULE_importDeclaration = 34, RULE_singleTypeImportDeclaration = 35, RULE_typeImportOnDemandDeclaration = 36, 
		RULE_singleStaticImportDeclaration = 37, RULE_staticImportOnDemandDeclaration = 38, 
		RULE_typeDeclaration = 39, RULE_classDeclaration = 40, RULE_normalClassDeclaration = 41, 
		RULE_classModifier = 42, RULE_typeParameters = 43, RULE_typeParameterList = 44, 
		RULE_superclass = 45, RULE_superinterfaces = 46, RULE_interfaceTypeList = 47, 
		RULE_classBody = 48, RULE_classBodyDeclaration = 49, RULE_classMemberDeclaration = 50, 
		RULE_fieldDeclaration = 51, RULE_fieldModifier = 52, RULE_variableDeclaratorList = 53, 
		RULE_variableDeclarator = 54, RULE_variableDeclaratorId = 55, RULE_variableInitializer = 56, 
		RULE_unannType = 57, RULE_unannPrimitiveType = 58, RULE_unannReferenceType = 59, 
		RULE_unannClassOrInterfaceType = 60, RULE_unannClassType = 61, RULE_unannClassType_lf_unannClassOrInterfaceType = 62, 
		RULE_unannClassType_lfno_unannClassOrInterfaceType = 63, RULE_unannInterfaceType = 64, 
		RULE_unannInterfaceType_lf_unannClassOrInterfaceType = 65, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType = 66, 
		RULE_unannTypeVariable = 67, RULE_unannArrayType = 68, RULE_methodDeclaration = 69, 
		RULE_methodModifier = 70, RULE_methodHeader = 71, RULE_result = 72, RULE_methodDeclarator = 73, 
		RULE_formalParameterList = 74, RULE_formalParameters = 75, RULE_formalParameter = 76, 
		RULE_variableModifier = 77, RULE_lastFormalParameter = 78, RULE_receiverParameter = 79, 
		RULE_throws_ = 80, RULE_exceptionTypeList = 81, RULE_exceptionType = 82, 
		RULE_methodBody = 83, RULE_instanceInitializer = 84, RULE_staticInitializer = 85, 
		RULE_constructorDeclaration = 86, RULE_constructorModifier = 87, RULE_constructorDeclarator = 88, 
		RULE_simpleTypeName = 89, RULE_constructorBody = 90, RULE_explicitConstructorInvocation = 91, 
		RULE_enumDeclaration = 92, RULE_enumBody = 93, RULE_enumConstantList = 94, 
		RULE_enumConstant = 95, RULE_enumConstantModifier = 96, RULE_enumBodyDeclarations = 97, 
		RULE_interfaceDeclaration = 98, RULE_normalInterfaceDeclaration = 99, 
		RULE_interfaceModifier = 100, RULE_extendsInterfaces = 101, RULE_interfaceBody = 102, 
		RULE_interfaceMemberDeclaration = 103, RULE_constantDeclaration = 104, 
		RULE_constantModifier = 105, RULE_interfaceMethodDeclaration = 106, RULE_interfaceMethodModifier = 107, 
		RULE_annotationTypeDeclaration = 108, RULE_annotationTypeBody = 109, RULE_annotationTypeMemberDeclaration = 110, 
		RULE_annotationTypeElementDeclaration = 111, RULE_annotationTypeElementModifier = 112, 
		RULE_defaultValue = 113, RULE_annotation = 114, RULE_normalAnnotation = 115, 
		RULE_elementValuePairList = 116, RULE_elementValuePair = 117, RULE_elementValue = 118, 
		RULE_elementValueArrayInitializer = 119, RULE_elementValueList = 120, 
		RULE_markerAnnotation = 121, RULE_singleElementAnnotation = 122, RULE_arrayInitializer = 123, 
		RULE_variableInitializerList = 124, RULE_block = 125, RULE_blockStatements = 126, 
		RULE_blockStatement = 127, RULE_localVariableDeclarationStatement = 128, 
		RULE_localVariableDeclaration = 129, RULE_statement = 130, RULE_statementNoShortIf = 131, 
		RULE_statementWithoutTrailingSubstatement = 132, RULE_emptyStatement = 133, 
		RULE_labeledStatement = 134, RULE_labeledStatementNoShortIf = 135, RULE_expressionStatement = 136, 
		RULE_statementExpression = 137, RULE_ifThenStatement = 138, RULE_ifThenElseStatement = 139, 
		RULE_ifThenElseStatementNoShortIf = 140, RULE_assertStatement = 141, RULE_switchStatement = 142, 
		RULE_switchBlock = 143, RULE_switchBlockStatementGroup = 144, RULE_switchLabels = 145, 
		RULE_switchLabel = 146, RULE_enumConstantName = 147, RULE_whileStatement = 148, 
		RULE_whileStatementNoShortIf = 149, RULE_doStatement = 150, RULE_forStatement = 151, 
		RULE_forStatementNoShortIf = 152, RULE_basicForStatement = 153, RULE_basicForStatementNoShortIf = 154, 
		RULE_forInit = 155, RULE_forUpdate = 156, RULE_statementExpressionList = 157, 
		RULE_enhancedForStatement = 158, RULE_enhancedForStatementNoShortIf = 159, 
		RULE_breakStatement = 160, RULE_continueStatement = 161, RULE_returnStatement = 162, 
		RULE_throwStatement = 163, RULE_synchronizedStatement = 164, RULE_tryStatement = 165, 
		RULE_catches = 166, RULE_catchClause = 167, RULE_catchFormalParameter = 168, 
		RULE_catchType = 169, RULE_finally_ = 170, RULE_tryWithResourcesStatement = 171, 
		RULE_resourceSpecification = 172, RULE_resourceList = 173, RULE_resource = 174, 
		RULE_primary = 175, RULE_primaryNoNewArray = 176, RULE_primaryNoNewArray_lf_arrayAccess = 177, 
		RULE_primaryNoNewArray_lfno_arrayAccess = 178, RULE_primaryNoNewArray_lf_primary = 179, 
		RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary = 180, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary = 181, 
		RULE_primaryNoNewArray_lfno_primary = 182, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary = 183, 
		RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary = 184, 
		RULE_classInstanceCreationExpression = 185, RULE_classInstanceCreationExpression_lf_primary = 186, 
		RULE_classInstanceCreationExpression_lfno_primary = 187, RULE_typeArgumentsOrDiamond = 188, 
		RULE_fieldAccess = 189, RULE_fieldAccess_lf_primary = 190, RULE_fieldAccess_lfno_primary = 191, 
		RULE_arrayAccess = 192, RULE_arrayAccess_lf_primary = 193, RULE_arrayAccess_lfno_primary = 194, 
		RULE_methodInvocation = 195, RULE_methodInvocation_lf_primary = 196, RULE_methodInvocation_lfno_primary = 197, 
		RULE_argumentList = 198, RULE_methodReference = 199, RULE_methodReference_lf_primary = 200, 
		RULE_methodReference_lfno_primary = 201, RULE_arrayCreationExpression = 202, 
		RULE_dimExprs = 203, RULE_dimExpr = 204, RULE_constantExpression = 205, 
		RULE_expression = 206, RULE_lambdaExpression = 207, RULE_lambdaParameters = 208, 
		RULE_inferredFormalParameterList = 209, RULE_lambdaBody = 210, RULE_assignmentExpression = 211, 
		RULE_assignment = 212, RULE_leftHandSide = 213, RULE_assignmentOperator = 214, 
		RULE_conditionalExpression = 215, RULE_conditionalOrExpression = 216, 
		RULE_conditionalAndExpression = 217, RULE_inclusiveOrExpression = 218, 
		RULE_exclusiveOrExpression = 219, RULE_andExpression = 220, RULE_equalityExpression = 221, 
		RULE_relationalExpression = 222, RULE_shiftExpression = 223, RULE_additiveExpression = 224, 
		RULE_multiplicativeExpression = 225, RULE_unaryExpression = 226, RULE_preIncrementExpression = 227, 
		RULE_preDecrementExpression = 228, RULE_unaryExpressionNotPlusMinus = 229, 
		RULE_postfixExpression = 230, RULE_postIncrementExpression = 231, RULE_postIncrementExpression_lf_postfixExpression = 232, 
		RULE_postDecrementExpression = 233, RULE_postDecrementExpression_lf_postfixExpression = 234, 
		RULE_castExpression = 235;
	private static String[] makeRuleNames() {
		return new String[] {
			"literal", "primitiveType", "numericType", "integralType", "floatingPointType", 
			"referenceType", "classOrInterfaceType", "classType", "classType_lf_classOrInterfaceType", 
			"classType_lfno_classOrInterfaceType", "interfaceType", "interfaceType_lf_classOrInterfaceType", 
			"interfaceType_lfno_classOrInterfaceType", "typeVariable", "arrayType", 
			"dims", "typeParameter", "typeParameterModifier", "typeBound", "additionalBound", 
			"typeArguments", "typeArgumentList", "typeArgument", "wildcard", "wildcardBounds", 
			"packageName", "typeName", "packageOrTypeName", "expressionName", "methodName", 
			"ambiguousName", "compilationUnit", "packageDeclaration", "packageModifier", 
			"importDeclaration", "singleTypeImportDeclaration", "typeImportOnDemandDeclaration", 
			"singleStaticImportDeclaration", "staticImportOnDemandDeclaration", "typeDeclaration", 
			"classDeclaration", "normalClassDeclaration", "classModifier", "typeParameters", 
			"typeParameterList", "superclass", "superinterfaces", "interfaceTypeList", 
			"classBody", "classBodyDeclaration", "classMemberDeclaration", "fieldDeclaration", 
			"fieldModifier", "variableDeclaratorList", "variableDeclarator", "variableDeclaratorId", 
			"variableInitializer", "unannType", "unannPrimitiveType", "unannReferenceType", 
			"unannClassOrInterfaceType", "unannClassType", "unannClassType_lf_unannClassOrInterfaceType", 
			"unannClassType_lfno_unannClassOrInterfaceType", "unannInterfaceType", 
			"unannInterfaceType_lf_unannClassOrInterfaceType", "unannInterfaceType_lfno_unannClassOrInterfaceType", 
			"unannTypeVariable", "unannArrayType", "methodDeclaration", "methodModifier", 
			"methodHeader", "result", "methodDeclarator", "formalParameterList", 
			"formalParameters", "formalParameter", "variableModifier", "lastFormalParameter", 
			"receiverParameter", "throws_", "exceptionTypeList", "exceptionType", 
			"methodBody", "instanceInitializer", "staticInitializer", "constructorDeclaration", 
			"constructorModifier", "constructorDeclarator", "simpleTypeName", "constructorBody", 
			"explicitConstructorInvocation", "enumDeclaration", "enumBody", "enumConstantList", 
			"enumConstant", "enumConstantModifier", "enumBodyDeclarations", "interfaceDeclaration", 
			"normalInterfaceDeclaration", "interfaceModifier", "extendsInterfaces", 
			"interfaceBody", "interfaceMemberDeclaration", "constantDeclaration", 
			"constantModifier", "interfaceMethodDeclaration", "interfaceMethodModifier", 
			"annotationTypeDeclaration", "annotationTypeBody", "annotationTypeMemberDeclaration", 
			"annotationTypeElementDeclaration", "annotationTypeElementModifier", 
			"defaultValue", "annotation", "normalAnnotation", "elementValuePairList", 
			"elementValuePair", "elementValue", "elementValueArrayInitializer", "elementValueList", 
			"markerAnnotation", "singleElementAnnotation", "arrayInitializer", "variableInitializerList", 
			"block", "blockStatements", "blockStatement", "localVariableDeclarationStatement", 
			"localVariableDeclaration", "statement", "statementNoShortIf", "statementWithoutTrailingSubstatement", 
			"emptyStatement", "labeledStatement", "labeledStatementNoShortIf", "expressionStatement", 
			"statementExpression", "ifThenStatement", "ifThenElseStatement", "ifThenElseStatementNoShortIf", 
			"assertStatement", "switchStatement", "switchBlock", "switchBlockStatementGroup", 
			"switchLabels", "switchLabel", "enumConstantName", "whileStatement", 
			"whileStatementNoShortIf", "doStatement", "forStatement", "forStatementNoShortIf", 
			"basicForStatement", "basicForStatementNoShortIf", "forInit", "forUpdate", 
			"statementExpressionList", "enhancedForStatement", "enhancedForStatementNoShortIf", 
			"breakStatement", "continueStatement", "returnStatement", "throwStatement", 
			"synchronizedStatement", "tryStatement", "catches", "catchClause", "catchFormalParameter", 
			"catchType", "finally_", "tryWithResourcesStatement", "resourceSpecification", 
			"resourceList", "resource", "primary", "primaryNoNewArray", "primaryNoNewArray_lf_arrayAccess", 
			"primaryNoNewArray_lfno_arrayAccess", "primaryNoNewArray_lf_primary", 
			"primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary", "primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary", 
			"primaryNoNewArray_lfno_primary", "primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary", 
			"primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary", "classInstanceCreationExpression", 
			"classInstanceCreationExpression_lf_primary", "classInstanceCreationExpression_lfno_primary", 
			"typeArgumentsOrDiamond", "fieldAccess", "fieldAccess_lf_primary", "fieldAccess_lfno_primary", 
			"arrayAccess", "arrayAccess_lf_primary", "arrayAccess_lfno_primary", 
			"methodInvocation", "methodInvocation_lf_primary", "methodInvocation_lfno_primary", 
			"argumentList", "methodReference", "methodReference_lf_primary", "methodReference_lfno_primary", 
			"arrayCreationExpression", "dimExprs", "dimExpr", "constantExpression", 
			"expression", "lambdaExpression", "lambdaParameters", "inferredFormalParameterList", 
			"lambdaBody", "assignmentExpression", "assignment", "leftHandSide", "assignmentOperator", 
			"conditionalExpression", "conditionalOrExpression", "conditionalAndExpression", 
			"inclusiveOrExpression", "exclusiveOrExpression", "andExpression", "equalityExpression", 
			"relationalExpression", "shiftExpression", "additiveExpression", "multiplicativeExpression", 
			"unaryExpression", "preIncrementExpression", "preDecrementExpression", 
			"unaryExpressionNotPlusMinus", "postfixExpression", "postIncrementExpression", 
			"postIncrementExpression_lf_postfixExpression", "postDecrementExpression", 
			"postDecrementExpression_lf_postfixExpression", "castExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
			"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
			"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
			"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
			"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
			"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
			"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
			"'transient'", "'try'", "'void'", "'volatile'", "'while'", null, null, 
			null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
			"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'->'", "'::'", "'+='", 
			"'-='", "'*='", "'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", 
			"'>>>='", null, "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", 
			"CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", 
			"ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
			"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
			"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
			"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
			"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", 
			"FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", "StringLiteral", 
			"NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", 
			"SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", "TILDE", "QUESTION", 
			"COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", "DEC", 
			"ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", "MOD", "ARROW", 
			"COLONCOLON", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
			"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
			"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", "ELLIPSIS", "WS", 
			"COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Java8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Java8Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(Java8Parser.IntegerLiteral, 0); }
		public TerminalNode FloatingPointLiteral() { return getToken(Java8Parser.FloatingPointLiteral, 0); }
		public TerminalNode BooleanLiteral() { return getToken(Java8Parser.BooleanLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(Java8Parser.CharacterLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(Java8Parser.StringLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(Java8Parser.NullLiteral, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863388262170624L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode BOOLEAN() { return getToken(Java8Parser.BOOLEAN, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_primitiveType);
		int _la;
		try {
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(474);
					annotation();
					}
					}
					setState(479);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(480);
				numericType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(481);
					annotation();
					}
					}
					setState(486);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(487);
				match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumericTypeContext extends ParserRuleContext {
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNumericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNumericType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNumericType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_numericType);
		try {
			setState(492);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(490);
				integralType();
				}
				break;
			case DOUBLE:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				floatingPointType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IntegralTypeContext extends ParserRuleContext {
		public TerminalNode BYTE() { return getToken(Java8Parser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(Java8Parser.SHORT, 0); }
		public TerminalNode INT() { return getToken(Java8Parser.INT, 0); }
		public TerminalNode LONG() { return getToken(Java8Parser.LONG, 0); }
		public TerminalNode CHAR() { return getToken(Java8Parser.CHAR, 0); }
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIntegralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIntegralType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIntegralType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_integralType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 138110042400L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FloatingPointTypeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(Java8Parser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(Java8Parser.DOUBLE, 0); }
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFloatingPointType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFloatingPointType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFloatingPointType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_floatingPointType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReferenceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_referenceType);
		try {
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				classOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(499);
				typeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(500);
				arrayType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() {
			return getRuleContext(InterfaceType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public List<ClassType_lf_classOrInterfaceTypeContext> classType_lf_classOrInterfaceType() {
			return getRuleContexts(ClassType_lf_classOrInterfaceTypeContext.class);
		}
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType(int i) {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,i);
		}
		public List<InterfaceType_lf_classOrInterfaceTypeContext> interfaceType_lf_classOrInterfaceType() {
			return getRuleContexts(InterfaceType_lf_classOrInterfaceTypeContext.class);
		}
		public InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType(int i) {
			return getRuleContext(InterfaceType_lf_classOrInterfaceTypeContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(503);
				classType_lfno_classOrInterfaceType();
				}
				break;
			case 2:
				{
				setState(504);
				interfaceType_lfno_classOrInterfaceType();
				}
				break;
			}
			setState(511);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(509);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(507);
						classType_lf_classOrInterfaceType();
						}
						break;
					case 2:
						{
						setState(508);
						interfaceType_lf_classOrInterfaceType();
						}
						break;
					}
					} 
				}
				setState(513);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classType);
		int _la;
		try {
			setState(536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(514);
					annotation();
					}
					}
					setState(519);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(520);
				match(Identifier);
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(521);
					typeArguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				classOrInterfaceType();
				setState(525);
				match(DOT);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(526);
					annotation();
					}
					}
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(532);
				match(Identifier);
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(533);
					typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType_lf_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType_lf_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() throws RecognitionException {
		ClassType_lf_classOrInterfaceTypeContext _localctx = new ClassType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classType_lf_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(538);
			match(DOT);
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(539);
				annotation();
				}
				}
				setState(544);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(545);
			match(Identifier);
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(546);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassType_lfno_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassType_lfno_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() throws RecognitionException {
		ClassType_lfno_classOrInterfaceTypeContext _localctx = new ClassType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classType_lfno_classOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(549);
				annotation();
				}
				}
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(555);
			match(Identifier);
			setState(557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(556);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public InterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceTypeContext interfaceType() throws RecognitionException {
		InterfaceTypeContext _localctx = new InterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_interfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			classType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceType_lf_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lf_classOrInterfaceTypeContext classType_lf_classOrInterfaceType() {
			return getRuleContext(ClassType_lf_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lf_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lf_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType_lf_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType_lf_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType_lf_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceType_lf_classOrInterfaceTypeContext interfaceType_lf_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lf_classOrInterfaceTypeContext _localctx = new InterfaceType_lf_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_interfaceType_lf_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			classType_lf_classOrInterfaceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceType_lfno_classOrInterfaceTypeContext extends ParserRuleContext {
		public ClassType_lfno_classOrInterfaceTypeContext classType_lfno_classOrInterfaceType() {
			return getRuleContext(ClassType_lfno_classOrInterfaceTypeContext.class,0);
		}
		public InterfaceType_lfno_classOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceType_lfno_classOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceType_lfno_classOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceType_lfno_classOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceType_lfno_classOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceType_lfno_classOrInterfaceTypeContext interfaceType_lfno_classOrInterfaceType() throws RecognitionException {
		InterfaceType_lfno_classOrInterfaceTypeContext _localctx = new InterfaceType_lfno_classOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_interfaceType_lfno_classOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			classType_lfno_classOrInterfaceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(565);
				annotation();
				}
				}
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(571);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arrayType);
		try {
			setState(582);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(573);
				primitiveType();
				setState(574);
				dims();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				classOrInterfaceType();
				setState(577);
				dims();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				typeVariable();
				setState(580);
				dims();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DimsContext extends ParserRuleContext {
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDims(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDims(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dims);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(584);
				annotation();
				}
				}
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(590);
			match(LBRACK);
			setState(591);
			match(RBRACK);
			setState(602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(595);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(592);
						annotation();
						}
						}
						setState(597);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(598);
					match(LBRACK);
					setState(599);
					match(RBRACK);
					}
					} 
				}
				setState(604);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<TypeParameterModifierContext> typeParameterModifier() {
			return getRuleContexts(TypeParameterModifierContext.class);
		}
		public TypeParameterModifierContext typeParameterModifier(int i) {
			return getRuleContext(TypeParameterModifierContext.class,i);
		}
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(605);
				typeParameterModifier();
				}
				}
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(611);
			match(Identifier);
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(612);
				typeBound();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TypeParameterModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameterModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameterModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterModifierContext typeParameterModifier() throws RecognitionException {
		TypeParameterModifierContext _localctx = new TypeParameterModifierContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeParameterModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			annotation();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeBoundContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Java8Parser.EXTENDS, 0); }
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeBound);
		int _la;
		try {
			setState(627);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(617);
				match(EXTENDS);
				setState(618);
				typeVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(619);
				match(EXTENDS);
				setState(620);
				classOrInterfaceType();
				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(621);
					additionalBound();
					}
					}
					setState(626);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditionalBoundContext extends ParserRuleContext {
		public TerminalNode BITAND() { return getToken(Java8Parser.BITAND, 0); }
		public InterfaceTypeContext interfaceType() {
			return getRuleContext(InterfaceTypeContext.class,0);
		}
		public AdditionalBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAdditionalBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAdditionalBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAdditionalBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionalBoundContext additionalBound() throws RecognitionException {
		AdditionalBoundContext _localctx = new AdditionalBoundContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_additionalBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(BITAND);
			setState(630);
			interfaceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(Java8Parser.LT, 0); }
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TerminalNode GT() { return getToken(Java8Parser.GT, 0); }
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			match(LT);
			setState(633);
			typeArgumentList();
			setState(634);
			match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			typeArgument();
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(637);
				match(COMMA);
				setState(638);
				typeArgument();
				}
				}
				setState(643);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeArgument);
		try {
			setState(646);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				referenceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(645);
				wildcard();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WildcardContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(Java8Parser.QUESTION, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public WildcardBoundsContext wildcardBounds() {
			return getRuleContext(WildcardBoundsContext.class,0);
		}
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWildcard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_wildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(648);
				annotation();
				}
				}
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(654);
			match(QUESTION);
			setState(656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(655);
				wildcardBounds();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WildcardBoundsContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Java8Parser.EXTENDS, 0); }
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardBounds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWildcardBounds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWildcardBounds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWildcardBounds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
		WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_wildcardBounds);
		try {
			setState(662);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXTENDS:
				enterOuterAlt(_localctx, 1);
				{
				setState(658);
				match(EXTENDS);
				setState(659);
				referenceType();
				}
				break;
			case SUPER:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				match(SUPER);
				setState(661);
				referenceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		return packageName(0);
	}

	private PackageNameContext packageName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageNameContext _localctx = new PackageNameContext(_ctx, _parentState);
		PackageNameContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_packageName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(665);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(672);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageName);
					setState(667);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(668);
					match(DOT);
					setState(669);
					match(Identifier);
					}
					} 
				}
				setState(674);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeName);
		try {
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				packageOrTypeName(0);
				setState(677);
				match(DOT);
				setState(678);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageOrTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public PackageOrTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageOrTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageOrTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageOrTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageOrTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageOrTypeNameContext packageOrTypeName() throws RecognitionException {
		return packageOrTypeName(0);
	}

	private PackageOrTypeNameContext packageOrTypeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PackageOrTypeNameContext _localctx = new PackageOrTypeNameContext(_ctx, _parentState);
		PackageOrTypeNameContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_packageOrTypeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(683);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(690);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PackageOrTypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_packageOrTypeName);
					setState(685);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(686);
					match(DOT);
					setState(687);
					match(Identifier);
					}
					} 
				}
				setState(692);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public ExpressionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpressionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpressionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpressionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionNameContext expressionName() throws RecognitionException {
		ExpressionNameContext _localctx = new ExpressionNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_expressionName);
		try {
			setState(698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(693);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(694);
				ambiguousName(0);
				setState(695);
				match(DOT);
				setState(696);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public MethodNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodNameContext methodName() throws RecognitionException {
		MethodNameContext _localctx = new MethodNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_methodName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AmbiguousNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AmbiguousNameContext ambiguousName() {
			return getRuleContext(AmbiguousNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public AmbiguousNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ambiguousName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAmbiguousName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAmbiguousName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAmbiguousName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AmbiguousNameContext ambiguousName() throws RecognitionException {
		return ambiguousName(0);
	}

	private AmbiguousNameContext ambiguousName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AmbiguousNameContext _localctx = new AmbiguousNameContext(_ctx, _parentState);
		AmbiguousNameContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_ambiguousName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(703);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(710);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AmbiguousNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_ambiguousName);
					setState(705);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(706);
					match(DOT);
					setState(707);
					match(Identifier);
					}
					} 
				}
				setState(712);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Java8Parser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCompilationUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCompilationUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(713);
				packageDeclaration();
				}
				break;
			}
			setState(719);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(716);
				importDeclaration();
				}
				}
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223371151822749182L) != 0) || _la==AT) {
				{
				{
				setState(722);
				typeDeclaration();
				}
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(728);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(Java8Parser.PACKAGE, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public List<PackageModifierContext> packageModifier() {
			return getRuleContexts(PackageModifierContext.class);
		}
		public PackageModifierContext packageModifier(int i) {
			return getRuleContext(PackageModifierContext.class,i);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(730);
				packageModifier();
				}
				}
				setState(735);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(736);
			match(PACKAGE);
			setState(737);
			packageName(0);
			setState(738);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PackageModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public PackageModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPackageModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPackageModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPackageModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageModifierContext packageModifier() throws RecognitionException {
		PackageModifierContext _localctx = new PackageModifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_packageModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			annotation();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationContext extends ParserRuleContext {
		public SingleTypeImportDeclarationContext singleTypeImportDeclaration() {
			return getRuleContext(SingleTypeImportDeclarationContext.class,0);
		}
		public TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() {
			return getRuleContext(TypeImportOnDemandDeclarationContext.class,0);
		}
		public SingleStaticImportDeclarationContext singleStaticImportDeclaration() {
			return getRuleContext(SingleStaticImportDeclarationContext.class,0);
		}
		public StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() {
			return getRuleContext(StaticImportOnDemandDeclarationContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_importDeclaration);
		try {
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				singleTypeImportDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(743);
				typeImportOnDemandDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(744);
				singleStaticImportDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(745);
				staticImportOnDemandDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleTypeImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Java8Parser.IMPORT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public SingleTypeImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTypeImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleTypeImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleTypeImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleTypeImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTypeImportDeclarationContext singleTypeImportDeclaration() throws RecognitionException {
		SingleTypeImportDeclarationContext _localctx = new SingleTypeImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_singleTypeImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			match(IMPORT);
			setState(749);
			typeName();
			setState(750);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeImportOnDemandDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Java8Parser.IMPORT, 0); }
		public PackageOrTypeNameContext packageOrTypeName() {
			return getRuleContext(PackageOrTypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TypeImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeImportOnDemandDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeImportOnDemandDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeImportOnDemandDeclarationContext typeImportOnDemandDeclaration() throws RecognitionException {
		TypeImportOnDemandDeclarationContext _localctx = new TypeImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_typeImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(752);
			match(IMPORT);
			setState(753);
			packageOrTypeName(0);
			setState(754);
			match(DOT);
			setState(755);
			match(MUL);
			setState(756);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleStaticImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Java8Parser.IMPORT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public SingleStaticImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStaticImportDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleStaticImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleStaticImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleStaticImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStaticImportDeclarationContext singleStaticImportDeclaration() throws RecognitionException {
		SingleStaticImportDeclarationContext _localctx = new SingleStaticImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_singleStaticImportDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(IMPORT);
			setState(759);
			match(STATIC);
			setState(760);
			typeName();
			setState(761);
			match(DOT);
			setState(762);
			match(Identifier);
			setState(763);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StaticImportOnDemandDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Java8Parser.IMPORT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public StaticImportOnDemandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticImportOnDemandDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStaticImportOnDemandDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStaticImportOnDemandDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStaticImportOnDemandDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticImportOnDemandDeclarationContext staticImportOnDemandDeclaration() throws RecognitionException {
		StaticImportOnDemandDeclarationContext _localctx = new StaticImportOnDemandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_staticImportOnDemandDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			match(IMPORT);
			setState(766);
			match(STATIC);
			setState(767);
			typeName();
			setState(768);
			match(DOT);
			setState(769);
			match(MUL);
			setState(770);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_typeDeclaration);
		try {
			setState(775);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(772);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(773);
				interfaceDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(774);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public NormalClassDeclarationContext normalClassDeclaration() {
			return getRuleContext(NormalClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_classDeclaration);
		try {
			setState(779);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(777);
				normalClassDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(778);
				enumDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NormalClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(Java8Parser.CLASS, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public SuperclassContext superclass() {
			return getRuleContext(SuperclassContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public NormalClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalClassDeclarationContext normalClassDeclaration() throws RecognitionException {
		NormalClassDeclarationContext _localctx = new NormalClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_normalClassDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 884763525122L) != 0) || _la==AT) {
				{
				{
				setState(781);
				classModifier();
				}
				}
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(787);
			match(CLASS);
			setState(788);
			match(Identifier);
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(789);
				typeParameters();
				}
			}

			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(792);
				superclass();
				}
			}

			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(795);
				superinterfaces();
				}
			}

			setState(798);
			classBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(Java8Parser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(Java8Parser.PRIVATE, 0); }
		public TerminalNode ABSTRACT() { return getToken(Java8Parser.ABSTRACT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode FINAL() { return getToken(Java8Parser.FINAL, 0); }
		public TerminalNode STRICTFP() { return getToken(Java8Parser.STRICTFP, 0); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_classModifier);
		try {
			setState(808);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(800);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(801);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(802);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(803);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(804);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(805);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(806);
				match(FINAL);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 8);
				{
				setState(807);
				match(STRICTFP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(Java8Parser.LT, 0); }
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode GT() { return getToken(Java8Parser.GT, 0); }
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_typeParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
			match(LT);
			setState(811);
			typeParameterList();
			setState(812);
			match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			typeParameter();
			setState(819);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(815);
				match(COMMA);
				setState(816);
				typeParameter();
				}
				}
				setState(821);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuperclassContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Java8Parser.EXTENDS, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public SuperclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSuperclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSuperclass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSuperclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperclassContext superclass() throws RecognitionException {
		SuperclassContext _localctx = new SuperclassContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_superclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(EXTENDS);
			setState(823);
			classType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuperinterfacesContext extends ParserRuleContext {
		public TerminalNode IMPLEMENTS() { return getToken(Java8Parser.IMPLEMENTS, 0); }
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superinterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSuperinterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSuperinterfaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSuperinterfaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperinterfacesContext superinterfaces() throws RecognitionException {
		SuperinterfacesContext _localctx = new SuperinterfacesContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_superinterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825);
			match(IMPLEMENTS);
			setState(826);
			interfaceTypeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceTypeListContext extends ParserRuleContext {
		public List<InterfaceTypeContext> interfaceType() {
			return getRuleContexts(InterfaceTypeContext.class);
		}
		public InterfaceTypeContext interfaceType(int i) {
			return getRuleContext(InterfaceTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public InterfaceTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceTypeListContext interfaceTypeList() throws RecognitionException {
		InterfaceTypeListContext _localctx = new InterfaceTypeListContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_interfaceTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			interfaceType();
			setState(833);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(829);
				match(COMMA);
				setState(830);
				interfaceType();
				}
				}
				setState(835);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			match(LBRACE);
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8645991068613655766L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 51539607553L) != 0)) {
				{
				{
				setState(837);
				classBodyDeclaration();
				}
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(843);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public ClassMemberDeclarationContext classMemberDeclaration() {
			return getRuleContext(ClassMemberDeclarationContext.class,0);
		}
		public InstanceInitializerContext instanceInitializer() {
			return getRuleContext(InstanceInitializerContext.class,0);
		}
		public StaticInitializerContext staticInitializer() {
			return getRuleContext(StaticInitializerContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassBodyDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassBodyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_classBodyDeclaration);
		try {
			setState(849);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(845);
				classMemberDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(846);
				instanceInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(847);
				staticInitializer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(848);
				constructorDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberDeclarationContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public ClassMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberDeclarationContext classMemberDeclaration() throws RecognitionException {
		ClassMemberDeclarationContext _localctx = new ClassMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_classMemberDeclaration);
		try {
			setState(856);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(851);
				fieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(852);
				methodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(853);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(854);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(855);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public List<FieldModifierContext> fieldModifier() {
			return getRuleContexts(FieldModifierContext.class);
		}
		public FieldModifierContext fieldModifier(int i) {
			return getRuleContext(FieldModifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 633653705310208L) != 0) || _la==AT) {
				{
				{
				setState(858);
				fieldModifier();
				}
				}
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(864);
			unannType();
			setState(865);
			variableDeclaratorList();
			setState(866);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(Java8Parser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(Java8Parser.PRIVATE, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode FINAL() { return getToken(Java8Parser.FINAL, 0); }
		public TerminalNode TRANSIENT() { return getToken(Java8Parser.TRANSIENT, 0); }
		public TerminalNode VOLATILE() { return getToken(Java8Parser.VOLATILE, 0); }
		public FieldModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldModifierContext fieldModifier() throws RecognitionException {
		FieldModifierContext _localctx = new FieldModifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_fieldModifier);
		try {
			setState(876);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(868);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(869);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(870);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(871);
				match(PRIVATE);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(872);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(873);
				match(FINAL);
				}
				break;
			case TRANSIENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(874);
				match(TRANSIENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(875);
				match(VOLATILE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorListContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public VariableDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclaratorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclaratorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorListContext variableDeclaratorList() throws RecognitionException {
		VariableDeclaratorListContext _localctx = new VariableDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_variableDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
			variableDeclarator();
			setState(883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(879);
				match(COMMA);
				setState(880);
				variableDeclarator();
				}
				}
				setState(885);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Java8Parser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
			variableDeclaratorId();
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(887);
				match(ASSIGN);
				setState(888);
				variableInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableDeclaratorId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableDeclaratorId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(891);
			match(Identifier);
			setState(893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(892);
				dims();
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_variableInitializer);
		try {
			setState(897);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(895);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(896);
				arrayInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public UnannReferenceTypeContext unannReferenceType() {
			return getRuleContext(UnannReferenceTypeContext.class,0);
		}
		public UnannTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannTypeContext unannType() throws RecognitionException {
		UnannTypeContext _localctx = new UnannTypeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_unannType);
		try {
			setState(901);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(899);
				unannPrimitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(900);
				unannReferenceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannPrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(Java8Parser.BOOLEAN, 0); }
		public UnannPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannPrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannPrimitiveTypeContext unannPrimitiveType() throws RecognitionException {
		UnannPrimitiveTypeContext _localctx = new UnannPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_unannPrimitiveType);
		try {
			setState(905);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(903);
				numericType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(904);
				match(BOOLEAN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannReferenceTypeContext extends ParserRuleContext {
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext unannArrayType() {
			return getRuleContext(UnannArrayTypeContext.class,0);
		}
		public UnannReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannReferenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannReferenceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannReferenceTypeContext unannReferenceType() throws RecognitionException {
		UnannReferenceTypeContext _localctx = new UnannReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_unannReferenceType);
		try {
			setState(910);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(907);
				unannClassOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(908);
				unannTypeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(909);
				unannArrayType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public List<UnannClassType_lf_unannClassOrInterfaceTypeContext> unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannClassType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public List<UnannInterfaceType_lf_unannClassOrInterfaceTypeContext> unannInterfaceType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public UnannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() throws RecognitionException {
		UnannClassOrInterfaceTypeContext _localctx = new UnannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_unannClassOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(912);
				unannClassType_lfno_unannClassOrInterfaceType();
				}
				break;
			case 2:
				{
				setState(913);
				unannInterfaceType_lfno_unannClassOrInterfaceType();
				}
				break;
			}
			setState(920);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(918);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						setState(916);
						unannClassType_lf_unannClassOrInterfaceType();
						}
						break;
					case 2:
						{
						setState(917);
						unannInterfaceType_lf_unannClassOrInterfaceType();
						}
						break;
					}
					} 
				}
				setState(922);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannClassTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public UnannClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassTypeContext unannClassType() throws RecognitionException {
		UnannClassTypeContext _localctx = new UnannClassTypeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_unannClassType);
		int _la;
		try {
			setState(939);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(923);
				match(Identifier);
				setState(925);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(924);
					typeArguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(927);
				unannClassOrInterfaceType();
				setState(928);
				match(DOT);
				setState(932);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(929);
					annotation();
					}
					}
					setState(934);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(935);
				match(Identifier);
				setState(937);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(936);
					typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannClassType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType_lf_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_unannClassType_lf_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			match(DOT);
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(942);
				annotation();
				}
				}
				setState(947);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(948);
			match(Identifier);
			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(949);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannClassType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannClassType_lfno_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_unannClassType_lfno_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(952);
			match(Identifier);
			setState(954);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(953);
				typeArguments();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannInterfaceTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public UnannInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceTypeContext unannInterfaceType() throws RecognitionException {
		UnannInterfaceTypeContext _localctx = new UnannInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_unannInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(956);
			unannClassType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannInterfaceType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_unannInterfaceType_lf_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			unannClassType_lf_unannClassOrInterfaceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			unannClassType_lfno_unannClassOrInterfaceType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannTypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public UnannTypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannTypeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannTypeVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannTypeVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannTypeVariableContext unannTypeVariable() throws RecognitionException {
		UnannTypeVariableContext _localctx = new UnannTypeVariableContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_unannTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(962);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnannArrayTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannArrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnannArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnannArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnannArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnannArrayTypeContext unannArrayType() throws RecognitionException {
		UnannArrayTypeContext _localctx = new UnannArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_unannArrayType);
		try {
			setState(973);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(964);
				unannPrimitiveType();
				setState(965);
				dims();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(967);
				unannClassOrInterfaceType();
				setState(968);
				dims();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(970);
				unannTypeVariable();
				setState(971);
				dims();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<MethodModifierContext> methodModifier() {
			return getRuleContexts(MethodModifierContext.class);
		}
		public MethodModifierContext methodModifier(int i) {
			return getRuleContext(MethodModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5283883778050L) != 0) || _la==AT) {
				{
				{
				setState(975);
				methodModifier();
				}
				}
				setState(980);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(981);
			methodHeader();
			setState(982);
			methodBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(Java8Parser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(Java8Parser.PRIVATE, 0); }
		public TerminalNode ABSTRACT() { return getToken(Java8Parser.ABSTRACT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode FINAL() { return getToken(Java8Parser.FINAL, 0); }
		public TerminalNode SYNCHRONIZED() { return getToken(Java8Parser.SYNCHRONIZED, 0); }
		public TerminalNode NATIVE() { return getToken(Java8Parser.NATIVE, 0); }
		public TerminalNode STRICTFP() { return getToken(Java8Parser.STRICTFP, 0); }
		public MethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodModifierContext methodModifier() throws RecognitionException {
		MethodModifierContext _localctx = new MethodModifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_methodModifier);
		try {
			setState(994);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(984);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(985);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(986);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(987);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(988);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(989);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(990);
				match(FINAL);
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 8);
				{
				setState(991);
				match(SYNCHRONIZED);
				}
				break;
			case NATIVE:
				enterOuterAlt(_localctx, 9);
				{
				setState(992);
				match(NATIVE);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 10);
				{
				setState(993);
				match(STRICTFP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodHeaderContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_methodHeader);
		int _la;
		try {
			setState(1013);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(996);
				result();
				setState(997);
				methodDeclarator();
				setState(999);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(998);
					throws_();
					}
				}

				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1001);
				typeParameters();
				setState(1005);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1002);
					annotation();
					}
					}
					setState(1007);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1008);
				result();
				setState(1009);
				methodDeclarator();
				setState(1011);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(1010);
					throws_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResultContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(Java8Parser.VOID, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_result);
		try {
			setState(1017);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1015);
				unannType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(1016);
				match(VOID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_methodDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019);
			match(Identifier);
			setState(1020);
			match(LPAREN);
			setState(1022);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 138111369512L) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1021);
				formalParameterList();
				}
			}

			setState(1024);
			match(RPAREN);
			setState(1026);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1025);
				dims();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends ParserRuleContext {
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Java8Parser.COMMA, 0); }
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_formalParameterList);
		try {
			setState(1034);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1028);
				receiverParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1029);
				formalParameters();
				setState(1030);
				match(COMMA);
				setState(1031);
				lastFormalParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1033);
				lastFormalParameter();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_formalParameters);
		try {
			int _alt;
			setState(1052);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1036);
				formalParameter();
				setState(1041);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1037);
						match(COMMA);
						setState(1038);
						formalParameter();
						}
						} 
					}
					setState(1043);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1044);
				receiverParameter();
				setState(1049);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1045);
						match(COMMA);
						setState(1046);
						formalParameter();
						}
						} 
					}
					setState(1051);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1054);
				variableModifier();
				}
				}
				setState(1059);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1060);
			unannType();
			setState(1061);
			variableDeclaratorId();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode FINAL() { return getToken(Java8Parser.FINAL, 0); }
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_variableModifier);
		try {
			setState(1065);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1063);
				annotation();
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1064);
				match(FINAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LastFormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(Java8Parser.ELLIPSIS, 0); }
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLastFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLastFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_lastFormalParameter);
		int _la;
		try {
			setState(1084);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1070);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FINAL || _la==AT) {
					{
					{
					setState(1067);
					variableModifier();
					}
					}
					setState(1072);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1073);
				unannType();
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1074);
					annotation();
					}
					}
					setState(1079);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1080);
				match(ELLIPSIS);
				setState(1081);
				variableDeclaratorId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1083);
				formalParameter();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReceiverParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReceiverParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1086);
				annotation();
				}
				}
				setState(1091);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1092);
			unannType();
			setState(1095);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1093);
				match(Identifier);
				setState(1094);
				match(DOT);
				}
			}

			setState(1097);
			match(THIS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Throws_Context extends ParserRuleContext {
		public TerminalNode THROWS() { return getToken(Java8Parser.THROWS, 0); }
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public Throws_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throws_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterThrows_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitThrows_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitThrows_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Throws_Context throws_() throws RecognitionException {
		Throws_Context _localctx = new Throws_Context(_ctx, getState());
		enterRule(_localctx, 160, RULE_throws_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1099);
			match(THROWS);
			setState(1100);
			exceptionTypeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExceptionTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExceptionTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExceptionTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1102);
			exceptionType();
			setState(1107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1103);
				match(COMMA);
				setState(1104);
				exceptionType();
				}
				}
				setState(1109);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExceptionTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExceptionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExceptionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_exceptionType);
		try {
			setState(1112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1110);
				classType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1111);
				typeVariable();
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_methodBody);
		try {
			setState(1116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1114);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1115);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstanceInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InstanceInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInstanceInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInstanceInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInstanceInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceInitializerContext instanceInitializer() throws RecognitionException {
		InstanceInitializerContext _localctx = new InstanceInitializerContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_instanceInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StaticInitializerContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StaticInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStaticInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStaticInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStaticInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaticInitializerContext staticInitializer() throws RecognitionException {
		StaticInitializerContext _localctx = new StaticInitializerContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_staticInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1120);
			match(STATIC);
			setState(1121);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ConstructorDeclaratorContext constructorDeclarator() {
			return getRuleContext(ConstructorDeclaratorContext.class,0);
		}
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public List<ConstructorModifierContext> constructorModifier() {
			return getRuleContexts(ConstructorModifierContext.class);
		}
		public ConstructorModifierContext constructorModifier(int i) {
			return getRuleContext(ConstructorModifierContext.class,i);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0) || _la==AT) {
				{
				{
				setState(1123);
				constructorModifier();
				}
				}
				setState(1128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1129);
			constructorDeclarator();
			setState(1131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(1130);
				throws_();
				}
			}

			setState(1133);
			constructorBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(Java8Parser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(Java8Parser.PRIVATE, 0); }
		public ConstructorModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorModifierContext constructorModifier() throws RecognitionException {
		ConstructorModifierContext _localctx = new ConstructorModifierContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_constructorModifier);
		try {
			setState(1139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1135);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1136);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1137);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1138);
				match(PRIVATE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclaratorContext extends ParserRuleContext {
		public SimpleTypeNameContext simpleTypeName() {
			return getRuleContext(SimpleTypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ConstructorDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorDeclarator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorDeclarator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclaratorContext constructorDeclarator() throws RecognitionException {
		ConstructorDeclaratorContext _localctx = new ConstructorDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_constructorDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1141);
				typeParameters();
				}
			}

			setState(1144);
			simpleTypeName();
			setState(1145);
			match(LPAREN);
			setState(1147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 138111369512L) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1146);
				formalParameterList();
				}
			}

			setState(1149);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public SimpleTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSimpleTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSimpleTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSimpleTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleTypeNameContext simpleTypeName() throws RecognitionException {
		SimpleTypeNameContext _localctx = new SimpleTypeNameContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_simpleTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
			return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstructorBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstructorBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
			match(LBRACE);
			setState(1155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(1154);
				explicitConstructorInvocation();
				}
				break;
			}
			setState(1158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8359349417232995522L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1157);
				blockStatements();
				}
			}

			setState(1160);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExplicitConstructorInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExplicitConstructorInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(1208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1162);
					typeArguments();
					}
				}

				setState(1165);
				match(THIS);
				setState(1166);
				match(LPAREN);
				setState(1168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(1167);
					argumentList();
					}
				}

				setState(1170);
				match(RPAREN);
				setState(1171);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1172);
					typeArguments();
					}
				}

				setState(1175);
				match(SUPER);
				setState(1176);
				match(LPAREN);
				setState(1178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(1177);
					argumentList();
					}
				}

				setState(1180);
				match(RPAREN);
				setState(1181);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1182);
				expressionName();
				setState(1183);
				match(DOT);
				setState(1185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1184);
					typeArguments();
					}
				}

				setState(1187);
				match(SUPER);
				setState(1188);
				match(LPAREN);
				setState(1190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(1189);
					argumentList();
					}
				}

				setState(1192);
				match(RPAREN);
				setState(1193);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1195);
				primary();
				setState(1196);
				match(DOT);
				setState(1198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1197);
					typeArguments();
					}
				}

				setState(1200);
				match(SUPER);
				setState(1201);
				match(LPAREN);
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(1202);
					argumentList();
					}
				}

				setState(1205);
				match(RPAREN);
				setState(1206);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(Java8Parser.ENUM, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public List<ClassModifierContext> classModifier() {
			return getRuleContexts(ClassModifierContext.class);
		}
		public ClassModifierContext classModifier(int i) {
			return getRuleContext(ClassModifierContext.class,i);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 884763525122L) != 0) || _la==AT) {
				{
				{
				setState(1210);
				classModifier();
				}
				}
				setState(1215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1216);
			match(ENUM);
			setState(1217);
			match(Identifier);
			setState(1219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(1218);
				superinterfaces();
				}
			}

			setState(1221);
			enumBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public EnumConstantListContext enumConstantList() {
			return getRuleContext(EnumConstantListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Java8Parser.COMMA, 0); }
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1223);
			match(LBRACE);
			setState(1225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(1224);
				enumConstantList();
				}
			}

			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1227);
				match(COMMA);
				}
			}

			setState(1231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1230);
				enumBodyDeclarations();
				}
			}

			setState(1233);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantListContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public EnumConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantListContext enumConstantList() throws RecognitionException {
		EnumConstantListContext _localctx = new EnumConstantListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_enumConstantList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1235);
			enumConstant();
			setState(1240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1236);
					match(COMMA);
					setState(1237);
					enumConstant();
					}
					} 
				}
				setState(1242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,117,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public List<EnumConstantModifierContext> enumConstantModifier() {
			return getRuleContexts(EnumConstantModifierContext.class);
		}
		public EnumConstantModifierContext enumConstantModifier(int i) {
			return getRuleContext(EnumConstantModifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1243);
				enumConstantModifier();
				}
				}
				setState(1248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1249);
			match(Identifier);
			setState(1255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1250);
				match(LPAREN);
				setState(1252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(1251);
					argumentList();
					}
				}

				setState(1254);
				match(RPAREN);
				}
			}

			setState(1258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(1257);
				classBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public EnumConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantModifierContext enumConstantModifier() throws RecognitionException {
		EnumConstantModifierContext _localctx = new EnumConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_enumConstantModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1260);
			annotation();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumBodyDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumBodyDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1262);
			match(SEMI);
			setState(1266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8645991068613655766L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 51539607553L) != 0)) {
				{
				{
				setState(1263);
				classBodyDeclaration();
				}
				}
				setState(1268);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_interfaceDeclaration);
		try {
			setState(1271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1269);
				normalInterfaceDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1270);
				annotationTypeDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(Java8Parser.INTERFACE, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsInterfacesContext extendsInterfaces() {
			return getRuleContext(ExtendsInterfacesContext.class,0);
		}
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 884763262978L) != 0) || _la==AT) {
				{
				{
				setState(1273);
				interfaceModifier();
				}
				}
				setState(1278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1279);
			match(INTERFACE);
			setState(1280);
			match(Identifier);
			setState(1282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1281);
				typeParameters();
				}
			}

			setState(1285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(1284);
				extendsInterfaces();
				}
			}

			setState(1287);
			interfaceBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(Java8Parser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(Java8Parser.PRIVATE, 0); }
		public TerminalNode ABSTRACT() { return getToken(Java8Parser.ABSTRACT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode STRICTFP() { return getToken(Java8Parser.STRICTFP, 0); }
		public InterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceModifierContext interfaceModifier() throws RecognitionException {
		InterfaceModifierContext _localctx = new InterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_interfaceModifier);
		try {
			setState(1296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1289);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1290);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(1291);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1292);
				match(PRIVATE);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1293);
				match(ABSTRACT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(1294);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 7);
				{
				setState(1295);
				match(STRICTFP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExtendsInterfacesContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Java8Parser.EXTENDS, 0); }
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public ExtendsInterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsInterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExtendsInterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExtendsInterfaces(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExtendsInterfaces(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsInterfacesContext extendsInterfaces() throws RecognitionException {
		ExtendsInterfacesContext _localctx = new ExtendsInterfacesContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_extendsInterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298);
			match(EXTENDS);
			setState(1299);
			interfaceTypeList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<InterfaceMemberDeclarationContext> interfaceMemberDeclaration() {
			return getRuleContexts(InterfaceMemberDeclarationContext.class);
		}
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration(int i) {
			return getRuleContext(InterfaceMemberDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1301);
			match(LBRACE);
			setState(1305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223089538734927062L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 51539607553L) != 0)) {
				{
				{
				setState(1302);
				interfaceMemberDeclaration();
				}
				}
				setState(1307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1308);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_interfaceMemberDeclaration);
		try {
			setState(1315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1310);
				constantDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1311);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1312);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1313);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1314);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public List<ConstantModifierContext> constantModifier() {
			return getRuleContexts(ConstantModifierContext.class);
		}
		public ConstantModifierContext constantModifier(int i) {
			return getRuleContext(ConstantModifierContext.class,i);
		}
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_constantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 309237907456L) != 0) || _la==AT) {
				{
				{
				setState(1317);
				constantModifier();
				}
				}
				setState(1322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1323);
			unannType();
			setState(1324);
			variableDeclaratorList();
			setState(1325);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode FINAL() { return getToken(Java8Parser.FINAL, 0); }
		public ConstantModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantModifierContext constantModifier() throws RecognitionException {
		ConstantModifierContext _localctx = new ConstantModifierContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_constantModifier);
		try {
			setState(1331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1327);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1328);
				match(PUBLIC);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(1329);
				match(STATIC);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(1330);
				match(FINAL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 858993463298L) != 0) || _la==AT) {
				{
				{
				setState(1333);
				interfaceMethodModifier();
				}
				}
				setState(1338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1339);
			methodHeader();
			setState(1340);
			methodBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(Java8Parser.ABSTRACT, 0); }
		public TerminalNode DEFAULT() { return getToken(Java8Parser.DEFAULT, 0); }
		public TerminalNode STATIC() { return getToken(Java8Parser.STATIC, 0); }
		public TerminalNode STRICTFP() { return getToken(Java8Parser.STRICTFP, 0); }
		public InterfaceMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInterfaceMethodModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInterfaceMethodModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInterfaceMethodModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodModifierContext interfaceMethodModifier() throws RecognitionException {
		InterfaceMethodModifierContext _localctx = new InterfaceMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_interfaceMethodModifier);
		try {
			setState(1348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1342);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1343);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1344);
				match(ABSTRACT);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1345);
				match(DEFAULT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(1346);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 6);
				{
				setState(1347);
				match(STRICTFP);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Java8Parser.AT, 0); }
		public TerminalNode INTERFACE() { return getToken(Java8Parser.INTERFACE, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public List<InterfaceModifierContext> interfaceModifier() {
			return getRuleContexts(InterfaceModifierContext.class);
		}
		public InterfaceModifierContext interfaceModifier(int i) {
			return getRuleContext(InterfaceModifierContext.class,i);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_annotationTypeDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1353);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1350);
					interfaceModifier();
					}
					} 
				}
				setState(1355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			setState(1356);
			match(AT);
			setState(1357);
			match(INTERFACE);
			setState(1358);
			match(Identifier);
			setState(1359);
			annotationTypeBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<AnnotationTypeMemberDeclarationContext> annotationTypeMemberDeclaration() {
			return getRuleContexts(AnnotationTypeMemberDeclarationContext.class);
		}
		public AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration(int i) {
			return getRuleContext(AnnotationTypeMemberDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1361);
			match(LBRACE);
			setState(1365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223371013711641814L) != 0) || _la==Identifier || _la==AT) {
				{
				{
				setState(1362);
				annotationTypeMemberDeclaration();
				}
				}
				setState(1367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1368);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeMemberDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public AnnotationTypeMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration() throws RecognitionException {
		AnnotationTypeMemberDeclarationContext _localctx = new AnnotationTypeMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_annotationTypeMemberDeclaration);
		try {
			setState(1375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1370);
				annotationTypeElementDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1371);
				constantDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1372);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1373);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1374);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public List<AnnotationTypeElementModifierContext> annotationTypeElementModifier() {
			return getRuleContexts(AnnotationTypeElementModifierContext.class);
		}
		public AnnotationTypeElementModifierContext annotationTypeElementModifier(int i) {
			return getRuleContext(AnnotationTypeElementModifierContext.class,i);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeElementDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeElementDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_annotationTypeElementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABSTRACT || _la==PUBLIC || _la==AT) {
				{
				{
				setState(1377);
				annotationTypeElementModifier();
				}
				}
				setState(1382);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1383);
			unannType();
			setState(1384);
			match(Identifier);
			setState(1385);
			match(LPAREN);
			setState(1386);
			match(RPAREN);
			setState(1388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK || _la==AT) {
				{
				setState(1387);
				dims();
				}
			}

			setState(1391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1390);
				defaultValue();
				}
			}

			setState(1393);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(Java8Parser.PUBLIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(Java8Parser.ABSTRACT, 0); }
		public AnnotationTypeElementModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotationTypeElementModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotationTypeElementModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotationTypeElementModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationTypeElementModifierContext annotationTypeElementModifier() throws RecognitionException {
		AnnotationTypeElementModifierContext _localctx = new AnnotationTypeElementModifierContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_annotationTypeElementModifier);
		try {
			setState(1398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1395);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1396);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1397);
				match(ABSTRACT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(Java8Parser.DEFAULT, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1400);
			match(DEFAULT);
			setState(1401);
			elementValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public NormalAnnotationContext normalAnnotation() {
			return getRuleContext(NormalAnnotationContext.class,0);
		}
		public MarkerAnnotationContext markerAnnotation() {
			return getRuleContext(MarkerAnnotationContext.class,0);
		}
		public SingleElementAnnotationContext singleElementAnnotation() {
			return getRuleContext(SingleElementAnnotationContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_annotation);
		try {
			setState(1406);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1403);
				normalAnnotation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1404);
				markerAnnotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1405);
				singleElementAnnotation();
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

	@SuppressWarnings("CheckReturnValue")
	public static class NormalAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Java8Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ElementValuePairListContext elementValuePairList() {
			return getRuleContext(ElementValuePairListContext.class,0);
		}
		public NormalAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterNormalAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitNormalAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitNormalAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalAnnotationContext normalAnnotation() throws RecognitionException {
		NormalAnnotationContext _localctx = new NormalAnnotationContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_normalAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408);
			match(AT);
			setState(1409);
			typeName();
			setState(1410);
			match(LPAREN);
			setState(1412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1411);
				elementValuePairList();
				}
			}

			setState(1414);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairListContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public ElementValuePairListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValuePairList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValuePairList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValuePairList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairListContext elementValuePairList() throws RecognitionException {
		ElementValuePairListContext _localctx = new ElementValuePairListContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_elementValuePairList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1416);
			elementValuePair();
			setState(1421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1417);
				match(COMMA);
				setState(1418);
				elementValuePair();
				}
				}
				setState(1423);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode ASSIGN() { return getToken(Java8Parser.ASSIGN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1424);
			match(Identifier);
			setState(1425);
			match(ASSIGN);
			setState(1426);
			elementValue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_elementValue);
		try {
			setState(1431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1428);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1429);
				elementValueArrayInitializer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1430);
				annotation();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public ElementValueListContext elementValueList() {
			return getRuleContext(ElementValueListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Java8Parser.COMMA, 0); }
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValueArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValueArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_elementValueArrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1433);
			match(LBRACE);
			setState(1435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 862730839481401640L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(1434);
				elementValueList();
				}
			}

			setState(1438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1437);
				match(COMMA);
				}
			}

			setState(1440);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueListContext extends ParserRuleContext {
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public ElementValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterElementValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitElementValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitElementValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementValueListContext elementValueList() throws RecognitionException {
		ElementValueListContext _localctx = new ElementValueListContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_elementValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1442);
			elementValue();
			setState(1447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1443);
					match(COMMA);
					setState(1444);
					elementValue();
					}
					} 
				}
				setState(1449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MarkerAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Java8Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MarkerAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markerAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMarkerAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMarkerAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMarkerAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MarkerAnnotationContext markerAnnotation() throws RecognitionException {
		MarkerAnnotationContext _localctx = new MarkerAnnotationContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_markerAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1450);
			match(AT);
			setState(1451);
			typeName();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SingleElementAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Java8Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public SingleElementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleElementAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSingleElementAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSingleElementAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSingleElementAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleElementAnnotationContext singleElementAnnotation() throws RecognitionException {
		SingleElementAnnotationContext _localctx = new SingleElementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_singleElementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1453);
			match(AT);
			setState(1454);
			typeName();
			setState(1455);
			match(LPAREN);
			setState(1456);
			elementValue();
			setState(1457);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public VariableInitializerListContext variableInitializerList() {
			return getRuleContext(VariableInitializerListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Java8Parser.COMMA, 0); }
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1459);
			match(LBRACE);
			setState(1461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 862730839481401640L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(1460);
				variableInitializerList();
				}
			}

			setState(1464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1463);
				match(COMMA);
				}
			}

			setState(1466);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableInitializerListContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public VariableInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterVariableInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitVariableInitializerList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitVariableInitializerList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializerListContext variableInitializerList() throws RecognitionException {
		VariableInitializerListContext _localctx = new VariableInitializerListContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_variableInitializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1468);
			variableInitializer();
			setState(1473);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1469);
					match(COMMA);
					setState(1470);
					variableInitializer();
					}
					} 
				}
				setState(1475);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,150,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1476);
			match(LBRACE);
			setState(1478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8359349417232995522L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1477);
				blockStatements();
				}
			}

			setState(1480);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementsContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementsContext blockStatements() throws RecognitionException {
		BlockStatementsContext _localctx = new BlockStatementsContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_blockStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1483); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1482);
				blockStatement();
				}
				}
				setState(1485); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8359349417232995522L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_blockStatement);
		try {
			setState(1490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1487);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1488);
				classDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1489);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLocalVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLocalVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1492);
			localVariableDeclaration();
			setState(1493);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLocalVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLocalVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1498);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1495);
				variableModifier();
				}
				}
				setState(1500);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1501);
			unannType();
			setState(1502);
			variableDeclaratorList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public IfThenElseStatementContext ifThenElseStatement() {
			return getRuleContext(IfThenElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_statement);
		try {
			setState(1510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1504);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1505);
				labeledStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1506);
				ifThenStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1507);
				ifThenElseStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1508);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1509);
				forStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementNoShortIfContext extends ParserRuleContext {
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementNoShortIfContext labeledStatementNoShortIf() {
			return getRuleContext(LabeledStatementNoShortIfContext.class,0);
		}
		public IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() {
			return getRuleContext(IfThenElseStatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext whileStatementNoShortIf() {
			return getRuleContext(WhileStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext forStatementNoShortIf() {
			return getRuleContext(ForStatementNoShortIfContext.class,0);
		}
		public StatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementNoShortIfContext statementNoShortIf() throws RecognitionException {
		StatementNoShortIfContext _localctx = new StatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_statementNoShortIf);
		try {
			setState(1517);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1512);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1513);
				labeledStatementNoShortIf();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1514);
				ifThenElseStatementNoShortIf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1515);
				whileStatementNoShortIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1516);
				forStatementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementWithoutTrailingSubstatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithoutTrailingSubstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementWithoutTrailingSubstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() throws RecognitionException {
		StatementWithoutTrailingSubstatementContext _localctx = new StatementWithoutTrailingSubstatementContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_statementWithoutTrailingSubstatement);
		try {
			setState(1531);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1519);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1520);
				emptyStatement();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case INC:
			case DEC:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1521);
				expressionStatement();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1522);
				assertStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(1523);
				switchStatement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 6);
				{
				setState(1524);
				doStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(1525);
				breakStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(1526);
				continueStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(1527);
				returnStatement();
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 10);
				{
				setState(1528);
				synchronizedStatement();
				}
				break;
			case THROW:
				enterOuterAlt(_localctx, 11);
				{
				setState(1529);
				throwStatement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 12);
				{
				setState(1530);
				tryStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1533);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLabeledStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLabeledStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1535);
			match(Identifier);
			setState(1536);
			match(COLON);
			setState(1537);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabeledStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public LabeledStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLabeledStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLabeledStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLabeledStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabeledStatementNoShortIfContext labeledStatementNoShortIf() throws RecognitionException {
		LabeledStatementNoShortIfContext _localctx = new LabeledStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_labeledStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1539);
			match(Identifier);
			setState(1540);
			match(COLON);
			setState(1541);
			statementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1543);
			statementExpression();
			setState(1544);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public PostIncrementExpressionContext postIncrementExpression() {
			return getRuleContext(PostIncrementExpressionContext.class,0);
		}
		public PostDecrementExpressionContext postDecrementExpression() {
			return getRuleContext(PostDecrementExpressionContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_statementExpression);
		try {
			setState(1553);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1546);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1547);
				preIncrementExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1548);
				preDecrementExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1549);
				postIncrementExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1550);
				postDecrementExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1551);
				methodInvocation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1552);
				classInstanceCreationExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfThenStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Java8Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenStatementContext ifThenStatement() throws RecognitionException {
		IfThenStatementContext _localctx = new IfThenStatementContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_ifThenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1555);
			match(IF);
			setState(1556);
			match(LPAREN);
			setState(1557);
			expression();
			setState(1558);
			match(RPAREN);
			setState(1559);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfThenElseStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Java8Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(Java8Parser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenElseStatementContext ifThenElseStatement() throws RecognitionException {
		IfThenElseStatementContext _localctx = new IfThenElseStatementContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_ifThenElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1561);
			match(IF);
			setState(1562);
			match(LPAREN);
			setState(1563);
			expression();
			setState(1564);
			match(RPAREN);
			setState(1565);
			statementNoShortIf();
			setState(1566);
			match(ELSE);
			setState(1567);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfThenElseStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Java8Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public List<StatementNoShortIfContext> statementNoShortIf() {
			return getRuleContexts(StatementNoShortIfContext.class);
		}
		public StatementNoShortIfContext statementNoShortIf(int i) {
			return getRuleContext(StatementNoShortIfContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Java8Parser.ELSE, 0); }
		public IfThenElseStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterIfThenElseStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitIfThenElseStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitIfThenElseStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() throws RecognitionException {
		IfThenElseStatementNoShortIfContext _localctx = new IfThenElseStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_ifThenElseStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1569);
			match(IF);
			setState(1570);
			match(LPAREN);
			setState(1571);
			expression();
			setState(1572);
			match(RPAREN);
			setState(1573);
			statementNoShortIf();
			setState(1574);
			match(ELSE);
			setState(1575);
			statementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssertStatementContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(Java8Parser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public AssertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssertStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssertStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_assertStatement);
		try {
			setState(1587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1577);
				match(ASSERT);
				setState(1578);
				expression();
				setState(1579);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1581);
				match(ASSERT);
				setState(1582);
				expression();
				setState(1583);
				match(COLON);
				setState(1584);
				expression();
				setState(1585);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(Java8Parser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589);
			match(SWITCH);
			setState(1590);
			match(LPAREN);
			setState(1591);
			expression();
			setState(1592);
			match(RPAREN);
			setState(1593);
			switchBlock();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Java8Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Java8Parser.RBRACE, 0); }
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1595);
			match(LBRACE);
			setState(1599);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1596);
					switchBlockStatementGroup();
					}
					} 
				}
				setState(1601);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			}
			setState(1605);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1602);
				switchLabel();
				}
				}
				setState(1607);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1608);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public SwitchLabelsContext switchLabels() {
			return getRuleContext(SwitchLabelsContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchBlockStatementGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchBlockStatementGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchBlockStatementGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_switchBlockStatementGroup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
			switchLabels();
			setState(1611);
			blockStatements();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabelsContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public SwitchLabelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchLabels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchLabels(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchLabels(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelsContext switchLabels() throws RecognitionException {
		SwitchLabelsContext _localctx = new SwitchLabelsContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_switchLabels);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			switchLabel();
			setState(1617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1614);
				switchLabel();
				}
				}
				setState(1619);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabelContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(Java8Parser.CASE, 0); }
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public EnumConstantNameContext enumConstantName() {
			return getRuleContext(EnumConstantNameContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(Java8Parser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSwitchLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSwitchLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSwitchLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_switchLabel);
		try {
			setState(1630);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,163,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1620);
				match(CASE);
				setState(1621);
				constantExpression();
				setState(1622);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1624);
				match(CASE);
				setState(1625);
				enumConstantName();
				setState(1626);
				match(COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1628);
				match(DEFAULT);
				setState(1629);
				match(COLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public EnumConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnumConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnumConstantName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnumConstantName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumConstantNameContext enumConstantName() throws RecognitionException {
		EnumConstantNameContext _localctx = new EnumConstantNameContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_enumConstantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Java8Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			match(WHILE);
			setState(1635);
			match(LPAREN);
			setState(1636);
			expression();
			setState(1637);
			match(RPAREN);
			setState(1638);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Java8Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterWhileStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitWhileStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitWhileStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementNoShortIfContext whileStatementNoShortIf() throws RecognitionException {
		WhileStatementNoShortIfContext _localctx = new WhileStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_whileStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1640);
			match(WHILE);
			setState(1641);
			match(LPAREN);
			setState(1642);
			expression();
			setState(1643);
			match(RPAREN);
			setState(1644);
			statementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DoStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(Java8Parser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(Java8Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1646);
			match(DO);
			setState(1647);
			statement();
			setState(1648);
			match(WHILE);
			setState(1649);
			match(LPAREN);
			setState(1650);
			expression();
			setState(1651);
			match(RPAREN);
			setState(1652);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public BasicForStatementContext basicForStatement() {
			return getRuleContext(BasicForStatementContext.class,0);
		}
		public EnhancedForStatementContext enhancedForStatement() {
			return getRuleContext(EnhancedForStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_forStatement);
		try {
			setState(1656);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1654);
				basicForStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1655);
				enhancedForStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementNoShortIfContext extends ParserRuleContext {
		public BasicForStatementNoShortIfContext basicForStatementNoShortIf() {
			return getRuleContext(BasicForStatementNoShortIfContext.class,0);
		}
		public EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() {
			return getRuleContext(EnhancedForStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementNoShortIfContext forStatementNoShortIf() throws RecognitionException {
		ForStatementNoShortIfContext _localctx = new ForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_forStatementNoShortIf);
		try {
			setState(1660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1658);
				basicForStatementNoShortIf();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1659);
				enhancedForStatementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BasicForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Java8Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Java8Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Java8Parser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBasicForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBasicForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBasicForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicForStatementContext basicForStatement() throws RecognitionException {
		BasicForStatementContext _localctx = new BasicForStatementContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_basicForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1662);
			match(FOR);
			setState(1663);
			match(LPAREN);
			setState(1665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087178240296L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1664);
				forInit();
				}
			}

			setState(1667);
			match(SEMI);
			setState(1669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(1668);
				expression();
				}
			}

			setState(1671);
			match(SEMI);
			setState(1673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1672);
				forUpdate();
				}
			}

			setState(1675);
			match(RPAREN);
			setState(1676);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BasicForStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Java8Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Java8Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Java8Parser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBasicForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBasicForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBasicForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicForStatementNoShortIfContext basicForStatementNoShortIf() throws RecognitionException {
		BasicForStatementNoShortIfContext _localctx = new BasicForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_basicForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(FOR);
			setState(1679);
			match(LPAREN);
			setState(1681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087178240296L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1680);
				forInit();
				}
			}

			setState(1683);
			match(SEMI);
			setState(1685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(1684);
				expression();
				}
			}

			setState(1687);
			match(SEMI);
			setState(1689);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 25165827L) != 0)) {
				{
				setState(1688);
				forUpdate();
				}
			}

			setState(1691);
			match(RPAREN);
			setState(1692);
			statementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
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
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_forInit);
		try {
			setState(1696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1694);
				statementExpressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1695);
				localVariableDeclaration();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitForUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitForUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1698);
			statementExpressionList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementExpressionListContext extends ParserRuleContext {
		public List<StatementExpressionContext> statementExpression() {
			return getRuleContexts(StatementExpressionContext.class);
		}
		public StatementExpressionContext statementExpression(int i) {
			return getRuleContext(StatementExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public StatementExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterStatementExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitStatementExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitStatementExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementExpressionListContext statementExpressionList() throws RecognitionException {
		StatementExpressionListContext _localctx = new StatementExpressionListContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_statementExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1700);
			statementExpression();
			setState(1705);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1701);
				match(COMMA);
				setState(1702);
				statementExpression();
				}
				}
				setState(1707);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnhancedForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Java8Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnhancedForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnhancedForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnhancedForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForStatementContext enhancedForStatement() throws RecognitionException {
		EnhancedForStatementContext _localctx = new EnhancedForStatementContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_enhancedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			match(FOR);
			setState(1709);
			match(LPAREN);
			setState(1713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1710);
				variableModifier();
				}
				}
				setState(1715);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1716);
			unannType();
			setState(1717);
			variableDeclaratorId();
			setState(1718);
			match(COLON);
			setState(1719);
			expression();
			setState(1720);
			match(RPAREN);
			setState(1721);
			statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EnhancedForStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Java8Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEnhancedForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEnhancedForStatementNoShortIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEnhancedForStatementNoShortIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() throws RecognitionException {
		EnhancedForStatementNoShortIfContext _localctx = new EnhancedForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_enhancedForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1723);
			match(FOR);
			setState(1724);
			match(LPAREN);
			setState(1728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1725);
				variableModifier();
				}
				}
				setState(1730);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1731);
			unannType();
			setState(1732);
			variableDeclaratorId();
			setState(1733);
			match(COLON);
			setState(1734);
			expression();
			setState(1735);
			match(RPAREN);
			setState(1736);
			statementNoShortIf();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(Java8Parser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1738);
			match(BREAK);
			setState(1740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1739);
				match(Identifier);
				}
			}

			setState(1742);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(Java8Parser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1744);
			match(CONTINUE);
			setState(1746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1745);
				match(Identifier);
				}
			}

			setState(1748);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(Java8Parser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1750);
			match(RETURN);
			setState(1752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(1751);
				expression();
				}
			}

			setState(1754);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(Java8Parser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitThrowStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitThrowStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1756);
			match(THROW);
			setState(1757);
			expression();
			setState(1758);
			match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SynchronizedStatementContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED() { return getToken(Java8Parser.SYNCHRONIZED, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitSynchronizedStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitSynchronizedStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			match(SYNCHRONIZED);
			setState(1761);
			match(LPAREN);
			setState(1762);
			expression();
			setState(1763);
			match(RPAREN);
			setState(1764);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TryStatementContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Java8Parser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryWithResourcesStatementContext tryWithResourcesStatement() {
			return getRuleContext(TryWithResourcesStatementContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_tryStatement);
		int _la;
		try {
			setState(1778);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1766);
				match(TRY);
				setState(1767);
				block();
				setState(1768);
				catches();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1770);
				match(TRY);
				setState(1771);
				block();
				setState(1773);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(1772);
					catches();
					}
				}

				setState(1775);
				finally_();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1777);
				tryWithResourcesStatement();
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatches(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatches(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1780);
			catchClause();
			setState(1784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1781);
				catchClause();
				}
				}
				setState(1786);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(Java8Parser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public CatchFormalParameterContext catchFormalParameter() {
			return getRuleContext(CatchFormalParameterContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1787);
			match(CATCH);
			setState(1788);
			match(LPAREN);
			setState(1789);
			catchFormalParameter();
			setState(1790);
			match(RPAREN);
			setState(1791);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CatchFormalParameterContext extends ParserRuleContext {
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchFormalParameterContext catchFormalParameter() throws RecognitionException {
		CatchFormalParameterContext _localctx = new CatchFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_catchFormalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1793);
				variableModifier();
				}
				}
				setState(1798);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1799);
			catchType();
			setState(1800);
			variableDeclaratorId();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CatchTypeContext extends ParserRuleContext {
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public List<TerminalNode> BITOR() { return getTokens(Java8Parser.BITOR); }
		public TerminalNode BITOR(int i) {
			return getToken(Java8Parser.BITOR, i);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCatchType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCatchType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1802);
			unannClassType();
			setState(1807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1803);
				match(BITOR);
				setState(1804);
				classType();
				}
				}
				setState(1809);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Finally_Context extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(Java8Parser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFinally_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFinally_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFinally_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Finally_Context finally_() throws RecognitionException {
		Finally_Context _localctx = new Finally_Context(_ctx, getState());
		enterRule(_localctx, 340, RULE_finally_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1810);
			match(FINALLY);
			setState(1811);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TryWithResourcesStatementContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Java8Parser.TRY, 0); }
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryWithResourcesStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryWithResourcesStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTryWithResourcesStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTryWithResourcesStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTryWithResourcesStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryWithResourcesStatementContext tryWithResourcesStatement() throws RecognitionException {
		TryWithResourcesStatementContext _localctx = new TryWithResourcesStatementContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_tryWithResourcesStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1813);
			match(TRY);
			setState(1814);
			resourceSpecification();
			setState(1815);
			block();
			setState(1817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CATCH) {
				{
				setState(1816);
				catches();
				}
			}

			setState(1820);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1819);
				finally_();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceSpecificationContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ResourceListContext resourceList() {
			return getRuleContext(ResourceListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Java8Parser.SEMI, 0); }
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResourceSpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResourceSpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1822);
			match(LPAREN);
			setState(1823);
			resourceList();
			setState(1825);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1824);
				match(SEMI);
				}
			}

			setState(1827);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceListContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(Java8Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Java8Parser.SEMI, i);
		}
		public ResourceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResourceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResourceList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResourceList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceListContext resourceList() throws RecognitionException {
		ResourceListContext _localctx = new ResourceListContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_resourceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1829);
			resource();
			setState(1834);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1830);
					match(SEMI);
					setState(1831);
					resource();
					}
					} 
				}
				setState(1836);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Java8Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FINAL || _la==AT) {
				{
				{
				setState(1837);
				variableModifier();
				}
				}
				setState(1842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1843);
			unannType();
			setState(1844);
			variableDeclaratorId();
			setState(1845);
			match(ASSIGN);
			setState(1846);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primaryContext.class,0);
		}
		public ArrayCreationExpressionContext arrayCreationExpression() {
			return getRuleContext(ArrayCreationExpressionContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_primaryContext> primaryNoNewArray_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primaryContext.class,i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1850);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(1848);
				primaryNoNewArray_lfno_primary();
				}
				break;
			case 2:
				{
				setState(1849);
				arrayCreationExpression();
				}
				break;
			}
			setState(1855);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1852);
					primaryNoNewArray_lf_primary();
					}
					} 
				}
				setState(1857);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArrayContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Java8Parser.CLASS, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public TerminalNode VOID() { return getToken(Java8Parser.VOID, 0); }
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public PrimaryNoNewArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArrayContext primaryNoNewArray() throws RecognitionException {
		PrimaryNoNewArrayContext _localctx = new PrimaryNoNewArrayContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_primaryNoNewArray);
		int _la;
		try {
			setState(1887);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1858);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1859);
				typeName();
				setState(1864);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1860);
					match(LBRACK);
					setState(1861);
					match(RBRACK);
					}
					}
					setState(1866);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1867);
				match(DOT);
				setState(1868);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1870);
				match(VOID);
				setState(1871);
				match(DOT);
				setState(1872);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1873);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1874);
				typeName();
				setState(1875);
				match(DOT);
				setState(1876);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1878);
				match(LPAREN);
				setState(1879);
				expression();
				setState(1880);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1882);
				classInstanceCreationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1883);
				fieldAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1884);
				arrayAccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1885);
				methodInvocation();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1886);
				methodReference();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lf_arrayAccessContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_arrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lf_arrayAccessContext _localctx = new PrimaryNoNewArray_lf_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_primaryNoNewArray_lf_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lfno_arrayAccessContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Java8Parser.CLASS, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public TerminalNode VOID() { return getToken(Java8Parser.VOID, 0); }
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_arrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lfno_arrayAccessContext _localctx = new PrimaryNoNewArray_lfno_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_primaryNoNewArray_lfno_arrayAccess);
		int _la;
		try {
			setState(1919);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1891);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1892);
				typeName();
				setState(1897);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1893);
					match(LBRACK);
					setState(1894);
					match(RBRACK);
					}
					}
					setState(1899);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1900);
				match(DOT);
				setState(1901);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1903);
				match(VOID);
				setState(1904);
				match(DOT);
				setState(1905);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1906);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1907);
				typeName();
				setState(1908);
				match(DOT);
				setState(1909);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1911);
				match(LPAREN);
				setState(1912);
				expression();
				setState(1913);
				match(RPAREN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1915);
				classInstanceCreationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1916);
				fieldAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1917);
				methodInvocation();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1918);
				methodReference();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public ArrayAccess_lf_primaryContext arrayAccess_lf_primary() {
			return getRuleContext(ArrayAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_primaryNoNewArray_lf_primary);
		try {
			setState(1926);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1921);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1922);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1923);
				arrayAccess_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1924);
				methodInvocation_lf_primary();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1925);
				methodReference_lf_primary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary);
		try {
			setState(1934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1930);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1931);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1932);
				methodInvocation_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1933);
				methodReference_lf_primary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Java8Parser.CLASS, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(Java8Parser.VOID, 0); }
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() {
			return getRuleContext(ArrayAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_primaryNoNewArray_lfno_primary);
		int _la;
		try {
			setState(1976);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1936);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1937);
				typeName();
				setState(1942);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1938);
					match(LBRACK);
					setState(1939);
					match(RBRACK);
					}
					}
					setState(1944);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1945);
				match(DOT);
				setState(1946);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1948);
				unannPrimitiveType();
				setState(1953);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1949);
					match(LBRACK);
					setState(1950);
					match(RBRACK);
					}
					}
					setState(1955);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1956);
				match(DOT);
				setState(1957);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1959);
				match(VOID);
				setState(1960);
				match(DOT);
				setState(1961);
				match(CLASS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1962);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1963);
				typeName();
				setState(1964);
				match(DOT);
				setState(1965);
				match(THIS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1967);
				match(LPAREN);
				setState(1968);
				expression();
				setState(1969);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1971);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1972);
				fieldAccess_lfno_primary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1973);
				arrayAccess_lfno_primary();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1974);
				methodInvocation_lfno_primary();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1975);
				methodReference_lfno_primary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Java8Parser.CLASS, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(Java8Parser.VOID, 0); }
		public TerminalNode THIS() { return getToken(Java8Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary);
		int _la;
		try {
			setState(2019);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1980);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1981);
				typeName();
				setState(1986);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1982);
					match(LBRACK);
					setState(1983);
					match(RBRACK);
					}
					}
					setState(1988);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1989);
				match(DOT);
				setState(1990);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1992);
				unannPrimitiveType();
				setState(1997);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1993);
					match(LBRACK);
					setState(1994);
					match(RBRACK);
					}
					}
					setState(1999);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2000);
				match(DOT);
				setState(2001);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2003);
				match(VOID);
				setState(2004);
				match(DOT);
				setState(2005);
				match(CLASS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2006);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2007);
				typeName();
				setState(2008);
				match(DOT);
				setState(2009);
				match(THIS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2011);
				match(LPAREN);
				setState(2012);
				expression();
				setState(2013);
				match(RPAREN);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2015);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2016);
				fieldAccess_lfno_primary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2017);
				methodInvocation_lfno_primary();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2018);
				methodReference_lfno_primary();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInstanceCreationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ClassInstanceCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpressionContext classInstanceCreationExpression() throws RecognitionException {
		ClassInstanceCreationExpressionContext _localctx = new ClassInstanceCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_classInstanceCreationExpression);
		int _la;
		try {
			setState(2104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2021);
				match(NEW);
				setState(2023);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2022);
					typeArguments();
					}
				}

				setState(2028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2025);
					annotation();
					}
					}
					setState(2030);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2031);
				match(Identifier);
				setState(2042);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2032);
					match(DOT);
					setState(2036);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(2033);
						annotation();
						}
						}
						setState(2038);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2039);
					match(Identifier);
					}
					}
					setState(2044);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2046);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2045);
					typeArgumentsOrDiamond();
					}
				}

				setState(2048);
				match(LPAREN);
				setState(2050);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2049);
					argumentList();
					}
				}

				setState(2052);
				match(RPAREN);
				setState(2054);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2053);
					classBody();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2056);
				expressionName();
				setState(2057);
				match(DOT);
				setState(2058);
				match(NEW);
				setState(2060);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2059);
					typeArguments();
					}
				}

				setState(2065);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2062);
					annotation();
					}
					}
					setState(2067);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2068);
				match(Identifier);
				setState(2070);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2069);
					typeArgumentsOrDiamond();
					}
				}

				setState(2072);
				match(LPAREN);
				setState(2074);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2073);
					argumentList();
					}
				}

				setState(2076);
				match(RPAREN);
				setState(2078);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2077);
					classBody();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2080);
				primary();
				setState(2081);
				match(DOT);
				setState(2082);
				match(NEW);
				setState(2084);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2083);
					typeArguments();
					}
				}

				setState(2089);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2086);
					annotation();
					}
					}
					setState(2091);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2092);
				match(Identifier);
				setState(2094);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2093);
					typeArgumentsOrDiamond();
					}
				}

				setState(2096);
				match(LPAREN);
				setState(2098);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2097);
					argumentList();
					}
				}

				setState(2100);
				match(RPAREN);
				setState(2102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(2101);
					classBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInstanceCreationExpression_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassInstanceCreationExpression_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lf_primaryContext _localctx = new ClassInstanceCreationExpression_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_classInstanceCreationExpression_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2106);
			match(DOT);
			setState(2107);
			match(NEW);
			setState(2109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2108);
				typeArguments();
				}
			}

			setState(2114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2111);
				annotation();
				}
				}
				setState(2116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2117);
			match(Identifier);
			setState(2119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2118);
				typeArgumentsOrDiamond();
				}
			}

			setState(2121);
			match(LPAREN);
			setState(2123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(2122);
				argumentList();
				}
			}

			setState(2125);
			match(RPAREN);
			setState(2127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				{
				setState(2126);
				classBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassInstanceCreationExpression_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitClassInstanceCreationExpression_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lfno_primaryContext _localctx = new ClassInstanceCreationExpression_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_classInstanceCreationExpression_lfno_primary);
		int _la;
		try {
			setState(2188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(2129);
				match(NEW);
				setState(2131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2130);
					typeArguments();
					}
				}

				setState(2136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2133);
					annotation();
					}
					}
					setState(2138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2139);
				match(Identifier);
				setState(2150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(2140);
					match(DOT);
					setState(2144);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(2141);
						annotation();
						}
						}
						setState(2146);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2147);
					match(Identifier);
					}
					}
					setState(2152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2153);
					typeArgumentsOrDiamond();
					}
				}

				setState(2156);
				match(LPAREN);
				setState(2158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2157);
					argumentList();
					}
				}

				setState(2160);
				match(RPAREN);
				setState(2162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
				case 1:
					{
					setState(2161);
					classBody();
					}
					break;
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2164);
				expressionName();
				setState(2165);
				match(DOT);
				setState(2166);
				match(NEW);
				setState(2168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2167);
					typeArguments();
					}
				}

				setState(2173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(2170);
					annotation();
					}
					}
					setState(2175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2176);
				match(Identifier);
				setState(2178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2177);
					typeArgumentsOrDiamond();
					}
				}

				setState(2180);
				match(LPAREN);
				setState(2182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2181);
					argumentList();
					}
				}

				setState(2184);
				match(RPAREN);
				setState(2186);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
				case 1:
					{
					setState(2185);
					classBody();
					}
					break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TerminalNode LT() { return getToken(Java8Parser.LT, 0); }
		public TerminalNode GT() { return getToken(Java8Parser.GT, 0); }
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterTypeArgumentsOrDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitTypeArgumentsOrDiamond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitTypeArgumentsOrDiamond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_typeArgumentsOrDiamond);
		try {
			setState(2193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2190);
				typeArguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2191);
				match(LT);
				setState(2192);
				match(GT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldAccessContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_fieldAccess);
		try {
			setState(2208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,240,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2195);
				primary();
				setState(2196);
				match(DOT);
				setState(2197);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2199);
				match(SUPER);
				setState(2200);
				match(DOT);
				setState(2201);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2202);
				typeName();
				setState(2203);
				match(DOT);
				setState(2204);
				match(SUPER);
				setState(2205);
				match(DOT);
				setState(2206);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldAccess_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public FieldAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccess_lf_primaryContext fieldAccess_lf_primary() throws RecognitionException {
		FieldAccess_lf_primaryContext _localctx = new FieldAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_fieldAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2210);
			match(DOT);
			setState(2211);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldAccess_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterFieldAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitFieldAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitFieldAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() throws RecognitionException {
		FieldAccess_lfno_primaryContext _localctx = new FieldAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_fieldAccess_lfno_primary);
		try {
			setState(2222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(2213);
				match(SUPER);
				setState(2214);
				match(DOT);
				setState(2215);
				match(Identifier);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(2216);
				typeName();
				setState(2217);
				match(DOT);
				setState(2218);
				match(SUPER);
				setState(2219);
				match(DOT);
				setState(2220);
				match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() {
			return getRuleContext(PrimaryNoNewArray_lfno_arrayAccessContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_arrayAccessContext> primaryNoNewArray_lf_arrayAccess() {
			return getRuleContexts(PrimaryNoNewArray_lf_arrayAccessContext.class);
		}
		public PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_arrayAccessContext.class,i);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,242,_ctx) ) {
			case 1:
				{
				setState(2224);
				expressionName();
				setState(2225);
				match(LBRACK);
				setState(2226);
				expression();
				setState(2227);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(2229);
				primaryNoNewArray_lfno_arrayAccess();
				setState(2230);
				match(LBRACK);
				setState(2231);
				expression();
				setState(2232);
				match(RBRACK);
				}
				break;
			}
			setState(2243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(2236);
				primaryNoNewArray_lf_arrayAccess();
				setState(2237);
				match(LBRACK);
				setState(2238);
				expression();
				setState(2239);
				match(RBRACK);
				}
				}
				setState(2245);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public List<PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext> primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class,i);
		}
		public ArrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccess_lf_primaryContext arrayAccess_lf_primary() throws RecognitionException {
		ArrayAccess_lf_primaryContext _localctx = new ArrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_arrayAccess_lf_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2246);
			primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary();
			setState(2247);
			match(LBRACK);
			setState(2248);
			expression();
			setState(2249);
			match(RBRACK);
			}
			setState(2258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,244,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2251);
					primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary();
					setState(2252);
					match(LBRACK);
					setState(2253);
					expression();
					setState(2254);
					match(RBRACK);
					}
					} 
				}
				setState(2260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,244,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccess_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Java8Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Java8Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Java8Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Java8Parser.RBRACK, i);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext.class,0);
		}
		public List<PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext> primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() {
			return getRuleContexts(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class);
		}
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class,i);
		}
		public ArrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayAccess_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayAccess_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() throws RecognitionException {
		ArrayAccess_lfno_primaryContext _localctx = new ArrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_arrayAccess_lfno_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(2261);
				expressionName();
				setState(2262);
				match(LBRACK);
				setState(2263);
				expression();
				setState(2264);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(2266);
				primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary();
				setState(2267);
				match(LBRACK);
				setState(2268);
				expression();
				setState(2269);
				match(RBRACK);
				}
				break;
			}
			setState(2280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2273);
					primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary();
					setState(2274);
					match(LBRACK);
					setState(2275);
					expression();
					setState(2276);
					match(RBRACK);
					}
					} 
				}
				setState(2282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodInvocationContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_methodInvocation);
		int _la;
		try {
			setState(2351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2283);
				methodName();
				setState(2284);
				match(LPAREN);
				setState(2286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2285);
					argumentList();
					}
				}

				setState(2288);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2290);
				typeName();
				setState(2291);
				match(DOT);
				setState(2293);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2292);
					typeArguments();
					}
				}

				setState(2295);
				match(Identifier);
				setState(2296);
				match(LPAREN);
				setState(2298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2297);
					argumentList();
					}
				}

				setState(2300);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2302);
				expressionName();
				setState(2303);
				match(DOT);
				setState(2305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2304);
					typeArguments();
					}
				}

				setState(2307);
				match(Identifier);
				setState(2308);
				match(LPAREN);
				setState(2310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2309);
					argumentList();
					}
				}

				setState(2312);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2314);
				primary();
				setState(2315);
				match(DOT);
				setState(2317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2316);
					typeArguments();
					}
				}

				setState(2319);
				match(Identifier);
				setState(2320);
				match(LPAREN);
				setState(2322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2321);
					argumentList();
					}
				}

				setState(2324);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2326);
				match(SUPER);
				setState(2327);
				match(DOT);
				setState(2329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2328);
					typeArguments();
					}
				}

				setState(2331);
				match(Identifier);
				setState(2332);
				match(LPAREN);
				setState(2334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2333);
					argumentList();
					}
				}

				setState(2336);
				match(RPAREN);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2337);
				typeName();
				setState(2338);
				match(DOT);
				setState(2339);
				match(SUPER);
				setState(2340);
				match(DOT);
				setState(2342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2341);
					typeArguments();
					}
				}

				setState(2344);
				match(Identifier);
				setState(2345);
				match(LPAREN);
				setState(2347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2346);
					argumentList();
					}
				}

				setState(2349);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodInvocation_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocation_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocation_lf_primaryContext methodInvocation_lf_primary() throws RecognitionException {
		MethodInvocation_lf_primaryContext _localctx = new MethodInvocation_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_methodInvocation_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2353);
			match(DOT);
			setState(2355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2354);
				typeArguments();
				}
			}

			setState(2357);
			match(Identifier);
			setState(2358);
			match(LPAREN);
			setState(2360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
				{
				setState(2359);
				argumentList();
				}
			}

			setState(2362);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodInvocation_lfno_primaryContext extends ParserRuleContext {
		public MethodNameContext methodName() {
			return getRuleContext(MethodNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Java8Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Java8Parser.DOT, i);
		}
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public MethodInvocation_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodInvocation_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodInvocation_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodInvocation_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() throws RecognitionException {
		MethodInvocation_lfno_primaryContext _localctx = new MethodInvocation_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_methodInvocation_lfno_primary);
		int _la;
		try {
			setState(2420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2364);
				methodName();
				setState(2365);
				match(LPAREN);
				setState(2367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2366);
					argumentList();
					}
				}

				setState(2369);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2371);
				typeName();
				setState(2372);
				match(DOT);
				setState(2374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2373);
					typeArguments();
					}
				}

				setState(2376);
				match(Identifier);
				setState(2377);
				match(LPAREN);
				setState(2379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2378);
					argumentList();
					}
				}

				setState(2381);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2383);
				expressionName();
				setState(2384);
				match(DOT);
				setState(2386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2385);
					typeArguments();
					}
				}

				setState(2388);
				match(Identifier);
				setState(2389);
				match(LPAREN);
				setState(2391);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2390);
					argumentList();
					}
				}

				setState(2393);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2395);
				match(SUPER);
				setState(2396);
				match(DOT);
				setState(2398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2397);
					typeArguments();
					}
				}

				setState(2400);
				match(Identifier);
				setState(2401);
				match(LPAREN);
				setState(2403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2402);
					argumentList();
					}
				}

				setState(2405);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2406);
				typeName();
				setState(2407);
				match(DOT);
				setState(2408);
				match(SUPER);
				setState(2409);
				match(DOT);
				setState(2411);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2410);
					typeArguments();
					}
				}

				setState(2413);
				match(Identifier);
				setState(2414);
				match(LPAREN);
				setState(2416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 286270087177978152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 25769819139L) != 0)) {
					{
					setState(2415);
					argumentList();
					}
				}

				setState(2418);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2422);
			expression();
			setState(2427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2423);
				match(COMMA);
				setState(2424);
				expression();
				}
				}
				setState(2429);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodReferenceContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(Java8Parser.COLONCOLON, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReferenceContext methodReference() throws RecognitionException {
		MethodReferenceContext _localctx = new MethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_methodReference);
		int _la;
		try {
			setState(2477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,278,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2430);
				expressionName();
				setState(2431);
				match(COLONCOLON);
				setState(2433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2432);
					typeArguments();
					}
				}

				setState(2435);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2437);
				referenceType();
				setState(2438);
				match(COLONCOLON);
				setState(2440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2439);
					typeArguments();
					}
				}

				setState(2442);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2444);
				primary();
				setState(2445);
				match(COLONCOLON);
				setState(2447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2446);
					typeArguments();
					}
				}

				setState(2449);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2451);
				match(SUPER);
				setState(2452);
				match(COLONCOLON);
				setState(2454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2453);
					typeArguments();
					}
				}

				setState(2456);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2457);
				typeName();
				setState(2458);
				match(DOT);
				setState(2459);
				match(SUPER);
				setState(2460);
				match(COLONCOLON);
				setState(2462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2461);
					typeArguments();
					}
				}

				setState(2464);
				match(Identifier);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2466);
				classType();
				setState(2467);
				match(COLONCOLON);
				setState(2469);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2468);
					typeArguments();
					}
				}

				setState(2471);
				match(NEW);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2473);
				arrayType();
				setState(2474);
				match(COLONCOLON);
				setState(2475);
				match(NEW);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodReference_lf_primaryContext extends ParserRuleContext {
		public TerminalNode COLONCOLON() { return getToken(Java8Parser.COLONCOLON, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public MethodReference_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference_lf_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference_lf_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReference_lf_primaryContext methodReference_lf_primary() throws RecognitionException {
		MethodReference_lf_primaryContext _localctx = new MethodReference_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_methodReference_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2479);
			match(COLONCOLON);
			setState(2481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2480);
				typeArguments();
				}
			}

			setState(2483);
			match(Identifier);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodReference_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(Java8Parser.COLONCOLON, 0); }
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Java8Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Java8Parser.DOT, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReference_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMethodReference_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMethodReference_lfno_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMethodReference_lfno_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodReference_lfno_primaryContext methodReference_lfno_primary() throws RecognitionException {
		MethodReference_lfno_primaryContext _localctx = new MethodReference_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_methodReference_lfno_primary);
		int _la;
		try {
			setState(2525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2485);
				expressionName();
				setState(2486);
				match(COLONCOLON);
				setState(2488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2487);
					typeArguments();
					}
				}

				setState(2490);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2492);
				referenceType();
				setState(2493);
				match(COLONCOLON);
				setState(2495);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2494);
					typeArguments();
					}
				}

				setState(2497);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2499);
				match(SUPER);
				setState(2500);
				match(COLONCOLON);
				setState(2502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2501);
					typeArguments();
					}
				}

				setState(2504);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2505);
				typeName();
				setState(2506);
				match(DOT);
				setState(2507);
				match(SUPER);
				setState(2508);
				match(COLONCOLON);
				setState(2510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2509);
					typeArguments();
					}
				}

				setState(2512);
				match(Identifier);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2514);
				classType();
				setState(2515);
				match(COLONCOLON);
				setState(2517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2516);
					typeArguments();
					}
				}

				setState(2519);
				match(NEW);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2521);
				arrayType();
				setState(2522);
				match(COLONCOLON);
				setState(2523);
				match(NEW);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCreationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Java8Parser.NEW, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimExprsContext dimExprs() {
			return getRuleContext(DimExprsContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitArrayCreationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitArrayCreationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayCreationExpressionContext arrayCreationExpression() throws RecognitionException {
		ArrayCreationExpressionContext _localctx = new ArrayCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_arrayCreationExpression);
		try {
			setState(2549);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2527);
				match(NEW);
				setState(2528);
				primitiveType();
				setState(2529);
				dimExprs();
				setState(2531);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
				case 1:
					{
					setState(2530);
					dims();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2533);
				match(NEW);
				setState(2534);
				classOrInterfaceType();
				setState(2535);
				dimExprs();
				setState(2537);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,287,_ctx) ) {
				case 1:
					{
					setState(2536);
					dims();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2539);
				match(NEW);
				setState(2540);
				primitiveType();
				setState(2541);
				dims();
				setState(2542);
				arrayInitializer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2544);
				match(NEW);
				setState(2545);
				classOrInterfaceType();
				setState(2546);
				dims();
				setState(2547);
				arrayInitializer();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DimExprsContext extends ParserRuleContext {
		public List<DimExprContext> dimExpr() {
			return getRuleContexts(DimExprContext.class);
		}
		public DimExprContext dimExpr(int i) {
			return getRuleContext(DimExprContext.class,i);
		}
		public DimExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDimExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDimExprs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDimExprs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimExprsContext dimExprs() throws RecognitionException {
		DimExprsContext _localctx = new DimExprsContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_dimExprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2551);
			dimExpr();
			setState(2555);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,289,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2552);
					dimExpr();
					}
					} 
				}
				setState(2557);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,289,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DimExprContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(Java8Parser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(Java8Parser.RBRACK, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public DimExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterDimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitDimExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitDimExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimExprContext dimExpr() throws RecognitionException {
		DimExprContext _localctx = new DimExprContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_dimExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2558);
				annotation();
				}
				}
				setState(2563);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2564);
			match(LBRACK);
			setState(2565);
			expression();
			setState(2566);
			match(RBRACK);
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

	@SuppressWarnings("CheckReturnValue")
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
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConstantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConstantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2568);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_expression);
		try {
			setState(2572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,291,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2570);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2571);
				assignmentExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(Java8Parser.ARROW, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2574);
			lambdaParameters();
			setState(2575);
			match(ARROW);
			setState(2576);
			lambdaBody();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaParametersContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Java8Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public InferredFormalParameterListContext inferredFormalParameterList() {
			return getRuleContext(InferredFormalParameterListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_lambdaParameters);
		int _la;
		try {
			setState(2588);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,293,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2578);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2579);
				match(LPAREN);
				setState(2581);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 138111369512L) != 0) || _la==Identifier || _la==AT) {
					{
					setState(2580);
					formalParameterList();
					}
				}

				setState(2583);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2584);
				match(LPAREN);
				setState(2585);
				inferredFormalParameterList();
				setState(2586);
				match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InferredFormalParameterListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Java8Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Java8Parser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Java8Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Java8Parser.COMMA, i);
		}
		public InferredFormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredFormalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInferredFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInferredFormalParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInferredFormalParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferredFormalParameterListContext inferredFormalParameterList() throws RecognitionException {
		InferredFormalParameterListContext _localctx = new InferredFormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_inferredFormalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2590);
			match(Identifier);
			setState(2595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2591);
				match(COMMA);
				setState(2592);
				match(Identifier);
				}
				}
				setState(2597);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLambdaBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLambdaBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_lambdaBody);
		try {
			setState(2600);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2598);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2599);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_assignmentExpression);
		try {
			setState(2604);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,296,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2602);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2603);
				assignment();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2606);
			leftHandSide();
			setState(2607);
			assignmentOperator();
			setState(2608);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LeftHandSideContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitLeftHandSide(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitLeftHandSide(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_leftHandSide);
		try {
			setState(2613);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,297,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2610);
				expressionName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2611);
				fieldAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2612);
				arrayAccess();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(Java8Parser.ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(Java8Parser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(Java8Parser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(Java8Parser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(Java8Parser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(Java8Parser.SUB_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(Java8Parser.LSHIFT_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(Java8Parser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(Java8Parser.URSHIFT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(Java8Parser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(Java8Parser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(Java8Parser.OR_ASSIGN, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAssignmentOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAssignmentOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2615);
			_la = _input.LA(1);
			if ( !(((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 68685922305L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(Java8Parser.QUESTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Java8Parser.COLON, 0); }
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_conditionalExpression);
		try {
			setState(2624);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,298,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2617);
				conditionalOrExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2618);
				conditionalOrExpression(0);
				setState(2619);
				match(QUESTION);
				setState(2620);
				expression();
				setState(2621);
				match(COLON);
				setState(2622);
				conditionalExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalOrExpressionContext extends ParserRuleContext {
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public ConditionalOrExpressionContext conditionalOrExpression() {
			return getRuleContext(ConditionalOrExpressionContext.class,0);
		}
		public TerminalNode OR() { return getToken(Java8Parser.OR, 0); }
		public ConditionalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalOrExpressionContext conditionalOrExpression() throws RecognitionException {
		return conditionalOrExpression(0);
	}

	private ConditionalOrExpressionContext conditionalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalOrExpressionContext _localctx = new ConditionalOrExpressionContext(_ctx, _parentState);
		ConditionalOrExpressionContext _prevctx = _localctx;
		int _startState = 432;
		enterRecursionRule(_localctx, 432, RULE_conditionalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2627);
			conditionalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2634);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalOrExpression);
					setState(2629);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2630);
					match(OR);
					setState(2631);
					conditionalAndExpression(0);
					}
					} 
				}
				setState(2636);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalAndExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public ConditionalAndExpressionContext conditionalAndExpression() {
			return getRuleContext(ConditionalAndExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(Java8Parser.AND, 0); }
		public ConditionalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterConditionalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitConditionalAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitConditionalAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalAndExpressionContext conditionalAndExpression() throws RecognitionException {
		return conditionalAndExpression(0);
	}

	private ConditionalAndExpressionContext conditionalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalAndExpressionContext _localctx = new ConditionalAndExpressionContext(_ctx, _parentState);
		ConditionalAndExpressionContext _prevctx = _localctx;
		int _startState = 434;
		enterRecursionRule(_localctx, 434, RULE_conditionalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2638);
			inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2645);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionalAndExpression);
					setState(2640);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2641);
					match(AND);
					setState(2642);
					inclusiveOrExpression(0);
					}
					} 
				}
				setState(2647);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public TerminalNode BITOR() { return getToken(Java8Parser.BITOR, 0); }
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitInclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitInclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 436;
		enterRecursionRule(_localctx, 436, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2649);
			exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2656);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(2651);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2652);
					match(BITOR);
					setState(2653);
					exclusiveOrExpression(0);
					}
					} 
				}
				setState(2658);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,301,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public TerminalNode CARET() { return getToken(Java8Parser.CARET, 0); }
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitExclusiveOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitExclusiveOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 438;
		enterRecursionRule(_localctx, 438, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2660);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2667);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(2662);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2663);
					match(CARET);
					setState(2664);
					andExpression(0);
					}
					} 
				}
				setState(2669);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public TerminalNode BITAND() { return getToken(Java8Parser.BITAND, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 440;
		enterRecursionRule(_localctx, 440, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2671);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2678);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(2673);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(2674);
					match(BITAND);
					setState(2675);
					equalityExpression(0);
					}
					} 
				}
				setState(2680);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(Java8Parser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(Java8Parser.NOTEQUAL, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 442;
		enterRecursionRule(_localctx, 442, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2682);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2692);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2690);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2684);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2685);
						match(EQUAL);
						setState(2686);
						relationalExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(2687);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2688);
						match(NOTEQUAL);
						setState(2689);
						relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(2694);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,305,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode LT() { return getToken(Java8Parser.LT, 0); }
		public TerminalNode GT() { return getToken(Java8Parser.GT, 0); }
		public TerminalNode LE() { return getToken(Java8Parser.LE, 0); }
		public TerminalNode GE() { return getToken(Java8Parser.GE, 0); }
		public TerminalNode INSTANCEOF() { return getToken(Java8Parser.INSTANCEOF, 0); }
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitRelationalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitRelationalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 444;
		enterRecursionRule(_localctx, 444, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2696);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2715);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,307,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2713);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,306,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2698);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(2699);
						match(LT);
						setState(2700);
						shiftExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2701);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(2702);
						match(GT);
						setState(2703);
						shiftExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2704);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2705);
						match(LE);
						setState(2706);
						shiftExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2707);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2708);
						match(GE);
						setState(2709);
						shiftExpression(0);
						}
						break;
					case 5:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(2710);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2711);
						match(INSTANCEOF);
						setState(2712);
						referenceType();
						}
						break;
					}
					} 
				}
				setState(2717);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,307,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public List<TerminalNode> LT() { return getTokens(Java8Parser.LT); }
		public TerminalNode LT(int i) {
			return getToken(Java8Parser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(Java8Parser.GT); }
		public TerminalNode GT(int i) {
			return getToken(Java8Parser.GT, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 446;
		enterRecursionRule(_localctx, 446, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2719);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2736);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2734);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,308,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2721);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2722);
						match(LT);
						setState(2723);
						match(LT);
						setState(2724);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2725);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2726);
						match(GT);
						setState(2727);
						match(GT);
						setState(2728);
						additiveExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(2729);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2730);
						match(GT);
						setState(2731);
						match(GT);
						setState(2732);
						match(GT);
						setState(2733);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(2738);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,309,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(Java8Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(Java8Parser.SUB, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 448;
		enterRecursionRule(_localctx, 448, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2740);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(2750);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,311,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2748);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2742);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2743);
						match(ADD);
						setState(2744);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(2745);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2746);
						match(SUB);
						setState(2747);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(2752);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,311,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(Java8Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(Java8Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(Java8Parser.MOD, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 450;
		enterRecursionRule(_localctx, 450, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2754);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(2767);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,313,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2765);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,312,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2756);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2757);
						match(MUL);
						setState(2758);
						unaryExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2759);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2760);
						match(DIV);
						setState(2761);
						unaryExpression();
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(2762);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(2763);
						match(MOD);
						setState(2764);
						unaryExpression();
						}
						break;
					}
					} 
				}
				setState(2769);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,313,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public PreIncrementExpressionContext preIncrementExpression() {
			return getRuleContext(PreIncrementExpressionContext.class,0);
		}
		public PreDecrementExpressionContext preDecrementExpression() {
			return getRuleContext(PreDecrementExpressionContext.class,0);
		}
		public TerminalNode ADD() { return getToken(Java8Parser.ADD, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode SUB() { return getToken(Java8Parser.SUB, 0); }
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 452, RULE_unaryExpression);
		try {
			setState(2777);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INC:
				enterOuterAlt(_localctx, 1);
				{
				setState(2770);
				preIncrementExpression();
				}
				break;
			case DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(2771);
				preDecrementExpression();
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 3);
				{
				setState(2772);
				match(ADD);
				setState(2773);
				unaryExpression();
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 4);
				{
				setState(2774);
				match(SUB);
				setState(2775);
				unaryExpression();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case BANG:
			case TILDE:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 5);
				{
				setState(2776);
				unaryExpressionNotPlusMinus();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PreIncrementExpressionContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(Java8Parser.INC, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPreIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPreIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPreIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreIncrementExpressionContext preIncrementExpression() throws RecognitionException {
		PreIncrementExpressionContext _localctx = new PreIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 454, RULE_preIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2779);
			match(INC);
			setState(2780);
			unaryExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PreDecrementExpressionContext extends ParserRuleContext {
		public TerminalNode DEC() { return getToken(Java8Parser.DEC, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPreDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPreDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPreDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreDecrementExpressionContext preDecrementExpression() throws RecognitionException {
		PreDecrementExpressionContext _localctx = new PreDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 456, RULE_preDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2782);
			match(DEC);
			setState(2783);
			unaryExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionNotPlusMinusContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode TILDE() { return getToken(Java8Parser.TILDE, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode BANG() { return getToken(Java8Parser.BANG, 0); }
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpressionNotPlusMinus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterUnaryExpressionNotPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitUnaryExpressionNotPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitUnaryExpressionNotPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() throws RecognitionException {
		UnaryExpressionNotPlusMinusContext _localctx = new UnaryExpressionNotPlusMinusContext(_ctx, getState());
		enterRule(_localctx, 458, RULE_unaryExpressionNotPlusMinus);
		try {
			setState(2791);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,315,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2785);
				postfixExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2786);
				match(TILDE);
				setState(2787);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2788);
				match(BANG);
				setState(2789);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2790);
				castExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<PostIncrementExpression_lf_postfixExpressionContext> postIncrementExpression_lf_postfixExpression() {
			return getRuleContexts(PostIncrementExpression_lf_postfixExpressionContext.class);
		}
		public PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression(int i) {
			return getRuleContext(PostIncrementExpression_lf_postfixExpressionContext.class,i);
		}
		public List<PostDecrementExpression_lf_postfixExpressionContext> postDecrementExpression_lf_postfixExpression() {
			return getRuleContexts(PostDecrementExpression_lf_postfixExpressionContext.class);
		}
		public PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression(int i) {
			return getRuleContext(PostDecrementExpression_lf_postfixExpressionContext.class,i);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 460, RULE_postfixExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2795);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,316,_ctx) ) {
			case 1:
				{
				setState(2793);
				primary();
				}
				break;
			case 2:
				{
				setState(2794);
				expressionName();
				}
				break;
			}
			setState(2801);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,318,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(2799);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INC:
						{
						setState(2797);
						postIncrementExpression_lf_postfixExpression();
						}
						break;
					case DEC:
						{
						setState(2798);
						postDecrementExpression_lf_postfixExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(2803);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,318,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostIncrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode INC() { return getToken(Java8Parser.INC, 0); }
		public PostIncrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIncrementExpressionContext postIncrementExpression() throws RecognitionException {
		PostIncrementExpressionContext _localctx = new PostIncrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 462, RULE_postIncrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2804);
			postfixExpression();
			setState(2805);
			match(INC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostIncrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(Java8Parser.INC, 0); }
		public PostIncrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postIncrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostIncrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostIncrementExpression_lf_postfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostIncrementExpression_lf_postfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostIncrementExpression_lf_postfixExpressionContext postIncrementExpression_lf_postfixExpression() throws RecognitionException {
		PostIncrementExpression_lf_postfixExpressionContext _localctx = new PostIncrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 464, RULE_postIncrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2807);
			match(INC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostDecrementExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public TerminalNode DEC() { return getToken(Java8Parser.DEC, 0); }
		public PostDecrementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostDecrementExpressionContext postDecrementExpression() throws RecognitionException {
		PostDecrementExpressionContext _localctx = new PostDecrementExpressionContext(_ctx, getState());
		enterRule(_localctx, 466, RULE_postDecrementExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2809);
			postfixExpression();
			setState(2810);
			match(DEC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PostDecrementExpression_lf_postfixExpressionContext extends ParserRuleContext {
		public TerminalNode DEC() { return getToken(Java8Parser.DEC, 0); }
		public PostDecrementExpression_lf_postfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postDecrementExpression_lf_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterPostDecrementExpression_lf_postfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitPostDecrementExpression_lf_postfixExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitPostDecrementExpression_lf_postfixExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostDecrementExpression_lf_postfixExpressionContext postDecrementExpression_lf_postfixExpression() throws RecognitionException {
		PostDecrementExpression_lf_postfixExpressionContext _localctx = new PostDecrementExpression_lf_postfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 468, RULE_postDecrementExpression_lf_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2812);
			match(DEC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Java8Parser.LPAREN, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Java8Parser.RPAREN, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public UnaryExpressionNotPlusMinusContext unaryExpressionNotPlusMinus() {
			return getRuleContext(UnaryExpressionNotPlusMinusContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Java8Listener ) ((Java8Listener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Java8Visitor ) return ((Java8Visitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 470, RULE_castExpression);
		int _la;
		try {
			setState(2841);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2814);
				match(LPAREN);
				setState(2815);
				primitiveType();
				setState(2816);
				match(RPAREN);
				setState(2817);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2819);
				match(LPAREN);
				setState(2820);
				referenceType();
				setState(2824);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2821);
					additionalBound();
					}
					}
					setState(2826);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2827);
				match(RPAREN);
				setState(2828);
				unaryExpressionNotPlusMinus();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2830);
				match(LPAREN);
				setState(2831);
				referenceType();
				setState(2835);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(2832);
					additionalBound();
					}
					}
					setState(2837);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2838);
				match(RPAREN);
				setState(2839);
				lambdaExpression();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return packageName_sempred((PackageNameContext)_localctx, predIndex);
		case 27:
			return packageOrTypeName_sempred((PackageOrTypeNameContext)_localctx, predIndex);
		case 30:
			return ambiguousName_sempred((AmbiguousNameContext)_localctx, predIndex);
		case 216:
			return conditionalOrExpression_sempred((ConditionalOrExpressionContext)_localctx, predIndex);
		case 217:
			return conditionalAndExpression_sempred((ConditionalAndExpressionContext)_localctx, predIndex);
		case 218:
			return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);
		case 219:
			return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);
		case 220:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 221:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 222:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 223:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 224:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 225:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean packageName_sempred(PackageNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean packageOrTypeName_sempred(PackageOrTypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean ambiguousName_sempred(AmbiguousNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalOrExpression_sempred(ConditionalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalAndExpression_sempred(ConditionalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 2);
		case 19:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}

	private static final String _serializedATNSegment0 =
		"\u0004\u0001k\u0b1c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007h\u0002"+
		"i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007m\u0002"+
		"n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007r\u0002"+
		"s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007w\u0002"+
		"x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007|\u0002"+
		"}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007\u0080"+
		"\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007\u0083"+
		"\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007\u0086"+
		"\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007\u0089"+
		"\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007\u008c"+
		"\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007\u008f"+
		"\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007\u0092"+
		"\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007\u0095"+
		"\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0002\u0098\u0007\u0098"+
		"\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a\u0002\u009b\u0007\u009b"+
		"\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d\u0002\u009e\u0007\u009e"+
		"\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0\u0002\u00a1\u0007\u00a1"+
		"\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3\u0002\u00a4\u0007\u00a4"+
		"\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6\u0002\u00a7\u0007\u00a7"+
		"\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9\u0002\u00aa\u0007\u00aa"+
		"\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac\u0002\u00ad\u0007\u00ad"+
		"\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af\u0002\u00b0\u0007\u00b0"+
		"\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2\u0002\u00b3\u0007\u00b3"+
		"\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5\u0002\u00b6\u0007\u00b6"+
		"\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8\u0002\u00b9\u0007\u00b9"+
		"\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb\u0002\u00bc\u0007\u00bc"+
		"\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0002\u00bf\u0007\u00bf"+
		"\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1\u0002\u00c2\u0007\u00c2"+
		"\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4\u0002\u00c5\u0007\u00c5"+
		"\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7\u0002\u00c8\u0007\u00c8"+
		"\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca\u0002\u00cb\u0007\u00cb"+
		"\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd\u0002\u00ce\u0007\u00ce"+
		"\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0\u0002\u00d1\u0007\u00d1"+
		"\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3\u0002\u00d4\u0007\u00d4"+
		"\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6\u0002\u00d7\u0007\u00d7"+
		"\u0002\u00d8\u0007\u00d8\u0002\u00d9\u0007\u00d9\u0002\u00da\u0007\u00da"+
		"\u0002\u00db\u0007\u00db\u0002\u00dc\u0007\u00dc\u0002\u00dd\u0007\u00dd"+
		"\u0002\u00de\u0007\u00de\u0002\u00df\u0007\u00df\u0002\u00e0\u0007\u00e0"+
		"\u0002\u00e1\u0007\u00e1\u0002\u00e2\u0007\u00e2\u0002\u00e3\u0007\u00e3"+
		"\u0002\u00e4\u0007\u00e4\u0002\u00e5\u0007\u00e5\u0002\u00e6\u0007\u00e6"+
		"\u0002\u00e7\u0007\u00e7\u0002\u00e8\u0007\u00e8\u0002\u00e9\u0007\u00e9"+
		"\u0002\u00ea\u0007\u00ea\u0002\u00eb\u0007\u00eb\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0005\u0001\u01dc\b\u0001\n\u0001\f\u0001\u01df\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u01e3\b\u0001\n\u0001\f\u0001\u01e6\t\u0001"+
		"\u0001\u0001\u0003\u0001\u01e9\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"\u01ed\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u01f6\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u01fa\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u01fe\b"+
		"\u0006\n\u0006\f\u0006\u0201\t\u0006\u0001\u0007\u0005\u0007\u0204\b\u0007"+
		"\n\u0007\f\u0007\u0207\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u020b"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0210\b\u0007"+
		"\n\u0007\f\u0007\u0213\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0217"+
		"\b\u0007\u0003\u0007\u0219\b\u0007\u0001\b\u0001\b\u0005\b\u021d\b\b\n"+
		"\b\f\b\u0220\t\b\u0001\b\u0001\b\u0003\b\u0224\b\b\u0001\t\u0005\t\u0227"+
		"\b\t\n\t\f\t\u022a\t\t\u0001\t\u0001\t\u0003\t\u022e\b\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0005\r\u0237\b\r\n"+
		"\r\f\r\u023a\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0247\b\u000e\u0001\u000f\u0005\u000f\u024a\b\u000f\n\u000f\f\u000f"+
		"\u024d\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0252\b"+
		"\u000f\n\u000f\f\u000f\u0255\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0259\b\u000f\n\u000f\f\u000f\u025c\t\u000f\u0001\u0010\u0005\u0010\u025f"+
		"\b\u0010\n\u0010\f\u0010\u0262\t\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0266\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u026f\b\u0012\n\u0012\f\u0012\u0272"+
		"\t\u0012\u0003\u0012\u0274\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u0280\b\u0015\n\u0015\f\u0015\u0283\t\u0015\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0287\b\u0016\u0001\u0017\u0005\u0017\u028a"+
		"\b\u0017\n\u0017\f\u0017\u028d\t\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u0291\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u0297\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u029f\b\u0019\n\u0019\f\u0019\u02a2\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u02a9"+
		"\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0005\u001b\u02b1\b\u001b\n\u001b\f\u001b\u02b4\t\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u02bb\b\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u02c5\b\u001e\n\u001e\f\u001e\u02c8"+
		"\t\u001e\u0001\u001f\u0003\u001f\u02cb\b\u001f\u0001\u001f\u0005\u001f"+
		"\u02ce\b\u001f\n\u001f\f\u001f\u02d1\t\u001f\u0001\u001f\u0005\u001f\u02d4"+
		"\b\u001f\n\u001f\f\u001f\u02d7\t\u001f\u0001\u001f\u0001\u001f\u0001 "+
		"\u0005 \u02dc\b \n \f \u02df\t \u0001 \u0001 \u0001 \u0001 \u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u02eb\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0003\'\u0308\b\'\u0001(\u0001(\u0003"+
		"(\u030c\b(\u0001)\u0005)\u030f\b)\n)\f)\u0312\t)\u0001)\u0001)\u0001)"+
		"\u0003)\u0317\b)\u0001)\u0003)\u031a\b)\u0001)\u0003)\u031d\b)\u0001)"+
		"\u0001)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003"+
		"*\u0329\b*\u0001+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0005,\u0332"+
		"\b,\n,\f,\u0335\t,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001/\u0001"+
		"/\u0001/\u0005/\u0340\b/\n/\f/\u0343\t/\u00010\u00010\u00050\u0347\b0"+
		"\n0\f0\u034a\t0\u00010\u00010\u00011\u00011\u00011\u00011\u00031\u0352"+
		"\b1\u00012\u00012\u00012\u00012\u00012\u00032\u0359\b2\u00013\u00053\u035c"+
		"\b3\n3\f3\u035f\t3\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00014\u00034\u036d\b4\u00015\u00015\u00015\u0005"+
		"5\u0372\b5\n5\f5\u0375\t5\u00016\u00016\u00016\u00036\u037a\b6\u00017"+
		"\u00017\u00037\u037e\b7\u00018\u00018\u00038\u0382\b8\u00019\u00019\u0003"+
		"9\u0386\b9\u0001:\u0001:\u0003:\u038a\b:\u0001;\u0001;\u0001;\u0003;\u038f"+
		"\b;\u0001<\u0001<\u0003<\u0393\b<\u0001<\u0001<\u0005<\u0397\b<\n<\f<"+
		"\u039a\t<\u0001=\u0001=\u0003=\u039e\b=\u0001=\u0001=\u0001=\u0005=\u03a3"+
		"\b=\n=\f=\u03a6\t=\u0001=\u0001=\u0003=\u03aa\b=\u0003=\u03ac\b=\u0001"+
		">\u0001>\u0005>\u03b0\b>\n>\f>\u03b3\t>\u0001>\u0001>\u0003>\u03b7\b>"+
		"\u0001?\u0001?\u0003?\u03bb\b?\u0001@\u0001@\u0001A\u0001A\u0001B\u0001"+
		"B\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0001"+
		"D\u0001D\u0003D\u03ce\bD\u0001E\u0005E\u03d1\bE\nE\fE\u03d4\tE\u0001E"+
		"\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001"+
		"F\u0001F\u0001F\u0003F\u03e3\bF\u0001G\u0001G\u0001G\u0003G\u03e8\bG\u0001"+
		"G\u0001G\u0005G\u03ec\bG\nG\fG\u03ef\tG\u0001G\u0001G\u0001G\u0003G\u03f4"+
		"\bG\u0003G\u03f6\bG\u0001H\u0001H\u0003H\u03fa\bH\u0001I\u0001I\u0001"+
		"I\u0003I\u03ff\bI\u0001I\u0001I\u0003I\u0403\bI\u0001J\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0003J\u040b\bJ\u0001K\u0001K\u0001K\u0005K\u0410\bK\n"+
		"K\fK\u0413\tK\u0001K\u0001K\u0001K\u0005K\u0418\bK\nK\fK\u041b\tK\u0003"+
		"K\u041d\bK\u0001L\u0005L\u0420\bL\nL\fL\u0423\tL\u0001L\u0001L\u0001L"+
		"\u0001M\u0001M\u0003M\u042a\bM\u0001N\u0005N\u042d\bN\nN\fN\u0430\tN\u0001"+
		"N\u0001N\u0005N\u0434\bN\nN\fN\u0437\tN\u0001N\u0001N\u0001N\u0001N\u0003"+
		"N\u043d\bN\u0001O\u0005O\u0440\bO\nO\fO\u0443\tO\u0001O\u0001O\u0001O"+
		"\u0003O\u0448\bO\u0001O\u0001O\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001"+
		"Q\u0005Q\u0452\bQ\nQ\fQ\u0455\tQ\u0001R\u0001R\u0003R\u0459\bR\u0001S"+
		"\u0001S\u0003S\u045d\bS\u0001T\u0001T\u0001U\u0001U\u0001U\u0001V\u0005"+
		"V\u0465\bV\nV\fV\u0468\tV\u0001V\u0001V\u0003V\u046c\bV\u0001V\u0001V"+
		"\u0001W\u0001W\u0001W\u0001W\u0003W\u0474\bW\u0001X\u0003X\u0477\bX\u0001"+
		"X\u0001X\u0001X\u0003X\u047c\bX\u0001X\u0001X\u0001Y\u0001Y\u0001Z\u0001"+
		"Z\u0003Z\u0484\bZ\u0001Z\u0003Z\u0487\bZ\u0001Z\u0001Z\u0001[\u0003[\u048c"+
		"\b[\u0001[\u0001[\u0001[\u0003[\u0491\b[\u0001[\u0001[\u0001[\u0003[\u0496"+
		"\b[\u0001[\u0001[\u0001[\u0003[\u049b\b[\u0001[\u0001[\u0001[\u0001[\u0001"+
		"[\u0003[\u04a2\b[\u0001[\u0001[\u0001[\u0003[\u04a7\b[\u0001[\u0001[\u0001"+
		"[\u0001[\u0001[\u0001[\u0003[\u04af\b[\u0001[\u0001[\u0001[\u0003[\u04b4"+
		"\b[\u0001[\u0001[\u0001[\u0003[\u04b9\b[\u0001\\\u0005\\\u04bc\b\\\n\\"+
		"\f\\\u04bf\t\\\u0001\\\u0001\\\u0001\\\u0003\\\u04c4\b\\\u0001\\\u0001"+
		"\\\u0001]\u0001]\u0003]\u04ca\b]\u0001]\u0003]\u04cd\b]\u0001]\u0003]"+
		"\u04d0\b]\u0001]\u0001]\u0001^\u0001^\u0001^\u0005^\u04d7\b^\n^\f^\u04da"+
		"\t^\u0001_\u0005_\u04dd\b_\n_\f_\u04e0\t_\u0001_\u0001_\u0001_\u0003_"+
		"\u04e5\b_\u0001_\u0003_\u04e8\b_\u0001_\u0003_\u04eb\b_\u0001`\u0001`"+
		"\u0001a\u0001a\u0005a\u04f1\ba\na\fa\u04f4\ta\u0001b\u0001b\u0003b\u04f8"+
		"\bb\u0001c\u0005c\u04fb\bc\nc\fc\u04fe\tc\u0001c\u0001c\u0001c\u0003c"+
		"\u0503\bc\u0001c\u0003c\u0506\bc\u0001c\u0001c\u0001d\u0001d\u0001d\u0001"+
		"d\u0001d\u0001d\u0001d\u0003d\u0511\bd\u0001e\u0001e\u0001e\u0001f\u0001"+
		"f\u0005f\u0518\bf\nf\ff\u051b\tf\u0001f\u0001f\u0001g\u0001g\u0001g\u0001"+
		"g\u0001g\u0003g\u0524\bg\u0001h\u0005h\u0527\bh\nh\fh\u052a\th\u0001h"+
		"\u0001h\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0003i\u0534\bi\u0001"+
		"j\u0005j\u0537\bj\nj\fj\u053a\tj\u0001j\u0001j\u0001j\u0001k\u0001k\u0001"+
		"k\u0001k\u0001k\u0001k\u0003k\u0545\bk\u0001l\u0005l\u0548\bl\nl\fl\u054b"+
		"\tl\u0001l\u0001l\u0001l\u0001l\u0001l\u0001m\u0001m\u0005m\u0554\bm\n"+
		"m\fm\u0557\tm\u0001m\u0001m\u0001n\u0001n\u0001n\u0001n\u0001n\u0003n"+
		"\u0560\bn\u0001o\u0005o\u0563\bo\no\fo\u0566\to\u0001o\u0001o\u0001o\u0001"+
		"o\u0001o\u0003o\u056d\bo\u0001o\u0003o\u0570\bo\u0001o\u0001o\u0001p\u0001"+
		"p\u0001p\u0003p\u0577\bp\u0001q\u0001q\u0001q\u0001r\u0001r\u0001r\u0003"+
		"r\u057f\br\u0001s\u0001s\u0001s\u0001s\u0003s\u0585\bs\u0001s\u0001s\u0001"+
		"t\u0001t\u0001t\u0005t\u058c\bt\nt\ft\u058f\tt\u0001u\u0001u\u0001u\u0001"+
		"u\u0001v\u0001v\u0001v\u0003v\u0598\bv\u0001w\u0001w\u0003w\u059c\bw\u0001"+
		"w\u0003w\u059f\bw\u0001w\u0001w\u0001x\u0001x\u0001x\u0005x\u05a6\bx\n"+
		"x\fx\u05a9\tx\u0001y\u0001y\u0001y\u0001z\u0001z\u0001z\u0001z\u0001z"+
		"\u0001z\u0001{\u0001{\u0003{\u05b6\b{\u0001{\u0003{\u05b9\b{\u0001{\u0001"+
		"{\u0001|\u0001|\u0001|\u0005|\u05c0\b|\n|\f|\u05c3\t|\u0001}\u0001}\u0003"+
		"}\u05c7\b}\u0001}\u0001}\u0001~\u0004~\u05cc\b~\u000b~\f~\u05cd\u0001"+
		"\u007f\u0001\u007f\u0001\u007f\u0003\u007f\u05d3\b\u007f\u0001\u0080\u0001"+
		"\u0080\u0001\u0080\u0001\u0081\u0005\u0081\u05d9\b\u0081\n\u0081\f\u0081"+
		"\u05dc\t\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u05e7\b\u0082"+
		"\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0003\u0083"+
		"\u05ee\b\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084"+
		"\u0001\u0084\u0003\u0084\u05fc\b\u0084\u0001\u0085\u0001\u0085\u0001\u0086"+
		"\u0001\u0086\u0001\u0086\u0001\u0086\u0001\u0087\u0001\u0087\u0001\u0087"+
		"\u0001\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089"+
		"\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0003\u0089"+
		"\u0612\b\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0001\u008a"+
		"\u0001\u008a\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008b"+
		"\u0001\u008b\u0001\u008b\u0001\u008b\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008d"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d"+
		"\u0001\u008d\u0001\u008d\u0001\u008d\u0003\u008d\u0634\b\u008d\u0001\u008e"+
		"\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008e\u0001\u008f"+
		"\u0001\u008f\u0005\u008f\u063e\b\u008f\n\u008f\f\u008f\u0641\t\u008f\u0001"+
		"\u008f\u0005\u008f\u0644\b\u008f\n\u008f\f\u008f\u0647\t\u008f\u0001\u008f"+
		"\u0001\u008f\u0001\u0090\u0001\u0090\u0001\u0090\u0001\u0091\u0001\u0091"+
		"\u0005\u0091\u0650\b\u0091\n\u0091\f\u0091\u0653\t\u0091\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0092\u0003\u0092\u065f\b\u0092\u0001\u0093\u0001"+
		"\u0093\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0094\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001\u0095\u0001"+
		"\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001\u0096\u0001"+
		"\u0096\u0001\u0096\u0001\u0096\u0001\u0097\u0001\u0097\u0003\u0097\u0679"+
		"\b\u0097\u0001\u0098\u0001\u0098\u0003\u0098\u067d\b\u0098\u0001\u0099"+
		"\u0001\u0099\u0001\u0099\u0003\u0099\u0682\b\u0099\u0001\u0099\u0001\u0099"+
		"\u0003\u0099\u0686\b\u0099\u0001\u0099\u0001\u0099\u0003\u0099\u068a\b"+
		"\u0099\u0001\u0099\u0001\u0099\u0001\u0099\u0001\u009a\u0001\u009a\u0001"+
		"\u009a\u0003\u009a\u0692\b\u009a\u0001\u009a\u0001\u009a\u0003\u009a\u0696"+
		"\b\u009a\u0001\u009a\u0001\u009a\u0003\u009a\u069a\b\u009a\u0001\u009a"+
		"\u0001\u009a\u0001\u009a\u0001\u009b\u0001\u009b\u0003\u009b\u06a1\b\u009b"+
		"\u0001\u009c\u0001\u009c\u0001\u009d\u0001\u009d\u0001\u009d\u0005\u009d"+
		"\u06a8\b\u009d\n\u009d\f\u009d\u06ab\t\u009d\u0001\u009e\u0001\u009e\u0001"+
		"\u009e\u0005\u009e\u06b0\b\u009e\n\u009e\f\u009e\u06b3\t\u009e\u0001\u009e"+
		"\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e\u0001\u009e"+
		"\u0001\u009f\u0001\u009f\u0001\u009f\u0005\u009f\u06bf\b\u009f\n\u009f"+
		"\f\u009f\u06c2\t\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f"+
		"\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u00a0\u0001\u00a0\u0003\u00a0"+
		"\u06cd\b\u00a0\u0001\u00a0\u0001\u00a0\u0001\u00a1\u0001\u00a1\u0003\u00a1"+
		"\u06d3\b\u00a1\u0001\u00a1\u0001\u00a1\u0001\u00a2\u0001\u00a2\u0003\u00a2"+
		"\u06d9\b\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3\u0001\u00a3"+
		"\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4"+
		"\u0001\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a5"+
		"\u0001\u00a5\u0001\u00a5\u0003\u00a5\u06ee\b\u00a5\u0001\u00a5\u0001\u00a5"+
		"\u0001\u00a5\u0003\u00a5\u06f3\b\u00a5\u0001\u00a6\u0001\u00a6\u0005\u00a6"+
		"\u06f7\b\u00a6\n\u00a6\f\u00a6\u06fa\t\u00a6\u0001\u00a7\u0001\u00a7\u0001"+
		"\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a8\u0005\u00a8\u0703"+
		"\b\u00a8\n\u00a8\f\u00a8\u0706\t\u00a8\u0001\u00a8\u0001\u00a8\u0001\u00a8"+
		"\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0005\u00a9\u070e\b\u00a9\n\u00a9"+
		"\f\u00a9\u0711\t\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00ab"+
		"\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0003\u00ab\u071a\b\u00ab\u0001\u00ab"+
		"\u0003\u00ab\u071d\b\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac"+
		"\u0722\b\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ad"+
		"\u0005\u00ad\u0729\b\u00ad\n\u00ad\f\u00ad\u072c\t\u00ad\u0001\u00ae\u0005"+
		"\u00ae\u072f\b\u00ae\n\u00ae\f\u00ae\u0732\t\u00ae\u0001\u00ae\u0001\u00ae"+
		"\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001\u00af\u0001\u00af\u0003\u00af"+
		"\u073b\b\u00af\u0001\u00af\u0005\u00af\u073e\b\u00af\n\u00af\f\u00af\u0741"+
		"\t\u00af\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0005\u00b0\u0747"+
		"\b\u00b0\n\u00b0\f\u00b0\u074a\t\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0003\u00b0"+
		"\u0760\b\u00b0\u0001\u00b1\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0001\u00b2\u0005\u00b2\u0768\b\u00b2\n\u00b2\f\u00b2\u076b\t\u00b2\u0001"+
		"\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0003\u00b2\u0780\b\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0003\u00b3\u0787\b\u00b3\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0003\u00b5\u078f\b\u00b5\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0005\u00b6\u0795\b\u00b6\n"+
		"\u00b6\f\u00b6\u0798\t\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0005\u00b6\u07a0\b\u00b6\n\u00b6\f\u00b6"+
		"\u07a3\t\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6"+
		"\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0003\u00b6\u07b9\b\u00b6\u0001\u00b7"+
		"\u0001\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0005\u00b8"+
		"\u07c1\b\u00b8\n\u00b8\f\u00b8\u07c4\t\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0005\u00b8\u07cc\b\u00b8\n"+
		"\u00b8\f\u00b8\u07cf\t\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u07e4\b\u00b8\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u07e8\b\u00b9\u0001\u00b9\u0005\u00b9\u07eb"+
		"\b\u00b9\n\u00b9\f\u00b9\u07ee\t\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00b9"+
		"\u0005\u00b9\u07f3\b\u00b9\n\u00b9\f\u00b9\u07f6\t\u00b9\u0001\u00b9\u0005"+
		"\u00b9\u07f9\b\u00b9\n\u00b9\f\u00b9\u07fc\t\u00b9\u0001\u00b9\u0003\u00b9"+
		"\u07ff\b\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9\u0803\b\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u0807\b\u00b9\u0001\u00b9\u0001\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u080d\b\u00b9\u0001\u00b9\u0005\u00b9\u0810"+
		"\b\u00b9\n\u00b9\f\u00b9\u0813\t\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9"+
		"\u0817\b\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9\u081b\b\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u081f\b\u00b9\u0001\u00b9\u0001\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u0825\b\u00b9\u0001\u00b9\u0005\u00b9\u0828"+
		"\b\u00b9\n\u00b9\f\u00b9\u082b\t\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9"+
		"\u082f\b\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9\u0833\b\u00b9\u0001"+
		"\u00b9\u0001\u00b9\u0003\u00b9\u0837\b\u00b9\u0003\u00b9\u0839\b\u00b9"+
		"\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u083e\b\u00ba\u0001\u00ba"+
		"\u0005\u00ba\u0841\b\u00ba\n\u00ba\f\u00ba\u0844\t\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0003\u00ba\u0848\b\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u084c"+
		"\b\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u0850\b\u00ba\u0001\u00bb"+
		"\u0001\u00bb\u0003\u00bb\u0854\b\u00bb\u0001\u00bb\u0005\u00bb\u0857\b"+
		"\u00bb\n\u00bb\f\u00bb\u085a\t\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb"+
		"\u0005\u00bb\u085f\b\u00bb\n\u00bb\f\u00bb\u0862\t\u00bb\u0001\u00bb\u0005"+
		"\u00bb\u0865\b\u00bb\n\u00bb\f\u00bb\u0868\t\u00bb\u0001\u00bb\u0003\u00bb"+
		"\u086b\b\u00bb\u0001\u00bb\u0001\u00bb\u0003\u00bb\u086f\b\u00bb\u0001"+
		"\u00bb\u0001\u00bb\u0003\u00bb\u0873\b\u00bb\u0001\u00bb\u0001\u00bb\u0001"+
		"\u00bb\u0001\u00bb\u0003\u00bb\u0879\b\u00bb\u0001\u00bb\u0005\u00bb\u087c"+
		"\b\u00bb\n\u00bb\f\u00bb\u087f\t\u00bb\u0001\u00bb\u0001\u00bb\u0003\u00bb"+
		"\u0883\b\u00bb\u0001\u00bb\u0001\u00bb\u0003\u00bb\u0887\b\u00bb\u0001"+
		"\u00bb\u0001\u00bb\u0003\u00bb\u088b\b\u00bb\u0003\u00bb\u088d\b\u00bb"+
		"\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0003\u00bc\u0892\b\u00bc\u0001\u00bd"+
		"\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd"+
		"\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd"+
		"\u0003\u00bd\u08a1\b\u00bd\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00bf"+
		"\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf"+
		"\u0001\u00bf\u0001\u00bf\u0003\u00bf\u08af\b\u00bf\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c0\u0003\u00c0\u08bb\b\u00c0\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0005\u00c0\u08c2\b\u00c0\n\u00c0"+
		"\f\u00c0\u08c5\t\u00c0\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1"+
		"\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1"+
		"\u0005\u00c1\u08d1\b\u00c1\n\u00c1\f\u00c1\u08d4\t\u00c1\u0001\u00c2\u0001"+
		"\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0001"+
		"\u00c2\u0001\u00c2\u0001\u00c2\u0003\u00c2\u08e0\b\u00c2\u0001\u00c2\u0001"+
		"\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0005\u00c2\u08e7\b\u00c2\n"+
		"\u00c2\f\u00c2\u08ea\t\u00c2\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003"+
		"\u00c3\u08ef\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u08f6\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003"+
		"\u00c3\u08fb\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u0902\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003"+
		"\u00c3\u0907\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u090e\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003"+
		"\u00c3\u0913\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u091a\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003"+
		"\u00c3\u091f\b\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0001\u00c3\u0003\u00c3\u0927\b\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0003\u00c3\u092c\b\u00c3\u0001\u00c3\u0001\u00c3\u0003\u00c3\u0930"+
		"\b\u00c3\u0001\u00c4\u0001\u00c4\u0003\u00c4\u0934\b\u00c4\u0001\u00c4"+
		"\u0001\u00c4\u0001\u00c4\u0003\u00c4\u0939\b\u00c4\u0001\u00c4\u0001\u00c4"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0940\b\u00c5\u0001\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0947\b\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u094c\b\u00c5\u0001\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0953\b\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0958\b\u00c5\u0001\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u095f\b\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0964\b\u00c5\u0001\u00c5"+
		"\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5"+
		"\u096c\b\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0971\b"+
		"\u00c5\u0001\u00c5\u0001\u00c5\u0003\u00c5\u0975\b\u00c5\u0001\u00c6\u0001"+
		"\u00c6\u0001\u00c6\u0005\u00c6\u097a\b\u00c6\n\u00c6\f\u00c6\u097d\t\u00c6"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0003\u00c7\u0982\b\u00c7\u0001\u00c7"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0003\u00c7\u0989\b\u00c7"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0003\u00c7"+
		"\u0990\b\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7"+
		"\u0003\u00c7\u0997\b\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7"+
		"\u0001\u00c7\u0001\u00c7\u0003\u00c7\u099f\b\u00c7\u0001\u00c7\u0001\u00c7"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0003\u00c7\u09a6\b\u00c7\u0001\u00c7"+
		"\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0001\u00c7\u0003\u00c7"+
		"\u09ae\b\u00c7\u0001\u00c8\u0001\u00c8\u0003\u00c8\u09b2\b\u00c8\u0001"+
		"\u00c8\u0001\u00c8\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0003\u00c9\u09b9"+
		"\b\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0003"+
		"\u00c9\u09c0\b\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001"+
		"\u00c9\u0003\u00c9\u09c7\b\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001"+
		"\u00c9\u0001\u00c9\u0001\u00c9\u0003\u00c9\u09cf\b\u00c9\u0001\u00c9\u0001"+
		"\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0003\u00c9\u09d6\b\u00c9\u0001"+
		"\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0003"+
		"\u00c9\u09de\b\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0003"+
		"\u00ca\u09e4\b\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0003"+
		"\u00ca\u09ea\b\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001"+
		"\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0001\u00ca\u0003"+
		"\u00ca\u09f6\b\u00ca\u0001\u00cb\u0001\u00cb\u0005\u00cb\u09fa\b\u00cb"+
		"\n\u00cb\f\u00cb\u09fd\t\u00cb\u0001\u00cc\u0005\u00cc\u0a00\b\u00cc\n"+
		"\u00cc\f\u00cc\u0a03\t\u00cc\u0001\u00cc\u0001\u00cc\u0001\u00cc\u0001"+
		"\u00cc\u0001\u00cd\u0001\u00cd\u0001\u00ce\u0001\u00ce\u0003\u00ce\u0a0d"+
		"\b\u00ce\u0001\u00cf\u0001\u00cf\u0001\u00cf\u0001\u00cf\u0001\u00d0\u0001"+
		"\u00d0\u0001\u00d0\u0003\u00d0\u0a16\b\u00d0\u0001\u00d0\u0001\u00d0\u0001"+
		"\u00d0\u0001\u00d0\u0001\u00d0\u0003\u00d0\u0a1d\b\u00d0\u0001\u00d1\u0001"+
		"\u00d1\u0001\u00d1\u0005\u00d1\u0a22\b\u00d1\n\u00d1\f\u00d1\u0a25\t\u00d1"+
		"\u0001\u00d2\u0001\u00d2\u0003\u00d2\u0a29\b\u00d2\u0001\u00d3\u0001\u00d3"+
		"\u0003\u00d3\u0a2d\b\u00d3\u0001\u00d4\u0001\u00d4\u0001\u00d4\u0001\u00d4"+
		"\u0001\u00d5\u0001\u00d5\u0001\u00d5\u0003\u00d5\u0a36\b\u00d5\u0001\u00d6"+
		"\u0001\u00d6\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d7"+
		"\u0001\u00d7\u0001\u00d7\u0003\u00d7\u0a41\b\u00d7\u0001\u00d8\u0001\u00d8"+
		"\u0001\u00d8\u0001\u00d8\u0001\u00d8\u0001\u00d8\u0005\u00d8\u0a49\b\u00d8"+
		"\n\u00d8\f\u00d8\u0a4c\t\u00d8\u0001\u00d9\u0001\u00d9\u0001\u00d9\u0001"+
		"\u00d9\u0001\u00d9\u0001\u00d9\u0005\u00d9\u0a54\b\u00d9\n\u00d9\f\u00d9"+
		"\u0a57\t\u00d9\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da\u0001\u00da"+
		"\u0001\u00da\u0005\u00da\u0a5f\b\u00da\n\u00da\f\u00da\u0a62\t\u00da\u0001"+
		"\u00db\u0001\u00db\u0001\u00db\u0001\u00db\u0001\u00db\u0001\u00db\u0005"+
		"\u00db\u0a6a\b\u00db\n\u00db\f\u00db\u0a6d\t\u00db\u0001\u00dc\u0001\u00dc"+
		"\u0001\u00dc\u0001\u00dc\u0001\u00dc\u0001\u00dc\u0005\u00dc\u0a75\b\u00dc"+
		"\n\u00dc\f\u00dc\u0a78\t\u00dc\u0001\u00dd\u0001\u00dd\u0001\u00dd\u0001"+
		"\u00dd\u0001\u00dd\u0001\u00dd\u0001\u00dd\u0001\u00dd\u0001\u00dd\u0005"+
		"\u00dd\u0a83\b\u00dd\n\u00dd\f\u00dd\u0a86\t\u00dd\u0001\u00de\u0001\u00de"+
		"\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de"+
		"\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de"+
		"\u0001\u00de\u0001\u00de\u0001\u00de\u0001\u00de\u0005\u00de\u0a9a\b\u00de"+
		"\n\u00de\f\u00de\u0a9d\t\u00de\u0001\u00df\u0001\u00df\u0001\u00df\u0001"+
		"\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001"+
		"\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001\u00df\u0001"+
		"\u00df\u0005\u00df\u0aaf\b\u00df\n\u00df\f\u00df\u0ab2\t\u00df\u0001\u00e0"+
		"\u0001\u00e0\u0001\u00e0\u0001\u00e0\u0001\u00e0\u0001\u00e0\u0001\u00e0"+
		"\u0001\u00e0\u0001\u00e0\u0005\u00e0\u0abd\b\u00e0\n\u00e0\f\u00e0\u0ac0"+
		"\t\u00e0\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001"+
		"\u00e1\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001\u00e1\u0001"+
		"\u00e1\u0005\u00e1\u0ace\b\u00e1\n\u00e1\f\u00e1\u0ad1\t\u00e1\u0001\u00e2"+
		"\u0001\u00e2\u0001\u00e2\u0001\u00e2\u0001\u00e2\u0001\u00e2\u0001\u00e2"+
		"\u0003\u00e2\u0ada\b\u00e2\u0001\u00e3\u0001\u00e3\u0001\u00e3\u0001\u00e4"+
		"\u0001\u00e4\u0001\u00e4\u0001\u00e5\u0001\u00e5\u0001\u00e5\u0001\u00e5"+
		"\u0001\u00e5\u0001\u00e5\u0003\u00e5\u0ae8\b\u00e5\u0001\u00e6\u0001\u00e6"+
		"\u0003\u00e6\u0aec\b\u00e6\u0001\u00e6\u0001\u00e6\u0005\u00e6\u0af0\b"+
		"\u00e6\n\u00e6\f\u00e6\u0af3\t\u00e6\u0001\u00e7\u0001\u00e7\u0001\u00e7"+
		"\u0001\u00e8\u0001\u00e8\u0001\u00e9\u0001\u00e9\u0001\u00e9\u0001\u00ea"+
		"\u0001\u00ea\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb"+
		"\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0005\u00eb\u0b07\b\u00eb\n\u00eb"+
		"\f\u00eb\u0b0a\t\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb"+
		"\u0001\u00eb\u0001\u00eb\u0005\u00eb\u0b12\b\u00eb\n\u00eb\f\u00eb\u0b15"+
		"\t\u00eb\u0001\u00eb\u0001\u00eb\u0001\u00eb\u0003\u00eb\u0b1a\b\u00eb"+
		"\u0001\u00eb\u0000\r26<\u01b0\u01b2\u01b4\u01b6\u01b8\u01ba\u01bc\u01be"+
		"\u01c0\u01c2\u00ec\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfh"+
		"jlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a"+
		"\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122"+
		"\u0124\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a"+
		"\u013c\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152"+
		"\u0154\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a"+
		"\u016c\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182"+
		"\u0184\u0186\u0188\u018a\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a"+
		"\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8\u01aa\u01ac\u01ae\u01b0\u01b2"+
		"\u01b4\u01b6\u01b8\u01ba\u01bc\u01be\u01c0\u01c2\u01c4\u01c6\u01c8\u01ca"+
		"\u01cc\u01ce\u01d0\u01d2\u01d4\u01d6\u0000\u0004\u0001\u000038\u0005\u0000"+
		"\u0005\u0005\b\b\u001b\u001b\u001d\u001d%%\u0002\u0000\u000e\u000e\u0014"+
		"\u0014\u0002\u0000BB[e\u0c0d\u0000\u01d8\u0001\u0000\u0000\u0000\u0002"+
		"\u01e8\u0001\u0000\u0000\u0000\u0004\u01ec\u0001\u0000\u0000\u0000\u0006"+
		"\u01ee\u0001\u0000\u0000\u0000\b\u01f0\u0001\u0000\u0000\u0000\n\u01f5"+
		"\u0001\u0000\u0000\u0000\f\u01f9\u0001\u0000\u0000\u0000\u000e\u0218\u0001"+
		"\u0000\u0000\u0000\u0010\u021a\u0001\u0000\u0000\u0000\u0012\u0228\u0001"+
		"\u0000\u0000\u0000\u0014\u022f\u0001\u0000\u0000\u0000\u0016\u0231\u0001"+
		"\u0000\u0000\u0000\u0018\u0233\u0001\u0000\u0000\u0000\u001a\u0238\u0001"+
		"\u0000\u0000\u0000\u001c\u0246\u0001\u0000\u0000\u0000\u001e\u024b\u0001"+
		"\u0000\u0000\u0000 \u0260\u0001\u0000\u0000\u0000\"\u0267\u0001\u0000"+
		"\u0000\u0000$\u0273\u0001\u0000\u0000\u0000&\u0275\u0001\u0000\u0000\u0000"+
		"(\u0278\u0001\u0000\u0000\u0000*\u027c\u0001\u0000\u0000\u0000,\u0286"+
		"\u0001\u0000\u0000\u0000.\u028b\u0001\u0000\u0000\u00000\u0296\u0001\u0000"+
		"\u0000\u00002\u0298\u0001\u0000\u0000\u00004\u02a8\u0001\u0000\u0000\u0000"+
		"6\u02aa\u0001\u0000\u0000\u00008\u02ba\u0001\u0000\u0000\u0000:\u02bc"+
		"\u0001\u0000\u0000\u0000<\u02be\u0001\u0000\u0000\u0000>\u02ca\u0001\u0000"+
		"\u0000\u0000@\u02dd\u0001\u0000\u0000\u0000B\u02e4\u0001\u0000\u0000\u0000"+
		"D\u02ea\u0001\u0000\u0000\u0000F\u02ec\u0001\u0000\u0000\u0000H\u02f0"+
		"\u0001\u0000\u0000\u0000J\u02f6\u0001\u0000\u0000\u0000L\u02fd\u0001\u0000"+
		"\u0000\u0000N\u0307\u0001\u0000\u0000\u0000P\u030b\u0001\u0000\u0000\u0000"+
		"R\u0310\u0001\u0000\u0000\u0000T\u0328\u0001\u0000\u0000\u0000V\u032a"+
		"\u0001\u0000\u0000\u0000X\u032e\u0001\u0000\u0000\u0000Z\u0336\u0001\u0000"+
		"\u0000\u0000\\\u0339\u0001\u0000\u0000\u0000^\u033c\u0001\u0000\u0000"+
		"\u0000`\u0344\u0001\u0000\u0000\u0000b\u0351\u0001\u0000\u0000\u0000d"+
		"\u0358\u0001\u0000\u0000\u0000f\u035d\u0001\u0000\u0000\u0000h\u036c\u0001"+
		"\u0000\u0000\u0000j\u036e\u0001\u0000\u0000\u0000l\u0376\u0001\u0000\u0000"+
		"\u0000n\u037b\u0001\u0000\u0000\u0000p\u0381\u0001\u0000\u0000\u0000r"+
		"\u0385\u0001\u0000\u0000\u0000t\u0389\u0001\u0000\u0000\u0000v\u038e\u0001"+
		"\u0000\u0000\u0000x\u0392\u0001\u0000\u0000\u0000z\u03ab\u0001\u0000\u0000"+
		"\u0000|\u03ad\u0001\u0000\u0000\u0000~\u03b8\u0001\u0000\u0000\u0000\u0080"+
		"\u03bc\u0001\u0000\u0000\u0000\u0082\u03be\u0001\u0000\u0000\u0000\u0084"+
		"\u03c0\u0001\u0000\u0000\u0000\u0086\u03c2\u0001\u0000\u0000\u0000\u0088"+
		"\u03cd\u0001\u0000\u0000\u0000\u008a\u03d2\u0001\u0000\u0000\u0000\u008c"+
		"\u03e2\u0001\u0000\u0000\u0000\u008e\u03f5\u0001\u0000\u0000\u0000\u0090"+
		"\u03f9\u0001\u0000\u0000\u0000\u0092\u03fb\u0001\u0000\u0000\u0000\u0094"+
		"\u040a\u0001\u0000\u0000\u0000\u0096\u041c\u0001\u0000\u0000\u0000\u0098"+
		"\u0421\u0001\u0000\u0000\u0000\u009a\u0429\u0001\u0000\u0000\u0000\u009c"+
		"\u043c\u0001\u0000\u0000\u0000\u009e\u0441\u0001\u0000\u0000\u0000\u00a0"+
		"\u044b\u0001\u0000\u0000\u0000\u00a2\u044e\u0001\u0000\u0000\u0000\u00a4"+
		"\u0458\u0001\u0000\u0000\u0000\u00a6\u045c\u0001\u0000\u0000\u0000\u00a8"+
		"\u045e\u0001\u0000\u0000\u0000\u00aa\u0460\u0001\u0000\u0000\u0000\u00ac"+
		"\u0466\u0001\u0000\u0000\u0000\u00ae\u0473\u0001\u0000\u0000\u0000\u00b0"+
		"\u0476\u0001\u0000\u0000\u0000\u00b2\u047f\u0001\u0000\u0000\u0000\u00b4"+
		"\u0481\u0001\u0000\u0000\u0000\u00b6\u04b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u04bd\u0001\u0000\u0000\u0000\u00ba\u04c7\u0001\u0000\u0000\u0000\u00bc"+
		"\u04d3\u0001\u0000\u0000\u0000\u00be\u04de\u0001\u0000\u0000\u0000\u00c0"+
		"\u04ec\u0001\u0000\u0000\u0000\u00c2\u04ee\u0001\u0000\u0000\u0000\u00c4"+
		"\u04f7\u0001\u0000\u0000\u0000\u00c6\u04fc\u0001\u0000\u0000\u0000\u00c8"+
		"\u0510\u0001\u0000\u0000\u0000\u00ca\u0512\u0001\u0000\u0000\u0000\u00cc"+
		"\u0515\u0001\u0000\u0000\u0000\u00ce\u0523\u0001\u0000\u0000\u0000\u00d0"+
		"\u0528\u0001\u0000\u0000\u0000\u00d2\u0533\u0001\u0000\u0000\u0000\u00d4"+
		"\u0538\u0001\u0000\u0000\u0000\u00d6\u0544\u0001\u0000\u0000\u0000\u00d8"+
		"\u0549\u0001\u0000\u0000\u0000\u00da\u0551\u0001\u0000\u0000\u0000\u00dc"+
		"\u055f\u0001\u0000\u0000\u0000\u00de\u0564\u0001\u0000\u0000\u0000\u00e0"+
		"\u0576\u0001\u0000\u0000\u0000\u00e2\u0578\u0001\u0000\u0000\u0000\u00e4"+
		"\u057e\u0001\u0000\u0000\u0000\u00e6\u0580\u0001\u0000\u0000\u0000\u00e8"+
		"\u0588\u0001\u0000\u0000\u0000\u00ea\u0590\u0001\u0000\u0000\u0000\u00ec"+
		"\u0597\u0001\u0000\u0000\u0000\u00ee\u0599\u0001\u0000\u0000\u0000\u00f0"+
		"\u05a2\u0001\u0000\u0000\u0000\u00f2\u05aa\u0001\u0000\u0000\u0000\u00f4"+
		"\u05ad\u0001\u0000\u0000\u0000\u00f6\u05b3\u0001\u0000\u0000\u0000\u00f8"+
		"\u05bc\u0001\u0000\u0000\u0000\u00fa\u05c4\u0001\u0000\u0000\u0000\u00fc"+
		"\u05cb\u0001\u0000\u0000\u0000\u00fe\u05d2\u0001\u0000\u0000\u0000\u0100"+
		"\u05d4\u0001\u0000\u0000\u0000\u0102\u05da\u0001\u0000\u0000\u0000\u0104"+
		"\u05e6\u0001\u0000\u0000\u0000\u0106\u05ed\u0001\u0000\u0000\u0000\u0108"+
		"\u05fb\u0001\u0000\u0000\u0000\u010a\u05fd\u0001\u0000\u0000\u0000\u010c"+
		"\u05ff\u0001\u0000\u0000\u0000\u010e\u0603\u0001\u0000\u0000\u0000\u0110"+
		"\u0607\u0001\u0000\u0000\u0000\u0112\u0611\u0001\u0000\u0000\u0000\u0114"+
		"\u0613\u0001\u0000\u0000\u0000\u0116\u0619\u0001\u0000\u0000\u0000\u0118"+
		"\u0621\u0001\u0000\u0000\u0000\u011a\u0633\u0001\u0000\u0000\u0000\u011c"+
		"\u0635\u0001\u0000\u0000\u0000\u011e\u063b\u0001\u0000\u0000\u0000\u0120"+
		"\u064a\u0001\u0000\u0000\u0000\u0122\u064d\u0001\u0000\u0000\u0000\u0124"+
		"\u065e\u0001\u0000\u0000\u0000\u0126\u0660\u0001\u0000\u0000\u0000\u0128"+
		"\u0662\u0001\u0000\u0000\u0000\u012a\u0668\u0001\u0000\u0000\u0000\u012c"+
		"\u066e\u0001\u0000\u0000\u0000\u012e\u0678\u0001\u0000\u0000\u0000\u0130"+
		"\u067c\u0001\u0000\u0000\u0000\u0132\u067e\u0001\u0000\u0000\u0000\u0134"+
		"\u068e\u0001\u0000\u0000\u0000\u0136\u06a0\u0001\u0000\u0000\u0000\u0138"+
		"\u06a2\u0001\u0000\u0000\u0000\u013a\u06a4\u0001\u0000\u0000\u0000\u013c"+
		"\u06ac\u0001\u0000\u0000\u0000\u013e\u06bb\u0001\u0000\u0000\u0000\u0140"+
		"\u06ca\u0001\u0000\u0000\u0000\u0142\u06d0\u0001\u0000\u0000\u0000\u0144"+
		"\u06d6\u0001\u0000\u0000\u0000\u0146\u06dc\u0001\u0000\u0000\u0000\u0148"+
		"\u06e0\u0001\u0000\u0000\u0000\u014a\u06f2\u0001\u0000\u0000\u0000\u014c"+
		"\u06f4\u0001\u0000\u0000\u0000\u014e\u06fb\u0001\u0000\u0000\u0000\u0150"+
		"\u0704\u0001\u0000\u0000\u0000\u0152\u070a\u0001\u0000\u0000\u0000\u0154"+
		"\u0712\u0001\u0000\u0000\u0000\u0156\u0715\u0001\u0000\u0000\u0000\u0158"+
		"\u071e\u0001\u0000\u0000\u0000\u015a\u0725\u0001\u0000\u0000\u0000\u015c"+
		"\u0730\u0001\u0000\u0000\u0000\u015e\u073a\u0001\u0000\u0000\u0000\u0160"+
		"\u075f\u0001\u0000\u0000\u0000\u0162\u0761\u0001\u0000\u0000\u0000\u0164"+
		"\u077f\u0001\u0000\u0000\u0000\u0166\u0786\u0001\u0000\u0000\u0000\u0168"+
		"\u0788\u0001\u0000\u0000\u0000\u016a\u078e\u0001\u0000\u0000\u0000\u016c"+
		"\u07b8\u0001\u0000\u0000\u0000\u016e\u07ba\u0001\u0000\u0000\u0000\u0170"+
		"\u07e3\u0001\u0000\u0000\u0000\u0172\u0838\u0001\u0000\u0000\u0000\u0174"+
		"\u083a\u0001\u0000\u0000\u0000\u0176\u088c\u0001\u0000\u0000\u0000\u0178"+
		"\u0891\u0001\u0000\u0000\u0000\u017a\u08a0\u0001\u0000\u0000\u0000\u017c"+
		"\u08a2\u0001\u0000\u0000\u0000\u017e\u08ae\u0001\u0000\u0000\u0000\u0180"+
		"\u08ba\u0001\u0000\u0000\u0000\u0182\u08c6\u0001\u0000\u0000\u0000\u0184"+
		"\u08df\u0001\u0000\u0000\u0000\u0186\u092f\u0001\u0000\u0000\u0000\u0188"+
		"\u0931\u0001\u0000\u0000\u0000\u018a\u0974\u0001\u0000\u0000\u0000\u018c"+
		"\u0976\u0001\u0000\u0000\u0000\u018e\u09ad\u0001\u0000\u0000\u0000\u0190"+
		"\u09af\u0001\u0000\u0000\u0000\u0192\u09dd\u0001\u0000\u0000\u0000\u0194"+
		"\u09f5\u0001\u0000\u0000\u0000\u0196\u09f7\u0001\u0000\u0000\u0000\u0198"+
		"\u0a01\u0001\u0000\u0000\u0000\u019a\u0a08\u0001\u0000\u0000\u0000\u019c"+
		"\u0a0c\u0001\u0000\u0000\u0000\u019e\u0a0e\u0001\u0000\u0000\u0000\u01a0"+
		"\u0a1c\u0001\u0000\u0000\u0000\u01a2\u0a1e\u0001\u0000\u0000\u0000\u01a4"+
		"\u0a28\u0001\u0000\u0000\u0000\u01a6\u0a2c\u0001\u0000\u0000\u0000\u01a8"+
		"\u0a2e\u0001\u0000\u0000\u0000\u01aa\u0a35\u0001\u0000\u0000\u0000\u01ac"+
		"\u0a37\u0001\u0000\u0000\u0000\u01ae\u0a40\u0001\u0000\u0000\u0000\u01b0"+
		"\u0a42\u0001\u0000\u0000\u0000\u01b2\u0a4d\u0001\u0000\u0000\u0000\u01b4"+
		"\u0a58\u0001\u0000\u0000\u0000\u01b6\u0a63\u0001\u0000\u0000\u0000\u01b8"+
		"\u0a6e\u0001\u0000\u0000\u0000\u01ba\u0a79\u0001\u0000\u0000\u0000\u01bc"+
		"\u0a87\u0001\u0000\u0000\u0000\u01be\u0a9e\u0001\u0000\u0000\u0000\u01c0"+
		"\u0ab3\u0001\u0000\u0000\u0000\u01c2\u0ac1\u0001\u0000\u0000\u0000\u01c4"+
		"\u0ad9\u0001\u0000\u0000\u0000\u01c6\u0adb\u0001\u0000\u0000\u0000\u01c8"+
		"\u0ade\u0001\u0000\u0000\u0000\u01ca\u0ae7\u0001\u0000\u0000\u0000\u01cc"+
		"\u0aeb\u0001\u0000\u0000\u0000\u01ce\u0af4\u0001\u0000\u0000\u0000\u01d0"+
		"\u0af7\u0001\u0000\u0000\u0000\u01d2\u0af9\u0001\u0000\u0000\u0000\u01d4"+
		"\u0afc\u0001\u0000\u0000\u0000\u01d6\u0b19\u0001\u0000\u0000\u0000\u01d8"+
		"\u01d9\u0007\u0000\u0000\u0000\u01d9\u0001\u0001\u0000\u0000\u0000\u01da"+
		"\u01dc\u0003\u00e4r\u0000\u01db\u01da\u0001\u0000\u0000\u0000\u01dc\u01df"+
		"\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01dd\u01de"+
		"\u0001\u0000\u0000\u0000\u01de\u01e0\u0001\u0000\u0000\u0000\u01df\u01dd"+
		"\u0001\u0000\u0000\u0000\u01e0\u01e9\u0003\u0004\u0002\u0000\u01e1\u01e3"+
		"\u0003\u00e4r\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e6\u0001"+
		"\u0000\u0000\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e7\u01e9\u0005\u0003\u0000\u0000\u01e8\u01dd\u0001"+
		"\u0000\u0000\u0000\u01e8\u01e4\u0001\u0000\u0000\u0000\u01e9\u0003\u0001"+
		"\u0000\u0000\u0000\u01ea\u01ed\u0003\u0006\u0003\u0000\u01eb\u01ed\u0003"+
		"\b\u0004\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ec\u01eb\u0001\u0000"+
		"\u0000\u0000\u01ed\u0005\u0001\u0000\u0000\u0000\u01ee\u01ef\u0007\u0001"+
		"\u0000\u0000\u01ef\u0007\u0001\u0000\u0000\u0000\u01f0\u01f1\u0007\u0002"+
		"\u0000\u0000\u01f1\t\u0001\u0000\u0000\u0000\u01f2\u01f6\u0003\f\u0006"+
		"\u0000\u01f3\u01f6\u0003\u001a\r\u0000\u01f4\u01f6\u0003\u001c\u000e\u0000"+
		"\u01f5\u01f2\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f4\u0001\u0000\u0000\u0000\u01f6\u000b\u0001\u0000\u0000\u0000"+
		"\u01f7\u01fa\u0003\u0012\t\u0000\u01f8\u01fa\u0003\u0018\f\u0000\u01f9"+
		"\u01f7\u0001\u0000\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01fa"+
		"\u01ff\u0001\u0000\u0000\u0000\u01fb\u01fe\u0003\u0010\b\u0000\u01fc\u01fe"+
		"\u0003\u0016\u000b\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fc"+
		"\u0001\u0000\u0000\u0000\u01fe\u0201\u0001\u0000\u0000\u0000\u01ff\u01fd"+
		"\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200\r\u0001"+
		"\u0000\u0000\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0202\u0204\u0003"+
		"\u00e4r\u0000\u0203\u0202\u0001\u0000\u0000\u0000\u0204\u0207\u0001\u0000"+
		"\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000"+
		"\u0000\u0000\u0206\u0208\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000"+
		"\u0000\u0000\u0208\u020a\u0005f\u0000\u0000\u0209\u020b\u0003(\u0014\u0000"+
		"\u020a\u0209\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000\u0000\u0000"+
		"\u020b\u0219\u0001\u0000\u0000\u0000\u020c\u020d\u0003\f\u0006\u0000\u020d"+
		"\u0211\u0005A\u0000\u0000\u020e\u0210\u0003\u00e4r\u0000\u020f\u020e\u0001"+
		"\u0000\u0000\u0000\u0210\u0213\u0001\u0000\u0000\u0000\u0211\u020f\u0001"+
		"\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0214\u0001"+
		"\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0214\u0216\u0005"+
		"f\u0000\u0000\u0215\u0217\u0003(\u0014\u0000\u0216\u0215\u0001\u0000\u0000"+
		"\u0000\u0216\u0217\u0001\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000"+
		"\u0000\u0218\u0205\u0001\u0000\u0000\u0000\u0218\u020c\u0001\u0000\u0000"+
		"\u0000\u0219\u000f\u0001\u0000\u0000\u0000\u021a\u021e\u0005A\u0000\u0000"+
		"\u021b\u021d\u0003\u00e4r\u0000\u021c\u021b\u0001\u0000\u0000\u0000\u021d"+
		"\u0220\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021e"+
		"\u021f\u0001\u0000\u0000\u0000\u021f\u0221\u0001\u0000\u0000\u0000\u0220"+
		"\u021e\u0001\u0000\u0000\u0000\u0221\u0223\u0005f\u0000\u0000\u0222\u0224"+
		"\u0003(\u0014\u0000\u0223\u0222\u0001\u0000\u0000\u0000\u0223\u0224\u0001"+
		"\u0000\u0000\u0000\u0224\u0011\u0001\u0000\u0000\u0000\u0225\u0227\u0003"+
		"\u00e4r\u0000\u0226\u0225\u0001\u0000\u0000\u0000\u0227\u022a\u0001\u0000"+
		"\u0000\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0228\u0229\u0001\u0000"+
		"\u0000\u0000\u0229\u022b\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000"+
		"\u0000\u0000\u022b\u022d\u0005f\u0000\u0000\u022c\u022e\u0003(\u0014\u0000"+
		"\u022d\u022c\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000"+
		"\u022e\u0013\u0001\u0000\u0000\u0000\u022f\u0230\u0003\u000e\u0007\u0000"+
		"\u0230\u0015\u0001\u0000\u0000\u0000\u0231\u0232\u0003\u0010\b\u0000\u0232"+
		"\u0017\u0001\u0000\u0000\u0000\u0233\u0234\u0003\u0012\t\u0000\u0234\u0019"+
		"\u0001\u0000\u0000\u0000\u0235\u0237\u0003\u00e4r\u0000\u0236\u0235\u0001"+
		"\u0000\u0000\u0000\u0237\u023a\u0001\u0000\u0000\u0000\u0238\u0236\u0001"+
		"\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u023b\u0001"+
		"\u0000\u0000\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023b\u023c\u0005"+
		"f\u0000\u0000\u023c\u001b\u0001\u0000\u0000\u0000\u023d\u023e\u0003\u0002"+
		"\u0001\u0000\u023e\u023f\u0003\u001e\u000f\u0000\u023f\u0247\u0001\u0000"+
		"\u0000\u0000\u0240\u0241\u0003\f\u0006\u0000\u0241\u0242\u0003\u001e\u000f"+
		"\u0000\u0242\u0247\u0001\u0000\u0000\u0000\u0243\u0244\u0003\u001a\r\u0000"+
		"\u0244\u0245\u0003\u001e\u000f\u0000\u0245\u0247\u0001\u0000\u0000\u0000"+
		"\u0246\u023d\u0001\u0000\u0000\u0000\u0246\u0240\u0001\u0000\u0000\u0000"+
		"\u0246\u0243\u0001\u0000\u0000\u0000\u0247\u001d\u0001\u0000\u0000\u0000"+
		"\u0248\u024a\u0003\u00e4r\u0000\u0249\u0248\u0001\u0000\u0000\u0000\u024a"+
		"\u024d\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b"+
		"\u024c\u0001\u0000\u0000\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d"+
		"\u024b\u0001\u0000\u0000\u0000\u024e\u024f\u0005=\u0000\u0000\u024f\u025a"+
		"\u0005>\u0000\u0000\u0250\u0252\u0003\u00e4r\u0000\u0251\u0250\u0001\u0000"+
		"\u0000\u0000\u0252\u0255\u0001\u0000\u0000\u0000\u0253\u0251\u0001\u0000"+
		"\u0000\u0000\u0253\u0254\u0001\u0000\u0000\u0000\u0254\u0256\u0001\u0000"+
		"\u0000\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0256\u0257\u0005=\u0000"+
		"\u0000\u0257\u0259\u0005>\u0000\u0000\u0258\u0253\u0001\u0000\u0000\u0000"+
		"\u0259\u025c\u0001\u0000\u0000\u0000\u025a\u0258\u0001\u0000\u0000\u0000"+
		"\u025a\u025b\u0001\u0000\u0000\u0000\u025b\u001f\u0001\u0000\u0000\u0000"+
		"\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u025f\u0003\"\u0011\u0000\u025e"+
		"\u025d\u0001\u0000\u0000\u0000\u025f\u0262\u0001\u0000\u0000\u0000\u0260"+
		"\u025e\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261"+
		"\u0263\u0001\u0000\u0000\u0000\u0262\u0260\u0001\u0000\u0000\u0000\u0263"+
		"\u0265\u0005f\u0000\u0000\u0264\u0266\u0003$\u0012\u0000\u0265\u0264\u0001"+
		"\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266!\u0001\u0000"+
		"\u0000\u0000\u0267\u0268\u0003\u00e4r\u0000\u0268#\u0001\u0000\u0000\u0000"+
		"\u0269\u026a\u0005\u0011\u0000\u0000\u026a\u0274\u0003\u001a\r\u0000\u026b"+
		"\u026c\u0005\u0011\u0000\u0000\u026c\u0270\u0003\f\u0006\u0000\u026d\u026f"+
		"\u0003&\u0013\u0000\u026e\u026d\u0001\u0000\u0000\u0000\u026f\u0272\u0001"+
		"\u0000\u0000\u0000\u0270\u026e\u0001\u0000\u0000\u0000\u0270\u0271\u0001"+
		"\u0000\u0000\u0000\u0271\u0274\u0001\u0000\u0000\u0000\u0272\u0270\u0001"+
		"\u0000\u0000\u0000\u0273\u0269\u0001\u0000\u0000\u0000\u0273\u026b\u0001"+
		"\u0000\u0000\u0000\u0274%\u0001\u0000\u0000\u0000\u0275\u0276\u0005U\u0000"+
		"\u0000\u0276\u0277\u0003\u0014\n\u0000\u0277\'\u0001\u0000\u0000\u0000"+
		"\u0278\u0279\u0005D\u0000\u0000\u0279\u027a\u0003*\u0015\u0000\u027a\u027b"+
		"\u0005C\u0000\u0000\u027b)\u0001\u0000\u0000\u0000\u027c\u0281\u0003,"+
		"\u0016\u0000\u027d\u027e\u0005@\u0000\u0000\u027e\u0280\u0003,\u0016\u0000"+
		"\u027f\u027d\u0001\u0000\u0000\u0000\u0280\u0283\u0001\u0000\u0000\u0000"+
		"\u0281\u027f\u0001\u0000\u0000\u0000\u0281\u0282\u0001\u0000\u0000\u0000"+
		"\u0282+\u0001\u0000\u0000\u0000\u0283\u0281\u0001\u0000\u0000\u0000\u0284"+
		"\u0287\u0003\n\u0005\u0000\u0285\u0287\u0003.\u0017\u0000\u0286\u0284"+
		"\u0001\u0000\u0000\u0000\u0286\u0285\u0001\u0000\u0000\u0000\u0287-\u0001"+
		"\u0000\u0000\u0000\u0288\u028a\u0003\u00e4r\u0000\u0289\u0288\u0001\u0000"+
		"\u0000\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001\u0000"+
		"\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c\u028e\u0001\u0000"+
		"\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028e\u0290\u0005G\u0000"+
		"\u0000\u028f\u0291\u00030\u0018\u0000\u0290\u028f\u0001\u0000\u0000\u0000"+
		"\u0290\u0291\u0001\u0000\u0000\u0000\u0291/\u0001\u0000\u0000\u0000\u0292"+
		"\u0293\u0005\u0011\u0000\u0000\u0293\u0297\u0003\n\u0005\u0000\u0294\u0295"+
		"\u0005(\u0000\u0000\u0295\u0297\u0003\n\u0005\u0000\u0296\u0292\u0001"+
		"\u0000\u0000\u0000\u0296\u0294\u0001\u0000\u0000\u0000\u02971\u0001\u0000"+
		"\u0000\u0000\u0298\u0299\u0006\u0019\uffff\uffff\u0000\u0299\u029a\u0005"+
		"f\u0000\u0000\u029a\u02a0\u0001\u0000\u0000\u0000\u029b\u029c\n\u0001"+
		"\u0000\u0000\u029c\u029d\u0005A\u0000\u0000\u029d\u029f\u0005f\u0000\u0000"+
		"\u029e\u029b\u0001\u0000\u0000\u0000\u029f\u02a2\u0001\u0000\u0000\u0000"+
		"\u02a0\u029e\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000\u0000"+
		"\u02a13\u0001\u0000\u0000\u0000\u02a2\u02a0\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a9\u0005f\u0000\u0000\u02a4\u02a5\u00036\u001b\u0000\u02a5\u02a6\u0005"+
		"A\u0000\u0000\u02a6\u02a7\u0005f\u0000\u0000\u02a7\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a8\u02a3\u0001\u0000\u0000\u0000\u02a8\u02a4\u0001\u0000\u0000"+
		"\u0000\u02a95\u0001\u0000\u0000\u0000\u02aa\u02ab\u0006\u001b\uffff\uffff"+
		"\u0000\u02ab\u02ac\u0005f\u0000\u0000\u02ac\u02b2\u0001\u0000\u0000\u0000"+
		"\u02ad\u02ae\n\u0001\u0000\u0000\u02ae\u02af\u0005A\u0000\u0000\u02af"+
		"\u02b1\u0005f\u0000\u0000\u02b0\u02ad\u0001\u0000\u0000\u0000\u02b1\u02b4"+
		"\u0001\u0000\u0000\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3"+
		"\u0001\u0000\u0000\u0000\u02b37\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001"+
		"\u0000\u0000\u0000\u02b5\u02bb\u0005f\u0000\u0000\u02b6\u02b7\u0003<\u001e"+
		"\u0000\u02b7\u02b8\u0005A\u0000\u0000\u02b8\u02b9\u0005f\u0000\u0000\u02b9"+
		"\u02bb\u0001\u0000\u0000\u0000\u02ba\u02b5\u0001\u0000\u0000\u0000\u02ba"+
		"\u02b6\u0001\u0000\u0000\u0000\u02bb9\u0001\u0000\u0000\u0000\u02bc\u02bd"+
		"\u0005f\u0000\u0000\u02bd;\u0001\u0000\u0000\u0000\u02be\u02bf\u0006\u001e"+
		"\uffff\uffff\u0000\u02bf\u02c0\u0005f\u0000\u0000\u02c0\u02c6\u0001\u0000"+
		"\u0000\u0000\u02c1\u02c2\n\u0001\u0000\u0000\u02c2\u02c3\u0005A\u0000"+
		"\u0000\u02c3\u02c5\u0005f\u0000\u0000\u02c4\u02c1\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c8\u0001\u0000\u0000\u0000\u02c6\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7=\u0001\u0000\u0000\u0000\u02c8"+
		"\u02c6\u0001\u0000\u0000\u0000\u02c9\u02cb\u0003@ \u0000\u02ca\u02c9\u0001"+
		"\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000\u0000\u02cb\u02cf\u0001"+
		"\u0000\u0000\u0000\u02cc\u02ce\u0003D\"\u0000\u02cd\u02cc\u0001\u0000"+
		"\u0000\u0000\u02ce\u02d1\u0001\u0000\u0000\u0000\u02cf\u02cd\u0001\u0000"+
		"\u0000\u0000\u02cf\u02d0\u0001\u0000\u0000\u0000\u02d0\u02d5\u0001\u0000"+
		"\u0000\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d2\u02d4\u0003N\'"+
		"\u0000\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d4\u02d7\u0001\u0000\u0000"+
		"\u0000\u02d5\u02d3\u0001\u0000\u0000\u0000\u02d5\u02d6\u0001\u0000\u0000"+
		"\u0000\u02d6\u02d8\u0001\u0000\u0000\u0000\u02d7\u02d5\u0001\u0000\u0000"+
		"\u0000\u02d8\u02d9\u0005\u0000\u0000\u0001\u02d9?\u0001\u0000\u0000\u0000"+
		"\u02da\u02dc\u0003B!\u0000\u02db\u02da\u0001\u0000\u0000\u0000\u02dc\u02df"+
		"\u0001\u0000\u0000\u0000\u02dd\u02db\u0001\u0000\u0000\u0000\u02dd\u02de"+
		"\u0001\u0000\u0000\u0000\u02de\u02e0\u0001\u0000\u0000\u0000\u02df\u02dd"+
		"\u0001\u0000\u0000\u0000\u02e0\u02e1\u0005 \u0000\u0000\u02e1\u02e2\u0003"+
		"2\u0019\u0000\u02e2\u02e3\u0005?\u0000\u0000\u02e3A\u0001\u0000\u0000"+
		"\u0000\u02e4\u02e5\u0003\u00e4r\u0000\u02e5C\u0001\u0000\u0000\u0000\u02e6"+
		"\u02eb\u0003F#\u0000\u02e7\u02eb\u0003H$\u0000\u02e8\u02eb\u0003J%\u0000"+
		"\u02e9\u02eb\u0003L&\u0000\u02ea\u02e6\u0001\u0000\u0000\u0000\u02ea\u02e7"+
		"\u0001\u0000\u0000\u0000\u02ea\u02e8\u0001\u0000\u0000\u0000\u02ea\u02e9"+
		"\u0001\u0000\u0000\u0000\u02ebE\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005"+
		"\u0019\u0000\u0000\u02ed\u02ee\u00034\u001a\u0000\u02ee\u02ef\u0005?\u0000"+
		"\u0000\u02efG\u0001\u0000\u0000\u0000\u02f0\u02f1\u0005\u0019\u0000\u0000"+
		"\u02f1\u02f2\u00036\u001b\u0000\u02f2\u02f3\u0005A\u0000\u0000\u02f3\u02f4"+
		"\u0005S\u0000\u0000\u02f4\u02f5\u0005?\u0000\u0000\u02f5I\u0001\u0000"+
		"\u0000\u0000\u02f6\u02f7\u0005\u0019\u0000\u0000\u02f7\u02f8\u0005&\u0000"+
		"\u0000\u02f8\u02f9\u00034\u001a\u0000\u02f9\u02fa\u0005A\u0000\u0000\u02fa"+
		"\u02fb\u0005f\u0000\u0000\u02fb\u02fc\u0005?\u0000\u0000\u02fcK\u0001"+
		"\u0000\u0000\u0000\u02fd\u02fe\u0005\u0019\u0000\u0000\u02fe\u02ff\u0005"+
		"&\u0000\u0000\u02ff\u0300\u00034\u001a\u0000\u0300\u0301\u0005A\u0000"+
		"\u0000\u0301\u0302\u0005S\u0000\u0000\u0302\u0303\u0005?\u0000\u0000\u0303"+
		"M\u0001\u0000\u0000\u0000\u0304\u0308\u0003P(\u0000\u0305\u0308\u0003"+
		"\u00c4b\u0000\u0306\u0308\u0005?\u0000\u0000\u0307\u0304\u0001\u0000\u0000"+
		"\u0000\u0307\u0305\u0001\u0000\u0000\u0000\u0307\u0306\u0001\u0000\u0000"+
		"\u0000\u0308O\u0001\u0000\u0000\u0000\u0309\u030c\u0003R)\u0000\u030a"+
		"\u030c\u0003\u00b8\\\u0000\u030b\u0309\u0001\u0000\u0000\u0000\u030b\u030a"+
		"\u0001\u0000\u0000\u0000\u030cQ\u0001\u0000\u0000\u0000\u030d\u030f\u0003"+
		"T*\u0000\u030e\u030d\u0001\u0000\u0000\u0000\u030f\u0312\u0001\u0000\u0000"+
		"\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000"+
		"\u0000\u0311\u0313\u0001\u0000\u0000\u0000\u0312\u0310\u0001\u0000\u0000"+
		"\u0000\u0313\u0314\u0005\t\u0000\u0000\u0314\u0316\u0005f\u0000\u0000"+
		"\u0315\u0317\u0003V+\u0000\u0316\u0315\u0001\u0000\u0000\u0000\u0316\u0317"+
		"\u0001\u0000\u0000\u0000\u0317\u0319\u0001\u0000\u0000\u0000\u0318\u031a"+
		"\u0003Z-\u0000\u0319\u0318\u0001\u0000\u0000\u0000\u0319\u031a\u0001\u0000"+
		"\u0000\u0000\u031a\u031c\u0001\u0000\u0000\u0000\u031b\u031d\u0003\\."+
		"\u0000\u031c\u031b\u0001\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000"+
		"\u0000\u031d\u031e\u0001\u0000\u0000\u0000\u031e\u031f\u0003`0\u0000\u031f"+
		"S\u0001\u0000\u0000\u0000\u0320\u0329\u0003\u00e4r\u0000\u0321\u0329\u0005"+
		"#\u0000\u0000\u0322\u0329\u0005\"\u0000\u0000\u0323\u0329\u0005!\u0000"+
		"\u0000\u0324\u0329\u0005\u0001\u0000\u0000\u0325\u0329\u0005&\u0000\u0000"+
		"\u0326\u0329\u0005\u0012\u0000\u0000\u0327\u0329\u0005\'\u0000\u0000\u0328"+
		"\u0320\u0001\u0000\u0000\u0000\u0328\u0321\u0001\u0000\u0000\u0000\u0328"+
		"\u0322\u0001\u0000\u0000\u0000\u0328\u0323\u0001\u0000\u0000\u0000\u0328"+
		"\u0324\u0001\u0000\u0000\u0000\u0328\u0325\u0001\u0000\u0000\u0000\u0328"+
		"\u0326\u0001\u0000\u0000\u0000\u0328\u0327\u0001\u0000\u0000\u0000\u0329"+
		"U\u0001\u0000\u0000\u0000\u032a\u032b\u0005D\u0000\u0000\u032b\u032c\u0003"+
		"X,\u0000\u032c\u032d\u0005C\u0000\u0000\u032dW\u0001\u0000\u0000\u0000"+
		"\u032e\u0333\u0003 \u0010\u0000\u032f\u0330\u0005@\u0000\u0000\u0330\u0332"+
		"\u0003 \u0010\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0332\u0335\u0001"+
		"\u0000\u0000\u0000\u0333\u0331\u0001\u0000\u0000\u0000\u0333\u0334\u0001"+
		"\u0000\u0000\u0000\u0334Y\u0001\u0000\u0000\u0000\u0335\u0333\u0001\u0000"+
		"\u0000\u0000\u0336\u0337\u0005\u0011\u0000\u0000\u0337\u0338\u0003\u000e"+
		"\u0007\u0000\u0338[\u0001\u0000\u0000\u0000\u0339\u033a\u0005\u0018\u0000"+
		"\u0000\u033a\u033b\u0003^/\u0000\u033b]\u0001\u0000\u0000\u0000\u033c"+
		"\u0341\u0003\u0014\n\u0000\u033d\u033e\u0005@\u0000\u0000\u033e\u0340"+
		"\u0003\u0014\n\u0000\u033f\u033d\u0001\u0000\u0000\u0000\u0340\u0343\u0001"+
		"\u0000\u0000\u0000\u0341\u033f\u0001\u0000\u0000\u0000\u0341\u0342\u0001"+
		"\u0000\u0000\u0000\u0342_\u0001\u0000\u0000\u0000\u0343\u0341\u0001\u0000"+
		"\u0000\u0000\u0344\u0348\u0005;\u0000\u0000\u0345\u0347\u0003b1\u0000"+
		"\u0346\u0345\u0001\u0000\u0000\u0000\u0347\u034a\u0001\u0000\u0000\u0000"+
		"\u0348\u0346\u0001\u0000\u0000\u0000\u0348\u0349\u0001\u0000\u0000\u0000"+
		"\u0349\u034b\u0001\u0000\u0000\u0000\u034a\u0348\u0001\u0000\u0000\u0000"+
		"\u034b\u034c\u0005<\u0000\u0000\u034ca\u0001\u0000\u0000\u0000\u034d\u0352"+
		"\u0003d2\u0000\u034e\u0352\u0003\u00a8T\u0000\u034f\u0352\u0003\u00aa"+
		"U\u0000\u0350\u0352\u0003\u00acV\u0000\u0351\u034d\u0001\u0000\u0000\u0000"+
		"\u0351\u034e\u0001\u0000\u0000\u0000\u0351\u034f\u0001\u0000\u0000\u0000"+
		"\u0351\u0350\u0001\u0000\u0000\u0000\u0352c\u0001\u0000\u0000\u0000\u0353"+
		"\u0359\u0003f3\u0000\u0354\u0359\u0003\u008aE\u0000\u0355\u0359\u0003"+
		"P(\u0000\u0356\u0359\u0003\u00c4b\u0000\u0357\u0359\u0005?\u0000\u0000"+
		"\u0358\u0353\u0001\u0000\u0000\u0000\u0358\u0354\u0001\u0000\u0000\u0000"+
		"\u0358\u0355\u0001\u0000\u0000\u0000\u0358\u0356\u0001\u0000\u0000\u0000"+
		"\u0358\u0357\u0001\u0000\u0000\u0000\u0359e\u0001\u0000\u0000\u0000\u035a"+
		"\u035c\u0003h4\u0000\u035b\u035a\u0001\u0000\u0000\u0000\u035c\u035f\u0001"+
		"\u0000\u0000\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035d\u035e\u0001"+
		"\u0000\u0000\u0000\u035e\u0360\u0001\u0000\u0000\u0000\u035f\u035d\u0001"+
		"\u0000\u0000\u0000\u0360\u0361\u0003r9\u0000\u0361\u0362\u0003j5\u0000"+
		"\u0362\u0363\u0005?\u0000\u0000\u0363g\u0001\u0000\u0000\u0000\u0364\u036d"+
		"\u0003\u00e4r\u0000\u0365\u036d\u0005#\u0000\u0000\u0366\u036d\u0005\""+
		"\u0000\u0000\u0367\u036d\u0005!\u0000\u0000\u0368\u036d\u0005&\u0000\u0000"+
		"\u0369\u036d\u0005\u0012\u0000\u0000\u036a\u036d\u0005.\u0000\u0000\u036b"+
		"\u036d\u00051\u0000\u0000\u036c\u0364\u0001\u0000\u0000\u0000\u036c\u0365"+
		"\u0001\u0000\u0000\u0000\u036c\u0366\u0001\u0000\u0000\u0000\u036c\u0367"+
		"\u0001\u0000\u0000\u0000\u036c\u0368\u0001\u0000\u0000\u0000\u036c\u0369"+
		"\u0001\u0000\u0000\u0000\u036c\u036a\u0001\u0000\u0000\u0000\u036c\u036b"+
		"\u0001\u0000\u0000\u0000\u036di\u0001\u0000\u0000\u0000\u036e\u0373\u0003"+
		"l6\u0000\u036f\u0370\u0005@\u0000\u0000\u0370\u0372\u0003l6\u0000\u0371"+
		"\u036f\u0001\u0000\u0000\u0000\u0372\u0375\u0001\u0000\u0000\u0000\u0373"+
		"\u0371\u0001\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000\u0374"+
		"k\u0001\u0000\u0000\u0000\u0375\u0373\u0001\u0000\u0000\u0000\u0376\u0379"+
		"\u0003n7\u0000\u0377\u0378\u0005B\u0000\u0000\u0378\u037a\u0003p8\u0000"+
		"\u0379\u0377\u0001\u0000\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000"+
		"\u037am\u0001\u0000\u0000\u0000\u037b\u037d\u0005f\u0000\u0000\u037c\u037e"+
		"\u0003\u001e\u000f\u0000\u037d\u037c\u0001\u0000\u0000\u0000\u037d\u037e"+
		"\u0001\u0000\u0000\u0000\u037eo\u0001\u0000\u0000\u0000\u037f\u0382\u0003"+
		"\u019c\u00ce\u0000\u0380\u0382\u0003\u00f6{\u0000\u0381\u037f\u0001\u0000"+
		"\u0000\u0000\u0381\u0380\u0001\u0000\u0000\u0000\u0382q\u0001\u0000\u0000"+
		"\u0000\u0383\u0386\u0003t:\u0000\u0384\u0386\u0003v;\u0000\u0385\u0383"+
		"\u0001\u0000\u0000\u0000\u0385\u0384\u0001\u0000\u0000\u0000\u0386s\u0001"+
		"\u0000\u0000\u0000\u0387\u038a\u0003\u0004\u0002\u0000\u0388\u038a\u0005"+
		"\u0003\u0000\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u0389\u0388\u0001"+
		"\u0000\u0000\u0000\u038au\u0001\u0000\u0000\u0000\u038b\u038f\u0003x<"+
		"\u0000\u038c\u038f\u0003\u0086C\u0000\u038d\u038f\u0003\u0088D\u0000\u038e"+
		"\u038b\u0001\u0000\u0000\u0000\u038e\u038c\u0001\u0000\u0000\u0000\u038e"+
		"\u038d\u0001\u0000\u0000\u0000\u038fw\u0001\u0000\u0000\u0000\u0390\u0393"+
		"\u0003~?\u0000\u0391\u0393\u0003\u0084B\u0000\u0392\u0390\u0001\u0000"+
		"\u0000\u0000\u0392\u0391\u0001\u0000\u0000\u0000\u0393\u0398\u0001\u0000"+
		"\u0000\u0000\u0394\u0397\u0003|>\u0000\u0395\u0397\u0003\u0082A\u0000"+
		"\u0396\u0394\u0001\u0000\u0000\u0000\u0396\u0395\u0001\u0000\u0000\u0000"+
		"\u0397\u039a\u0001\u0000\u0000\u0000\u0398\u0396\u0001\u0000\u0000\u0000"+
		"\u0398\u0399\u0001\u0000\u0000\u0000\u0399y\u0001\u0000\u0000\u0000\u039a"+
		"\u0398\u0001\u0000\u0000\u0000\u039b\u039d\u0005f\u0000\u0000\u039c\u039e"+
		"\u0003(\u0014\u0000\u039d\u039c\u0001\u0000\u0000\u0000\u039d\u039e\u0001"+
		"\u0000\u0000\u0000\u039e\u03ac\u0001\u0000\u0000\u0000\u039f\u03a0\u0003"+
		"x<\u0000\u03a0\u03a4\u0005A\u0000\u0000\u03a1\u03a3\u0003\u00e4r\u0000"+
		"\u03a2\u03a1\u0001\u0000\u0000\u0000\u03a3\u03a6\u0001\u0000\u0000\u0000"+
		"\u03a4\u03a2\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000\u0000"+
		"\u03a5\u03a7\u0001\u0000\u0000\u0000\u03a6\u03a4\u0001\u0000\u0000\u0000"+
		"\u03a7\u03a9\u0005f\u0000\u0000\u03a8\u03aa\u0003(\u0014\u0000\u03a9\u03a8"+
		"\u0001\u0000\u0000\u0000\u03a9\u03aa\u0001\u0000\u0000\u0000\u03aa\u03ac"+
		"\u0001\u0000\u0000\u0000\u03ab\u039b\u0001\u0000\u0000\u0000\u03ab\u039f"+
		"\u0001\u0000\u0000\u0000\u03ac{\u0001\u0000\u0000\u0000\u03ad\u03b1\u0005"+
		"A\u0000\u0000\u03ae\u03b0\u0003\u00e4r\u0000\u03af\u03ae\u0001\u0000\u0000"+
		"\u0000\u03b0\u03b3\u0001\u0000\u0000\u0000\u03b1\u03af\u0001\u0000\u0000"+
		"\u0000\u03b1\u03b2\u0001\u0000\u0000\u0000\u03b2\u03b4\u0001\u0000\u0000"+
		"\u0000\u03b3\u03b1\u0001\u0000\u0000\u0000\u03b4\u03b6\u0005f\u0000\u0000"+
		"\u03b5\u03b7\u0003(\u0014\u0000\u03b6\u03b5\u0001\u0000\u0000\u0000\u03b6"+
		"\u03b7\u0001\u0000\u0000\u0000\u03b7}\u0001\u0000\u0000\u0000\u03b8\u03ba"+
		"\u0005f\u0000\u0000\u03b9\u03bb\u0003(\u0014\u0000\u03ba\u03b9\u0001\u0000"+
		"\u0000\u0000\u03ba\u03bb\u0001\u0000\u0000\u0000\u03bb\u007f\u0001\u0000"+
		"\u0000\u0000\u03bc\u03bd\u0003z=\u0000\u03bd\u0081\u0001\u0000\u0000\u0000"+
		"\u03be\u03bf\u0003|>\u0000\u03bf\u0083\u0001\u0000\u0000\u0000\u03c0\u03c1"+
		"\u0003~?\u0000\u03c1\u0085\u0001\u0000\u0000\u0000\u03c2\u03c3\u0005f"+
		"\u0000\u0000\u03c3\u0087\u0001\u0000\u0000\u0000\u03c4\u03c5\u0003t:\u0000"+
		"\u03c5\u03c6\u0003\u001e\u000f\u0000\u03c6\u03ce\u0001\u0000\u0000\u0000"+
		"\u03c7\u03c8\u0003x<\u0000\u03c8\u03c9\u0003\u001e\u000f\u0000\u03c9\u03ce"+
		"\u0001\u0000\u0000\u0000\u03ca\u03cb\u0003\u0086C\u0000\u03cb\u03cc\u0003"+
		"\u001e\u000f\u0000\u03cc\u03ce\u0001\u0000\u0000\u0000\u03cd\u03c4\u0001"+
		"\u0000\u0000\u0000\u03cd\u03c7\u0001\u0000\u0000\u0000\u03cd\u03ca\u0001"+
		"\u0000\u0000\u0000\u03ce\u0089\u0001\u0000\u0000\u0000\u03cf\u03d1\u0003"+
		"\u008cF\u0000\u03d0\u03cf\u0001\u0000\u0000\u0000\u03d1\u03d4\u0001\u0000"+
		"\u0000\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000"+
		"\u0000\u0000\u03d3\u03d5\u0001\u0000\u0000\u0000\u03d4\u03d2\u0001\u0000"+
		"\u0000\u0000\u03d5\u03d6\u0003\u008eG\u0000\u03d6\u03d7\u0003\u00a6S\u0000"+
		"\u03d7\u008b\u0001\u0000\u0000\u0000\u03d8\u03e3\u0003\u00e4r\u0000\u03d9"+
		"\u03e3\u0005#\u0000\u0000\u03da\u03e3\u0005\"\u0000\u0000\u03db\u03e3"+
		"\u0005!\u0000\u0000\u03dc\u03e3\u0005\u0001\u0000\u0000\u03dd\u03e3\u0005"+
		"&\u0000\u0000\u03de\u03e3\u0005\u0012\u0000\u0000\u03df\u03e3\u0005*\u0000"+
		"\u0000\u03e0\u03e3\u0005\u001e\u0000\u0000\u03e1\u03e3\u0005\'\u0000\u0000"+
		"\u03e2\u03d8\u0001\u0000\u0000\u0000\u03e2\u03d9\u0001\u0000\u0000\u0000"+
		"\u03e2\u03da\u0001\u0000\u0000\u0000\u03e2\u03db\u0001\u0000\u0000\u0000"+
		"\u03e2\u03dc\u0001\u0000\u0000\u0000\u03e2\u03dd\u0001\u0000\u0000\u0000"+
		"\u03e2\u03de\u0001\u0000\u0000\u0000\u03e2\u03df\u0001\u0000\u0000\u0000"+
		"\u03e2\u03e0\u0001\u0000\u0000\u0000\u03e2\u03e1\u0001\u0000\u0000\u0000"+
		"\u03e3\u008d\u0001\u0000\u0000\u0000\u03e4\u03e5\u0003\u0090H\u0000\u03e5"+
		"\u03e7\u0003\u0092I\u0000\u03e6\u03e8\u0003\u00a0P\u0000\u03e7\u03e6\u0001"+
		"\u0000\u0000\u0000\u03e7\u03e8\u0001\u0000\u0000\u0000\u03e8\u03f6\u0001"+
		"\u0000\u0000\u0000\u03e9\u03ed\u0003V+\u0000\u03ea\u03ec\u0003\u00e4r"+
		"\u0000\u03eb\u03ea\u0001\u0000\u0000\u0000\u03ec\u03ef\u0001\u0000\u0000"+
		"\u0000\u03ed\u03eb\u0001\u0000\u0000\u0000\u03ed\u03ee\u0001\u0000\u0000"+
		"\u0000\u03ee\u03f0\u0001\u0000\u0000\u0000\u03ef\u03ed\u0001\u0000\u0000"+
		"\u0000\u03f0\u03f1\u0003\u0090H\u0000\u03f1\u03f3\u0003\u0092I\u0000\u03f2"+
		"\u03f4\u0003\u00a0P\u0000\u03f3\u03f2\u0001\u0000\u0000\u0000\u03f3\u03f4"+
		"\u0001\u0000\u0000\u0000\u03f4\u03f6\u0001\u0000\u0000\u0000\u03f5\u03e4"+
		"\u0001\u0000\u0000\u0000\u03f5\u03e9\u0001\u0000\u0000\u0000\u03f6\u008f"+
		"\u0001\u0000\u0000\u0000\u03f7\u03fa\u0003r9\u0000\u03f8\u03fa\u00050"+
		"\u0000\u0000\u03f9\u03f7\u0001\u0000\u0000\u0000\u03f9\u03f8\u0001\u0000"+
		"\u0000\u0000\u03fa\u0091\u0001\u0000\u0000\u0000\u03fb\u03fc\u0005f\u0000"+
		"\u0000\u03fc\u03fe\u00059\u0000\u0000\u03fd\u03ff\u0003\u0094J\u0000\u03fe"+
		"\u03fd\u0001\u0000\u0000\u0000\u03fe\u03ff\u0001\u0000\u0000\u0000\u03ff"+
		"\u0400\u0001\u0000\u0000\u0000\u0400\u0402\u0005:\u0000\u0000\u0401\u0403"+
		"\u0003\u001e\u000f\u0000\u0402\u0401\u0001\u0000\u0000\u0000\u0402\u0403"+
		"\u0001\u0000\u0000\u0000\u0403\u0093\u0001\u0000\u0000\u0000\u0404\u040b"+
		"\u0003\u009eO\u0000\u0405\u0406\u0003\u0096K\u0000\u0406\u0407\u0005@"+
		"\u0000\u0000\u0407\u0408\u0003\u009cN\u0000\u0408\u040b\u0001\u0000\u0000"+
		"\u0000\u0409\u040b\u0003\u009cN\u0000\u040a\u0404\u0001\u0000\u0000\u0000"+
		"\u040a\u0405\u0001\u0000\u0000\u0000\u040a\u0409\u0001\u0000\u0000\u0000"+
		"\u040b\u0095\u0001\u0000\u0000\u0000\u040c\u0411\u0003\u0098L\u0000\u040d"+
		"\u040e\u0005@\u0000\u0000\u040e\u0410\u0003\u0098L\u0000\u040f\u040d\u0001"+
		"\u0000\u0000\u0000\u0410\u0413\u0001\u0000\u0000\u0000\u0411\u040f\u0001"+
		"\u0000\u0000\u0000\u0411\u0412\u0001\u0000\u0000\u0000\u0412\u041d\u0001"+
		"\u0000\u0000\u0000\u0413\u0411\u0001\u0000\u0000\u0000\u0414\u0419\u0003"+
		"\u009eO\u0000\u0415\u0416\u0005@\u0000\u0000\u0416\u0418\u0003\u0098L"+
		"\u0000\u0417\u0415\u0001\u0000\u0000\u0000\u0418\u041b\u0001\u0000\u0000"+
		"\u0000\u0419\u0417\u0001\u0000\u0000\u0000\u0419\u041a\u0001\u0000\u0000"+
		"\u0000\u041a\u041d\u0001\u0000\u0000\u0000\u041b\u0419\u0001\u0000\u0000"+
		"\u0000\u041c\u040c\u0001\u0000\u0000\u0000\u041c\u0414\u0001\u0000\u0000"+
		"\u0000\u041d\u0097\u0001\u0000\u0000\u0000\u041e\u0420\u0003\u009aM\u0000"+
		"\u041f\u041e\u0001\u0000\u0000\u0000\u0420\u0423\u0001\u0000\u0000\u0000"+
		"\u0421\u041f\u0001\u0000\u0000\u0000\u0421\u0422\u0001\u0000\u0000\u0000"+
		"\u0422\u0424\u0001\u0000\u0000\u0000\u0423\u0421\u0001\u0000\u0000\u0000"+
		"\u0424\u0425\u0003r9\u0000\u0425\u0426\u0003n7\u0000\u0426\u0099\u0001"+
		"\u0000\u0000\u0000\u0427\u042a\u0003\u00e4r\u0000\u0428\u042a\u0005\u0012"+
		"\u0000\u0000\u0429\u0427\u0001\u0000\u0000\u0000\u0429\u0428\u0001\u0000"+
		"\u0000\u0000\u042a\u009b\u0001\u0000\u0000\u0000\u042b\u042d\u0003\u009a"+
		"M\u0000\u042c\u042b\u0001\u0000\u0000\u0000\u042d\u0430\u0001\u0000\u0000"+
		"\u0000\u042e\u042c\u0001\u0000\u0000\u0000\u042e\u042f\u0001\u0000\u0000"+
		"\u0000\u042f\u0431\u0001\u0000\u0000\u0000\u0430\u042e\u0001\u0000\u0000"+
		"\u0000\u0431\u0435\u0003r9\u0000\u0432\u0434\u0003\u00e4r\u0000\u0433"+
		"\u0432\u0001\u0000\u0000\u0000\u0434\u0437\u0001\u0000\u0000\u0000\u0435"+
		"\u0433\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000\u0000\u0000\u0436"+
		"\u0438\u0001\u0000\u0000\u0000\u0437\u0435\u0001\u0000\u0000\u0000\u0438"+
		"\u0439\u0005h\u0000\u0000\u0439\u043a\u0003n7\u0000\u043a\u043d\u0001"+
		"\u0000\u0000\u0000\u043b\u043d\u0003\u0098L\u0000\u043c\u042e\u0001\u0000"+
		"\u0000\u0000\u043c\u043b\u0001\u0000\u0000\u0000\u043d\u009d\u0001\u0000"+
		"\u0000\u0000\u043e\u0440\u0003\u00e4r\u0000\u043f\u043e\u0001\u0000\u0000"+
		"\u0000\u0440\u0443\u0001\u0000\u0000\u0000\u0441\u043f\u0001\u0000\u0000"+
		"\u0000\u0441\u0442\u0001\u0000\u0000\u0000\u0442\u0444\u0001\u0000\u0000"+
		"\u0000\u0443\u0441\u0001\u0000\u0000\u0000\u0444\u0447\u0003r9\u0000\u0445"+
		"\u0446\u0005f\u0000\u0000\u0446\u0448\u0005A\u0000\u0000\u0447\u0445\u0001"+
		"\u0000\u0000\u0000\u0447\u0448\u0001\u0000\u0000\u0000\u0448\u0449\u0001"+
		"\u0000\u0000\u0000\u0449\u044a\u0005+\u0000\u0000\u044a\u009f\u0001\u0000"+
		"\u0000\u0000\u044b\u044c\u0005-\u0000\u0000\u044c\u044d\u0003\u00a2Q\u0000"+
		"\u044d\u00a1\u0001\u0000\u0000\u0000\u044e\u0453\u0003\u00a4R\u0000\u044f"+
		"\u0450\u0005@\u0000\u0000\u0450\u0452\u0003\u00a4R\u0000\u0451\u044f\u0001"+
		"\u0000\u0000\u0000\u0452\u0455\u0001\u0000\u0000\u0000\u0453\u0451\u0001"+
		"\u0000\u0000\u0000\u0453\u0454\u0001\u0000\u0000\u0000\u0454\u00a3\u0001"+
		"\u0000\u0000\u0000\u0455\u0453\u0001\u0000\u0000\u0000\u0456\u0459\u0003"+
		"\u000e\u0007\u0000\u0457\u0459\u0003\u001a\r\u0000\u0458\u0456\u0001\u0000"+
		"\u0000\u0000\u0458\u0457\u0001\u0000\u0000\u0000\u0459\u00a5\u0001\u0000"+
		"\u0000\u0000\u045a\u045d\u0003\u00fa}\u0000\u045b\u045d\u0005?\u0000\u0000"+
		"\u045c\u045a\u0001\u0000\u0000\u0000\u045c\u045b\u0001\u0000\u0000\u0000"+
		"\u045d\u00a7\u0001\u0000\u0000\u0000\u045e\u045f\u0003\u00fa}\u0000\u045f"+
		"\u00a9\u0001\u0000\u0000\u0000\u0460\u0461\u0005&\u0000\u0000\u0461\u0462"+
		"\u0003\u00fa}\u0000\u0462\u00ab\u0001\u0000\u0000\u0000\u0463\u0465\u0003"+
		"\u00aeW\u0000\u0464\u0463\u0001\u0000\u0000\u0000\u0465\u0468\u0001\u0000"+
		"\u0000\u0000\u0466\u0464\u0001\u0000\u0000\u0000\u0466\u0467\u0001\u0000"+
		"\u0000\u0000\u0467\u0469\u0001\u0000\u0000\u0000\u0468\u0466\u0001\u0000"+
		"\u0000\u0000\u0469\u046b\u0003\u00b0X\u0000\u046a\u046c\u0003\u00a0P\u0000"+
		"\u046b\u046a\u0001\u0000\u0000\u0000\u046b\u046c\u0001\u0000\u0000\u0000"+
		"\u046c\u046d\u0001\u0000\u0000\u0000\u046d\u046e\u0003\u00b4Z\u0000\u046e"+
		"\u00ad\u0001\u0000\u0000\u0000\u046f\u0474\u0003\u00e4r\u0000\u0470\u0474"+
		"\u0005#\u0000\u0000\u0471\u0474\u0005\"\u0000\u0000\u0472\u0474\u0005"+
		"!\u0000\u0000\u0473\u046f\u0001\u0000\u0000\u0000\u0473\u0470\u0001\u0000"+
		"\u0000\u0000\u0473\u0471\u0001\u0000\u0000\u0000\u0473\u0472\u0001\u0000"+
		"\u0000\u0000\u0474\u00af\u0001\u0000\u0000\u0000\u0475\u0477\u0003V+\u0000"+
		"\u0476\u0475\u0001\u0000\u0000\u0000\u0476\u0477\u0001\u0000\u0000\u0000"+
		"\u0477\u0478\u0001\u0000\u0000\u0000\u0478\u0479\u0003\u00b2Y\u0000\u0479"+
		"\u047b\u00059\u0000\u0000\u047a\u047c\u0003\u0094J\u0000\u047b\u047a\u0001"+
		"\u0000\u0000\u0000\u047b\u047c\u0001\u0000\u0000\u0000\u047c\u047d\u0001"+
		"\u0000\u0000\u0000\u047d\u047e\u0005:\u0000\u0000\u047e\u00b1\u0001\u0000"+
		"\u0000\u0000\u047f\u0480\u0005f\u0000\u0000\u0480\u00b3\u0001\u0000\u0000"+
		"\u0000\u0481\u0483\u0005;\u0000\u0000\u0482\u0484\u0003\u00b6[\u0000\u0483"+
		"\u0482\u0001\u0000\u0000\u0000\u0483\u0484\u0001\u0000\u0000\u0000\u0484"+
		"\u0486\u0001\u0000\u0000\u0000\u0485\u0487\u0003\u00fc~\u0000\u0486\u0485"+
		"\u0001\u0000\u0000\u0000\u0486\u0487\u0001\u0000\u0000\u0000\u0487\u0488"+
		"\u0001\u0000\u0000\u0000\u0488\u0489\u0005<\u0000\u0000\u0489\u00b5\u0001"+
		"\u0000\u0000\u0000\u048a\u048c\u0003(\u0014\u0000\u048b\u048a\u0001\u0000"+
		"\u0000\u0000\u048b\u048c\u0001\u0000\u0000\u0000\u048c\u048d\u0001\u0000"+
		"\u0000\u0000\u048d\u048e\u0005+\u0000\u0000\u048e\u0490\u00059\u0000\u0000"+
		"\u048f\u0491\u0003\u018c\u00c6\u0000\u0490\u048f\u0001\u0000\u0000\u0000"+
		"\u0490\u0491\u0001\u0000\u0000\u0000\u0491\u0492\u0001\u0000\u0000\u0000"+
		"\u0492\u0493\u0005:\u0000\u0000\u0493\u04b9\u0005?\u0000\u0000\u0494\u0496"+
		"\u0003(\u0014\u0000\u0495\u0494\u0001\u0000\u0000\u0000\u0495\u0496\u0001"+
		"\u0000\u0000\u0000\u0496\u0497\u0001\u0000\u0000\u0000\u0497\u0498\u0005"+
		"(\u0000\u0000\u0498\u049a\u00059\u0000\u0000\u0499\u049b\u0003\u018c\u00c6"+
		"\u0000\u049a\u0499\u0001\u0000\u0000\u0000\u049a\u049b\u0001\u0000\u0000"+
		"\u0000\u049b\u049c\u0001\u0000\u0000\u0000\u049c\u049d\u0005:\u0000\u0000"+
		"\u049d\u04b9\u0005?\u0000\u0000\u049e\u049f\u00038\u001c\u0000\u049f\u04a1"+
		"\u0005A\u0000\u0000\u04a0\u04a2\u0003(\u0014\u0000\u04a1\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a1\u04a2\u0001\u0000\u0000\u0000\u04a2\u04a3\u0001\u0000"+
		"\u0000\u0000\u04a3\u04a4\u0005(\u0000\u0000\u04a4\u04a6\u00059\u0000\u0000"+
		"\u04a5\u04a7\u0003\u018c\u00c6\u0000\u04a6\u04a5\u0001\u0000\u0000\u0000"+
		"\u04a6\u04a7\u0001\u0000\u0000\u0000\u04a7\u04a8\u0001\u0000\u0000\u0000"+
		"\u04a8\u04a9\u0005:\u0000\u0000\u04a9\u04aa\u0005?\u0000\u0000\u04aa\u04b9"+
		"\u0001\u0000\u0000\u0000\u04ab\u04ac\u0003\u015e\u00af\u0000\u04ac\u04ae"+
		"\u0005A\u0000\u0000\u04ad\u04af\u0003(\u0014\u0000\u04ae\u04ad\u0001\u0000"+
		"\u0000\u0000\u04ae\u04af\u0001\u0000\u0000\u0000\u04af\u04b0\u0001\u0000"+
		"\u0000\u0000\u04b0\u04b1\u0005(\u0000\u0000\u04b1\u04b3\u00059\u0000\u0000"+
		"\u04b2\u04b4\u0003\u018c\u00c6\u0000\u04b3\u04b2\u0001\u0000\u0000\u0000"+
		"\u04b3\u04b4\u0001\u0000\u0000\u0000\u04b4\u04b5\u0001\u0000\u0000\u0000"+
		"\u04b5\u04b6\u0005:\u0000\u0000\u04b6\u04b7\u0005?\u0000\u0000\u04b7\u04b9"+
		"\u0001\u0000\u0000\u0000\u04b8\u048b\u0001\u0000\u0000\u0000\u04b8\u0495"+
		"\u0001\u0000\u0000\u0000\u04b8\u049e\u0001\u0000\u0000\u0000\u04b8\u04ab"+
		"\u0001\u0000\u0000\u0000\u04b9\u00b7\u0001\u0000\u0000\u0000\u04ba\u04bc"+
		"\u0003T*\u0000\u04bb\u04ba\u0001\u0000\u0000\u0000\u04bc\u04bf\u0001\u0000"+
		"\u0000\u0000\u04bd\u04bb\u0001\u0000\u0000\u0000\u04bd\u04be\u0001\u0000"+
		"\u0000\u0000\u04be\u04c0\u0001\u0000\u0000\u0000\u04bf\u04bd\u0001\u0000"+
		"\u0000\u0000\u04c0\u04c1\u0005\u0010\u0000\u0000\u04c1\u04c3\u0005f\u0000"+
		"\u0000\u04c2\u04c4\u0003\\.\u0000\u04c3\u04c2\u0001\u0000\u0000\u0000"+
		"\u04c3\u04c4\u0001\u0000\u0000\u0000\u04c4\u04c5\u0001\u0000\u0000\u0000"+
		"\u04c5\u04c6\u0003\u00ba]\u0000\u04c6\u00b9\u0001\u0000\u0000\u0000\u04c7"+
		"\u04c9\u0005;\u0000\u0000\u04c8\u04ca\u0003\u00bc^\u0000\u04c9\u04c8\u0001"+
		"\u0000\u0000\u0000\u04c9\u04ca\u0001\u0000\u0000\u0000\u04ca\u04cc\u0001"+
		"\u0000\u0000\u0000\u04cb\u04cd\u0005@\u0000\u0000\u04cc\u04cb\u0001\u0000"+
		"\u0000\u0000\u04cc\u04cd\u0001\u0000\u0000\u0000\u04cd\u04cf\u0001\u0000"+
		"\u0000\u0000\u04ce\u04d0\u0003\u00c2a\u0000\u04cf\u04ce\u0001\u0000\u0000"+
		"\u0000\u04cf\u04d0\u0001\u0000\u0000\u0000\u04d0\u04d1\u0001\u0000\u0000"+
		"\u0000\u04d1\u04d2\u0005<\u0000\u0000\u04d2\u00bb\u0001\u0000\u0000\u0000"+
		"\u04d3\u04d8\u0003\u00be_\u0000\u04d4\u04d5\u0005@\u0000\u0000\u04d5\u04d7"+
		"\u0003\u00be_\u0000\u04d6\u04d4\u0001\u0000\u0000\u0000\u04d7\u04da\u0001"+
		"\u0000\u0000\u0000\u04d8\u04d6\u0001\u0000\u0000\u0000\u04d8\u04d9\u0001"+
		"\u0000\u0000\u0000\u04d9\u00bd\u0001\u0000\u0000\u0000\u04da\u04d8\u0001"+
		"\u0000\u0000\u0000\u04db\u04dd\u0003\u00c0`\u0000\u04dc\u04db\u0001\u0000"+
		"\u0000\u0000\u04dd\u04e0\u0001\u0000\u0000\u0000\u04de\u04dc\u0001\u0000"+
		"\u0000\u0000\u04de\u04df\u0001\u0000\u0000\u0000\u04df\u04e1\u0001\u0000"+
		"\u0000\u0000\u04e0\u04de\u0001\u0000\u0000\u0000\u04e1\u04e7\u0005f\u0000"+
		"\u0000\u04e2\u04e4\u00059\u0000\u0000\u04e3\u04e5\u0003\u018c\u00c6\u0000"+
		"\u04e4\u04e3\u0001\u0000\u0000\u0000\u04e4\u04e5\u0001\u0000\u0000\u0000"+
		"\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6\u04e8\u0005:\u0000\u0000\u04e7"+
		"\u04e2\u0001\u0000\u0000\u0000\u04e7\u04e8\u0001\u0000\u0000\u0000\u04e8"+
		"\u04ea\u0001\u0000\u0000\u0000\u04e9\u04eb\u0003`0\u0000\u04ea\u04e9\u0001"+
		"\u0000\u0000\u0000\u04ea\u04eb\u0001\u0000\u0000\u0000\u04eb\u00bf\u0001"+
		"\u0000\u0000\u0000\u04ec\u04ed\u0003\u00e4r\u0000\u04ed\u00c1\u0001\u0000"+
		"\u0000\u0000\u04ee\u04f2\u0005?\u0000\u0000\u04ef\u04f1\u0003b1\u0000"+
		"\u04f0\u04ef\u0001\u0000\u0000\u0000\u04f1\u04f4\u0001\u0000\u0000\u0000"+
		"\u04f2\u04f0\u0001\u0000\u0000\u0000\u04f2\u04f3\u0001\u0000\u0000\u0000"+
		"\u04f3\u00c3\u0001\u0000\u0000\u0000\u04f4\u04f2\u0001\u0000\u0000\u0000"+
		"\u04f5\u04f8\u0003\u00c6c\u0000\u04f6\u04f8\u0003\u00d8l\u0000\u04f7\u04f5"+
		"\u0001\u0000\u0000\u0000\u04f7\u04f6\u0001\u0000\u0000\u0000\u04f8\u00c5"+
		"\u0001\u0000\u0000\u0000\u04f9\u04fb\u0003\u00c8d\u0000\u04fa\u04f9\u0001"+
		"\u0000\u0000\u0000\u04fb\u04fe\u0001\u0000\u0000\u0000\u04fc\u04fa\u0001"+
		"\u0000\u0000\u0000\u04fc\u04fd\u0001\u0000\u0000\u0000\u04fd\u04ff\u0001"+
		"\u0000\u0000\u0000\u04fe\u04fc\u0001\u0000\u0000\u0000\u04ff\u0500\u0005"+
		"\u001c\u0000\u0000\u0500\u0502\u0005f\u0000\u0000\u0501\u0503\u0003V+"+
		"\u0000\u0502\u0501\u0001\u0000\u0000\u0000\u0502\u0503\u0001\u0000\u0000"+
		"\u0000\u0503\u0505\u0001\u0000\u0000\u0000\u0504\u0506\u0003\u00cae\u0000"+
		"\u0505\u0504\u0001\u0000\u0000\u0000\u0505\u0506\u0001\u0000\u0000\u0000"+
		"\u0506\u0507\u0001\u0000\u0000\u0000\u0507\u0508\u0003\u00ccf\u0000\u0508"+
		"\u00c7\u0001\u0000\u0000\u0000\u0509\u0511\u0003\u00e4r\u0000\u050a\u0511"+
		"\u0005#\u0000\u0000\u050b\u0511\u0005\"\u0000\u0000\u050c\u0511\u0005"+
		"!\u0000\u0000\u050d\u0511\u0005\u0001\u0000\u0000\u050e\u0511\u0005&\u0000"+
		"\u0000\u050f\u0511\u0005\'\u0000\u0000\u0510\u0509\u0001\u0000\u0000\u0000"+
		"\u0510\u050a\u0001\u0000\u0000\u0000\u0510\u050b\u0001\u0000\u0000\u0000"+
		"\u0510\u050c\u0001\u0000\u0000\u0000\u0510\u050d\u0001\u0000\u0000\u0000"+
		"\u0510\u050e\u0001\u0000\u0000\u0000\u0510\u050f\u0001\u0000\u0000\u0000"+
		"\u0511\u00c9\u0001\u0000\u0000\u0000\u0512\u0513\u0005\u0011\u0000\u0000"+
		"\u0513\u0514\u0003^/\u0000\u0514\u00cb\u0001\u0000\u0000\u0000\u0515\u0519"+
		"\u0005;\u0000\u0000\u0516\u0518\u0003\u00ceg\u0000\u0517\u0516\u0001\u0000"+
		"\u0000\u0000\u0518\u051b\u0001\u0000\u0000\u0000\u0519\u0517\u0001\u0000"+
		"\u0000\u0000\u0519\u051a\u0001\u0000\u0000\u0000\u051a\u051c\u0001\u0000"+
		"\u0000\u0000\u051b\u0519\u0001\u0000\u0000\u0000\u051c\u051d\u0005<\u0000"+
		"\u0000\u051d\u00cd\u0001\u0000\u0000\u0000\u051e\u0524\u0003\u00d0h\u0000"+
		"\u051f\u0524\u0003\u00d4j\u0000\u0520\u0524\u0003P(\u0000\u0521\u0524"+
		"\u0003\u00c4b\u0000\u0522\u0524\u0005?\u0000\u0000\u0523\u051e\u0001\u0000"+
		"\u0000\u0000\u0523\u051f\u0001\u0000\u0000\u0000\u0523\u0520\u0001\u0000"+
		"\u0000\u0000\u0523\u0521\u0001\u0000\u0000\u0000\u0523\u0522\u0001\u0000"+
		"\u0000\u0000\u0524\u00cf\u0001\u0000\u0000\u0000\u0525\u0527\u0003\u00d2"+
		"i\u0000\u0526\u0525\u0001\u0000\u0000\u0000\u0527\u052a\u0001\u0000\u0000"+
		"\u0000\u0528\u0526\u0001\u0000\u0000\u0000\u0528\u0529\u0001\u0000\u0000"+
		"\u0000\u0529\u052b\u0001\u0000\u0000\u0000\u052a\u0528\u0001\u0000\u0000"+
		"\u0000\u052b\u052c\u0003r9\u0000\u052c\u052d\u0003j5\u0000\u052d\u052e"+
		"\u0005?\u0000\u0000\u052e\u00d1\u0001\u0000\u0000\u0000\u052f\u0534\u0003"+
		"\u00e4r\u0000\u0530\u0534\u0005#\u0000\u0000\u0531\u0534\u0005&\u0000"+
		"\u0000\u0532\u0534\u0005\u0012\u0000\u0000\u0533\u052f\u0001\u0000\u0000"+
		"\u0000\u0533\u0530\u0001\u0000\u0000\u0000\u0533\u0531\u0001\u0000\u0000"+
		"\u0000\u0533\u0532\u0001\u0000\u0000\u0000\u0534\u00d3\u0001\u0000\u0000"+
		"\u0000\u0535\u0537\u0003\u00d6k\u0000\u0536\u0535\u0001\u0000\u0000\u0000"+
		"\u0537\u053a\u0001\u0000\u0000\u0000\u0538\u0536\u0001\u0000\u0000\u0000"+
		"\u0538\u0539\u0001\u0000\u0000\u0000\u0539\u053b\u0001\u0000\u0000\u0000"+
		"\u053a\u0538\u0001\u0000\u0000\u0000\u053b\u053c\u0003\u008eG\u0000\u053c"+
		"\u053d\u0003\u00a6S\u0000\u053d\u00d5\u0001\u0000\u0000\u0000\u053e\u0545"+
		"\u0003\u00e4r\u0000\u053f\u0545\u0005#\u0000\u0000\u0540\u0545\u0005\u0001"+
		"\u0000\u0000\u0541\u0545\u0005\f\u0000\u0000\u0542\u0545\u0005&\u0000"+
		"\u0000\u0543\u0545\u0005\'\u0000\u0000\u0544\u053e\u0001\u0000\u0000\u0000"+
		"\u0544\u053f\u0001\u0000\u0000\u0000\u0544\u0540\u0001\u0000\u0000\u0000"+
		"\u0544\u0541\u0001\u0000\u0000\u0000\u0544\u0542\u0001\u0000\u0000\u0000"+
		"\u0544\u0543\u0001\u0000\u0000\u0000\u0545\u00d7\u0001\u0000\u0000\u0000"+
		"\u0546\u0548\u0003\u00c8d\u0000\u0547\u0546\u0001\u0000\u0000\u0000\u0548"+
		"\u054b\u0001\u0000\u0000\u0000\u0549\u0547\u0001\u0000\u0000\u0000\u0549"+
		"\u054a\u0001\u0000\u0000\u0000\u054a\u054c\u0001\u0000\u0000\u0000\u054b"+
		"\u0549\u0001\u0000\u0000\u0000\u054c\u054d\u0005g\u0000\u0000\u054d\u054e"+
		"\u0005\u001c\u0000\u0000\u054e\u054f\u0005f\u0000\u0000\u054f\u0550\u0003"+
		"\u00dam\u0000\u0550\u00d9\u0001\u0000\u0000\u0000\u0551\u0555\u0005;\u0000"+
		"\u0000\u0552\u0554\u0003\u00dcn\u0000\u0553\u0552\u0001\u0000\u0000\u0000"+
		"\u0554\u0557\u0001\u0000\u0000\u0000\u0555\u0553\u0001\u0000\u0000\u0000"+
		"\u0555\u0556\u0001\u0000\u0000\u0000\u0556\u0558\u0001\u0000\u0000\u0000"+
		"\u0557\u0555\u0001\u0000\u0000\u0000\u0558\u0559\u0005<\u0000\u0000\u0559"+
		"\u00db\u0001\u0000\u0000\u0000\u055a\u0560\u0003\u00deo\u0000\u055b\u0560"+
		"\u0003\u00d0h\u0000\u055c\u0560\u0003P(\u0000\u055d\u0560\u0003\u00c4"+
		"b\u0000\u055e\u0560\u0005?\u0000\u0000\u055f\u055a\u0001\u0000\u0000\u0000"+
		"\u055f\u055b\u0001\u0000\u0000\u0000\u055f\u055c\u0001\u0000\u0000\u0000"+
		"\u055f\u055d\u0001\u0000\u0000\u0000\u055f\u055e\u0001\u0000\u0000\u0000"+
		"\u0560\u00dd\u0001\u0000\u0000\u0000\u0561\u0563\u0003\u00e0p\u0000\u0562"+
		"\u0561\u0001\u0000\u0000\u0000\u0563\u0566\u0001\u0000\u0000\u0000\u0564"+
		"\u0562\u0001\u0000\u0000\u0000\u0564\u0565\u0001\u0000\u0000\u0000\u0565"+
		"\u0567\u0001\u0000\u0000\u0000\u0566\u0564\u0001\u0000\u0000\u0000\u0567"+
		"\u0568\u0003r9\u0000\u0568\u0569\u0005f\u0000\u0000\u0569\u056a\u0005"+
		"9\u0000\u0000\u056a\u056c\u0005:\u0000\u0000\u056b\u056d\u0003\u001e\u000f"+
		"\u0000\u056c\u056b\u0001\u0000\u0000\u0000\u056c\u056d\u0001\u0000\u0000"+
		"\u0000\u056d\u056f\u0001\u0000\u0000\u0000\u056e\u0570\u0003\u00e2q\u0000"+
		"\u056f\u056e\u0001\u0000\u0000\u0000\u056f\u0570\u0001\u0000\u0000\u0000"+
		"\u0570\u0571\u0001\u0000\u0000\u0000\u0571\u0572\u0005?\u0000\u0000\u0572"+
		"\u00df\u0001\u0000\u0000\u0000\u0573\u0577\u0003\u00e4r\u0000\u0574\u0577"+
		"\u0005#\u0000\u0000\u0575\u0577\u0005\u0001\u0000\u0000\u0576\u0573\u0001"+
		"\u0000\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0576\u0575\u0001"+
		"\u0000\u0000\u0000\u0577\u00e1\u0001\u0000\u0000\u0000\u0578\u0579\u0005"+
		"\f\u0000\u0000\u0579\u057a\u0003\u00ecv\u0000\u057a\u00e3\u0001\u0000"+
		"\u0000\u0000\u057b\u057f\u0003\u00e6s\u0000\u057c\u057f\u0003\u00f2y\u0000"+
		"\u057d\u057f\u0003\u00f4z\u0000\u057e\u057b\u0001\u0000\u0000\u0000\u057e"+
		"\u057c\u0001\u0000\u0000\u0000\u057e\u057d\u0001\u0000\u0000\u0000\u057f"+
		"\u00e5\u0001\u0000\u0000\u0000\u0580\u0581\u0005g\u0000\u0000\u0581\u0582"+
		"\u00034\u001a\u0000\u0582\u0584\u00059\u0000\u0000\u0583\u0585\u0003\u00e8"+
		"t\u0000\u0584\u0583\u0001\u0000\u0000\u0000\u0584\u0585\u0001\u0000\u0000"+
		"\u0000\u0585\u0586\u0001\u0000\u0000\u0000\u0586\u0587\u0005:\u0000\u0000"+
		"\u0587\u00e7\u0001\u0000\u0000\u0000\u0588\u058d\u0003\u00eau\u0000\u0589"+
		"\u058a\u0005@\u0000\u0000\u058a\u058c\u0003\u00eau\u0000\u058b\u0589\u0001"+
		"\u0000\u0000\u0000\u058c\u058f\u0001\u0000\u0000\u0000\u058d\u058b\u0001"+
		"\u0000\u0000\u0000\u058d\u058e\u0001\u0000\u0000\u0000\u058e\u00e9\u0001"+
		"\u0000\u0000\u0000\u058f\u058d\u0001\u0000\u0000\u0000\u0590\u0591\u0005"+
		"f\u0000\u0000\u0591\u0592\u0005B\u0000\u0000\u0592\u0593\u0003\u00ecv"+
		"\u0000\u0593\u00eb\u0001\u0000\u0000\u0000\u0594\u0598\u0003\u01ae\u00d7"+
		"\u0000\u0595\u0598\u0003\u00eew\u0000\u0596\u0598\u0003\u00e4r\u0000\u0597"+
		"\u0594\u0001\u0000\u0000\u0000\u0597\u0595\u0001\u0000\u0000\u0000\u0597"+
		"\u0596\u0001\u0000\u0000\u0000\u0598\u00ed\u0001\u0000\u0000\u0000\u0599"+
		"\u059b\u0005;\u0000\u0000\u059a\u059c\u0003\u00f0x\u0000\u059b\u059a\u0001"+
		"\u0000\u0000\u0000\u059b\u059c\u0001\u0000\u0000\u0000\u059c\u059e\u0001"+
		"\u0000\u0000\u0000\u059d\u059f\u0005@\u0000\u0000\u059e\u059d\u0001\u0000"+
		"\u0000\u0000\u059e\u059f\u0001\u0000\u0000\u0000\u059f\u05a0\u0001\u0000"+
		"\u0000\u0000\u05a0\u05a1\u0005<\u0000\u0000\u05a1\u00ef\u0001\u0000\u0000"+
		"\u0000\u05a2\u05a7\u0003\u00ecv\u0000\u05a3\u05a4\u0005@\u0000\u0000\u05a4"+
		"\u05a6\u0003\u00ecv\u0000\u05a5\u05a3\u0001\u0000\u0000\u0000\u05a6\u05a9"+
		"\u0001\u0000\u0000\u0000\u05a7\u05a5\u0001\u0000\u0000\u0000\u05a7\u05a8"+
		"\u0001\u0000\u0000\u0000\u05a8\u00f1\u0001\u0000\u0000\u0000\u05a9\u05a7"+
		"\u0001\u0000\u0000\u0000\u05aa\u05ab\u0005g\u0000\u0000\u05ab\u05ac\u0003"+
		"4\u001a\u0000\u05ac\u00f3\u0001\u0000\u0000\u0000\u05ad\u05ae\u0005g\u0000"+
		"\u0000\u05ae\u05af\u00034\u001a\u0000\u05af\u05b0\u00059\u0000\u0000\u05b0"+
		"\u05b1\u0003\u00ecv\u0000\u05b1\u05b2\u0005:\u0000\u0000\u05b2\u00f5\u0001"+
		"\u0000\u0000\u0000\u05b3\u05b5\u0005;\u0000\u0000\u05b4\u05b6\u0003\u00f8"+
		"|\u0000\u05b5\u05b4\u0001\u0000\u0000\u0000\u05b5\u05b6\u0001\u0000\u0000"+
		"\u0000\u05b6\u05b8\u0001\u0000\u0000\u0000\u05b7\u05b9\u0005@\u0000\u0000"+
		"\u05b8\u05b7\u0001\u0000\u0000\u0000\u05b8\u05b9\u0001\u0000\u0000\u0000"+
		"\u05b9\u05ba\u0001\u0000\u0000\u0000\u05ba\u05bb\u0005<\u0000\u0000\u05bb"+
		"\u00f7\u0001\u0000\u0000\u0000\u05bc\u05c1\u0003p8\u0000\u05bd\u05be\u0005"+
		"@\u0000\u0000\u05be\u05c0\u0003p8\u0000\u05bf\u05bd\u0001\u0000\u0000"+
		"\u0000\u05c0\u05c3\u0001\u0000\u0000\u0000\u05c1\u05bf\u0001\u0000\u0000"+
		"\u0000\u05c1\u05c2\u0001\u0000\u0000\u0000\u05c2\u00f9\u0001\u0000\u0000"+
		"\u0000\u05c3\u05c1\u0001\u0000\u0000\u0000\u05c4\u05c6\u0005;\u0000\u0000"+
		"\u05c5\u05c7\u0003\u00fc~\u0000\u05c6\u05c5\u0001\u0000\u0000\u0000\u05c6"+
		"\u05c7\u0001\u0000\u0000\u0000\u05c7\u05c8\u0001\u0000\u0000\u0000\u05c8"+
		"\u05c9\u0005<\u0000\u0000\u05c9\u00fb\u0001\u0000\u0000\u0000\u05ca\u05cc"+
		"\u0003\u00fe\u007f\u0000\u05cb\u05ca\u0001\u0000\u0000\u0000\u05cc\u05cd"+
		"\u0001\u0000\u0000\u0000\u05cd\u05cb\u0001\u0000\u0000\u0000\u05cd\u05ce"+
		"\u0001\u0000\u0000\u0000\u05ce\u00fd\u0001\u0000\u0000\u0000\u05cf\u05d3"+
		"\u0003\u0100\u0080\u0000\u05d0\u05d3\u0003P(\u0000\u05d1\u05d3\u0003\u0104"+
		"\u0082\u0000\u05d2\u05cf\u0001\u0000\u0000\u0000\u05d2\u05d0\u0001\u0000"+
		"\u0000\u0000\u05d2\u05d1\u0001\u0000\u0000\u0000\u05d3\u00ff\u0001\u0000"+
		"\u0000\u0000\u05d4\u05d5\u0003\u0102\u0081\u0000\u05d5\u05d6\u0005?\u0000"+
		"\u0000\u05d6\u0101\u0001\u0000\u0000\u0000\u05d7\u05d9\u0003\u009aM\u0000"+
		"\u05d8\u05d7\u0001\u0000\u0000\u0000\u05d9\u05dc\u0001\u0000\u0000\u0000"+
		"\u05da\u05d8\u0001\u0000\u0000\u0000\u05da\u05db\u0001\u0000\u0000\u0000"+
		"\u05db\u05dd\u0001\u0000\u0000\u0000\u05dc\u05da\u0001\u0000\u0000\u0000"+
		"\u05dd\u05de\u0003r9\u0000\u05de\u05df\u0003j5\u0000\u05df\u0103\u0001"+
		"\u0000\u0000\u0000\u05e0\u05e7\u0003\u0108\u0084\u0000\u05e1\u05e7\u0003"+
		"\u010c\u0086\u0000\u05e2\u05e7\u0003\u0114\u008a\u0000\u05e3\u05e7\u0003"+
		"\u0116\u008b\u0000\u05e4\u05e7\u0003\u0128\u0094\u0000\u05e5\u05e7\u0003"+
		"\u012e\u0097\u0000\u05e6\u05e0\u0001\u0000\u0000\u0000\u05e6\u05e1\u0001"+
		"\u0000\u0000\u0000\u05e6\u05e2\u0001\u0000\u0000\u0000\u05e6\u05e3\u0001"+
		"\u0000\u0000\u0000\u05e6\u05e4\u0001\u0000\u0000\u0000\u05e6\u05e5\u0001"+
		"\u0000\u0000\u0000\u05e7\u0105\u0001\u0000\u0000\u0000\u05e8\u05ee\u0003"+
		"\u0108\u0084\u0000\u05e9\u05ee\u0003\u010e\u0087\u0000\u05ea\u05ee\u0003"+
		"\u0118\u008c\u0000\u05eb\u05ee\u0003\u012a\u0095\u0000\u05ec\u05ee\u0003"+
		"\u0130\u0098\u0000\u05ed\u05e8\u0001\u0000\u0000\u0000\u05ed\u05e9\u0001"+
		"\u0000\u0000\u0000\u05ed\u05ea\u0001\u0000\u0000\u0000\u05ed\u05eb\u0001"+
		"\u0000\u0000\u0000\u05ed\u05ec\u0001\u0000\u0000\u0000\u05ee\u0107\u0001"+
		"\u0000\u0000\u0000\u05ef\u05fc\u0003\u00fa}\u0000\u05f0\u05fc\u0003\u010a"+
		"\u0085\u0000\u05f1\u05fc\u0003\u0110\u0088\u0000\u05f2\u05fc\u0003\u011a"+
		"\u008d\u0000\u05f3\u05fc\u0003\u011c\u008e\u0000\u05f4\u05fc\u0003\u012c"+
		"\u0096\u0000\u05f5\u05fc\u0003\u0140\u00a0\u0000\u05f6\u05fc\u0003\u0142"+
		"\u00a1\u0000\u05f7\u05fc\u0003\u0144\u00a2\u0000\u05f8\u05fc\u0003\u0148"+
		"\u00a4\u0000\u05f9\u05fc\u0003\u0146\u00a3\u0000\u05fa\u05fc\u0003\u014a"+
		"\u00a5\u0000\u05fb\u05ef\u0001\u0000\u0000\u0000\u05fb\u05f0\u0001\u0000"+
		"\u0000\u0000\u05fb\u05f1\u0001\u0000\u0000\u0000\u05fb\u05f2\u0001\u0000"+
		"\u0000\u0000\u05fb\u05f3\u0001\u0000\u0000\u0000\u05fb\u05f4\u0001\u0000"+
		"\u0000\u0000\u05fb\u05f5\u0001\u0000\u0000\u0000\u05fb\u05f6\u0001\u0000"+
		"\u0000\u0000\u05fb\u05f7\u0001\u0000\u0000\u0000\u05fb\u05f8\u0001\u0000"+
		"\u0000\u0000\u05fb\u05f9\u0001\u0000\u0000\u0000\u05fb\u05fa\u0001\u0000"+
		"\u0000\u0000\u05fc\u0109\u0001\u0000\u0000\u0000\u05fd\u05fe\u0005?\u0000"+
		"\u0000\u05fe\u010b\u0001\u0000\u0000\u0000\u05ff\u0600\u0005f\u0000\u0000"+
		"\u0600\u0601\u0005H\u0000\u0000\u0601\u0602\u0003\u0104\u0082\u0000\u0602"+
		"\u010d\u0001\u0000\u0000\u0000\u0603\u0604\u0005f\u0000\u0000\u0604\u0605"+
		"\u0005H\u0000\u0000\u0605\u0606\u0003\u0106\u0083\u0000\u0606\u010f\u0001"+
		"\u0000\u0000\u0000\u0607\u0608\u0003\u0112\u0089\u0000\u0608\u0609\u0005"+
		"?\u0000\u0000\u0609\u0111\u0001\u0000\u0000\u0000\u060a\u0612\u0003\u01a8"+
		"\u00d4\u0000\u060b\u0612\u0003\u01c6\u00e3\u0000\u060c\u0612\u0003\u01c8"+
		"\u00e4\u0000\u060d\u0612\u0003\u01ce\u00e7\u0000\u060e\u0612\u0003\u01d2"+
		"\u00e9\u0000\u060f\u0612\u0003\u0186\u00c3\u0000\u0610\u0612\u0003\u0172"+
		"\u00b9\u0000\u0611\u060a\u0001\u0000\u0000\u0000\u0611\u060b\u0001\u0000"+
		"\u0000\u0000\u0611\u060c\u0001\u0000\u0000\u0000\u0611\u060d\u0001\u0000"+
		"\u0000\u0000\u0611\u060e\u0001\u0000\u0000\u0000\u0611\u060f\u0001\u0000"+
		"\u0000\u0000\u0611\u0610\u0001\u0000\u0000\u0000\u0612\u0113\u0001\u0000"+
		"\u0000\u0000\u0613\u0614\u0005\u0016\u0000\u0000\u0614\u0615\u00059\u0000"+
		"\u0000\u0615\u0616\u0003\u019c\u00ce\u0000\u0616\u0617\u0005:\u0000\u0000"+
		"\u0617\u0618\u0003\u0104\u0082\u0000\u0618\u0115\u0001\u0000\u0000\u0000"+
		"\u0619\u061a\u0005\u0016\u0000\u0000\u061a\u061b\u00059\u0000\u0000\u061b"+
		"\u061c\u0003\u019c\u00ce\u0000\u061c\u061d\u0005:\u0000\u0000\u061d\u061e"+
		"\u0003\u0106\u0083\u0000\u061e\u061f\u0005\u000f\u0000\u0000\u061f\u0620"+
		"\u0003\u0104\u0082\u0000\u0620\u0117\u0001\u0000\u0000\u0000\u0621\u0622"+
		"\u0005\u0016\u0000\u0000\u0622\u0623\u00059\u0000\u0000\u0623\u0624\u0003"+
		"\u019c\u00ce\u0000\u0624\u0625\u0005:\u0000\u0000\u0625\u0626\u0003\u0106"+
		"\u0083\u0000\u0626\u0627\u0005\u000f\u0000\u0000\u0627\u0628\u0003\u0106"+
		"\u0083\u0000\u0628\u0119\u0001\u0000\u0000\u0000\u0629\u062a\u0005\u0002"+
		"\u0000\u0000\u062a\u062b\u0003\u019c\u00ce\u0000\u062b\u062c\u0005?\u0000"+
		"\u0000\u062c\u0634\u0001\u0000\u0000\u0000\u062d\u062e\u0005\u0002\u0000"+
		"\u0000\u062e\u062f\u0003\u019c\u00ce\u0000\u062f\u0630\u0005H\u0000\u0000"+
		"\u0630\u0631\u0003\u019c\u00ce\u0000\u0631\u0632\u0005?\u0000\u0000\u0632"+
		"\u0634\u0001\u0000\u0000\u0000\u0633\u0629\u0001\u0000\u0000\u0000\u0633"+
		"\u062d\u0001\u0000\u0000\u0000\u0634\u011b\u0001\u0000\u0000\u0000\u0635"+
		"\u0636\u0005)\u0000\u0000\u0636\u0637\u00059\u0000\u0000\u0637\u0638\u0003"+
		"\u019c\u00ce\u0000\u0638\u0639\u0005:\u0000\u0000\u0639\u063a\u0003\u011e"+
		"\u008f\u0000\u063a\u011d\u0001\u0000\u0000\u0000\u063b\u063f\u0005;\u0000"+
		"\u0000\u063c\u063e\u0003\u0120\u0090\u0000\u063d\u063c\u0001\u0000\u0000"+
		"\u0000\u063e\u0641\u0001\u0000\u0000\u0000\u063f\u063d\u0001\u0000\u0000"+
		"\u0000\u063f\u0640\u0001\u0000\u0000\u0000\u0640\u0645\u0001\u0000\u0000"+
		"\u0000\u0641\u063f\u0001\u0000\u0000\u0000\u0642\u0644\u0003\u0124\u0092"+
		"\u0000\u0643\u0642\u0001\u0000\u0000\u0000\u0644\u0647\u0001\u0000\u0000"+
		"\u0000\u0645\u0643\u0001\u0000\u0000\u0000\u0645\u0646\u0001\u0000\u0000"+
		"\u0000\u0646\u0648\u0001\u0000\u0000\u0000\u0647\u0645\u0001\u0000\u0000"+
		"\u0000\u0648\u0649\u0005<\u0000\u0000\u0649\u011f\u0001\u0000\u0000\u0000"+
		"\u064a\u064b\u0003\u0122\u0091\u0000\u064b\u064c\u0003\u00fc~\u0000\u064c"+
		"\u0121\u0001\u0000\u0000\u0000\u064d\u0651\u0003\u0124\u0092\u0000\u064e"+
		"\u0650\u0003\u0124\u0092\u0000\u064f\u064e\u0001\u0000\u0000\u0000\u0650"+
		"\u0653\u0001\u0000\u0000\u0000\u0651\u064f\u0001\u0000\u0000\u0000\u0651"+
		"\u0652\u0001\u0000\u0000\u0000\u0652\u0123\u0001\u0000\u0000\u0000\u0653"+
		"\u0651\u0001\u0000\u0000\u0000\u0654\u0655\u0005\u0006\u0000\u0000\u0655"+
		"\u0656\u0003\u019a\u00cd\u0000\u0656\u0657\u0005H\u0000\u0000\u0657\u065f"+
		"\u0001\u0000\u0000\u0000\u0658\u0659\u0005\u0006\u0000\u0000\u0659\u065a"+
		"\u0003\u0126\u0093\u0000\u065a\u065b\u0005H\u0000\u0000\u065b\u065f\u0001"+
		"\u0000\u0000\u0000\u065c\u065d\u0005\f\u0000\u0000\u065d\u065f\u0005H"+
		"\u0000\u0000\u065e\u0654\u0001\u0000\u0000\u0000\u065e\u0658\u0001\u0000"+
		"\u0000\u0000\u065e\u065c\u0001\u0000\u0000\u0000\u065f\u0125\u0001\u0000"+
		"\u0000\u0000\u0660\u0661\u0005f\u0000\u0000\u0661\u0127\u0001\u0000\u0000"+
		"\u0000\u0662\u0663\u00052\u0000\u0000\u0663\u0664\u00059\u0000\u0000\u0664"+
		"\u0665\u0003\u019c\u00ce\u0000\u0665\u0666\u0005:\u0000\u0000\u0666\u0667"+
		"\u0003\u0104\u0082\u0000\u0667\u0129\u0001\u0000\u0000\u0000\u0668\u0669"+
		"\u00052\u0000\u0000\u0669\u066a\u00059\u0000\u0000\u066a\u066b\u0003\u019c"+
		"\u00ce\u0000\u066b\u066c\u0005:\u0000\u0000\u066c\u066d\u0003\u0106\u0083"+
		"\u0000\u066d\u012b\u0001\u0000\u0000\u0000\u066e\u066f\u0005\r\u0000\u0000"+
		"\u066f\u0670\u0003\u0104\u0082\u0000\u0670\u0671\u00052\u0000\u0000\u0671"+
		"\u0672\u00059\u0000\u0000\u0672\u0673\u0003\u019c\u00ce\u0000\u0673\u0674"+
		"\u0005:\u0000\u0000\u0674\u0675\u0005?\u0000\u0000\u0675\u012d\u0001\u0000"+
		"\u0000\u0000\u0676\u0679\u0003\u0132\u0099\u0000\u0677\u0679\u0003\u013c"+
		"\u009e\u0000\u0678\u0676\u0001\u0000\u0000\u0000\u0678\u0677\u0001\u0000"+
		"\u0000\u0000\u0679\u012f\u0001\u0000\u0000\u0000\u067a\u067d\u0003\u0134"+
		"\u009a\u0000\u067b\u067d\u0003\u013e\u009f\u0000\u067c\u067a\u0001\u0000"+
		"\u0000\u0000\u067c\u067b\u0001\u0000\u0000\u0000\u067d\u0131\u0001\u0000"+
		"\u0000\u0000\u067e\u067f\u0005\u0015\u0000\u0000\u067f\u0681\u00059\u0000"+
		"\u0000\u0680\u0682\u0003\u0136\u009b\u0000\u0681\u0680\u0001\u0000\u0000"+
		"\u0000\u0681\u0682\u0001\u0000\u0000\u0000\u0682\u0683\u0001\u0000\u0000"+
		"\u0000\u0683\u0685\u0005?\u0000\u0000\u0684\u0686\u0003\u019c\u00ce\u0000"+
		"\u0685\u0684\u0001\u0000\u0000\u0000\u0685\u0686\u0001\u0000\u0000\u0000"+
		"\u0686\u0687\u0001\u0000\u0000\u0000\u0687\u0689\u0005?\u0000\u0000\u0688"+
		"\u068a\u0003\u0138\u009c\u0000\u0689\u0688\u0001\u0000\u0000\u0000\u0689"+
		"\u068a\u0001\u0000\u0000\u0000\u068a\u068b\u0001\u0000\u0000\u0000\u068b"+
		"\u068c\u0005:\u0000\u0000\u068c\u068d\u0003\u0104\u0082\u0000\u068d\u0133"+
		"\u0001\u0000\u0000\u0000\u068e\u068f\u0005\u0015\u0000\u0000\u068f\u0691"+
		"\u00059\u0000\u0000\u0690\u0692\u0003\u0136\u009b\u0000\u0691\u0690\u0001"+
		"\u0000\u0000\u0000\u0691\u0692\u0001\u0000\u0000\u0000\u0692\u0693\u0001"+
		"\u0000\u0000\u0000\u0693\u0695\u0005?\u0000\u0000\u0694\u0696\u0003\u019c"+
		"\u00ce\u0000\u0695\u0694\u0001\u0000\u0000\u0000\u0695\u0696\u0001\u0000"+
		"\u0000\u0000\u0696\u0697\u0001\u0000\u0000\u0000\u0697\u0699\u0005?\u0000"+
		"\u0000\u0698\u069a\u0003\u0138\u009c\u0000\u0699\u0698\u0001\u0000\u0000"+
		"\u0000\u0699\u069a\u0001\u0000\u0000\u0000\u069a\u069b\u0001\u0000\u0000"+
		"\u0000\u069b\u069c\u0005:\u0000\u0000\u069c\u069d\u0003\u0106\u0083\u0000"+
		"\u069d\u0135\u0001\u0000\u0000\u0000\u069e\u06a1\u0003\u013a\u009d\u0000"+
		"\u069f\u06a1\u0003\u0102\u0081\u0000\u06a0\u069e\u0001\u0000\u0000\u0000"+
		"\u06a0\u069f\u0001\u0000\u0000\u0000\u06a1\u0137\u0001\u0000\u0000\u0000"+
		"\u06a2\u06a3\u0003\u013a\u009d\u0000\u06a3\u0139\u0001\u0000\u0000\u0000"+
		"\u06a4\u06a9\u0003\u0112\u0089\u0000\u06a5\u06a6\u0005@\u0000\u0000\u06a6"+
		"\u06a8\u0003\u0112\u0089\u0000\u06a7\u06a5\u0001\u0000\u0000\u0000\u06a8"+
		"\u06ab\u0001\u0000\u0000\u0000\u06a9\u06a7\u0001\u0000\u0000\u0000\u06a9"+
		"\u06aa\u0001\u0000\u0000\u0000\u06aa\u013b\u0001\u0000\u0000\u0000\u06ab"+
		"\u06a9\u0001\u0000\u0000\u0000\u06ac\u06ad\u0005\u0015\u0000\u0000\u06ad"+
		"\u06b1\u00059\u0000\u0000\u06ae\u06b0\u0003\u009aM\u0000\u06af\u06ae\u0001"+
		"\u0000\u0000\u0000\u06b0\u06b3\u0001\u0000\u0000\u0000\u06b1\u06af\u0001"+
		"\u0000\u0000\u0000\u06b1\u06b2\u0001\u0000\u0000\u0000\u06b2\u06b4\u0001"+
		"\u0000\u0000\u0000\u06b3\u06b1\u0001\u0000\u0000\u0000\u06b4\u06b5\u0003"+
		"r9\u0000\u06b5\u06b6\u0003n7\u0000\u06b6\u06b7\u0005H\u0000\u0000\u06b7"+
		"\u06b8\u0003\u019c\u00ce\u0000\u06b8\u06b9\u0005:\u0000\u0000\u06b9\u06ba"+
		"\u0003\u0104\u0082\u0000\u06ba\u013d\u0001\u0000\u0000\u0000\u06bb\u06bc"+
		"\u0005\u0015\u0000\u0000\u06bc\u06c0\u00059\u0000\u0000\u06bd\u06bf\u0003"+
		"\u009aM\u0000\u06be\u06bd\u0001\u0000\u0000\u0000\u06bf\u06c2\u0001\u0000"+
		"\u0000\u0000\u06c0\u06be\u0001\u0000\u0000\u0000\u06c0\u06c1\u0001\u0000"+
		"\u0000\u0000\u06c1\u06c3\u0001\u0000\u0000\u0000\u06c2\u06c0\u0001\u0000"+
		"\u0000\u0000\u06c3\u06c4\u0003r9\u0000\u06c4\u06c5\u0003n7\u0000\u06c5"+
		"\u06c6\u0005H\u0000\u0000\u06c6\u06c7\u0003\u019c\u00ce\u0000\u06c7\u06c8"+
		"\u0005:\u0000\u0000\u06c8\u06c9\u0003\u0106\u0083\u0000\u06c9\u013f\u0001"+
		"\u0000\u0000\u0000\u06ca\u06cc\u0005\u0004\u0000\u0000\u06cb\u06cd\u0005"+
		"f\u0000\u0000\u06cc\u06cb\u0001\u0000\u0000\u0000\u06cc\u06cd\u0001\u0000"+
		"\u0000\u0000\u06cd\u06ce\u0001\u0000\u0000\u0000\u06ce\u06cf\u0005?\u0000"+
		"\u0000\u06cf\u0141\u0001\u0000\u0000\u0000\u06d0\u06d2\u0005\u000b\u0000"+
		"\u0000\u06d1\u06d3\u0005f\u0000\u0000\u06d2\u06d1\u0001\u0000\u0000\u0000"+
		"\u06d2\u06d3\u0001\u0000\u0000\u0000\u06d3\u06d4\u0001\u0000\u0000\u0000"+
		"\u06d4\u06d5\u0005?\u0000\u0000\u06d5\u0143\u0001\u0000\u0000\u0000\u06d6"+
		"\u06d8\u0005$\u0000\u0000\u06d7\u06d9\u0003\u019c\u00ce\u0000\u06d8\u06d7"+
		"\u0001\u0000\u0000\u0000\u06d8\u06d9\u0001\u0000\u0000\u0000\u06d9\u06da"+
		"\u0001\u0000\u0000\u0000\u06da\u06db\u0005?\u0000\u0000\u06db\u0145\u0001"+
		"\u0000\u0000\u0000\u06dc\u06dd\u0005,\u0000\u0000\u06dd\u06de\u0003\u019c"+
		"\u00ce\u0000\u06de\u06df\u0005?\u0000\u0000\u06df\u0147\u0001\u0000\u0000"+
		"\u0000\u06e0\u06e1\u0005*\u0000\u0000\u06e1\u06e2\u00059\u0000\u0000\u06e2"+
		"\u06e3\u0003\u019c\u00ce\u0000\u06e3\u06e4\u0005:\u0000\u0000\u06e4\u06e5"+
		"\u0003\u00fa}\u0000\u06e5\u0149\u0001\u0000\u0000\u0000\u06e6\u06e7\u0005"+
		"/\u0000\u0000\u06e7\u06e8\u0003\u00fa}\u0000\u06e8\u06e9\u0003\u014c\u00a6"+
		"\u0000\u06e9\u06f3\u0001\u0000\u0000\u0000\u06ea\u06eb\u0005/\u0000\u0000"+
		"\u06eb\u06ed\u0003\u00fa}\u0000\u06ec\u06ee\u0003\u014c\u00a6\u0000\u06ed"+
		"\u06ec\u0001\u0000\u0000\u0000\u06ed\u06ee\u0001\u0000\u0000\u0000\u06ee"+
		"\u06ef\u0001\u0000\u0000\u0000\u06ef\u06f0\u0003\u0154\u00aa\u0000\u06f0"+
		"\u06f3\u0001\u0000\u0000\u0000\u06f1\u06f3\u0003\u0156\u00ab\u0000\u06f2"+
		"\u06e6\u0001\u0000\u0000\u0000\u06f2\u06ea\u0001\u0000\u0000\u0000\u06f2"+
		"\u06f1\u0001\u0000\u0000\u0000\u06f3\u014b\u0001\u0000\u0000\u0000\u06f4"+
		"\u06f8\u0003\u014e\u00a7\u0000\u06f5\u06f7\u0003\u014e\u00a7\u0000\u06f6"+
		"\u06f5\u0001\u0000\u0000\u0000\u06f7\u06fa\u0001\u0000\u0000\u0000\u06f8"+
		"\u06f6\u0001\u0000\u0000\u0000\u06f8\u06f9\u0001\u0000\u0000\u0000\u06f9"+
		"\u014d\u0001\u0000\u0000\u0000\u06fa\u06f8\u0001\u0000\u0000\u0000\u06fb"+
		"\u06fc\u0005\u0007\u0000\u0000\u06fc\u06fd\u00059\u0000\u0000\u06fd\u06fe"+
		"\u0003\u0150\u00a8\u0000\u06fe\u06ff\u0005:\u0000\u0000\u06ff\u0700\u0003"+
		"\u00fa}\u0000\u0700\u014f\u0001\u0000\u0000\u0000\u0701\u0703\u0003\u009a"+
		"M\u0000\u0702\u0701\u0001\u0000\u0000\u0000\u0703\u0706\u0001\u0000\u0000"+
		"\u0000\u0704\u0702\u0001\u0000\u0000\u0000\u0704\u0705\u0001\u0000\u0000"+
		"\u0000\u0705\u0707\u0001\u0000\u0000\u0000\u0706\u0704\u0001\u0000\u0000"+
		"\u0000\u0707\u0708\u0003\u0152\u00a9\u0000\u0708\u0709\u0003n7\u0000\u0709"+
		"\u0151\u0001\u0000\u0000\u0000\u070a\u070f\u0003z=\u0000\u070b\u070c\u0005"+
		"V\u0000\u0000\u070c\u070e\u0003\u000e\u0007\u0000\u070d\u070b\u0001\u0000"+
		"\u0000\u0000\u070e\u0711\u0001\u0000\u0000\u0000\u070f\u070d\u0001\u0000"+
		"\u0000\u0000\u070f\u0710\u0001\u0000\u0000\u0000\u0710\u0153\u0001\u0000"+
		"\u0000\u0000\u0711\u070f\u0001\u0000\u0000\u0000\u0712\u0713\u0005\u0013"+
		"\u0000\u0000\u0713\u0714\u0003\u00fa}\u0000\u0714\u0155\u0001\u0000\u0000"+
		"\u0000\u0715\u0716\u0005/\u0000\u0000\u0716\u0717\u0003\u0158\u00ac\u0000"+
		"\u0717\u0719\u0003\u00fa}\u0000\u0718\u071a\u0003\u014c\u00a6\u0000\u0719"+
		"\u0718\u0001\u0000\u0000\u0000\u0719\u071a\u0001\u0000\u0000\u0000\u071a"+
		"\u071c\u0001\u0000\u0000\u0000\u071b\u071d\u0003\u0154\u00aa\u0000\u071c"+
		"\u071b\u0001\u0000\u0000\u0000\u071c\u071d\u0001\u0000\u0000\u0000\u071d"+
		"\u0157\u0001\u0000\u0000\u0000\u071e\u071f\u00059\u0000\u0000\u071f\u0721"+
		"\u0003\u015a\u00ad\u0000\u0720\u0722\u0005?\u0000\u0000\u0721\u0720\u0001"+
		"\u0000\u0000\u0000\u0721\u0722\u0001\u0000\u0000\u0000\u0722\u0723\u0001"+
		"\u0000\u0000\u0000\u0723\u0724\u0005:\u0000\u0000\u0724\u0159\u0001\u0000"+
		"\u0000\u0000\u0725\u072a\u0003\u015c\u00ae\u0000\u0726\u0727\u0005?\u0000"+
		"\u0000\u0727\u0729\u0003\u015c\u00ae\u0000\u0728\u0726\u0001\u0000\u0000"+
		"\u0000\u0729\u072c\u0001\u0000\u0000\u0000\u072a\u0728\u0001\u0000\u0000"+
		"\u0000\u072a\u072b\u0001\u0000\u0000\u0000\u072b\u015b\u0001\u0000\u0000"+
		"\u0000\u072c\u072a\u0001\u0000\u0000\u0000\u072d\u072f\u0003\u009aM\u0000"+
		"\u072e\u072d\u0001\u0000\u0000\u0000\u072f\u0732\u0001\u0000\u0000\u0000"+
		"\u0730\u072e\u0001\u0000\u0000\u0000\u0730\u0731\u0001\u0000\u0000\u0000"+
		"\u0731\u0733\u0001\u0000\u0000\u0000\u0732\u0730\u0001\u0000\u0000\u0000"+
		"\u0733\u0734\u0003r9\u0000\u0734\u0735\u0003n7\u0000\u0735\u0736\u0005"+
		"B\u0000\u0000\u0736\u0737\u0003\u019c\u00ce\u0000\u0737\u015d\u0001\u0000"+
		"\u0000\u0000\u0738\u073b\u0003\u016c\u00b6\u0000\u0739\u073b\u0003\u0194"+
		"\u00ca\u0000\u073a\u0738\u0001\u0000\u0000\u0000\u073a\u0739\u0001\u0000"+
		"\u0000\u0000\u073b\u073f\u0001\u0000\u0000\u0000\u073c\u073e\u0003\u0166"+
		"\u00b3\u0000\u073d\u073c\u0001\u0000\u0000\u0000\u073e\u0741\u0001\u0000"+
		"\u0000\u0000\u073f\u073d\u0001\u0000\u0000\u0000\u073f\u0740\u0001\u0000"+
		"\u0000\u0000\u0740\u015f\u0001\u0000\u0000\u0000\u0741\u073f\u0001\u0000"+
		"\u0000\u0000\u0742\u0760\u0003\u0000\u0000\u0000\u0743\u0748\u00034\u001a"+
		"\u0000\u0744\u0745\u0005=\u0000\u0000\u0745\u0747\u0005>\u0000\u0000\u0746"+
		"\u0744\u0001\u0000\u0000\u0000\u0747\u074a\u0001\u0000\u0000\u0000\u0748"+
		"\u0746\u0001\u0000\u0000\u0000\u0748\u0749\u0001\u0000\u0000\u0000\u0749"+
		"\u074b\u0001\u0000\u0000\u0000\u074a\u0748\u0001\u0000\u0000\u0000\u074b"+
		"\u074c\u0005A\u0000\u0000\u074c\u074d\u0005\t\u0000\u0000\u074d\u0760"+
		"\u0001\u0000\u0000\u0000\u074e\u074f\u00050\u0000\u0000\u074f\u0750\u0005"+
		"A\u0000\u0000\u0750\u0760\u0005\t\u0000\u0000\u0751\u0760\u0005+\u0000"+
		"\u0000\u0752\u0753\u00034\u001a\u0000\u0753\u0754\u0005A\u0000\u0000\u0754"+
		"\u0755\u0005+\u0000\u0000\u0755\u0760\u0001\u0000\u0000\u0000\u0756\u0757"+
		"\u00059\u0000\u0000\u0757\u0758\u0003\u019c\u00ce\u0000\u0758\u0759\u0005"+
		":\u0000\u0000\u0759\u0760\u0001\u0000\u0000\u0000\u075a\u0760\u0003\u0172"+
		"\u00b9\u0000\u075b\u0760\u0003\u017a\u00bd\u0000\u075c\u0760\u0003\u0180"+
		"\u00c0\u0000\u075d\u0760\u0003\u0186\u00c3\u0000\u075e\u0760\u0003\u018e"+
		"\u00c7\u0000\u075f\u0742\u0001\u0000\u0000\u0000\u075f\u0743\u0001\u0000"+
		"\u0000\u0000\u075f\u074e\u0001\u0000\u0000\u0000\u075f\u0751\u0001\u0000"+
		"\u0000\u0000\u075f\u0752\u0001\u0000\u0000\u0000\u075f\u0756\u0001\u0000"+
		"\u0000\u0000\u075f\u075a\u0001\u0000\u0000\u0000\u075f\u075b\u0001\u0000"+
		"\u0000\u0000\u075f\u075c\u0001\u0000\u0000\u0000\u075f\u075d\u0001\u0000"+
		"\u0000\u0000\u075f\u075e\u0001\u0000\u0000\u0000\u0760\u0161\u0001\u0000"+
		"\u0000\u0000\u0761\u0762\u0001\u0000\u0000\u0000\u0762\u0163\u0001\u0000"+
		"\u0000\u0000\u0763\u0780\u0003\u0000\u0000\u0000\u0764\u0769\u00034\u001a"+
		"\u0000\u0765\u0766\u0005=\u0000\u0000\u0766\u0768\u0005>\u0000\u0000\u0767"+
		"\u0765\u0001\u0000\u0000\u0000\u0768\u076b\u0001\u0000\u0000\u0000\u0769"+
		"\u0767\u0001\u0000\u0000\u0000\u0769\u076a\u0001\u0000\u0000\u0000\u076a"+
		"\u076c\u0001\u0000\u0000\u0000\u076b\u0769\u0001\u0000\u0000\u0000\u076c"+
		"\u076d\u0005A\u0000\u0000\u076d\u076e\u0005\t\u0000\u0000\u076e\u0780"+
		"\u0001\u0000\u0000\u0000\u076f\u0770\u00050\u0000\u0000\u0770\u0771\u0005"+
		"A\u0000\u0000\u0771\u0780\u0005\t\u0000\u0000\u0772\u0780\u0005+\u0000"+
		"\u0000\u0773\u0774\u00034\u001a\u0000\u0774\u0775\u0005A\u0000\u0000\u0775"+
		"\u0776\u0005+\u0000\u0000\u0776\u0780\u0001\u0000\u0000\u0000\u0777\u0778"+
		"\u00059\u0000\u0000\u0778\u0779\u0003\u019c\u00ce\u0000\u0779\u077a\u0005"+
		":\u0000\u0000\u077a\u0780\u0001\u0000\u0000\u0000\u077b\u0780\u0003\u0172"+
		"\u00b9\u0000\u077c\u0780\u0003\u017a\u00bd\u0000\u077d\u0780\u0003\u0186"+
		"\u00c3\u0000\u077e\u0780\u0003\u018e\u00c7\u0000\u077f\u0763\u0001\u0000"+
		"\u0000\u0000\u077f\u0764\u0001\u0000\u0000\u0000\u077f\u076f\u0001\u0000"+
		"\u0000\u0000\u077f\u0772\u0001\u0000\u0000\u0000\u077f\u0773\u0001\u0000"+
		"\u0000\u0000\u077f\u0777\u0001\u0000\u0000\u0000\u077f\u077b\u0001\u0000"+
		"\u0000\u0000\u077f\u077c\u0001\u0000\u0000\u0000\u077f\u077d\u0001\u0000"+
		"\u0000\u0000\u077f\u077e\u0001\u0000\u0000\u0000\u0780\u0165\u0001\u0000"+
		"\u0000\u0000\u0781\u0787\u0003\u0174\u00ba\u0000\u0782\u0787\u0003\u017c"+
		"\u00be\u0000\u0783\u0787\u0003\u0182\u00c1\u0000\u0784\u0787\u0003\u0188"+
		"\u00c4\u0000\u0785\u0787\u0003\u0190\u00c8\u0000\u0786\u0781\u0001\u0000"+
		"\u0000\u0000\u0786\u0782\u0001\u0000\u0000\u0000\u0786\u0783\u0001\u0000"+
		"\u0000\u0000\u0786\u0784\u0001\u0000\u0000\u0000\u0786\u0785\u0001\u0000"+
		"\u0000\u0000\u0787\u0167\u0001\u0000\u0000\u0000\u0788\u0789\u0001\u0000"+
		"\u0000\u0000\u0789\u0169\u0001\u0000\u0000\u0000\u078a\u078f\u0003\u0174"+
		"\u00ba\u0000\u078b\u078f\u0003\u017c\u00be\u0000\u078c\u078f\u0003\u0188"+
		"\u00c4\u0000\u078d\u078f\u0003\u0190\u00c8\u0000\u078e\u078a\u0001\u0000"+
		"\u0000\u0000\u078e\u078b\u0001\u0000\u0000\u0000\u078e\u078c\u0001\u0000"+
		"\u0000\u0000\u078e\u078d\u0001\u0000\u0000\u0000\u078f\u016b\u0001\u0000"+
		"\u0000\u0000\u0790\u07b9\u0003\u0000\u0000\u0000\u0791\u0796\u00034\u001a"+
		"\u0000\u0792\u0793\u0005=\u0000\u0000\u0793\u0795\u0005>\u0000\u0000\u0794"+
		"\u0792\u0001\u0000\u0000\u0000\u0795\u0798\u0001\u0000\u0000\u0000\u0796"+
		"\u0794\u0001\u0000\u0000\u0000\u0796\u0797\u0001\u0000\u0000\u0000\u0797"+
		"\u0799\u0001\u0000\u0000\u0000\u0798\u0796\u0001\u0000\u0000\u0000\u0799"+
		"\u079a\u0005A\u0000\u0000\u079a\u079b\u0005\t\u0000\u0000\u079b\u07b9"+
		"\u0001\u0000\u0000\u0000\u079c\u07a1\u0003t:\u0000\u079d\u079e\u0005="+
		"\u0000\u0000\u079e\u07a0\u0005>\u0000\u0000\u079f\u079d\u0001\u0000\u0000"+
		"\u0000\u07a0\u07a3\u0001\u0000\u0000\u0000\u07a1\u079f\u0001\u0000\u0000"+
		"\u0000\u07a1\u07a2\u0001\u0000\u0000\u0000\u07a2\u07a4\u0001\u0000\u0000"+
		"\u0000\u07a3\u07a1\u0001\u0000\u0000\u0000\u07a4\u07a5\u0005A\u0000\u0000"+
		"\u07a5\u07a6\u0005\t\u0000\u0000\u07a6\u07b9\u0001\u0000\u0000\u0000\u07a7"+
		"\u07a8\u00050\u0000\u0000\u07a8\u07a9\u0005A\u0000\u0000\u07a9\u07b9\u0005"+
		"\t\u0000\u0000\u07aa\u07b9\u0005+\u0000\u0000\u07ab\u07ac\u00034\u001a"+
		"\u0000\u07ac\u07ad\u0005A\u0000\u0000\u07ad\u07ae\u0005+\u0000\u0000\u07ae"+
		"\u07b9\u0001\u0000\u0000\u0000\u07af\u07b0\u00059\u0000\u0000\u07b0\u07b1"+
		"\u0003\u019c\u00ce\u0000\u07b1\u07b2\u0005:\u0000\u0000\u07b2\u07b9\u0001"+
		"\u0000\u0000\u0000\u07b3\u07b9\u0003\u0176\u00bb\u0000\u07b4\u07b9\u0003"+
		"\u017e\u00bf\u0000\u07b5\u07b9\u0003\u0184\u00c2\u0000\u07b6\u07b9\u0003"+
		"\u018a\u00c5\u0000\u07b7\u07b9\u0003\u0192\u00c9\u0000\u07b8\u0790\u0001"+
		"\u0000\u0000\u0000\u07b8\u0791\u0001\u0000\u0000\u0000\u07b8\u079c\u0001"+
		"\u0000\u0000\u0000\u07b8\u07a7\u0001\u0000\u0000\u0000\u07b8\u07aa\u0001"+
		"\u0000\u0000\u0000\u07b8\u07ab\u0001\u0000\u0000\u0000\u07b8\u07af\u0001"+
		"\u0000\u0000\u0000\u07b8\u07b3\u0001\u0000\u0000\u0000\u07b8\u07b4\u0001"+
		"\u0000\u0000\u0000\u07b8\u07b5\u0001\u0000\u0000\u0000\u07b8\u07b6\u0001"+
		"\u0000\u0000\u0000\u07b8\u07b7\u0001\u0000\u0000\u0000\u07b9\u016d\u0001"+
		"\u0000\u0000\u0000\u07ba\u07bb\u0001\u0000\u0000\u0000\u07bb\u016f\u0001"+
		"\u0000\u0000\u0000\u07bc\u07e4\u0003\u0000\u0000\u0000\u07bd\u07c2\u0003"+
		"4\u001a\u0000\u07be\u07bf\u0005=\u0000\u0000\u07bf\u07c1\u0005>\u0000"+
		"\u0000\u07c0\u07be\u0001\u0000\u0000\u0000\u07c1\u07c4\u0001\u0000\u0000"+
		"\u0000\u07c2\u07c0\u0001\u0000\u0000\u0000\u07c2\u07c3\u0001\u0000\u0000"+
		"\u0000\u07c3\u07c5\u0001\u0000\u0000\u0000\u07c4\u07c2\u0001\u0000\u0000"+
		"\u0000\u07c5\u07c6\u0005A\u0000\u0000\u07c6\u07c7\u0005\t\u0000\u0000"+
		"\u07c7\u07e4\u0001\u0000\u0000\u0000\u07c8\u07cd\u0003t:\u0000\u07c9\u07ca"+
		"\u0005=\u0000\u0000\u07ca\u07cc\u0005>\u0000\u0000\u07cb\u07c9\u0001\u0000"+
		"\u0000\u0000\u07cc\u07cf\u0001\u0000\u0000\u0000\u07cd\u07cb\u0001\u0000"+
		"\u0000\u0000\u07cd\u07ce\u0001\u0000\u0000\u0000\u07ce\u07d0\u0001\u0000"+
		"\u0000\u0000\u07cf\u07cd\u0001\u0000\u0000\u0000\u07d0\u07d1\u0005A\u0000"+
		"\u0000\u07d1\u07d2\u0005\t\u0000\u0000\u07d2\u07e4\u0001\u0000\u0000\u0000"+
		"\u07d3\u07d4\u00050\u0000\u0000\u07d4\u07d5\u0005A\u0000\u0000\u07d5\u07e4"+
		"\u0005\t\u0000\u0000\u07d6\u07e4\u0005+\u0000\u0000\u07d7\u07d8\u0003"+
		"4\u001a\u0000\u07d8\u07d9\u0005A\u0000\u0000\u07d9\u07da\u0005+\u0000"+
		"\u0000\u07da\u07e4\u0001\u0000\u0000\u0000\u07db\u07dc\u00059\u0000\u0000"+
		"\u07dc\u07dd\u0003\u019c\u00ce\u0000\u07dd\u07de\u0005:\u0000\u0000\u07de"+
		"\u07e4\u0001\u0000\u0000\u0000\u07df\u07e4\u0003\u0176\u00bb\u0000\u07e0"+
		"\u07e4\u0003\u017e\u00bf\u0000\u07e1\u07e4\u0003\u018a\u00c5\u0000\u07e2"+
		"\u07e4\u0003\u0192\u00c9\u0000\u07e3\u07bc\u0001\u0000\u0000\u0000\u07e3"+
		"\u07bd\u0001\u0000\u0000\u0000\u07e3\u07c8\u0001\u0000\u0000\u0000\u07e3"+
		"\u07d3\u0001\u0000\u0000\u0000\u07e3\u07d6\u0001\u0000\u0000\u0000\u07e3"+
		"\u07d7\u0001\u0000\u0000\u0000\u07e3\u07db\u0001\u0000\u0000\u0000\u07e3"+
		"\u07df\u0001\u0000\u0000\u0000\u07e3\u07e0\u0001\u0000\u0000\u0000\u07e3"+
		"\u07e1\u0001\u0000\u0000\u0000\u07e3\u07e2\u0001\u0000\u0000\u0000\u07e4"+
		"\u0171\u0001\u0000\u0000\u0000\u07e5\u07e7\u0005\u001f\u0000\u0000\u07e6"+
		"\u07e8\u0003(\u0014\u0000\u07e7\u07e6\u0001\u0000\u0000\u0000\u07e7\u07e8"+
		"\u0001\u0000\u0000\u0000\u07e8\u07ec\u0001\u0000\u0000\u0000\u07e9\u07eb"+
		"\u0003\u00e4r\u0000\u07ea\u07e9\u0001\u0000\u0000\u0000\u07eb\u07ee\u0001"+
		"\u0000\u0000\u0000\u07ec\u07ea\u0001\u0000\u0000\u0000\u07ec\u07ed\u0001"+
		"\u0000\u0000\u0000\u07ed\u07ef\u0001\u0000\u0000\u0000\u07ee\u07ec\u0001"+
		"\u0000\u0000\u0000\u07ef\u07fa\u0005f\u0000\u0000\u07f0\u07f4\u0005A\u0000"+
		"\u0000\u07f1\u07f3\u0003\u00e4r\u0000\u07f2\u07f1\u0001\u0000\u0000\u0000"+
		"\u07f3\u07f6\u0001\u0000\u0000\u0000\u07f4\u07f2\u0001\u0000\u0000\u0000"+
		"\u07f4\u07f5\u0001\u0000\u0000\u0000\u07f5\u07f7\u0001\u0000\u0000\u0000"+
		"\u07f6\u07f4\u0001\u0000\u0000\u0000\u07f7\u07f9\u0005f\u0000\u0000\u07f8"+
		"\u07f0\u0001\u0000\u0000\u0000\u07f9\u07fc\u0001\u0000\u0000\u0000\u07fa"+
		"\u07f8\u0001\u0000\u0000\u0000\u07fa\u07fb\u0001\u0000\u0000\u0000\u07fb"+
		"\u07fe\u0001\u0000\u0000\u0000\u07fc\u07fa\u0001\u0000\u0000\u0000\u07fd"+
		"\u07ff\u0003\u0178\u00bc\u0000\u07fe\u07fd\u0001\u0000\u0000\u0000\u07fe"+
		"\u07ff\u0001\u0000\u0000\u0000\u07ff\u0800\u0001\u0000\u0000\u0000\u0800"+
		"\u0802\u00059\u0000\u0000\u0801\u0803\u0003\u018c\u00c6\u0000\u0802\u0801"+
		"\u0001\u0000\u0000\u0000\u0802\u0803\u0001\u0000\u0000\u0000\u0803\u0804"+
		"\u0001\u0000\u0000\u0000\u0804\u0806\u0005:\u0000\u0000\u0805\u0807\u0003"+
		"`0\u0000\u0806\u0805\u0001\u0000\u0000\u0000\u0806\u0807\u0001\u0000\u0000"+
		"\u0000\u0807\u0839\u0001\u0000\u0000\u0000\u0808\u0809\u00038\u001c\u0000"+
		"\u0809\u080a\u0005A\u0000\u0000\u080a\u080c\u0005\u001f\u0000\u0000\u080b"+
		"\u080d\u0003(\u0014\u0000\u080c\u080b\u0001\u0000\u0000\u0000\u080c\u080d"+
		"\u0001\u0000\u0000\u0000\u080d\u0811\u0001\u0000\u0000\u0000\u080e\u0810"+
		"\u0003\u00e4r\u0000\u080f\u080e\u0001\u0000\u0000\u0000\u0810\u0813\u0001"+
		"\u0000\u0000\u0000\u0811\u080f\u0001\u0000\u0000\u0000\u0811\u0812\u0001"+
		"\u0000\u0000\u0000\u0812\u0814\u0001\u0000\u0000\u0000\u0813\u0811\u0001"+
		"\u0000\u0000\u0000\u0814\u0816\u0005f\u0000\u0000\u0815\u0817\u0003\u0178"+
		"\u00bc\u0000\u0816\u0815\u0001\u0000\u0000\u0000\u0816\u0817\u0001\u0000"+
		"\u0000\u0000\u0817\u0818\u0001\u0000\u0000\u0000\u0818\u081a\u00059\u0000"+
		"\u0000\u0819\u081b\u0003\u018c\u00c6\u0000\u081a\u0819\u0001\u0000\u0000"+
		"\u0000\u081a\u081b\u0001\u0000\u0000\u0000\u081b\u081c\u0001\u0000\u0000"+
		"\u0000\u081c\u081e\u0005:\u0000\u0000\u081d\u081f\u0003`0\u0000\u081e"+
		"\u081d\u0001\u0000\u0000\u0000\u081e\u081f\u0001\u0000\u0000\u0000\u081f"+
		"\u0839\u0001\u0000\u0000\u0000\u0820\u0821\u0003\u015e\u00af\u0000\u0821"+
		"\u0822\u0005A\u0000\u0000\u0822\u0824\u0005\u001f\u0000\u0000\u0823\u0825"+
		"\u0003(\u0014\u0000\u0824\u0823\u0001\u0000\u0000\u0000\u0824\u0825\u0001"+
		"\u0000\u0000\u0000\u0825\u0829\u0001\u0000\u0000\u0000\u0826\u0828\u0003"+
		"\u00e4r\u0000\u0827\u0826\u0001\u0000\u0000\u0000\u0828\u082b\u0001\u0000"+
		"\u0000\u0000\u0829\u0827\u0001\u0000\u0000\u0000\u0829\u082a\u0001\u0000"+
		"\u0000\u0000\u082a\u082c\u0001\u0000\u0000\u0000\u082b\u0829\u0001\u0000"+
		"\u0000\u0000\u082c\u082e\u0005f\u0000\u0000\u082d\u082f\u0003\u0178\u00bc"+
		"\u0000\u082e\u082d\u0001\u0000\u0000\u0000\u082e\u082f\u0001\u0000\u0000"+
		"\u0000\u082f\u0830\u0001\u0000\u0000\u0000\u0830\u0832\u00059\u0000\u0000"+
		"\u0831\u0833\u0003\u018c\u00c6\u0000\u0832\u0831\u0001\u0000\u0000\u0000"+
		"\u0832\u0833\u0001\u0000\u0000\u0000\u0833\u0834\u0001\u0000\u0000\u0000"+
		"\u0834\u0836\u0005:\u0000\u0000\u0835\u0837\u0003`0\u0000\u0836\u0835"+
		"\u0001\u0000\u0000\u0000\u0836\u0837\u0001\u0000\u0000\u0000\u0837\u0839"+
		"\u0001\u0000\u0000\u0000\u0838\u07e5\u0001\u0000\u0000\u0000\u0838\u0808"+
		"\u0001\u0000\u0000\u0000\u0838\u0820\u0001\u0000\u0000\u0000\u0839\u0173"+
		"\u0001\u0000\u0000\u0000\u083a\u083b\u0005A\u0000\u0000\u083b\u083d\u0005"+
		"\u001f\u0000\u0000\u083c\u083e\u0003(\u0014\u0000\u083d\u083c\u0001\u0000"+
		"\u0000\u0000\u083d\u083e\u0001\u0000\u0000\u0000\u083e\u0842\u0001\u0000"+
		"\u0000\u0000\u083f\u0841\u0003\u00e4r\u0000\u0840\u083f\u0001\u0000\u0000"+
		"\u0000\u0841\u0844\u0001\u0000\u0000\u0000\u0842\u0840\u0001\u0000\u0000"+
		"\u0000\u0842\u0843\u0001\u0000\u0000\u0000\u0843\u0845\u0001\u0000\u0000"+
		"\u0000\u0844\u0842\u0001\u0000\u0000\u0000\u0845\u0847\u0005f\u0000\u0000"+
		"\u0846\u0848\u0003\u0178\u00bc\u0000\u0847\u0846\u0001\u0000\u0000\u0000"+
		"\u0847\u0848\u0001\u0000\u0000\u0000\u0848\u0849\u0001\u0000\u0000\u0000"+
		"\u0849\u084b\u00059\u0000\u0000\u084a\u084c\u0003\u018c\u00c6\u0000\u084b"+
		"\u084a\u0001\u0000\u0000\u0000\u084b\u084c\u0001\u0000\u0000\u0000\u084c"+
		"\u084d\u0001\u0000\u0000\u0000\u084d\u084f\u0005:\u0000\u0000\u084e\u0850"+
		"\u0003`0\u0000\u084f\u084e\u0001\u0000\u0000\u0000\u084f\u0850\u0001\u0000"+
		"\u0000\u0000\u0850\u0175\u0001\u0000\u0000\u0000\u0851\u0853\u0005\u001f"+
		"\u0000\u0000\u0852\u0854\u0003(\u0014\u0000\u0853\u0852\u0001\u0000\u0000"+
		"\u0000\u0853\u0854\u0001\u0000\u0000\u0000\u0854\u0858\u0001\u0000\u0000"+
		"\u0000\u0855\u0857\u0003\u00e4r\u0000\u0856\u0855\u0001\u0000\u0000\u0000"+
		"\u0857\u085a\u0001\u0000\u0000\u0000\u0858\u0856\u0001\u0000\u0000\u0000"+
		"\u0858\u0859\u0001\u0000\u0000\u0000\u0859\u085b\u0001\u0000\u0000\u0000"+
		"\u085a\u0858\u0001\u0000\u0000\u0000\u085b\u0866\u0005f\u0000\u0000\u085c"+
		"\u0860\u0005A\u0000\u0000\u085d\u085f\u0003\u00e4r\u0000\u085e\u085d\u0001"+
		"\u0000\u0000\u0000\u085f\u0862\u0001\u0000\u0000\u0000\u0860\u085e\u0001"+
		"\u0000\u0000\u0000\u0860\u0861\u0001\u0000\u0000\u0000\u0861\u0863\u0001"+
		"\u0000\u0000\u0000\u0862\u0860\u0001\u0000\u0000\u0000\u0863\u0865\u0005"+
		"f\u0000\u0000\u0864\u085c\u0001\u0000\u0000\u0000\u0865\u0868\u0001\u0000"+
		"\u0000\u0000\u0866\u0864\u0001\u0000\u0000\u0000\u0866\u0867\u0001\u0000"+
		"\u0000\u0000\u0867\u086a\u0001\u0000\u0000\u0000\u0868\u0866\u0001\u0000"+
		"\u0000\u0000\u0869\u086b\u0003\u0178\u00bc\u0000\u086a\u0869\u0001\u0000"+
		"\u0000\u0000\u086a\u086b\u0001\u0000\u0000\u0000\u086b\u086c\u0001\u0000"+
		"\u0000\u0000\u086c\u086e\u00059\u0000\u0000\u086d\u086f\u0003\u018c\u00c6"+
		"\u0000\u086e\u086d\u0001\u0000\u0000\u0000\u086e\u086f\u0001\u0000\u0000"+
		"\u0000\u086f\u0870\u0001\u0000\u0000\u0000\u0870\u0872\u0005:\u0000\u0000"+
		"\u0871\u0873\u0003`0\u0000\u0872\u0871\u0001\u0000\u0000\u0000\u0872\u0873"+
		"\u0001\u0000\u0000\u0000\u0873\u088d\u0001\u0000\u0000\u0000\u0874\u0875"+
		"\u00038\u001c\u0000\u0875\u0876\u0005A\u0000\u0000\u0876\u0878\u0005\u001f"+
		"\u0000\u0000\u0877\u0879\u0003(\u0014\u0000\u0878\u0877\u0001\u0000\u0000"+
		"\u0000\u0878\u0879\u0001\u0000\u0000\u0000\u0879\u087d\u0001\u0000\u0000"+
		"\u0000\u087a\u087c\u0003\u00e4r\u0000\u087b\u087a\u0001\u0000\u0000\u0000"+
		"\u087c\u087f\u0001\u0000\u0000\u0000\u087d\u087b\u0001\u0000\u0000\u0000"+
		"\u087d\u087e\u0001\u0000\u0000\u0000\u087e\u0880\u0001\u0000\u0000\u0000"+
		"\u087f\u087d\u0001\u0000\u0000\u0000\u0880\u0882\u0005f\u0000\u0000\u0881"+
		"\u0883\u0003\u0178\u00bc\u0000\u0882\u0881\u0001\u0000\u0000\u0000\u0882"+
		"\u0883\u0001\u0000\u0000\u0000\u0883\u0884\u0001\u0000\u0000\u0000\u0884"+
		"\u0886\u00059\u0000\u0000\u0885\u0887\u0003\u018c\u00c6\u0000\u0886\u0885"+
		"\u0001\u0000\u0000\u0000\u0886\u0887\u0001\u0000\u0000\u0000\u0887\u0888"+
		"\u0001\u0000\u0000\u0000\u0888\u088a\u0005:\u0000\u0000\u0889\u088b\u0003"+
		"`0\u0000\u088a\u0889\u0001\u0000\u0000\u0000\u088a\u088b\u0001\u0000\u0000"+
		"\u0000\u088b\u088d\u0001\u0000\u0000\u0000\u088c\u0851\u0001\u0000\u0000"+
		"\u0000\u088c\u0874\u0001\u0000\u0000\u0000\u088d\u0177\u0001\u0000\u0000"+
		"\u0000\u088e\u0892\u0003(\u0014\u0000\u088f\u0890\u0005D\u0000\u0000\u0890"+
		"\u0892\u0005C\u0000\u0000\u0891\u088e\u0001\u0000\u0000\u0000\u0891\u088f"+
		"\u0001\u0000\u0000\u0000\u0892\u0179\u0001\u0000\u0000\u0000\u0893\u0894"+
		"\u0003\u015e\u00af\u0000\u0894\u0895\u0005A\u0000\u0000\u0895\u0896\u0005"+
		"f\u0000\u0000\u0896\u08a1\u0001\u0000\u0000\u0000\u0897\u0898\u0005(\u0000"+
		"\u0000\u0898\u0899\u0005A\u0000\u0000\u0899\u08a1\u0005f\u0000\u0000\u089a"+
		"\u089b\u00034\u001a\u0000\u089b\u089c\u0005A\u0000\u0000\u089c\u089d\u0005"+
		"(\u0000\u0000\u089d\u089e\u0005A\u0000\u0000\u089e\u089f\u0005f\u0000"+
		"\u0000\u089f\u08a1\u0001\u0000\u0000\u0000\u08a0\u0893\u0001\u0000\u0000"+
		"\u0000\u08a0\u0897\u0001\u0000\u0000\u0000\u08a0\u089a\u0001\u0000\u0000"+
		"\u0000\u08a1\u017b\u0001\u0000\u0000\u0000\u08a2\u08a3\u0005A\u0000\u0000"+
		"\u08a3\u08a4\u0005f\u0000\u0000\u08a4\u017d\u0001\u0000\u0000\u0000\u08a5"+
		"\u08a6\u0005(\u0000\u0000\u08a6\u08a7\u0005A\u0000\u0000\u08a7\u08af\u0005"+
		"f\u0000\u0000\u08a8\u08a9\u00034\u001a\u0000\u08a9\u08aa\u0005A\u0000"+
		"\u0000\u08aa\u08ab\u0005(\u0000\u0000\u08ab\u08ac\u0005A\u0000\u0000\u08ac"+
		"\u08ad\u0005f\u0000\u0000\u08ad\u08af\u0001\u0000\u0000\u0000\u08ae\u08a5"+
		"\u0001\u0000\u0000\u0000\u08ae\u08a8\u0001\u0000\u0000\u0000\u08af\u017f"+
		"\u0001\u0000\u0000\u0000\u08b0\u08b1\u00038\u001c\u0000\u08b1\u08b2\u0005"+
		"=\u0000\u0000\u08b2\u08b3\u0003\u019c\u00ce\u0000\u08b3\u08b4\u0005>\u0000"+
		"\u0000\u08b4\u08bb\u0001\u0000\u0000\u0000\u08b5\u08b6\u0003\u0164\u00b2"+
		"\u0000\u08b6\u08b7\u0005=\u0000\u0000\u08b7\u08b8\u0003\u019c\u00ce\u0000"+
		"\u08b8\u08b9\u0005>\u0000\u0000\u08b9\u08bb\u0001\u0000\u0000\u0000\u08ba"+
		"\u08b0\u0001\u0000\u0000\u0000\u08ba\u08b5\u0001\u0000\u0000\u0000\u08bb"+
		"\u08c3\u0001\u0000\u0000\u0000\u08bc\u08bd\u0003\u0162\u00b1\u0000\u08bd"+
		"\u08be\u0005=\u0000\u0000\u08be\u08bf\u0003\u019c\u00ce\u0000\u08bf\u08c0"+
		"\u0005>\u0000\u0000\u08c0\u08c2\u0001\u0000\u0000\u0000\u08c1\u08bc\u0001"+
		"\u0000\u0000\u0000\u08c2\u08c5\u0001\u0000\u0000\u0000\u08c3\u08c1\u0001"+
		"\u0000\u0000\u0000\u08c3\u08c4\u0001\u0000\u0000\u0000\u08c4\u0181\u0001"+
		"\u0000\u0000\u0000\u08c5\u08c3\u0001\u0000\u0000\u0000\u08c6\u08c7\u0003"+
		"\u016a\u00b5\u0000\u08c7\u08c8\u0005=\u0000\u0000\u08c8\u08c9\u0003\u019c"+
		"\u00ce\u0000\u08c9\u08ca\u0005>\u0000\u0000\u08ca\u08d2\u0001\u0000\u0000"+
		"\u0000\u08cb\u08cc\u0003\u0168\u00b4\u0000\u08cc\u08cd\u0005=\u0000\u0000"+
		"\u08cd\u08ce\u0003\u019c\u00ce\u0000\u08ce\u08cf\u0005>\u0000\u0000\u08cf"+
		"\u08d1\u0001\u0000\u0000\u0000\u08d0\u08cb\u0001\u0000\u0000\u0000\u08d1"+
		"\u08d4\u0001\u0000\u0000\u0000\u08d2\u08d0\u0001\u0000\u0000\u0000\u08d2"+
		"\u08d3\u0001\u0000\u0000\u0000\u08d3\u0183\u0001\u0000\u0000\u0000\u08d4"+
		"\u08d2\u0001\u0000\u0000\u0000\u08d5\u08d6\u00038\u001c\u0000\u08d6\u08d7"+
		"\u0005=\u0000\u0000\u08d7\u08d8\u0003\u019c\u00ce\u0000\u08d8\u08d9\u0005"+
		">\u0000\u0000\u08d9\u08e0\u0001\u0000\u0000\u0000\u08da\u08db\u0003\u0170"+
		"\u00b8\u0000\u08db\u08dc\u0005=\u0000\u0000\u08dc\u08dd\u0003\u019c\u00ce"+
		"\u0000\u08dd\u08de\u0005>\u0000\u0000\u08de\u08e0\u0001\u0000\u0000\u0000"+
		"\u08df\u08d5\u0001\u0000\u0000\u0000\u08df\u08da\u0001\u0000\u0000\u0000"+
		"\u08e0\u08e8\u0001\u0000\u0000\u0000\u08e1\u08e2\u0003\u016e\u00b7\u0000"+
		"\u08e2\u08e3\u0005=\u0000\u0000\u08e3\u08e4\u0003\u019c\u00ce\u0000\u08e4"+
		"\u08e5\u0005>\u0000\u0000\u08e5\u08e7\u0001\u0000\u0000\u0000\u08e6\u08e1"+
		"\u0001\u0000\u0000\u0000\u08e7\u08ea\u0001\u0000\u0000\u0000\u08e8\u08e6"+
		"\u0001\u0000\u0000\u0000\u08e8\u08e9\u0001\u0000\u0000\u0000\u08e9\u0185"+
		"\u0001\u0000\u0000\u0000\u08ea\u08e8\u0001\u0000\u0000\u0000\u08eb\u08ec"+
		"\u0003:\u001d\u0000\u08ec\u08ee\u00059\u0000\u0000\u08ed\u08ef\u0003\u018c"+
		"\u00c6\u0000\u08ee\u08ed\u0001\u0000\u0000\u0000\u08ee\u08ef\u0001\u0000"+
		"\u0000\u0000\u08ef\u08f0\u0001\u0000\u0000\u0000\u08f0\u08f1\u0005:\u0000"+
		"\u0000\u08f1\u0930\u0001\u0000\u0000\u0000\u08f2\u08f3\u00034\u001a\u0000"+
		"\u08f3\u08f5\u0005A\u0000\u0000\u08f4\u08f6\u0003(\u0014\u0000\u08f5\u08f4"+
		"\u0001\u0000\u0000\u0000\u08f5\u08f6\u0001\u0000\u0000\u0000\u08f6\u08f7"+
		"\u0001\u0000\u0000\u0000\u08f7\u08f8\u0005f\u0000\u0000\u08f8\u08fa\u0005"+
		"9\u0000\u0000\u08f9\u08fb\u0003\u018c\u00c6\u0000\u08fa\u08f9\u0001\u0000"+
		"\u0000\u0000\u08fa\u08fb\u0001\u0000\u0000\u0000\u08fb\u08fc\u0001\u0000"+
		"\u0000\u0000\u08fc\u08fd\u0005:\u0000\u0000\u08fd\u0930\u0001\u0000\u0000"+
		"\u0000\u08fe\u08ff\u00038\u001c\u0000\u08ff\u0901\u0005A\u0000\u0000\u0900"+
		"\u0902\u0003(\u0014\u0000\u0901\u0900\u0001\u0000\u0000\u0000\u0901\u0902"+
		"\u0001\u0000\u0000\u0000\u0902\u0903\u0001\u0000\u0000\u0000\u0903\u0904"+
		"\u0005f\u0000\u0000\u0904\u0906\u00059\u0000\u0000\u0905\u0907\u0003\u018c"+
		"\u00c6\u0000\u0906\u0905\u0001\u0000\u0000\u0000\u0906\u0907\u0001\u0000"+
		"\u0000\u0000\u0907\u0908\u0001\u0000\u0000\u0000\u0908\u0909\u0005:\u0000"+
		"\u0000\u0909\u0930\u0001\u0000\u0000\u0000\u090a\u090b\u0003\u015e\u00af"+
		"\u0000\u090b\u090d\u0005A\u0000\u0000\u090c\u090e\u0003(\u0014\u0000\u090d"+
		"\u090c\u0001\u0000\u0000\u0000\u090d\u090e\u0001\u0000\u0000\u0000\u090e"+
		"\u090f\u0001\u0000\u0000\u0000\u090f\u0910\u0005f\u0000\u0000\u0910\u0912"+
		"\u00059\u0000\u0000\u0911\u0913\u0003\u018c\u00c6\u0000\u0912\u0911\u0001"+
		"\u0000\u0000\u0000\u0912\u0913\u0001\u0000\u0000\u0000\u0913\u0914\u0001"+
		"\u0000\u0000\u0000\u0914\u0915\u0005:\u0000\u0000\u0915\u0930\u0001\u0000"+
		"\u0000\u0000\u0916\u0917\u0005(\u0000\u0000\u0917\u0919\u0005A\u0000\u0000"+
		"\u0918\u091a\u0003(\u0014\u0000\u0919\u0918\u0001\u0000\u0000\u0000\u0919"+
		"\u091a\u0001\u0000\u0000\u0000\u091a\u091b\u0001\u0000\u0000\u0000\u091b"+
		"\u091c\u0005f\u0000\u0000\u091c\u091e\u00059\u0000\u0000\u091d\u091f\u0003"+
		"\u018c\u00c6\u0000\u091e\u091d\u0001\u0000\u0000\u0000\u091e\u091f\u0001"+
		"\u0000\u0000\u0000\u091f\u0920\u0001\u0000\u0000\u0000\u0920\u0930\u0005"+
		":\u0000\u0000\u0921\u0922\u00034\u001a\u0000\u0922\u0923\u0005A\u0000"+
		"\u0000\u0923\u0924\u0005(\u0000\u0000\u0924\u0926\u0005A\u0000\u0000\u0925"+
		"\u0927\u0003(\u0014\u0000\u0926\u0925\u0001\u0000\u0000\u0000\u0926\u0927"+
		"\u0001\u0000\u0000\u0000\u0927\u0928\u0001\u0000\u0000\u0000\u0928\u0929"+
		"\u0005f\u0000\u0000\u0929\u092b\u00059\u0000\u0000\u092a\u092c\u0003\u018c"+
		"\u00c6\u0000\u092b\u092a\u0001\u0000\u0000\u0000\u092b\u092c\u0001\u0000"+
		"\u0000\u0000\u092c\u092d\u0001\u0000\u0000\u0000\u092d\u092e\u0005:\u0000"+
		"\u0000\u092e\u0930\u0001\u0000\u0000\u0000\u092f\u08eb\u0001\u0000\u0000"+
		"\u0000\u092f\u08f2\u0001\u0000\u0000\u0000\u092f\u08fe\u0001\u0000\u0000"+
		"\u0000\u092f\u090a\u0001\u0000\u0000\u0000\u092f\u0916\u0001\u0000\u0000"+
		"\u0000\u092f\u0921\u0001\u0000\u0000\u0000\u0930\u0187\u0001\u0000\u0000"+
		"\u0000\u0931\u0933\u0005A\u0000\u0000\u0932\u0934\u0003(\u0014\u0000\u0933"+
		"\u0932\u0001\u0000\u0000\u0000\u0933\u0934\u0001\u0000\u0000\u0000\u0934"+
		"\u0935\u0001\u0000\u0000\u0000\u0935\u0936\u0005f\u0000\u0000\u0936\u0938"+
		"\u00059\u0000\u0000\u0937\u0939\u0003\u018c\u00c6\u0000\u0938\u0937\u0001"+
		"\u0000\u0000\u0000\u0938\u0939\u0001\u0000\u0000\u0000\u0939\u093a\u0001"+
		"\u0000\u0000\u0000\u093a\u093b\u0005:\u0000\u0000\u093b\u0189\u0001\u0000"+
		"\u0000\u0000\u093c\u093d\u0003:\u001d\u0000\u093d\u093f\u00059\u0000\u0000"+
		"\u093e\u0940\u0003\u018c\u00c6\u0000\u093f\u093e\u0001\u0000\u0000\u0000"+
		"\u093f\u0940\u0001\u0000\u0000\u0000\u0940\u0941\u0001\u0000\u0000\u0000"+
		"\u0941\u0942\u0005:\u0000\u0000\u0942\u0975\u0001\u0000\u0000\u0000\u0943"+
		"\u0944\u00034\u001a\u0000\u0944\u0946\u0005A\u0000\u0000\u0945\u0947\u0003"+
		"(\u0014\u0000\u0946\u0945\u0001\u0000\u0000\u0000\u0946\u0947\u0001\u0000"+
		"\u0000\u0000\u0947\u0948\u0001\u0000\u0000\u0000\u0948\u0949\u0005f\u0000"+
		"\u0000\u0949\u094b\u00059\u0000\u0000\u094a\u094c\u0003\u018c\u00c6\u0000"+
		"\u094b\u094a\u0001\u0000\u0000\u0000\u094b\u094c\u0001\u0000\u0000\u0000"+
		"\u094c\u094d\u0001\u0000\u0000\u0000\u094d\u094e\u0005:\u0000\u0000\u094e"+
		"\u0975\u0001\u0000\u0000\u0000\u094f\u0950\u00038\u001c\u0000\u0950\u0952"+
		"\u0005A\u0000\u0000\u0951\u0953\u0003(\u0014\u0000\u0952\u0951\u0001\u0000"+
		"\u0000\u0000\u0952\u0953\u0001\u0000\u0000\u0000\u0953\u0954\u0001\u0000"+
		"\u0000\u0000\u0954\u0955\u0005f\u0000\u0000\u0955\u0957\u00059\u0000\u0000"+
		"\u0956\u0958\u0003\u018c\u00c6\u0000\u0957\u0956\u0001\u0000\u0000\u0000"+
		"\u0957\u0958\u0001\u0000\u0000\u0000\u0958\u0959\u0001\u0000\u0000\u0000"+
		"\u0959\u095a\u0005:\u0000\u0000\u095a\u0975\u0001\u0000\u0000\u0000\u095b"+
		"\u095c\u0005(\u0000\u0000\u095c\u095e\u0005A\u0000\u0000\u095d\u095f\u0003"+
		"(\u0014\u0000\u095e\u095d\u0001\u0000\u0000\u0000\u095e\u095f\u0001\u0000"+
		"\u0000\u0000\u095f\u0960\u0001\u0000\u0000\u0000\u0960\u0961\u0005f\u0000"+
		"\u0000\u0961\u0963\u00059\u0000\u0000\u0962\u0964\u0003\u018c\u00c6\u0000"+
		"\u0963\u0962\u0001\u0000\u0000\u0000\u0963\u0964\u0001\u0000\u0000\u0000"+
		"\u0964\u0965\u0001\u0000\u0000\u0000\u0965\u0975\u0005:\u0000\u0000\u0966"+
		"\u0967\u00034\u001a\u0000\u0967\u0968\u0005A\u0000\u0000\u0968\u0969\u0005"+
		"(\u0000\u0000\u0969\u096b\u0005A\u0000\u0000\u096a\u096c\u0003(\u0014"+
		"\u0000\u096b\u096a\u0001\u0000\u0000\u0000\u096b\u096c\u0001\u0000\u0000"+
		"\u0000\u096c\u096d\u0001\u0000\u0000";
	private static final String _serializedATNSegment1 =
		"\u0000\u096d\u096e\u0005f\u0000\u0000\u096e\u0970\u00059\u0000\u0000\u096f"+
		"\u0971\u0003\u018c\u00c6\u0000\u0970\u096f\u0001\u0000\u0000\u0000\u0970"+
		"\u0971\u0001\u0000\u0000\u0000\u0971\u0972\u0001\u0000\u0000\u0000\u0972"+
		"\u0973\u0005:\u0000\u0000\u0973\u0975\u0001\u0000\u0000\u0000\u0974\u093c"+
		"\u0001\u0000\u0000\u0000\u0974\u0943\u0001\u0000\u0000\u0000\u0974\u094f"+
		"\u0001\u0000\u0000\u0000\u0974\u095b\u0001\u0000\u0000\u0000\u0974\u0966"+
		"\u0001\u0000\u0000\u0000\u0975\u018b\u0001\u0000\u0000\u0000\u0976\u097b"+
		"\u0003\u019c\u00ce\u0000\u0977\u0978\u0005@\u0000\u0000\u0978\u097a\u0003"+
		"\u019c\u00ce\u0000\u0979\u0977\u0001\u0000\u0000\u0000\u097a\u097d\u0001"+
		"\u0000\u0000\u0000\u097b\u0979\u0001\u0000\u0000\u0000\u097b\u097c\u0001"+
		"\u0000\u0000\u0000\u097c\u018d\u0001\u0000\u0000\u0000\u097d\u097b\u0001"+
		"\u0000\u0000\u0000\u097e\u097f\u00038\u001c\u0000\u097f\u0981\u0005Z\u0000"+
		"\u0000\u0980\u0982\u0003(\u0014\u0000\u0981\u0980\u0001\u0000\u0000\u0000"+
		"\u0981\u0982\u0001\u0000\u0000\u0000\u0982\u0983\u0001\u0000\u0000\u0000"+
		"\u0983\u0984\u0005f\u0000\u0000\u0984\u09ae\u0001\u0000\u0000\u0000\u0985"+
		"\u0986\u0003\n\u0005\u0000\u0986\u0988\u0005Z\u0000\u0000\u0987\u0989"+
		"\u0003(\u0014\u0000\u0988\u0987\u0001\u0000\u0000\u0000\u0988\u0989\u0001"+
		"\u0000\u0000\u0000\u0989\u098a\u0001\u0000\u0000\u0000\u098a\u098b\u0005"+
		"f\u0000\u0000\u098b\u09ae\u0001\u0000\u0000\u0000\u098c\u098d\u0003\u015e"+
		"\u00af\u0000\u098d\u098f\u0005Z\u0000\u0000\u098e\u0990\u0003(\u0014\u0000"+
		"\u098f\u098e\u0001\u0000\u0000\u0000\u098f\u0990\u0001\u0000\u0000\u0000"+
		"\u0990\u0991\u0001\u0000\u0000\u0000\u0991\u0992\u0005f\u0000\u0000\u0992"+
		"\u09ae\u0001\u0000\u0000\u0000\u0993\u0994\u0005(\u0000\u0000\u0994\u0996"+
		"\u0005Z\u0000\u0000\u0995\u0997\u0003(\u0014\u0000\u0996\u0995\u0001\u0000"+
		"\u0000\u0000\u0996\u0997\u0001\u0000\u0000\u0000\u0997\u0998\u0001\u0000"+
		"\u0000\u0000\u0998\u09ae\u0005f\u0000\u0000\u0999\u099a\u00034\u001a\u0000"+
		"\u099a\u099b\u0005A\u0000\u0000\u099b\u099c\u0005(\u0000\u0000\u099c\u099e"+
		"\u0005Z\u0000\u0000\u099d\u099f\u0003(\u0014\u0000\u099e\u099d\u0001\u0000"+
		"\u0000\u0000\u099e\u099f\u0001\u0000\u0000\u0000\u099f\u09a0\u0001\u0000"+
		"\u0000\u0000\u09a0\u09a1\u0005f\u0000\u0000\u09a1\u09ae\u0001\u0000\u0000"+
		"\u0000\u09a2\u09a3\u0003\u000e\u0007\u0000\u09a3\u09a5\u0005Z\u0000\u0000"+
		"\u09a4\u09a6\u0003(\u0014\u0000\u09a5\u09a4\u0001\u0000\u0000\u0000\u09a5"+
		"\u09a6\u0001\u0000\u0000\u0000\u09a6\u09a7\u0001\u0000\u0000\u0000\u09a7"+
		"\u09a8\u0005\u001f\u0000\u0000\u09a8\u09ae\u0001\u0000\u0000\u0000\u09a9"+
		"\u09aa\u0003\u001c\u000e\u0000\u09aa\u09ab\u0005Z\u0000\u0000\u09ab\u09ac"+
		"\u0005\u001f\u0000\u0000\u09ac\u09ae\u0001\u0000\u0000\u0000\u09ad\u097e"+
		"\u0001\u0000\u0000\u0000\u09ad\u0985\u0001\u0000\u0000\u0000\u09ad\u098c"+
		"\u0001\u0000\u0000\u0000\u09ad\u0993\u0001\u0000\u0000\u0000\u09ad\u0999"+
		"\u0001\u0000\u0000\u0000\u09ad\u09a2\u0001\u0000\u0000\u0000\u09ad\u09a9"+
		"\u0001\u0000\u0000\u0000\u09ae\u018f\u0001\u0000\u0000\u0000\u09af\u09b1"+
		"\u0005Z\u0000\u0000\u09b0\u09b2\u0003(\u0014\u0000\u09b1\u09b0\u0001\u0000"+
		"\u0000\u0000\u09b1\u09b2\u0001\u0000\u0000\u0000\u09b2\u09b3\u0001\u0000"+
		"\u0000\u0000\u09b3\u09b4\u0005f\u0000\u0000\u09b4\u0191\u0001\u0000\u0000"+
		"\u0000\u09b5\u09b6\u00038\u001c\u0000\u09b6\u09b8\u0005Z\u0000\u0000\u09b7"+
		"\u09b9\u0003(\u0014\u0000\u09b8\u09b7\u0001\u0000\u0000\u0000\u09b8\u09b9"+
		"\u0001\u0000\u0000\u0000\u09b9\u09ba\u0001\u0000\u0000\u0000\u09ba\u09bb"+
		"\u0005f\u0000\u0000\u09bb\u09de\u0001\u0000\u0000\u0000\u09bc\u09bd\u0003"+
		"\n\u0005\u0000\u09bd\u09bf\u0005Z\u0000\u0000\u09be\u09c0\u0003(\u0014"+
		"\u0000\u09bf\u09be\u0001\u0000\u0000\u0000\u09bf\u09c0\u0001\u0000\u0000"+
		"\u0000\u09c0\u09c1\u0001\u0000\u0000\u0000\u09c1\u09c2\u0005f\u0000\u0000"+
		"\u09c2\u09de\u0001\u0000\u0000\u0000\u09c3\u09c4\u0005(\u0000\u0000\u09c4"+
		"\u09c6\u0005Z\u0000\u0000\u09c5\u09c7\u0003(\u0014\u0000\u09c6\u09c5\u0001"+
		"\u0000\u0000\u0000\u09c6\u09c7\u0001\u0000\u0000\u0000\u09c7\u09c8\u0001"+
		"\u0000\u0000\u0000\u09c8\u09de\u0005f\u0000\u0000\u09c9\u09ca\u00034\u001a"+
		"\u0000\u09ca\u09cb\u0005A\u0000\u0000\u09cb\u09cc\u0005(\u0000\u0000\u09cc"+
		"\u09ce\u0005Z\u0000\u0000\u09cd\u09cf\u0003(\u0014\u0000\u09ce\u09cd\u0001"+
		"\u0000\u0000\u0000\u09ce\u09cf\u0001\u0000\u0000\u0000\u09cf\u09d0\u0001"+
		"\u0000\u0000\u0000\u09d0\u09d1\u0005f\u0000\u0000\u09d1\u09de\u0001\u0000"+
		"\u0000\u0000\u09d2\u09d3\u0003\u000e\u0007\u0000\u09d3\u09d5\u0005Z\u0000"+
		"\u0000\u09d4\u09d6\u0003(\u0014\u0000\u09d5\u09d4\u0001\u0000\u0000\u0000"+
		"\u09d5\u09d6\u0001\u0000\u0000\u0000\u09d6\u09d7\u0001\u0000\u0000\u0000"+
		"\u09d7\u09d8\u0005\u001f\u0000\u0000\u09d8\u09de\u0001\u0000\u0000\u0000"+
		"\u09d9\u09da\u0003\u001c\u000e\u0000\u09da\u09db\u0005Z\u0000\u0000\u09db"+
		"\u09dc\u0005\u001f\u0000\u0000\u09dc\u09de\u0001\u0000\u0000\u0000\u09dd"+
		"\u09b5\u0001\u0000\u0000\u0000\u09dd\u09bc\u0001\u0000\u0000\u0000\u09dd"+
		"\u09c3\u0001\u0000\u0000\u0000\u09dd\u09c9\u0001\u0000\u0000\u0000\u09dd"+
		"\u09d2\u0001\u0000\u0000\u0000\u09dd\u09d9\u0001\u0000\u0000\u0000\u09de"+
		"\u0193\u0001\u0000\u0000\u0000\u09df\u09e0\u0005\u001f\u0000\u0000\u09e0"+
		"\u09e1\u0003\u0002\u0001\u0000\u09e1\u09e3\u0003\u0196\u00cb\u0000\u09e2"+
		"\u09e4\u0003\u001e\u000f\u0000\u09e3\u09e2\u0001\u0000\u0000\u0000\u09e3"+
		"\u09e4\u0001\u0000\u0000\u0000\u09e4\u09f6\u0001\u0000\u0000\u0000\u09e5"+
		"\u09e6\u0005\u001f\u0000\u0000\u09e6\u09e7\u0003\f\u0006\u0000\u09e7\u09e9"+
		"\u0003\u0196\u00cb\u0000\u09e8\u09ea\u0003\u001e\u000f\u0000\u09e9\u09e8"+
		"\u0001\u0000\u0000\u0000\u09e9\u09ea\u0001\u0000\u0000\u0000\u09ea\u09f6"+
		"\u0001\u0000\u0000\u0000\u09eb\u09ec\u0005\u001f\u0000\u0000\u09ec\u09ed"+
		"\u0003\u0002\u0001\u0000\u09ed\u09ee\u0003\u001e\u000f\u0000\u09ee\u09ef"+
		"\u0003\u00f6{\u0000\u09ef\u09f6\u0001\u0000\u0000\u0000\u09f0\u09f1\u0005"+
		"\u001f\u0000\u0000\u09f1\u09f2\u0003\f\u0006\u0000\u09f2\u09f3\u0003\u001e"+
		"\u000f\u0000\u09f3\u09f4\u0003\u00f6{\u0000\u09f4\u09f6\u0001\u0000\u0000"+
		"\u0000\u09f5\u09df\u0001\u0000\u0000\u0000\u09f5\u09e5\u0001\u0000\u0000"+
		"\u0000\u09f5\u09eb\u0001\u0000\u0000\u0000\u09f5\u09f0\u0001\u0000\u0000"+
		"\u0000\u09f6\u0195\u0001\u0000\u0000\u0000\u09f7\u09fb\u0003\u0198\u00cc"+
		"\u0000\u09f8\u09fa\u0003\u0198\u00cc\u0000\u09f9\u09f8\u0001\u0000\u0000"+
		"\u0000\u09fa\u09fd\u0001\u0000\u0000\u0000\u09fb\u09f9\u0001\u0000\u0000"+
		"\u0000\u09fb\u09fc\u0001\u0000\u0000\u0000\u09fc\u0197\u0001\u0000\u0000"+
		"\u0000\u09fd\u09fb\u0001\u0000\u0000\u0000\u09fe\u0a00\u0003\u00e4r\u0000"+
		"\u09ff\u09fe\u0001\u0000\u0000\u0000\u0a00\u0a03\u0001\u0000\u0000\u0000"+
		"\u0a01\u09ff\u0001\u0000\u0000\u0000\u0a01\u0a02\u0001\u0000\u0000\u0000"+
		"\u0a02\u0a04\u0001\u0000\u0000\u0000\u0a03\u0a01\u0001\u0000\u0000\u0000"+
		"\u0a04\u0a05\u0005=\u0000\u0000\u0a05\u0a06\u0003\u019c\u00ce\u0000\u0a06"+
		"\u0a07\u0005>\u0000\u0000\u0a07\u0199\u0001\u0000\u0000\u0000\u0a08\u0a09"+
		"\u0003\u019c\u00ce\u0000\u0a09\u019b\u0001\u0000\u0000\u0000\u0a0a\u0a0d"+
		"\u0003\u019e\u00cf\u0000\u0a0b\u0a0d\u0003\u01a6\u00d3\u0000\u0a0c\u0a0a"+
		"\u0001\u0000\u0000\u0000\u0a0c\u0a0b\u0001\u0000\u0000\u0000\u0a0d\u019d"+
		"\u0001\u0000\u0000\u0000\u0a0e\u0a0f\u0003\u01a0\u00d0\u0000\u0a0f\u0a10"+
		"\u0005Y\u0000\u0000\u0a10\u0a11\u0003\u01a4\u00d2\u0000\u0a11\u019f\u0001"+
		"\u0000\u0000\u0000\u0a12\u0a1d\u0005f\u0000\u0000\u0a13\u0a15\u00059\u0000"+
		"\u0000\u0a14\u0a16\u0003\u0094J\u0000\u0a15\u0a14\u0001\u0000\u0000\u0000"+
		"\u0a15\u0a16\u0001\u0000\u0000\u0000\u0a16\u0a17\u0001\u0000\u0000\u0000"+
		"\u0a17\u0a1d\u0005:\u0000\u0000\u0a18\u0a19\u00059\u0000\u0000\u0a19\u0a1a"+
		"\u0003\u01a2\u00d1\u0000\u0a1a\u0a1b\u0005:\u0000\u0000\u0a1b\u0a1d\u0001"+
		"\u0000\u0000\u0000\u0a1c\u0a12\u0001\u0000\u0000\u0000\u0a1c\u0a13\u0001"+
		"\u0000\u0000\u0000\u0a1c\u0a18\u0001\u0000\u0000\u0000\u0a1d\u01a1\u0001"+
		"\u0000\u0000\u0000\u0a1e\u0a23\u0005f\u0000\u0000\u0a1f\u0a20\u0005@\u0000"+
		"\u0000\u0a20\u0a22\u0005f\u0000\u0000\u0a21\u0a1f\u0001\u0000\u0000\u0000"+
		"\u0a22\u0a25\u0001\u0000\u0000\u0000\u0a23\u0a21\u0001\u0000\u0000\u0000"+
		"\u0a23\u0a24\u0001\u0000\u0000\u0000\u0a24\u01a3\u0001\u0000\u0000\u0000"+
		"\u0a25\u0a23\u0001\u0000\u0000\u0000\u0a26\u0a29\u0003\u019c\u00ce\u0000"+
		"\u0a27\u0a29\u0003\u00fa}\u0000\u0a28\u0a26\u0001\u0000\u0000\u0000\u0a28"+
		"\u0a27\u0001\u0000\u0000\u0000\u0a29\u01a5\u0001\u0000\u0000\u0000\u0a2a"+
		"\u0a2d\u0003\u01ae\u00d7\u0000\u0a2b\u0a2d\u0003\u01a8\u00d4\u0000\u0a2c"+
		"\u0a2a\u0001\u0000\u0000\u0000\u0a2c\u0a2b\u0001\u0000\u0000\u0000\u0a2d"+
		"\u01a7\u0001\u0000\u0000\u0000\u0a2e\u0a2f\u0003\u01aa\u00d5\u0000\u0a2f"+
		"\u0a30\u0003\u01ac\u00d6\u0000\u0a30\u0a31\u0003\u019c\u00ce\u0000\u0a31"+
		"\u01a9\u0001\u0000\u0000\u0000\u0a32\u0a36\u00038\u001c\u0000\u0a33\u0a36"+
		"\u0003\u017a\u00bd\u0000\u0a34\u0a36\u0003\u0180\u00c0\u0000\u0a35\u0a32"+
		"\u0001\u0000\u0000\u0000\u0a35\u0a33\u0001\u0000\u0000\u0000\u0a35\u0a34"+
		"\u0001\u0000\u0000\u0000\u0a36\u01ab\u0001\u0000\u0000\u0000\u0a37\u0a38"+
		"\u0007\u0003\u0000\u0000\u0a38\u01ad\u0001\u0000\u0000\u0000\u0a39\u0a41"+
		"\u0003\u01b0\u00d8\u0000\u0a3a\u0a3b\u0003\u01b0\u00d8\u0000\u0a3b\u0a3c"+
		"\u0005G\u0000\u0000\u0a3c\u0a3d\u0003\u019c\u00ce\u0000\u0a3d\u0a3e\u0005"+
		"H\u0000\u0000\u0a3e\u0a3f\u0003\u01ae\u00d7\u0000\u0a3f\u0a41\u0001\u0000"+
		"\u0000\u0000\u0a40\u0a39\u0001\u0000\u0000\u0000\u0a40\u0a3a\u0001\u0000"+
		"\u0000\u0000\u0a41\u01af\u0001\u0000\u0000\u0000\u0a42\u0a43\u0006\u00d8"+
		"\uffff\uffff\u0000\u0a43\u0a44\u0003\u01b2\u00d9\u0000\u0a44\u0a4a\u0001"+
		"\u0000\u0000\u0000\u0a45\u0a46\n\u0001\u0000\u0000\u0a46\u0a47\u0005N"+
		"\u0000\u0000\u0a47\u0a49\u0003\u01b2\u00d9\u0000\u0a48\u0a45\u0001\u0000"+
		"\u0000\u0000\u0a49\u0a4c\u0001\u0000\u0000\u0000\u0a4a\u0a48\u0001\u0000"+
		"\u0000\u0000\u0a4a\u0a4b\u0001\u0000\u0000\u0000\u0a4b\u01b1\u0001\u0000"+
		"\u0000\u0000\u0a4c\u0a4a\u0001\u0000\u0000\u0000\u0a4d\u0a4e\u0006\u00d9"+
		"\uffff\uffff\u0000\u0a4e\u0a4f\u0003\u01b4\u00da\u0000\u0a4f\u0a55\u0001"+
		"\u0000\u0000\u0000\u0a50\u0a51\n\u0001\u0000\u0000\u0a51\u0a52\u0005M"+
		"\u0000\u0000\u0a52\u0a54\u0003\u01b4\u00da\u0000\u0a53\u0a50\u0001\u0000"+
		"\u0000\u0000\u0a54\u0a57\u0001\u0000\u0000\u0000\u0a55\u0a53\u0001\u0000"+
		"\u0000\u0000\u0a55\u0a56\u0001\u0000\u0000\u0000\u0a56\u01b3\u0001\u0000"+
		"\u0000\u0000\u0a57\u0a55\u0001\u0000\u0000\u0000\u0a58\u0a59\u0006\u00da"+
		"\uffff\uffff\u0000\u0a59\u0a5a\u0003\u01b6\u00db\u0000\u0a5a\u0a60\u0001"+
		"\u0000\u0000\u0000\u0a5b\u0a5c\n\u0001\u0000\u0000\u0a5c\u0a5d\u0005V"+
		"\u0000\u0000\u0a5d\u0a5f\u0003\u01b6\u00db\u0000\u0a5e\u0a5b\u0001\u0000"+
		"\u0000\u0000\u0a5f\u0a62\u0001\u0000\u0000\u0000\u0a60\u0a5e\u0001\u0000"+
		"\u0000\u0000\u0a60\u0a61\u0001\u0000\u0000\u0000\u0a61\u01b5\u0001\u0000"+
		"\u0000\u0000\u0a62\u0a60\u0001\u0000\u0000\u0000\u0a63\u0a64\u0006\u00db"+
		"\uffff\uffff\u0000\u0a64\u0a65\u0003\u01b8\u00dc\u0000\u0a65\u0a6b\u0001"+
		"\u0000\u0000\u0000\u0a66\u0a67\n\u0001\u0000\u0000\u0a67\u0a68\u0005W"+
		"\u0000\u0000\u0a68\u0a6a\u0003\u01b8\u00dc\u0000\u0a69\u0a66\u0001\u0000"+
		"\u0000\u0000\u0a6a\u0a6d\u0001\u0000\u0000\u0000\u0a6b\u0a69\u0001\u0000"+
		"\u0000\u0000\u0a6b\u0a6c\u0001\u0000\u0000\u0000\u0a6c\u01b7\u0001\u0000"+
		"\u0000\u0000\u0a6d\u0a6b\u0001\u0000\u0000\u0000\u0a6e\u0a6f\u0006\u00dc"+
		"\uffff\uffff\u0000\u0a6f\u0a70\u0003\u01ba\u00dd\u0000\u0a70\u0a76\u0001"+
		"\u0000\u0000\u0000\u0a71\u0a72\n\u0001\u0000\u0000\u0a72\u0a73\u0005U"+
		"\u0000\u0000\u0a73\u0a75\u0003\u01ba\u00dd\u0000\u0a74\u0a71\u0001\u0000"+
		"\u0000\u0000\u0a75\u0a78\u0001\u0000\u0000\u0000\u0a76\u0a74\u0001\u0000"+
		"\u0000\u0000\u0a76\u0a77\u0001\u0000\u0000\u0000\u0a77\u01b9\u0001\u0000"+
		"\u0000\u0000\u0a78\u0a76\u0001\u0000\u0000\u0000\u0a79\u0a7a\u0006\u00dd"+
		"\uffff\uffff\u0000\u0a7a\u0a7b\u0003\u01bc\u00de\u0000\u0a7b\u0a84\u0001"+
		"\u0000\u0000\u0000\u0a7c\u0a7d\n\u0002\u0000\u0000\u0a7d\u0a7e\u0005I"+
		"\u0000\u0000\u0a7e\u0a83\u0003\u01bc\u00de\u0000\u0a7f\u0a80\n\u0001\u0000"+
		"\u0000\u0a80\u0a81\u0005L\u0000\u0000\u0a81\u0a83\u0003\u01bc\u00de\u0000"+
		"\u0a82\u0a7c\u0001\u0000\u0000\u0000\u0a82\u0a7f\u0001\u0000\u0000\u0000"+
		"\u0a83\u0a86\u0001\u0000\u0000\u0000\u0a84\u0a82\u0001\u0000\u0000\u0000"+
		"\u0a84\u0a85\u0001\u0000\u0000\u0000\u0a85\u01bb\u0001\u0000\u0000\u0000"+
		"\u0a86\u0a84\u0001\u0000\u0000\u0000\u0a87\u0a88\u0006\u00de\uffff\uffff"+
		"\u0000\u0a88\u0a89\u0003\u01be\u00df\u0000\u0a89\u0a9b\u0001\u0000\u0000"+
		"\u0000\u0a8a\u0a8b\n\u0005\u0000\u0000\u0a8b\u0a8c\u0005D\u0000\u0000"+
		"\u0a8c\u0a9a\u0003\u01be\u00df\u0000\u0a8d\u0a8e\n\u0004\u0000\u0000\u0a8e"+
		"\u0a8f\u0005C\u0000\u0000\u0a8f\u0a9a\u0003\u01be\u00df\u0000\u0a90\u0a91"+
		"\n\u0003\u0000\u0000\u0a91\u0a92\u0005J\u0000\u0000\u0a92\u0a9a\u0003"+
		"\u01be\u00df\u0000\u0a93\u0a94\n\u0002\u0000\u0000\u0a94\u0a95\u0005K"+
		"\u0000\u0000\u0a95\u0a9a\u0003\u01be\u00df\u0000\u0a96\u0a97\n\u0001\u0000"+
		"\u0000\u0a97\u0a98\u0005\u001a\u0000\u0000\u0a98\u0a9a\u0003\n\u0005\u0000"+
		"\u0a99\u0a8a\u0001\u0000\u0000\u0000\u0a99\u0a8d\u0001\u0000\u0000\u0000"+
		"\u0a99\u0a90\u0001\u0000\u0000\u0000\u0a99\u0a93\u0001\u0000\u0000\u0000"+
		"\u0a99\u0a96\u0001\u0000\u0000\u0000\u0a9a\u0a9d\u0001\u0000\u0000\u0000"+
		"\u0a9b\u0a99\u0001\u0000\u0000\u0000\u0a9b\u0a9c\u0001\u0000\u0000\u0000"+
		"\u0a9c\u01bd\u0001\u0000\u0000\u0000\u0a9d\u0a9b\u0001\u0000\u0000\u0000"+
		"\u0a9e\u0a9f\u0006\u00df\uffff\uffff\u0000\u0a9f\u0aa0\u0003\u01c0\u00e0"+
		"\u0000\u0aa0\u0ab0\u0001\u0000\u0000\u0000\u0aa1\u0aa2\n\u0003\u0000\u0000"+
		"\u0aa2\u0aa3\u0005D\u0000\u0000\u0aa3\u0aa4\u0005D\u0000\u0000\u0aa4\u0aaf"+
		"\u0003\u01c0\u00e0\u0000\u0aa5\u0aa6\n\u0002\u0000\u0000\u0aa6\u0aa7\u0005"+
		"C\u0000\u0000\u0aa7\u0aa8\u0005C\u0000\u0000\u0aa8\u0aaf\u0003\u01c0\u00e0"+
		"\u0000\u0aa9\u0aaa\n\u0001\u0000\u0000\u0aaa\u0aab\u0005C\u0000\u0000"+
		"\u0aab\u0aac\u0005C\u0000\u0000\u0aac\u0aad\u0005C\u0000\u0000\u0aad\u0aaf"+
		"\u0003\u01c0\u00e0\u0000\u0aae\u0aa1\u0001\u0000\u0000\u0000\u0aae\u0aa5"+
		"\u0001\u0000\u0000\u0000\u0aae\u0aa9\u0001\u0000\u0000\u0000\u0aaf\u0ab2"+
		"\u0001\u0000\u0000\u0000\u0ab0\u0aae\u0001\u0000\u0000\u0000\u0ab0\u0ab1"+
		"\u0001\u0000\u0000\u0000\u0ab1\u01bf\u0001\u0000\u0000\u0000\u0ab2\u0ab0"+
		"\u0001\u0000\u0000\u0000\u0ab3\u0ab4\u0006\u00e0\uffff\uffff\u0000\u0ab4"+
		"\u0ab5\u0003\u01c2\u00e1\u0000\u0ab5\u0abe\u0001\u0000\u0000\u0000\u0ab6"+
		"\u0ab7\n\u0002\u0000\u0000\u0ab7\u0ab8\u0005Q\u0000\u0000\u0ab8\u0abd"+
		"\u0003\u01c2\u00e1\u0000\u0ab9\u0aba\n\u0001\u0000\u0000\u0aba\u0abb\u0005"+
		"R\u0000\u0000\u0abb\u0abd\u0003\u01c2\u00e1\u0000\u0abc\u0ab6\u0001\u0000"+
		"\u0000\u0000\u0abc\u0ab9\u0001\u0000\u0000\u0000\u0abd\u0ac0\u0001\u0000"+
		"\u0000\u0000\u0abe\u0abc\u0001\u0000\u0000\u0000\u0abe\u0abf\u0001\u0000"+
		"\u0000\u0000\u0abf\u01c1\u0001\u0000\u0000\u0000\u0ac0\u0abe\u0001\u0000"+
		"\u0000\u0000\u0ac1\u0ac2\u0006\u00e1\uffff\uffff\u0000\u0ac2\u0ac3\u0003"+
		"\u01c4\u00e2\u0000\u0ac3\u0acf\u0001\u0000\u0000\u0000\u0ac4\u0ac5\n\u0003"+
		"\u0000\u0000\u0ac5\u0ac6\u0005S\u0000\u0000\u0ac6\u0ace\u0003\u01c4\u00e2"+
		"\u0000\u0ac7\u0ac8\n\u0002\u0000\u0000\u0ac8\u0ac9\u0005T\u0000\u0000"+
		"\u0ac9\u0ace\u0003\u01c4\u00e2\u0000\u0aca\u0acb\n\u0001\u0000\u0000\u0acb"+
		"\u0acc\u0005X\u0000\u0000\u0acc\u0ace\u0003\u01c4\u00e2\u0000\u0acd\u0ac4"+
		"\u0001\u0000\u0000\u0000\u0acd\u0ac7\u0001\u0000\u0000\u0000\u0acd\u0aca"+
		"\u0001\u0000\u0000\u0000\u0ace\u0ad1\u0001\u0000\u0000\u0000\u0acf\u0acd"+
		"\u0001\u0000\u0000\u0000\u0acf\u0ad0\u0001\u0000\u0000\u0000\u0ad0\u01c3"+
		"\u0001\u0000\u0000\u0000\u0ad1\u0acf\u0001\u0000\u0000\u0000\u0ad2\u0ada"+
		"\u0003\u01c6\u00e3\u0000\u0ad3\u0ada\u0003\u01c8\u00e4\u0000\u0ad4\u0ad5"+
		"\u0005Q\u0000\u0000\u0ad5\u0ada\u0003\u01c4\u00e2\u0000\u0ad6\u0ad7\u0005"+
		"R\u0000\u0000\u0ad7\u0ada\u0003\u01c4\u00e2\u0000\u0ad8\u0ada\u0003\u01ca"+
		"\u00e5\u0000\u0ad9\u0ad2\u0001\u0000\u0000\u0000\u0ad9\u0ad3\u0001\u0000"+
		"\u0000\u0000\u0ad9\u0ad4\u0001\u0000\u0000\u0000\u0ad9\u0ad6\u0001\u0000"+
		"\u0000\u0000\u0ad9\u0ad8\u0001\u0000\u0000\u0000\u0ada\u01c5\u0001\u0000"+
		"\u0000\u0000\u0adb\u0adc\u0005O\u0000\u0000\u0adc\u0add\u0003\u01c4\u00e2"+
		"\u0000\u0add\u01c7\u0001\u0000\u0000\u0000\u0ade\u0adf\u0005P\u0000\u0000"+
		"\u0adf\u0ae0\u0003\u01c4\u00e2\u0000\u0ae0\u01c9\u0001\u0000\u0000\u0000"+
		"\u0ae1\u0ae8\u0003\u01cc\u00e6\u0000\u0ae2\u0ae3\u0005F\u0000\u0000\u0ae3"+
		"\u0ae8\u0003\u01c4\u00e2\u0000\u0ae4\u0ae5\u0005E\u0000\u0000\u0ae5\u0ae8"+
		"\u0003\u01c4\u00e2\u0000\u0ae6\u0ae8\u0003\u01d6\u00eb\u0000\u0ae7\u0ae1"+
		"\u0001\u0000\u0000\u0000\u0ae7\u0ae2\u0001\u0000\u0000\u0000\u0ae7\u0ae4"+
		"\u0001\u0000\u0000\u0000\u0ae7\u0ae6\u0001\u0000\u0000\u0000\u0ae8\u01cb"+
		"\u0001\u0000\u0000\u0000\u0ae9\u0aec\u0003\u015e\u00af\u0000\u0aea\u0aec"+
		"\u00038\u001c\u0000\u0aeb\u0ae9\u0001\u0000\u0000\u0000\u0aeb\u0aea\u0001"+
		"\u0000\u0000\u0000\u0aec\u0af1\u0001\u0000\u0000\u0000\u0aed\u0af0\u0003"+
		"\u01d0\u00e8\u0000\u0aee\u0af0\u0003\u01d4\u00ea\u0000\u0aef\u0aed\u0001"+
		"\u0000\u0000\u0000\u0aef\u0aee\u0001\u0000\u0000\u0000\u0af0\u0af3\u0001"+
		"\u0000\u0000\u0000\u0af1\u0aef\u0001\u0000\u0000\u0000\u0af1\u0af2\u0001"+
		"\u0000\u0000\u0000\u0af2\u01cd\u0001\u0000\u0000\u0000\u0af3\u0af1\u0001"+
		"\u0000\u0000\u0000\u0af4\u0af5\u0003\u01cc\u00e6\u0000\u0af5\u0af6\u0005"+
		"O\u0000\u0000\u0af6\u01cf\u0001\u0000\u0000\u0000\u0af7\u0af8\u0005O\u0000"+
		"\u0000\u0af8\u01d1\u0001\u0000\u0000\u0000\u0af9\u0afa\u0003\u01cc\u00e6"+
		"\u0000\u0afa\u0afb\u0005P\u0000\u0000\u0afb\u01d3\u0001\u0000\u0000\u0000"+
		"\u0afc\u0afd\u0005P\u0000\u0000\u0afd\u01d5\u0001\u0000\u0000\u0000\u0afe"+
		"\u0aff\u00059\u0000\u0000\u0aff\u0b00\u0003\u0002\u0001\u0000\u0b00\u0b01"+
		"\u0005:\u0000\u0000\u0b01\u0b02\u0003\u01c4\u00e2\u0000\u0b02\u0b1a\u0001"+
		"\u0000\u0000\u0000\u0b03\u0b04\u00059\u0000\u0000\u0b04\u0b08\u0003\n"+
		"\u0005\u0000\u0b05\u0b07\u0003&\u0013\u0000\u0b06\u0b05\u0001\u0000\u0000"+
		"\u0000\u0b07\u0b0a\u0001\u0000\u0000\u0000\u0b08\u0b06\u0001\u0000\u0000"+
		"\u0000\u0b08\u0b09\u0001\u0000\u0000\u0000\u0b09\u0b0b\u0001\u0000\u0000"+
		"\u0000\u0b0a\u0b08\u0001\u0000\u0000\u0000\u0b0b\u0b0c\u0005:\u0000\u0000"+
		"\u0b0c\u0b0d\u0003\u01ca\u00e5\u0000\u0b0d\u0b1a\u0001\u0000\u0000\u0000"+
		"\u0b0e\u0b0f\u00059\u0000\u0000\u0b0f\u0b13\u0003\n\u0005\u0000\u0b10"+
		"\u0b12\u0003&\u0013\u0000\u0b11\u0b10\u0001\u0000\u0000\u0000\u0b12\u0b15"+
		"\u0001\u0000\u0000\u0000\u0b13\u0b11\u0001\u0000\u0000\u0000\u0b13\u0b14"+
		"\u0001\u0000\u0000\u0000\u0b14\u0b16\u0001\u0000\u0000\u0000\u0b15\u0b13"+
		"\u0001\u0000\u0000\u0000\u0b16\u0b17\u0005:\u0000\u0000\u0b17\u0b18\u0003"+
		"\u019e\u00cf\u0000\u0b18\u0b1a\u0001\u0000\u0000\u0000\u0b19\u0afe\u0001"+
		"\u0000\u0000\u0000\u0b19\u0b03\u0001\u0000\u0000\u0000\u0b19\u0b0e\u0001"+
		"\u0000\u0000\u0000\u0b1a\u01d7\u0001\u0000\u0000\u0000\u0142\u01dd\u01e4"+
		"\u01e8\u01ec\u01f5\u01f9\u01fd\u01ff\u0205\u020a\u0211\u0216\u0218\u021e"+
		"\u0223\u0228\u022d\u0238\u0246\u024b\u0253\u025a\u0260\u0265\u0270\u0273"+
		"\u0281\u0286\u028b\u0290\u0296\u02a0\u02a8\u02b2\u02ba\u02c6\u02ca\u02cf"+
		"\u02d5\u02dd\u02ea\u0307\u030b\u0310\u0316\u0319\u031c\u0328\u0333\u0341"+
		"\u0348\u0351\u0358\u035d\u036c\u0373\u0379\u037d\u0381\u0385\u0389\u038e"+
		"\u0392\u0396\u0398\u039d\u03a4\u03a9\u03ab\u03b1\u03b6\u03ba\u03cd\u03d2"+
		"\u03e2\u03e7\u03ed\u03f3\u03f5\u03f9\u03fe\u0402\u040a\u0411\u0419\u041c"+
		"\u0421\u0429\u042e\u0435\u043c\u0441\u0447\u0453\u0458\u045c\u0466\u046b"+
		"\u0473\u0476\u047b\u0483\u0486\u048b\u0490\u0495\u049a\u04a1\u04a6\u04ae"+
		"\u04b3\u04b8\u04bd\u04c3\u04c9\u04cc\u04cf\u04d8\u04de\u04e4\u04e7\u04ea"+
		"\u04f2\u04f7\u04fc\u0502\u0505\u0510\u0519\u0523\u0528\u0533\u0538\u0544"+
		"\u0549\u0555\u055f\u0564\u056c\u056f\u0576\u057e\u0584\u058d\u0597\u059b"+
		"\u059e\u05a7\u05b5\u05b8\u05c1\u05c6\u05cd\u05d2\u05da\u05e6\u05ed\u05fb"+
		"\u0611\u0633\u063f\u0645\u0651\u065e\u0678\u067c\u0681\u0685\u0689\u0691"+
		"\u0695\u0699\u06a0\u06a9\u06b1\u06c0\u06cc\u06d2\u06d8\u06ed\u06f2\u06f8"+
		"\u0704\u070f\u0719\u071c\u0721\u072a\u0730\u073a\u073f\u0748\u075f\u0769"+
		"\u077f\u0786\u078e\u0796\u07a1\u07b8\u07c2\u07cd\u07e3\u07e7\u07ec\u07f4"+
		"\u07fa\u07fe\u0802\u0806\u080c\u0811\u0816\u081a\u081e\u0824\u0829\u082e"+
		"\u0832\u0836\u0838\u083d\u0842\u0847\u084b\u084f\u0853\u0858\u0860\u0866"+
		"\u086a\u086e\u0872\u0878\u087d\u0882\u0886\u088a\u088c\u0891\u08a0\u08ae"+
		"\u08ba\u08c3\u08d2\u08df\u08e8\u08ee\u08f5\u08fa\u0901\u0906\u090d\u0912"+
		"\u0919\u091e\u0926\u092b\u092f\u0933\u0938\u093f\u0946\u094b\u0952\u0957"+
		"\u095e\u0963\u096b\u0970\u0974\u097b\u0981\u0988\u098f\u0996\u099e\u09a5"+
		"\u09ad\u09b1\u09b8\u09bf\u09c6\u09ce\u09d5\u09dd\u09e3\u09e9\u09f5\u09fb"+
		"\u0a01\u0a0c\u0a15\u0a1c\u0a23\u0a28\u0a2c\u0a35\u0a40\u0a4a\u0a55\u0a60"+
		"\u0a6b\u0a76\u0a82\u0a84\u0a99\u0a9b\u0aae\u0ab0\u0abc\u0abe\u0acd\u0acf"+
		"\u0ad9\u0ae7\u0aeb\u0aef\u0af1\u0b08\u0b13\u0b19";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
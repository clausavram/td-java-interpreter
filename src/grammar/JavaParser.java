// Generated from E:/Documents/Java Projects/Java_Projects_year4/TranslatorDesign/ANTLRTranslatorDesignProject/src\Java.g4 by ANTLR 4.4.1-dev
package grammar;

import structure.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, PACKAGE=4, IMPORT=5, CLASS=6, PACKAGE_NAME=7, 
		IDENTIFIER=8, WORD=9, LETTER=10, DIGIT=11, LINE_COMMENT=12, WS=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "'}'", "';'", "'package'", "'import'", "'class'", 
		"PACKAGE_NAME", "IDENTIFIER", "WORD", "LETTER", "DIGIT", "LINE_COMMENT", 
		"WS"
	};
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_package_statement = 2, RULE_import_statement = 3, 
		RULE_class_statement = 4;
	public static final String[] ruleNames = {
		"start", "program", "package_statement", "import_statement", "class_statement"
	};

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public JavaProgram value;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Import_statementContext import_statement(int i) {
			return getRuleContext(Import_statementContext.class,i);
		}
		public List<Class_statementContext> class_statement() {
			return getRuleContexts(Class_statementContext.class);
		}
		public Class_statementContext class_statement(int i) {
			return getRuleContext(Class_statementContext.class,i);
		}
		public Package_statementContext package_statement() {
			return getRuleContext(Package_statementContext.class,0);
		}
		public List<Import_statementContext> import_statement() {
			return getRuleContexts(Import_statementContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(12); package_statement();
				}
			}

			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(15); import_statement();
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(21); class_statement();
				}
				}
				setState(26);
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

	public static class Package_statementContext extends ParserRuleContext {
		public Token x;
		public TerminalNode PACKAGE_NAME(int i) {
			return getToken(JavaParser.PACKAGE_NAME, i);
		}
		public List<TerminalNode> PACKAGE_NAME() { return getTokens(JavaParser.PACKAGE_NAME); }
		public List<TerminalNode> PACKAGE() { return getTokens(JavaParser.PACKAGE); }
		public TerminalNode PACKAGE(int i) {
			return getToken(JavaParser.PACKAGE, i);
		}
		public Package_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterPackage_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitPackage_statement(this);
		}
	}

	public final Package_statementContext package_statement() throws RecognitionException {
		Package_statementContext _localctx = new Package_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_package_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27); match(PACKAGE);
				setState(28); ((Package_statementContext)_localctx).x = match(PACKAGE_NAME);
				setState(29); match(T__0);
				System.out.println("package: " + (((Package_statementContext)_localctx).x!=null?((Package_statementContext)_localctx).x.getText():null));
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PACKAGE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Import_statementContext extends ParserRuleContext {
		public Token x;
		public TerminalNode IMPORT() { return getToken(JavaParser.IMPORT, 0); }
		public TerminalNode PACKAGE_NAME() { return getToken(JavaParser.PACKAGE_NAME, 0); }
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitImport_statement(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(IMPORT);
			setState(36); ((Import_statementContext)_localctx).x = match(PACKAGE_NAME);
			setState(37); match(T__0);
			System.out.println("import: " + (((Import_statementContext)_localctx).x!=null?((Import_statementContext)_localctx).x.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_statementContext extends ParserRuleContext {
		public Token name;
		public TerminalNode WORD() { return getToken(JavaParser.WORD, 0); }
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public Class_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).enterClass_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JavaListener ) ((JavaListener)listener).exitClass_statement(this);
		}
	}

	public final Class_statementContext class_statement() throws RecognitionException {
		Class_statementContext _localctx = new Class_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_class_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); match(CLASS);
			setState(41); ((Class_statementContext)_localctx).name = match(WORD);
			setState(42); match(T__2);
			System.out.println("class: " + (((Class_statementContext)_localctx).name!=null?((Class_statementContext)_localctx).name.getText():null));
			setState(44); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\5\3\20\n\3\3\3\7\3\23\n\3\f\3"+
		"\16\3\26\13\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\4\3\4\3\4\3\4\6\4\"\n"+
		"\4\r\4\16\4#\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\2\2\7\2\4"+
		"\6\b\n\2\2/\2\f\3\2\2\2\4\17\3\2\2\2\6!\3\2\2\2\b%\3\2\2\2\n*\3\2\2\2"+
		"\f\r\5\4\3\2\r\3\3\2\2\2\16\20\5\6\4\2\17\16\3\2\2\2\17\20\3\2\2\2\20"+
		"\24\3\2\2\2\21\23\5\b\5\2\22\21\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24"+
		"\25\3\2\2\2\25\32\3\2\2\2\26\24\3\2\2\2\27\31\5\n\6\2\30\27\3\2\2\2\31"+
		"\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\5\3\2\2\2\34\32\3\2\2\2\35"+
		"\36\7\6\2\2\36\37\7\t\2\2\37 \7\5\2\2 \"\b\4\1\2!\35\3\2\2\2\"#\3\2\2"+
		"\2#!\3\2\2\2#$\3\2\2\2$\7\3\2\2\2%&\7\7\2\2&\'\7\t\2\2\'(\7\5\2\2()\b"+
		"\5\1\2)\t\3\2\2\2*+\7\b\2\2+,\7\13\2\2,-\7\3\2\2-.\b\6\1\2./\7\4\2\2/"+
		"\13\3\2\2\2\6\17\24\32#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from E:/Documents/Java Projects/Java_Projects_year4/TranslatorDesign/ANTLRTranslatorDesignProject/src\Java.g4 by ANTLR 4.4.1-dev
package grammar;

import structure.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, PACKAGE=4, IMPORT=5, CLASS=6, PACKAGE_NAME=7, 
		IDENTIFIER=8, WORD=9, LETTER=10, DIGIT=11, LINE_COMMENT=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "PACKAGE", "IMPORT", "CLASS", "PACKAGE_NAME", 
		"IDENTIFIER", "WORD", "LETTER", "DIGIT", "LINE_COMMENT", "WS"
	};


	public JavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Java.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17h\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\b\3\b\5\bC\n\b\3\t\3\t\7\tG\n\t\f"+
		"\t\16\tJ\13\t\3\n\6\nM\n\n\r\n\16\nN\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\7\rY\n\r\f\r\16\r\\\13\r\3\r\3\r\3\r\3\r\3\16\6\16c\n\16\r\16\16\16d"+
		"\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\3\2\b\5\2C\\aac|\6\2\62;C\\aac|\4\2C\\c|\3\2\62;\3\2\f\f\5\2"+
		"\13\f\17\17\"\"m\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7"+
		"!\3\2\2\2\t#\3\2\2\2\13+\3\2\2\2\r\62\3\2\2\2\178\3\2\2\2\21D\3\2\2\2"+
		"\23L\3\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31T\3\2\2\2\33b\3\2\2\2\35\36\7}"+
		"\2\2\36\4\3\2\2\2\37 \7\177\2\2 \6\3\2\2\2!\"\7=\2\2\"\b\3\2\2\2#$\7r"+
		"\2\2$%\7c\2\2%&\7e\2\2&\'\7m\2\2\'(\7c\2\2()\7i\2\2)*\7g\2\2*\n\3\2\2"+
		"\2+,\7k\2\2,-\7o\2\2-.\7r\2\2./\7q\2\2/\60\7t\2\2\60\61\7v\2\2\61\f\3"+
		"\2\2\2\62\63\7e\2\2\63\64\7n\2\2\64\65\7c\2\2\65\66\7u\2\2\66\67\7u\2"+
		"\2\67\16\3\2\2\28=\5\23\n\29:\7\60\2\2:<\5\23\n\2;9\3\2\2\2<?\3\2\2\2"+
		"=;\3\2\2\2=>\3\2\2\2>B\3\2\2\2?=\3\2\2\2@A\7\60\2\2AC\7,\2\2B@\3\2\2\2"+
		"BC\3\2\2\2C\20\3\2\2\2DH\t\2\2\2EG\t\3\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2"+
		"\2HI\3\2\2\2I\22\3\2\2\2JH\3\2\2\2KM\5\25\13\2LK\3\2\2\2MN\3\2\2\2NL\3"+
		"\2\2\2NO\3\2\2\2O\24\3\2\2\2PQ\t\4\2\2Q\26\3\2\2\2RS\t\5\2\2S\30\3\2\2"+
		"\2TU\7\61\2\2UV\7\61\2\2VZ\3\2\2\2WY\n\6\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3"+
		"\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\f\2\2^_\3\2\2\2_`\b\r\2\2`\32"+
		"\3\2\2\2ac\t\7\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2f"+
		"g\b\16\2\2g\34\3\2\2\2\t\2=BHNZd\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
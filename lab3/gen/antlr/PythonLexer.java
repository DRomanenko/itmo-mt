// Generated from C:/Users/mrnea/IdeaProjects/itmo-mt/lab3/src/main/java/antlr\Python.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, INPUT=3, OUTPUT=4, ASSIGNMENT=5, LITERAL=6, NAME=7, COLON=8, 
		LPAREN=9, RPAREN=10, PLUS=11, MINUS=12, MUL=13, DIV=14, EQ=15, NEQ=16, 
		GT=17, LT=18, GEQ=19, LEQ=20, TAB=21, WHITESPACE=22, LINESEPARATOR=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "INPUT", "OUTPUT", "ASSIGNMENT", "LITERAL", "NAME", "COLON", 
			"LPAREN", "RPAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", "GT", 
			"LT", "GEQ", "LEQ", "TAB", "WHITESPACE", "LINESEPARATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'int(input())'", "'print'", "'='", null, null, 
			"':'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", 
			"'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "INPUT", "OUTPUT", "ASSIGNMENT", "LITERAL", "NAME", 
			"COLON", "LPAREN", "RPAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", 
			"GT", "LT", "GEQ", "LEQ", "TAB", "WHITESPACE", "LINESEPARATOR"
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


	public PythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Python.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\6\7P\n\7\r\7\16\7Q\3\b"+
		"\3\b\7\bV\n\b\f\b\16\bY\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\6\27|\n\27\r\27\16\27}\3"+
		"\27\3\27\3\30\6\30\u0083\n\30\r\30\16\30\u0084\2\2\31\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\3\2\13\13"+
		"\4\2\f\f\17\17\2\u0089\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\64\3\2\2\2\79\3\2\2\2\tF\3\2\2"+
		"\2\13L\3\2\2\2\rO\3\2\2\2\17S\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2"+
		"\2\2\27`\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!k\3\2"+
		"\2\2#n\3\2\2\2%p\3\2\2\2\'r\3\2\2\2)u\3\2\2\2+x\3\2\2\2-{\3\2\2\2/\u0082"+
		"\3\2\2\2\61\62\7k\2\2\62\63\7h\2\2\63\4\3\2\2\2\64\65\7g\2\2\65\66\7n"+
		"\2\2\66\67\7u\2\2\678\7g\2\28\6\3\2\2\29:\7k\2\2:;\7p\2\2;<\7v\2\2<=\7"+
		"*\2\2=>\7k\2\2>?\7p\2\2?@\7r\2\2@A\7w\2\2AB\7v\2\2BC\7*\2\2CD\7+\2\2D"+
		"E\7+\2\2E\b\3\2\2\2FG\7r\2\2GH\7t\2\2HI\7k\2\2IJ\7p\2\2JK\7v\2\2K\n\3"+
		"\2\2\2LM\7?\2\2M\f\3\2\2\2NP\t\2\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3"+
		"\2\2\2R\16\3\2\2\2SW\t\3\2\2TV\t\4\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2W"+
		"X\3\2\2\2X\20\3\2\2\2YW\3\2\2\2Z[\7<\2\2[\22\3\2\2\2\\]\7*\2\2]\24\3\2"+
		"\2\2^_\7+\2\2_\26\3\2\2\2`a\7-\2\2a\30\3\2\2\2bc\7/\2\2c\32\3\2\2\2de"+
		"\7,\2\2e\34\3\2\2\2fg\7\61\2\2g\36\3\2\2\2hi\7?\2\2ij\7?\2\2j \3\2\2\2"+
		"kl\7#\2\2lm\7?\2\2m\"\3\2\2\2no\7@\2\2o$\3\2\2\2pq\7>\2\2q&\3\2\2\2rs"+
		"\7@\2\2st\7?\2\2t(\3\2\2\2uv\7>\2\2vw\7?\2\2w*\3\2\2\2xy\t\5\2\2y,\3\2"+
		"\2\2z|\7\"\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177"+
		"\u0080\b\27\2\2\u0080.\3\2\2\2\u0081\u0083\t\6\2\2\u0082\u0081\3\2\2\2"+
		"\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\60"+
		"\3\2\2\2\7\2QW}\u0084\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
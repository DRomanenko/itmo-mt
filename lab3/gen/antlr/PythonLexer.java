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
		IF=1, ELSE=2, ELIF=3, WHILE=4, INPUT=5, OUTPUT=6, ASSIGNMENT=7, LITERAL=8, 
		NAME=9, COLON=10, LPAREN=11, RPAREN=12, PLUS=13, MINUS=14, MUL=15, DIV=16, 
		EQ=17, NEQ=18, GT=19, LT=20, GEQ=21, LEQ=22, TAB=23, WHITESPACE=24, LINESEPARATOR=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "ELIF", "WHILE", "INPUT", "OUTPUT", "ASSIGNMENT", "LITERAL", 
			"NAME", "COLON", "LPAREN", "RPAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", 
			"NEQ", "GT", "LT", "GEQ", "LEQ", "TAB", "WHITESPACE", "LINESEPARATOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'elif'", "'while'", "'int(input())'", "'print'", 
			"'='", null, null, "':'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'=='", 
			"'!='", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "ELIF", "WHILE", "INPUT", "OUTPUT", "ASSIGNMENT", 
			"LITERAL", "NAME", "COLON", "LPAREN", "RPAREN", "PLUS", "MINUS", "MUL", 
			"DIV", "EQ", "NEQ", "GT", "LT", "GEQ", "LEQ", "TAB", "WHITESPACE", "LINESEPARATOR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\t_\n\t\r\t\16\t`\3\n\3\n\7"+
		"\ne\n\n\f\n\16\nh\13\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\6\31\u008b\n\31\r\31\16\31"+
		"\u008c\3\31\3\31\3\32\6\32\u0092\n\32\r\32\16\32\u0093\2\2\33\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\7\3\2\62;\5\2C\\aac|\6\2"+
		"\62;C\\aac|\3\2\13\13\4\2\f\f\17\17\2\u0098\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\3\65\3\2\2\2\58\3\2\2\2\7=\3\2\2\2\tB\3\2\2\2\13H\3\2\2\2\rU\3\2\2"+
		"\2\17[\3\2\2\2\21^\3\2\2\2\23b\3\2\2\2\25i\3\2\2\2\27k\3\2\2\2\31m\3\2"+
		"\2\2\33o\3\2\2\2\35q\3\2\2\2\37s\3\2\2\2!u\3\2\2\2#w\3\2\2\2%z\3\2\2\2"+
		"\'}\3\2\2\2)\177\3\2\2\2+\u0081\3\2\2\2-\u0084\3\2\2\2/\u0087\3\2\2\2"+
		"\61\u008a\3\2\2\2\63\u0091\3\2\2\2\65\66\7k\2\2\66\67\7h\2\2\67\4\3\2"+
		"\2\289\7g\2\29:\7n\2\2:;\7u\2\2;<\7g\2\2<\6\3\2\2\2=>\7g\2\2>?\7n\2\2"+
		"?@\7k\2\2@A\7h\2\2A\b\3\2\2\2BC\7y\2\2CD\7j\2\2DE\7k\2\2EF\7n\2\2FG\7"+
		"g\2\2G\n\3\2\2\2HI\7k\2\2IJ\7p\2\2JK\7v\2\2KL\7*\2\2LM\7k\2\2MN\7p\2\2"+
		"NO\7r\2\2OP\7w\2\2PQ\7v\2\2QR\7*\2\2RS\7+\2\2ST\7+\2\2T\f\3\2\2\2UV\7"+
		"r\2\2VW\7t\2\2WX\7k\2\2XY\7p\2\2YZ\7v\2\2Z\16\3\2\2\2[\\\7?\2\2\\\20\3"+
		"\2\2\2]_\t\2\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\22\3\2\2\2b"+
		"f\t\3\2\2ce\t\4\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\24\3\2\2"+
		"\2hf\3\2\2\2ij\7<\2\2j\26\3\2\2\2kl\7*\2\2l\30\3\2\2\2mn\7+\2\2n\32\3"+
		"\2\2\2op\7-\2\2p\34\3\2\2\2qr\7/\2\2r\36\3\2\2\2st\7,\2\2t \3\2\2\2uv"+
		"\7\61\2\2v\"\3\2\2\2wx\7?\2\2xy\7?\2\2y$\3\2\2\2z{\7#\2\2{|\7?\2\2|&\3"+
		"\2\2\2}~\7@\2\2~(\3\2\2\2\177\u0080\7>\2\2\u0080*\3\2\2\2\u0081\u0082"+
		"\7@\2\2\u0082\u0083\7?\2\2\u0083,\3\2\2\2\u0084\u0085\7>\2\2\u0085\u0086"+
		"\7?\2\2\u0086.\3\2\2\2\u0087\u0088\t\5\2\2\u0088\60\3\2\2\2\u0089\u008b"+
		"\7\"\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\31\2\2\u008f\62\3\2\2"+
		"\2\u0090\u0092\t\6\2\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0093\u0094\3\2\2\2\u0094\64\3\2\2\2\7\2`f\u008c\u0093\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
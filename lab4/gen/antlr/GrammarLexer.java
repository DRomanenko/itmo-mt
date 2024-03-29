// Generated from C:/Users/mrnea/work/itmo-mt/lab4/src/main/java/antlr\Grammar.g4 by ANTLR 4.9.1
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
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, TERM=14, NON_TERM=15, REGEX=16, 
		STRING=17, CODE=18, PCKG_NAME=19, WHITESPACE=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "TERM", "NON_TERM", "REGEX", "STRING", 
			"CODE", "PCKG_NAME", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|-'", "'+p'", "';'", "':'", "':='", "'|'", "'<'", "','", "'>'", 
			"'('", "')'", "'='", "'=>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "TERM", "NON_TERM", "REGEX", "STRING", "CODE", "PCKG_NAME", 
			"WHITESPACE"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0089\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\7\17L\n\17\f\17\16\17O\13\17\3\20\3\20"+
		"\7\20S\n\20\f\20\16\20V\13\20\3\21\3\21\3\21\3\21\7\21\\\n\21\f\21\16"+
		"\21_\13\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22g\n\22\f\22\16\22j\13\22"+
		"\3\22\3\22\3\23\3\23\6\23p\n\23\r\23\16\23q\3\23\5\23u\n\23\7\23w\n\23"+
		"\f\23\16\23z\13\23\3\23\3\23\3\24\6\24\177\n\24\r\24\16\24\u0080\3\25"+
		"\6\25\u0084\n\25\r\25\16\25\u0085\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26\3\2\n\3\2C\\\5\2\62;C\\c|\3\2c|\5\2\f\f\17\17))\3\2$$\4\2}}\177"+
		"\177\5\2\60\60\62;c|\5\2\13\f\17\17\"\"\2\u0093\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5.\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65"+
		"\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21<\3\2\2\2\23>\3\2\2\2\25@\3\2\2\2\27"+
		"B\3\2\2\2\31D\3\2\2\2\33F\3\2\2\2\35I\3\2\2\2\37P\3\2\2\2!W\3\2\2\2#b"+
		"\3\2\2\2%m\3\2\2\2\'~\3\2\2\2)\u0083\3\2\2\2+,\7~\2\2,-\7/\2\2-\4\3\2"+
		"\2\2./\7-\2\2/\60\7r\2\2\60\6\3\2\2\2\61\62\7=\2\2\62\b\3\2\2\2\63\64"+
		"\7<\2\2\64\n\3\2\2\2\65\66\7<\2\2\66\67\7?\2\2\67\f\3\2\2\289\7~\2\29"+
		"\16\3\2\2\2:;\7>\2\2;\20\3\2\2\2<=\7.\2\2=\22\3\2\2\2>?\7@\2\2?\24\3\2"+
		"\2\2@A\7*\2\2A\26\3\2\2\2BC\7+\2\2C\30\3\2\2\2DE\7?\2\2E\32\3\2\2\2FG"+
		"\7?\2\2GH\7@\2\2H\34\3\2\2\2IM\t\2\2\2JL\t\3\2\2KJ\3\2\2\2LO\3\2\2\2M"+
		"K\3\2\2\2MN\3\2\2\2N\36\3\2\2\2OM\3\2\2\2PT\t\4\2\2QS\t\3\2\2RQ\3\2\2"+
		"\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2U \3\2\2\2VT\3\2\2\2W]\7)\2\2X\\\n\5\2"+
		"\2YZ\7^\2\2Z\\\7)\2\2[X\3\2\2\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2"+
		"\2^`\3\2\2\2_]\3\2\2\2`a\7)\2\2a\"\3\2\2\2bh\7$\2\2cg\n\6\2\2de\7^\2\2"+
		"eg\7$\2\2fc\3\2\2\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2ik\3\2\2\2"+
		"jh\3\2\2\2kl\7$\2\2l$\3\2\2\2mx\7}\2\2np\n\7\2\2on\3\2\2\2pq\3\2\2\2q"+
		"o\3\2\2\2qr\3\2\2\2rt\3\2\2\2su\5%\23\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vo\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\177\2"+
		"\2|&\3\2\2\2}\177\t\b\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081(\3\2\2\2\u0082\u0084\t\t\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\u0088\b\25\2\2\u0088*\3\2\2\2\17\2MT[]fhqtx~\u0080\u0085"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
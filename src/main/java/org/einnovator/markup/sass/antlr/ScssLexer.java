package org.einnovator.markup.sass.antlr;

// Generated from ScssLexer.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScssLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NULL=1, IN=2, Unit=3, COMBINE_COMPARE=4, Ellipsis=5, InterpolationStart=6, 
		LPAREN=7, RPAREN=8, BlockStart=9, BlockEnd=10, LBRACK=11, RBRACK=12, GT=13, 
		TIL=14, LT=15, COLON=16, SEMI=17, COMMA=18, DOT=19, DOLLAR=20, AT=21, 
		AND=22, HASH=23, COLONCOLON=24, PLUS=25, TIMES=26, DIV=27, MINUS=28, PERC=29, 
		UrlStart=30, EQEQ=31, NOTEQ=32, EQ=33, PIPE_EQ=34, TILD_EQ=35, MIXIN=36, 
		FUNCTION=37, AT_ELSE=38, IF=39, AT_IF=40, AT_FOR=41, AT_WHILE=42, AT_EACH=43, 
		INCLUDE=44, IMPORT=45, RETURN=46, FROM=47, THROUGH=48, POUND_DEFAULT=49, 
		Identifier=50, StringLiteral=51, Number=52, Color=53, WS=54, SL_COMMENT=55, 
		COMMENT=56, UrlEnd=57, Url=58, SPACE=59, InterpolationStartAfter=60, IdentifierAfter=61;
	public static final int
		URL_STARTED=1, IDENTIFY=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "URL_STARTED", "IDENTIFY"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NULL", "IN", "Unit", "COMBINE_COMPARE", "Ellipsis", "InterpolationStart", 
			"LPAREN", "RPAREN", "BlockStart", "BlockEnd", "LBRACK", "RBRACK", "GT", 
			"TIL", "LT", "COLON", "SEMI", "COMMA", "DOT", "DOLLAR", "AT", "AND", 
			"HASH", "COLONCOLON", "PLUS", "TIMES", "DIV", "MINUS", "PERC", "UrlStart", 
			"EQEQ", "NOTEQ", "EQ", "PIPE_EQ", "TILD_EQ", "MIXIN", "FUNCTION", "AT_ELSE", 
			"IF", "AT_IF", "AT_FOR", "AT_WHILE", "AT_EACH", "INCLUDE", "IMPORT", 
			"RETURN", "FROM", "THROUGH", "POUND_DEFAULT", "Identifier", "STRING", 
			"StringLiteral", "Number", "Color", "WS", "SL_COMMENT", "COMMENT", "UrlEnd", 
			"Url", "BlockStart_ID", "SPACE", "DOLLAR_ID", "InterpolationStartAfter", 
			"InterpolationEnd_ID", "IdentifierAfter", "Ellipsis_ID", "DOT_ID", "LPAREN_ID", 
			"RPAREN_ID", "COLON_ID", "COMMA_ID", "SEMI_ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'null'", "'in'", null, null, "'...'", null, "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "'>'", "'~'", "'<'", "':'", "';'", "','", "'.'", 
			"'$'", "'@'", "'&'", "'#'", "'::'", "'+'", "'*'", "'/'", "'-'", "'%'", 
			null, "'=='", "'!='", "'='", "'|='", "'~='", "'@mixin'", "'@function'", 
			"'@else'", "'if'", "'@if'", "'@for'", "'@while'", "'@each'", "'@include'", 
			"'@import'", "'@return'", "'from'", "'through'", "'!default'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NULL", "IN", "Unit", "COMBINE_COMPARE", "Ellipsis", "InterpolationStart", 
			"LPAREN", "RPAREN", "BlockStart", "BlockEnd", "LBRACK", "RBRACK", "GT", 
			"TIL", "LT", "COLON", "SEMI", "COMMA", "DOT", "DOLLAR", "AT", "AND", 
			"HASH", "COLONCOLON", "PLUS", "TIMES", "DIV", "MINUS", "PERC", "UrlStart", 
			"EQEQ", "NOTEQ", "EQ", "PIPE_EQ", "TILD_EQ", "MIXIN", "FUNCTION", "AT_ELSE", 
			"IF", "AT_IF", "AT_FOR", "AT_WHILE", "AT_EACH", "INCLUDE", "IMPORT", 
			"RETURN", "FROM", "THROUGH", "POUND_DEFAULT", "Identifier", "StringLiteral", 
			"Number", "Color", "WS", "SL_COMMENT", "COMMENT", "UrlEnd", "Url", "SPACE", 
			"InterpolationStartAfter", "IdentifierAfter"
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


	public ScssLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ScssLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u022f\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00c1\n\4\3\5\3\5\3\5\3"+
		"\5\5\5\u00c7\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3."+
		"\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\63\3\63\7\63\u0178\n\63\f\63\16\63\u017b\13\63\3\63\3\63\3\63\7\63"+
		"\u0180\n\63\f\63\16\63\u0183\13\63\5\63\u0185\n\63\3\63\3\63\3\64\3\64"+
		"\7\64\u018b\n\64\f\64\16\64\u018e\13\64\3\64\3\64\3\64\7\64\u0193\n\64"+
		"\f\64\16\64\u0196\13\64\3\64\5\64\u0199\n\64\3\65\3\65\3\66\3\66\7\66"+
		"\u019f\n\66\f\66\16\66\u01a2\13\66\3\66\5\66\u01a5\n\66\3\66\6\66\u01a8"+
		"\n\66\r\66\16\66\u01a9\3\66\7\66\u01ad\n\66\f\66\16\66\u01b0\13\66\3\66"+
		"\5\66\u01b3\n\66\3\66\6\66\u01b6\n\66\r\66\16\66\u01b7\5\66\u01ba\n\66"+
		"\3\67\3\67\6\67\u01be\n\67\r\67\16\67\u01bf\38\38\38\68\u01c5\n8\r8\16"+
		"8\u01c6\38\38\39\39\39\39\79\u01cf\n9\f9\169\u01d2\139\39\39\39\59\u01d7"+
		"\n9\59\u01d9\n9\39\39\3:\3:\3:\3:\7:\u01e1\n:\f:\16:\u01e4\13:\3:\3:\3"+
		":\3:\3:\3;\3;\3;\3;\3<\3<\6<\u01f1\n<\r<\16<\u01f2\5<\u01f5\n<\3=\3=\3"+
		"=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3A\3A\3A\3A\3B\3B\3C\3C\3C\3"+
		"C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3H\3"+
		"H\3H\3H\3H\3I\3I\3I\3I\3I\3\u01e2\2J\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23"+
		"\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30"+
		"\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]"+
		"/_\60a\61c\62e\63g\64i\2k\65m\66o\67q8s9u:w;y<{\2}=\177\2\u0081>\u0083"+
		"\2\u0085?\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\5\2"+
		"\3\4\n\6\2C\\aac|\u0102\0\b\2//\62;C\\aac|\u0102\0\5\2\f\f\17\17$$\5\2"+
		"\f\f\17\17))\5\2\62;CHch\5\2\13\f\17\17\"\"\4\2\f\f\17\17\6\2\f\f\17\17"+
		"++==\2\u0251\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\3y\3\2\2\2\4{\3\2\2\2\4"+
		"}\3\2\2\2\4\177\3\2\2\2\4\u0081\3\2\2\2\4\u0083\3\2\2\2\4\u0085\3\2\2"+
		"\2\4\u0087\3\2\2\2\4\u0089\3\2\2\2\4\u008b\3\2\2\2\4\u008d\3\2\2\2\4\u008f"+
		"\3\2\2\2\4\u0091\3\2\2\2\4\u0093\3\2\2\2\5\u0095\3\2\2\2\7\u009a\3\2\2"+
		"\2\t\u00c0\3\2\2\2\13\u00c6\3\2\2\2\r\u00c8\3\2\2\2\17\u00cc\3\2\2\2\21"+
		"\u00d1\3\2\2\2\23\u00d3\3\2\2\2\25\u00d5\3\2\2\2\27\u00d7\3\2\2\2\31\u00d9"+
		"\3\2\2\2\33\u00db\3\2\2\2\35\u00dd\3\2\2\2\37\u00df\3\2\2\2!\u00e1\3\2"+
		"\2\2#\u00e3\3\2\2\2%\u00e5\3\2\2\2\'\u00e7\3\2\2\2)\u00e9\3\2\2\2+\u00eb"+
		"\3\2\2\2-\u00ed\3\2\2\2/\u00ef\3\2\2\2\61\u00f1\3\2\2\2\63\u00f3\3\2\2"+
		"\2\65\u00f6\3\2\2\2\67\u00f8\3\2\2\29\u00fa\3\2\2\2;\u00fc\3\2\2\2=\u00fe"+
		"\3\2\2\2?\u0100\3\2\2\2A\u0108\3\2\2\2C\u010b\3\2\2\2E\u010e\3\2\2\2G"+
		"\u0110\3\2\2\2I\u0113\3\2\2\2K\u0116\3\2\2\2M\u011d\3\2\2\2O\u0127\3\2"+
		"\2\2Q\u012d\3\2\2\2S\u0130\3\2\2\2U\u0134\3\2\2\2W\u0139\3\2\2\2Y\u0140"+
		"\3\2\2\2[\u0146\3\2\2\2]\u014f\3\2\2\2_\u0157\3\2\2\2a\u015f\3\2\2\2c"+
		"\u0164\3\2\2\2e\u016c\3\2\2\2g\u0184\3\2\2\2i\u0198\3\2\2\2k\u019a\3\2"+
		"\2\2m\u01b9\3\2\2\2o\u01bb\3\2\2\2q\u01c4\3\2\2\2s\u01ca\3\2\2\2u\u01dc"+
		"\3\2\2\2w\u01ea\3\2\2\2y\u01f4\3\2\2\2{\u01f6\3\2\2\2}\u01fb\3\2\2\2\177"+
		"\u0200\3\2\2\2\u0081\u0204\3\2\2\2\u0083\u0206\3\2\2\2\u0085\u020a\3\2"+
		"\2\2\u0087\u020c\3\2\2\2\u0089\u0211\3\2\2\2\u008b\u0216\3\2\2\2\u008d"+
		"\u021b\3\2\2\2\u008f\u0220\3\2\2\2\u0091\u0225\3\2\2\2\u0093\u022a\3\2"+
		"\2\2\u0095\u0096\7p\2\2\u0096\u0097\7w\2\2\u0097\u0098\7n\2\2\u0098\u0099"+
		"\7n\2\2\u0099\6\3\2\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\b"+
		"\3\2\2\2\u009d\u00c1\7\'\2\2\u009e\u009f\7r\2\2\u009f\u00c1\7z\2\2\u00a0"+
		"\u00a1\7e\2\2\u00a1\u00c1\7o\2\2\u00a2\u00a3\7o\2\2\u00a3\u00c1\7o\2\2"+
		"\u00a4\u00a5\7k\2\2\u00a5\u00c1\7p\2\2\u00a6\u00a7\7r\2\2\u00a7\u00c1"+
		"\7v\2\2\u00a8\u00a9\7r\2\2\u00a9\u00c1\7e\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00c1\7o\2\2\u00ac\u00ad\7g\2\2\u00ad\u00c1\7z\2\2\u00ae\u00af\7f\2\2"+
		"\u00af\u00b0\7g\2\2\u00b0\u00c1\7i\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3"+
		"\7c\2\2\u00b3\u00c1\7f\2\2\u00b4\u00b5\7i\2\2\u00b5\u00b6\7t\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00c1\7f\2\2\u00b8\u00b9\7o\2\2\u00b9\u00c1\7u\2\2"+
		"\u00ba\u00c1\7u\2\2\u00bb\u00bc\7j\2\2\u00bc\u00c1\7|\2\2\u00bd\u00be"+
		"\7m\2\2\u00be\u00bf\7j\2\2\u00bf\u00c1\7|\2\2\u00c0\u009d\3\2\2\2\u00c0"+
		"\u009e\3\2\2\2\u00c0\u00a0\3\2\2\2\u00c0\u00a2\3\2\2\2\u00c0\u00a4\3\2"+
		"\2\2\u00c0\u00a6\3\2\2\2\u00c0\u00a8\3\2\2\2\u00c0\u00aa\3\2\2\2\u00c0"+
		"\u00ac\3\2\2\2\u00c0\u00ae\3\2\2\2\u00c0\u00b1\3\2\2\2\u00c0\u00b4\3\2"+
		"\2\2\u00c0\u00b8\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c0\u00bb\3\2\2\2\u00c0"+
		"\u00bd\3\2\2\2\u00c1\n\3\2\2\2\u00c2\u00c3\7(\2\2\u00c3\u00c7\7(\2\2\u00c4"+
		"\u00c5\7~\2\2\u00c5\u00c7\7~\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c4\3\2\2"+
		"\2\u00c7\f\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\u00ca\7\60\2\2\u00ca\u00cb"+
		"\7\60\2\2\u00cb\16\3\2\2\2\u00cc\u00cd\5\61\30\2\u00cd\u00ce\5\25\n\2"+
		"\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\7\2\2\u00d0\20\3\2\2\2\u00d1\u00d2"+
		"\7*\2\2\u00d2\22\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4\24\3\2\2\2\u00d5\u00d6"+
		"\7}\2\2\u00d6\26\3\2\2\2\u00d7\u00d8\7\177\2\2\u00d8\30\3\2\2\2\u00d9"+
		"\u00da\7]\2\2\u00da\32\3\2\2\2\u00db\u00dc\7_\2\2\u00dc\34\3\2\2\2\u00dd"+
		"\u00de\7@\2\2\u00de\36\3\2\2\2\u00df\u00e0\7\u0080\2\2\u00e0 \3\2\2\2"+
		"\u00e1\u00e2\7>\2\2\u00e2\"\3\2\2\2\u00e3\u00e4\7<\2\2\u00e4$\3\2\2\2"+
		"\u00e5\u00e6\7=\2\2\u00e6&\3\2\2\2\u00e7\u00e8\7.\2\2\u00e8(\3\2\2\2\u00e9"+
		"\u00ea\7\60\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7&\2\2\u00ec,\3\2\2\2\u00ed"+
		"\u00ee\7B\2\2\u00ee.\3\2\2\2\u00ef\u00f0\7(\2\2\u00f0\60\3\2\2\2\u00f1"+
		"\u00f2\7%\2\2\u00f2\62\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4\u00f5\7<\2\2\u00f5"+
		"\64\3\2\2\2\u00f6\u00f7\7-\2\2\u00f7\66\3\2\2\2\u00f8\u00f9\7,\2\2\u00f9"+
		"8\3\2\2\2\u00fa\u00fb\7\61\2\2\u00fb:\3\2\2\2\u00fc\u00fd\7/\2\2\u00fd"+
		"<\3\2\2\2\u00fe\u00ff\7\'\2\2\u00ff>\3\2\2\2\u0100\u0101\7w\2\2\u0101"+
		"\u0102\7t\2\2\u0102\u0103\7n\2\2\u0103\u0104\3\2\2\2\u0104\u0105\5\21"+
		"\b\2\u0105\u0106\3\2\2\2\u0106\u0107\b\37\3\2\u0107@\3\2\2\2\u0108\u0109"+
		"\7?\2\2\u0109\u010a\7?\2\2\u010aB\3\2\2\2\u010b\u010c\7#\2\2\u010c\u010d"+
		"\7?\2\2\u010dD\3\2\2\2\u010e\u010f\7?\2\2\u010fF\3\2\2\2\u0110\u0111\7"+
		"~\2\2\u0111\u0112\7?\2\2\u0112H\3\2\2\2\u0113\u0114\7\u0080\2\2\u0114"+
		"\u0115\7?\2\2\u0115J\3\2\2\2\u0116\u0117\7B\2\2\u0117\u0118\7o\2\2\u0118"+
		"\u0119\7k\2\2\u0119\u011a\7z\2\2\u011a\u011b\7k\2\2\u011b\u011c\7p\2\2"+
		"\u011cL\3\2\2\2\u011d\u011e\7B\2\2\u011e\u011f\7h\2\2\u011f\u0120\7w\2"+
		"\2\u0120\u0121\7p\2\2\u0121\u0122\7e\2\2\u0122\u0123\7v\2\2\u0123\u0124"+
		"\7k\2\2\u0124\u0125\7q\2\2\u0125\u0126\7p\2\2\u0126N\3\2\2\2\u0127\u0128"+
		"\7B\2\2\u0128\u0129\7g\2\2\u0129\u012a\7n\2\2\u012a\u012b\7u\2\2\u012b"+
		"\u012c\7g\2\2\u012cP\3\2\2\2\u012d\u012e\7k\2\2\u012e\u012f\7h\2\2\u012f"+
		"R\3\2\2\2\u0130\u0131\7B\2\2\u0131\u0132\7k\2\2\u0132\u0133\7h\2\2\u0133"+
		"T\3\2\2\2\u0134\u0135\7B\2\2\u0135\u0136\7h\2\2\u0136\u0137\7q\2\2\u0137"+
		"\u0138\7t\2\2\u0138V\3\2\2\2\u0139\u013a\7B\2\2\u013a\u013b\7y\2\2\u013b"+
		"\u013c\7j\2\2\u013c\u013d\7k\2\2\u013d\u013e\7n\2\2\u013e\u013f\7g\2\2"+
		"\u013fX\3\2\2\2\u0140\u0141\7B\2\2\u0141\u0142\7g\2\2\u0142\u0143\7c\2"+
		"\2\u0143\u0144\7e\2\2\u0144\u0145\7j\2\2\u0145Z\3\2\2\2\u0146\u0147\7"+
		"B\2\2\u0147\u0148\7k\2\2\u0148\u0149\7p\2\2\u0149\u014a\7e\2\2\u014a\u014b"+
		"\7n\2\2\u014b\u014c\7w\2\2\u014c\u014d\7f\2\2\u014d\u014e\7g\2\2\u014e"+
		"\\\3\2\2\2\u014f\u0150\7B\2\2\u0150\u0151\7k\2\2\u0151\u0152\7o\2\2\u0152"+
		"\u0153\7r\2\2\u0153\u0154\7q\2\2\u0154\u0155\7t\2\2\u0155\u0156\7v\2\2"+
		"\u0156^\3\2\2\2\u0157\u0158\7B\2\2\u0158\u0159\7t\2\2\u0159\u015a\7g\2"+
		"\2\u015a\u015b\7v\2\2\u015b\u015c\7w\2\2\u015c\u015d\7t\2\2\u015d\u015e"+
		"\7p\2\2\u015e`\3\2\2\2\u015f\u0160\7h\2\2\u0160\u0161\7t\2\2\u0161\u0162"+
		"\7q\2\2\u0162\u0163\7o\2\2\u0163b\3\2\2\2\u0164\u0165\7v\2\2\u0165\u0166"+
		"\7j\2\2\u0166\u0167\7t\2\2\u0167\u0168\7q\2\2\u0168\u0169\7w\2\2\u0169"+
		"\u016a\7i\2\2\u016a\u016b\7j\2\2\u016bd\3\2\2\2\u016c\u016d\7#\2\2\u016d"+
		"\u016e\7f\2\2\u016e\u016f\7g\2\2\u016f\u0170\7h\2\2\u0170\u0171\7c\2\2"+
		"\u0171\u0172\7w\2\2\u0172\u0173\7n\2\2\u0173\u0174\7v\2\2\u0174f\3\2\2"+
		"\2\u0175\u0179\t\2\2\2\u0176\u0178\t\3\2\2\u0177\u0176\3\2\2\2\u0178\u017b"+
		"\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u0185\3\2\2\2\u017b"+
		"\u0179\3\2\2\2\u017c\u017d\7/\2\2\u017d\u0181\t\2\2\2\u017e\u0180\t\3"+
		"\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0175\3\2"+
		"\2\2\u0184\u017c\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\b\63\2\2\u0187"+
		"h\3\2\2\2\u0188\u018c\7$\2\2\u0189\u018b\n\4\2\2\u018a\u0189\3\2\2\2\u018b"+
		"\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2"+
		"\2\2\u018e\u018c\3\2\2\2\u018f\u0199\7$\2\2\u0190\u0194\7)\2\2\u0191\u0193"+
		"\n\5\2\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0199\7)"+
		"\2\2\u0198\u0188\3\2\2\2\u0198\u0190\3\2\2\2\u0199j\3\2\2\2\u019a\u019b"+
		"\5i\64\2\u019bl\3\2\2\2\u019c\u01a4\7/\2\2\u019d\u019f\4\62;\2\u019e\u019d"+
		"\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\7\60\2\2\u01a4\u01a0\3"+
		"\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a8\4\62;\2\u01a7"+
		"\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2"+
		"\2\2\u01aa\u01ba\3\2\2\2\u01ab\u01ad\4\62;\2\u01ac\u01ab\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b1\3\2"+
		"\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b3\7\60\2\2\u01b2\u01ae\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01b5\3\2\2\2\u01b4\u01b6\4\62;\2\u01b5\u01b4\3\2"+
		"\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01ba\3\2\2\2\u01b9\u019c\3\2\2\2\u01b9\u01b2\3\2\2\2\u01ban\3\2\2\2"+
		"\u01bb\u01bd\7%\2\2\u01bc\u01be\t\6\2\2\u01bd\u01bc\3\2\2\2\u01be\u01bf"+
		"\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0p\3\2\2\2\u01c1"+
		"\u01c5\t\7\2\2\u01c2\u01c3\7\17\2\2\u01c3\u01c5\7\f\2\2\u01c4\u01c1\3"+
		"\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6"+
		"\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01c9\b8\4\2\u01c9r\3\2\2\2\u01ca"+
		"\u01cb\7\61\2\2\u01cb\u01cc\7\61\2\2\u01cc\u01d0\3\2\2\2\u01cd\u01cf\n"+
		"\b\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d8\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d9\7\f"+
		"\2\2\u01d4\u01d6\7\17\2\2\u01d5\u01d7\7\f\2\2\u01d6\u01d5\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d3\3\2\2\2\u01d8\u01d4\3\2"+
		"\2\2\u01d9\u01da\3\2\2\2\u01da\u01db\b9\4\2\u01dbt\3\2\2\2\u01dc\u01dd"+
		"\7\61\2\2\u01dd\u01de\7,\2\2\u01de\u01e2\3\2\2\2\u01df\u01e1\13\2\2\2"+
		"\u01e0\u01df\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e2\u01e0"+
		"\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e6\7,\2\2\u01e6"+
		"\u01e7\7\61\2\2\u01e7\u01e8\3\2\2\2\u01e8\u01e9\b:\4\2\u01e9v\3\2\2\2"+
		"\u01ea\u01eb\5\23\t\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\b;\5\2\u01edx\3"+
		"\2\2\2\u01ee\u01f5\5i\64\2\u01ef\u01f1\n\t\2\2\u01f0\u01ef\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\3\2"+
		"\2\2\u01f4\u01ee\3\2\2\2\u01f4\u01f0\3\2\2\2\u01f5z\3\2\2\2\u01f6\u01f7"+
		"\5\25\n\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\b=\5\2\u01f9\u01fa\b=\6\2\u01fa"+
		"|\3\2\2\2\u01fb\u01fc\5q8\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\b>\5\2\u01fe"+
		"\u01ff\b>\4\2\u01ff~\3\2\2\2\u0200\u0201\5+\25\2\u0201\u0202\3\2\2\2\u0202"+
		"\u0203\b?\7\2\u0203\u0080\3\2\2\2\u0204\u0205\5\17\7\2\u0205\u0082\3\2"+
		"\2\2\u0206\u0207\5\27\13\2\u0207\u0208\3\2\2\2\u0208\u0209\bA\b\2\u0209"+
		"\u0084\3\2\2\2\u020a\u020b\5g\63\2\u020b\u0086\3\2\2\2\u020c\u020d\5\r"+
		"\6\2\u020d\u020e\3\2\2\2\u020e\u020f\bC\5\2\u020f\u0210\bC\t\2\u0210\u0088"+
		"\3\2\2\2\u0211\u0212\5)\24\2\u0212\u0213\3\2\2\2\u0213\u0214\bD\5\2\u0214"+
		"\u0215\bD\n\2\u0215\u008a\3\2\2\2\u0216\u0217\5\21\b\2\u0217\u0218\3\2"+
		"\2\2\u0218\u0219\bE\5\2\u0219\u021a\bE\13\2\u021a\u008c\3\2\2\2\u021b"+
		"\u021c\5\23\t\2\u021c\u021d\3\2\2\2\u021d\u021e\bF\5\2\u021e\u021f\bF"+
		"\f\2\u021f\u008e\3\2\2\2\u0220\u0221\5#\21\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\bG\5\2\u0223\u0224\bG\r\2\u0224\u0090\3\2\2\2\u0225\u0226\5\'\23"+
		"\2\u0226\u0227\3\2\2\2\u0227\u0228\bH\5\2\u0228\u0229\bH\16\2\u0229\u0092"+
		"\3\2\2\2\u022a\u022b\5%\22\2\u022b\u022c\3\2\2\2\u022c\u022d\bI\5\2\u022d"+
		"\u022e\bI\17\2\u022e\u0094\3\2\2\2\35\2\3\4\u00c0\u00c6\u0179\u0181\u0184"+
		"\u018c\u0194\u0198\u01a0\u01a4\u01a9\u01ae\u01b2\u01b7\u01b9\u01bf\u01c4"+
		"\u01c6\u01d0\u01d6\u01d8\u01e2\u01f2\u01f4\20\7\4\2\7\3\2\b\2\2\6\2\2"+
		"\t\13\2\t\26\2\t\f\2\t\7\2\t\25\2\t\t\2\t\n\2\t\22\2\t\24\2\t\23\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from GUI.g4 by ANTLR 4.13.2
package org.robok.easyui.antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({
  "all",
  "warnings",
  "unchecked",
  "unused",
  "cast",
  "CheckReturnValue",
  "this-escape"
})
public class GUILexer extends Lexer {
  static {
    RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION);
  }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
  public static final int T__0 = 1,
      T__1 = 2,
      T__2 = 3,
      T__3 = 4,
      T__4 = 5,
      T__5 = 6,
      IDENTIFIER = 7,
      IDENTIFIER_COLON = 8,
      STRING = 9,
      NUMBER = 10,
      IDENTIFIER_DOT = 11,
      WS = 12;
  public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

  public static String[] modeNames = {"DEFAULT_MODE"};

  private static String[] makeRuleNames() {
    return new String[] {
      "T__0",
      "T__1",
      "T__2",
      "T__3",
      "T__4",
      "T__5",
      "IDENTIFIER",
      "IDENTIFIER_COLON",
      "STRING",
      "NUMBER",
      "IDENTIFIER_DOT",
      "WS"
    };
  }

  public static final String[] ruleNames = makeRuleNames();

  private static String[] makeLiteralNames() {
    return new String[] {null, "'('", "')'", "'{'", "'}'", "','", "'='"};
  }

  private static final String[] _LITERAL_NAMES = makeLiteralNames();

  private static String[] makeSymbolicNames() {
    return new String[] {
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      "IDENTIFIER",
      "IDENTIFIER_COLON",
      "STRING",
      "NUMBER",
      "IDENTIFIER_DOT",
      "WS"
    };
  }

  private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated public static final String[] tokenNames;

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

  public GUILexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
  }

  @Override
  public String getGrammarFileName() {
    return "GUI.g4";
  }

  @Override
  public String[] getRuleNames() {
    return ruleNames;
  }

  @Override
  public String getSerializedATN() {
    return _serializedATN;
  }

  @Override
  public String[] getChannelNames() {
    return channelNames;
  }

  @Override
  public String[] getModeNames() {
    return modeNames;
  }

  @Override
  public ATN getATN() {
    return _ATN;
  }

  public static final String _serializedATN =
      "\u0004\u0000\ff\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"
          + "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"
          + "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"
          + "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"
          + "\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"
          + "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"
          + "\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006(\b\u0006\n\u0006\f\u0006"
          + "+\t\u0006\u0001\u0007\u0001\u0007\u0005\u0007/\b\u0007\n\u0007\f\u0007"
          + "2\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b8\b\b\n\b\f\b;\t\b\u0001"
          + "\b\u0001\b\u0001\t\u0004\t@\b\t\u000b\t\f\tA\u0001\t\u0001\t\u0004\tF"
          + "\b\t\u000b\t\f\tG\u0003\tJ\b\t\u0001\n\u0001\n\u0005\nN\b\n\n\n\f\nQ\t"
          + "\n\u0001\n\u0001\n\u0001\n\u0005\nV\b\n\n\n\f\nY\t\n\u0005\n[\b\n\n\n"
          + "\f\n^\t\n\u0001\u000b\u0004\u000ba\b\u000b\u000b\u000b\f\u000bb\u0001"
          + "\u000b\u0001\u000b\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007"
          + "\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"
          + "\u0017\f\u0001\u0000\u0006\u0003\u0000AZ__az\u0004\u000009AZ__az\u0004"
          + "\u00000:AZ__az\u0002\u0000\"\"\\\\\u0001\u000009\u0003\u0000\t\n\r\r "
          + " p\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"
          + "\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"
          + "\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"
          + "\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"
          + "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"
          + "\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u0019"
          + "\u0001\u0000\u0000\u0000\u0003\u001b\u0001\u0000\u0000\u0000\u0005\u001d"
          + "\u0001\u0000\u0000\u0000\u0007\u001f\u0001\u0000\u0000\u0000\t!\u0001"
          + "\u0000\u0000\u0000\u000b#\u0001\u0000\u0000\u0000\r%\u0001\u0000\u0000"
          + "\u0000\u000f,\u0001\u0000\u0000\u0000\u00113\u0001\u0000\u0000\u0000\u0013"
          + "?\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017`\u0001"
          + "\u0000\u0000\u0000\u0019\u001a\u0005(\u0000\u0000\u001a\u0002\u0001\u0000"
          + "\u0000\u0000\u001b\u001c\u0005)\u0000\u0000\u001c\u0004\u0001\u0000\u0000"
          + "\u0000\u001d\u001e\u0005{\u0000\u0000\u001e\u0006\u0001\u0000\u0000\u0000"
          + "\u001f \u0005}\u0000\u0000 \b\u0001\u0000\u0000\u0000!\"\u0005,\u0000"
          + "\u0000\"\n\u0001\u0000\u0000\u0000#$\u0005=\u0000\u0000$\f\u0001\u0000"
          + "\u0000\u0000%)\u0007\u0000\u0000\u0000&(\u0007\u0001\u0000\u0000\'&\u0001"
          + "\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000"
          + ")*\u0001\u0000\u0000\u0000*\u000e\u0001\u0000\u0000\u0000+)\u0001\u0000"
          + "\u0000\u0000,0\u0007\u0000\u0000\u0000-/\u0007\u0002\u0000\u0000.-\u0001"
          + "\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"
          + "01\u0001\u0000\u0000\u00001\u0010\u0001\u0000\u0000\u000020\u0001\u0000"
          + "\u0000\u000039\u0005\"\u0000\u000048\b\u0003\u0000\u000056\u0005\\\u0000"
          + "\u000068\t\u0000\u0000\u000074\u0001\u0000\u0000\u000075\u0001\u0000\u0000"
          + "\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"
          + "\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005"
          + "\"\u0000\u0000=\u0012\u0001\u0000\u0000\u0000>@\u0007\u0004\u0000\u0000"
          + "?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"
          + "\u0000AB\u0001\u0000\u0000\u0000BI\u0001\u0000\u0000\u0000CE\u0005.\u0000"
          + "\u0000DF\u0007\u0004\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000"
          + "\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001"
          + "\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"
          + "J\u0014\u0001\u0000\u0000\u0000KO\u0007\u0000\u0000\u0000LN\u0007\u0001"
          + "\u0000\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001"
          + "\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000P\\\u0001\u0000\u0000\u0000"
          + "QO\u0001\u0000\u0000\u0000RS\u0005.\u0000\u0000SW\u0007\u0000\u0000\u0000"
          + "TV\u0007\u0001\u0000\u0000UT\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000"
          + "\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001\u0000"
          + "\u0000\u0000YW\u0001\u0000\u0000\u0000ZR\u0001\u0000\u0000\u0000[^\u0001"
          + "\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000"
          + "]\u0016\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000_a\u0007\u0005"
          + "\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001"
          + "\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"
          + "de\u0006\u000b\u0000\u0000e\u0018\u0001\u0000\u0000\u0000\f\u0000)079"
          + "AGIOW\\b\u0001\u0006\u0000\u0000";
  public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}

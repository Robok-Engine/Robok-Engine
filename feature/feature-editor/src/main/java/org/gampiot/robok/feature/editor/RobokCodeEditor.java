package org.gampiot.robok.feature.editor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.util.Log;

import androidx.annotation.Nullable;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticDetail;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.lang.diagnostic.Quickfix;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.schemes.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import robok.diagnostic.logic.*;

import org.gampiot.robok.feature.editor.R;
import org.gampiot.robok.feature.editor.databinding.LayoutCodeEditorBinding;
import org.gampiot.robok.feature.editor.symbol.RobokSymbolInput;
import org.gampiot.robok.feature.editor.schemes.*;
import org.gampiot.robok.feature.editor.languages.java.*;

import java.lang.CharSequence;

public class RobokCodeEditor extends LinearLayout implements DiagnosticListener, EditorListener  {

     public DiagnosticsContainer diagnostics; // popup/box of Diagnostic
    
     public Context context; // Global context
    
     public DiagnosticListener diagnosticListener; // DiagnosticListener used.
     public EditorListener editorListener; // EditorListener used.
     
     public final RobokSymbolInput DEFAULT_SYMBOL_VIEW; // Default symbol view used.
     
     private final LayoutCodeEditorBinding binding;
    
     private JavaLanguage language;
     
     public final static String TAG = "RobokCodeEditor"; 
    
     /*
     * Default constructor.
     */
     public RobokCodeEditor(Context context) {
          this(context, null);
          this.context = context;
     }
     
     /*
     * Complete constructor.
     */
     public RobokCodeEditor(Context context, @Nullable AttributeSet attrs) {
          super(context, attrs);
          this.context = context;
          this.diagnosticListener = this;
          this.editorListener = this;
          binding = LayoutCodeEditorBinding.inflate(LayoutInflater.from(context), this, true);
          diagnostics = new DiagnosticsContainer();
          DEFAULT_SYMBOL_VIEW = binding.robokSymbolInput;
          configureEditor();
          configureSymbolView(DEFAULT_SYMBOL_VIEW);
          configureDiagnostic();
     }
     
     /*
     * This method sets the editor's initial text, font, language...
     */
     private void configureEditor() {
          //Diagnostics
          diagnostics = new DiagnosticsContainer();
          language = new JavaLanguage(binding.editor, this, diagnostics, editorListener);
          binding.editor.setText(BASE_MESSAGE);
          binding.editor.setTypefaceText(Typeface.MONOSPACE);
          binding.editor.setTextSize(16);
          binding.editor.setEditorLanguage(language);
          binding.editor.setWordwrap(false);
          binding.editor.getProps().symbolPairAutoCompletion = true;
          binding.editor.getComponent(EditorAutoCompletion.class).setEnabled(true);
          applyEditorTheme();
     }
     
     /*
     * Method to define a symbol view.
     * is already included in the editor, but you can remove it.
     */
     public void configureSymbolView (RobokSymbolInput robokSymbolInput) {
          robokSymbolInput.bindEditor(getCodeEditor());
          robokSymbolInput.addSymbols(
               new String[]{"->", "{", "}", "(", ")", ",", "|", "=", "#", "!", "&", "/", "%", "`", "_", ";", ".", "×", "<", ">", "\"", "?", "+", "-", "*", "/", "<-"},
               new String[]{"\t", "{}", "}", "(", ")", ",", ".", ";", "|", "\"", "?", "+", "-", "*", "/"}
          );
     }
     
     /*
     * Method to set the editor theme.
     * see: https://github.com/robok-inc/Robok-Engine/tree/dev/feature/feature-editor/src/main/java/org/gampiot/robok/feature/editor/ThemeManager.kt
     */
     private void applyEditorTheme() {
          var mng = new Manager();
          binding.editor.setColorScheme(selectTheme(mng.getEditorThemeInt()));
     }

     /*
     * Method to choose editor theme.
     * @param themeIndex number of theme 0...6 
     */
     private EditorColorScheme selectTheme(int themeIndex) {
          EditorColorScheme scheme;
          try {
               switch (themeIndex) {
                    case 0:
                         scheme = new SchemeRobok(binding.editor.getContext());
                         break;
                    case 1:
                         scheme = new SchemeRobokTH(binding.editor.getContext());
                         break;
                    case 2:
                         scheme = new SchemeGitHub();
                         break;
                    case 3:
                         scheme = new SchemeEclipse();
                         break;
                    case 4:
                         scheme = new SchemeDarcula();
                         break;
                    case 5:
                         scheme = new SchemeVS2019();
                         break;
                    case 6:
                         scheme = new SchemeNotepadXX();
                         break;
                    default:
                         scheme = new SchemeRobok(binding.editor.getContext());
                         break;
               }
          } catch (Exception e) {
               Log.e(TAG, "fail on select theme: " + themeIndex, e);
               scheme = new SchemeRobok(binding.editor.getContext());
          }
          return scheme;
     }
     
     /*
     * Method to check if there are any errors in the code with ANTLR 4 Java 8.
     * @param inputText text to be checked, usually the editor code.
     */
     private void checkForPossibleErrors(String inputText) {
          diagnostics.reset();
          try {
              // use ANTLR to compile code and return diagnostic 
              ANTLRInputStream input = new ANTLRInputStream(inputText);
              Java8Lexer lexer = new Java8Lexer(input);
              CommonTokenStream tokens = new CommonTokenStream(lexer);
              Java8Parser parser = new Java8Parser(tokens);
              parser.removeErrorListeners();
              Java8ErrorListener robokError = new Java8ErrorListener();
  
              robokError.getError(diagnosticListener);
              parser.addErrorListener(robokError);
              parser.compilationUnit();
          } catch (Exception e) {
              Log.e(TAG, "Error reading file", e);
          }
     }
    
     /* 
     * Method to add a diagnostic box/popup in the sora editor.
     * @param positionStart corresponds to the first character of the error code.
     * @param positionEnd corresponds to the end character of the error code.
     * @param severity corresponds to the severity of the error.
     * @param msg a message about the error to the user.
     */
     public void addDiagnosticInEditor(int positionStart, int positionEnd, short severity, String msg) {
          DiagnosticRegion diagnosticRegion = new DiagnosticRegion(
               positionStart,
               positionEnd,
               severity,
               0L,
                   new DiagnosticDetail(
                        context.getResources().getString(org.gampiot.robok.feature.res.R.string.text_error_details), 
                        msg,
                        Arrays.asList(
                            new Quickfix("Fix Quick", 0L, () -> quickFix()) 
                        ),
                        null
                   )
               );
          diagnostics.addDiagnostic(diagnosticRegion);
          binding.editor.setDiagnostics(diagnostics);
     }
     
     /*
     * Method to resolve a simple error quickly 
     * not implemented yet.
     */
     public void quickFix () {
          // TO-DO: logic to fix basic errors quickly
     }
     
     /*
     * Method to set the DiagnosticListener
     * @param diagnosticListener New listener instance (DiagnosticListener interface)
     */
     public void setDiagnosticListener (DiagnosticListener diagnosticListener) {
          this.diagnosticListener = diagnosticListener;
     }
     
     /*
     * Method to set the EditorListener
     * @param editorListener New listener instance (EditorListener interface)
     */
     public void setEditorListener (EditorListener editorListener) {
          this.editorListener = editorListener;
     }
     
     /*
     * Method to directly work with the editor (sora)
     * @return Returns current *io.github.rosemoe.sora.widget.CodeEditor* instance
     */
     public CodeEditor getCodeEditor() {
          return binding.editor;
     }
     
     /*
     * Method to get editor text
     * @return Returns a CharSequence like every textview & etc.
     */
     public CharSequence getText() {
          return binding.editor.getText();
     }
    
     /*
     * Method to redo the text editor.
     */
     public void redo() {
          binding.editor.redo();
     }   
     
     /*
     * Method to undo the text editor.
     */
     public void undo () {
          binding.editor.undo();
     }
     
     /*
     * This method is used to notify the editor that a new error dialigost has been received.
     * @param line an integer corresponding to the error line
     * @param positionStart corresponds to the first character of the error code.
     * @param positionEnd corresponds to the end character of the error code.
     * @param msg a message about the error to the user.
     */
     @Override
     public void onDiagnosticReceive(int line, int positionStart, int positionEnd, String msg) {
          onDiagnosticStatusReceive(true);
          addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg);
     }
     
     /*
     * This method is called when some diagnostic status is received. 
     * @param isError: returns whether it is an error or not.
     */
     @Override
     public void onDiagnosticStatusReceive(boolean isError) { }
    
     /*
     * This method is called whenever the editor text is changed.
     */
     @Override 
     public void onEditorTextChange () { }
    
     private static final String BASE_MESSAGE = "package com.my.newproject;\n\n" +
                "public class Main {\n\n" +
                "    // Variables\n\n" +
                "    // Variables#string\n" +
                "    public String defString;\n" +
                "    public static String constString = \"I AM A STATIC\";\n" +
                "    String withoutPrivacyString;\n" +
                "    static String withoutPrivacyConstString = \"I AM A STATIC\";\n\n" +
                "    // Variables#int\n" +
                "    public int defInt;\n" +
                "    public static int constInt = 0;\n" +
                "    int withoutPrivacyInt;\n" +
                "    static int withoutPrivacyConstInt = 0;\n\n" +
                "    // Variables#boolean\n" +
                "    public boolean defBoolean;\n" +
                "    public static boolean constBoolean = false;\n" +
                "    boolean withoutPrivacyBoolean;\n" +
                "    static boolean withoutPrivacyConstBoolean = true;\n\n" +
                "    // Methods\n\n" +
                "    // methods#void\n" +
                "    private void myVoidMethod() {\n" +
                "        // method content\n" +
                "    }\n\n" +
                "    public static void myStaticVoidMethod() {\n" +
                "        // method content\n" +
                "    }\n\n" +
                "    // methods#string\n" +
                "    public String myStringMethod() {\n" +
                "        // method content\n" +
                "        return \"Hello, World!\";\n" +
                "    }\n\n" +
                "    public static String myStaticStringMethod() {\n" +
                "        // method content\n" +
                "        return \"I am a static method.\";\n" +
                "    }\n\n" +
                "    // and more...\n" +
                "}";
    
}
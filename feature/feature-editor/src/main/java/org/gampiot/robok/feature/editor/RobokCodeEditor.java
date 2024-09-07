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

import org.robok.diagnostic.logic.*;

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
    
     private JavaLanguage language; // Configuration of JavaLanguage
     
     private EditorConfigManager editorConfigManager;
     
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
          editorConfigManager = new EditorConfigManager();
          DEFAULT_SYMBOL_VIEW = binding.robokSymbolInput;
          configureEditor();
          configureSymbolView(DEFAULT_SYMBOL_VIEW);
     }
     
     /*
     * This method sets the editor's initial text, font, language...
     */
     private void configureEditor() {
          //Diagnostics
          diagnostics = new DiagnosticsContainer();
          language = new JavaLanguage(this, diagnostics);
          reload();
          getSoraCodeEditor().setText(BASE_MESSAGE);
          getSoraCodeEditor().setTypefaceText(AppearanceManager.getTypeface(editorConfigManager.getEditorTypefacePreference()));
          getSoraCodeEditor().setTextSize(16);
          getSoraCodeEditor().setEditorLanguage(language);
          getSoraCodeEditor().setWordwrap(editorConfigManager.isUseWordWrap());
          getSoraCodeEditor().getProps().symbolPairAutoCompletion = true;
          getSoraCodeEditor().getComponent(EditorAutoCompletion.class).setEnabled(true);
          getSoraCodeEditor().setColorScheme(AppearanceManager.getTheme(this, editorConfigManager.getEditorThemePreference()));
     }
     
     /*
     * Method to define a symbol view.
     * is already included in the editor, but you can remove it.
     */
     public void configureSymbolView (RobokSymbolInput robokSymbolInput) {
          robokSymbolInput.bindEditor(getSoraCodeEditor());
          robokSymbolInput.addSymbols(
               new String[]{"->", "{", "}", "(", ")", ",", "|", "=", "#", "!", "&", "/", "%", "`", "_", ";", ".", "×", "<", ">", "\"", "?", "+", "-", "*", "/", "<-"},
               new String[]{"\t", "{}", "}", "(", ")", ",", ".", ";", "|", "\"", "?", "+", "-", "*", "/"}
          );
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
          getSoraCodeEditor().setDiagnostics(diagnostics);
     }
     
     /*
     * Method to reload Language config
     */
     public void reload() {
          language.setEditorListener(editorListener);
          language.setDiagnosticListener(diagnosticListener);
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
     public CodeEditor getSoraCodeEditor() {
          return binding.editor;
     }
     
     /*
     * Method to get editor text
     * @return Returns a CharSequence like every textview & etc.
     */
     public CharSequence getText() {
          return getSoraCodeEditor().getText();
     }
    
     /*
     * Method to redo the text editor.
     */
     public void redo() {
          getSoraCodeEditor().redo();
     }   
     
     /*
     * Method to undo the text editor.
     */
     public void undo () {
          getSoraCodeEditor().undo();
     }
    
     /*
     * Method to get if can redo
     */
     public boolean isCanRedo() {
          return getSoraCodeEditor().canRedo();
     }
     
     /*
     * Method to get if can undo
     */
     public boolean isCanUndo() {
          return getSoraCodeEditor().canUndo();
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
    
     /*
     * AppearanceManager class
     * subclass to manage Code Editor Appearance.
     */
     public static final class AppearanceManager {
          
          
          /*
          * Method to choose editor font typeface.
          * @param typefaceIndex number of theme 0...4
          * @return Return a TypeFace to use on editor
          */
          public static final Typeface getTypeface(int typefaceIndex) {
               switch (typefaceIndex) {
                    case 0:
                        return Typeface.DEFAULT;
                    case 1:
                        return Typeface.DEFAULT_BOLD;
                    case 2:
                        return Typeface.MONOSPACE;
                    case 3:
                        return Typeface.SANS_SERIF;
                    case 4:
                        return Typeface.SERIF;
                    default:
                        return Typeface.DEFAULT;
               }
          }
          
          /*
          * Method to choose editor theme.
          * @param themeIndex number of theme 0...6
          * @return Return a EditorColorScheme instance
          */
          public static final EditorColorScheme getTheme(RobokCodeEditor rcd, int themeIndex) {
               var ctx = rcd.getSoraCodeEditor().getContext();
               switch (themeIndex) {
                    case 0:
                        return new SchemeRobok(ctx);
                    case 1:
                        return new SchemeRobokTH(ctx);
                    case 2:
                        return new SchemeGitHub();
                    case 3:
                        return new SchemeEclipse();
                    case 4:
                        return new SchemeDarcula();
                    case 5:
                        return new SchemeVS2019();
                    case 6:
                        return new SchemeNotepadXX();
                    default:
                        return new SchemeRobok(ctx);
               }
          }
     }
     
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
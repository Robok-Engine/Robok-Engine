package org.gampiot.robok.feature.component.editor;

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
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticDetail;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.lang.diagnostic.Quickfix;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.event.ContentChangeEvent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import robok.diagnostic.logic.*;

import org.gampiot.robok.feature.component.R;
import org.gampiot.robok.feature.component.databinding.LayoutCodeEditorBinding;
import org.gampiot.robok.feature.component.editor.symbol.RobokSymbolInput;

public class RobokCodeEditor extends LinearLayout implements DiagnosticListener {

    public Context context;
    public final DiagnosticsContainer diagnostics;
    public final LayoutCodeEditorBinding binding;
    public RobokSymbolInput DEFAULT_SYMBOL_VIEW;

    public RobokCodeEditor(Context context) {
        this(context, null);
        this.context = context;
    }

    public RobokCodeEditor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        binding = LayoutCodeEditorBinding.inflate(LayoutInflater.from(context), this, true);
        diagnostics = new DiagnosticsContainer();
        DEFAULT_SYMBOL_VIEW = binding.robokSymbolInput;
        configureEditor();
        configureSymbolView();
        configureDiagnostic();
    }

    void configureEditor() {
        binding.editor.setText(BASE_MESSAGE);
        binding.editor.setTypefaceText(Typeface.MONOSPACE);
        binding.editor.setTextSize(16);
        binding.editor.setEditorLanguage(new JavaLanguage());
        binding.editor.setWordwrap(false);
        binding.editor.getProps().symbolPairAutoCompletion = true;
        binding.editor.getComponent(EditorAutoCompletion.class).setEnabled(true);
        applyEditorTheme();        
    }
    
    void configureDiagnostic () {
        binding.editor.subscribeEvent(ContentChangeEvent.class, (event, undubscribe) -> {
              String inputText = binding.editor.getText().toString(); 
              CheckforPossibleErrors(inputText);
        });
    }
    
    public void configureSymbolView (RobokSymbolInput robokSymbolInput) {
         robokSymbolInput.bindEditor(getCodeEditor());
         robokSymbolInput.addSymbols(
              new String[]{"->", "{", "}", "(", ")", ",", "|", "=", "#", "!", "&", "/", "%", "`", "_", ";", ".", "×", "<", ">", "\"", "?", "+", "-", "*", "/", "<-"},
              new String[]{"\t", "{}", "}", "(", ")", ",", ".", ";", "|", "\"", "?", "+", "-", "*", "/"}
         );
    }
    
    void applyEditorTheme() {
         int theme = ThemeManager.Companion.loadTheme(getContext());
         ThemeManager.Companion.selectTheme(binding.editor, theme);
    }
    
    @Override
    public void onDiagnosticReceive(int line, int positionStart, int positionEnd, String msg) {
         onDiagnosticStatusReceive(true);
         addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg);
    }
    
    @Override
    public void onDiagnosticStatusReceive(boolean isError) {
         if (isError) {
            Toast.makeText(context, "error", 4000).show();
         }
    }
    
    void CheckforPossibleErrors(String inputText) {
        diagnostics.reset();
        try {
            // use ANTLR to compile code and return diagnostic 
            ANTLRInputStream input = new ANTLRInputStream(inputText);
            Java8Lexer lexer = new Java8Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Java8Parser parser = new Java8Parser(tokens);
            parser.removeErrorListeners();
            Java8ErrorListener robokError = new Java8ErrorListener();

            robokError.getError(this);
            parser.addErrorListener(robokError);
            parser.compilationUnit();
        } catch (Exception e) {
            Log.e("MainActivity", "Error reading file", e);
        }
    }
    
    void addDiagnosticInEditor(int positionStart, int positionEnd, int severity, String msg) {
         DiagnosticRegion diagnosticRegion = new DiagnosticRegion(
              positionStart,
              positionEnd,
              DiagnosticRegion.SEVERITY_ERROR, // Certifique-se de que SEREVITY_ERROR é uma constante válida
              0L,
                  new DiagnosticDetail(
                       "Error detail:", 
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

    
    public void quickFix () {
         // TO-DO: logic to fix basic errors quickly
    }

    public CodeEditor getCodeEditor() {
        return binding.editor;
    }

    public String getText() {
        return binding.editor.getText().toString();
    }
    
    public void redo() {
        binding.editor.redo();
    }
    
    public void undo () {
        binding.editor.undo();
    }
    
    static final String BASE_MESSAGE = "package com.my.newproject;\n\n" +
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

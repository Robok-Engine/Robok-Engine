package dev.trindadeaquiles.robokide.ui.components.editor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.util.Log;

import androidx.annotation.Nullable;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.langs.java.JavaLanguage;

import dev.trindadeaquiles.robokide.R;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticDetail;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.lang.diagnostic.Quickfix;
import io.github.rosemoe.sora.text.Content;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import robok.dev.diagnostic.logic.*;

public class RobokCodeEditor extends LinearLayout {

    public CodeEditor editor;
    private DiagnosticsContainer diagnostics;

    public RobokCodeEditor(Context context) {
        this(context, null);
    }

    public RobokCodeEditor(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_code_editor, this);

        editor = findViewById(R.id.editor);
        diagnostics = new DiagnosticsContainer();
        
        configEditor();
        configDiagnostic();
    }

    private void configEditor() {
        this.editor.setText(BASE_MESSAGE);
        this.editor.setTypefaceText(Typeface.MONOSPACE);
        this.editor.setTextSize(16);
        this.editor.setEditorLanguage(new JavaLanguage());
        this.editor.setWordwrap(false);
        this.editor.getProps().symbolPairAutoCompletion = true;
        this.editor.getComponent(EditorAutoCompletion.class).setEnabled(true);
        applyEditorTheme();        
    }
    
    private void configDiagnostic () {
        //Editor event, if there is a change in the text, this event will be called.
        this.editor.subscribeEvent(ContentChangeEvent.class, (event, undubscribe) -> {
              String inputText = this.editor.getText().toString(); 
              CheckforPossibleErrors(inputText, new DiagnosticListener() {
                     @Override
                     public void onDiagnosticReceive(int line, int positionStart, int positionEnd, String msg) {
                          /* int indexStart = getAbsoluteIndexIgnoringNewlines(inputText, line, positionStart);
                             int indexEnd = getAbsoluteIndexIgnoringNewlines(inputText, line, positionEnd); */
                          addDiagnosticInEditor(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, msg);
                     }
             });
        });
    }
    
    private void applyEditorTheme() {
         int theme = ThemeManager.Companion.loadTheme(getContext());
         ThemeManager.Companion.selectTheme(this.editor, theme);
    }
    
    /*
       * Method used to check if the editor code has errors.
       * If so, the listener will be called.
       * This method must be called every time there is a change in the code.
    */
    private void CheckforPossibleErrors(String inputText, DiagnosticListener listener) {
        diagnostics.reset(); //reset diagnostics.
        try {
            //Using antlr to compile the code.
            
            ANTLRInputStream input = new ANTLRInputStream(inputText);
            Java8Lexer lexer = new Java8Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Java8Parser parser = new Java8Parser(tokens);
            parser.removeErrorListeners();
            Java8ErrorListener robokError = new Java8ErrorListener();

            robokError.getError(listener);
                    
            parser.addErrorListener(robokError);
            
            parser.compilationUnit();
            // Use ParseTreeWalker to navigate the tree and apply checks 
            //additional if necessary
        } catch (Exception e) {
            Log.e("MainActivity", "Error reading file", e);
        }
    }
    
    private void addDiagnosticInEditor(int positionStart, int positionEnd, int severity, String msg){
        diagnostics.addDiagnostic(new DiagnosticRegion(positionStart, positionEnd, DiagnosticRegion.SEVERITY_ERROR, 0L,
                new DiagnosticDetail(
                    "TestTitle, Hello Robok!","" + //diagnostic title 
                     msg, 
                    Arrays.asList(
                        new Quickfix("Fix Quick", 0L, () -> {
                            /*action here*/
                        }),
                        new Quickfix("Test", 0L, () -> {
                            /*action here*/
                        })
                    ), null)
        ));
        
        //apply diagnostic
        this.editor.setDiagnostics(diagnostics);
    }

    public CodeEditor getCodeEditor() {
        return this.editor;
    }

    public String getText() {
        return this.editor.getText().toString();
    }
    
    private void redo() {
        this.editor.redo();
    }
    
    private void undo () {
        this.editor.undo();
    }
    
    public static final String BASE_MESSAGE = "package com.my.newproject;\n\n" +
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
package dev.trindade.robokide.ui.components.editor;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.langs.java.JavaLanguage;

import dev.trindade.robokide.R;

public class CodeEditorView extends LinearLayout {

    public CodeEditor editor;
    public SharedPreferences pref;

    public CodeEditorView(Context context) {
        this(context, null);
    }

    public CodeEditorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.layout_code_editor, this);

        editor = findViewById(R.id.editor);
        pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);
        
        initialize();
    }

    private void initialize() {
        String defaultCode = "package com.my.newproject;\n\n" +
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
                "    public void myVoidMethod() {\n" +
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

        editor.setText(defaultCode);
        editor.setTypefaceText(Typeface.MONOSPACE);
        editor.setTextSize(16);
        editor.setEditorLanguage(new JavaLanguage());
        editor.setWordwrap(false);
        editor.getProps().symbolPairAutoCompletion = true;
        editor.getComponent(EditorAutoCompletion.class).setEnabled(true);
        applyEditorTheme();
    }
    
    public void applyEditorTheme () {
        var themeManager = new ThemeManager();
        var theme = themeManager.loadTheme(getContext());
        themeManager.selectTheme(this.editor, theme);
    }

    public CodeEditor getCodeEditor() {
        return this.editor;
    }

    public String getText() {
        return this.editor.getText().toString();
    }
}
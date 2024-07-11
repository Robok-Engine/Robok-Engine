package dev.trindade.robokide.ui.components.editor;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
        loadCESettings(getContext(), editor, "act");
    }

    private void loadCESettings(Context context, CodeEditor editor, String prefix) {
        SharedPreferences pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);
        int text_size = pref.getInt(prefix + "_ts", 12);
        int theme = pref.getInt(prefix + "_theme", 3);
        boolean word_wrap = pref.getBoolean(prefix + "_ww", false);
        boolean auto_c = pref.getBoolean(prefix + "_ac", true);
        boolean auto_complete_symbol_pairs = pref.getBoolean(prefix + "_acsp", true);

        ThemeManager.INSTANCE.selectTheme(editor, theme);
        editor.setTextSize(text_size);
        editor.setWordwrap(word_wrap);
        editor.getProps().symbolPairAutoCompletion = auto_complete_symbol_pairs;
        editor.getComponent(EditorAutoCompletion.class).setEnabled(auto_c);
    }

    public CodeEditor getCodeEditor() {
        return this.editor;
    }

    public String getText() {
        return editor.getText().toString();
    }

    public void showSwitchThemeDialog(Activity activity, CodeEditor editor, DialogInterface.OnClickListener listener) {
        ThemeManager.INSTANCE.showSwitchThemeDialog(activity, editor, which -> {
            listener.onClick(null, which);
            return null;
        });
    }
}
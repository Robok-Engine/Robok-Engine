package dev.trindade.robokide.ui.components.editor;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula;
import io.github.rosemoe.sora.widget.schemes.SchemeEclipse;
import io.github.rosemoe.sora.widget.schemes.SchemeGitHub;
import io.github.rosemoe.sora.widget.schemes.SchemeNotepadXX;
import io.github.rosemoe.sora.widget.schemes.SchemeVS2019;
import io.github.rosemoe.sora.langs.java.JavaLanguage;

import dev.trindade.robokide.R;
import dev.trindade.robokide.ui.components.dialog.RobokDialog;
import dev.trindade.robokide.ui.components.editor.themes.RobokDarcula;

public class CodeEditorView extends LinearLayout {

    private CodeEditor editor;
    private SharedPreferences pref;
    private Context context;

    public static final List<Pair<String, Class<? extends EditorColorScheme>>> KNOWN_COLOR_SCHEMES = new ArrayList<>();
    static {
        KNOWN_COLOR_SCHEMES.add(new Pair<>("Default", EditorColorScheme.class));
        KNOWN_COLOR_SCHEMES.add(new Pair<>("GitHub", SchemeGitHub.class));
        KNOWN_COLOR_SCHEMES.add(new Pair<>("Eclipse", SchemeEclipse.class));
        KNOWN_COLOR_SCHEMES.add(new Pair<>("Darcula", RobokDarcula.class));
        KNOWN_COLOR_SCHEMES.add(new Pair<>("VS2019", SchemeVS2019.class));
        KNOWN_COLOR_SCHEMES.add(new Pair<>("NotepadXX", SchemeNotepadXX.class));
    }

    public CodeEditorView(Context context) {
        this(context, null);
        this.context = context;
    }

    public CodeEditorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.code_editor_hs, this);
        
        editor = findViewById(R.id.editor);
        pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);

        initialize();
    }

    private void initialize() {
        editor.setTypefaceText(Typeface.MONOSPACE);
        editor.setTextSize(16);
        editor.setEditorLanguage(new JavaLanguage()); // Default language
        loadCESettings(getContext(), editor, "act");
    }

    private void loadCESettings(Context context, CodeEditor editor, String prefix) {
        SharedPreferences pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);
        int text_size = pref.getInt(prefix + "_ts", 12);
        int theme = pref.getInt(prefix + "_theme", 3);
        boolean word_wrap = pref.getBoolean(prefix + "_ww", false);
        boolean auto_c = pref.getBoolean(prefix + "_ac", true);
        boolean auto_complete_symbol_pairs = pref.getBoolean(prefix + "_acsp", true);

        selectTheme(editor, theme);
        editor.setTextSize(text_size);
        editor.setWordwrap(word_wrap);
        editor.getProps().symbolPairAutoCompletion = auto_complete_symbol_pairs;
        editor.getComponent(EditorAutoCompletion.class).setEnabled(auto_c);
    }
    
    public String getText() {
         return editor.getText().toString(); 
    }

    private static void selectTheme(CodeEditor editor, int which) {
        EditorColorScheme scheme;

        switch (which) {
            default:
            case 0:
                scheme = new EditorColorScheme();
                break;
            case 1:
                scheme = new SchemeGitHub();
                break;
            case 2:
                scheme = new SchemeEclipse();
                break;
            case 3:
                scheme = new RobokDarcula(context);
                break;
            case 4:
                scheme = new SchemeVS2019();
                break;
            case 5:
                scheme = new SchemeNotepadXX();
                break;
        }

        Log.d("CodeEditorView", "Selected theme index: " + which);
        editor.setColorScheme(scheme);
    }

    private static void showSwitchThemeDialog(Activity activity, CodeEditor editor, DialogInterface.OnClickListener listener) {
        int selectedThemeIndex = 0;
        EditorColorScheme currentScheme = editor.getColorScheme();
        for (int i = 0; i < KNOWN_COLOR_SCHEMES.size(); i++) {
            if (KNOWN_COLOR_SCHEMES.get(i).second.equals(currentScheme.getClass())) {
                selectedThemeIndex = i;
                break;
            }
        }

        String[] themeItems = new String[KNOWN_COLOR_SCHEMES.size()];
        for (int i = 0; i < KNOWN_COLOR_SCHEMES.size(); i++) {
            themeItems[i] = KNOWN_COLOR_SCHEMES.get(i).first;
        }

        new RobokDialog(activity)
                .setTitle("Select Theme")
                .setSingleChoiceItems(themeItems, selectedThemeIndex, listener)
                .setNegativeButton("Cancel", null)
                .show();
    }
}
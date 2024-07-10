package dev.trindade.robokide.ui.components.editor

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.util.Pair
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.Nullable

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.components.dialog.RobokDialog
import dev.trindade.robokide.ui.components.editor.themes.RobokDarcula
import dev.trindade.robokide.databinding.LayoutCodeEditorBinding

import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion
import io.github.rosemoe.sora.widget.schemes.*

class CodeEditorView @JvmOverloads constructor(
    context: Context, 
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val binding: LayoutCodeEditorBinding = LayoutCodeEditorBinding.inflate(
        LayoutInflater.from(context), this, true
    )
    private val pref: SharedPreferences = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE)
    private lateinit var editor: CodeEditor

    init {
        this.context = context
        initialize()
    }

    private fun initialize() {
        editor = binding.editor
        editor.typefaceText = Typeface.MONOSPACE
        editor.textSize = 16
        editor.editorLanguage = JavaLanguage() // Default language
        loadCESettings(context, editor, "act")
    }

    private fun loadCESettings(context: Context, editor: CodeEditor, prefix: String) {
        val pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE)
        val textSize = pref.getInt(prefix + "_ts", 12)
        val theme = pref.getInt(prefix + "_theme", 3)
        val wordWrap = pref.getBoolean(prefix + "_ww", false)
        val autoC = pref.getBoolean(prefix + "_ac", true)
        val autoCompleteSymbolPairs = pref.getBoolean(prefix + "_acsp", true)

        selectTheme(editor, theme)
        editor.textSize = textSize
        editor.wordwrap = wordWrap
        editor.props.symbolPairAutoCompletion = autoCompleteSymbolPairs
        editor.getComponent(EditorAutoCompletion::class.java).isEnabled = autoC
    }

    fun getText(): String {
        return editor.text.toString()
    }

    private fun selectTheme(editor: CodeEditor, which: Int) {
        val scheme: EditorColorScheme = when (which) {
            1 -> SchemeGitHub()
            2 -> SchemeEclipse()
            3 -> RobokDarcula(context)
            4 -> SchemeVS2019()
            5 -> SchemeNotepadXX()
            else -> EditorColorScheme()
        }

        Log.d("CodeEditorView", "Selected theme index: $which")
        editor.colorScheme = scheme
    }

    fun showSwitchThemeDialog(activity: Activity, listener: DialogInterface.OnClickListener) {
        var selectedThemeIndex = 0
        val currentScheme = binding.editor.colorScheme
        for ((index, pair) in KNOWN_COLOR_SCHEMES.withIndex()) {
            if (pair.second == currentScheme.javaClass) {
                selectedThemeIndex = index
                break
            }
        }

        val themeItems = Array(KNOWN_COLOR_SCHEMES.size) { i -> KNOWN_COLOR_SCHEMES[i].first }
        RobokDialog(activity)
            .setTitle("Select Theme")
            .setSingleChoiceItems(themeItems, selectedThemeIndex, listener)
            .setNegativeButton("Cancel", null)
            .show()
    }

    companion object {
        val KNOWN_COLOR_SCHEMES = listOf(
            "Default" to EditorColorScheme::class.java,
            "GitHub" to SchemeGitHub::class.java,
            "Eclipse" to SchemeEclipse::class.java,
            "Darcula" to RobokDarcula::class.java,
            "VS2019" to SchemeVS2019::class.java,
            "NotepadXX" to SchemeNotepadXX::class.java
        )
    }
}







/*
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
import dev.trindade.robokide.databinding.LayoutCodeEditorBinding;

public class CodeEditorView extends LinearLayout {

    private CodeEditor editor;
    private SharedPreferences pref;
    private Context context;
    private LayoutCodeEditorBinding binding;

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
        binding = LayoutCodeEditorBinding.inflate(LayoutInflater.from(context), this, true);
    }

    public CodeEditorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        
        binding = LayoutCodeEditorBinding.inflate(LayoutInflater.from(context), this, true);
        
        pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);

        initialize();
    }

    private void initialize() {
        binding.editor.setTypefaceText(Typeface.MONOSPACE);
        binding.editor.setTextSize(16);
        binding.editor.setEditorLanguage(new JavaLanguage()); // Default language
        loadCESettings(getContext(), binding.editor, "act");
    }

    private void loadCESettings(Context context, CodeEditor editor, String prefix) {
        SharedPreferences pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE);
        int text_size = pref.getInt(prefix + "_ts", 12);
        int theme = pref.getInt(prefix + "_theme", 3);
        boolean word_wrap = pref.getBoolean(prefix + "_ww", false);
        boolean auto_c = pref.getBoolean(prefix + "_ac", true);
        boolean auto_complete_symbol_pairs = pref.getBoolean(prefix + "_acsp", true);

        selectTheme(editor, theme);
        binding.editor.setTextSize(text_size);
        binding.editor.setWordwrap(word_wrap);
        binding.editor.getProps().symbolPairAutoCompletion = auto_complete_symbol_pairs;
        binding.editor.getComponent(EditorAutoCompletion.class).setEnabled(auto_c);
    }
    
    public String getText() {
         return binding.editor.getText().toString(); 
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
        EditorColorScheme currentScheme = binding.editor.getColorScheme();
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
*/
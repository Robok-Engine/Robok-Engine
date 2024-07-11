package dev.trindade.robokide.ui.components.editor

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.Nullable

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.components.dialog.RobokDialog
import dev.trindade.robokide.databinding.LayoutCodeEditorBinding

import io.github.rosemoe.sora.widget.CodeEditor
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion
import io.github.rosemoe.sora.widget.schemes.*
import io.github.rosemoe.sora.langs.java.JavaLanguage

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
        initialize()
    }

    private fun initialize() {
        binding.editor.typefaceText = Typeface.MONOSPACE
        binding.editor.textSize = 16
        binding.editor.editorLanguage = JavaLanguage()
        loadCESettings(context, "act")
    }

    private fun loadCESettings(context: Context, prefix: String) {
        val pref = context.getSharedPreferences("hsce", Activity.MODE_PRIVATE)
        val textSize = pref.getInt(prefix + "_ts", 12)
        val theme = pref.getInt(prefix + "_theme", 3)
        val wordWrap = pref.getBoolean(prefix + "_ww", false)
        val autoC = pref.getBoolean(prefix + "_ac", true)
        val autoCompleteSymbolPairs = pref.getBoolean(prefix + "_acsp", true)

        selectTheme(editor, theme)
        binding.editor.textSize = textSize
        binding.editor.wordwrap = wordWrap
        binding.editor.props.symbolPairAutoCompletion = autoCompleteSymbolPairs
        binding.editor.getComponent(EditorAutoCompletion::class.java).isEnabled = autoC
    }

    fun getText(): String {
        return binding.editor.text.toString()
    }

    private fun selectTheme(which: Int) {
        val scheme: EditorColorScheme = when (which) {
            1 -> SchemeGitHub()
            2 -> SchemeEclipse()
            3 -> SchemeDarcula(context)
            4 -> SchemeVS2019()
            5 -> SchemeNotepadXX()
            else -> EditorColorScheme()
        }

        Log.d("CodeEditorView", "Selected theme index: $which")
        binding.editor.colorScheme = scheme
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
            "Darcula" to SchemeDarcula::class.java,
            "VS2019" to SchemeVS2019::class.java,
            "NotepadXX" to SchemeNotepadXX::class.java
        )
    }
}
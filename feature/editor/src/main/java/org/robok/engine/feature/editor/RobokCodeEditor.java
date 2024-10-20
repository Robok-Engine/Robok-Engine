package org.robok.engine.feature.editor;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import io.github.rosemoe.sora.lang.diagnostic.DiagnosticDetail;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticRegion;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.lang.diagnostic.Quickfix;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.component.EditorAutoCompletion;
import io.github.rosemoe.sora.widget.schemes.*;
import io.github.rosemoe.sora.lang.EmptyLanguage;

import kotlin.io.FilesKt;

import org.robok.engine.feature.editor.databinding.LayoutCodeEditorBinding;
import org.robok.engine.feature.editor.languages.java.*;
import org.robok.engine.feature.editor.languages.Language;
import org.robok.engine.feature.editor.schemes.*;
import org.robok.engine.core.antlr4.java.*;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RobokCodeEditor extends LinearLayout implements AntlrListener, EditorListener {

    public static final String TAG = "RobokCodeEditor";

    private DiagnosticsContainer diagnostics; // popup/box of Diagnostic

    private AntlrListener antlrListener; // AntlrListener used.
    private EditorListener editorListener; // EditorListener used.

    private final LayoutCodeEditorBinding binding;

    private EditorConfigManager editorConfigManager;

    private File file; // Editor file

    private boolean isModified;

    /*
     * Default constructor.
     */
    public RobokCodeEditor(Context context, File file) {
        super(context);
        this.file = file;
        this.antlrListener = this;
        this.editorListener = this;

        binding = LayoutCodeEditorBinding.inflate(LayoutInflater.from(context), this, true);
        editorConfigManager = new EditorConfigManager();
        configureEditor();
        configureSymbolView();
    }

    /*
     * This method sets the editor's initial text, font, language...
     */
    private void configureEditor() {
        // Diagnostics
        
        diagnostics = new DiagnosticsContainer();
        
        readFile();

        getSoraCodeEditor().setTypefaceText(AppearanceManager.getTypeface(editorConfigManager.getEditorTypefacePreference()));
        getSoraCodeEditor().setTextSize(16);
        getSoraCodeEditor().setWordwrap(editorConfigManager.isUseWordWrap());
        
        if(getFileExtension().equals("java")) {
            getSoraCodeEditor().setEditorLanguage(new JavaLanguage(this, diagnostics));
            getSoraCodeEditor().getProps().symbolPairAutoCompletion = true;
            getSoraCodeEditor().getComponent(EditorAutoCompletion.class).setEnabled(true);
        } else {
            getSoraCodeEditor().setEditorLanguage(new EmptyLanguage());
        }
        
        getSoraCodeEditor()
                .setColorScheme(
                        AppearanceManager.getTheme(
                                this, editorConfigManager.getEditorThemePreference()));
        
        if(getFileExtension().equals("java")) reloadListeners();
    }
    
    /*
    * Method to get file extension.
    */
    private String getFileExtension() {
        var fileName = getFile().getName();
        var extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return extension;
    }
    
    /*
     * Method that provides the language based on the file extension.
     * @return Language instance of correct language
     */
    private Language getLanguage() {
        return switch (getFileExtension()) {
            case "java" -> new JavaLanguage(this, diagnostics);
            default -> null;
        };
    }
    
    /*
     * Read text of the file of getFile()
     */
    private void readFile() {
        CompletableFuture.supplyAsync(() -> FilesKt.readText(getFile(), StandardCharsets.UTF_8))
                .whenComplete((result, error) -> getSoraCodeEditor().setText(result));
    }

    /*
     * Method to define a symbol view.
     * is already included in the editor, but you can remove it.
     */
    public void configureSymbolView() {
        binding.robokSymbolInput.bindEditor(getSoraCodeEditor());
        binding.robokSymbolInput.addSymbols(
                new String[] {
                    "->", "{", "}", "(", ")", ",", "|", "=", "#", "!", "&", "/", "%", "`", "_", ";",
                    ".", "×", "<", ">", "\"", "?", "+", "-", "*", "/", "<-"
                },
                new String[] {
                    "\t", "{}", "}", "(", ")", ",", ".", ";", "|", "\"", "?", "+", "-", "*", "/"
                });
    }

    /**
     * Method to add a diagnostic box/popup in the sora editor.
     * @param positionStart corresponds to the first character of the error code.
     * @param positionEnd corresponds to the end character of the error code.
     * @param severity corresponds to the severity of the error.
     * @param msg a message about the error to the user.
     */
    public void addDiagnosticInEditor(
        int positionStart,
        int positionEnd,
        short severity, 
        String msg
    ) {
        DiagnosticRegion diagnosticRegion =
            new DiagnosticRegion(
                positionStart,
                positionEnd,
                severity,
                0L,
                new DiagnosticDetail(
                    getContext()
                    .getString(org.robok.engine.strings.R.string.text_error_details),
                    msg,
                    List.of(
                        new Quickfix(
                            "Fix Quick", 
                            0L, () -> quickFix()
                        )
                    ),
                    null
                )
            );
        diagnostics.addDiagnostic(diagnosticRegion);
        getSoraCodeEditor().setDiagnostics(diagnostics);
    }

    /*
     * Method to reloadListeners Language config
     */
    public void reloadListeners() {
        getLanguage().setEditorListener(editorListener);
        getLanguage().setAntlrListener(antlrListener);
    }

    public void release() {
        getSoraCodeEditor().release();
    }

    /*
     * Method to resolve a simple error quickly
     * not implemented yet.
     */
    public void quickFix() {
        // TO-DO: logic to fix basic errors quickly
    }

    /**
     * Method to set the AntlrListener
     * @param antlrListener New listener instance (AntlrListener interface)
     */
    public void setAntlrListener(AntlrListener antlrListener) {
        this.antlrListener = antlrListener;
    }

    /**
     * Method to set the EditorListener
     * @param editorListener New listener instance (EditorListener interface)
     */
    public void setEditorListener(EditorListener editorListener) {
        this.editorListener = editorListener;
    }

    /**
     * Method to directly work with the editor (sora)
     * @return Returns current *io.github.rosemoe.sora.widget.CodeEditor* instance
     */
    public CodeEditor getSoraCodeEditor() {
        return binding.editor;
    }

    /**
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
    public void undo() {
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
     * Method to mark editor value modifierd or not
     * @param isModified  new value
     */
    public void setModified(boolean isModified) {
        this.isModified = isModified;
    }
    
    /*
     * Method to get if current editor value is modified or not
     * @return value of true for yes, false for not
     */
    public boolean isModified() {
        return this.isModified;
    }

    /**
     * Get current file from editor.
     * 
     * @return The file.
     */
    public File getFile() {
        return this.file;
    }

    /**
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

    /**
     * This method is called when some diagnostic status is received.
     * @param isError: returns whether it is an error or not.
     */
    @Override
    public void onDiagnosticStatusReceive(boolean isError) {}

    /*
     * This method is called whenever the editor text is changed.
     */
    @Override
    public void onEditorTextChange() {}

    /*
     * AppearanceManager class
     * subclass to manage Code Editor Appearance.
     */
    public static final class AppearanceManager {

        /**
         * Method to choose editor font typeface.
         * @param typefaceIndex number of theme 0...4
         * @return Return a TypeFace to use on editor
         */
        public static Typeface getTypeface(int typefaceIndex) {
          return switch (typefaceIndex) {
            case 1 -> Typeface.DEFAULT_BOLD;
            case 2 -> Typeface.MONOSPACE;
            case 3 -> Typeface.SANS_SERIF;
            case 4 -> Typeface.SERIF;
            default -> Typeface.DEFAULT;
          };
        }

        /**
         * Method to choose editor theme.
         * @param themeIndex number of theme 0...6
         * @return Return a EditorColorScheme instance
         */
        public static EditorColorScheme getTheme(RobokCodeEditor rcd, int themeIndex) {
            var ctx = rcd.getSoraCodeEditor().getContext();
          return switch (themeIndex) {
            case 1 -> new SchemeRobokTH(ctx);
            case 2 -> new SchemeGitHub();
            case 3 -> new SchemeEclipse();
            case 4 -> new SchemeDarcula();
            case 5 -> new SchemeVS2019();
            case 6 -> new SchemeNotepadXX();
            default -> new SchemeRobok(ctx);
          };
        }
    }
}

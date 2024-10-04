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

import kotlin.io.FilesKt;

import org.robok.engine.feature.editor.databinding.LayoutCodeEditorBinding;
import org.robok.engine.feature.editor.languages.java.*;
import org.robok.engine.feature.editor.languages.Language;
import org.robok.engine.feature.editor.schemes.*;
import org.robok.antlr4.java.*;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class RobokCodeEditor extends LinearLayout implements AntlrListener, EditorListener {

    public static final String TAG = "RobokCodeEditor";

    private DiagnosticsContainer diagnostics; // popup/box of Diagnostic

    private AntlrListener antlrListener; // AntlrListener used.
    private EditorListener editorListener; // EditorListener used.

    private final LayoutCodeEditorBinding binding;

    private Language language; // Configuration of JavaLanguage

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
        language = handleLanguage();
        reload();
        readFile();

        getSoraCodeEditor().setTypefaceText(AppearanceManager.getTypeface(editorConfigManager.getEditorTypefacePreference()));
        getSoraCodeEditor().setTextSize(16);
        getSoraCodeEditor().setEditorLanguage(language);
        getSoraCodeEditor().setWordwrap(editorConfigManager.isUseWordWrap());
        getSoraCodeEditor().getProps().symbolPairAutoCompletion = true;
        getSoraCodeEditor().getComponent(EditorAutoCompletion.class).setEnabled(true);
        getSoraCodeEditor()
                .setColorScheme(
                        AppearanceManager.getTheme(
                                this, editorConfigManager.getEditorThemePreference()));
    }
    
    private Language handleLanguage() {
        if(file.getName().endsWith(".java")) return new JavaLanguage(this, diagnostics);
        return new JavaLanguage(this, diagnostics);
    }

    private void readFile() {
        CompletableFuture.supplyAsync(() -> FilesKt.readText(file, Charset.forName("UTF-8")))
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

    /*
     * Method to add a diagnostic box/popup in the sora editor.
     * @param positionStart corresponds to the first character of the error code.
     * @param positionEnd corresponds to the end character of the error code.
     * @param severity corresponds to the severity of the error.
     * @param msg a message about the error to the user.
     */
    public void addDiagnosticInEditor(
            int positionStart, int positionEnd, short severity, String msg) {
        DiagnosticRegion diagnosticRegion =
                new DiagnosticRegion(
                        positionStart,
                        positionEnd,
                        severity,
                        0L,
                        new DiagnosticDetail(
                                getContext()
                                        .getString(
                                                org.robok.engine.strings.R.string
                                                        .text_error_details),
                                msg,
                                Arrays.asList(new Quickfix("Fix Quick", 0L, () -> quickFix())),
                                null));
        diagnostics.addDiagnostic(diagnosticRegion);
        getSoraCodeEditor().setDiagnostics(diagnostics);
    }

    /*
     * Method to reload Language config
     */
    public void reload() {
        language.setEditorListener(editorListener);
        language.setAntlrListener(antlrListener);
    }

    /*
     * Method to resolve a simple error quickly
     * not implemented yet.
     */
    public void quickFix() {
        // TO-DO: logic to fix basic errors quickly
    }

    /*
     * Method to set the AntlrListener
     * @param antlrListener New listener instance (AntlrListener interface)
     */
    public void setAntlrListener(AntlrListener antlrListener) {
        this.antlrListener = antlrListener;
    }

    /*
     * Method to set the EditorListener
     * @param editorListener New listener instance (EditorListener interface)
     */
    public void setEditorListener(EditorListener editorListener) {
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

    public void markModified() {
        this.isModified = true;
    }

    public void markUnmodified() {
        this.isModified = false;
    }

    public boolean isModified() {
        return this.isModified;
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
}

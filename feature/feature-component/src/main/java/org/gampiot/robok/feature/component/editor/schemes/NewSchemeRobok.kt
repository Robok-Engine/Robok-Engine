package org.gampiot.robok.feature.component.editor.schemes

/*
 * Custom theme class for the Sora Editor based on SchemeDarcula.
 * This class overrides the default color scheme with custom colors.
 */

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import org.gampiot.robok.feature.component.R

class NewSchemeRobok(context: Context) : SchemeDarcula() {

    private val context: Context

    init {
        this.context = context
        
        // General editor colors
        setColor(EditorColorScheme.WHOLE_BACKGROUND, getAttrColor(android.R.attr.colorBackground)) // Editor's background color
        setColor(EditorColorScheme.CURRENT_LINE, getColor(R.color.scheme_robok_current_line)) // Highlight color for the current line
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getColor(R.color.scheme_robok_line_number_panel)) // Background color for line number panel
        setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, getColor(R.color.scheme_robok_line_number_background)) // Line number background
        setColor(EditorColorScheme.LINE_NUMBER, getColor(R.color.scheme_robok_line_number)) // Text color for line numbers
        
        // Syntax highlight colors
        setColor(EditorColorScheme.KEYWORD, getAttrColor(com.google.android.material.R.attr.colorPrimary)) // Keyword color
        setColor(EditorColorScheme.TYPE_NAME, getColor(R.color.scheme_robok_type_name)) // Type name color (e.g., classes, interfaces)
        setColor(EditorColorScheme.LITERAL, getColor(R.color.scheme_robok_literal)) // Literal color (e.g., numbers)
        setColor(EditorColorScheme.STRING, getColor(R.color.scheme_robok_string)) // String literal color
        setColor(EditorColorScheme.COMMENT, getColor(R.color.scheme_robok_comment)) // Comment color
        setColor(EditorColorScheme.DOCS, getColor(R.color.scheme_robok_docs)) // Documentation comments color
        setColor(EditorColorScheme.IDENTIFIER_NAME, getColor(R.color.scheme_robok_identifier)) // Variable and identifier names
        setColor(EditorColorScheme.FUNCTION_NAME, getAttrColor(com.google.android.material.R.attr.colorOnSurface)) // Function name color
        setColor(EditorColorScheme.OPERATOR, getColor(R.color.scheme_robok_operator)) // Operator color (e.g., +, -, *, /)
        setColor(EditorColorScheme.ANNOTATION, getColor(R.color.scheme_robok_annotation)) // Annotation color (e.g., @Override)

        // Bracket matching colors
        setColor(EditorColorScheme.MATCHED_BRACE, getColor(R.color.scheme_robok_matched_brace)) // Matched brace highlight color
        setColor(EditorColorScheme.UNMATCHED_BRACE, getColor(R.color.scheme_robok_unmatched_brace)) // Unmatched brace highlight color

        // Selection and handles
        setColor(EditorColorScheme.SELECTION_BACKGROUND, getColor(R.color.scheme_robok_selection_background)) // Selection background color
        setColor(EditorColorScheme.SELECTION_HANDLE, getColor(R.color.scheme_robok_selection_handle)) // Selection handle color

        // Error and warning underlines
        setColor(EditorColorScheme.ERROR_UNDERLINE, getColor(R.color.scheme_robok_error_underline)) // Error underline color
        setColor(EditorColorScheme.WARNING_UNDERLINE, getColor(R.color.scheme_robok_warning_underline)) // Warning underline color

        // Editor guide lines
        setColor(EditorColorScheme.GUTTER_DIVIDER, getColor(R.color.scheme_robok_gutter_divider)) // Divider line in the gutter
        setColor(EditorColorScheme.NON_PRINTABLE_CHAR, getColor(R.color.scheme_robok_non_printable)) // Non-printable character color
        setColor(EditorColorScheme.CARET, getColor(R.color.scheme_robok_caret)) // Caret (cursor) color
        setColor(EditorColorScheme.CARET_LINE, getColor(R.color.scheme_robok_caret_line)) // Caret line color

        // Additional UI components
        setColor(EditorColorScheme.BLOCK_LINE, getColor(R.color.scheme_robok_block_line)) // Block line color
        setColor(EditorColorScheme.BLOCK_LINE_CURRENT, getColor(R.color.scheme_robok_block_line_current)) // Current block line color
        setColor(EditorColorScheme.RIGHT_MARGIN, getColor(R.color.scheme_robok_right_margin)) // Right margin line color
        setColor(EditorColorScheme.CODE_LENS, getColor(R.color.scheme_robok_code_lens)) // Code lens color
        setColor(EditorColorScheme.SIGNATURE, getColor(R.color.scheme_robok_signature)) // Signature color
        setColor(EditorColorScheme.LINK, getColor(R.color.scheme_robok_link)) // Link color in text
    }

    private fun getAttrColor(@AttrRes resId: Int): Int {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(resId, typedValue, true)
        return if (typedValue.resourceId != 0) {
            ContextCompat.getColor(context, typedValue.resourceId)
        } else {
            typedValue.data
        }
    }

    private fun getColor(resId: Int): Int {
        return ContextCompat.getColor(context, resId)
    }
}
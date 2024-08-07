package org.gampiot.robok.feature.component.editor.schemes

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme

class SchemeRobokTH(context: Context) : EditorColorScheme() {

    val context : Context

    init {
        this.context = context
        setColor(EditorColorScheme.WHOLE_BACKGROUND, getAttrColor(android.R.attr.colorBackground))
        setColor(EditorColorScheme.CURRENT_LINE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_current_line))
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getAttrColor(android.R.attr.colorBackground))
        setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, getAttrColor(android.R.attr.colorBackground))
        setColor(EditorColorScheme.KEYWORD, getAttrColor(com.google.android.material.R.attr.colorPrimary))
        setColor(EditorColorScheme.FUNCTION_NAME, getAttrColor(com.google.android.material.R.attr.colorOnSurface))
        setColor(EditorColorScheme.ATTRIBUTE_VALUE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_attribute_value))
        setColor(EditorColorScheme.ATTRIBUTE_NAME, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_attribute_name))
        setColor(EditorColorScheme.HTML_TAG, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_html_tag))
        setColor(EditorColorScheme.ANNOTATION, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_annotation))
        setColor(EditorColorScheme.IDENTIFIER_NAME, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_identifier_name))
        setColor(EditorColorScheme.IDENTIFIER_VAR, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_identifier_var))
        setColor(EditorColorScheme.LITERAL, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_literal))
        setColor(EditorColorScheme.OPERATOR, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_operator))
        setColor(EditorColorScheme.COMMENT, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_comment))
        setColor(EditorColorScheme.TEXT_SELECTED, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_text_selected))
        setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_matched_text_background))
        setColor(EditorColorScheme.SELECTION_HANDLE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_selection_handle))
        setColor(EditorColorScheme.SELECTION_INSERT, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_selection_insert))
        setColor(EditorColorScheme.SELECTED_TEXT_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_selected_text_background))
        setColor(EditorColorScheme.UNDERLINE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_underline))
        setColor(EditorColorScheme.SIDE_BLOCK_LINE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_side_block_line))
        setColor(EditorColorScheme.NON_PRINTABLE_CHAR, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_non_printable_char))
        setColor(EditorColorScheme.STICKY_SCROLL_DIVIDER, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_sticky_scroll_divider))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_ACTION, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_diagnostic_tooltip_action))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_DETAILED_MSG, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_diagnostic_tooltip_detailed_msg))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_BRIEF_MSG, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_diagnostic_tooltip_brief_msg))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_diagnostic_tooltip_background))
        setColor(EditorColorScheme.FUNCTION_CHAR_BACKGROUND_STROKE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_function_char_background_stroke))
        setColor(EditorColorScheme.HARD_WRAP_MARKER, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_hard_wrap_marker))
        setColor(EditorColorScheme.TEXT_INLAY_HINT_FOREGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_text_inlay_hint_foreground))
        setColor(EditorColorScheme.TEXT_INLAY_HINT_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_text_inlay_hint_background))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_EDITING, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_snippet_background_editing))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_RELATED, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_snippet_background_related))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_INACTIVE, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_snippet_background_inactive))
        setColor(EditorColorScheme.SIGNATURE_TEXT_NORMAL, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_signature_text_normal))
        setColor(EditorColorScheme.SIGNATURE_TEXT_HIGHLIGHTED_PARAMETER, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_signature_text_highlighted_parameter))
        setColor(EditorColorScheme.STATIC_SPAN_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_static_span_background))
        setColor(EditorColorScheme.STATIC_SPAN_FOREGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_static_span_foreground))
        setColor(EditorColorScheme.SIGNATURE_BACKGROUND, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_signature_background))
        setColor(EditorColorScheme.LINE_NUMBER, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_line_number))
        setColor(EditorColorScheme.LINE_NUMBER_CURRENT, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_line_number_current))
        setColor(EditorColorScheme.LINE_DIVIDER, getColor(org.gampiot.robok.feature.component.R.color.scheme_robok_line_divider))
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

    override fun getColor(colorResId: Int): Int {
        return ContextCompat.getColor(context, colorResId)
    }
}
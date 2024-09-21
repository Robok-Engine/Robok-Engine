package org.gampiot.robok.feature.editor.schemes

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
        setColor(EditorColorScheme.CURRENT_LINE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_current_line))
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getAttrColor(android.R.attr.colorBackground))
        setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, getAttrColor(android.R.attr.colorBackground))
        setColor(EditorColorScheme.KEYWORD, getAttrColor(com.google.android.material.R.attr.colorPrimary))
        setColor(EditorColorScheme.FUNCTION_NAME, getAttrColor(com.google.android.material.R.attr.colorOnSurface))
        setColor(EditorColorScheme.ATTRIBUTE_VALUE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_attribute_value))
        setColor(EditorColorScheme.ATTRIBUTE_NAME, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_attribute_name))
        setColor(EditorColorScheme.HTML_TAG, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_html_tag))
        setColor(EditorColorScheme.ANNOTATION, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_annotation))
        setColor(EditorColorScheme.IDENTIFIER_NAME, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_identifier_name))
        setColor(EditorColorScheme.IDENTIFIER_VAR, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_identifier_var))
        setColor(EditorColorScheme.LITERAL, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_literal))
        setColor(EditorColorScheme.OPERATOR, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_operator))
        setColor(EditorColorScheme.COMMENT, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_comment))
        setColor(EditorColorScheme.TEXT_SELECTED, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_text_selected))
        setColor(EditorColorScheme.MATCHED_TEXT_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_matched_text_background))
        setColor(EditorColorScheme.SELECTION_HANDLE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_selection_handle))
        setColor(EditorColorScheme.SELECTION_INSERT, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_selection_insert))
        setColor(EditorColorScheme.SELECTED_TEXT_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_selected_text_background))
        setColor(EditorColorScheme.UNDERLINE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_underline))
        setColor(EditorColorScheme.SIDE_BLOCK_LINE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_side_block_line))
        setColor(EditorColorScheme.NON_PRINTABLE_CHAR, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_non_printable_char))
        setColor(EditorColorScheme.STICKY_SCROLL_DIVIDER, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_sticky_scroll_divider))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_ACTION, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_diagnostic_tooltip_action))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_DETAILED_MSG, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_diagnostic_tooltip_detailed_msg))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_BRIEF_MSG, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_diagnostic_tooltip_brief_msg))
        setColor(EditorColorScheme.DIAGNOSTIC_TOOLTIP_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_diagnostic_tooltip_background))
        setColor(EditorColorScheme.FUNCTION_CHAR_BACKGROUND_STROKE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_function_char_background_stroke))
        setColor(EditorColorScheme.HARD_WRAP_MARKER, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_hard_wrap_marker))
        setColor(EditorColorScheme.TEXT_INLAY_HINT_FOREGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_text_inlay_hint_foreground))
        setColor(EditorColorScheme.TEXT_INLAY_HINT_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_text_inlay_hint_background))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_EDITING, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_snippet_background_editing))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_RELATED, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_snippet_background_related))
        setColor(EditorColorScheme.SNIPPET_BACKGROUND_INACTIVE, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_snippet_background_inactive))
        setColor(EditorColorScheme.SIGNATURE_TEXT_NORMAL, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_signature_text_normal))
        setColor(EditorColorScheme.SIGNATURE_TEXT_HIGHLIGHTED_PARAMETER, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_signature_text_highlighted_parameter))
        setColor(EditorColorScheme.STATIC_SPAN_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_static_span_background))
        setColor(EditorColorScheme.STATIC_SPAN_FOREGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_static_span_foreground))
        setColor(EditorColorScheme.SIGNATURE_BACKGROUND, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_signature_background))
        setColor(EditorColorScheme.LINE_NUMBER, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_line_number))
        setColor(EditorColorScheme.LINE_NUMBER_CURRENT, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_line_number_current))
        setColor(EditorColorScheme.LINE_DIVIDER, ContextCompat.getColor(context, org.gampiot.robok.feature.editor.R.color.scheme_robok_line_divider))
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
}

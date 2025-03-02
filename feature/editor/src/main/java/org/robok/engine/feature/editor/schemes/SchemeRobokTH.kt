package org.robok.engine.feature.editor.schemes

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
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import org.robok.engine.res.ResUtils

class SchemeRobokTH(context: Context) : EditorColorScheme() {

  val context: Context
  val resUtils: ResUtils

  init {
    this.context = context
    resUtils = ResUtils(context)

    setColor(
      EditorColorScheme.WHOLE_BACKGROUND,
      resUtils.getAttrColor(android.R.attr.colorBackground),
    )
    setColor(
      EditorColorScheme.CURRENT_LINE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_current_line),
    )
    setColor(
      EditorColorScheme.LINE_NUMBER_PANEL,
      resUtils.getAttrColor(android.R.attr.colorBackground),
    )
    setColor(
      EditorColorScheme.LINE_NUMBER_BACKGROUND,
      resUtils.getAttrColor(android.R.attr.colorBackground),
    )
    setColor(
      EditorColorScheme.KEYWORD,
      resUtils.getAttrColor(com.google.android.material.R.attr.colorPrimary),
    )
    setColor(
      EditorColorScheme.FUNCTION_NAME,
      resUtils.getAttrColor(com.google.android.material.R.attr.colorOnSurface),
    )
    setColor(
      EditorColorScheme.ATTRIBUTE_VALUE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_attribute_value),
    )
    setColor(
      EditorColorScheme.ATTRIBUTE_NAME,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_attribute_name),
    )
    setColor(
      EditorColorScheme.HTML_TAG,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_html_tag),
    )
    setColor(
      EditorColorScheme.ANNOTATION,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_annotation),
    )
    setColor(
      EditorColorScheme.IDENTIFIER_NAME,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_identifier_name),
    )
    setColor(
      EditorColorScheme.IDENTIFIER_VAR,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_identifier_var),
    )
    setColor(
      EditorColorScheme.LITERAL,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_literal),
    )
    setColor(
      EditorColorScheme.OPERATOR,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_operator),
    )
    setColor(
      EditorColorScheme.COMMENT,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_comment),
    )
    setColor(
      EditorColorScheme.TEXT_SELECTED,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_text_selected),
    )
    setColor(
      EditorColorScheme.MATCHED_TEXT_BACKGROUND,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_matched_text_background
      ),
    )
    setColor(
      EditorColorScheme.SELECTION_HANDLE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_selection_handle),
    )
    setColor(
      EditorColorScheme.SELECTION_INSERT,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_selection_insert),
    )
    setColor(
      EditorColorScheme.SELECTED_TEXT_BACKGROUND,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_selected_text_background
      ),
    )
    setColor(
      EditorColorScheme.UNDERLINE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_underline),
    )
    setColor(
      EditorColorScheme.SIDE_BLOCK_LINE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_side_block_line),
    )
    setColor(
      EditorColorScheme.NON_PRINTABLE_CHAR,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_non_printable_char),
    )
    setColor(
      EditorColorScheme.STICKY_SCROLL_DIVIDER,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_sticky_scroll_divider),
    )
    setColor(
      EditorColorScheme.DIAGNOSTIC_TOOLTIP_ACTION,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_diagnostic_tooltip_action
      ),
    )
    setColor(
      EditorColorScheme.DIAGNOSTIC_TOOLTIP_DETAILED_MSG,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_diagnostic_tooltip_detailed_msg
      ),
    )
    setColor(
      EditorColorScheme.DIAGNOSTIC_TOOLTIP_BRIEF_MSG,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_diagnostic_tooltip_brief_msg
      ),
    )
    setColor(
      EditorColorScheme.DIAGNOSTIC_TOOLTIP_BACKGROUND,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_diagnostic_tooltip_background
      ),
    )
    setColor(
      EditorColorScheme.FUNCTION_CHAR_BACKGROUND_STROKE,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_function_char_background_stroke
      ),
    )
    setColor(
      EditorColorScheme.HARD_WRAP_MARKER,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_hard_wrap_marker),
    )
    setColor(
      EditorColorScheme.TEXT_INLAY_HINT_FOREGROUND,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_text_inlay_hint_foreground
      ),
    )
    setColor(
      EditorColorScheme.TEXT_INLAY_HINT_BACKGROUND,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_text_inlay_hint_background
      ),
    )
    setColor(
      EditorColorScheme.SNIPPET_BACKGROUND_EDITING,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_snippet_background_editing
      ),
    )
    setColor(
      EditorColorScheme.SNIPPET_BACKGROUND_RELATED,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_snippet_background_related
      ),
    )
    setColor(
      EditorColorScheme.SNIPPET_BACKGROUND_INACTIVE,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_snippet_background_inactive
      ),
    )
    setColor(
      EditorColorScheme.SIGNATURE_TEXT_NORMAL,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_signature_text_normal),
    )
    setColor(
      EditorColorScheme.SIGNATURE_TEXT_HIGHLIGHTED_PARAMETER,
      resUtils.getColor(
        org.robok.engine.feature.editor.R.color.scheme_robok_signature_text_highlighted_parameter
      ),
    )
    setColor(
      EditorColorScheme.STATIC_SPAN_BACKGROUND,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_static_span_background),
    )
    setColor(
      EditorColorScheme.STATIC_SPAN_FOREGROUND,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_static_span_foreground),
    )
    setColor(
      EditorColorScheme.SIGNATURE_BACKGROUND,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_signature_background),
    )
    setColor(
      EditorColorScheme.LINE_NUMBER,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_line_number),
    )
    setColor(
      EditorColorScheme.LINE_NUMBER_CURRENT,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_line_number_current),
    )
    setColor(
      EditorColorScheme.LINE_DIVIDER,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_line_divider),
    )
  }
}

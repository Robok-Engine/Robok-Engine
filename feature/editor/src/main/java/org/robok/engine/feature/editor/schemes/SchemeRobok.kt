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

/* 
 *  The default Robok Theme.
*/

import android.content.Context
import android.util.TypedValue

import androidx.annotation.AttrRes

import androidx.core.content.ContextCompat

import io.github.rosemoe.sora.widget.schemes.SchemeDarcula
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme

import org.robok.engine.feature.editor.R

class SchemeRobok(context: Context) : SchemeDarcula() {

    val context : Context

    init {
        this.context = context
        setColor(EditorColorScheme.WHOLE_BACKGROUND, getAttrColor(android.R.attr.colorBackground)) // set the background color
        setColor(EditorColorScheme.CURRENT_LINE, getColor(org.robok.engine.feature.editor.R.color.scheme_robok_current_line)) // set the current line color
        setColor(EditorColorScheme.LINE_NUMBER_PANEL, getAttrColor(android.R.attr.colorBackground)) // set color bar for line numbers
        setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, getAttrColor(android.R.attr.colorBackground)); // set color bar for line numbers
        setColor(EditorColorScheme.KEYWORD, getAttrColor(com.google.android.material.R.attr.colorPrimary)); // set keywords colors
        setColor(EditorColorScheme.FUNCTION_NAME, getAttrColor(com.google.android.material.R.attr.colorPrimary)); // set function name colors
        setColor(EditorColorScheme.IDENTIFIER_NAME, ContextCompat.getColor(context, org.robok.engine.feature.editor.R.color.scheme_robok_identifier_name));
        setColor(EditorColorScheme.TEXT_NORMAL, ContextCompat.getColor(context, org.robok.engine.feature.editor.R.color.scheme_robok_text_normal));
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
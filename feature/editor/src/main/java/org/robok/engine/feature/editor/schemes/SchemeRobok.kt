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
import com.google.android.material.R as MaterialR
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula
import org.robok.engine.feature.editor.R
import org.robok.engine.res.ResUtils

class SchemeRobok(context: Context) : SchemeDarcula() {

  val context: Context
  val resUtils: ResUtils

  init {
    this.context = context
    resUtils = ResUtils(context)

    val primary = resUtils.getAttrColor(MaterialR.attr.colorPrimary)
    val surface = resUtils.getAttrColor(MaterialR.attr.colorSurface)
    val onSurface = resUtils.getAttrColor(MaterialR.attr.colorOnSurface)

    setColor(EditorColorScheme.WHOLE_BACKGROUND, surface)
    setColor(
      EditorColorScheme.CURRENT_LINE,
      resUtils.getColor(org.robok.engine.feature.editor.R.color.scheme_robok_current_line),
    )
    setColor(EditorColorScheme.LINE_NUMBER_PANEL, surface)
    setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, surface)
    setColor(EditorColorScheme.KEYWORD, primary)
    setColor(EditorColorScheme.FUNCTION_NAME, onSurface)
    setColor(EditorColorScheme.IDENTIFIER_NAME, primary)
    setColor(EditorColorScheme.TEXT_NORMAL, onSurface)
    setColor(EditorColorScheme.OPERATOR, onSurface)
  }
}

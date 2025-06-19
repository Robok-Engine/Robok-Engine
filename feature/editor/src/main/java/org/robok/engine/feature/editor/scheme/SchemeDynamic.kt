package org.robok.engine.feature.editor.scheme

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

class SchemeDynamic(context: Context) : SchemeDarcula() {

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

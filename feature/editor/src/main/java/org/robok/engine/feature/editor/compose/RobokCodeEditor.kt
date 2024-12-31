package org.robok.engine.feature.editor.compose

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import java.io.File
import org.robok.engine.feature.editor.RobokCodeEditor as AndroidRobokCodeEditor

@Composable
fun RobokCodeEditor(modifier: Modifier = Modifier, state: RobokCodeEditorState) {
  val context = LocalContext.current
  val codeEditorFactory = remember { setCodeEditorFactory(context = context, state = state) }
  AndroidView(factory = { codeEditorFactory }, modifier = modifier, onRelease = { it.release() })
}

private fun setCodeEditorFactory(
  context: Context,
  state: RobokCodeEditorState,
): AndroidRobokCodeEditor {
  val androidRobokCodeEditor = AndroidRobokCodeEditor(context, state.file!!)
  state.view = androidRobokCodeEditor
  return androidRobokCodeEditor
}

@Composable fun rememberRobokCodeEditorState() = remember { RobokCodeEditorState() }

data class RobokCodeEditorState(var view: AndroidRobokCodeEditor? = null, var file: File? = null)

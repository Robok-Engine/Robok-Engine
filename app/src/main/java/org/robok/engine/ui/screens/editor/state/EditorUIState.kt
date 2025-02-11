package org.robok.engine.ui.screens.editor.state

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

import org.robok.engine.feature.editor.RobokCodeEditor
import org.robok.engine.io.File
import org.robok.engine.ui.screens.editor.EditorNavigateActions

data class EditorUIState(
  val title: String = "Robok",
  val canRedo: Boolean = false,
  val canUndo: Boolean = false,
  val hasFileOpen: Boolean = false,
  val openedFiles: List<File> = emptyList(),
  val selectedFileIndex: Int = 0,
  val editors: List<RobokCodeEditor> = emptyList(),
  val moreOptionOpen: Boolean = false,
  val isBackClicked: Boolean = false,
  val isRunClicked: Boolean = false,
  val editorNavigateActions: EditorNavigateActions? = null,
)

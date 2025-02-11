package org.robok.engine.ui.screens.editor.event

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

import org.robok.engine.io.File

sealed interface EditorEvent {
  data class SelectFile(val index: Int) : EditorEvent

  data class OpenFile(val file: File) : EditorEvent

  data class CloseFile(val index: Int) : EditorEvent

  data class CloseOthers(val index: Int) : EditorEvent

  data object CloseAll : EditorEvent

  data object SaveFile : EditorEvent

  data object SaveAllFiles : EditorEvent

  data object Undo : EditorEvent

  data object Redo : EditorEvent

  data object More : EditorEvent

  data object Run : EditorEvent
}

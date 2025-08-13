package org.robok.engine.ui.screens.editor.event

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

import java.io.File

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

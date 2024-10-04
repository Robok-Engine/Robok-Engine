package org.robok.engine.ui.activities.editor.event

import java.io.File

sealed interface EditorEvent {
    data class OpenFile(val file: File): EditorEvent
    data class CloseFile(val index: Int): EditorEvent
    object CloseOthers : EditorEvent
    object CloseAll : EditorEvent
}
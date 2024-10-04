package org.robok.engine.ui.activities.editor.state

import java.io.File

data class EditorState(
   val currentIndex: Int,
   val currentFile: File?
)
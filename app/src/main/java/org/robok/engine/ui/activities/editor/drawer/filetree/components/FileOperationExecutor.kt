package org.robok.engine.ui.activities.editor.drawer.filetree.components

import android.content.Context
import org.robok.engine.feature.filetree.events.FileTreeEventListener
import java.io.File

class FileOperationExecutor(
  private val context: Context,
  private val onFileClicked: (File) -> Unit = { _: File -> },
  private val onFolderClicked: (File) -> Unit = { _: File -> },
  private val onFileLongClicked: (File) -> Boolean = { _: File -> false },
  private val onFolderLongClicked: (File) -> Boolean = { _: File -> false },
  private val onFileTreeViewUpdate: (Int, Int) -> Unit = { _: Int, _: Int -> }
) : FileTreeEventListener {

  override fun onFileClick(file: File) = onFileClicked(file)

  override fun onFolderClick(folder: File) = onFolderClicked(folder)

  override fun onFileLongClick(file: File): Boolean = onFileLongClicked(file)

  override fun onFolderLongClick(folder: File): Boolean = onFolderLongClicked(folder)

  override fun onFileTreeViewUpdated(startPosition: Int, itemCount: Int) =
    onFileTreeViewUpdate(startPosition, itemCount)
}
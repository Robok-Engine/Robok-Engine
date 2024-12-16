package org.robok.engine.ui.activities.editor.drawer.filetree.components

import android.content.Context
import android.widget.Toast
import org.robok.engine.feature.filetree.events.FileTreeEventListener
import java.io.File

class FileOperationExecutor(
  private val context: Context,
  private val onFileClick: (File) -> Unit = { },
  private val onFolderClick: (File) -> Unit = { },
  private val onFileLongClick: (File) -> Boolean = { false },
  private val onFolderLongClick: (File) -> Boolean = { false },
  private val onFileTreeViewUpdated: (Int, Int) -> Unit = { _, _ -> }
) : FileTreeEventListener {

  override fun onFileClick(file: File) = onFileClick(file)

  override fun onFolderClick(folder: File) = onFolderClick(folder)

  override fun onFileLongClick(file: File): Boolean = onFileLongClick(file)

  override fun onFolderLongClick(folder: File): Boolean = onFolderLongClick(folder)

  override fun onFileTreeViewUpdated(startPosition: Int, itemCount: Int) =
    onFileTreeViewUpdated(startPosition, itemCount)
}
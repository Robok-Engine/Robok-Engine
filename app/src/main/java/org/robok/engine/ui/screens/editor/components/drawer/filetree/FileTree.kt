package org.robok.engine.ui.screens.editor.components.drawer.filetree

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

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.viewinterop.AndroidView
import java.io.File
import org.robok.engine.feature.treeview.interfaces.FileClickListener
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.feature.treeview.provider.DefaultFileIconProvider
import org.robok.engine.feature.treeview.provider.FileWrapper
import org.robok.engine.feature.treeview.widget.FileTree as FileTreeView

@Composable
fun FileTree(
  path: String,
  onClick: (Node<FileObject>) -> Unit,
  modifier: Modifier = Modifier,
  state: FileTreeState,
) {
  val context = LocalContext.current
  val fileTreeFactory = remember {
    setFileTreeFactory(context = context, path = path, onClick = onClick, state = state)
  }
  AndroidView(factory = { fileTreeFactory }, modifier = modifier)
}

private fun setFileTreeFactory(
  context: Context,
  path: String,
  onClick: (Node<FileObject>) -> Unit,
  state: FileTreeState,
): FileTreeView {
  val fileObject = FileWrapper(File(path))
  val fileTree =
    FileTreeView(context).apply {
      loadFiles(fileObject)
      setOnFileClickListener(
        object : FileClickListener {
          override fun onClick(node: Node<FileObject>) {
            onClick(node)
          }
        }
      )
      setIconProvider(DefaultFileIconProvider(context))
    }
  state.fileTreeView = fileTree
  return fileTree
}

data class FileTreeState(var fileTreeView: FileTreeView? = null)

@Composable fun rememberFileTreeState() = remember { FileTreeState() }

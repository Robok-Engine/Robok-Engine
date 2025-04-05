package org.robok.engine.feature.treeview.widget

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
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.robok.engine.feature.treeview.FileTreeColors
import org.robok.engine.feature.treeview.adapters.FileTreeAdapter
import org.robok.engine.feature.treeview.interfaces.FileClickListener
import org.robok.engine.feature.treeview.interfaces.FileIconProvider
import org.robok.engine.feature.treeview.interfaces.FileLongClickListener
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.feature.treeview.provider.DefaultFileIconProvider
import org.robok.engine.feature.treeview.util.Sorter

class FileTree @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0,
  colors: FileTreeColors,
) : RecyclerView(context, attrs, defStyleAttr) {

  private var fileTreeAdapter: FileTreeAdapter
  private lateinit var rootFileObject: FileObject
  private var init = false
  private var showRootNode: Boolean = true

  init {
    setItemViewCacheSize(100)
    layoutManager = LinearLayoutManager(context)
    fileTreeAdapter = FileTreeAdapter(context, this, colors)
  }

  fun getRootFileObject(): FileObject {
    return rootFileObject
  }

  fun setIconProvider(fileIconProvider: FileIconProvider) {
    fileTreeAdapter.iconProvider = fileIconProvider
  }

  fun setOnFileClickListener(clickListener: FileClickListener) {
    fileTreeAdapter.onClickListener = clickListener
  }

  fun setOnFileLongClickListener(longClickListener: FileLongClickListener) {
    fileTreeAdapter.onLongClickListener = longClickListener
  }

  fun loadFiles(file: FileObject, showRootNodeX: Boolean? = null) {
    rootFileObject = file

    showRootNodeX?.let { showRootNode = it }

    val nodes: List<Node<FileObject>> =
      if (showRootNode) {
        mutableListOf<Node<FileObject>>().apply { add(Node(file)) }
      } else {
        Sorter.sort(file)
      }

    if (!init) {
      if (fileTreeAdapter.iconProvider == null) {
        fileTreeAdapter.iconProvider = DefaultFileIconProvider(context)
      }
      adapter = fileTreeAdapter
      init = true
    }

    fileTreeAdapter.submitList(nodes)
    if (showRootNode) {
      fileTreeAdapter.expandNode(nodes[0])
    }
  }

  fun reloadFileTree() {
    val nodes: List<Node<FileObject>> =
      if (showRootNode) {
        mutableListOf<Node<FileObject>>().apply { add(Node(rootFileObject)) }
      } else {
        Sorter.sort(rootFileObject)
      }
    fileTreeAdapter.submitList(nodes)
  }
}
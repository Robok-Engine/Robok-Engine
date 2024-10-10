package org.robok.engine.feature.treeview.widget

/*
 *  This file is part of Xed-Editor (Karbon) © 2024.
 *
 *  Xed-Editor (Karbon) is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Xed-Editor (Karbon) is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Xed-Editor (Karbon).  If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.robok.engine.feature.treeview.adapters.FileTreeAdapter
import org.robok.engine.feature.treeview.interfaces.FileClickListener
import org.robok.engine.feature.treeview.interfaces.FileIconProvider
import org.robok.engine.feature.treeview.interfaces.FileLongClickListener
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.feature.treeview.provider.DefaultFileIconProvider
import org.robok.engine.feature.treeview.util.Sorter

class FileTree : RecyclerView {
    private var fileTreeAdapter: FileTreeAdapter
    private lateinit var rootFileObject: FileObject

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int,
    ) : super(context, attrs, defStyleAttr)

    init {
        setItemViewCacheSize(100)
        layoutManager = LinearLayoutManager(context)
        fileTreeAdapter = FileTreeAdapter(context, this)
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

    private var init = false
    private var showRootNode: Boolean = true

    fun loadFiles(file: FileObject, showRootNodeX: Boolean? = null) {
        rootFileObject = file

        showRootNodeX?.let { showRootNode = it }

        val nodes: List<Node<FileObject>> =
            if (showRootNode) {
                mutableListOf<Node<FileObject>>().apply { add(Node(file)) }
            } else {
                Sorter.sort(file)
            }

        if (init.not()) {
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

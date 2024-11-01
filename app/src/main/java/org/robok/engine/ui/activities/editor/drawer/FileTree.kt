package org.robok.engine.ui.activities.editor.drawer

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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import org.robok.engine.strings.Strings
import org.robok.engine.feature.treeview.widget.FileTree as FileTreeView
import org.robok.engine.feature.treeview.interfaces.FileClickListener
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node
import org.robok.engine.feature.treeview.provider.DefaultFileIconProvider
import org.robok.engine.feature.treeview.provider.FileWrapper

@Composable
fun FileTree(
    path: String,
    onClick: (Node<FileObject>) -> Unit
) {
    AndroidView(
        factory = { context ->
            val fileObject = FileWrapper(File(path))
            FileTreeView(context).apply {
                loadFiles(fileObject)
                setOnFileClickListener(object : FileClickListener {
                    override fun onClick(node: Node<FileObject>) {
                        onClick(node)
                    }
                })
                setIconProvider(DefaultFileIconProvider(context))
            }
        }
    )
}
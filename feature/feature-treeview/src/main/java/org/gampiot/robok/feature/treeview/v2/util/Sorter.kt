package org.gampiot.robok.feature.treeview.v2.util

import org.gampiot.robok.feature.treeview.v2.interfaces.FileObject
import org.gampiot.robok.feature.treeview.v2.model.Node

object Sorter {
    fun sort(root: FileObject): List<Node<FileObject>> {
        return root.listFiles()
            .sortedWith(compareBy<FileObject> { !it.isDirectory() }.thenBy { it.getName() })
            .map { Node(it) }
    }
}
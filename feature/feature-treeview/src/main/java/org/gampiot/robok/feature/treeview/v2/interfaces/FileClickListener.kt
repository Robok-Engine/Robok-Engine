package org.gampiot.robok.feature.treeview.v2.interfaces

import org.gampiot.robok.feature.treeview.v2.model.Node

interface FileClickListener {
    fun onClick(node: Node<FileObject>)
}

interface FileLongClickListener {
    fun onLongClick(node: Node<FileObject>)
}
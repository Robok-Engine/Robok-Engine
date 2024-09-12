package org.gampiot.robok.feature.treeview.v2.interfaces

import android.graphics.drawable.Drawable

import org.gampiot.robok.feature.treeview.v2.model.Node

interface FileIconProvider {
    fun getIcon(node: Node<FileObject>):Drawable?
    fun getChevronRight():Drawable?
    fun getExpandMore():Drawable?
}
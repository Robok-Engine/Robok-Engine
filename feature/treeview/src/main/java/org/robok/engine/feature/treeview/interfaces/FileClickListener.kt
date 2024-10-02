package org.robok.engine.feature.treeview.interfaces

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

import org.robok.engine.feature.treeview.model.Node

interface FileClickListener {
    fun onClick(node: Node<FileObject>)
}

interface FileLongClickListener {
    fun onLongClick(node: Node<FileObject>)
}
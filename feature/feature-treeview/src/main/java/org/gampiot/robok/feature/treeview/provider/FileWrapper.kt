package org.gampiot.robok.feature.treeview.provider

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

import org.gampiot.robok.feature.treeview.interfaces.FileObject

import java.io.File

//wrapper for java.io.File
class FileWrapper(val file: File) : FileObject {

    override fun listFiles(): List<FileObject> {
        val list = file.listFiles()
        if (list.isNullOrEmpty()){
            return emptyList()
        }

        return list.map { f -> file(f) }
    }

    fun getNativeFile():File{
        return file
    }

    override fun isDirectory(): Boolean {
        return file.isDirectory
    }

    override fun isFile(): Boolean {
       return file.isFile
    }

    override fun getName(): String {
       return file.name
    }

    override fun getParentFile(): FileObject? {
        return file.parentFile?.let { file(it) }
    }

    override fun getAbsolutePath(): String {
        return file.absolutePath
    }
}
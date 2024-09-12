package org.gampiot.robok.feature.treeview.v2.interfaces

import java.io.Serializable

interface FileObject : Serializable{
    fun listFiles():List<FileObject>
    fun isDirectory():Boolean
    fun isFile():Boolean
    fun getName():String
    fun getParentFile(): FileObject?
    fun getAbsolutePath():String
}
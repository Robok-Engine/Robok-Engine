package org.robok.engine.ui.activities.editor.viewmodel

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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider

import org.robok.engine.ui.activities.editor.state.EditorState
import org.robok.engine.ui.activities.editor.event.EditorEvent

import java.io.File

class EditorViewModel : ViewModel() {

    private val _editorState = MutableLiveData(EditorState(-1, null))
    private val _editorEvent = MutableLiveData<EditorEvent>()
    private val _files = MutableLiveData(mutableListOf<File>())

    val editorState: LiveData<EditorState>
        get() = _editorState

    val editorEvent: LiveData<EditorEvent>
        get() = _editorEvent

    val files: LiveData<MutableList<File>>
        get() = _files

    val openedFiles: List<File>
        get() = files.value ?: listOf()

    val fileCount: Int
        get() = files.value?.size ?: 0

    val currentFileIndex: Int
        get() = editorState.value?.currentIndex ?: -1

    val currentFile: File?
        get() = editorState.value?.currentFile

    fun openFile(file: File) {
        _editorEvent.value = EditorEvent.OpenFile(file)
    }

    fun closeFile(index: Int) {
        _editorEvent.value = EditorEvent.CloseFile(index)
    }

    fun closeOthers() {
        _editorEvent.value = EditorEvent.CloseOthers
    }

    fun closeAll() {
        _editorEvent.value = EditorEvent.CloseAll
    }

    fun setCurrentFile(index: Int) {
        _editorState.value = _editorState.value!!.copy(
            currentIndex = index,
            currentFile = openedFiles[index],
        )
    }

    fun addFile(file: File) {
        val files = _files.value!!
        files.add(file)
        _files.value = files
    }

    fun removeFile(index: Int) {
        val files = _files.value!!
        files.removeAt(index)
        _files.value = files
    }
    
    fun removeAllFiles() {
        val files = _files.value!!
        files.clear()
        _files.value = files
    }

    fun indexOfFile(file: File): Int {
        val files = this.openedFiles
        for (i in files.indices) {
          if (files[i] == file) {
            return i
          }
        }
        return -1
    }
}

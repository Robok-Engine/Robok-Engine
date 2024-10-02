package org.robok.engine.ui.activities.editor.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider

import java.io.File

class EditorViewModel : ViewModel() {

    private val _editorState = MutableLiveData<EditorState>(EditorState(-1, null))
    private val _editorEvent = MutableLiveData<EditorEvent>()
    private val _files = MutableLiveData<MutableList<File>>(mutableListOf<File>())

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
        get() = editorState.value?.currentFile ?: null

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

    sealed interface EditorEvent {
        data class OpenFile(val file: File): EditorEvent
        data class CloseFile(val index: Int): EditorEvent
        object CloseOthers : EditorEvent
        object CloseAll : EditorEvent
    }

    data class EditorState(
        val currentIndex: Int,
        val currentFile: File?
    )
}

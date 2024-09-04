package org.gampiot.robok.feature.settings.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import org.gampiot.robok.feature.settings.repositories.AppPreferencesRepository

class AppPreferencesViewModel(
    private val repo: AppPreferencesRepository
) : ViewModel() {
     val editorTheme = repo.editorTheme
     val editorIsUseWordWrap = repo.editorIsUseWordWrap
 
     fun changeEditorTheme (value: Int) {
         viewModelScope.launch {
              repo.changeEditorTheme(value)
         }
     }
     
     fun enableEditorWordWrap (value: Boolean) {
         viewModelScope.launch {
              repo.enableEditorWordWrap(value)
         }
     }
}
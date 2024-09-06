package org.gampiot.robok.feature.editor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel

class EditorConfigManager : KoinComponent {

    private val appPreferencesViewModel: AppPreferencesViewModel by inject()

    val editorTheme: Flow<Int> get() = appPreferencesViewModel.editorTheme
    val editorTypeface: Flow<Int> get() = appPreferencesViewModel.editorTypeface
    val editorIsUseWordWrap: Flow<Boolean> get() = appPreferencesViewModel.editorIsUseWordWrap
    
    /*
    * Method to get Editor theme index
    * @return Return a Int (0..6) with theme index
    */
    fun getEditorThemePreference(): Int {
        return runBlocking {
            editorTheme.first()
        }
    }
    
    /*
    * Method to get Editor theme index
    * @return Return a Int (0..6) with theme index
    */
    fun getEditorTypefacePreference(): Int {
        return runBlocking {
            editorTypeface.first()
        }
    }
    
    /*
    * Method to get if is to use Word Wrap on editor
    * @return Return true or false
    */
    fun isUseWordWrap(): Boolean {
        return runBlocking {
            editorIsUseWordWrap.first()
        }
    }

    /*
    * Method to set Editor theme index
    * @param value A Int of new theme index
    */
    fun setEditorTheme(value: Int) {
        appPreferencesViewModel.changeEditorTheme(value)
    }
    
    /*
    * Method to set Editor theme index
    * @param value A Int of new theme index
    */
    fun setEditorTypeface(value: Int) {
        appPreferencesViewModel.changeEditorTypeface(value)
    }
    
    /*
    * Method to set if editor will use WordWrap
    * @param value A Boolean to enable or disable
    */
    fun setEditorIsUseWordWrap(value: Boolean) {
        appPreferencesViewModel.enableEditorWordWrap(value)
    }
}

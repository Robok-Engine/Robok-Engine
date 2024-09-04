package org.gampiot.robok.feature.editor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel

class EditorConfigManager : KoinComponent {

    private val appPreferencesViewModel: AppPreferencesViewModel by inject()

    val editorTheme: Flow<Int> get() = appPreferencesViewModel.editorTheme

    /*
    * Method to get Editor theme index
    * @return Return a Int with theme index
    */
    fun getEditorThemeInt(): Int {
        return runBlocking {
            editorTheme.first()
        }
    }

    /*
    * Method to set Editor theme index
    * @param value A Int of new theme index
    */
    fun setEditorTheme(value: Int) {
        appPreferencesViewModel.changeEditorTheme(value)
    }
}

package org.gampiot.robok.feature.editor

// From I.A

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Manager : KoinComponent {

    private val appPreferencesViewModel: AppPreferencesViewModel by inject()

    // Expose the Flow from the ViewModel
    val editorTheme: Flow<Int> get() = appPreferencesViewModel.editorTheme

    // Method to get the current theme value
    fun getEditorTheme(): Int {
        return runBlocking {
            // Collect the first value from the Flow
            editorTheme.first()
        }
    }

    // Method to set a new theme value
    fun setEditorTheme(value: Int) {
        appPreferencesViewModel.changeEditorTheme(value)
    }
}

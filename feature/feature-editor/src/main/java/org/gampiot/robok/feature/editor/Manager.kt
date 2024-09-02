package org.gampiot.robok.feature.editor

// form A.I lol

import kotlinx.coroutines.flow.StateFlow

import org.gampiot.robok.feature.settings.viewmodels.AppPreferencesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Manager : KoinComponent {

    private val appPreferencesViewModel: AppPreferencesViewModel by inject()

    val editorTheme: StateFlow<Int> get() = appPreferencesViewModel.editorTheme

    fun getEditorTheme(): Int {
        return editorTheme.value
    }

    fun setEditorTheme(value: Int) {
        appPreferencesViewModel.changeEditorTheme(value)
    }
}

package org.robok.engine.feature.editor

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

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

import org.robok.engine.feature.settings.compose.viewmodels.AppPreferencesViewModel

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

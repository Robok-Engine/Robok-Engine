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
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel

class EditorConfigManager : KoinComponent {

  private val editorPreferences: PreferencesViewModel by inject()

  private val editorTheme: Flow<Int>
    get() = preferencesViewModel.editorPreferences.theme
  private val editorTypeface: Flow<Int>
    get() = preferencesViewModel.editorPreferences.typeface
  private val editorIsUseWordWrap: Flow<Boolean>
    get() = preferencesViewModel.editorPreferences.isUseWordWrap
  private val editorFont: Flow<Int>
    get() = preferencesViewModel.editorPreferences.font

  /**
   * Method to get Editor theme index
   * @return Return a Int (0..6) with theme index 
   */
  fun getEditorTheme(): Int =
    runBlocking { editorTheme.first() }

  /**
   * Method to get Editor typeface index
   * @return Return a Int with typeface index 
   */
  fun getEditorTypeface(): Int =
    runBlocking { editorTypeface.first() }

  /**
   * Method to get if is to use Word Wrap on editor
   * @return Return true or false
   */
  fun getEditorIsUseWordWrap(): Boolean =
    runBlocking { editorIsUseWordWrap.first() }

  /**
   * Method to get editor font index
   * @return Return an Int with font index 
   */
  fun getEditorFont(): Int =
    runBlocking { editorFont.first() }

  /**
   * Method to set Editor theme index
   * @param value A Int of new theme index
   */

  fun setEditorTheme(value: Int) =
    preferencesViewModel.editorPreferences.setEditorTheme(value)

  /**
   * Method to set Editor typeface index
   * @param value A Int of new typeface index
   */
  fun setEditorTypeface(value: Int) =
    preferencesViewModel.editorPreferences.setEditorTypeface(value)

  /**
   * Method to set if editor will use WordWrap
   * @param value A Boolean to enable or disable
   */
  fun setEditorWordWrapEnable(value: Boolean) =
    preferencesViewModel.editorPreferences.setEditorWordWrapEnable(value)

  /**
   * Method to set editor font
   * @param value A font number index
   */
  fun setEditorFont(value: Int) =
    preferencesViewModel.editorPreferences.setEditorFont(value)
}
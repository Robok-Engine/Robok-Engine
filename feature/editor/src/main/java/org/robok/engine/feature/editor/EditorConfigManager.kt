package org.robok.engine.feature.editor

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel

class EditorConfigManager : KoinComponent {

  private val appPreferencesViewModel: PreferencesViewModel by inject()

  private val editorTheme: Flow<Int>
    get() = appPreferencesViewModel.editorTheme

  private val editorTypeface: Flow<Int>
    get() = appPreferencesViewModel.editorTypeface

  private val editorIsUseWordWrap: Flow<Boolean>
    get() = appPreferencesViewModel.editorIsUseWordWrap

  private val editorFont: Flow<Int>
    get() = appPreferencesViewModel.editorFont

  /*
   * Method to get Editor theme index
   * @return Return a Int (0..6) with theme index
   */
  fun getEditorTheme(): Int = runBlocking { editorTheme.first() }

  /*
   * Method to get Editor theme index
   * @return Return a Int (0..6) with theme index
   */
  fun getEditorTypeface(): Int = runBlocking { editorTypeface.first() }

  /*
   * Method to get if is to use Word Wrap on editor
   * @return Return true or false
   */
  fun getEditorIsUseWordWrap(): Boolean = runBlocking { editorIsUseWordWrap.first() }

  /*
   * Method to get if is to use Word Wrap on editor
   * @return Return true or false
   */
  fun getEditorFont(): Int = runBlocking { editorFont.first() }

  /*
   * Method to set Editor theme index
   * @param value A Int of new theme index
   */
  fun setEditorTheme(value: Int) = appPreferencesViewModel.setEditorTheme(value)

  /*
   * Method to set Editor theme index
   * @param value A Int of new theme index
   */
  fun setEditorTypeface(value: Int) = appPreferencesViewModel.setEditorTypeface(value)

  /*
   * Method to set if editor will use WordWrap
   * @param value A Boolean to enable or disable
   */
  fun setEditorWordWrapEnable(value: Boolean) =
    appPreferencesViewModel.setEditorWordWrapEnable(value)

  /*
   * Method to set editor font
   * @param value A font number index
   */
  fun setEditorFont(value: Int) = appPreferencesViewModel.setEditorFont(value)
}

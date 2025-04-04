package org.robok.engine.core.settings.repositories

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

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import org.robok.engine.core.settings.DefaultValues

class PreferencesRepository(private val dataStore: DataStore<Preferences>) {

  val appPreferences = AppPreferences(dataStore)
  val editorPreferences = EditorPreferences(dataStore)

  class AppPreferences(private val dataStore: DataStore<Preferences>) {
    private val appIsUseMonetPreference = booleanPreferencesKey("app_monet")
    private val appIsUseAmoledPreference = booleanPreferencesKey("app_amoled")
    private val appIsUseBlurPreference = booleanPreferencesKey("app_blur")

    val isUseMonet = dataStore.data.map { it[appIsUseMonetPreference] ?: DefaultValues.App.USE_MONET }
    val isUseAmoled = dataStore.data.map { it[appIsUseAmoledPreference] ?: DefaultValues.App.USE_AMOLED }
    val isUseBlur = dataStore.data.map { it[appIsUseBlurPreference] ?: DefaultValues.App.USE_BLUR }

    suspend fun setUseMonetEnable(value: Boolean) =
        dataStore.edit { it[appIsUseMonetPreference] = value }

    suspend fun setUseAmoledEnable(value: Boolean) =
        dataStore.edit { it[appIsUseAmoledPreference] = value }

    suspend fun setUseBlurEnable(value: Boolean) =
        dataStore.edit { it[appIsUseBlurPreference] = value }
  }

  class EditorPreferences(private val dataStore: DataStore<Preferences>) {
    private val editorThemePreference = intPreferencesKey("editor_theme")
    private val editorTypefacePreference = intPreferencesKey("editor_typeface")
    private val editorIsUseWordWrapPreference = booleanPreferencesKey("editor_word_wrap")
    private val editorFontPreference = intPreferencesKey("editor_font")

    val theme = dataStore.data.map { it[editorThemePreference] ?: DefaultValues.Editor.THEME }
    val typeface = dataStore.data.map { it[editorTypefacePreference] ?: DefaultValues.Editor.TYPEFACE }
    val isUseWordWrap = dataStore.data.map { it[editorIsUseWordWrapPreference] ?: DefaultValues.Editor.USE_WORD_WRAP }
    val font = dataStore.data.map { it[editorFontPreference] ?: DefaultValues.Editor.FONT }

    suspend fun setEditorTheme(value: Int) =
        dataStore.edit { it[editorThemePreference] = value }

    suspend fun setEditorTypeface(value: Int) =
        dataStore.edit { it[editorTypefacePreference] = value }

    suspend fun setEditorWordWrapEnable(value: Boolean) =
        dataStore.edit { it[editorIsUseWordWrapPreference] = value }

    suspend fun setEditorFont(value: Int) =
        dataStore.edit { it[editorFontPreference] = value }
  }
}
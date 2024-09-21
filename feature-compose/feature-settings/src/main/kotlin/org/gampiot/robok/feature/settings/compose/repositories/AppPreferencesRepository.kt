package org.gampiot.robok.feature.settings.compose.repositories

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
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.map

private val editorThemePreference = intPreferencesKey("editor_theme")
private val editorTypefacePreference = intPreferencesKey("editor_typeface")
private val editorIsUseWordWrapPreference = booleanPreferencesKey("editor_word_wrap")

class AppPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
     val editorTheme = dataStore.data
          .map {
              it[editorThemePreference] ?: 0
          }
     val editorTypeface = dataStore.data
          .map {
              it[editorTypefacePreference] ?: 0
          }
     val editorIsUseWordWrap = dataStore.data
          .map {
              it[editorIsUseWordWrapPreference] ?: false
          }
        
     suspend fun changeEditorTheme(value: Int) {
         dataStore.edit { preferences ->
             preferences[editorThemePreference] = value
         }
     }
     
     suspend fun changeEditorTypeface(value: Int) {
         dataStore.edit { preferences ->
             preferences[editorTypefacePreference] = value
         }
     }
     
     suspend fun enableEditorWordWrap(value: Boolean) {
         dataStore.edit { preferences ->
             preferences[editorIsUseWordWrapPreference] = value
         }
     }
}

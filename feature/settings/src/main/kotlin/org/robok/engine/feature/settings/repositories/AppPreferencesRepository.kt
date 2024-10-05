package org.robok.engine.feature.settings.repositories

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

import android.os.Build

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.edit

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.map

import org.robok.engine.feature.settings.DefaultValues

private val installedRDKVersionPreference = stringPreferencesKey("installed_rdk_version")
private val appIsUseMonetPreference = booleanPreferencesKey("app_monet")
private val editorThemePreference = intPreferencesKey("editor_theme")
private val editorTypefacePreference = intPreferencesKey("editor_typeface")
private val editorIsUseWordWrapPreference = booleanPreferencesKey("editor_word_wrap")

class AppPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {

     val installedRDKVersion = dataStore.data
          .map {
              it[installedRDKVersionPreference] ?: DefaultValues.INSTALLED_RDK_VERSION
          }
     val appIsUseMonet = dataStore.data
          .map {
              it[appIsUseMonetPreference] ?: DefaultValues.IS_USE_MONET
          }
     val editorTheme = dataStore.data
          .map {
              it[editorThemePreference] ?: DefaultValues.EDITOR_THEME
          }
     val editorTypeface = dataStore.data
          .map {
              it[editorTypefacePreference] ?: DefaultValues.EDITOR_TYPEFACE
          }
     val editorIsUseWordWrap = dataStore.data
          .map {
              it[editorIsUseWordWrapPreference] ?: DefaultValues.EDITOR_IS_USE_WORD_WRAP
          }
          
     suspend fun changeInstalledRDK(value: String) {
         dataStore.edit { preferences ->
             preferences[installedRDKVersionPreference] = value
         }
     }
     
     suspend fun enableMonet(value: Boolean) {
         dataStore.edit { preferences ->
             preferences[appIsUseMonetPreference] = value
         }
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

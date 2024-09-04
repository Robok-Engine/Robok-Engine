package org.gampiot.robok.feature.settings.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.map

private val editorThemePreference = intPreferencesKey("editor_theme")
private val editorIsUseWordWrapPreference = booleanPreferencesKey("editor_word_wrap")

class AppPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
     val editorTheme = dataStore.data
          .map {
              it[editorThemePreference] ?: 0
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
     
     suspend fun enableEditorWordWrap(value: Boolean) {
         dataStore.edit { preferences ->
             preferences[editorIsUseWordWrapPreference] = value
         }
     }
}

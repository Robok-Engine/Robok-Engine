package org.gampiot.robok.feature.settings.repositories

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.edit

import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.map

private val editorThemePreference = intPreferencesKey("editor_theme")

class AppPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
     val editorTheme = dataStore.data
          .map {
              it[editorThemePreference] ?: 0
          }
        
     suspend fun changeEditorTheme(value: Int) {
         dataStore.edit { preferences ->
             preferences[editorThemePreference] = value
         }
     }
}

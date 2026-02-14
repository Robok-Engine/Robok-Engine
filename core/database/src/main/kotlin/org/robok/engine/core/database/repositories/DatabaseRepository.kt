package org.robok.engine.core.database.repositories

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
import kotlinx.coroutines.flow.map
import org.robok.engine.core.database.DefaultValues

class DatabaseRepository(private val dataStore: DataStore<Preferences>) {
  private val isFirstTimePreference = booleanPreferencesKey("is_first_time_preference")

  val isFirstTime = dataStore.data.map { it[isFirstTimePreference] ?: DefaultValues.IS_FIRST_TIME }

  suspend fun setIsFirstTime(value: Boolean) =
    dataStore.edit { preferences -> preferences[isFirstTimePreference] = value }
}

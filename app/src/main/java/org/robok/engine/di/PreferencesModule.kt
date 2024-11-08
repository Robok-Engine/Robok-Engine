package org.robok.engine.di

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
 
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.robok.engine.feature.settings.repositories.AppPreferencesRepository
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel

const val APP_PREFERENCES = "app_preferences"

val preferencesModule = module {
  singleOf(::AppPreferencesRepository)
  viewModelOf(::AppPreferencesViewModel)

  single {
    PreferenceDataStoreFactory.create { androidContext().preferencesDataStoreFile(APP_PREFERENCES) }
  }
}

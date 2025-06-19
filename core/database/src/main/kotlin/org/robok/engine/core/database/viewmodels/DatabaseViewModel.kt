package org.robok.engine.core.database.viewmodels

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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.robok.engine.core.database.repositories.DatabaseRepository

class DatabaseViewModel(private val repo: DatabaseRepository) : ViewModel() {
  val isFirstTime = repo.isFirstTime

  fun setIsFirstTime(value: Boolean) {
    viewModelScope.launch { repo.setIsFirstTime(value) }
  }
}

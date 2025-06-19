package org.robok.engine.ui.screens.settings.about.viewmodel

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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.robok.engine.defaults.DefaultContributors
import org.robok.engine.ui.screens.settings.about.models.Contributor
import org.robok.engine.ui.screens.settings.about.repository.ContributorsRepository

class AboutViewModel(private val repository: ContributorsRepository) : ViewModel() {
  private var _isShowContributorDialog by mutableStateOf(false)
  val isShowContributorDialog: Boolean
    get() = _isShowContributorDialog

  private var _currentContributor by mutableStateOf<Contributor?>(null)
  val currentContributor: Contributor
    get() = _currentContributor!!

  private var _contributors by mutableStateOf<List<Contributor>>(DefaultContributors())
  val contributors: List<Contributor>
    get() = _contributors

  init {
    viewModelScope.launch { fetchCommits() }
  }

  fun setShowContributorDialog(value: Boolean) {
    _isShowContributorDialog = value
  }

  fun setCurrentContributor(value: Contributor) {
    _currentContributor = value
  }

  private suspend fun fetchCommits() {
    _contributors = repository.fetchContributors()
  }
}

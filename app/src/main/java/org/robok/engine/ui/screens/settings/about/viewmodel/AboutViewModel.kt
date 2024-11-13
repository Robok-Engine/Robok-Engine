package org.robok.engine.ui.screens.settings.about.viewmodel

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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.robok.engine.models.about.Contributor
import org.robok.engine.defaults.DefaultContributors
import org.robok.engine.ui.screens.settings.about.repository.ContributorsRepository
import kotlinx.coroutines.launch

class AboutViewModel(
  private val repository: ContributorsRepository
): ViewModel() {
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
    viewModelScope.launch {
      fetchCommits()
    }
  }
    
  fun setShowContributorDialog(value: Boolean) {
    _isShowContributorDialog = value
  }
  
  fun setCurrentContributor(value: Contributor) {
    _currentContributor = value
  }
  
  private suspend fun fetchCommits() {
    _contributors = repo.fetchContributors()
  }
}
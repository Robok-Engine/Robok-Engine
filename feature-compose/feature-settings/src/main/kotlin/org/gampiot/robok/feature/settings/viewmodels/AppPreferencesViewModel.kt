package org.gampiot.robok.feature.settings.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import org.gampiot.robok.feature.settings.repositories.AppPreferencesRepository

class AppPreferencesViewModel(
    private val repo: AppPreferencesRepository
) : ViewModel() {
     val isUseMonet = repo.isUseMonet
     val isUseHighContrast = repo.isUseHighContrast
     
     fun enableMonet (value: Boolean) {
         viewModelScope.launch {
              repo.enableMonet(value)
         }
     }
     
     fun enableHighContrast (value: Boolean) {
         viewModelScope.launch {
              repo.enableHighContrast(value)
         }
     }
}
package org.gampiot.robok.feature.settings.compose.viewmodels

sealed class DownloadState {
    object NotStarted : DownloadState()
    object Loading : DownloadState()
    data class Success(val message: String) : DownloadState()
    data class Error(val error: String) : DownloadState()
}

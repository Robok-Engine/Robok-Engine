package org.gampiot.robok.ui.fragments.about.viewmodel

import android.content.Context

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import okhttp3.OkHttpClient
import okhttp3.Request

import org.gampiot.robok.ui.fragments.about.model.Contributor
import org.gampiot.robok.feature.component.terminal.RobokTerminal

class ContributorViewModel(context: Context) : ViewModel() {

    private val _contributors = MutableLiveData<List<Contributor>>()
    val contributors: LiveData<List<Contributor>> get() = _contributors

    private val client = OkHttpClient()
    private val terminal = RobokTerminal(context)

    init {
        fetchContributors()
    }

    private fun fetchContributors() {
        viewModelScope.launch {
            val request = Request.Builder()
                .url("https://raw.githubusercontent.com/gampiot-inc/Robok-Engine/dev/contributors/contributors_github.json")
                .build()

            try {
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        val jsonString = response.body?.string()
                        terminal.addLog("Response successful: $jsonString")
                        jsonString?.let {
                            val contributorsList = Json.decodeFromString<List<Contributor>>(it)
                            _contributors.postValue(contributorsList)
                            terminal.addLog("Parsed contributors: ${contributorsList.size}")
                        }
                    } else {
                        terminal.addLog("Request failed with code: ${response.code}")
                    }
                }
            } catch (e: Exception) {
                terminal.addLog("Network request failed: ${e.message}")
            }
        }
    }
}

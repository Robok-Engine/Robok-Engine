package org.gampiot.robok.ui.fragments.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import okhttp3.OkHttpClient
import okhttp3.Request

import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import org.gampiot.robok.ui.fragments.about.model.Contributor

class ContributorViewModel : ViewModel() {

    private val _contributors = MutableLiveData<List<Contributor>>()
    val contributors: LiveData<List<Contributor>> get() = _contributors

    private val client = OkHttpClient()

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
                        val jsonString = response.body()?.string()
                        jsonString?.let {
                            val contributorsList = Json.decodeFromString<List<Contributor>>(it)
                            _contributors.postValue(contributorsList)
                        }
                    } else {
                        // error handle
                    }
                }
            } catch (e: Exception) {
                // handle exeception
            }
        }
    }
}

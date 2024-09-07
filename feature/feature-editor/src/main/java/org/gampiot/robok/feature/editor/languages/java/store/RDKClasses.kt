package org.gampiot.robok.feature.editor.languages.java.store

import android.util.Log

import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import okhttp3.OkHttpClient
import okhttp3.Request

import org.gampiot.robok.feature.editor.languages.java.store.models.ClassItem

class RDKClasses {

    companion object {
        private const val TAG = "RDKClasses"
        private const val RDK_VERSION = "RDK-1"
        private const val URL = "https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/$RDK_VERSION/classes.json"
    }

    private val client = OkHttpClient()

    private suspend fun fetchClasses(): List<ClassItem> = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(URL)
            .build()
        try {
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val jsonString = response.body?.string()
                    Log.d(TAG, "JSON Received: $jsonString")
                    jsonString?.let {
                        return@withContext Json.decodeFromString<List<ClassItem>>(it)
                    }
                } else {
                    Log.e(TAG, "Error: ${response.message}")
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error:", e)
        }
        emptyList()
    }

    suspend fun getClasses(): HashMap<String, String> {
        val classes = fetchClasses()
        return classes.associate { it.className to it.classPackageName } as HashMap<String, String>
    }
}

object RDKClassesHelper {
    @JvmStatic
    fun getClasses(): HashMap<String, String> {
        return runBlocking {
            RDKClasses().getClasses()
        }
    }
}

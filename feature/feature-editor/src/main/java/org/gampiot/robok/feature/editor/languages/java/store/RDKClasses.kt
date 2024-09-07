package org.gampiot.robok.feature.editor.languages.java.store

/*
* Class to get Classes from https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/$RDK_VERSION/classes.json
* And add in HashMap to use on Auto Complete
* @author Aquiles Trindade
*/

import android.util.Log

import okhttp3.OkHttpClient
import okhttp3.Request

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.coroutines.runBlocking

import org.gampiot.robok.feature.editor.languages.java.store.models.ClassItem

import java.util.HashMap

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
        val classMap = HashMap<String, String>()
        classes.forEach { clazz ->
            classMap[clazz.className] = clazz.classPackageName
        }
        return classMap
    }
}

object RDKClassesHelper {
    @JvmStatic
    fun getClasses(): HashMap<String, String> = runBlocking {
        RDKClasses().getClasses()
    }
}

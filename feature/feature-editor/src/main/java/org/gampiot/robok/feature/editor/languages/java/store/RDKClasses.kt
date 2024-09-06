package org.gampiot.robok.feature.editor.languages.java.store

import okhttp3.OkHttpClient
import okhttp3.Request

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import org.gampiot.robok.feature.editor.languages.java.store.models.ClassItem

import java.util.HashMap

class RDKClasses {

    companion object {
        private const val RDK_VERSION = "RDK-1"
        private const val URL = "https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/$RDK_VERSION/classes.json"
    }

    private val client = OkHttpClient()
    
    private fun fetchClasses(): List<ClassItem> = runBlocking {
        val response = CoroutineScope(Dispatchers.IO).launch {
            val request = Request.Builder()
                .url(URL)
                .build()
            try {
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        val jsonString = response.body?.string()
                        jsonString?.let {
                            return@launch Json.decodeFromString<List<ClassItem>>(it)
                        }
                    }
                }
            } catch (e: Exception) { }
        }.join()  
        emptyList()
    }

    fun getClasses(): HashMap<String, String> {
        val classes = fetchClasses()
        val classMap = HashMap<String, String>()
        classes.forEach { clazz ->
            classMap[clazz.className] = clazz.classPackageName
        }
        return classMap
    }
}

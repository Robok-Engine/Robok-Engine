package org.gampiot.robok.feature.editor.languages.java.store

import okhttp3.OkHttpClient
import okhttp3.Request

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import org.gampiot.robok.feature.editor.languages.java.store.models.Class

import java.util.HashMap

class RDKClasses {

    companion object {
        private const val RDK_VERSION = "RDK-1"
        private const val URL = "https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/$RDK_VERSION/classes.json"
    }

    private val client = OkHttpClient()

    fun fetchClasses(callback: (List<Class>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val request = Request.Builder()
                .url(URL)
                .build()
            try {
                client.newCall(request).execute().use { response ->
                    if (response.isSuccessful) {
                        val jsonString = response.body?.string()
                        jsonString?.let {
                            val classes = Json.decodeFromString<List<Class>>(it)
                            callback(classes)
                        } ?: callback(emptyList())
                    } else {
                        callback(emptyList())
                    }
                }
            } catch (e: Exception) {
                callback(emptyList())
            }
        }
    }

    fun getClasses(callback: (HashMap<String, String>) -> Unit) {
        fetchClasses { classes ->
            val classMap = HashMap<String, String>()
            classes.forEach { clazz ->
                classMap[clazz.className] = clazz.classPackageName
            }
            callback(classMap)
        }
    }
}


/* usage
   rdkClasses.getClasses(classMap -> {
        if (classMap.isEmpty()) {
            System.out.println("No classes found or an error occurred");
        } else {
            System.out.println("Fetched classes as map:");
            for (String name : classMap.keySet()) {
                  System.out.println("Class Name: " + name + ", Description: " + classMap.get(name));
            }
       }
    });
*/
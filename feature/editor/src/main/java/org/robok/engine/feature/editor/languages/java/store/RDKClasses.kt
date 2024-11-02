package org.robok.engine.feature.editor.languages.java.store

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

/*
 * Class to get Classes from https://raw.githubusercontent.com/robok-inc/Robok-SDK/dev/versions/$RDK_VERSION/classes.json
 * And add in HashMap to use on Auto Complete
 * @author Aquiles Trindade
 */

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.robok.engine.feature.editor.languages.java.store.models.ClassItem

class RDKClasses {

  companion object {
    private const val TAG = "RDKClasses"
    private const val RDK_VERSION = "RDK-1"
    private const val URL =
      "https://raw.githubusercontent.com/Robok-Engine/Robok-SDK/dev/versions/$RDK_VERSION/classes.json"
  }

  private val client = OkHttpClient()

  private suspend fun fetchClasses(): List<ClassItem> =
    withContext(Dispatchers.IO) {
      val request = Request.Builder().url(URL).build()
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
    return runBlocking { RDKClasses().getClasses() }
  }
}

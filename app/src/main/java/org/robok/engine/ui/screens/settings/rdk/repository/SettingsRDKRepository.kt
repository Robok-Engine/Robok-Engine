package org.robok.engine.ui.screens.settings.rdk.repository

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
 
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.robok.engine.core.utils.RobokLog

class SettingsRDKRepository(val client: HttpClient) {

  suspend fun getVersions(): List<String> {
    return try {
      val response =
        client.get(
          "https://raw.githubusercontent.com/robok-engine/Robok-SDK/dev/versions/versions.json"
        )

      if (response.status.value in 200..299) {
        val body: String = response.bodyAsText()
        val versions: List<String> = Json.decodeFromString(body)
        versions
      } else {
        emptyList()
      }
    } catch (e: Exception) {
      RobokLog.e(message = e.toString())
      emptyList()
    }
  }
}
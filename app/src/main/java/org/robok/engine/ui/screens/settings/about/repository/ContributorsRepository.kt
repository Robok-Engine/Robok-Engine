package org.robok.engine.ui.screens.settings.about.repository

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
import org.robok.engine.core.utils.Log
import org.robok.engine.ui.screens.settings.about.models.Contributor

class ContributorsRepository(val client: HttpClient) {

  suspend fun fetchContributors(): List<Contributor> {
    return try {
      val response =
        client.get(
          "https://raw.githubusercontent.com/robok-engine/Robok-Engine/host/.github/contributors/contributors_github.json"
        )

      if (response.status.value in 200..299) {
        val body: String = response.bodyAsText()
        val contributors: List<Contributor> = Json.decodeFromString(body)
        val contributorsFiltered =
          contributors.filter { contributor ->
            contributor.type != "Bot" &&
              contributor.role != "Bot" &&
              contributor.user_view_type != "private"
          }
        contributorsFiltered
      } else {
        emptyList()
      }
    } catch (e: Exception) {
      Log.e(message = e.toString())
      emptyList()
    }
  }
}

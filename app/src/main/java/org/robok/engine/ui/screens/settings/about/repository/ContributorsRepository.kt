package org.robok.engine.ui.screens.settings.about.repository

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

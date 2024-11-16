package org.robok.engine.ui.screens.settings.about.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.robok.engine.core.utils.RobokLog
import org.robok.engine.models.about.Contributor

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
        RobokLog.e(message = contributorsFiltered.toString())
        contributorsFiltered
      } else {
        emptyList()
      }
    } catch (e: Exception) {
      RobokLog.e(message = e.toString())
      emptyList()
    }
  }
}

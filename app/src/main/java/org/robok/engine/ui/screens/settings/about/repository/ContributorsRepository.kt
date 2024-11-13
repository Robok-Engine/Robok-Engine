package org.robok.engine.ui.screens.settings.about.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ContributorsRepository(
  val client: HttpClient
) {
  
  suspend fun getContributors(): List<Contributor> {
    return try {
      val response =
        client.get("https://raw.githubusercontent.com/robok-inc/Robok-Engine/host/.github/contributors/contributors_github.json")

      if (response.status.value in 200..299) {
        val contributors: List<Contributor> = response.body()
        contributors.filter { contributor ->
          contributor.type != "Bot" &&
          contributor.role != "Bot" &&
          contributor.user_view_type != "private"
        }
      } else {
        emptyList()
      }
      
    } catch (e: Exception) {
      emptyList()
    }
  }
}
package org.robok.engine.ui.screens.settings.about.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.robok.engine.core.utils.RobokLog
import org.robok.engine.models.about.Contributor

class ContributorsRepository(
  val client: HttpClient
) {
  
  suspend fun fetchContributors(): List<Contributor> {
    return try {
      val response =
        client.get("https://raw.githubusercontent.com/robok-inc/Robok-Engine/host/.github/contributors/contributors_github.json")

      if (response.status.value in 200..299) {
        val contributors: List<Contributor> = response.body()
        val c = contributors.filter { contributor ->
          contributor.type != "Bot" &&
          contributor.role != "Bot" &&
          contributor.user_view_type != "private"
        }
        RobokLog.e(message = c.toString())
        c
      } else {
        emptyList()
      }
      
    } catch (e: Exception) {
      RobokLog.e(message = e.toString())
      emptyList()
    }
  }
}
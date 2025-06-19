package org.robok.engine.ui.screens.settings.about.models

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
import kotlinx.serialization.Serializable
import org.robok.engine.ui.screens.settings.about.components.Role

@Serializable
data class Contributor(
  val login: String = "Name",
  val id: Int = 0,
  val node_id: String = "node",
  val avatar_url: String = "avatar_url",
  val gravatar_id: String = "gravatar_id",
  val url: String = "url",
  val html_url: String = "html_url",
  val followers_url: String = "folowers_url",
  val following_url: String = "following_url",
  val gists_url: String = "gistis_url",
  val starred_url: String = "starred_url",
  val subscriptions_url: String = "subscriptions_url",
  val organizations_url: String = "organizations_url",
  val repos_url: String = "repos_url",
  val events_url: String = "events_url",
  val received_events_url: String = "received_events_url",
  val type: String = "User",
  val site_admin: Boolean = false,
  val contributions: Int = 0,
  val role: String = Role.DEVELOPER,
  val user_view_type: String = "public",
)

package org.robok.engine.models.about

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

import kotlinx.serialization.Serializable

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
    val role: String = "Contributor",
    val user_view_type: String = "public",
)

package org.gampiot.robok.feature.settings.compose.screens.ui.about

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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.annotation.IdRes

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.settings.compose.R
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.component.compose.preferences.base.LocalIsExpandedScreen
import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceTemplate
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.component.compose.text.RobokText
import org.gampiot.robok.feature.res.Strings

import coil.compose.SubcomposeAsyncImage

import kotlinx.serialization.Serializable
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString


var contributors = listOf(
     Contributor(
        login = "trindadedev",
        role = "Main Developer",
        avatar_url = "https://github.com/trindadedev13.png"
     )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavController,
    version: String
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    val contributorsState = remember { mutableStateOf<List<Contributor>>(contributors) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            contributors = fetchContributors()
            contributorsState.value = contributors
        }
    }

    val links = listOf(
        Link(
            name = stringResource(id = Strings.item_github_title),
            description = stringResource(id = Strings.item_github_description),
            imageResId = R.drawable.ic_github_24,
            url = stringResource(id = Strings.link_github)
        ),
        Link(
            name = stringResource(id = Strings.item_telegram_title),
            description = stringResource(id = Strings.item_telegram_description),
            imageResId = R.drawable.ic_send_24,
            url = stringResource(id = Strings.link_telegram)
        ),
        Link(
            name = stringResource(id = Strings.item_whatsapp_title),
            description = stringResource(id = Strings.item_whatsapp_description),
            imageResId = R.drawable.ic_whatsapp_24,
            url = stringResource(id = Strings.link_whatsapp)
        )
    )

    PreferenceLayout(
        label = stringResource(id = Strings.settings_about_title),
        modifier = Modifier,
        backArrowVisible = !LocalIsExpandedScreen.current,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape),
            )
            Spacer(modifier = Modifier.height(12.dp))
            RobokText(
                text = "Robok",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
            RobokText(
                text = version,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.requiredHeight(16.dp))
        }
        if (contributors.isNotEmpty()) {
            PreferenceGroup(heading = stringResource(id = Strings.text_contributors)) {
                 contributorsState.value.forEach {
                      ContributorRow(dataInfo = it)
                 }
            }
        }
        PreferenceGroup(heading = stringResource(id = Strings.text_seeus)) {
            links.forEach {
                LinkRow(dataInfo = it)
            }
        }
    }
}

val client = OkHttpClient()

suspend fun fetchContributors(): List<Contributor> {
    val request = Request.Builder()
        .url("https://raw.githubusercontent.com/robok-inc/Robok-Engine/host/.github/contributors/contributors_github.json")
        .build()

    return withContext(Dispatchers.IO) {
        try {
            client.newCall(request).execute().use { response ->
                if (response.isSuccessful) {
                    val jsonString = response.body?.string()
                    jsonString?.let {
                        val contributors = Json.decodeFromString<List<Contributor>>(it)
                        
                        contributors.filter { contributor ->
                            contributor.type != "Bot" && contributor.role != "Bot"
                        }
                    } ?: emptyList()
                } else {
                    emptyList()
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}

@Composable
fun ContributorRow(
   dataInfo: Contributor
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    PreferenceTemplate(
        title = { RobokText(text = dataInfo.login) },
        description = { RobokText(text = dataInfo.role) },
        modifier = Modifier
           .clickable(
              onClick = {
                  uriHandler.openUri(dataInfo.html_url)
              }
           ),
        startWidget = {
            SubcomposeAsyncImage(
                model = dataInfo.avatar_url,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                },
            )
        }
    )
}

@Composable
fun LinkRow(
   dataInfo: Link
) {
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    PreferenceTemplate(
        modifier = Modifier
           .clickable(
              onClick = {
                  uriHandler.openUri(dataInfo.url)
              }
           ),
        title = { RobokText(fontWeight = FontWeight.Bold, text = dataInfo.name) },
        description = { RobokText(text = dataInfo.description) },
        startWidget = {
            Image(
                painter = painterResource(id = dataInfo.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceContainer),
            )
        }
    )
}

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
    val role: String = "Contributor"
)


data class Link(
    val name: String,
    val description: String,
    @IdRes val imageResId: Int,
    val url: String
)

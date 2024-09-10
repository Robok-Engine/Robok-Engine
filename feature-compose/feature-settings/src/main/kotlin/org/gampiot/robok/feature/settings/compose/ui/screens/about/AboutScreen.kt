package org.gampiot.robok.feature.settings.compose.screens.ui.about

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.platform.LocalContext

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceTemplate
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

import coil.compose.SubcomposeAsyncImage

import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_about_title),
        backArrowVisible = true,
    ) {
        val contributors = listOf (
            Contributor(
               login = "trindadedev",
               role = "Main Developer",
               avatar_url = "https://github.com/trindadedev13.png"
            )
        )
        PreferenceGroup(heading = stringResource(id = Strings.text_contributors)) {
             contributors.forEach {
                ContributorRow(
                    dataInfo = it
                )
            }
        }
    }
}

@Composable
fun ContributorRow(
   dataInfo: Contributor
) {
    val context = LocalContext.current

    PreferenceTemplate(
        title = { Text(text = dataInfo.login) },
        description = { Text(text = dataInfo.role) },
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
        },
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
    val role: String = "Developer"
)

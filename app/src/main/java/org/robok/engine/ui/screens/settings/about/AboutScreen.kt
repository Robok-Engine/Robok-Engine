package org.robok.engine.ui.screens.settings.about

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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.BuildConfig
import org.robok.engine.Drawables
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.core.components.shape.ButtonShape
import org.robok.engine.defaults.DefaultContributors
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.models.about.Contributor
import org.robok.engine.models.about.Link
import org.robok.engine.strings.Strings

var contributors = DefaultContributors()

@Composable
fun AboutScreen() {
  val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()

  val contributorsState = remember { mutableStateOf(contributors) }
  val scope = rememberCoroutineScope()

  LaunchedEffect(Unit) {
    scope.launch {
      contributors = fetchContributors()
      contributorsState.value = if (contributors.isEmpty()) DefaultContributors() else contributors
    }
  }

  val links =
    listOf(
      Link(
        name = stringResource(id = Strings.title_github),
        description = stringResource(id = Strings.text_github),
        imageResId = Drawables.ic_github_24,
        url = stringResource(id = Strings.link_github),
      ),
      Link(
        name = stringResource(id = Strings.title_telegram),
        description = stringResource(id = Strings.text_telegram),
        imageResId = Drawables.ic_send_24,
        url = stringResource(id = Strings.link_telegram),
      ),
      Link(
        name = stringResource(id = Strings.title_whatsapp),
        description = stringResource(id = Strings.text_whatsapp),
        imageResId = Drawables.ic_whatsapp_24,
        url = stringResource(id = Strings.link_whatsapp),
      ),
    )

  Screen(
    label = stringResource(id = Strings.settings_about_title),
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Column(
      modifier = Modifier.padding(top = 8.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Image(
        painter = painterResource(id = Drawables.ic_launcher),
        contentDescription = null,
        modifier = Modifier.size(72.dp).clip(CircleShape),
      )
      Spacer(modifier = Modifier.height(12.dp))
      Text(
        text = "Robok",
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge,
      )
      Text(
        text = BuildConfig.VERSION_NAME,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
      Spacer(modifier = Modifier.requiredHeight(16.dp))
    }

    if (contributorsState.value.isNotEmpty()) {
      val roles = contributorsState.value.groupBy { it.role }
      roles.forEach { (role, contributorsList) ->
        PreferenceGroup(heading = role) {
          contributorsList.forEach { ContributorRow(dataInfo = it) }
        }
      }
    }

    PreferenceGroup(heading = stringResource(id = Strings.text_seeus)) {
      links.forEach { LinkRow(dataInfo = it) }
    }
  }
}

val client = OkHttpClient()

suspend fun fetchContributors(): List<Contributor> {
  val request =
    Request.Builder()
      .url(
        "https://raw.githubusercontent.com/robok-inc/Robok-Engine/host/.github/contributors/contributors_github.json"
      )
      .build()

  return withContext(Dispatchers.IO) {
    try {
      client.newCall(request).execute().use { response ->
        if (response.isSuccessful) {
          val jsonString = response.body?.string()
          jsonString?.let {
            val contributors = Json.decodeFromString<List<Contributor>>(it)

            contributors.filter { contributor ->
              contributor.type != "Bot" &&
                contributor.role != "Bot" &&
                contributor.user_view_type != "private"
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
fun ContributorRow(dataInfo: Contributor) {
  var isShowDialog = remember { mutableStateOf(false) }
  PreferenceTemplate(
    title = { Text(fontWeight = FontWeight.Bold, text = dataInfo.login) },
    description = { Text(text = dataInfo.role) },
    modifier = Modifier.clickable(onClick = { isShowDialog.value = true }),
    startWidget = {
      val avatarUrl =
        if (dataInfo.avatar_url.isNullOrEmpty()) Drawables.ic_nerd else dataInfo.avatar_url
      AsyncImage(
        model = avatarUrl,
        contentDescription = null,
        placeholder = painterResource(Drawables.ic_nerd),
        modifier =
          Modifier.clip(CircleShape)
            .size(32.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer),
      )
    },
  )
  OpenContributorDialog(contributor = dataInfo, isShowDialog = isShowDialog)
}

@Composable
fun LinkRow(dataInfo: Link) {
  val uriHandler = LocalUriHandler.current

  PreferenceTemplate(
    modifier = Modifier.clickable(onClick = { uriHandler.openUri(dataInfo.url) }),
    title = { Text(fontWeight = FontWeight.Bold, text = dataInfo.name) },
    description = { Text(text = dataInfo.description) },
    startWidget = {
      Image(
        painter = painterResource(id = dataInfo.imageResId),
        contentDescription = null,
        modifier = Modifier.size(32.dp).clip(CircleShape),
      )
    },
  )
}

@Composable
fun OpenContributorDialog(contributor: Contributor, isShowDialog: MutableState<Boolean>) {
  val uriHandler = LocalUriHandler.current
  AnimatedVisibility(
    visible = isShowDialog.value,
    enter = fadeIn(tween(250)) + slideInVertically { it / 2 },
    exit = fadeOut(tween(200)) + slideOutVertically { -it / 2 },
  ) {
    AlertDialog(
      onDismissRequest = { isShowDialog.value = false },
      title = { Text(text = stringResource(Strings.title_open_contributor_github)) },
      text = {
        Text(
          text =
            stringResource(Strings.text_open_contributor_github)
              .replace("-name-", contributor.login)
        )
      },
      confirmButton = {
        Button(
          onClick = {
            isShowDialog.value = false
            uriHandler.openUri(contributor.html_url)
          },
          shape = ButtonShape(),
        ) {
          Text(stringResource(id = Strings.common_word_open))
        }
      },
      dismissButton = {
        OutlinedButton(onClick = { isShowDialog.value = false }, shape = ButtonShape()) {
          Text(stringResource(id = Strings.common_word_cancel))
        }
      }
    )
  }
}

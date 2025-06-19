package org.robok.engine.ui.screens.settings.about

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

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.BuildConfig
import org.robok.engine.Drawables
import org.robok.engine.Strings
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.core.utils.isDeviceLanguage
import org.robok.engine.defaults.DefaultContributors
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.draw.enableBlur
import org.robok.engine.ui.screens.settings.about.components.ContributorDialog
import org.robok.engine.ui.screens.settings.about.components.ContributorWidget
import org.robok.engine.ui.screens.settings.about.components.LinkWidget
import org.robok.engine.ui.screens.settings.about.components.handleRolePlural
import org.robok.engine.ui.screens.settings.about.models.Link
import org.robok.engine.ui.screens.settings.about.viewmodel.AboutViewModel

var contributors = DefaultContributors()

@Composable
fun AboutScreen() {
  val appPrefsViewModel = koinViewModel<PreferencesViewModel>()
  val aboutViewModel = koinViewModel<AboutViewModel>()
  val context = LocalContext.current

  Screen(
    label = stringResource(id = Strings.settings_about_title),
    modifier = Modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) { innerPadding ->
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
        text = stringResource(id = Strings.app_name),
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

    if (aboutViewModel.contributors.isNotEmpty()) {
      val roles = aboutViewModel.contributors.groupBy { it.role }
      roles.forEach { (role, contributorsList) ->
        PreferenceGroup(heading = handleRolePlural(role)) {
          contributorsList.forEach {
            ContributorWidget(
              model = it,
              onClick = { contributor ->
                aboutViewModel.setShowContributorDialog(true)
                aboutViewModel.setCurrentContributor(contributor)
              },
            )
          }
        }
      }
    }

    PreferenceGroup(heading = stringResource(id = Strings.text_seeus)) {
      getLinksList().forEach { LinkWidget(model = it) }
    }
  }

  if (aboutViewModel.isShowContributorDialog) {
    context.enableBlur(true)
    ContributorDialog(
      contributor = aboutViewModel.currentContributor,
      onDismissRequest = {
        aboutViewModel.setShowContributorDialog(false)
        context.enableBlur(false)
      },
    )
  }
}

@Composable private fun rememberContributorsState() = remember { mutableStateOf(contributors) }

@Composable
private fun getLinksList(): List<Link> {
  return listOfNotNull(
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
      name = stringResource(id = Strings.title_discord),
      description = stringResource(id = Strings.text_discord),
      imageResId = Drawables.ic_discord_24,
      url = stringResource(id = Strings.link_discord),
    ),
  )
}

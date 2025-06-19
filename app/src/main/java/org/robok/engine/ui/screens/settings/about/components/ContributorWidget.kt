package org.robok.engine.ui.screens.settings.about.components

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
import coil.compose.AsyncImage
import org.robok.engine.Drawables
import org.robok.engine.Strings
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.ui.screens.settings.about.models.Contributor

@Composable
fun ContributorWidget(model: Contributor, onClick: (Contributor) -> Unit = {}) {
  PreferenceTemplate(
    title = { Text(fontWeight = FontWeight.Bold, text = model.login) },
    description = { Text(text = handleRole(model.role)) },
    modifier = Modifier.clickable { onClick(model) },
    startWidget = {
      val avatarUrl = if (model.avatar_url.isNullOrEmpty()) Drawables.ic_nerd else model.avatar_url
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
}

@Composable
fun handleRole(role: String): String =
  when (role) {
    Role.FOUNDER -> stringResource(id = Strings.role_founder)
    Role.TRANSLATOR -> stringResource(id = Strings.role_translator)
    Role.DEVELOPER -> stringResource(id = Strings.role_developer)
    else -> stringResource(id = Strings.role_developer)
  }

@Composable
fun handleRolePlural(role: String): String =
  when (role) {
    Role.FOUNDER -> stringResource(id = Strings.role_founders)
    Role.TRANSLATOR -> stringResource(id = Strings.role_translators)
    Role.DEVELOPER -> stringResource(id = Strings.role_developers)
    else -> stringResource(id = Strings.role_developers)
  }

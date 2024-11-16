package org.robok.engine.ui.screens.settings.about.components

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
import org.robok.engine.strings.Strings
import org.robok.engine.core.components.preferences.base.PreferenceTemplate
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
fun handleRole(role: String): String = when(role) {
  Role.FOUNDER -> stringResource(id = Strings.role_founder)
  Role.TRANSLATOR -> stringResource(id = Strings.role_translator)
  Role.DEVELOPER -> stringResource(id = Strings.role_developer)
  else -> stringResource(id = Strings.role_developer)
}

@Composable
fun handleRolePlural(role: String): String = when(role) {
  Role.FOUNDER -> stringResource(id = Strings.role_founders)
  Role.TRANSLATOR -> stringResource(id = Strings.role_translators)
  Role.DEVELOPER -> stringResource(id = Strings.role_developers)
  else -> stringResource(id = Strings.role_developers)
}
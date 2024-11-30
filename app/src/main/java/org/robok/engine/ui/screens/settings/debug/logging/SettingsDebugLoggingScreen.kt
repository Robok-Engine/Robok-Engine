package org.robok.engine.ui.screens.settings.debug.logging

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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.Drawables
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.core.utils.RobokLog
import org.robok.engine.strings.Strings

@Composable
fun SettingsDebugLoggingScreen() {
  var logs by remember { mutableStateOf<List<String>>(emptyList()) }
  var isLoading by remember { mutableStateOf(true) }

  LaunchedEffect(Unit) {
    try {
      val retrievedLogs = RobokLog.getLogs()
      logs = retrievedLogs
      isLoading = false
    } catch (e: Exception) {
      isLoading = false
    }
  }

  Screen(label = stringResource(id = Strings.text_logging)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_all_logs)) {
      if (isLoading) {
        Text(modifier = Modifier.padding(18.dp), text = stringResource(id = Strings.loading_logs))
      } else if (logs.isEmpty()) {
        EmptyContentItem()
      } else {
        logs.forEach { log -> Text(modifier = Modifier.padding(18.dp), text = log) }
      }
    }
  }
}

@Composable
private fun EmptyContentItem() {
  PreferenceTemplate(
    title = {
      Text(
        text = stringResource(id = Strings.warning_no_logs),
        style = MaterialTheme.typography.titleMedium,
      )
    },
    startWidget = {
      Image(
        painter = painterResource(id = Drawables.ic_warning_24),
        contentDescription = null,
        modifier = Modifier.size(32.dp).clip(CircleShape),
      )
    },
    modifier = Modifier.fillMaxWidth(),
  )
}

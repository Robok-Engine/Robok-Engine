package org.robok.engine.ui.screens.settings.debug.logging

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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.Strings
import org.robok.engine.core.utils.Log
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

@Composable
fun SettingsDebugLoggingScreen() {
  var logs by remember { mutableStateOf<List<String>>(emptyList()) }
  var isLoading by remember { mutableStateOf(true) }

  LaunchedEffect(Unit) {
    try {
      val retrievedLogs = Log.getLogs()
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
        imageVector = Icons.Rounded.Warning,
        contentDescription = stringResource(id = Strings.warning_no_projects),
        modifier = Modifier.size(32.dp).clip(CircleShape),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )
    },
    modifier = Modifier.fillMaxWidth(),
  )
}

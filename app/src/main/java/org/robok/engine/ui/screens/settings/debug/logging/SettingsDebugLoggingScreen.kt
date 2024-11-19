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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.Image
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import org.robok.engine.strings.Strings
import org.robok.engine.Drawables
import org.robok.engine.core.utils.RobokLog
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.base.PreferenceTemplate

@Composable
fun SettingsDebugLoggingScreen() {
  val logs by rememberLogs()
  Screen(label = stringResource(id = Strings.text_logging)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_all_logs)) { 
      if (logs.isEmpty().not()) {
        logs.forEach { log ->
          Text(
            text = log
          )
        }
      } else {
        EmptyContentItem()
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
        modifier = Modifier.size(32.dp).clip(CircleShape)
      )
    },
    modifier = Modifier.fillMaxWidth()
  )
}


@Composable
private fun rememberLogs() = remember {
  RobokLog.getLogs()
}
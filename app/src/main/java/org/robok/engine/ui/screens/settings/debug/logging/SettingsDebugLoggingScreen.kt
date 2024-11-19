package org.robok.engine.ui.screens.settings.debug.logginh

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
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import org.robok.engine.strings.Strings
import org.robok.engine.core.utils.RobokLog
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup

@Composable
fun SettingsDebugLoggingScreen() {
  Screen(label = stringResource(id = Strings.text_logging)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_all_logs)) {
      RobokLog.getLogs().forEach { log ->
        Text(
          text = log
        )
      }
    }
  }
}
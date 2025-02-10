package org.robok.engine.ui.screens.settings.debug

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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.normal.Preference
import org.robok.engine.routes.Route
import org.robok.engine.routes.SettingsDebugLoggingRoute

@Composable
fun SettingsDebugScreen(onNavigate: (Route) -> Unit) {
  Screen(label = stringResource(id = Strings.settings_debug_title)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_logging)) {
      Preference(
        title = { Text(text = stringResource(id = Strings.settings_debug_see_logs_title)) },
        description = {
          Text(text = stringResource(id = Strings.settings_debug_see_logs_description))
        },
        onClick = { onNavigate(SettingsDebugLoggingRoute) },
      )
    }
  }
}

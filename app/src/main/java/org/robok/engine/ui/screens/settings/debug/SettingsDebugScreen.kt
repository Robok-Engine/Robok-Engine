package org.robok.engine.ui.screens.settings.debug

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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings
import org.robok.engine.navigation.routes.Route
import org.robok.engine.navigation.routes.SettingsDebugLoggingRoute
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.normal.Preference

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

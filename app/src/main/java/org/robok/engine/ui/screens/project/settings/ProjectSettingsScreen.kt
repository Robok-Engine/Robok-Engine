package org.robok.engine.ui.screens.project.settings

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

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.platform.LocalToastHostState
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.project.settings.components.BasicInputs
import org.robok.engine.ui.screens.project.settings.components.Buttons
import org.robok.engine.ui.screens.project.settings.viewmodel.ProjectSettingsViewModel

@Composable
fun ProjectSettingsScreen(projectManager: ProjectManager) {
  val context = LocalContext.current
  val toastHostState = LocalToastHostState.current
  val scope = rememberCoroutineScope()
  val viewModel = koinViewModel<ProjectSettingsViewModel>()
  val uiState = viewModel.uiState

  LaunchedEffect(Unit) {
    try {
      val buildConfig = projectManager.getProjectSettingsFromFile()
      viewModel.setGameName(buildConfig?.gameName ?: "")
      viewModel.setGameIconPath(buildConfig?.gameIconPath ?: "")
      viewModel.setMainScreenName(buildConfig?.mainScreenName ?: "")
    } catch (e: Exception) {
      toastHostState.showToast(message = e.toString(), icon = Icons.Rounded.Error)
    }
  }

  Screen(label = stringResource(id = Strings.settings_project_settings_tile)) {
    PreferenceGroup(heading = stringResource(id = Strings.common_word_basic)) {
      val modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 8.dp)

      BasicInputs(viewModel = viewModel, modifier = modifier)
      Buttons(
        viewModel = viewModel,
        modifier = modifier,
        onSave = { newConfig ->
          projectManager.writeToProjectSettings(newConfig)
          scope.launch {
            toastHostState.showToast(
              message = context.getString(Strings.text_saved),
              icon = Icons.Rounded.Check,
            )
          }
          (context as? Activity)?.finish()
        },
        onCancel = { (context as? Activity)?.finish() },
      )
    }
  }
}

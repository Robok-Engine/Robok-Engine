package org.robok.engine.ui.screens.project.settings.components

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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.Strings
import org.robok.engine.ui.screens.project.settings.viewmodel.ProjectSettingsViewModel

@Composable
fun BasicInputs(viewModel: ProjectSettingsViewModel, modifier: Modifier = Modifier) {
  val uiState = viewModel.uiState

  Column(modifier = modifier) {
    OutlinedTextField(
      value = uiState.gameName ?: "",
      onValueChange = { gameName -> viewModel.setGameName(gameName) },
      label = { Text(text = stringResource(id = Strings.settings_project_settings_game_name)) },
      shape = RoundedCornerShape(12.dp),
      modifier = Modifier.fillMaxWidth(),
    )

    OutlinedTextField(
      value = uiState.gameIconPath ?: "",
      onValueChange = { gameIconPath -> viewModel.setGameIconPath(gameIconPath) },
      label = {
        Text(text = stringResource(id = Strings.settings_project_settings_game_icon_path))
      },
      shape = RoundedCornerShape(12.dp),
      modifier = Modifier.fillMaxWidth(),
    )

    OutlinedTextField(
      value = uiState.mainScreenName ?: "",
      onValueChange = { mainScreenName -> viewModel.setMainScreenName(mainScreenName) },
      label = {
        Text(text = stringResource(id = Strings.settings_project_settings_game_main_screen_name))
      },
      shape = RoundedCornerShape(12.dp),
      modifier = Modifier.fillMaxWidth(),
    )
  }
}

package org.robok.engine.ui.screens.project.settings.components

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

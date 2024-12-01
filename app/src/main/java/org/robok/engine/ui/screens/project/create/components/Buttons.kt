package org.robok.engine.ui.screens.project.create.components

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel

@Composable
fun Buttons(
  viewModel: CreateProjectViewModel,
  modifier: Modifier = Modifier.fillMaxWidth(),
  onCreate: () -> Unit,
  onCancel: () -> Unit,
) {
  val uiState = viewModel.uiState

  Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier) {
    OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancel) {
      Text(text = stringResource(id = Strings.common_word_cancel))
    }
    Button(modifier = Modifier.weight(1f), onClick = onCreate) {
      Text(text = stringResource(id = Strings.title_create_project))
    }
  }
}

package org.robok.engine.ui.screens.project.create.components

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
import org.robok.engine.Strings
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

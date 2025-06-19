package org.robok.engine.ui.screens.editor.components.tab

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

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorFileTabActions(editorViewModel: EditorViewModel, index: Int, onClick: () -> Unit = {}) {
  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.common_word_close)) },
    onClick = {
      editorViewModel.closeFile(index)
      onClick()
    },
  )

  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.common_word_close_others)) },
    onClick = {
      editorViewModel.closeOthersFiles(index)
      onClick()
    },
  )

  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.common_word_close_all)) },
    onClick = {
      editorViewModel.closeAllFiles()
      onClick()
    },
  )
}

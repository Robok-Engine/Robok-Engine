package org.robok.engine.ui.core.components.dialog.sheet.choice

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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.robok.engine.strings.Strings
import org.robok.engine.ui.core.components.dialog.sheet.BottomSheetContent
import org.robok.engine.ui.core.components.radio.IntRadioController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceBottomSheet(
  visible: Boolean,
  title: @Composable () -> Unit,
  default: Int,
  options: List<Int>,
  titleFactory: (Int) -> String,
  excludedOptions: List<Int>,
  onRequestClose: () -> Unit,
  onChoice: (Int) -> Unit,
) {
  var tempSelectedOption by remember { mutableStateOf(default) }
  val btmSheetState = rememberModalBottomSheetState()
  val btmSheetScope = rememberCoroutineScope()

  if (visible) {
    ModalBottomSheet(onDismissRequest = { onRequestClose() }, sheetState = btmSheetState) {
      BottomSheetContent(
        title = title,
        buttons = {
          OutlinedButton(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            onClick = {
              btmSheetScope.launch {
                btmSheetState.hide()
                onRequestClose()
              }
            },
          ) {
            Text(stringResource(id = Strings.common_word_cancel))
          }
          Button(
            modifier = Modifier.padding(start = 4.dp, end = 4.dp),
            onClick = {
              btmSheetScope.launch {
                btmSheetState.hide()
                onChoice(tempSelectedOption)
                onRequestClose()
              }
            },
          ) {
            Text(stringResource(id = Strings.common_word_save))
          }
        },
      ) {
        IntRadioController(
          default = tempSelectedOption,
          options = options,
          excludedOptions = excludedOptions,
          labelFactory = titleFactory,
          onChoiceSelected = { selectedOption -> tempSelectedOption = selectedOption },
        )
      }
    }
  }
}

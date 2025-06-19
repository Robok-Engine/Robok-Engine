package org.robok.engine.ui.core.components.radio

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

@Composable
fun IntRadioController(
  default: Int,
  options: List<Int>,
  excludedOptions: List<Int> = emptyList(),
  labelFactory: (Int) -> String = { it.toString() },
  onChoiceSelected: (Int) -> Unit,
) {
  var selectedChoice by remember { mutableStateOf(default) }

  Column {
    options
      .filterNot { it in excludedOptions }
      .forEach { option ->
        PreferenceTemplate(
          title = { Text(text = labelFactory(option)) },
          modifier =
            Modifier.clickable {
              selectedChoice = option
              onChoiceSelected(option)
            },
          startWidget = { RadioButton(selected = option == selectedChoice, onClick = null) },
        )
      }
  }
}

package org.robok.engine.ui.core.components.dialog.input

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
import org.robok.engine.strings.Strings
import org.robok.engine.ui.core.components.dialog.EnhancedAlertDialog

/*
 * A Basic Dialog with Text Field for input.
 * @author Aquiles Trindade (trindadedev).
 */
@Composable
fun InputDialog(
  title: String,
  inputLabel: String,
  inputValue: String,
  onInputValueChange: (String) -> Unit,
  onConfirm: () -> Unit,
  onDismiss: () -> Unit,
) {
  EnhancedAlertDialog(
    onDismissRequest = onDismiss,
    title = { Text(text = title) },
    text = {
      Column {
        OutlinedTextField(
          value = inputValue,
          onValueChange = onInputValueChange,
          label = { Text(inputLabel) },
          modifier = Modifier.fillMaxWidth(),
        )
      }
    },
    confirmButton = {
      Button(onClick = onConfirm) { Text(text = stringResource(id = Strings.common_word_save)) }
    },
    dismissButton = {
      OutlinedButton(onClick = onDismiss) {
        Text(text = stringResource(id = Strings.common_word_cancel))
      }
    },
  )
}

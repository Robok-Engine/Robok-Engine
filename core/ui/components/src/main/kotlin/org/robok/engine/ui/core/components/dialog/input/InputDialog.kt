package org.robok.engine.ui.core.components.dialog.input

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

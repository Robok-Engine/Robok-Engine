package org.robok.engine.core.components.dialog.input

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.robok.engine.core.components.dialog.RobokDialog
import org.robok.engine.strings.Strings

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
  RobokDialog(
    onDismissRequest = onDismiss,
    title = { Text(text = title) },
    text = {
      Column {
        OutlinedTextField(
          value = inputValue,
          onValueChange = onInputValueChange,
          label = { Text(inputLabel) },
          modifier = Modifier.fillMaxWidth(),
          shape = RoundedCornerShape(12.dp),
        )
      }
    },
    confirmButton = { Text(stringResource(id = Strings.common_word_save)) },
    onConfirmation = onConfirm,
    dismissButton = { Text(stringResource(id = Strings.common_word_cancel)) },
  )
}

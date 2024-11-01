package org.robok.engine.core.components.dialog

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RobokDialog(
  onDismissRequest: () -> Unit,
  onConfirmation: () -> Unit,
  title: @Composable () -> Unit,
  text: @Composable () -> Unit,
  confirmButton: @Composable () -> Unit,
  dismissButton: @Composable (() -> Unit)? = null,
  icon: @Composable (() -> Unit)? = null,
  iconDescription: String = "Icon",
) {
  AlertDialog(
    icon = { icon?.let { it() } },
    title = { title() },
    text = { text() },
    onDismissRequest = { onDismissRequest() },
    confirmButton = { Button(onClick = { onConfirmation() }) { confirmButton() } },
    dismissButton = {
      dismissButton?.let { dismissText ->
        OutlinedButton(onClick = { onDismissRequest() }) { dismissText() }
      }
    },
  )
}

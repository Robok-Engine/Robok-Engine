package org.gampiot.robok.feature.component.compose.dialog

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
import androidx.compose.ui.unit.dp

import org.gampiot.robok.feature.component.compose.radio.IntRadioController
import org.gampiot.robok.feature.component.compose.text.RobokText

@Composable
fun RobokChoiceDialog(
    visible: Boolean,
    title: @Composable () -> Unit,
    default: Int,
    options: List<Int>, 
    labelFactory: (Int) -> String,
    excludedOptions: List<Int>,
    onRequestClose: () -> Unit,
    onChoice: (Int) -> Unit
) {
    if (visible) {
        AlertDialog(
            onDismissRequest = { onRequestClose() },
            title = title,
            text = {
                Column(
                    modifier = Modifier.padding(4.dp)
                ) {
                    IntRadioController(
                        default = default,
                        options = options,
                        excludedOptions = excludedOptions,
                        labelFactory = labelFactory,
                        onChoiceSelected = { selectedOption ->
                            onChoice(selectedOption)
                            onRequestClose()
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { onRequestClose() }) {
                    RobokText("Close")
                }
            }
        )
    }
}

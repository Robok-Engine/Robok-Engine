package org.robok.engine.core.components.dialog.sheet.choice

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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.robok.engine.core.components.dialog.sheet.BottomSheetContent
import org.robok.engine.core.components.radio.IntRadioController
import org.robok.engine.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChoiceBottomSheet(
    visible: Boolean,
    title: @Composable () -> Unit,
    default: Int,
    options: List<Int>,
    labelFactory: (Int) -> String,
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
                    labelFactory = labelFactory,
                    onChoiceSelected = { selectedOption -> tempSelectedOption = selectedOption },
                )
            }
        }
    }
}

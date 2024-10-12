package org.robok.engine.core.components.dialog.choice

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

@Composable
fun RobokChoiceDialog(
    visivel: Boolean,
    titulo: @Composable () -> Unit,
    padrao: Int,
    opcoes: List<Int>,
    fabricaDeLabel: (Int) -> String,
    opcoesExcluidas: List<Int>,
    aoSolicitarFechamento: () -> Unit,
    aoEscolher: (Int) -> Unit,
) {
    var opcaoTemporariaSelecionada by remember { mutableStateOf(padrao) }
    val estadoBtmSheet = rememberModalBottomSheetState()
    val escopoBtmSheet = rememberCoroutineScope()

    if (visivel) {
        ModalBottomSheet(
            onDismissRequest = { aoSolicitarFechamento() },
            sheetState = estadoBtmSheet,
        ) {
            BottomSheetContent(
                title = titulo,
                buttons = {
                    OutlinedButton(
                        onClick = {
                            escopoBtmSheet.launch {
                                estadoBtmSheet.hide()
                                aoSolicitarFechamento()
                            }
                        }
                    ) {
                        Text(stringResource(id = Strings.common_word_cancel))
                    }
                    Button(
                        onClick = {
                            escopoBtmSheet.launch {
                                estadoBtmSheet.hide()
                                aoEscolher(opcaoTemporariaSelecionada)
                                aoSolicitarFechamento()
                            }
                        }
                    ) {
                        Text(stringResource(id = Strings.common_word_save))
                    }
                },
            ) {
                IntRadioController(
                    default = opcaoTemporariaSelecionada,
                    options = opcoes,
                    excludedOptions = opcoesExcluidas,
                    labelFactory = fabricaDeLabel,
                    onChoiceSelected = { opcaoSelecionada -> opcaoTemporariaSelecionada = opcaoSelecionada },
                )
            }
        }
    }
}
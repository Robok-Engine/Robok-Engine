package org.gampiot.robok.feature.component.compose.dialog

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
    options: List<Int>, // Added options parameter
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

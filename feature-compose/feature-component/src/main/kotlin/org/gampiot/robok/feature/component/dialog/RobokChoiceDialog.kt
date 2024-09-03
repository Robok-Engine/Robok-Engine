package org.gampiot.robok.feature.component.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.gampiot.robok.feature.component.radio.IntRadioController

@Composable
fun RobokChoiceDialog(
    visible: Boolean,
    title: @Composable () -> Unit,
    default: Int,
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
                Column {
                    IntRadioController(
                        default = default,
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
                    Text("Close")
                }
            }
        )
    }
}

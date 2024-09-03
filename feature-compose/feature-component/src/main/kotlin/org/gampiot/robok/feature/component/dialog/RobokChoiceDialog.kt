package org.gampiot.robok.feature.component.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable

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
    var selectedOption by remember { mutableStateOf(default) }

    if (visible) {
        AlertDialog(
            onDismissRequest = { onRequestClose() },
            title = title,
            text = {
                Column {
                    (0..6).filterNot { it in excludedOptions }.forEach { option ->
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = { selectedOption = option }
                            )
                            Text(
                                text = labelFactory(option),
                                modifier = Modifier
                                    .clickable { selectedOption = option }
                                    .padding(start = 8.dp)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onChoice(selectedOption)
                    onRequestClose()
                }) {
                    Text("Close")
                }
            }
        )
    }
}

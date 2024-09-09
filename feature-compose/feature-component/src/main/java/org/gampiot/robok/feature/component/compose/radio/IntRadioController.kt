package org.gampiot.robok.feature.component.compose.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IntRadioController(
    default: Int,
    options: List<Int>, // Ensure options is included here
    excludedOptions: List<Int> = emptyList(),
    labelFactory: (Int) -> String = { it.toString() },
    onChoiceSelected: (Int) -> Unit
) {
    var selectedChoice by remember { mutableStateOf(default) }

    Column {
        options
            .filterNot { it in excludedOptions }
            .forEach { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            selectedChoice = option
                            onChoiceSelected(option)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = labelFactory(option),
                        modifier = Modifier.weight(1f)
                    )
                    RadioButton(
                        selected = option == selectedChoice,
                        onClick = {
                            selectedChoice = option
                            onChoiceSelected(option)
                        }
                    )
                }
            }
    }
}

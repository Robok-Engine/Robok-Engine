package org.gampiot.robok.feature.component.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun IntRadioController(
    default: Int,
    options: List<Int>,
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
                        .clickable {
                            selectedChoice = option
                            onChoiceSelected(option)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = labelFactory(option))
                    Spacer(modifier = Modifier.weight(1f))
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

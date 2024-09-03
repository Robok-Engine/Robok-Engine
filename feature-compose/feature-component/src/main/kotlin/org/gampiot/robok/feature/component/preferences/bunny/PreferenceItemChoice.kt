package org.gampiot.robok.feature.component.preferences.bunny

import androidx.compose.foundation.clickable
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import org.gampiot.robok.feature.component.dialog.RobokChoiceDialog

@Composable
fun PreferenceItemChoice(
    label: String,
    title: String = label,
    disabled: Boolean = false,
    pref: Int,
    options: List<Int>,
    excludedOptions: List<Int> = emptyList(),
    labelFactory: (Int) -> String = { it.toString() },
    onPrefChange: (Int) -> Unit,
) {
    val choiceLabel = labelFactory(pref)
    val (opened, setOpened) = remember { 
        mutableStateOf(false) 
    }

    PreferenceItem(
        modifier = 
           Modifier.clickable(enabled = !disabled) { setOpened(true) },
        text = { 
           Text(text = label)
        }
    ) {
        RobokChoiceDialog(
            visible = opened,
            title = {
               Text(title) 
            },
            default = pref,
            options = options,
            labelFactory = labelFactory,
            excludedOptions = excludedOptions,
            onRequestClose = {
                setOpened(false)
            },
            onChoice = {
                setOpened(false)
                onPrefChange(it)
            }
        )
        FilledTonalButton(
            onClick = { 
                setOpened(true)
            },
            enabled = !disabled) {
                Text(choiceLabel)
            }
    }
}

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
    excludedOptions: List<Int> = emptyList(),
    labelFactory: (Int) -> String = { it.toString() },
    onPrefChange: (Int) -> Unit,
) {
    val context = LocalContext.current
    val choiceLabel = labelFactory(pref)
    var opened by remember { mutableStateOf(false) }

    PreferenceItem(
        modifier = Modifier.clickable(enabled = !disabled) { opened = true },
        text = { Text(text = label) }
    ) {
        RobokChoiceDialog(
            visible = opened,
            title = { Text(title) },
            default = pref,
            labelFactory = labelFactory,
            excludedOptions = excludedOptions,
            onRequestClose = {
                opened = false
            },
            onChoice = {
                opened = false
                onPrefChange(it)
            }
        )
        FilledTonalButton(onClick = { opened = true }, enabled = !disabled) {
            Text(choiceLabel)
        }
    }
}

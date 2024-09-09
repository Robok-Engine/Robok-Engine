package org.gampiot.robok.feature.component.compose.preferences.choice

/*
 * Copyright 2024, Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceTemplate
import org.gampiot.robok.feature.component.compose.dialog.RobokChoiceDialog

/**
 * A Preference that allows the user to choose an option from a list of options.
 */
@Composable
fun PreferenceChoice(
    label: String,
    title: String = label,
    disabled: Boolean = false,
    pref: Int,
    options: List<Int>,
    excludedOptions: List<Int> = emptyList(),
    labelFactory: (Int) -> String = { it.toString() },
    onPrefChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val choiceLabel = labelFactory(pref)
    val (opened, setOpened) = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    PreferenceTemplate(
        modifier = modifier.clickable(
            enabled = !disabled,
            indication = ripple(),
            interactionSource = interactionSource,
        ) {
            setOpened(true)
        },
        contentModifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 16.dp)
            .padding(start = 16.dp),
        title = { Text(text = label) },
        endWidget = {
            if (!disabled) {
                FilledTonalButton(
                    modifier = Modifier
                        .width(150.dp)
                        .padding(horizontal = 16.dp),
                    onClick = { setOpened(true) },
                    enabled = !disabled
                ) {
                    Text(choiceLabel)
                }
            }
        },
        enabled = !disabled,
        applyPaddings = false
    )

    if (opened) {
        RobokChoiceDialog(
            visible = opened,
            title = { Text(title) },
            default = pref,
            options = options,
            labelFactory = labelFactory,
            excludedOptions = excludedOptions,
            onRequestClose = { setOpened(false) },
            onChoice = {
                setOpened(false)
                onPrefChange(it)
            }
        )
    }
}

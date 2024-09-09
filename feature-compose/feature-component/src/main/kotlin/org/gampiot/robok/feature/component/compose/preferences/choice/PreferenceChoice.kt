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
 

import androidx.compose.foundation.clickable
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.dialog.RobokChoiceDialog

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
) {
    val choiceLabel = labelFactory(pref)
    val (opened, setOpened) = remember { 
        mutableStateOf(false) 
    }

    Preference(
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

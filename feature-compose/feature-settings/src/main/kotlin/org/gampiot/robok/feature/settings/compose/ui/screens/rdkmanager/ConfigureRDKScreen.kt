package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.navigation.*
import androidx.compose.ui.platform.*

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.component.compose.preferences.normal.Preference
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigureRDKScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    
    val rdkVersions = listOf(
      "RDK-1",
      "RDK-2" /* fictitious */
    )
    
    val context = LocalContext.current
    
    var textFieldLabel by remember {
        mutableStateOf(context.getString(Strings.settings_configure_rdk_select_rdk_label))
    }
    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_configure_rdk_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
            DynamicSelectTextField(
                modifier = Modifier
                   .padding(8.dp),
                selectedValue = "RDK-01",
                options = rdkVersions,
                label = textFieldLabel,
                onValueChangedEvent = { 
                    textFieldLabel = it
                }
            )
            Button(
                onClick = { /* nothing happed yet */ }
            ) {
                Text(text = stringResource(id = Strings.common_word_save))
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedValue,
            onValueChange = {},
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = OutlinedTextFieldDefaults.colors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option: String ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        expanded = false
                        onValueChangedEvent(option)
                    }
                )
            }
        }
    }
}
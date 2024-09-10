package org.gampiot.robok.feature.settings.compose.screens.ui.rdkmanager

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.koinViewModel
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigureRDKScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: ConfigureRDKViewModel = koinViewModel { ConfigureRDKViewModel(context) }
    
    val rdkVersions = listOf("RDK-1")
    var version by remember { mutableStateOf("RDK-1") }
    
    val zipUrl = "https://github.com/robok-inc/Robok-SDK/raw/dev/versions/$version/$version.zip"
    val outputDirName = "robok-sdk"
    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_configure_rdk_title),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.settings_configure_rdk_version)) {
            DynamicSelectTextField(
                modifier = Modifier
                   .padding(horizontal = 18.dp, vertical = 8.dp),
                selectedValue = version,
                options = rdkVersions,
                label = stringResource(id = Strings.settings_configure_rdk_version),
                onValueChangedEvent = { selectedVersion ->
                    version = selectedVersion
                }
            )
            Button(
                modifier = Modifier
                   .padding(horizontal = 18.dp, vertical = 8.dp)
                   .fillMaxWidth(),
                onClick = {
                    viewModel.startDownload(zipUrl, outputDirName)
                }
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
package org.gampiot.robok.feature.settings.compose.screens.ui.editor

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext

import org.koin.androidx.compose.koinViewModel

import org.gampiot.robok.feature.component.compose.ApplicationScreen
import org.gampiot.robok.feature.component.compose.appbars.TopBar
import org.gampiot.robok.feature.component.compose.Title
import org.gampiot.robok.feature.component.compose.preferences.PreferenceItem
import org.gampiot.robok.feature.component.compose.preferences.bunny.PreferenceItemChoice
import org.gampiot.robok.feature.settings.compose.viewmodels.AppPreferencesViewModel
import org.gampiot.robok.feature.res.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsCodeEditorScreen(
    navController: NavController
) {
    val appPrefsViewModel = koinViewModel<AppPreferencesViewModel>()
    val editorTheme by appPrefsViewModel.editorTheme.collectAsState(initial = 0)
    val editorTypeface by appPrefsViewModel.editorTypeface.collectAsState(initial = 0)
    val editorIsUseWordWrap by appPrefsViewModel.editorIsUseWordWrap.collectAsState(initial = false)
    
    val context = LocalContext.current
    
    val editorThemes = listOf(0, 1, 2, 3, 4, 5, 6) //ints/positions
    val editorThemeLabels = listOf(
        "Robok",
        "Robok TH", 
        "GitHub", 
        "Eclipse", 
        "Darcula", 
        "Visual Studio Code 19", 
        "Notepad XX"
    ) // strings/labels
    
    val editorTypefaces = listOf(0, 1, 2, 3, 4) // ints/positions
    val editorTypefacesLabels = listOf(
       context.getString(Strings.common_word_normal),
       context.getString(Strings.text_bold),
       context.getString(Strings.text_monospace),
       context.getString(Strings.text_sans_serif),
       context.getString(Strings.text_serif)
    ) // strings/labels
       
    ApplicationScreen(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        topBar = {
            TopBar(
                barTitle = stringResource(id = Strings.settings_code_editor_title),
                scrollBehavior = it,
                onClickBackButton = {
                    navController.popBackStack()
                }
            )
        },
        content = {
            Column(modifier = Modifier) {
                Title(title = stringResource(id = Strings.settings_appearance_title))
                PreferenceItemChoice(
                    label = stringResource(id = Strings.settings_code_editor_theme_title),
                    title = stringResource(id = Strings.settings_code_editor_theme_description),
                    pref = editorTheme,
                    options = editorThemes,
                    excludedOptions = emptyList(),
                    labelFactory = { index ->
                        editorThemeLabels.getOrElse(index) { "Unknown" }
                    },
                    onPrefChange = { newTheme ->
                        appPrefsViewModel.changeEditorTheme(newTheme)
                    }
                )
                PreferenceItemChoice(
                    label = stringResource(id = Strings.settings_code_editor_typeface_title),
                    title = stringResource(id = Strings.settings_code_editor_typeface_description),
                    pref = editorTypeface,
                    options = editorTypefaces,
                    excludedOptions = emptyList(),
                    labelFactory = { index ->
                        editorTypefacesLabels.getOrElse(index) { "Unknown" }
                    },
                    onPrefChange = { newTypeface ->
                        appPrefsViewModel.changeEditorTypeface(newTypeface)
                    }
                )
                Title(title = stringResource(id = Strings.settings_formatting_title))
                PreferenceItem (
                     title = stringResource(id = Strings.settings_code_editor_word_wrap_title),
                     description = stringResource(id = Strings.settings_code_editor_word_wrap_description),
                     showToggle = true,
                     isChecked = editorIsUseWordWrap,
                     onClick = {
                          appPrefsViewModel.enableEditorWordWrap(!it)
                     }
                )
            }
        }
    )
}

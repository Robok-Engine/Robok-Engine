package org.robok.engine.ui.screens.project.create

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Intent
import android.os.Environment
import android.widget.Toast

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.collectAsState

import kotlinx.coroutines.launch

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.robok.engine.strings.Strings
import org.robok.engine.defaults.DefaultTemplate
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.activities.editor.EditorActivity
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModelFactory
import org.robok.engine.ui.screens.project.create.state.CreateProjectState
import org.robok.engine.core.components.compose.dialog.RobokDialog
import org.robok.engine.core.components.compose.preferences.base.PreferenceLayout
import org.robok.engine.core.components.compose.preferences.base.PreferenceGroup

import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProjectScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val projectPath = File(Environment.getExternalStorageDirectory(), "Robok/.projects/Empty")
    val projectManager = ProjectManager(context)
    val viewModel: CreateProjectViewModel = viewModel(
        factory = CreateProjectViewModelFactory(projectManager)
    )
    val state = viewModel.state 

    PreferenceLayout(
        label = stringResource(id = Strings.title_create_project),
        backArrowVisible = true,
    ) {
        PreferenceGroup(heading = stringResource(id = Strings.text_basic_info)) {
            Screen(
               state = state,
               viewModel = viewModel,
               template= DefaultTemplate(),
               navController = navController,
               context = context
            )
        }
    }

    if (state.errorMessage != null) {
        LaunchedEffect(state.errorMessage) {
            Toast.makeText(context, state.errorMessage, Toast.LENGTH_SHORT).show()
            viewModel.updateErrorMessage(null) 
        }
    }
}

@Composable
private fun Screen(
    state: CreateProjectState,
    viewModel: CreateProjectViewModel,
    template: ProjectTemplate,
    navController: NavHostController,
    context: android.content.Context,
    modifier: Modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
) {
    
    OutlinedTextField(
        value = state.projectName,
        onValueChange = { viewModel.updateProjectName(it) },
        label = { Text(text = stringResource(id = Strings.hint_project_name), maxLines = 1) },
        modifier = modifier.fillMaxWidth()
    )
    OutlinedTextField(
        value = state.packageName,
        onValueChange = { viewModel.updatePackageName(it) },
        label = { Text(text = stringResource(id = Strings.hint_package_name), maxLines = 1) },
        modifier = modifier.fillMaxWidth()
    )
    
    var isShowDialog = remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = { navController.popBackStack() }
        ) {
            Text(text = stringResource(id = Strings.common_word_cancel))
        }
        Button(
            modifier = Modifier.weight(1f),
            onClick = {
                viewModel.setProjectPath(File(Environment.getExternalStorageDirectory(), "Robok/.projects/${state.projectName}"))
                viewModel.createProject(template,
                   onSuccess = {
                        val bundle = android.os.Bundle().apply {
                             putString("projectPath", viewModel.getProjectPath().absolutePath)
                        }
                        val intent = Intent(context, EditorActivity::class.java).apply {
                             putExtras(bundle)
                        }
                        context.startActivity(intent)
                   },
                   onError = {  error ->
                        isShowDialog.value = true
                        title = "An error occurred"
                        message = error
                   }
                )
            }
        ) {
           Text(text = stringResource(id = Strings.title_create_project))
        }
        ShowVeryBasicDialog(title = title, message = message, isShowDialog = isShowDialog)
    }
}

@Composable
fun ShowVeryBasicDialog(
    title: String,
    message: String,
    isShowDialog: MutableState<Boolean>
) {
    if (isShowDialog.value) {
        RobokDialog(
            onDismissRequest = {
                isShowDialog.value = false
            },
            onConfirmation = {
                isShowDialog.value = false
            },
            title = {
                Text(text = title, fontSize = 24.sp)
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                Text(stringResource(id = Strings.common_word_ok))
            },
            dismissButton = {
                Text(stringResource(id = Strings.common_word_cancel))
            },
            icon = {
                Icon(Icons.Outlined.Settings, contentDescription = "Icon")
            }
        )
    }
}
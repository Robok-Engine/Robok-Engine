package org.gampiot.robok.ui.screens.project.create

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
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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

import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.models.project.ProjectTemplate
import org.gampiot.robok.manage.project.ProjectManager
import org.gampiot.robok.ui.activities.editor.EditorActivity
import org.gampiot.robok.feature.component.compose.text.RobokText
import org.gampiot.robok.feature.component.compose.dialog.RobokDialog
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup

import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProjectScreen(
    navController: NavController,
    projectTemplate: ProjectTemplate
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
               template = projectTemplate,
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
    navController: NavController,
    context: android.content.Context,
    modifier: Modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
) {
    
    OutlinedTextField(
        value = state.projectName,
        onValueChange = { viewModel.updateProjectName(it) },
        label = { RobokText(text = stringResource(id = Strings.hint_project_name)) },
        modifier = modifier.fillMaxWidth()
    )
    OutlinedTextField(
        value = state.packageName,
        onValueChange = { viewModel.updatePackageName(it) },
        label = { RobokText(text = stringResource(id = Strings.hint_package_name)) },
        modifier = modifier.fillMaxWidth()
    )
    
    //Spacer(modifier = Modifier.weight(1f))
    
    var showDialog by remember { mutableStateOf(false) }
    
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedButton(
            modifier = Modifier.weight(1f),
            onClick = { navController.popBackStack() }
        ) {
            RobokText(text = stringResource(id = Strings.common_word_cancel))
        }
        Button(
            modifier = Modifier.weight(1f),
            onClick = {
                viewModel.setProjectPath(File(Environment.getExternalStorageDirectory(), "Robok/.projects/${state.projectName}"))
                viewModel.createProject(template,
                   onSuccess = {
                        showProjectCreatedDialog(context, viewModel.getProjectPath())
                   },
                   onError = { error ->
                        showDialog = true
                   }
                )
            }
        ) {
           RobokText(text = stringResource(id = Strings.title_create_project))
        }
        showErrorDialog(showDialog = showDialog, error = error)
    }
}

@Composable
fun showErrorDialog(
   showDialog: Boolean,
   error: String
) {
    if (showDialog) {
        RobokDialog(
            onDismissRequest = {
                showDialog = false
            },
            onConfirmation = {
                showDialog = false
            },
            dialogTitle = "Something unexpected happened",
            dialogText = error,
            iconDescription = "Error Icon"
        )
    }
}

private fun showProjectCreatedDialog(context: android.content.Context, projectPath: File) {
    val dialog = MaterialAlertDialogBuilder(context)
        .setTitle(context.getString(Strings.warning_project_created_title))
        .setMessage(context.getString(Strings.warning_project_created_message))
        .setPositiveButton(context.getString(Strings.title_open_project)) { _, _ ->
            val bundle = android.os.Bundle().apply {
                putString("projectPath", projectPath.absolutePath)
            }

            val intent = Intent(context, EditorActivity::class.java).apply {
                putExtras(bundle)
            }
            context.startActivity(intent)
        }
        .setNegativeButton(context.getString(Strings.common_word_ok)) { dialog, _ ->
            dialog.dismiss()
        }
        .create()

    dialog.show()
}
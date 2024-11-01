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
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.io.File
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.dialog.RobokDialog
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.editor.EditorActivity
import org.robok.engine.ui.screens.project.create.state.CreateProjectState
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel

@Composable
fun CreateProjectScreen(template: ProjectTemplate) {
  val context = LocalContext.current

  val projectManager = ProjectManager(context)
  val viewModel: CreateProjectViewModel = koinViewModel { parametersOf(projectManager) }
  val state = viewModel.state

  LaunchedEffect(template) {
    viewModel.updateProjectName(template.name)
    viewModel.updatePackageName(template.packageName)
  }

  Screen(label = stringResource(id = Strings.title_create_project)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_basic_info)) {
      Screen(state = state, viewModel = viewModel, template = template, context = context)
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
  context: android.content.Context,
  modifier: Modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
) {
  val navController = LocalMainNavController.current

  OutlinedTextField(
    value = state.projectName,
    onValueChange = { viewModel.updateProjectName(it) },
    label = { Text(text = stringResource(id = Strings.hint_project_name), maxLines = 1) },
    shape = RoundedCornerShape(12.dp),
    modifier = modifier.fillMaxWidth(),
  )
  OutlinedTextField(
    value = state.packageName,
    onValueChange = { viewModel.updatePackageName(it) },
    label = { Text(text = stringResource(id = Strings.hint_package_name), maxLines = 1) },
    shape = RoundedCornerShape(12.dp),
    modifier = modifier.fillMaxWidth(),
  )

  var isShowDialog = remember { mutableStateOf(false) }
  var title by remember { mutableStateOf("") }
  var message by remember { mutableStateOf("") }

  Row(horizontalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier.fillMaxWidth()) {
    OutlinedButton(modifier = Modifier.weight(1f), onClick = { navController.popBackStack() }) {
      Text(text = stringResource(id = Strings.common_word_cancel))
    }
    Button(
      modifier = Modifier.weight(1f),
      onClick = {
        viewModel.setProjectPath(File(ProjectManager.getProjectsPath(), state.projectName))
        viewModel.createProject(
          template,
          onSuccess = {
            val bundle =
              android.os.Bundle().apply {
                putString(ExtraKeys.Project.PATH, viewModel.getProjectPath().absolutePath)
              }
            val intent = Intent(context, EditorActivity::class.java).apply { putExtras(bundle) }
            context.startActivity(intent)
          },
          onError = { error ->
            isShowDialog.value = true
            title = "An error occurred"
            message = error
          },
        )
      },
    ) {
      Text(text = stringResource(id = Strings.title_create_project))
    }
    ShowVeryBasicDialog(title = title, message = message, isShowDialog = isShowDialog)
  }
}

@Composable
fun ShowVeryBasicDialog(title: String, message: String, isShowDialog: MutableState<Boolean>) {
  if (isShowDialog.value) {
    RobokDialog(
      onDismissRequest = { isShowDialog.value = false },
      onConfirmation = { isShowDialog.value = false },
      title = { Text(text = title, fontSize = 24.sp) },
      text = { Text(text = message) },
      confirmButton = { Text(stringResource(id = Strings.common_word_ok)) },
      dismissButton = { Text(stringResource(id = Strings.common_word_cancel)) },
      icon = { Icon(Icons.Outlined.Settings, contentDescription = "Icon") },
    )
  }
}

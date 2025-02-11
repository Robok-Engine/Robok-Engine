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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.io.File
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.robok.engine.Strings
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.dialog.loading.LoadingDialog
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.toast.LocalToastHostState
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.routes.EditorRoute
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.screens.project.create.components.Buttons
import org.robok.engine.ui.screens.project.create.components.Inputs
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel

@Composable
fun CreateProjectScreen(template: ProjectTemplate) {
  val context = LocalContext.current
  val navController = LocalMainNavController.current
  val projectManager = ProjectManager(context)
  val viewModel: CreateProjectViewModel = koinViewModel { parametersOf(projectManager) }
  val uiState = viewModel.uiState
  val toastHostState = LocalToastHostState.current
  val coroutineScope = rememberCoroutineScope()

  LaunchedEffect(template) {
    viewModel.setProjectName(template.name)
    viewModel.setPackageName(template.packageName)
  }

  Screen(label = stringResource(id = Strings.title_create_project)) {
    PreferenceGroup(heading = stringResource(id = Strings.text_basic_info)) {
      val modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 8.dp)

      Inputs(modifier = modifier, viewModel = viewModel)
      Buttons(
        modifier = modifier,
        viewModel = viewModel,
        onCreate = {
          viewModel.setProjectPath(File(ProjectManager.PROJECTS_PATH, uiState.projectName))
          viewModel.createProject(
            template,
            onSuccess = {
              navController.navigateSingleTop(EditorRoute(viewModel.getProjectPath().absolutePath))
            },
            onError = { error ->
              coroutineScope.launch {
                toastHostState.showToast(
                  message = context.getString(Strings.title_un_error_ocurred),
                  icon = Icons.Rounded.Error,
                )
              }
            },
          )
        },
        onCancel = { navController.popBackStack() },
      )
    }
  }
  if (uiState.isLoading) {
    LoadingDialog()
  }
}

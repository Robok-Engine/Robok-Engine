package org.robok.engine.ui.screens.project.create

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.navigation.routes.EditorRoute
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.dialog.loading.LoadingDialog
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.toast.LocalToastHostState
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.screens.project.create.components.Buttons
import org.robok.engine.ui.screens.project.create.components.Inputs
import org.robok.engine.ui.screens.project.create.components.LanguageChooser
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
    val modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 8.dp)
    PreferenceGroup(heading = stringResource(id = Strings.text_basic_info)) {
      Inputs(modifier = modifier, viewModel = viewModel)
      Buttons(
        modifier = modifier,
        viewModel = viewModel,
        onCreate = {
          viewModel.setIsLoading(true)
          viewModel.setProjectPath(File(ProjectManager.PROJECTS_PATH, uiState.projectName))
          viewModel.create(
            template,
            onSuccess = {
              navController.navigateSingleTop(EditorRoute(viewModel.getProjectPath().absolutePath))
            },
            onError = { error ->
              coroutineScope.launch {
                toastHostState.showToast(message = error, icon = Icons.Rounded.Error)
              }
            },
          )
        },
        onCancel = { navController.popBackStack() },
      )
    }
    PreferenceGroup(heading = stringResource(Strings.text_project_language)) {
      LanguageChooser(modifier = modifier, viewModel = viewModel)
    }
  }
  if (uiState.isLoading) {
    LoadingDialog()
  }
}

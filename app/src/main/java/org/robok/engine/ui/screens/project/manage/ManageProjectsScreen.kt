package org.robok.engine.ui.screens.project.manage

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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Strings
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.navigation.routes.TemplatesRoute
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.screens.project.manage.viewmodel.ManageProjectsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageProjectsScreen(onProjectClick: (String) -> Unit) {
  val projectViewModel = koinViewModel<ManageProjectsViewModel>()
  val projects by projectViewModel.projects.collectAsState()

  LaunchedEffect(Unit) {
    withContext(Dispatchers.IO) {
      projectViewModel.updateProjects(
        ProjectManager.PROJECTS_PATH.listFiles() ?: emptyArray<File>()
      )
    }
  }
  Screen(label = stringResource(id = Strings.title_projects)) {
    PreferenceGroup(heading = stringResource(id = Strings.title_your_projects)) {
      if (projects.isEmpty().not()) {
        projects.forEach { project ->
          ProjectItem(projectFile = project, onProjectClick = onProjectClick)
        }
      } else {
        EmptyContentItem()
      }
    }
  }
}

@Composable
fun ProjectItem(projectFile: File, onProjectClick: (String) -> Unit) {
  val navController = LocalMainNavController.current
  val context = LocalContext.current
  PreferenceTemplate(
    title = { Text(text = projectFile.name, style = MaterialTheme.typography.titleMedium) },
    description = { Text(text = projectFile.path, style = MaterialTheme.typography.titleSmall) },
    modifier = Modifier.fillMaxWidth().clickable(onClick = { onProjectClick(projectFile.path) }),
  )
}

@Composable
fun EmptyContentItem() {
  val navController = LocalMainNavController.current

  PreferenceTemplate(
    title = {
      Text(
        text = stringResource(id = Strings.warning_no_projects),
        style = MaterialTheme.typography.titleMedium,
      )
    },
    startWidget = {
      Image(
        imageVector = Icons.Rounded.Warning,
        contentDescription = stringResource(id = Strings.warning_no_projects),
        modifier = Modifier.size(32.dp).clip(CircleShape),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )
    },
    modifier =
      Modifier.fillMaxWidth().clickable { navController.navigateSingleTop(route = TemplatesRoute) },
  )
}

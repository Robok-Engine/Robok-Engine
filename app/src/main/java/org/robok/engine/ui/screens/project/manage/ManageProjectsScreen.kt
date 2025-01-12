package org.robok.engine.ui.screens.project.manage

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.Drawables
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup
import org.robok.engine.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.routes.TemplatesRoute
import org.robok.engine.strings.Strings
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
      )
    },
    modifier =
      Modifier.fillMaxWidth().clickable { navController.navigateSingleTop(route = TemplatesRoute) },
  )
}

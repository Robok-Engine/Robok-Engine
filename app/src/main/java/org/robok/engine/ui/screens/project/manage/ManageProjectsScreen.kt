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

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.editor.EditorActivity
import org.robok.engine.ui.screens.project.manage.viewmodel.ManageProjectsViewModel
import org.robok.engine.keys.ExtraKeys

val projectPath = File(ProjectManager.PROJECTS_PATH)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageProjectsScreen() {
    val projectViewModel = koinViewModel<ManageProjectsViewModel>()
    val projects by projectViewModel.projects.collectAsState()

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            projectViewModel.updateProjects(projectPath.listFiles() ?: emptyArray<File>())
        }
    }
    Screen(label = stringResource(id = Strings.title_projects)) {
        PreferenceGroup(heading = stringResource(id = Strings.title_your_projects)) {
            if (projects.isEmpty().not()) {
                projects.forEach { project -> ProjectItem(projectFile = project) }
            } else {
                EmptyContentItem()
            }
        }
    }
}

@Composable
fun ProjectItem(projectFile: File) {
    val context = LocalContext.current
    PreferenceTemplate(
        title = { Text(text = projectFile.name, style = MaterialTheme.typography.titleMedium) },
        description = {
            Text(text = projectFile.path, style = MaterialTheme.typography.titleSmall)
        },
        modifier =
            Modifier.fillMaxWidth()
                .clickable(
                    onClick = {
                        context.startActivity(
                            Intent(context, EditorActivity::class.java).apply {
                                putExtras(
                                    android.os.Bundle().apply {
                                        putString(ExtraKeys.Project.PATH, projectFile.absolutePath)
                                    }
                                )
                            }
                        )
                    }
                ),
    )
}

@Composable
fun EmptyContentItem() {
    PreferenceTemplate(
        title = {
            Text(
                text = stringResource(id = Strings.warning_no_projects),
                style = MaterialTheme.typography.titleMedium,
            )
        },
        startWidget = {
            Image(
                painter = painterResource(id = Drawables.ic_warning_24),
                contentDescription = null,
                modifier =
                    Modifier.size(32.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceContainer),
            )
        },
        modifier =
            Modifier.fillMaxWidth().clickable(onClick = { /* TO-DO: go to CreateProjectScreen */ }),
    )
}

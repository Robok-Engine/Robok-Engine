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
import android.os.Environment

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import org.robok.engine.core.components.compose.preferences.base.PreferenceLayout
import org.robok.engine.core.components.compose.preferences.base.PreferenceGroup
import org.robok.engine.core.components.compose.preferences.base.PreferenceTemplate

import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.editor.EditorActivity
import org.robok.engine.ui.screens.project.manage.viewmodel.ManageProjectsViewModel

import java.io.File

val projectPath = File(Environment.getExternalStorageDirectory(), "Robok/.projects")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageProjectsScreen(
    navController: NavController
) {
    val projectViewModel: ManageProjectsViewModel = viewModel()
    val projects by projectViewModel.projects.collectAsState()

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            projectViewModel.updateProjects(projectPath.listFiles() ?: emptyArray<File>())
        }
    }
    PreferenceLayout(
        label = stringResource(id = Strings.title_projects),
        backArrowVisible = true,
    ) {
        PreferenceGroup(
            heading = stringResource(id = Strings.title_your_projects)
        ) {
            if(projects.isEmpty().not()) {
                projects.forEach { project -> 
                    ProjectItem(projectFile = project)
                }
            } else {
                Row(
                   modifier = Modifier
                      .fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.Center
                ){
                   Text(text = stringResource(id = Strings.warning_no_projects))
                }
            }
        }
    }
}

@Composable
fun ProjectItem(
    projectFile: File
) {
    val context = LocalContext.current
    PreferenceTemplate(
        title = { 
            Text(
                text = projectFile.name, 
                style = MaterialTheme.typography.titleMedium
            ) 
        },
        description = {
            Text(
                text = projectFile.path,
                style = MaterialTheme.typography.titleSmall
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = {
                    context.startActivity(Intent(context, EditorActivity::class.java).apply {
                        putExtras(android.os.Bundle().apply {
                            putString("projectPath", projectFile.absolutePath)
                        })
                    })
                }
            )
    )
}
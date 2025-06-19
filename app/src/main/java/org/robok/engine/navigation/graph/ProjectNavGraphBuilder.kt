package org.robok.engine.navigation.graph

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

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import java.io.File
import kotlin.reflect.typeOf
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.navigation.navtype.CustomNavType
import org.robok.engine.navigation.routes.CreateProjectRoute
import org.robok.engine.navigation.routes.EditorRoute
import org.robok.engine.navigation.routes.ManageProjectsRoute
import org.robok.engine.navigation.routes.ProjectSettingsRoute
import org.robok.engine.navigation.routes.TemplatesRoute
import org.robok.engine.ui.screens.project.create.CreateProjectScreen
import org.robok.engine.ui.screens.project.manage.ManageProjectsScreen
import org.robok.engine.ui.screens.project.settings.ProjectSettingsScreen
import org.robok.engine.ui.screens.project.template.ProjectTemplatesScreen

fun NavGraphBuilder.ProjectNavGraphBuilder(navController: NavHostController) {
  composable<TemplatesRoute> {
    ProjectTemplatesScreen(
      onTemplateClick = { template ->
        navController.navigateSingleTop(CreateProjectRoute(template))
      }
    )
  }

  composable<CreateProjectRoute>(
    typeMap =
      mapOf(
        typeOf<ProjectTemplate>() to
          CustomNavType(ProjectTemplate::class.java, ProjectTemplate.serializer())
      )
  ) {
    val route: CreateProjectRoute = it.toRoute()
    CreateProjectScreen(template = route.template)
  }

  composable<ManageProjectsRoute> {
    ManageProjectsScreen(
      onProjectClick = { projectPath -> navController.navigateSingleTop(EditorRoute(projectPath)) }
    )
  }

  composable<ProjectSettingsRoute>(typeMap = mapOf(typeOf<String>() to NavType.StringType)) {
    val route: ProjectSettingsRoute = it.toRoute()
    val context = LocalContext.current
    val projectManager = ProjectManager(context).apply { projectPath = File(route.projectPath) }
    ProjectSettingsScreen(onBack = { navController.popBackStack() }, projectManager)
  }
}

package org.robok.engine.navigation

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

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlin.reflect.typeOf
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.routes.CreateProjectRoute
import org.robok.engine.routes.ManageProjectsRoute
import org.robok.engine.routes.TemplatesRoute
import org.robok.engine.ui.screens.project.create.CreateProjectScreen
import org.robok.engine.ui.screens.project.manage.ManageProjectsScreen
import org.robok.engine.ui.screens.project.template.ProjectTemplatesScreen

fun NavGraphBuilder.ProjectRoutes(navController: NavHostController) {
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

  composable<ManageProjectsRoute> { ManageProjectsScreen() }
}

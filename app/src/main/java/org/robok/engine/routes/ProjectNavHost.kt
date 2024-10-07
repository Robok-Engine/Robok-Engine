package org.robok.engine.routes

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

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import org.robok.engine.Drawables
import org.robok.engine.strings.Strings
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.ui.screens.project.create.CreateProjectScreen
import org.robok.engine.ui.screens.project.manage.ManageProjectsScreen

@Composable
fun ProjectNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ProjectRoutes.CreateProject.route,
        enterTransition = AnimationTransitions.enterTransition,
        exitTransition = AnimationTransitions.exitTransition,
        popEnterTransition = AnimationTransitions.popEnterTransition,
        popExitTransition = AnimationTransitions.popExitTransition
    ) {
        composable(ProjectRoutes.CreateProject.route) {
            CreateProjectScreen(
                navController = navController,
                projectTemplate = getTemplate()
            )
        } 
        composable(ProjectRoutes.ManageProjects.route){
            ManageProjectsScreen(navController = navController)
        }
    }
}

private fun getTemplate(): ProjectTemplate {
    return ProjectTemplate(
       name = getString(Strings.template_name_empty_game),
       packageName = "com.robok.empty",
       zipFileName = "empty_game.zip",
       javaSupport = true,
       kotlinSupport = false,
       imageResId = Drawables.ic_empty_game
    )
}
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

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlin.reflect.typeOf
import org.robok.engine.navigation.graph.ProjectNavGraphBuilder
import org.robok.engine.navigation.graph.SettingsNavGraphBuilder
import org.robok.engine.navigation.routes.EditorRoute
import org.robok.engine.navigation.routes.HomeRoute
import org.robok.engine.navigation.routes.ProjectSettingsRoute
import org.robok.engine.navigation.routes.TerminalRoute
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.screens.editor.EditorNavigateActions
import org.robok.engine.ui.screens.editor.EditorScreen
import org.robok.engine.ui.screens.editor.LocalEditorDrawerNavController
import org.robok.engine.ui.screens.editor.LocalEditorFilesDrawerState
import org.robok.engine.ui.screens.editor.LocalEditorModalState
import org.robok.engine.ui.screens.editor.components.modal.rememberEditorModalState
import org.robok.engine.ui.screens.home.HomeScreen
import org.robok.engine.ui.screens.terminal.TerminalScreen

@Composable
fun MainNavHost() {
  val navController = LocalMainNavController.current

  BaseNavHost(navController = navController, startDestination = HomeRoute) {
    composable<HomeRoute> { HomeScreen() }

    composable<TerminalRoute> { TerminalScreen() }

    composable<EditorRoute>(typeMap = mapOf(typeOf<String>() to NavType.StringType)) {
      CompositionLocalProvider(
        LocalEditorFilesDrawerState provides rememberDrawerState(DrawerValue.Closed),
        LocalEditorDrawerNavController provides rememberNavController(),
        LocalEditorModalState provides rememberEditorModalState(),
      ) {
        val route: EditorRoute = it.toRoute()
        EditorScreen(
          projectPath = route.projectPath,
          editorNavigateActions =
            EditorNavigateActions(
              popBackStack = { navController.popBackStack() },
              onNavigateToProjectSettings = { projectPath ->
                navController.navigate(ProjectSettingsRoute(projectPath))
              },
            ),
        )
      }
    }

    ProjectNavGraphBuilder(navController)
    SettingsNavGraphBuilder(navController)
  }
}

package org.robok.engine.navigation

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
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.screens.editor.EditorNavigateActions
import org.robok.engine.ui.screens.editor.EditorScreen
import org.robok.engine.ui.screens.editor.LocalEditorDrawerNavController
import org.robok.engine.ui.screens.editor.LocalEditorFilesDrawerState
import org.robok.engine.ui.screens.editor.LocalEditorModalState
import org.robok.engine.ui.screens.editor.components.modal.rememberEditorModalState
import org.robok.engine.ui.screens.home.HomeScreen

@Composable
fun MainNavHost() {
  val navController = LocalMainNavController.current

  BaseNavHost(navController = navController, startDestination = HomeRoute) {
    composable<HomeRoute> { HomeScreen() }

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

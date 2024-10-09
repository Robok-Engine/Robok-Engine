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

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.robok.engine.BuildConfig
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.routes.AboutLibrariesRoute
import org.robok.engine.routes.AboutRoute
import org.robok.engine.routes.CreateProjectRoute
import org.robok.engine.routes.HomeRoute
import org.robok.engine.routes.ManageProjectsRoute
import org.robok.engine.routes.SettingsAppRoute
import org.robok.engine.routes.SettingsCodeEditorRoute
import org.robok.engine.routes.SettingsRDKRoute
import org.robok.engine.routes.SettingsRoute
import org.robok.engine.routes.TemplateRoute
import org.robok.engine.ui.animations.navigation.NavigationAnimationTransitions
import org.robok.engine.ui.screens.home.HomeScreen
import org.robok.engine.ui.screens.project.create.CreateProjectScreen
import org.robok.engine.ui.screens.project.manage.ManageProjectsScreen
import org.robok.engine.ui.screens.settings.SettingsScreen
import org.robok.engine.ui.screens.settings.about.AboutScreen
import org.robok.engine.ui.screens.settings.app.SettingsAppScreen
import org.robok.engine.ui.screens.settings.editor.SettingsCodeEditorScreen
import org.robok.engine.ui.screens.settings.libraries.LibrariesScreen
import org.robok.engine.ui.screens.settings.rdk.SettingsRDKScreen
import org.robok.engine.ui.screens.template.TemplateScreen
import kotlin.reflect.typeOf

@Composable
fun MainNavHost(
  context: Context
) {
  val navController = LocalMainNavController.current

  NavHost(
    navController = navController,
    startDestination = HomeRoute,
    enterTransition = { NavigationAnimationTransitions.enterTransition },
    exitTransition = { NavigationAnimationTransitions.exitTransition },
    popEnterTransition = { NavigationAnimationTransitions.popEnterTransition },
    popExitTransition = { NavigationAnimationTransitions.popExitTransition }
  ) {
    composable<HomeRoute> {
      HomeScreen(context = context)
    }

    composable<TemplateRoute> {
      TemplateScreen(
        onTemplateClick = { template ->
          navController.navigateSingleTop(CreateProjectRoute(template))
        }
      )
    }

    composable<CreateProjectRoute>(
      typeMap = mapOf(
        typeOf<ProjectTemplate>() to CustomNavType(ProjectTemplate::class.java, ProjectTemplate.serializer())
      )
    ) {
      val route: CreateProjectRoute = it.toRoute()

      CreateProjectScreen(
        template = route.template
      )
    }

    composable<ManageProjectsRoute> {
      ManageProjectsScreen(navController = navController)
    }

    composable<SettingsRoute> {
      SettingsScreen(navController = navController)
    }

    composable<SettingsAppRoute> {
      SettingsAppScreen(navController = navController)
    }

    composable<SettingsCodeEditorRoute> {
      SettingsCodeEditorScreen(navController = navController)
    }

    composable<SettingsRDKRoute> {
      SettingsRDKScreen(navController = navController)
    }

    composable<AboutLibrariesRoute> {
      LibrariesScreen(navController = navController)
    }

    composable<AboutRoute> {
      AboutScreen(
        navController = navController,
        version = BuildConfig.VERSION_NAME
      )
    }
  }
}
package org.robok.engine.navigation.setup

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

import android.app.Activity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.database.viewmodels.DatabaseViewModel
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.routes.MainRoute
import org.robok.engine.routes.SetupInitialRoute
import org.robok.engine.routes.SetupPermissionsRoute
import org.robok.engine.routes.SetupDevelopmentEnvironmentRoute
import org.robok.engine.platform.LocalFirstNavController
import org.robok.engine.ui.screens.setup.SetupInitialScreen
import org.robok.engine.ui.screens.setup.SetupPermissionsScreen
import org.robok.engine.ui.screens.setup.SetupDevelopmentEnvironmentScreen

fun NavGraphBuilder.SetupRoutes(navController: NavHostController) {
  composable<SetupInitialRoute> {
    val context = LocalContext.current
    SetupInitialScreen(
      onBack = {
        (context as? Activity).finish()
      },
      onNext = {
        navController.navigateSingleTop(SetupPermissionRoutes)
      }
    )
  }
  composable<SetupPermissionsRoute> {
    SetupPermissionsScreen(
      onNext = {
        navController.navigateSingleTop(SetupDevelopmentEnvironmentRoute)
      }
    )
  }
  composable<SetupDevelopmentEnvironmentRoute> {
    val firstNavController = LocalFirstNavController.current
    val database = koinViewModel<DatabaseViewModel>()
    SetupDevelopmentEnvironmentScreen(
      onNext = {
        firstNavController.navigateSingleTop(MainRoute)
        database.setIsFirstTime(false)
      }
    )
  }
}
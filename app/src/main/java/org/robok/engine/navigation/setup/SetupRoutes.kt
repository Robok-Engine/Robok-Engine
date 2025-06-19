package org.robok.engine.navigation.setup

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

import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.database.viewmodels.DatabaseViewModel
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.routes.MainRoute
import org.robok.engine.navigation.routes.SetupDevelopmentEnvironmentRoute
import org.robok.engine.navigation.routes.SetupPermissionsRoute
import org.robok.engine.navigation.routes.SetupWelcomeRoute
import org.robok.engine.ui.platform.LocalFirstNavController
import org.robok.engine.ui.screens.setup.SetupDevelopmentEnvironmentScreen
import org.robok.engine.ui.screens.setup.SetupPermissionsScreen
import org.robok.engine.ui.screens.setup.SetupWelcomeScreen

fun NavGraphBuilder.SetupRoutes(navController: NavHostController) {
  composable<SetupWelcomeRoute> {
    val activity = LocalContext.current as? Activity
    SetupWelcomeScreen(
      onBack = { activity?.let { it.finish() } },
      onNext = { navController.navigateSingleTop(SetupPermissionsRoute) },
    )
  }
  composable<SetupPermissionsRoute> {
    SetupPermissionsScreen(
      onBack = { navController.popBackStack() },
      onNext = { navController.navigateSingleTop(SetupDevelopmentEnvironmentRoute) },
    )
  }
  composable<SetupDevelopmentEnvironmentRoute> {
    val firstNavController = LocalFirstNavController.current
    val database = koinViewModel<DatabaseViewModel>()
    SetupDevelopmentEnvironmentScreen(
      onBack = { navController.popBackStack() },
      onNext = {
        firstNavController.navigateSingleTop(MainRoute)
        database.setIsFirstTime(false)
      },
    )
  }
}

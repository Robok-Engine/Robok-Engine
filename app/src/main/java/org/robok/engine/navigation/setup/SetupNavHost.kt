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

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import org.robok.engine.navigation.routes.SetupWelcomeRoute
import org.robok.engine.ui.animations.navigation.NavigationAnimationTransitions.FadeSlide
import org.robok.engine.ui.platform.LocalSetupNavController

@Composable
fun SetupNavHost() {
  val navController = LocalSetupNavController.current

  NavHost(
    navController = navController,
    startDestination = SetupWelcomeRoute,
    enterTransition = { FadeSlide.enterTransition },
    exitTransition = { FadeSlide.exitTransition },
    popEnterTransition = { FadeSlide.popEnterTransition },
    popExitTransition = { FadeSlide.popExitTransition },
  ) {
    SetupRoutes(navController = navController)
  }
}

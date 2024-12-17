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

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.routes.HomeRoute
import org.robok.engine.routes.TerminalRoute
import org.robok.engine.ui.animations.navigation.NavigationAnimationTransitions.FadeSlide
import org.robok.engine.ui.screens.home.HomeScreen
import org.robok.engine.ui.screens.terminal.TerminalScreen

@Composable
fun MainNavHost() {
  val navController = LocalMainNavController.current

  NavHost(
    navController = navController,
    startDestination = HomeRoute,
    enterTransition = { FadeSlide.enterTransition },
    exitTransition = { FadeSlide.exitTransition },
    popEnterTransition = { FadeSlide.popEnterTransition },
    popExitTransition = { FadeSlide.popExitTransition },
  ) {
    composable<HomeRoute> { HomeScreen() }

    composable<TerminalRoute> { TerminalScreen() }

    ProjectRoutes(navController)
    SettingsRoutes(navController)
  }
}

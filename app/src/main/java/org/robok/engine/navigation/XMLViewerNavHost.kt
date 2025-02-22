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
import androidx.navigation.compose.composable
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.routes.XMLViewerCodeRoute
import org.robok.engine.navigation.routes.XMLViewerRoute
import org.robok.engine.ui.platform.LocalXMLViewerNavController
import org.robok.engine.ui.screens.xmlviewer.XMLViewerCodeScreen
import org.robok.engine.ui.screens.xmlviewer.XMLViewerScreen
import org.robok.engine.ui.screens.xmlviewer.viewmodel.XMLViewerViewModel

@Composable
fun XMLViewerNavHost(xml: String) {
  val navController = LocalXMLViewerNavController.current

  BaseNavHost(navController = navController, startDestination = XMLViewerRoute) {
    composable<XMLViewerRoute> {
      val viewModel = koinViewModel<XMLViewerViewModel>()
      XMLViewerScreen(
        viewModel = viewModel,
        onToggleFullScreen = { viewModel.toggleFullScreen() },
        onShowCodeClick = { navController.navigateSingleTop(XMLViewerCodeRoute) },
        xml = xml,
        onOutlineClick = { view, bean -> },
      )
    }
    composable<XMLViewerCodeRoute> { XMLViewerCodeScreen(xml = xml) }
  }
}

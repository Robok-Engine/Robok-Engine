package org.robok.engine.ui.activities

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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.navigation.FirstNavHost
import org.robok.engine.platform.LocalFirstNavController
import org.robok.engine.routes.MainRoute
import org.robok.engine.routes.SetupRoute
import org.robok.engine.ui.base.BaseComposeActivity

class MainActivity : BaseComposeActivity() {

  @Composable
  override fun onScreenCreated() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      ProvideCompositionLocals {
        val navController = LocalFirstNavController.current
        val isFirstTime by database.isFirstTime.collectAsState(initial = false)
        LaunchedEffect(isFirstTime) {
          if (isFirstTime) {
            navController.navigateSingleTop(SetupRoute)
          } else {
            navController.navigateSingleTop(MainRoute)
          }
        }
        FirstNavHost()
      }
    }
  }

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    CompositionLocalProvider(
      LocalFirstNavController provides rememberNavController(),
      content = content,
    )
  }
}

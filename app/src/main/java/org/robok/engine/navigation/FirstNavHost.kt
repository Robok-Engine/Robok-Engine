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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.robok.engine.navigation.routes.MainRoute
import org.robok.engine.navigation.routes.SetupRoute
import org.robok.engine.navigation.setup.SetupNavHost
import org.robok.engine.ui.platform.LocalFirstNavController
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.platform.LocalSetupNavController

@Composable
fun FirstNavHost() {
  val navController = LocalFirstNavController.current

  BaseNavHost(navController = navController, startDestination = MainRoute) {
    composable<MainRoute> {
      CompositionLocalProvider(LocalMainNavController provides rememberNavController()) {
        MainNavHost()
      }
    }
    composable<SetupRoute> {
      CompositionLocalProvider(LocalSetupNavController provides rememberNavController()) {
        SetupNavHost()
      }
    }
  }
}

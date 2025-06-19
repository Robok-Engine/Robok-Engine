package org.robok.engine.ui.activities

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

import android.os.Build
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
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.FirstNavHost
import org.robok.engine.navigation.routes.MainRoute
import org.robok.engine.navigation.routes.SetupRoute
import org.robok.engine.ui.base.BaseComposeActivity
import org.robok.engine.ui.platform.LocalFirstNavController

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

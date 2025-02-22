package org.robok.engine.ui.theme

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
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel

@Composable
fun RobokTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  isActivity: Boolean = true,
  content: @Composable () -> Unit,
) {
  val appPrefsViewModel = koinViewModel<PreferencesViewModel>()

  val dynamicColor by
    appPrefsViewModel.appIsUseMonet.collectAsState(initial = DefaultValues.IS_USE_MONET)

  val highContrastDarkTheme by
    appPrefsViewModel.appIsUseAmoled.collectAsState(initial = DefaultValues.IS_USE_AMOLED)

  val colorScheme =
    when {
      dynamicColor && supportsDynamicTheming() -> {
        val context = LocalContext.current
        when {
          darkTheme && highContrastDarkTheme ->
            dynamicDarkColorScheme(context).copy(background = Color.Black, surface = Color.Black)
          darkTheme -> dynamicDarkColorScheme(context)
          else -> dynamicLightColorScheme(context)
        }
      }

      darkTheme && highContrastDarkTheme ->
        DarkColorScheme.copy(background = Color.Black, surface = Color.Black)
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      if (isActivity) {
        (view.context as Activity).apply {
          WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = !darkTheme
            isAppearanceLightNavigationBars = !darkTheme
          }
        }
      }
    }
  }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

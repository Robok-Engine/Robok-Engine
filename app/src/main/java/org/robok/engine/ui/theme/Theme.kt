package org.robok.engine.ui.theme

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
import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialExpressiveTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextDirection
import androidx.core.view.WindowCompat
import com.google.android.material.color.MaterialColors
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.dynamicColorScheme
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel

fun Color.applyOpacity(enabled: Boolean): Color {
  return if (enabled) this else this.copy(alpha = 0.62f)
}

@Composable
@ReadOnlyComposable
fun Color.harmonizeWith(other: Color) =
  Color(MaterialColors.harmonize(this.toArgb(), other.toArgb()))

@Composable
@ReadOnlyComposable
fun Color.harmonizeWithPrimary(): Color =
  this.harmonizeWith(other = MaterialTheme.colorScheme.primary)

@Composable
fun rememberDynamicScheme(darkTheme: Boolean = isSystemInDarkTheme()): ColorScheme {
  val context = LocalContext.current
  return remember {
    if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
  }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
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
    dynamicColorScheme(!darkTheme).run {
      if (highContrastDarkTheme && darkTheme)
        copy(
          surface = Color.Black,
          background = Color.Black,
          surfaceContainerLowest = Color.Black,
          surfaceContainerLow = surfaceContainerLowest,
          surfaceContainer = surfaceContainerLow,
          surfaceContainerHigh = surfaceContainerLow,
          surfaceContainerHighest = surfaceContainer,
        )
      else this
    }

  val textStyle =
    LocalTextStyle.current.copy(
      lineBreak = LineBreak.Paragraph,
      textDirection = TextDirection.Content,
    )

  val tonalPalettes = LocalTonalPalettes.current

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

  CompositionLocalProvider(LocalTextStyle provides textStyle) {
    MaterialExpressiveTheme(
      colorScheme = colorScheme,
      typography = Typography,
      shapes = provideShapes(),
      content = content,
    )
  }
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

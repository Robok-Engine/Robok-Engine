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
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.PaletteStyle
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import org.robok.engine.core.settings.DefaultValues
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.FirstNavHost
import org.robok.engine.navigation.routes.MainRoute
import org.robok.engine.navigation.routes.SetupRoute
import org.robok.engine.ui.base.BaseComposeActivity
import org.robok.engine.ui.platform.LocalFirstNavController
import org.robok.engine.ui.platform.LocalThemeDynamicColor
import org.robok.engine.ui.platform.LocalThemePaletteStyleIndex
import org.robok.engine.ui.platform.LocalThemeSeedColor
import org.robok.engine.ui.theme.paletteStyles
import org.robok.engine.ui.theme.rememberDynamicScheme

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
    val appIsUseMonet by
      preferences.appIsUseMonet.collectAsState(initial = DefaultValues.IS_USE_MONET)
    val appThemeSeedColor: Int by
      preferences.appThemeSeedColor.collectAsState(initial = DefaultValues.APP_THEME_SEED_COLOR)
    val appThemePaletteStyleIndex by
      preferences.appThemePaletteStyleIndex.collectAsState(
        initial = DefaultValues.APP_THEME_PALETTE_STYLE_INDEX
      )
    val tonalPalettes =
      if (appIsUseMonet && Build.VERSION.SDK_INT >= 31) rememberDynamicScheme().toTonalPalettes()
      else
        Color(appThemeSeedColor)
          .toTonalPalettes(
            paletteStyles.getOrElse(appThemePaletteStyleIndex) { PaletteStyle.TonalSpot }
          )
    CompositionLocalProvider(
      LocalFirstNavController provides rememberNavController(),
      LocalThemeSeedColor provides appThemeSeedColor,
      LocalThemePaletteStyleIndex provides appThemePaletteStyleIndex,
      LocalThemeDynamicColor provides appIsUseMonet,
      LocalTonalPalettes provides tonalPalettes,
      content = content,
    )
  }
}

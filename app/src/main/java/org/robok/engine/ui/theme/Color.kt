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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.kyant.monet.PaletteStyle
import com.kyant.monet.TonalPalettes
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import io.material.hct.Hct

const val STYLE_TONAL_SPOT = 0
const val STYLE_MONOCHROME = 4

val paletteStyles =
  listOf(
    PaletteStyle.TonalSpot,
    PaletteStyle.Spritz,
    PaletteStyle.FruitSalad,
    PaletteStyle.Vibrant,
    PaletteStyle.Monochrome,
  )

@Composable
fun Number.autoDark(isDarkTheme: Boolean = isSystemInDarkTheme()): Double =
  if (!isDarkTheme) this.toDouble()
  else
    when (this.toDouble()) {
      6.0 -> 98.0
      10.0 -> 99.0
      20.0 -> 95.0
      25.0 -> 90.0
      30.0 -> 90.0
      40.0 -> 80.0
      50.0 -> 60.0
      60.0 -> 50.0
      70.0 -> 40.0
      80.0 -> 40.0
      90.0 -> 30.0
      95.0 -> 20.0
      98.0 -> 10.0
      99.0 -> 10.0
      100.0 -> 20.0
      else -> this.toDouble()
    }

/**
 * @return a [Color] generated using [Hct] algorithm, harmonized with `primary` color
 * @receiver Seed number used for generating color
 */
@Composable
@ReadOnlyComposable
fun Int.generateLabelColor(): Color =
  Color(Hct.from(hue = (this % 360).toDouble(), chroma = 36.0, tone = 80.0).toInt())
    .harmonizeWithPrimary()

/**
 * @return a [Color] generated using [Hct] algorithm, harmonized with `primary` color
 * @receiver Seed number used for generating color
 */
@Composable
@ReadOnlyComposable
fun Int.generateOnLabelColor(): Color =
  Color(Hct.from(hue = (this % 360).toDouble(), chroma = 36.0, tone = 20.0).toInt())
    .harmonizeWithPrimary()

val ErrorTonalPalettes = Color.Red.toTonalPalettes()

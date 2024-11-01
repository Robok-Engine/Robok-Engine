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

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.robok.engine.Fonts

val NunitoFontFamily =
  FontFamily(
    Font(Fonts.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(Fonts.nunito_bold, FontWeight.Bold, FontStyle.Normal),
  )

val Typography =
  Typography(
    displayLarge =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 57.sp),
    displayMedium =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 45.sp),
    displaySmall =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 36.sp),
    headlineLarge =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 32.sp),
    headlineMedium =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 28.sp),
    headlineSmall =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 24.sp),
    titleLarge =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 22.sp),
    titleMedium =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp),
    titleSmall =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    bodyLarge =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp),
    bodyMedium =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    bodySmall =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    labelLarge =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp),
    labelMedium =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall =
      TextStyle(fontFamily = NunitoFontFamily, fontWeight = FontWeight.Medium, fontSize = 11.sp),
  )

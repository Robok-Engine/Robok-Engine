package org.gampiot.robok.ui.theme

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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle

import org.gampiot.robok.R

val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_bold, FontWeight.Bold, FontStyle.Normal),
)

val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = NunitoFontFamily,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = NunitoFontFamily,
        fontSize = 16.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
)
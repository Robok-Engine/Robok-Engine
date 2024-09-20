package org.gampiot.robok.ui.theme

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
package org.gampiot.robok.feature.component.compose.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_bold, FontWeight.Bold, FontStyle.Normal),
)

val nunitoTextStyle = TextStyle(
    fontFamily = customFontFamily,
    fontSize = 16.sp 
)

@Composable
fun RobokText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = nunitoTextStyle
) {
    Text(text = text, style = style, modifier = modifier)
}


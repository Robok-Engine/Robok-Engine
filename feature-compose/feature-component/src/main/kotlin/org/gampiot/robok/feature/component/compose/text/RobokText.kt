package org.gampiot.robok.feature.component.compose.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier

import org.gampiot.robok.feature.component.compose.R

val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_bold, FontWeight.Bold, FontStyle.Normal),
)

val nunitoTextStyle = TextStyle(
    fontFamily = NunitoFontFamily
)

@Composable
fun RobokText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = nunitoTextStyle
) {
    Text(text = text, style = style, modifier = modifier)
}


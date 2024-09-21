package org.gampiot.robok.feature.component.compose.cards

// from VegaBobo/DSU-Sideloader

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

import org.gampiot.robok.feature.component.compose.text.RobokText

@Composable
fun CardTitle(modifier: Modifier = Modifier, cardTitle: String) {
    val scroll = rememberScrollState(0)
    RobokText(
        modifier = modifier.horizontalScroll(scroll),
        text = cardTitle,
        fontSize = 20.sp,
        maxLines = 1,
        style = MaterialTheme.typography.headlineMedium,
    )
}

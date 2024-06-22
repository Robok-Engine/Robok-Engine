package dev.trindade.robokide.ui.models.preferences

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.theme.*

@Composable
fun PreferenceItem(
    iconResId: Int,
    title: String,
    summary: String,
    onClick: () -> Unit = {}
) {
    val selectableItemBackground = MaterialTheme.colorScheme.surfaceVariant

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(selectableItemBackground, shape = RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 17.sp),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = summary,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 1.dp)
            )
        }

        Box(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterVertically)
        ) {
            
        }
    }
}
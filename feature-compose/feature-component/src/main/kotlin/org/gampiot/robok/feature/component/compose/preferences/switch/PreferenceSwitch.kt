package org.gampiot.robok.feature.component.compose.preferences.switch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceTemplate
import org.gampiot.robok.feature.component.compose.text.RobokText

/**
 * A Preference that provides a two-state toggleable option.
 */
@Composable
fun PreferenceSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    PreferenceTemplate(
        modifier = modifier.clickable(
            enabled = enabled,
            indication = ripple(),
            interactionSource = interactionSource,
        ) {
            if (onClick != null) {
                onClick()
            } else {
                onCheckedChange(!checked)
            }
        },
        contentModifier = Modifier
            .fillMaxHeight()
            .padding(vertical = 16.dp)
            .padding(start = 16.dp),
        title = { RobokText(text = label) },
        description = { description?.let { RobokText(text = it) } },
        endWidget = {
            if (onClick != null) {
                Spacer(
                    modifier = Modifier
                        .height(32.dp)
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(MaterialTheme.colorScheme.outlineVariant),
                )
            }
            Switch(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .height(24.dp),
                checked = checked,
                onCheckedChange = onCheckedChange,
                enabled = enabled,
                interactionSource = interactionSource,
            )
        },
        enabled = enabled,
        applyPaddings = false,
    )
}
package org.robok.engine.ui.core.components.preferences.switch

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate
import androidx.compose.material3.Switch

/**
 * A Preference that provides a two-state toggleable option.
 *
 * @author Aquiles Trindade (trindadedev).
 */
@Composable
fun PreferenceSwitch(
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit,
  title: String,
  modifier: Modifier = Modifier,
  description: String? = null,
  enabled: Boolean = true,
  onClick: (() -> Unit)? = null,
) {
  val interactionSource = remember { MutableInteractionSource() }

  PreferenceTemplate(
    modifier =
      modifier.clickable(
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
    contentModifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).padding(start = 16.dp),
    title = { Text(fontWeight = FontWeight.Bold, text = title) },
    description = { description?.let { Text(text = it) } },
    endWidget = {
      if (onClick != null) {
        Spacer(
          modifier =
            Modifier.height(32.dp)
              .width(1.dp)
              .fillMaxHeight()
              .background(MaterialTheme.colorScheme.outlineVariant)
        )
      }
      Switch(
        modifier = Modifier.padding(all = 16.dp).height(24.dp),
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

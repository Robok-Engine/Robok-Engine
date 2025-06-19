package org.robok.engine.ui.core.components.preferences.normal

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

/*
 * A Normal preference used in settings
 * @author Aquiles Trindade (trindadedev).
 */

@Composable
fun Preference(
  modifier: Modifier = Modifier,
  icon: @Composable (() -> Unit)? = null,
  title: @Composable () -> Unit,
  description: @Composable (() -> Unit) = {},
  trailing: @Composable (() -> Unit) = {},
  onClick: (() -> Unit)? = null,
) {
  val interactionSource = remember { MutableInteractionSource() }

  PreferenceTemplate(
    modifier =
      modifier.clickable(
        indication = ripple(),
        interactionSource = interactionSource,
        onClick = { onClick?.invoke() },
      ),
    contentModifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).padding(start = 16.dp),
    title = {
      ProvideTextStyle(MaterialTheme.typography.titleLarge.copy(fontSize = 19.sp)) { title() }
    },
    description = {
      ProvideTextStyle(
        MaterialTheme.typography.bodyMedium.copy(
          color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
      ) {
        description()
      }
    },
    endWidget = {
      if (icon != null) {
        Box(modifier = Modifier.padding(8.dp)) { icon() }
      }
      trailing()
    },
    enabled = true,
    applyPaddings = false,
  )
}

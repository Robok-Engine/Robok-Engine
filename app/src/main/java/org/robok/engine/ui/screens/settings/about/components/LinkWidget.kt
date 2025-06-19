package org.robok.engine.ui.screens.settings.about.components

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

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate
import org.robok.engine.ui.screens.settings.about.models.Link

@Composable
fun LinkWidget(model: Link) {
  val uriHandler = LocalUriHandler.current

  PreferenceTemplate(
    modifier = Modifier.clickable { uriHandler.openUri(model.url) },
    title = { Text(fontWeight = FontWeight.Bold, text = model.name) },
    description = { Text(text = model.description) },
    startWidget = {
      Image(
        painter = painterResource(id = model.imageResId),
        contentDescription = null,
        modifier = Modifier.size(32.dp).clip(CircleShape),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )
    },
  )
}

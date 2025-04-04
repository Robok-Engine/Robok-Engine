package org.robok.engine.ui.screens.settings.app.color

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

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.TonalPalettes
import com.kyant.monet.a1
import com.kyant.monet.a2
import com.kyant.monet.a3

// Code based on the Seal application.

data class ColorChooserInfo(
  val isMonetEnable: Boolean = false,
)

@Composable
private fun RowScope.ColorButton(
  chooserInfo: ColorChooserInfo
) {
  
}

@Composable
fun RowScope.ColorButtonImpl(
  modifier: Modifier = Modifier,
  isSelected: Boolean = false,
  cardColor: Color = MaterialTheme.colorScheme.surfaceContainer,
  containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
  checkIconTint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
  tonalPalettes: TonalPalettes,
  onClick: () -> Unit = {},
) {
  val containerSize by animateDpAsState(targetValue = if (isSelected) 28.dp else 0.dp)
  val checkIconSize by animateDpAsState(targetValue = if (isSelected) 16.dp else 0.dp)

  Surface(
    modifier =
      modifier
        .padding(4.dp)
        .sizeIn(maxHeight = 80.dp, maxWidth = 80.dp, minHeight = 64.dp, minWidth = 64.dp)
        .weight(1f, false)
        .aspectRatio(1f),
    shape = RoundedCornerShape(16.dp),
    color = cardColor,
    onClick = onClick,
  ) {
    CompositionLocalProvider(LocalTonalPalettes provides tonalPalettes) {
      val color1 = 80.a1
      val color2 = 90.a2
      val color3 = 60.a3
      Box(modifier = Modifier.fillMaxSize()) {
        Box(
          modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .align(Alignment.Center)
            .drawBehind { drawCircle(color1) }
        ) {
          Surface(
            modifier = Modifier
              .align(Alignment.BottomStart)
              .size(24.dp),
            color = color2,
          ) {}
          Surface(
            modifier = Modifier
              .align(Alignment.BottomEnd)
              .size(24.dp),
            color = color3,
          ) {}
          Box(
            modifier =
              Modifier.align(Alignment.Center).clip(CircleShape).size(containerSize).drawBehind {
                drawCircle(containerColor)
              }
          ) {
            Icon(
              imageVector = Icons.Rounded.Check,
              contentDescription = null,
              modifier = Modifier.size(checkIconSize).align(Alignment.Center),
              tint = checkIconTint,
            )
          }
        }
      }
    }
  }
}

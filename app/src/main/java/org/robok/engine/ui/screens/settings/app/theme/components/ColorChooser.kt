package org.robok.engine.ui.screens.settings.app.theme.components

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
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.PaletteStyle
import com.kyant.monet.TonalPalettes
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import com.kyant.monet.a1
import com.kyant.monet.a2
import com.kyant.monet.a3
import io.material.hct.Hct
import org.robok.engine.ui.platform.LocalThemeDynamicColor
import org.robok.engine.ui.platform.LocalThemePaletteStyleIndex
import org.robok.engine.ui.platform.LocalThemeSeedColor
import org.robok.engine.ui.theme.STYLE_MONOCHROME
import org.robok.engine.ui.theme.STYLE_TONAL_SPOT
import org.robok.engine.ui.theme.paletteStyles

// Based on the Seal application.
// All credit to Seal.

private val ColorList =
  ((4..10) + (1..3)).map { it * 35.0 }.map { Color(Hct.from(it, 40.0, 40.0).toInt()) }

@OptIn(ExperimentalFoundationApi::class)
@Composable
public fun ColorChooser(
  onChangeThemeSeedColor: (Int, Int) -> Unit,
  onChangeDynamicColors: (Boolean) -> Unit,
) {
  Column {
    val pageCount = ColorList.size + 1

    val pagerState =
      rememberPagerState(
        initialPage =
          if (LocalThemePaletteStyleIndex.current == STYLE_MONOCHROME) pageCount
          else
            ColorList.indexOf(Color(LocalThemeSeedColor.current)).run {
              if (this == -1) 0 else this
            }
      ) {
        pageCount
      }
    HorizontalPager(
      modifier = Modifier.fillMaxWidth().clearAndSetSemantics {},
      state = pagerState,
      contentPadding = PaddingValues(horizontal = 12.dp),
    ) { page ->
      if (page < pageCount - 1) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
          ColorButtons(
            color = ColorList[page],
            onChangeThemeSeedColor = onChangeThemeSeedColor,
            onChangeDynamicColors = onChangeDynamicColors,
          )
        }
      } else {
        val isSelected =
          LocalThemePaletteStyleIndex.current == STYLE_MONOCHROME && !LocalThemeDynamicColor.current
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
          ColorButtonImpl(
            isSelected = isSelected,
            tonalPalettes = Color.Black.toTonalPalettes(PaletteStyle.Monochrome),
            onClick = {
              onChangeDynamicColors(false)
              onChangeThemeSeedColor(Color.Black.toArgb(), STYLE_MONOCHROME)
            },
          )
        }
      }
    }
    HorizontalPagerIndicator(
      pagerState = pagerState,
      pageCount = pageCount,
      modifier =
        Modifier.clearAndSetSemantics {}
          .align(Alignment.CenterHorizontally)
          .padding(vertical = 12.dp),
      activeColor = MaterialTheme.colorScheme.primary,
      inactiveColor = MaterialTheme.colorScheme.outlineVariant,
      indicatorHeight = 6.dp,
      indicatorWidth = 6.dp,
    )
  }
}

@Composable
private fun RowScope.ColorButtons(
  color: Color,
  onChangeThemeSeedColor: (Int, Int) -> Unit,
  onChangeDynamicColors: (Boolean) -> Unit,
) {
  paletteStyles.subList(STYLE_TONAL_SPOT, STYLE_MONOCHROME).forEachIndexed { index, style ->
    ColorButton(
      color = color,
      index = index,
      tonalStyle = style,
      onChangeThemeSeedColor = onChangeThemeSeedColor,
      onChangeDynamicColors = onChangeDynamicColors,
    )
  }
}

@Composable
private fun RowScope.ColorButton(
  modifier: Modifier = Modifier,
  color: Color = Color.Green,
  index: Int = 0,
  tonalStyle: PaletteStyle = PaletteStyle.TonalSpot,
  onChangeThemeSeedColor: (Int, Int) -> Unit,
  onChangeDynamicColors: (Boolean) -> Unit,
) {
  val tonalPalettes by remember { mutableStateOf(color.toTonalPalettes(tonalStyle)) }
  val isSelected =
    !LocalThemeDynamicColor.current &&
      LocalThemeSeedColor.current == color.toArgb() &&
      LocalThemePaletteStyleIndex.current == index
  ColorButtonImpl(modifier = modifier, tonalPalettes = tonalPalettes, isSelected = isSelected) {
    onChangeDynamicColors(false)
    onChangeThemeSeedColor(color.toArgb(), index)
  }
}

@Composable
private fun RowScope.ColorButtonImpl(
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
          modifier =
            modifier.size(48.dp).clip(CircleShape).align(Alignment.Center).drawBehind {
              drawCircle(color1)
            }
        ) {
          Surface(modifier = Modifier.align(Alignment.BottomStart).size(24.dp), color = color2) {}
          Surface(modifier = Modifier.align(Alignment.BottomEnd).size(24.dp), color = color3) {}
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

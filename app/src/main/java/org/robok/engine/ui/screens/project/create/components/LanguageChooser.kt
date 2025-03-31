package org.robok.engine.ui.screens.project.create.components

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.robok.engine.templates.Language
import org.robok.engine.ui.icons.RobokIcons
import org.robok.engine.ui.icons.language.Java
import org.robok.engine.ui.icons.language.Kotlin
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel

@Composable
fun LanguageChooser(modifier: Modifier = Modifier, viewModel: CreateProjectViewModel) {
  val uiState = viewModel.uiState
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    LanguageButton(
      language = Language.Java,
      isSelected = uiState.language == Language.Java,
      onClick = { viewModel.setLanguage(Language.Java) },
    )
    LanguageButton(
      language = Language.Kotlin,
      isSelected = uiState.language == Language.Kotlin,
      onClick = { viewModel.setLanguage(Language.Kotlin) },
    )
  }
}

@Composable
private fun RowScope.LanguageButton(
  modifier: Modifier = Modifier,
  isSelected: Boolean = false,
  language: Language = Language.Java,
  onClick: () -> Unit = {},
) {
  LanguageButtonImpl(isSelected = isSelected, language = language, onClick = onClick)
}

@Composable
private fun RowScope.LanguageButtonImpl(
  modifier: Modifier = Modifier,
  isSelected: Boolean = false,
  language: Language = Language.Java,
  cardColor: Color = MaterialTheme.colorScheme.surfaceContainer,
  containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
  checkIconTint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
  languageIconTint: Color = MaterialTheme.colorScheme.primary,
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
    Box(modifier = Modifier.fillMaxSize()) {
      Box(modifier = modifier.size(48.dp).clip(CircleShape).align(Alignment.Center)) {
        Icon(
          imageVector =
            if (language == Language.Kotlin) RobokIcons.Language.Kotlin
            else RobokIcons.Language.Java,
          contentDescription = null,
          modifier = Modifier.size(40.dp).align(Alignment.Center),
          tint = languageIconTint,
        )
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

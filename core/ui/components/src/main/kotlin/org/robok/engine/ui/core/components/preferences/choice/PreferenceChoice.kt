package org.robok.engine.ui.core.components.preferences.choice

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.robok.engine.ui.core.components.dialog.sheet.choice.ChoiceBottomSheet
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

/**
 * A Preference that allows the user to choose an option from a list of options.
 *
 * @author Aquiles Trindade (trindadedev).
 */
@Composable
fun PreferenceChoice(
  title: String,
  description: String = title,
  disabled: Boolean = false,
  pref: Int,
  options: List<Int>,
  excludedOptions: List<Int> = emptyList(),
  titleFactory: (Int) -> String = { it.toString() },
  onPrefChange: (Int) -> Unit,
  modifier: Modifier = Modifier,
  onSheetOpenClose: (Boolean) -> Unit = {},
) {
  val choiceLabel = titleFactory(pref)
  val (opened, setOpened) = remember { mutableStateOf(false) }
  val interactionSource = remember { MutableInteractionSource() }

  PreferenceTemplate(
    modifier =
      modifier.clickable(
        enabled = !disabled,
        indication = ripple(),
        interactionSource = interactionSource,
      ) {
        onSheetOpenClose(true)
        setOpened(true)
      },
    contentModifier = Modifier.fillMaxHeight().padding(vertical = 16.dp).padding(start = 16.dp),
    title = { Text(fontWeight = FontWeight.Bold, text = title) },
    endWidget = {
      if (!disabled) {
        FilledTonalButton(
          modifier = Modifier.padding(horizontal = 16.dp),
          onClick = {
            onSheetOpenClose(true)
            setOpened(true)
          },
          enabled = !disabled,
        ) {
          Text(choiceLabel)
        }
      }
    },
    enabled = !disabled,
    applyPaddings = false,
  )

  if (opened) {
    ChoiceBottomSheet(
      visible = opened,
      title = { Text(fontWeight = FontWeight.Bold, text = title) },
      default = pref,
      options = options,
      titleFactory = titleFactory,
      excludedOptions = excludedOptions,
      onRequestClose = {
        onSheetOpenClose(false)
        setOpened(false)
      },
      onChoice = {
        onSheetOpenClose(false)
        setOpened(false)
        onPrefChange(it)
      },
    )
  }
}

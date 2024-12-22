package org.robok.engine.ui.screens.setup.components

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
 *   along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings

@Composable
fun BottomButtons(
  modifier: Modifier = Modifier,
  isWelcome: Boolean = false,
  onBack: () -> Unit,
  onNext: () -> Unit,
) {
  Row(modifier = modifier) {
    TextButton(onClick = onBack) {
      Text(
        text =
          stringResource(id = if (isWelcome) Strings.common_word_exit else Strings.common_word_back)
      )
    }
    Spacer(modifier = Modifier.weight(1f))
    Button(onClick = onNext) { Text(text = stringResource(id = Strings.common_word_next)) }
  }
}

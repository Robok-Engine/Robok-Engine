package org.robok.engine.ui.core.components.dialog.sheet

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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
 * Used for generic content for bottom sheet.
 * @author Aquiles Trindade (trindadedev)
 */

@Composable
fun BottomSheetContent(
  buttons: @Composable RowScope.() -> Unit,
  modifier: Modifier = Modifier,
  title: (@Composable () -> Unit)? = null,
  text: @Composable (() -> Unit)? = null,
  content: @Composable (() -> Unit)? = null,
) {
  val contentPadding = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)

  Column(modifier = modifier.fillMaxWidth().safeDrawingPadding()) {
    title?.let {
      Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        val textStyle = MaterialTheme.typography.titleLarge
        ProvideTextStyle(textStyle, title)
      }
    }
    text?.let {
      Box(modifier = contentPadding) {
        val textStyle = MaterialTheme.typography.bodyMedium
        ProvideTextStyle(textStyle, text)
      }
    }
    content?.let {
      Box(modifier = Modifier.padding(top = if (title != null || text != null) 16.dp else 0.dp)) {
        content()
      }
    }
    Row(
      horizontalArrangement = Arrangement.End,
      modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
      buttons()
    }
  }
}

package org.robok.engine.ui.activities.editor.drawer

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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import org.robok.engine.strings.Strings

@Composable
fun ProjectInfoDrawer() {
  var selectedTabIndex by remember { mutableStateOf(0) }
  val tabTitles =
    listOf(
      stringResource(id = Strings.common_word_logs),
      stringResource(id = Strings.text_diagnostic),
    )

  Column {
    TabRow(selectedTabIndex = selectedTabIndex) {
      tabTitles.forEachIndexed { index, title ->
        Tab(
          selected = selectedTabIndex == index,
          onClick = { selectedTabIndex = index },
          text = { Text(title) },
        )
      }
    }
    when (selectedTabIndex) {
      0 -> DrawerContent(text = stringResource(id = Strings.common_word_logs))
      1 -> DrawerContent(text = stringResource(id = Strings.text_diagnostic))
    }
  }
}

@Composable
private fun DrawerContent(text: String) {
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(text = text, fontSize = 24.sp, color = MaterialTheme.colorScheme.onSurface)
  }
}

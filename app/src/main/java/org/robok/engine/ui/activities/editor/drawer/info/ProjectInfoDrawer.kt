package org.robok.engine.ui.activities.editor.drawer.info

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
fun ProjectInfoDrawer(viewModel: ProjectInfoDrawerViewModel) {
  val tabTitles =
    listOf(
      stringResource(id = Strings.common_word_logs),
      stringResource(id = Strings.text_diagnostic),
    )

  Column {
    TabRow(selectedTabIndex = viewModel.currentTabIndex) {
      tabTitles.forEachIndexed { index, title ->
        Tab(
          selected = viewModel.currentTabIndex == index,
          onClick = { viewModel.setCurrentTabIndex(index) },
          text = { Text(title) },
        )
      }
    }
    when (viewModel.currentTabIndex) {
      ProjectInfoDrawerIndexs.LOGS -> LogsDrawer()
      ProjectInfoDrawerIndexs.DIAGNOSTIC -> DiagnosticDrawer()
    }
  }
}

@Composable
private fun LogsDrawer() {
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(
      text = stringResource(id = Strings.common_word_logs),
      fontSize = 24.sp,
      color = MaterialTheme.colorScheme.onSurface,
    )
  }
}

@Composable
private fun DiagnosticDrawer() {
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    Text(
      text = stringResource(id = Strings.text_diagnostic),
      fontSize = 24.sp,
      color = MaterialTheme.colorScheme.onSurface,
    )
  }
}

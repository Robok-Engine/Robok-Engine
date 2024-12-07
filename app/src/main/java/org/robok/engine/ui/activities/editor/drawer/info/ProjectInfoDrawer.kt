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

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.editor.drawer.info.diagnostic.DiagnosticContent
import org.robok.engine.ui.activities.editor.drawer.info.diagnostic.viewmodel.DiagnosticViewModel
import org.robok.engine.ui.activities.editor.drawer.info.logs.LogsContent
import org.robok.engine.ui.activities.editor.drawer.info.viewmodel.ProjectInfoDrawerViewModel

@Composable
fun ProjectInfoDrawer(
  projectInfoViewModel: ProjectInfoDrawerViewModel,
  diagnosticViewModel: DiagnosticViewModel,
) {
  val tabTitles =
    listOf(
      stringResource(id = Strings.common_word_logs),
      stringResource(id = Strings.text_diagnostic),
    )

  Column {
    TabRow(selectedTabIndex = projectInfoViewModel.currentTabIndex) {
      tabTitles.forEachIndexed { index, title ->
        Tab(
          selected = projectInfoViewModel.currentTabIndex == index,
          onClick = { projectInfoViewModel.setCurrentTabIndex(index) },
          text = { Text(title) },
        )
      }
    }
    when (projectInfoViewModel.currentTabIndex) {
      ProjectInfoDrawerIndexs.LOGS -> LogsContent()
      ProjectInfoDrawerIndexs.DIAGNOSTIC -> DiagnosticContent(viewModel = diagnosticViewModel)
    }
  }
}

package org.robok.engine.ui.activities.editor.drawer.info.diagnostic

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.robok.engine.ui.activities.editor.drawer.info.diagnostic.viewmodel.DiagnosticViewModel

@Composable
fun DiagnosticContent(viewModel: DiagnosticViewModel) {
  Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
    viewModel.diagnostics.forEach { diagnostic ->
      Text(text = diagnostic.message, fontSize = 18.sp, color = MaterialTheme.colorScheme.onSurface)
    }
  }
}

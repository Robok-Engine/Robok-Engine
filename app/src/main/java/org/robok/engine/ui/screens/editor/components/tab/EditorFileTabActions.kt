package org.robok.engine.ui.screens.editor.components.tab

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
 

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.robok.engine.Strings
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorFileTabActions(
  editorViewModel: EditorViewModel,
  index: Int,
  onClick: () -> Unit = {}
) {
  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.close)) },
    onClick = {
      editorViewModel.closeFile(index)
      onClick()
    }
  )

  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.close_others)) },
    onClick = {
      editorViewModel.closeOthers(index)
      onClick()
    }
  )

  DropdownMenuItem(
    text = { Text(stringResource(id = Strings.close_all)) },
    onClick = {
      editorViewModel.closeAll()
      onClick()
    }
  )
}



package org.robok.engine.ui.screens.editor.components.drawer.filetree

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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import java.io.File
import org.robok.engine.Strings
import org.robok.engine.ui.theme.Typography

@Composable
fun FileTreeDrawer(
  path: File,
  onNodeClick: (FileNode) -> Unit
) {
  Column {
    Text(
      text = stringResource(id = Strings.common_word_files),
      style = Typography.titleMedium,
      fontSize = 24.sp,
      color = MaterialTheme.colorScheme.onSurface,
      modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
    )
    FileTree(
      path = path,
      onNodeClick = onNodeClick,
    )
  }
}

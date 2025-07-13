package org.robok.engine.ui.screens.editor.components.drawer.filetree

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

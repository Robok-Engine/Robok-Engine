package org.robok.engine.ui.screens.xmlviewer

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

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import io.github.rosemoe.sora.text.Content
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.xmlviewer.components.rememberCodeEditorState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XMLViewerCodeScreen(xml: String) {
  Scaffold(
    topBar = { TopAppBar(title = { Text(text = stringResource(Strings.text_see_code)) }) },
    content = { padding ->
      val editorState = rememberCodeEditorState(initialContent = Content(xml))
      CodeEditor(modifier = Modifier.padding(innerPadding).fillMaxSize(), state = editorState)
    },
  )
}

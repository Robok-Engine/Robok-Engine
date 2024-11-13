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

import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import java.util.Stack
import org.robok.engine.core.components.animation.ExpandAndShrink
import org.robok.engine.core.components.shape.ButtonShape
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.xmlviewer.viewmodel.XMLViewerViewModel
import org.robok.engine.ui.screens.xmlviewer.components.CodeViewer
import org.robok.engine.ui.screens.xmlviewer.components.rememberCodeEditorState
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import io.github.rosemoe.sora.text.Content

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XMLViewerCodeScreen(
  xml: String,
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { 
          Text(text = stringResource(Strings.text_see_code)) 
        }
      )
    },
    content = { padding ->
      val editorState = rememberCodeEditorState(
        initialContent = Content(xml)
      )
      CodeEditor(
        modifier = Modifier
          .padding(innerPadding)
          .fillMaxSize(),
        state = editorState,
      )
    }
  )
}
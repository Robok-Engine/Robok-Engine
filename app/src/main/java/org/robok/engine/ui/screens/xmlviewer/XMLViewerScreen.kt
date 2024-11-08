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
import java.util.Stack
import org.robok.engine.core.components.animation.ExpandAndShrink
import org.robok.engine.core.components.shape.ButtonShape
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.xmlviewer.viewmodel.XMLViewerViewModel
import org.robok.engine.ui.screens.xmlviewer.components.OutlineView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XMLViewerScreen(
  viewModel: XMLViewerViewModel,
  onToggleFullScreen: () -> Unit,
  onToggleShowCode: () -> Unit,
  onOutlineClick: (View, ViewBean) -> Unit,
  nodes: List<TreeNode<ViewBean>>,
  treeNodeStack: Stack<TreeNode<ViewBean>>,
  xml: String,
) {
  var isFullScreen by remember { viewModel.isFullScreen }
  var isShowCodeDialog by remember { viewModel.isShowCodeDialog }

  Scaffold(
    topBar = {
      ExpandAndShrink(!isFullScreen) {
        TopAppBar(
          title = { Text(text = stringResource(Strings.title_gui_viewer)) },
          actions = {
            IconButton(onClick = { onToggleShowCode() }) {
              Icon(Icons.Default.Code, contentDescription = "See Code")
            }
          },
        )
      }
    },
    content = { padding ->
      Box(modifier = Modifier.padding(padding)) {
        OutlineView(
          modifier = Modifier.fillMaxSize().padding(8.dp),
          onOutlineClick = onOutlineClick,
          nodes = nodes,
          treeNodeStack = treeNodeStack,
          xml = xml,
        )
        FloatingActionButton(
          onClick = onToggleFullScreen,
          modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
        ) {
          Icon(Icons.Default.Fullscreen, contentDescription = "Full Screen")
        }
      }
    },
  )
  if (isShowCodeDialog) {
    AlertDialog(
      onDismissRequest = onToggleShowCode,
      title = { Text(text = stringResource(Strings.text_see_code)) },
      text = { Text(text = xml) },
      confirmButton = {
        Button(onClick = onToggleShowCode, shape = ButtonShape()) {
          Text(stringResource(id = Strings.common_word_ok))
        }
      },
    )
  }
}

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import java.util.Stack
import org.robok.engine.core.components.animation.ExpandAndShrink
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.xmlviewer.viewmodel.XMLViewerViewModel
import org.robok.engine.ui.screens.xmlviewer.components.OutlineView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XMLViewerScreen(
  viewModel: XMLViewerViewModel,
  onToggleFullScreen: () -> Unit,
  onOutlineClick: (View, ViewBean) -> Unit,
  onShowCodeClick: () -> Unit,
  xml: String,
) {
  val nodes = mutableListOf<TreeNode<ViewBean>>()
  val treeNodeStack = Stack<TreeNode<ViewBean>>()

  var isFullScreen by remember { viewModel.isFullScreen }

  val context = LocalContext.current
  ProxyResources.init(context)

  clearResources()

  Scaffold(
    topBar = {
      ExpandAndShrink(!isFullScreen) {
        TopAppBar(
          title = { Text(text = stringResource(Strings.title_gui_viewer)) },
          actions = {
            IconButton(onClick = onShowCodeClick) {
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
}

private fun clearResources() {
  try {
    ProxyResources.getInstance().viewIdMap.takeIf { it.isNotEmpty() }?.clear()
    MessageArray.getInstanse().clear()
  } catch (_: Exception) {}
}

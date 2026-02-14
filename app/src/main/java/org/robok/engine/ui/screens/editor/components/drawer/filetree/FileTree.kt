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

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.InsertDriveFile
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import java.io.File
import org.robok.engine.ui.core.components.animation.ExpandAndShrink

data class FileNode(
  val name: String,
  val isDirectory: Boolean,
  val abs: File,
  val children: List<FileNode> = emptyList(),
  val isExpanded: MutableState<Boolean> = mutableStateOf(false)
)

fun buildFileTree(file: File): FileNode {
  return if (file.isDirectory) {
    val children = file.listFiles()?.sortedBy {
      it.name
    }?.map {
      buildFileTree(it)
    } ?: emptyList()
    FileNode(
      name = file.name,
      isDirectory = true,
      abs = file,
      children = children)
  } else {
    FileNode(
      name = file.name,
      isDirectory = false,
      abs = file
    )
  }
}

@Composable
fun FileTree(
  path: File,
  onNodeClick: (FileNode) -> Unit = {}
) {
  val rootNode = remember(path) { buildFileTree(path) }

  FileTree(
    nodes = listOf(rootNode),
    onNodeClick = onNodeClick
  )
}

@Composable
fun FileTree(
  nodes: List<FileNode>,
  level: Int = 0,
  onNodeClick: (FileNode) -> Unit = {}
) {
  Column {
    nodes.forEach { node ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            if (node.isDirectory) {
              node.isExpanded.value = !node.isExpanded.value
            }
            onNodeClick(node)
          }
          .padding(
             start = (level * 16).dp,
             top = 4.dp,
             bottom = 4.dp
          ),
          verticalAlignment = Alignment.CenterVertically
      ) {
        if (node.isDirectory) {
          val rotation by animateFloatAsState(
            targetValue = if (node.isExpanded.value) 0f else -180f,
            animationSpec = tween(500)
          )
          Icon(
            imageVector = if (node.isExpanded.value) Icons.Filled.ExpandMore else Icons.Filled.ChevronRight,
            contentDescription = null,
            modifier = Modifier.rotate(rotation)
          )
        } else {
          Spacer(modifier = Modifier.width(24.dp))
        }
        Icon(
          imageVector = if (node.isDirectory) Icons.Filled.Folder else Icons.Filled.InsertDriveFile,
          contentDescription = null
        )
        Text(text = node.name)
      }
      ExpandAndShrink(node.isDirectory && node.isExpanded.value) {
        FileTree(
          nodes = node.children,
          level = level + 1,
          onNodeClick = onNodeClick
        )
      }
    }
  }
}
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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
      isDirectory = true,
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
          Icon(
            imageVector = if (node.isExpanded.value) Icons.Filled.ExpandMore else Icons.Filled.ChevronRight,
            contentDescription = null
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
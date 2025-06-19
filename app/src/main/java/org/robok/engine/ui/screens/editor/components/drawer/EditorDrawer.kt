package org.robok.engine.ui.screens.editor.components.drawer

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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.robok.engine.ui.screens.editor.LocalEditorFilesDrawerState
import org.robok.engine.ui.screens.editor.navigation.EditorDrawerNavHost
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorDrawer(editorViewModel: EditorViewModel, content: @Composable () -> Unit) {
  val drawerState = LocalEditorFilesDrawerState.current
  ModalNavigationDrawer(
    drawerState = drawerState,
    modifier = Modifier.fillMaxSize().imePadding(),
    gesturesEnabled = drawerState.isOpen,
    drawerContent = {
      ModalDrawerSheet(
        drawerState = drawerState,
        modifier = Modifier.fillMaxWidth(fraction = 0.85f),
        drawerContainerColor = MaterialTheme.colorScheme.background,
        drawerContentColor = contentColorFor(MaterialTheme.colorScheme.background),
      ) {
        EditorDrawerNavHost(editorViewModel = editorViewModel)
      }
    },
  ) {
    content()
  }
}

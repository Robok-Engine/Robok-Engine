package org.robok.engine.ui.screens.editor.navigation

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

import androidx.compose.runtime.Composable
import org.robok.engine.navigation.BaseNavHost
import org.robok.engine.navigation.routes.EditorDrawerFilesRoute
import org.robok.engine.ui.screens.editor.LocalEditorDrawerNavController
import org.robok.engine.ui.screens.editor.viewmodel.EditorViewModel

@Composable
fun EditorDrawerNavHost(editorViewModel: EditorViewModel) {
  val navController = LocalEditorDrawerNavController.current

  BaseNavHost(navController = navController, startDestination = EditorDrawerFilesRoute) {
    EditorDrawerRoutes(navController = navController, editorViewModel = editorViewModel)
  }
}

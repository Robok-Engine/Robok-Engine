package org.robok.engine.ui.screens.project.manage.viewmodel

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

import androidx.lifecycle.ViewModel
import java.io.File
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ManageProjectsViewModel : ViewModel() {

  private val _projects = MutableStateFlow<Array<File>>(emptyArray())

  val projects: StateFlow<Array<File>> = _projects

  /*
   * Update projects list
   */
  fun updateProjects(projects: Array<File>) {
    _projects.update { projects.filter { isProject(it) }.toTypedArray() }
  }

  /*
   * Check if is project or not.
   */
  fun isProject(file: File): Boolean = file.isDirectory and (file.listFiles().isNullOrEmpty().not())
}

package org.robok.engine.ui.screens.project.manage.viewmodel

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
    fun isProject(file: File): Boolean =
        file.isDirectory and (file.listFiles().isNullOrEmpty().not())
}

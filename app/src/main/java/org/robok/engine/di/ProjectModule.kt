package org.robok.engine.di

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

import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.screens.project.create.viewmodel.CreateProjectViewModel
import org.robok.engine.ui.screens.project.manage.viewmodel.ManageProjectsViewModel
import org.robok.engine.ui.screens.project.settings.viewmodel.ProjectSettingsViewModel

val ProjectModule = module {
  viewModel { (projectManager: ProjectManager) -> CreateProjectViewModel(projectManager) }
  viewModelOf(::ManageProjectsViewModel)
  viewModelOf(::ProjectSettingsViewModel)
}

package org.robok.engine.ui.activities.project.settings.build

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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import java.io.File
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.manage.project.ProjectManager
import org.robok.engine.ui.activities.base.RobokComposeActivity
import org.robok.engine.ui.screens.project.settings.build.ProjectBuildConfigScreen
import org.robok.engine.ui.theme.RobokTheme

class ProjectBuildSettingsActivity : RobokComposeActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val extras = intent.extras
    val projectManager = ProjectManager(this)
    if (extras != null) {
      val projectPath = extras.getString(ExtraKeys.Project.PATH)
      projectPath?.let { projectManager.projectPath = File(it) }
    }
    setContent {
      RobokTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ProjectBuildConfigScreen(projectManager = projectManager)
        }
      }
    }
  }
}

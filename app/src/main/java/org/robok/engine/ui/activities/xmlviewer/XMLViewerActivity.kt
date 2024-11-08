package org.robok.engine.ui.activities.xmlviewer

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

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import org.robok.easyui.config.Config
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.ui.activities.xmlviewer.viewmodel.XMLViewerViewModel
import org.robok.engine.ui.theme.RobokTheme

class XMLViewerActivity : AppCompatActivity() {
  private val viewModel: XMLViewerViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val config = intent.getSerializableExtra(ExtraKeys.Gui.CONFIG) as? Config
    config?.let {
      when (it.orientation) {
        "landscape",
        "horizontal" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        "portrait",
        "vertical" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
      }
    }

    setContent {
      RobokTheme {
        XMLViewerScreen(
          viewModel = viewModel,
          onToggleFullScreen = { viewModel.toggleFullScreen() },
          onOutlineClick = { view ->
            // do nothing for now
          },
        )
      }
    }
  }
}

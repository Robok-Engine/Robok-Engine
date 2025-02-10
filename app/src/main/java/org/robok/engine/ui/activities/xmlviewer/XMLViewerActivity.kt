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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.amix.config.Config
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.navigation.XMLViewerNavHost
import org.robok.engine.ui.base.BaseComposeActivity
import org.robok.engine.ui.platform.LocalXMLViewerNavController

class XMLViewerActivity : BaseComposeActivity() {

  @Composable
  override fun onScreenCreated() {
    val xml = intent.getStringExtra(ExtraKeys.Gui.CODE)
    val config = intent.getSerializableExtra(ExtraKeys.Gui.CONFIG) as? Config

    config?.let {
      when (it.orientation) {
        "landscape",
        "horizontal" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        "portrait",
        "vertical" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
      }
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
      ProvideCompositionLocals { XMLViewerNavHost(xml!!) }
    }
  }

  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalXMLViewerNavController provides navController, content = content)
  }
}

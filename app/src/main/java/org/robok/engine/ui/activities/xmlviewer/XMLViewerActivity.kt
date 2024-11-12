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
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import java.util.Stack
import org.koin.androidx.compose.koinViewModel
import org.robok.easyui.config.Config
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.ui.activities.base.RobokComposeActivity
import org.robok.engine.ui.activities.xmlviewer.viewmodel.XMLViewerViewModel
import org.robok.engine.ui.screens.xmlviewer.XMLViewerScreen
import org.robok.engine.ui.theme.RobokTheme
import org.robok.engine.platform.LocalXMLViewerNavController
import org.robok.engine.navigation.XMLViewerNavHost

class XMLViewerActivity : RobokComposeActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
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
    
    setContent {
      RobokTheme {
        ProvideCompositionLocals {
          XMLViewerNavHost(xml!!)
        }
      }
    }
  }
  
  @Composable
  private fun ProvideCompositionLocals(content: @Composable () -> Unit) {
    val navController = rememberNavController()

    CompositionLocalProvider(
      LocalXMLViewerNavController provides navController,
      content = content
    )
  }
}

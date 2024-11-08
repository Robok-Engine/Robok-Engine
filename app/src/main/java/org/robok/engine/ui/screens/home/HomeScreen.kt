package org.robok.engine.ui.screens.home

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

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import java.io.File
import org.robok.engine.Drawables
import org.robok.engine.core.utils.PathUtils
import org.robok.engine.core.utils.getDefaultPath
import org.robok.engine.extensions.navigation.navigateSingleTop
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.routes.ManageProjectsRoute
import org.robok.engine.routes.SettingsRoute
import org.robok.engine.routes.TemplatesRoute
import org.robok.engine.routes.TerminalRoute
import org.robok.engine.strings.Strings
import org.robok.engine.ui.activities.editor.EditorActivity
import org.robok.engine.ui.theme.Typography
import org.robok.engine.BuildConfig

@Composable
fun HomeScreen() {
  val navController = LocalMainNavController.current
  val context = LocalContext.current

  Column(
    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(8.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Image(
        painter = painterResource(id = Drawables.ic_robok),
        contentDescription = null,
        modifier = Modifier.size(70.dp).padding(8.dp),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )
      Text(
        text = BuildConfig.APPLICATION_NAME,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(8.dp),
      )
    }

    LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      contentPadding = PaddingValues(8.dp),
      modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
    ) {
      items(4) { index ->
        HomeCardItem(
          icon =
            when (index) {
              0 -> Icons.Rounded.Add
              1 -> Icons.Rounded.FolderOpen
              2 -> Icons.Rounded.Settings
              else -> Icons.Rounded.Info
            },
          title =
            when (index) {
              0 -> stringResource(id = Strings.title_create_project)
              1 -> stringResource(id = Strings.title_open_project)
              2 -> stringResource(id = Strings.common_word_settings)
              else -> stringResource(id = Strings.title_terminal)
            },
          onClick = {
            when (index) {
              0 -> {
                navController.navigateSingleTop(route = TemplatesRoute)
              }

              1 -> {
                navController.navigateSingleTop(route = ManageProjectsRoute)
              }

              2 -> {
                navController.navigateSingleTop(route = SettingsRoute)
              }

              else -> {
                navController.navigateSingleTop(route = TerminalRoute)
              }
            }
          },
        )
      }
    }
  }
}

@Composable
fun HomeCardItem(icon: ImageVector, title: String, onClick: () -> Unit) {
  Card(
    modifier =Modifier
      .padding(8.dp)
      .height(100.dp),
    shape = MaterialTheme.shapes.medium,
    elevation = CardDefaults.cardElevation(0.dp),
    onClick = onClick
  ) {
    Column(
      modifier = Modifier.padding(11.dp).fillMaxSize(),
      horizontalAlignment = Alignment.Start,
      verticalArrangement = Arrangement.Top,
    ) {
      Image(
        imageVector = icon,
        contentDescription = title,
        modifier = Modifier.size(25.dp),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
      )
      Text(text = title, modifier = Modifier.padding(top = 8.dp), style = Typography.bodyMedium)
    }
  }
}

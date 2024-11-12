package org.robok.engine.ui.screens.project.template.components

/*
 * This file is part of Robok © 2024.
 *
 * Robok is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robok is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.nestedscroll.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import org.robok.engine.Drawables
import org.robok.engine.models.project.ProjectTemplate

@Composable
fun ProjectTemplateCard(template: ProjectTemplate, onTemplateClick: (ProjectTemplate) -> Unit) {
  Card(
    modifier = Modifier.heightIn(max = 250.dp).widthIn(max = 215.dp),
    colors =
      CardDefaults.cardColors()
        .copy(containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)),
    shape = MaterialTheme.shapes.medium,
    onClick = { onTemplateClick(template) },
  ) {
    Box(modifier = Modifier.fillMaxHeight().weight(1f), contentAlignment = Alignment.Center) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(Color.Black)
      )

      Image(painter = painterResource(id = Drawables.ic_robok), contentDescription = null)
    }

    ListItem(
      overlineContent = {
        Text(
          text = if (template.javaSupport) "Java" else if (template.kotlinSupport) "Kotlin" else "",
          fontWeight = FontWeight.Bold,
        )
      },
      headlineContent = { Text(template.name) },
      supportingContent = { Text(template.packageName) },
      colors = ListItemDefaults.colors(containerColor = Color.Transparent),
    )
  }
}

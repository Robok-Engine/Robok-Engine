package org.robok.engine.ui.screens.settings.libraries

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.entity.Library
import org.robok.engine.core.components.preferences.base.PreferenceTemplate

@Composable
fun LibraryItem(library: Library, onClick: () -> Unit) {
  PreferenceTemplate(
    modifier = Modifier.clickable(onClick = onClick).padding(8.dp),
    title = { LibraryItemTitle(library.name) },
  )
}

@Composable
fun LibraryItemTitle(title: String?) {
  title?.let { Text(text = it, color = MaterialTheme.colorScheme.onSurface) }
    ?: Text(text = "No Title Available", color = MaterialTheme.colorScheme.onSurface)
}

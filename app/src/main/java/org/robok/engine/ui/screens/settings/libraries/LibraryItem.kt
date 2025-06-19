package org.robok.engine.ui.screens.settings.libraries

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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.entity.Library
import org.robok.engine.ui.core.components.preferences.base.PreferenceTemplate

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

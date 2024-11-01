package org.robok.engine.ui.screens.settings.libraries

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

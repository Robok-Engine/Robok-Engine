package org.robok.engine.ui.screens.settings.libraries

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

import com.mikepenz.aboutlibraries.entity.Library

@Composable
fun LibraryItem(
    library: Library,
    onClick: () -> Unit
) {
    PreferenceTemplate(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp),
        title = {
            LibraryItemTitle(library.name)
        },
    )
}

@Composable
fun LibraryItemTitle(
    title: String?
) {
    title?.let {
        Text(
            text = it,
            color = MaterialTheme.colorScheme.onSurface
        ) 
    } ?: Text(
           text = "No Title Available",
           color = MaterialTheme.colorScheme.onSurface
         )
}

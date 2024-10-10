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

package org.robok.engine.ui.screens.project.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.robok.engine.Drawables
import org.robok.engine.defaults.DefaultTemplate
import org.robok.engine.models.project.ProjectTemplate
import org.robok.engine.platform.LocalMainNavController
import org.robok.engine.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectTemplatesScreen(onTemplateClick: (ProjectTemplate) -> Unit) {
    val navController = LocalMainNavController.current

    val templates = remember { mutableStateListOf<ProjectTemplate>() }

    LaunchedEffect(Unit) { templates.add(DefaultTemplate()) }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = { Text(stringResource(Strings.common_word_templates)) },
                navigationIcon = {
                    IconButton(onClick = navController::navigateUp) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(templates) {
                    Card(
                        modifier = Modifier.heightIn(max = 250.dp),
                        colors =
                            CardDefaults.cardColors()
                                .copy(
                                    containerColor =
                                        MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
                                ),
                        shape = MaterialTheme.shapes.medium,
                        onClick = { onTemplateClick(it) },
                    ) {
                        Box(
                            modifier = Modifier.fillMaxHeight().weight(1f),
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(id = Drawables.splash_bg),
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                            )

                            Image(
                                painter = painterResource(id = Drawables.ic_robok),
                                contentDescription = null,
                            )
                        }

                        ListItem(
                            overlineContent = {
                                Text(
                                    text =
                                        if (it.javaSupport) "Java"
                                        else if (it.kotlinSupport) "Kotlin" else "",
                                    fontWeight = FontWeight.Bold,
                                )
                            },
                            headlineContent = { Text(it.name) },
                            supportingContent = { Text(it.packageName) },
                            colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                        )
                    }
                }
            }
        }
    }
}

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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.FolderOpen
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.robok.engine.Drawables
import org.robok.engine.Strings
import org.robok.engine.ext.navigateSingleTop
import org.robok.engine.navigation.routes.ManageProjectsRoute
import org.robok.engine.navigation.routes.SettingsRoute
import org.robok.engine.navigation.routes.TemplatesRoute
import org.robok.engine.navigation.routes.TerminalRoute
import org.robok.engine.ui.platform.LocalMainNavController
import org.robok.engine.ui.theme.Typography

@Composable
fun HomeScreen() {
    val navController = LocalMainNavController.current
    val context = LocalContext.current
  
    val homeCardItems = listOf(
        HomeCardItemData(
            icon = Icons.Rounded.Add,
            title = stringResource(id = Strings.title_create_project),
            onClick = {
                navController.navigateSingleTop(route = TemplatesRoute)
            }
        ),
        HomeCardItemData(
            icon = Icons.Rounded.FolderOpen,
            title = stringResource(id = Strings.title_open_project),
            onClick = {
                navController.navigateSingleTop(route = ManageProjectsRoute)
            }
        ),
        HomeCardItemData(
            icon = Icons.Rounded.Settings,
            title = stringResource(id = Strings.common_word_settings),
            onClick = {
                navController.navigateSingleTop(route = SettingsRoute)
            }
        ),
        HomeCardItemData(
            icon = Icons.Rounded.Info,
            title = stringResource(id = Strings.title_terminal),
            onClick = {
                navController.navigateSingleTop(route = TerminalRoute)
            }
        )
    )

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
                text = stringResource(Strings.app_name),
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
            items(homeCardItems) { item ->
                HomeCardItem(item = item)
            }
        }
    }
}

@Composable
fun HomeCardItem(item: HomeCardItemData) {
    Card(
        modifier = Modifier.padding(8.dp).height(100.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(0.dp),
        onClick = item.onClick,
    ) {
        Column(
            modifier = Modifier.padding(11.dp).fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Image(
                imageVector = item.icon,
                contentDescription = item.title,
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            )
            Text(text = item.title, modifier = Modifier.padding(top = 8.dp), style = Typography.bodyMedium)
        }
    }
}

@Immutable
data class HomeCardItemData(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)

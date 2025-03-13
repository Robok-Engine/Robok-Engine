package org.robok.engine.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
                HomeCardItem(
                    item = item
                )
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
                imageVector = homeCardItemData.icon,
                contentDescription = homeCardItemData.title,
                modifier = Modifier.size(25.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
            )
            Text(text = homeCardItemData.title, modifier = Modifier.padding(top = 8.dp), style = Typography.bodyMedium)
        }
    }
}

@Immutable
data class HomeCardItemData(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)

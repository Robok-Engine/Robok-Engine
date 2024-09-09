package org.gampiot.robok.feature.settings.compose.screens.ui.libraries

import android.os.Bundle
import android.content.Context

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Settings
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.input.nestedscroll.nestedScroll

import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext
import com.mikepenz.aboutlibraries.ui.compose.LibrariesContainer
import com.mikepenz.aboutlibraries.ui.compose.LibraryDefaults
import com.mikepenz.aboutlibraries.entity.Library

import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.feature.component.compose.preferences.base.PreferenceLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibrariesScreen(
    navController: NavController
) {
    val context = LocalContext.current    
    PreferenceLayout(
        label = stringResource(id = Strings.settings_libraries_title),
        backArrowVisible = true
    ) {
       PreferenceGroup {
           librariesScreen(context)
       }
    }
}

@Composable
fun librariesScreen(context: Context) {
    val uriHandler = LocalUriHandler.current
    val libs = remember { mutableStateOf<Libs?>(null) }
    libs.value = Libs.Builder().withContext(context).build()
    val libraries = libs.value!!.libraries
    
    libraries.forEach { library ->
       LibraryItem(
          library = library,
          onClick = {
             library.website?.let {
                 if (it.isNotEmpty()) {
                     uriHandler.openUri(it)
                 }
             }
          }
       )
    }
}

@Composable
fun LibraryItem(
    library: Library,
    onClick: () -> Unit
) {
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(16.dp),
       verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = library.name,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        Badge(
            containerColor = LibraryDefaults.libraryColors().badgeBackgroundColor,
            contentColor = LibraryDefaults.libraryColors().badgeContentColor
        ) {
             library.artifactVersion?.let { 
                    Text(text = it) 
             }
        }
    }
}
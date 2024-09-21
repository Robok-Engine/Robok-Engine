package org.gampiot.robok.ui.screens.home

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

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

import org.gampiot.robok.R
import org.gampiot.robok.app.Drawables
import org.gampiot.robok.ui.activities.editor.EditorActivity
import org.gampiot.robok.ui.theme.Typography
import org.gampiot.robok.feature.res.Strings
import org.gampiot.robok.feature.terminal.TerminalActivity
import org.gampiot.robok.feature.util.getDefaultPath
import org.gampiot.robok.feature.component.compose.text.RobokText

@Composable
fun HomeScreen(
    navController: NavController,
    actContext: Context
) {
    var selectedFolderUri by remember { mutableStateOf<Uri?>(null) }

    val folderPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocumentTree()
    ) { uri: Uri? ->
        selectedFolderUri = uri
        val bundle = Bundle().apply {
             putString("projectPath", processUri(actContext, uri!!))
        }
        val intent = Intent(actContext, EditorActivity::class.java).apply {
              putExtras(bundle)
        }
        actContext.startActivity(intent)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = Drawables.ic_robok),
                contentDescription = null,
                modifier = Modifier.size(70.dp).padding(8.dp)
            )
            RobokText(
                text = "Robok",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            items(4) { index ->
                HomeCardItem(
                    icon = when (index) {
                        0 -> Drawables.ic_add_24
                        1 -> Drawables.ic_folder_open_24
                        2 -> Drawables.ic_settings_24
                        else -> Drawables.ic_info_24
                    },
                    title = when (index) {
                        0 -> stringResource(id = Strings.title_create_project)
                        1 -> stringResource(id = Strings.title_open_project)
                        2 -> stringResource(id = Strings.common_word_settings)
                        else -> stringResource(id = Strings.title_terminal)
                    },
                    onClick = { 
                        when (index) {
                            0 -> onCreateProjectClicked()
                            1 -> onOpenProjectClicked(folderPickerLauncher)
                            2 -> navController.navigate("settings")
                            else -> onTerminalClicked(actContext)
                        }
                    }
                )
            }
        }
    }
}

private fun onCreateProjectClicked() {
    TODO("trindadedev is lazy and not implemented yet")
}

private fun onOpenProjectClicked(folderPickerLauncher: ActivityResultLauncher<Uri?>) {
    folderPickerLauncher.launch(null)
}

private fun onTerminalClicked(actContext: Context) {
    actContext.startActivity(Intent(actContext, TerminalActivity::class.java))
}

private fun processUri(ac: Context, uri: Uri): String {
    ac.contentResolver.takePersistableUriPermission(
            uri,
            Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    ) 
    val documentId = DocumentsContract.getTreeDocumentId(uri)
    val folderUri = DocumentsContract.buildDocumentUriUsingTree(uri, documentId)
    val path = getPathFromUri(folderUri)
    return path ?: "${getDefaultPath()}/Robok"
}

private fun getPathFromUri(uri: Uri): String? {
    val documentId = DocumentsContract.getDocumentId(uri)
    val split = documentId.split(":")
    val type = split[0]
    val relativePath = split[1]
    if ("primary".equals(type, true)) {
         return "/storage/emulated/0/$relativePath"
    }
    return null
}

@Composable
fun HomeCardItem(
    icon: Int, title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onClick)
            .height(100.dp),
        shape = RoundedCornerShape(17.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(11.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            RobokText(
                text = title,
                modifier = Modifier.padding(top = 8.dp),
                style = Typography.bodyMedium
            )
        }
    }
}
package dev.trindade.robokide.ui.models.preferences

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.theme.*

@Composable
fun PreferenceScreen() {
    
    OakTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            CollapsingToolbar()
            PreferenceContent(Modifier.padding(top = 200.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingToolbar() {
    val scrollState = rememberScrollState()

    Column {
       TopAppBar(
            title = { Text("Preferences") },
            navigationIcon = {
                IconButton(onClick = { /* click action */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "Back"
                    )
                }
            },
            
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
        )
        Spacer(modifier = Modifier.height(200.dp))
    }
}

@Composable
fun PreferenceContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text("Preference content")
    }
}
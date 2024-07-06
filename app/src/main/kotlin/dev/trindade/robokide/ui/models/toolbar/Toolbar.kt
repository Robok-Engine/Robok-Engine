package dev.trindade.robokide.ui.models.toolbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import dev.trindade.robokide.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBarLarge(title: String) {
    LargeTopAppBar(
        title = {
            Text(text = title)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun centeredTitleAppBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigation_back)
                )
            }
        }
    )
}
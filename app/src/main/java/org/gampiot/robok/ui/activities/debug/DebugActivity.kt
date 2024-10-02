package org.gampiot.robok.ui.activities.debug

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
 *  along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import android.os.Bundle

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.*

import org.gampiot.robok.ui.theme.RobokTheme
import org.gampiot.robok.core.utils.base.RobokActivity
import org.gampiot.robok.core.components.compose.preferences.base.PreferenceLayout
import org.gampiot.robok.core.components.compose.preferences.base.PreferenceGroup
import org.gampiot.robok.strings.Strings

@OptIn(ExperimentalMaterial3Api::class)
class DebugActivity : RobokActivity() {

    private val exceptionType = listOf(
        "StringIndexOutOfBoundsException",
        "IndexOutOfBoundsException",
        "ArithmeticException",
        "NumberFormatException",
        "ActivityNotFoundException"
    )

    private val errMessage = listOf(
        "Invalid string operation\n",
        "Invalid list operation\n",
        "Invalid arithmetical operation\n",
        "Invalid toNumber block operation\n",
        "Invalid intent operation"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobokTheme {
                DebugScreen(intent.getStringExtra("error") ?: "")
            }
        }
    }

    @Composable
    fun DebugScreen(errorMessage: String) {
        var madeErrMsg by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(true) }

        LaunchedEffect(errorMessage) {
            madeErrMsg = processErrorMessage(errorMessage)
        }

        PreferenceLayout(
            label = stringResource(id = Strings.title_un_error_ocurred),
            backArrowVisible = true
        ) {
            PreferenceGroup(heading = stringResource(id = Strings.text_error_info)) {
                ErrorContent(madeErrMsg)
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(stringResource(id = Strings.common_word_end))
                    }
                },
                title = { Text(stringResource(id = Strings.title_un_error_ocurred)) },
                text = { Text(madeErrMsg) }
            )
        }
    }

    @Composable
    fun ErrorContent(madeErrMsg: String) {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(madeErrMsg.split("\n")) { line ->
                    Text(text = line, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }

    private fun processErrorMessage(errMsg: String): String {
        val splitMessage = errMsg.split("\n")
        if (splitMessage.isEmpty() || splitMessage[0].isEmpty()) {
            return errMsg
        }
        for (i in exceptionType.indices) {
            if (splitMessage[0].contains(exceptionType[i])) {
                val additionalInfo = splitMessage[0].substringAfter(exceptionType[i])
                return errMessage[i] + additionalInfo
            }
        }
        return errMsg
    }
}
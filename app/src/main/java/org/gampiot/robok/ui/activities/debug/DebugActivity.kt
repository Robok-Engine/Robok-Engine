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

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.text.selection.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*
import androidx.compose.ui.res.stringResource

import org.gampiot.robok.strings.Strings
import org.gampiot.robok.core.utils.base.RobokActivity

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
            DebugScreen(intent.getStringExtra("error") ?: "")
        }
    }

    @Composable
    fun DebugScreen(errorMessage: String) {
        var madeErrMsg by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(true) }

        LaunchedEffect(errorMessage) {
            madeErrMsg = processErrorMessage(errorMessage)
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(id = Strings.title_debug_title)) },
                    navigationIcon = {
                        IconButton(onClick = { finish() }) {
                            Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            content = { paddingValues ->
                ErrorContent(madeErrMsg)
            }
        )

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(stringResource(id = Strings.common_word_end))
                    }
                },
                title = { Text(stringResource(id = Strings.title_debug_title)) },
                text = { Text(madeErrMsg) }
            )
        }
    }

    @Composable
    fun ErrorContent(
        madeErrMsg: String,
        modifier: Modifier = Modifier
    ) {
        val verticalScrollState = rememberScrollState()
        val horizontalScrollState = rememberScrollState()

        SelectionContainer {
            Text(
                text = madeErrMsg,
                fontSize = 11.sp,
                lineHeight = 14.sp,
                modifier = modifier
                    .verticalScroll(verticalScrollState)
                    .horizontalScroll(horizontalScrollState)
            )
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
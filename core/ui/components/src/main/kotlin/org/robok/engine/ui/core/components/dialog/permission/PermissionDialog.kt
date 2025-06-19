package org.robok.engine.ui.core.components.dialog.permission

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import org.robok.engine.strings.Strings

@Composable
fun PermissionDialog(
  icon: ImageVector,
  dialogText: String,
  onAllowClicked: () -> Unit,
  onDenyClicked: () -> Unit,
  onDismissRequest: () -> Unit,
) {
  Dialog(onDismissRequest = {}) {
    Box(
      modifier =
        Modifier.fillMaxWidth()
          .background(
            MaterialTheme.colorScheme.surfaceContainerHigh,
            shape = RoundedCornerShape(28.dp),
          )
          .padding(10.dp),
      contentAlignment = Alignment.Center,
    ) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
          imageVector = icon,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.primary,
          modifier = Modifier.size(80.dp).padding(top = 20.dp),
        )

        Text(
          text = dialogText,
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onSurface,
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(vertical = 20.dp, horizontal = 40.dp),
        )

        Button(
          onClick = onAllowClicked,
          modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 2.dp),
        ) {
          Text(
            text = stringResource(id = Strings.common_word_allow),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
          onClick = onDenyClicked,
          modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 2.dp),
        ) {
          Text(
            text = stringResource(id = Strings.common_word_deny),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
          )
        }
        Spacer(modifier = Modifier.height(8.dp))
      }
    }
  }
}

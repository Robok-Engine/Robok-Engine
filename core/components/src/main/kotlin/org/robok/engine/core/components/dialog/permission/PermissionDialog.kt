package org.robok.engine.core.components.dialog.permission

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
import org.robok.engine.core.components.shape.ButtonShape

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
          shape = ButtonShape(),
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
          shape = ButtonShape(),
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

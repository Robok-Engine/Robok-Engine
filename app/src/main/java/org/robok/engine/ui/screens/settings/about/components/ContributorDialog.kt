package org.robok.engine.ui.screens.settings.about.components

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

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import com.google.android.material.R as MaterialR
import org.robok.engine.strings.Strings
import org.robok.engine.ui.screens.settings.about.models.Contributor
import org.robok.engine.ui.utils.getDialogWindow

@Composable
fun ContributorDialog(contributor: Contributor, onDismissRequest: () -> Unit) {
  val uriHandler = LocalUriHandler.current
  AlertDialog(
    onDismissRequest = onDismissRequest,
    title = { Text(text = stringResource(Strings.title_open_contributor_profile)) },
    text = {
      Text(text = stringResource(Strings.text_open_contributor_profile, contributor.login))
    },
    confirmButton = {
      Button(
        onClick = {
          onDismissRequest()
          uriHandler.openUri(contributor.html_url)
        }
      ) {
        Text(text = stringResource(id = Strings.common_word_open))
      }
    },
    dismissButton = {
      OutlinedButton(onClick = onDismissRequest) {
        Text(text = stringResource(id = Strings.common_word_cancel))
      }
    },
  )
  val dialogWindow = getDialogWindow()
  LaunchedEffect(Unit) {
    dialogWindow?.apply {
      setWindowAnimations(MaterialR.style.MaterialAlertDialog_Material3_Animation)
    }
  }
}

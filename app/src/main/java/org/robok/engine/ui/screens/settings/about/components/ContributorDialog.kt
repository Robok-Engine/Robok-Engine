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

import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.platform.LocalUriHandler
import org.robok.engine.Strings
import org.robok.engine.ui.core.components.dialog.EnhancedAlertDialog
import org.robok.engine.ui.screens.settings.about.models.Contributor

@Composable
fun ContributorDialog(contributor: Contributor, onDismissRequest: () -> Unit) {
  val uriHandler = LocalUriHandler.current
  EnhancedAlertDialog(
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
}

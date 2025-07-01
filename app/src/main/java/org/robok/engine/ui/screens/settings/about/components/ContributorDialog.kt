package org.robok.engine.ui.screens.settings.about.components

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

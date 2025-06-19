package org.robok.engine.ui.screens.settings.libraries

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

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext
import org.robok.engine.Strings
import org.robok.engine.ui.core.components.Screen
import org.robok.engine.ui.core.components.preferences.base.PreferenceGroup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibrariesScreen() {
  val context = LocalContext.current
  Screen(label = stringResource(id = Strings.settings_libraries_title)) {
    PreferenceGroup { Screen(context) }
  }
}

@Composable
private fun Screen(context: Context) {
  val uriHandler = LocalUriHandler.current
  var libs by remember { mutableStateOf<Libs?>(null) }
  libs = Libs.Builder().withContext(context).build()
  val libraries = libs!!.libraries

  libraries.forEach { library ->
    LibraryItem(
      library = library,
      onClick = {
        library.website?.let {
          if (it.isNotEmpty()) {
            // dont open for now uriHandler.openUri(it)
          }
        }
      },
    )
  }
}

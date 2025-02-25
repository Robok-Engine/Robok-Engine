package org.robok.engine.ui.screens.settings.libraries

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
import org.robok.engine.core.components.Screen
import org.robok.engine.core.components.preferences.base.PreferenceGroup

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

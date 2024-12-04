package org.robok.engine.ui.screens.modeling

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

import androidx.compose.foundation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.robok.engine.Drawables
import org.robok.engine.ui.screens.modeling.viewmodel.ModelingViewModel
import org.robok.engine.core.components.animation.ExpandAndShrink

@Composable
fun ModelingScreen(
  viewModel: ModelingViewModel
) {
  
  Box(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.fillMaxSize()) { /* screen content */ }

    Image(
      painter = painterResource(id = Drawables.ic_robok),
      contentDescription = "Open 3D Options",
      modifier =
        Modifier.align(Alignment.TopEnd).padding(16.dp).size(50.dp).clickable {
          viewModel.setOptionsOpen(!viewModel.isOptionsOpen)
        },
    )

    ExpandAndShrink(
      visible = viewModel.isOptionsOpen,
      modifier =
        Modifier.align(Alignment.TopEnd)
          .padding(16.dp)
          .size(width = 200.dp, height = 400.dp)
          .background(MaterialTheme.colorScheme.surfaceContainerHigh),
    ) {
      Box(modifier = Modifier.padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Spacer(modifier = Modifier.height(8.dp))
        }
      }
    }
  }
}

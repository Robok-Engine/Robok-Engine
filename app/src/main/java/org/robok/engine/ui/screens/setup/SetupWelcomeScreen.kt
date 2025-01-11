package org.robok.engine.ui.screens.setup

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
 *   along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.robok.engine.Drawables
import org.robok.engine.Strings
import org.robok.engine.ui.screens.setup.components.BottomButtons

@Composable
fun SetupWelcomeScreen(onBack: () -> Unit, onNext: () -> Unit) {
  BackHandler { onBack() }
  Scaffold(
    modifier = Modifier.systemBarsPadding(),
    bottomBar = {
      BottomButtons(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        isWelcome = true,
        onNext = onNext,
        onBack = onBack,
      )
    },
  ) { innerPadding ->
    Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
      Welcome(
        modifier =
          Modifier.align(Alignment.BottomCenter)
            .padding(horizontal = 35.dp)
            .padding(bottom = 120.dp)
      )
    }
  }
}

@Composable
fun Welcome(modifier: Modifier = Modifier) {
  Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
    Image(
      painter = painterResource(id = Drawables.ic_setup_welcome_person ),
      contentDescription = "App Icon",
      modifier = Modifier.size(256.dp)
      .padding(bottom = 24.dp)
      ,
      contentScale = ContentScale.Fit,
    )
    Text(
      text = stringResource(id = Strings.setup_welcome_title),
      style = MaterialTheme.typography.headlineLarge,
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(
      text = stringResource(id = Strings.setup_welcome_description),
      fontSize = 19.sp,
      style = MaterialTheme.typography.bodyLarge,
      textAlign = TextAlign.Center,
    )
  }
}

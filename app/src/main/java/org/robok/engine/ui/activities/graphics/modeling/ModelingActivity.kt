package org.robok.engine.ui.activities.graphics.modeling

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

import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import org.koin.androidx.compose.koinViewModel
import org.robok.engine.ui.base.BaseComposeActivity
import org.robok.engine.ui.screens.graphics.modeling.ModelingScreen
import org.robok.engine.ui.screens.graphics.modeling.viewmodel.ModelingViewModel
import org.robok.engine.ui.theme.RobokTheme

class ModelingActivity : BaseComposeActivity(), AndroidFragmentApplication.Callbacks {

  @Composable
  override fun onScreenCreated() {
    SideEffect { hideSystemUI() }
    val viewModel = koinViewModel<ModelingViewModel>()
    setContent { RobokTheme { ModelingScreen(viewModel = viewModel) } }
  }

  /** Hide phone ui to better experience */
  private fun hideSystemUI() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
      window.setDecorFitsSystemWindows(false)
      window.insetsController?.let { controller ->
        controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
      }
    } else {
      @Suppress("DEPRECATION")
      window.decorView.systemUiVisibility =
        (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
  }

  /** Implementation of the exit() method of the AndroidFragmentApplication.Callbacks interface */
  override fun exit() {
    finish()
  }
}

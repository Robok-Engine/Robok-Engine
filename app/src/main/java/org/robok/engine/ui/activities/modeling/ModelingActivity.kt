package org.robok.engine.ui.activities.modeling

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
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import org.robok.engine.databinding.Activity3dModelBinding
import org.robok.engine.feature.modeling.fragment.LibGDXFragment
import org.robok.engine.feature.modeling.view.Model3DView
import org.robok.engine.ui.activities.base.RobokComposeActivity

class ModelingActivity : RobokComposeActivity(), AndroidFragmentApplication.Callbacks {

  private var binding: Activity3dModelBinding? = null
  private var model3dView: Model3DView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = Activity3dModelBinding.inflate(layoutInflater)
    setContentView(binding?.root)

    val libGDXFragment = LibGDXFragment()
    val fragmentManager: FragmentManager = supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(binding?.frameLibGdx?.id ?: 0, libGDXFragment)
    fragmentTransaction.commit()

    fragmentManager.executePendingTransactions()
    model3dView = Model3DView.clazz

    val activityHelper = ModelingActivityHelper(this, model3dView)
    val composeUI: ComposeView = activityHelper.createComposeView()

    binding?.layoutParent?.addView(composeUI)
    hideSystemUI()
  }

  /** Check if the game is null to prevent errors. */
  private fun verifyIfMy3dGameIsNull() {
    if (model3dView != null) return
    model3dView = Model3DView.clazz
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

  /** Set binding to null if the activity is destroyed. */
  override fun onDestroy() {
    binding = null
    super.onDestroy()
  }
}

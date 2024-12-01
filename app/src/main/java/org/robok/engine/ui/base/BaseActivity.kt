package org.robok.engine.ui.base

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

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import dev.chrisbanes.insetter.Insetter
import kotlinx.coroutines.runBlocking
import org.robok.engine.core.utils.getBackPressedClickListener
import org.robok.engine.ui.theme.XMLThemeManager

open class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    val themeManager = XMLThemeManager()
    runBlocking { themeManager.apply(this@BaseActivity) }
    super.onCreate(savedInstanceState)
  }

  fun handleInsetts(rootView: View) {
    Insetter.builder().padding(WindowInsetsCompat.Type.navigationBars()).applyToView(rootView)
  }

  open fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
    toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
  }

  open fun isDarkMode(): Boolean {
    val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentNightMode == Configuration.UI_MODE_NIGHT_YES
  }
}

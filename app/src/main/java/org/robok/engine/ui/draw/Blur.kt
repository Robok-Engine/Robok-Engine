package org.robok.engine.ui.draw

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.skydoves.cloudy.cloudy
import org.robok.engine.ui.base.BaseComposeActivity

/** Enable or disable blur of content */
fun Context.enableBlur(enable: Boolean) {
  val a = this as BaseComposeActivity
  a.isBlurEnable = enable
}

/** Defines the radius value in blur */
fun Context.setBlurRadius(blurRadius: Int) {
  val a = this as BaseComposeActivity
  a.blurRadius = blurRadius
}

@Composable
fun Modifier.blur(radius: Int = 15, isBlurEnable: Boolean = true): Modifier {
  return if (isBlurEnable) cloudy(radius = radius) else this
}

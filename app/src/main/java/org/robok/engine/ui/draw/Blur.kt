package org.robok.engine.ui.draw

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

/*
 * This file is part of Robok © 2024.
 *
 * Robok is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robok is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.robok.engine.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

class CustomNavType<T : Parcelable>(
  private val clazz: Class<T>,
  private val serializer: KSerializer<T>,
) : NavType<T>(isNullableAllowed = false) {

  override fun get(bundle: Bundle, key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      bundle.getParcelable(key, clazz)
    } else {
      @Suppress("DEPRECATION") bundle.getParcelable(key)
    }
  }

  override fun parseValue(value: String): T {
    return Json.decodeFromString(serializer, value)
  }

  override fun serializeAsValue(value: T): String {
    return Json.encodeToString(serializer, value)
  }

  override fun put(bundle: Bundle, key: String, value: T) {
    bundle.putParcelable(key, value)
  }

  override val name: String
    get() = clazz.name
}

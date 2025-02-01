package org.robok.engine.core.utils

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
import android.os.LocaleList
import java.util.Locale

/**
 * Verify user device language
 *
 * @param language The Language, like "pt".
 * @param country The Country name, like "BR".
 */
fun isDeviceLanguage(language: String, country: String): Boolean {
  val currentLocale: Locale =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      LocaleList.getDefault()[0]
    } else {
      Locale.getDefault()
    }
  return currentLocale.language == language && currentLocale.country == country
}

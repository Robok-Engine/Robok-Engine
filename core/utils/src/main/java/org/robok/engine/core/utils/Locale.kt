package org.robok.engine.core.utils

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

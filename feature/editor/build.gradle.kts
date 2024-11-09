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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */
import org.robok.engine.build.BuildConfig

plugins {
  alias(libs.plugins.robok.library)
  kotlin("plugin.serialization") version "2.0.21"
}

android {
  namespace = "${BuildConfig.featurePackageName}.editor"
}

dependencies {
  implementation(libs.material)
  implementation(libs.appcompat)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.datastore.preferences)
  
  implementation(libs.coroutines.android)
  implementation(libs.serialization.json)
  
  implementation(platform(libs.okhttp.bom))
  implementation("com.squareup.okhttp3:okhttp")
  
  implementation(libs.koin.android)
  
  implementation(libs.sora.editor)
  implementation(libs.sora.editor.language.java)
  implementation(libs.sora.editor.language.textmate)
  
  implementation(libs.antlr)
  implementation(libs.antlr.runtime)
  
  implementation(projects.appStrings)
  implementation(projects.feature.settings)
  implementation(projects.core.utils)
  implementation(projects.core.antlr4.java)
}
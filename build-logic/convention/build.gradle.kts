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
 
plugins {
  `kotlin-dsl`
}

dependencies {
  compileOnly(libs.android.gradle)
  compileOnly(libs.compose.gradle)
  compileOnly(libs.kotlin.gradle)
  compileOnly(libs.ksp.gradle)
}

gradlePlugin {
  plugins {
    register("robok.application") {
      id = "robok.application"
      implementationClass = "ApplicationConventionPlugin"
    }
    
    register("robok.library") {
      id = "robok.library"
      implementationClass = "LibraryConventionPlugin"
    }
    
    register("robok.compose") {
      id = "robok.compose"
      implementationClass = "ComposeConventionPlugin"
    }
    
    register("robok.library.compose") {
      id = "robok.compose"
      implementationClass = "LibraryComposeConventionPlugin"
    }
  }
}
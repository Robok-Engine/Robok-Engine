package org.robok.engine.feature.compiler.android.model

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

import java.io.File
import org.robok.engine.feature.compiler.android.logger.Logger

data class Project(
  var outputFile: File? = null,
  var resourcesFile: File? = null,
  var javaFile: File? = null,
  var manifestFile: File? = null,
  var minSdk: Int = 0,
  var targetSdk: Int = 0,
  var versionCode: Int = 1,
  var versionName: String = "1.0",
  var libraries: MutableList<Library>? = null,
  var assetsFile: File? = null,
  var logger: Logger? = null,
  var rootPath: File? = null
)
package org.robok.engine.feature.compiler.android.model

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

import java.io.File
import org.robok.engine.feature.compiler.android.logger.LoggerViewModel

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
  var logger: LoggerViewModel? = null,
  var rootPath: File? = null,
)

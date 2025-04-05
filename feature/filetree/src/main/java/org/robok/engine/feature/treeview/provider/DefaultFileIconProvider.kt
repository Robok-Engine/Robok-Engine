package org.robok.engine.feature.treeview.provider

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
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import org.robok.engine.feature.treeview.R
import org.robok.engine.feature.treeview.interfaces.FileIconProvider
import org.robok.engine.feature.treeview.interfaces.FileObject
import org.robok.engine.feature.treeview.model.Node

class DefaultFileIconProvider(context: Context) : FileIconProvider {
  private val file by lazy { ContextCompat.getDrawable(context, R.drawable.file) }
  private val folder by lazy { ContextCompat.getDrawable(context, R.drawable.folder) }
  private val chevron_right by lazy {
    ContextCompat.getDrawable(context, R.drawable.ic_chevron_right)
  }
  private val expand_more by lazy {
    ContextCompat.getDrawable(context, R.drawable.round_expand_more_24)
  }
  private val java by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_java) }
  private val html by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_html) }
  private val kotlin by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_kotlin) }
  private val python by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_python) }
  private val xml by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_xml) }
  private val js by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_js) }
  private val c by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_c) }
  private val cpp by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_cpp) }
  private val json by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_json) }
  private val css by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_css) }
  private val csharp by lazy { ContextCompat.getDrawable(context, R.drawable.ic_language_csharp) }

  private val bash by lazy { ContextCompat.getDrawable(context, R.drawable.bash) }
  private val apk by lazy { ContextCompat.getDrawable(context, R.drawable.apkfile) }
  private val archive by lazy { ContextCompat.getDrawable(context, R.drawable.archive) }
  private val contract by lazy { ContextCompat.getDrawable(context, R.drawable.contract) }
  private val text by lazy { ContextCompat.getDrawable(context, R.drawable.text) }
  private val video by lazy { ContextCompat.getDrawable(context, R.drawable.video) }
  private val audio by lazy { ContextCompat.getDrawable(context, R.drawable.music) }
  private val image by lazy { ContextCompat.getDrawable(context, R.drawable.image) }
  private val react by lazy { ContextCompat.getDrawable(context, R.drawable.react) }
  private val rust by lazy { ContextCompat.getDrawable(context, R.drawable.rust) }
  private val markdown by lazy { ContextCompat.getDrawable(context, R.drawable.markdown) }

  override fun getIcon(node: Node<FileObject>): Drawable? {
    return if (node.value.isFile()) {
      when (node.value.getName()) {
        "contract.sol",
        "LICENSE" -> contract
        "gradlew" -> bash

        else ->
          when (node.value.getName().substringAfterLast('.', "")) {
            "java",
            "bsh" -> java
            "html" -> html
            "kt",
            "kts" -> kotlin
            "py" -> python
            "xml" -> xml
            "js" -> js
            "c",
            "h" -> c
            "cpp",
            "hpp" -> cpp
            "json" -> json
            "css" -> css
            "cs" -> csharp
            "sh",
            "bash",
            "zsh",
            "bat" -> bash
            "apk",
            "xapk",
            "apks" -> apk
            "zip",
            "rar",
            "7z",
            "tar.gz",
            "tar.bz2",
            "tar" -> archive
            "md" -> markdown
            "txt" -> text
            "mp3",
            "wav",
            "ogg",
            "flac" -> audio
            "mp4",
            "mov",
            "avi",
            "mkv" -> video
            "jpg",
            "jpeg",
            "png",
            "gif",
            "bmp" -> image
            "rs" -> rust
            "jsx" -> react
            else -> file
          }
      }
    } else {
      folder
    }
  }

  override fun getChevronRight(): Drawable? {
    return chevron_right
  }

  override fun getExpandMore(): Drawable? {
    return expand_more
  }
}

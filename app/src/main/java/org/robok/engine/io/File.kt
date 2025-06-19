package org.robok.engine.io

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

import java.security.MessageDigest

class File(val filePath: String) : java.io.File(filePath) {
  private var previousHash: String? = null

  /** Generates the hash (SHA-256) of the file content. */
  private fun calculateHash(): String {
    if (!exists()) throw IllegalStateException("File does not exist: $path")
    val digest = MessageDigest.getInstance("SHA-256")
    inputStream().use { fis ->
      val buffer = ByteArray(1024)
      var bytesRead: Int
      while (fis.read(buffer).also { bytesRead = it } != -1) {
        digest.update(buffer, 0, bytesRead)
      }
    }
    return digest.digest().joinToString("") { "%02x".format(it) }
  }

  /**
   * Checks if the file content has been modified since the last check. Returns `true` if the
   * content is different, `false` otherwise.
   */
  fun isModified(): Boolean {
    val currentHash = calculateHash()
    val isModified = previousHash != null && currentHash != previousHash
    previousHash = currentHash
    return isModified
  }
}

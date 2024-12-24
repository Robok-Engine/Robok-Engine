package org.robok.engine.io

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

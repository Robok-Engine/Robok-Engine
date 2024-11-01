package org.robok.engine.feature.compiler.util;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipExtractor {

  public static void extractZip(File zipFile, File destDir) throws IOException {
    if (!destDir.exists()) {
      destDir.mkdirs();
    }

    try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
      ZipEntry entry;
      while ((entry = zipInputStream.getNextEntry()) != null) {
        File file = new File(destDir, entry.getName());

        if (entry.isDirectory()) {
          file.mkdirs();
        } else {
          // Ensure parent directory exists
          file.getParentFile().mkdirs();

          try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zipInputStream.read(buffer)) != -1) {
              fos.write(buffer, 0, bytesRead);
            }
          }
        }
        zipInputStream.closeEntry();
      }
    }
  }
}

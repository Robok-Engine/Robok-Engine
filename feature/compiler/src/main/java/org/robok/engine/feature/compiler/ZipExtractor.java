package org.robok.engine.feature.compiler;

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

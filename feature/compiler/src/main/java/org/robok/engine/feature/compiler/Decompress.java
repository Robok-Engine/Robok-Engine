package org.robok.engine.feature.compiler;

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

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompress {
  private static final int BUFFER_SIZE = 1024 * 10;
  private static final String TAG = "Decompress";

  public static void unzipFromAssets(Context context, String zipFile, String destination) {
    try {
      if (destination == null || destination.length() == 0)
        destination = context.getFilesDir().getAbsolutePath();
      InputStream stream = context.getAssets().open(zipFile);
      unzip(stream, destination);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void unzip(String zipFile, String location) {
    try {
      FileInputStream fin = new FileInputStream(zipFile);
      unzip(fin, location);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void unzip(InputStream stream, String destination) {
    dirChecker(destination, "");
    byte[] buffer = new byte[BUFFER_SIZE];
    try {
      ZipInputStream zin = new ZipInputStream(stream);
      ZipEntry ze = null;

      while ((ze = zin.getNextEntry()) != null) {
        Log.v(TAG, "Unzipping " + ze.getName());

        if (ze.isDirectory()) {
          dirChecker(destination, ze.getName());
        } else {
          File f = new File(destination, ze.getName());
          if (!f.exists()) {
            boolean success = f.createNewFile();
            if (!success) {
              Log.w(TAG, "Failed to create file " + f.getName());
              continue;
            }
            FileOutputStream fout = new FileOutputStream(f);
            int count;
            while ((count = zin.read(buffer)) != -1) {
              fout.write(buffer, 0, count);
            }
            zin.closeEntry();
            fout.close();
          }
        }
      }
      zin.close();
    } catch (Exception e) {
      Log.e(TAG, "unzip", e);
    }
  }

  private static void dirChecker(String destination, String dir) {
    File f = new File(destination, dir);

    if (!f.isDirectory()) {
      boolean success = f.mkdirs();
      if (!success) {
        Log.w(TAG, "Failed to create folder " + f.getName());
      }
    }
  }
}

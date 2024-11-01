package org.robok.engine.feature.editor.languages.java.store;

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
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class RDKFileMapper {

  private Context context;
  private HashMap<String, String> robokClasses;
  private String actuallyRdk;
  private File rdkDirectory;

  public RDKFileMapper(Context context) {
    this.context = context;
    robokClasses = new HashMap<>();

    actuallyRdk = "RDK-1";
    rdkDirectory = new File(context.getFilesDir(), actuallyRdk + "/rdk/");

    load();
  }

  public void load() {
    this.robokClasses = mapRdkClasses();
  }

  public HashMap<String, String> getClasses() {
    return this.robokClasses;
  }

  public HashMap<String, String> mapRdkClasses() {
    File rdkFolder = rdkDirectory;

    if (rdkFolder.exists() && rdkFolder.isDirectory()) {
      mapClassesRecursively(rdkFolder, "", robokClasses);
    } else {
      robokClasses.put("RDKNotExistsException", "robok.rdk.RDKNotExistsException");
    }

    return robokClasses;
  }

  private void mapClassesRecursively(
      File folder, String packageName, HashMap<String, String> robokClasses) {
    File[] files = folder.listFiles();
    if (files == null) return;

    for (File file : files) {
      if (file.isDirectory()) {
        String newPackageName =
            packageName.isEmpty() ? file.getName() : packageName + "." + file.getName();
        mapClassesRecursively(file, newPackageName, robokClasses);
      } else if (file.getName().endsWith(".class")) {
        String className = file.getName().replace(".class", "");
        String classPath = packageName + "." + className;
        robokClasses.put(className, classPath);
      }
    }
  }

  public URLClassLoader getClassLoader() throws Exception {
    File file = rdkDirectory;

    URL url = file.toURI().toURL();
    URL[] urls = new URL[] {url};

    return new URLClassLoader(urls);
  }
}

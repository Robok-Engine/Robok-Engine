package org.robok.engine.feature.compiler.android;

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
import java.io.IOException;
import org.robok.engine.feature.compiler.android.exception.CompilerException;
import org.robok.engine.feature.compiler.Decompress;

public class Compiler {

  private Context glbContext;

  public Compiler(Context context) {
    glbContext = context;
  }

  public interface OnProgressUpdateListener {
    void onProgressUpdate(String... update);
  }

  protected OnProgressUpdateListener listener;
  private String tag = "unknow";
  private boolean isCompilationSuccessful = true;

  public void setProgressListener(OnProgressUpdateListener listener) {
    this.listener = listener;
  }

  public void onProgressUpdate(String... update) {
    if (listener != null) {
      listener.onProgressUpdate(update);
    }
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getTag() {
    return this.tag;
  }

  public boolean getIsCompilationSuccessful() {
    return this.isCompilationSuccessful;
  }

  public void setIsCompilationSuccessful(boolean isCompilationSuccessful) {
    this.isCompilationSuccessful = isCompilationSuccessful;
  }

  public void prepare() {}

  public void run() throws CompilerException, IOException {}

  public File getAndroidJarFile() {
    File check = new File(glbContext.getFilesDir() + "/temp/android.jar");

    if (check.exists()) {
      return check;
    }

    Decompress.unzipFromAssets(
        glbContext, "android.jar.zip", check.getParentFile().getAbsolutePath());

    return check;
  }

  public File getLambdaFactoryFile() {
    File check = new File(glbContext.getFilesDir() + "/temp/core-lambda-stubs.jar");

    if (check.exists()) {
      return check;
    }

    Decompress.unzipFromAssets(
        glbContext, "core-lambda-stubs.zip", check.getParentFile().getAbsolutePath());

    return check;
  }
}

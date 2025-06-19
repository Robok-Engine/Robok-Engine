package org.robok.engine.feature.compiler.android;

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

import android.content.Context;
import java.io.File;
import java.io.IOException;
import org.robok.engine.feature.compiler.Decompress;
import org.robok.engine.feature.compiler.android.exception.CompilerException;

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

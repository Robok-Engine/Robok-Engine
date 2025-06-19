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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.batch.Main;
import org.robok.engine.feature.compiler.android.exception.CompilerException;
import org.robok.engine.feature.compiler.android.model.Library;
import org.robok.engine.feature.compiler.android.model.Project;

public class ECJCompiler extends Compiler {

  private static final String TAG = "ECJ";

  private Project mProject;

  private Context glbContext;

  public ECJCompiler(Context context, Project project) {
    super(context);
    glbContext = context;
    mProject = project;
    setTag(TAG);
  }

  @Override
  public void prepare() {}

  @Override
  public void run() throws CompilerException {

    onProgressUpdate("Compiling java files...");
    onProgressUpdate("Running...");
    //	mProject.getLogger().d(TAG, "Running...");

    CompilerOutputStream errorOutputStream = new CompilerOutputStream(new StringBuffer());
    PrintWriter errWriter = new PrintWriter(errorOutputStream);

    CompilerOutputStream outputStream = new CompilerOutputStream(new StringBuffer());
    PrintWriter outWriter = new PrintWriter(outputStream);

    ArrayList<String> args = new ArrayList<>();

    args.add("-1.8");
    args.add("-proc:none");
    args.add("-nowarn");
    args.add("-d");
    File file = new File(mProject.getOutputFile() + "/bin/classes/");
    file.mkdir();
    args.add(file.getAbsolutePath());

    args.add("-cp");
    StringBuilder libraryString = new StringBuilder();

    libraryString.append(getAndroidJarFile().getAbsolutePath());
    libraryString.append(":");
    for (Library library : mProject.getLibraries()) {
      File classFile = library.getClassJarFile();
      if (classFile.exists()) {
        libraryString.append(classFile.getAbsolutePath());
        libraryString.append(":");
      }
    }
    libraryString.append(getLambdaFactoryFile().getAbsolutePath());
    args.add(libraryString.toString());

    args.add("-sourcepath");
    args.add(" ");

    args.add(mProject.getJavaFile().getAbsolutePath());

    for (File resourceFile : getJavaFiles(new File(mProject.getOutputFile() + "/gen"))) {
      args.add(resourceFile.getAbsolutePath());
    }

    Main main = new Main(outWriter, errWriter, false, null, null);

    main.compile(args.toArray(new String[0]));

    if (main.globalErrorsCount > 0) {
      // throw new CompilerException(errorOutputStream.buffer.toString());
      mProject.getLogger().e(TAG, errorOutputStream.buffer.toString());
      setIsCompilationSuccessful(false);
    }
  }

  private List<File> getJavaFiles(File dir) {

    List<File> files = new ArrayList<>();

    File[] childs = dir.listFiles();

    if (childs != null) {
      for (File child : childs) {

        if (child.isDirectory()) {
          files.addAll(getJavaFiles(child));
          continue;
        }
        if (child.getName().endsWith(".java"))
          ;
        {
          files.add(child);
        }
      }
    }
    return files;
  }

  private class CompilerOutputStream extends OutputStream {

    public StringBuffer buffer;

    public CompilerOutputStream(StringBuffer buffer) {
      this.buffer = buffer;
    }

    @Override
    public void write(int b) {

      if (b == '\n') {
        mProject.getLogger().d(TAG, buffer.toString());
        buffer = new StringBuffer();
        return;
      }
      buffer.append((char) b);
    }
  }
}

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
import java.util.ArrayList;
import java.util.List;
import org.robok.engine.core.utils.FileUtil;
import org.robok.engine.feature.compiler.BinaryExecutor;
import org.robok.engine.feature.compiler.android.exception.CompilerException;
import org.robok.engine.feature.compiler.android.model.Library;
import org.robok.engine.feature.compiler.android.model.Project;

public class AAPT2Compiler extends Compiler {

  private static final String TAG = "AAPT2";

  private Project projectModel;
  private List<Library> librariesList;

  private File binPath;
  private File genPath;
  private File outputPath;
  private File resPath;

  private BinaryExecutor binaryExecutor;

  private Context glbContext;

  public AAPT2Compiler(Context context, Project project) {
    super(context);
    projectModel = project;
    glbContext = context;
    setTag(TAG);
  }

  @Override
  public void prepare() {
    onProgressUpdate("Preparing AAPT2...");

    librariesList = new ArrayList<>();
    librariesList.addAll(projectModel.getLibraries());

    binPath = new File(projectModel.getOutputFile(), "bin");
    genPath = new File(projectModel.getOutputFile(), "gen");

    for (Library library : new ArrayList<>(librariesList)) {
      if (new File(binPath, "/res/" + library.getName() + ".zip").exists()) {
        librariesList.remove(library); // remove the library from the list so it wont get compiled
        onProgressUpdate("Removing " + library.getName() + " to speed up compilation");
      }
    }
    File[] childs = binPath.listFiles();
    if (childs != null) {
      for (File child : childs) {
        if (child.getName().equals("res")) {
          continue;
        }
        child.delete();
      }
    }
    FileUtil.makeDir(binPath.getPath());
    FileUtil.makeDir(genPath.getPath());
  }

  @Override
  public void run() throws CompilerException, IOException {
    ArrayList<String> args = new ArrayList<>();
    binaryExecutor = new BinaryExecutor();

    // compile resources
    onProgressUpdate("Compiling resources");
    args.add(getAAPT2File().getAbsolutePath());
    args.add("compile");
    args.add("--dir");
    args.add(projectModel.getResourcesFile().getAbsolutePath());
    args.add("-o");

    resPath = new File(binPath, "res");
    resPath.mkdir();

    outputPath = createNewFile(resPath, "project.zip");
    args.add(outputPath.getAbsolutePath());
    binaryExecutor.setCommands(args);
    if (!binaryExecutor.execute().isEmpty()) {
      projectModel.getLogger().e(TAG, binaryExecutor.getLogs());
      setIsCompilationSuccessful(false);
    }

    onProgressUpdate("Compiling libraries");
    compileLibraries();
    args.clear();
    // link resources
    onProgressUpdate("Linking resources");
    args.add(getAAPT2File().getAbsolutePath());
    args.add("link");
    args.add("--allow-reserved-package-id");
    args.add("--no-version-vectors");
    args.add("--no-version-transitions");
    args.add("--auto-add-overlay");
    args.add("--min-sdk-version");
    args.add(String.valueOf(projectModel.getMinSdk()));
    args.add("--target-sdk-version");
    args.add(String.valueOf(projectModel.getTargetSdk()));
    args.add("--version-code");
    args.add(String.valueOf(projectModel.getVersionCode()));
    args.add("--version-name");
    args.add(String.valueOf(projectModel.getVersionName()));
    /* TODO: custom android.jar */
    args.add("-I");
    args.add(getAndroidJarFile().getAbsolutePath());
    if (projectModel.getAssetsFile() != null) {
      args.add("-A");
      args.add(projectModel.getAssetsFile().getAbsolutePath());
    }
    // add compiled resources
    File[] resources = resPath.listFiles();
    if (resources != null) {
      for (File file : resources) {
        if (file.isDirectory() || file.getName().equals("project.zip")) {
          continue;
        }
        args.add("-R");
        args.add(file.getAbsolutePath());
      }
    }
    File projectZip = new File(resPath, "project.zip");
    if (projectZip.exists()) {
      args.add("-R");
      args.add(projectZip.getAbsolutePath());
    }
    // export generated R.java files to /dir/gen/
    args.add("--java");
    args.add(genPath.getAbsolutePath() + "/");
    args.add("--manifest");
    args.add(projectModel.getManifestFile().getAbsolutePath());
    StringBuilder sb = new StringBuilder();
    for (Library library : librariesList) {
      if (library.requiresResourceFile()) {
        projectModel.getLogger().d(TAG, "Adding extra package: " + library.getPackageName());
        sb.append(library.getPackageName());
        sb.append(":");
      }
    }
    if (!sb.toString().isEmpty()) {
      args.add("--extra-packages");
      args.add(sb.toString().substring(0, sb.toString().length() - 1));
    }
    args.add("-o");
    args.add(createNewFile(binPath, "generated.apk.res").getAbsolutePath());
    binaryExecutor.setCommands(args);
    if (!binaryExecutor.execute().isEmpty()) {
      projectModel.getLogger().e(TAG, binaryExecutor.getLogs());
      setIsCompilationSuccessful(false);
    }
  }

  private void compileLibraries() throws CompilerException, IOException {
    ArrayList<String> args = new ArrayList<>();
    for (Library library : librariesList) {
      if (!library.getResourcesFile().exists()) {
        continue;
      }
      projectModel.getLogger().d(TAG, "Compiling library: " + library.getName());
      args.clear();
      args.add(getAAPT2File().getAbsolutePath());
      args.add("compile");
      args.add("--dir");
      args.add(library.getResourcesFile().getAbsolutePath());
      args.add("-o");
      File output = createNewFile(resPath, library.getName() + ".zip");
      args.add(output.getAbsolutePath());

      binaryExecutor.setCommands(args);
      if (!binaryExecutor.execute().isEmpty()) {
        projectModel.getLogger().e(TAG, binaryExecutor.getLogs());
        setIsCompilationSuccessful(false);
      }
    }
  }

  private File createNewFile(File parent, String name) throws IOException {
    File createdFile = new File(parent, name);
    parent.mkdirs();
    createdFile.createNewFile();
    return createdFile;
  }

  private File getAAPT2File() throws CompilerException, IOException {
    File nativeLibrary =
        new File(glbContext.getApplicationInfo().nativeLibraryDir + "/libaapt2.so");

    if (!nativeLibrary.exists()) {
      projectModel.getLogger().e(TAG, "AAPT2 binary not found");
      setIsCompilationSuccessful(false);
    }
    return nativeLibrary;
  }
}

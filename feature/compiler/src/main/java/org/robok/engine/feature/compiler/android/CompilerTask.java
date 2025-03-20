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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Robok. If not, see <https://www.gnu.org/licenses/>.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.android.sdklib.build.ApkBuilder;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.robok.apksigner.Main;
import org.robok.engine.core.utils.FileUtil;
import org.robok.engine.feature.compiler.android.incremental.IncrementalD8Compiler;
import org.robok.engine.feature.compiler.android.incremental.IncrementalECJCompiler;
import org.robok.engine.feature.compiler.android.model.Library;
import org.robok.engine.feature.compiler.android.model.Project;
import org.robok.engine.feature.compiler.robok.AssetsCompiler;
import org.robok.engine.feature.compiler.robok.AssetsCompiler.Log;
import org.robok.engine.feature.compiler.robok.AssetsCompiler.LogType;

public class CompilerTask {

  public interface OnCompileResult {
    void onCompileSuccess(File file);

    void onCompileError(String msg);
  }

  private final WeakReference<Context> mContext;
  private final Handler mHandler;
  private final ExecutorService mExecutor;
  private final List<Boolean> compilationSteps;

  private TextView progress;
  private long startTime;
  private Project project;
  private final OnCompileResult onResult;

  public CompilerTask(Context context, OnCompileResult result) {
    mContext = new WeakReference<>(context);
    mHandler = new Handler(Looper.getMainLooper());
    mExecutor = Executors.newSingleThreadExecutor();
    compilationSteps = new ArrayList<>();
    this.onResult = result;
  }

  public void execute(Project project) {
    onPreExecute();

    mExecutor.execute(
        () -> {
          CompilerResult result = doInBackground(project);
          mHandler.post(() -> onPostExecute(result));
        });
  }

  protected void onPreExecute() {
    Context context = mContext.get();
    if (context != null) {
      // Initialize dialog or other pre-execution tasks
      startTime = System.currentTimeMillis();
    }
  }

  protected CompilerResult doInBackground(Project project) {
    CompilerResult compilerResult;

    try {
      this.project = project;

      if (startAssetsCompiler()) {
        compilationSteps.add(true);

        if (startAaptCompiler()) {
          compilationSteps.add(true);

          if (startEcjCompiler()) {
            compilationSteps.add(true);

            if (startD8Compiler()) {
              compilationSteps.add(true);
              startApkBuilder();
            }
          }
        }
      }

      project.getLogger().d("APK Signer", "Signing Apk");
      File genApk = new File(project.getOutputFile() + "/bin/gen.apk");

      File signApk = signFile(genApk);

      long time = System.currentTimeMillis() - startTime;
      if (compilationSteps.size() == 4) {
        project.getLogger().d("APK Builder", "Build success, took " + time + "ms");
        compilerResult = new CompilerResult("Success", false, signApk);
      } else {
        project.getLogger().d("APK Builder", "Build failed, took " + time + "ms");
        compilerResult = new CompilerResult("Failed", true, null);
      }

    } catch (Exception e) {
      return new CompilerResult(android.util.Log.getStackTraceString(e), true, null);
    }

    return compilerResult;
  }

  /*
   * compile /sdcard/Robok/projects/$projectName/assets
   * to android structure in private dir
   * @param buildLogger A Terminal Logger instante
   */
  private boolean startAssetsCompiler() {
    var assetsCompiler = new AssetsCompiler(mContext.get(), project.getRootPath());
    var hasError = new AtomicBoolean(false);

    assetsCompiler.setCompileListener(
        logs -> {
          for (Log log : logs) {
            if (log.getType() == LogType.NORMAL) {
              publishProgress("AssetsCompiler", log.getText());
              hasError.set(false);
            } else {
              project.getLogger().e("AssetsCompiler", log.getText());
              hasError.set(true);
            }
          }
        });

    assetsCompiler.compileAll();
    return !hasError.get();
  }

  private boolean startAaptCompiler() throws Exception {
    Compiler aapt2Compiler = new AAPT2Compiler(mContext.get(), project);
    aapt2Compiler.setProgressListener(args -> publishProgress(aapt2Compiler.getTag(), args));
    aapt2Compiler.prepare();
    aapt2Compiler.run();

    return aapt2Compiler.getIsCompilationSuccessful();
  }

  private boolean startEcjCompiler() throws Exception {
    Compiler ecjCompiler = new IncrementalECJCompiler(mContext.get(), project);
    ecjCompiler.setProgressListener(args -> publishProgress(ecjCompiler.getTag(), args));
    ecjCompiler.prepare();
    ecjCompiler.run();

    return ecjCompiler.getIsCompilationSuccessful();
  }

  private boolean startD8Compiler() throws Exception {
    Compiler d8Compiler = new IncrementalD8Compiler(mContext.get(), project);
    d8Compiler.setProgressListener(args -> publishProgress(d8Compiler.getTag(), args));
    d8Compiler.prepare();
    d8Compiler.run();

    return d8Compiler.getIsCompilationSuccessful();
  }

  private void startApkBuilder() throws Exception {
    publishProgress("APK Builder", "Packaging APK...");
    project.getLogger().d("APK Builder", "Packaging APK");

    File binDir = new File(project.getOutputFile(), "bin");
    File apkPath = new File(binDir, "gen.apk");
    apkPath.createNewFile();

    File resPath = new File(binDir, "generated.apk.res");
    File dexFile = new File(binDir, "classes.dex");
    ApkBuilder builder = new ApkBuilder(apkPath, resPath, dexFile, null, null);

    File[] binFiles = binDir.listFiles();
    for (File file : binFiles) {
      if (!file.getName().equals("classes.dex") && file.getName().endsWith(".dex")) {
        builder.addFile(file, Uri.parse(file.getAbsolutePath()).getLastPathSegment());
        project.getLogger().d("APK Builder", "Adding dex file " + file.getName() + " to APK.");
      }
    }

    for (Library library : project.getLibraries()) {
      builder.addResourcesFromJar(new File(library.getPath(), "classes.jar"));
      project
          .getLogger()
          .d("APK Builder", "Adding resources of " + library.getName() + " to the APK");
    }

    builder.setDebugMode(false);
    builder.sealApk();
  }

  private void publishProgress(String tag, String... updates) {
    mHandler.post(
        () -> {
          if (updates.length > 0) {
            String update = updates[0];
            project.getLogger().d(tag, update);
          }
        });
  }

  protected void onPostExecute(CompilerResult result) {
    if (result.isError()) {
      onResult.onCompileError(result.getMessage());
    } else {
      onResult.onCompileSuccess(result.getSignApk());
    }
  }

  public void shutdown() {
    mExecutor.shutdown();
  }

  private File signFile(File file) {
    File signedFile = null;

    try {
      String outFile = file.getAbsolutePath();
      String out = project.getOutputFile() + "/bin/generated.apk";
      Main.sign(file, out, "testkey"); // Sign apk file
      signedFile = new File(out);
    } catch (Exception e) {
      project.getLogger().d("APK Signer", "Sign error");
    }

    try {
      FileUtil.deleteFile(project.getOutputFile() + "/bin/gen.apk");
    } catch (Exception e) {
      // Handle exception
      e.printStackTrace();
    }

    return signedFile;
  }
}

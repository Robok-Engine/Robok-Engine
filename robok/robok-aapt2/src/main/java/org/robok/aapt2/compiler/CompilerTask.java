package org.robok.aapt2.compiler;

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
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import android.net.Uri;

import com.android.sdklib.build.ApkBuilder;

import java.lang.ref.WeakReference;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.robok.aapt2.util.FileUtil;
import org.robok.aapt2.model.Project;
import org.robok.aapt2.model.Library;
import org.robok.aapt2.compiler.AAPT2Compiler;
import org.robok.aapt2.compiler.Compiler;
import org.robok.aapt2.compiler.CompilerResult;
import org.robok.aapt2.compiler.incremental.IncrementalECJCompiler;
import org.robok.aapt2.compiler.incremental.IncrementalD8Compiler;

public class CompilerTask {

    private final WeakReference<Context> mContext;
    private final Handler mHandler;
    private final ExecutorService mExecutor;
    private List<Boolean> compilationSteps;

    private TextView progress;
    private long startTime;
    private Project project;

    public CompilerTask(Context context) {
        mContext = new WeakReference<>(context);
        mHandler = new Handler(Looper.getMainLooper());
        mExecutor = Executors.newSingleThreadExecutor();
        compilationSteps = new ArrayList<Boolean>();
    }

    public void execute(Project project) {
        onPreExecute();

        mExecutor.execute(() -> {
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
            

            if (startAaptCompiler()) {
                compilationSteps.add(true);
                if (startEcjCompiler()) {
                    compilationSteps.add(true);
                    if (startD8Compiler()) {
                        compilationSteps.add(true);
                        startBuildApk();
                    }
                }
            }
            //project.getLogger().d("APK Signer", "Signing Apk");
			//String path_ = project.getOutputFile() + "/bin/gen.apk";
            
            //assinarApk(mContext.get(), new java.io.File(path_));
			 //signFile(new java.io.File(path_));
            
            long time = System.currentTimeMillis() - startTime;
            if(compilationSteps.size() == 3){
                project.getLogger().d("APK Builder", "Build success, took " + time + "ms");
                compilerResult = new CompilerResult("Success", false);
            }else{
                project.getLogger().d("APK Builder", "Build failed, took " + time + "ms");
                compilerResult = new CompilerResult("Failed", true);
            }

        } catch (Exception e) {
            return new CompilerResult(android.util.Log.getStackTraceString(e), true);
        }
        return compilerResult;
    }

    private boolean startAaptCompiler() throws Exception{
        Compiler aapt2Compiler = new AAPT2Compiler(project);
            aapt2Compiler.setProgressListener(
                    args -> publishProgress(aapt2Compiler.getTag(), args));
            aapt2Compiler.prepare();
            aapt2Compiler.run();
        
        return aapt2Compiler.getIsCompilationSuccessful();
        
    }
    private boolean startEcjCompiler () throws Exception{
        Compiler ecjCompiler = new IncrementalECJCompiler(project);
            ecjCompiler.setProgressListener(args -> publishProgress(ecjCompiler.getTag(),args));
            ecjCompiler.prepare();
            ecjCompiler.run();
        
        return ecjCompiler.getIsCompilationSuccessful();
    }
    
    private boolean startD8Compiler() throws Exception{
        Compiler d8Compiler = new IncrementalD8Compiler(project);
            d8Compiler.setProgressListener(args -> publishProgress(d8Compiler.getTag(),args));
            d8Compiler.prepare();
            d8Compiler.run();
        
        return d8Compiler.getIsCompilationSuccessful();
    }
    
    private void startBuildApk() throws Exception{
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
                            if (!file.getName().equals("classes.dex")
                                    && file.getName().endsWith(".dex")) {
                                builder.addFile(
                                        file,
                                        Uri.parse(file.getAbsolutePath()).getLastPathSegment());
                                project.getLogger()
                                        .d(
                                                "APK Builder",
                                                "Adding dex file " + file.getName() + " to APK.");
                            }
                        }
                        for (Library library : project.getLibraries()) {
                            builder.addResourcesFromJar(new File(library.getPath(), "classes.jar"));
                            project.getLogger()
                                    .d(
                                            "APK Builder",
                                            "Adding resources of "
                                                    + library.getName()
                                                    + " to the APK");
                        }
                        builder.setDebugMode(false);
                        builder.sealApk();
    }
    
    /*public void assinarApk(Context context, File file) {
    
    String keystoreAssetPath = "keys/tempkey.jks"; // Caminho dentro dos assets
    String keystorePassword = "keyrobok";
    String keyAlias = "tempkey";
    String keyPassword = "privkeyrobok";
        
        String outFile =file.getAbsolutePath();
		String out = project.getOutputFile() + "/bin/sign.apk";

    try {
        ApkSignerUtil.signApk(context, outFile, out, keystoreAssetPath, keystorePassword, keyAlias, keyPassword);
            
        project.getLogger().e("APK Signer", "Sucess sign apk");
    } catch (Exception e) {
        e.printStackTrace();
        project.getLogger().e("APK Signer", "Error sign apk");
            
    }
}*/

    private void publishProgress(String Tag, String... updates) {
        mHandler.post(() -> {
            if (updates.length > 0) {
                String update = updates[0];
                project.getLogger().w(Tag, update);
                // Atualize sua UI com o progresso aqui
                // progress.setText(update);
            }
        });
    }

    protected void onPostExecute(CompilerResult result) {
        if (result.isError()) {
            Context context = mContext.get();
            if (context != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Compilation error");
                builder.setMessage(result.getMessage());
                builder.setPositiveButton("CLOSE", null);
                builder.create().show();
            }
        }
    }

    public void shutdown() {
        mExecutor.shutdown();
    }
    
    /*private void signedFile(final File file){
		try {
			String outFile =file.getAbsolutePath();
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/APK Signer/"));
			out = FileUtil.getExternalStorageDir().concat("/APK Signer/".concat(Uri.parse(outFile).getLastPathSegment().replace(".apk", "").concat("-signed.apk")));
			apksigner.Main.sign(file,out);
			SketchwareUtil.showMessage(getApplicationContext(), "Success - ".concat(out));
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
	}*/
    
    /*private void signFile(final File file){
		class sign_apk_file extends AsyncTask<Void, Void, Void> { 
			@Override
			protected Void doInBackground(Void... arg0) {
				try {
					String outFile =file.getAbsolutePath();
					String out = project.getOutputFile() + "/bin/generated.apk";
					// SIGN APK FILE
					apksigner.Main.sign(file,out, "testkey");
				} catch (Exception e) {
					long time = System.currentTimeMillis() - startTime;
					project.getLogger().d("APK Signer", "Sign error");
				}
				return null;
			}
			
			protected void onPreExecute() {
				
				return ;
			}
			
			protected void onPostExecute(Void result) {
			//	long time = System.currentTimeMillis() - startTime;
			//	project.getLogger().d("APK Builder", "Build success, took " + time + "ms");
                project.getLogger().d("install Apk" + file , "");
               // Apkinstaller.apk(c,file);
				try {
					FileUtil.deleteFile(project.getOutputFile() + "/bin/gen.apk");
					
					
				} catch (Exception e) {
					
				}
				return ;
			}
		}
		new sign_apk_file().execute();
	}*/
}
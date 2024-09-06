package org.robok.aapt2.compiler;

import org.robok.aapt2.util.Decompress;
import org.robok.aapt2.compiler.exception.CompilerException;
import org.robok.aapt2.compiler.exception.AAPT2CompileException;

import org.gampiot.robok.feature.util.application.RobokApplication;

import java.io.IOException;
import java.io.File;

public abstract class Compiler {

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

    public abstract void prepare();

    public abstract void run() throws CompilerException, IOException;

    public File getAndroidJarFile() {
        File check =
                new File(RobokApplication.robokContext.getFilesDir() + "/temp/android.jar");

        if (check.exists()) {
            return check;
        }

        Decompress.unzipFromAssets(
                RobokApplication.robokContext,
                "android.jar.zip",
                check.getParentFile().getAbsolutePath());

        return check;
    }

    public File getLambdaFactoryFile() {
        File check =
                new File(
                        RobokApplication.robokContext.getFilesDir()
                                + "/temp/core-lambda-stubs.jar");

        if (check.exists()) {
            return check;
        }

        Decompress.unzipFromAssets(
                RobokApplication.robokContext,
                "core-lambda-stubs.zip",
                check.getParentFile().getAbsolutePath());

        return check;
    }
}

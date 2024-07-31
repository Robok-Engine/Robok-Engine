package org.gampiot.robokide;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Process;
import android.util.Log;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.color.DynamicColors;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.gampiot.robokide.ui.activities.DebugActivity;

public class Robok extends Application {

    private static FragmentManager sFragmentManager;

    public static void init(FragmentManager fragmentManager) {
        sFragmentManager = fragmentManager;
    }

    public static String getOrientation(Context ctx) {
        Configuration configuration = ctx.getResources().getConfiguration();
        switch (configuration.orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                return "portrait";
            case Configuration.ORIENTATION_LANDSCAPE:
                return "landscape";
            default:
                return "undefined";
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("error", Log.getStackTraceString(throwable));
            startActivity(intent);
            Process.killProcess(Process.myPid());
            System.exit(1);
        });
    }

    private String getStackTrace(Throwable th) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        Throwable cause = th;
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        return result.toString();
    }
}
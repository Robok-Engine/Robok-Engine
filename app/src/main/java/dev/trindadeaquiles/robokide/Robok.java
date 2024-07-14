package dev.trindadeaquiles.robokide;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Process;

import androidx.fragment.app.FragmentManager;

import dev.trindadeaquiles.robokide.ui.activities.DebugActivity;

import com.google.android.material.color.DynamicColors;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class Robok extends Application {

    private static FragmentManager sFragmentManager;

    public static void init(FragmentManager fragmentManager) {
        sFragmentManager = fragmentManager;
    }

    public static String getOrientation(Context ctx) {
        Configuration configuration = ctx.getResources().getConfiguration();
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            return "portrait";
        } else if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return "landscape";
        } else {
            return "undefined";
        }
    }

    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    @Override
    public void onCreate() {
        this.uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread thread, Throwable ex) {
                        Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
                        Intent setFlags = intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("error", getStackTrace(ex));
                        PendingIntent pendingIntent =
                                PendingIntent.getActivity(
                                        getApplicationContext(),
                                        11111,
                                        intent,
                                        PendingIntent.FLAG_ONE_SHOT);
                        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                        am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, pendingIntent);
                        Process.killProcess(Process.myPid());
                        System.exit(2);
                        uncaughtExceptionHandler.uncaughtException(thread, ex);
                    }
                });
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }

    private String getStackTrace(Throwable th) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        Throwable cause = th;
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        final String stacktraceAsString = result.toString();
        printWriter.close();
        return stacktraceAsString;
    }
}
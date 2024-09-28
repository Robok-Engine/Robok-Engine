package org.gampiot.robok.core.utils.application;

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

import org.gampiot.robok.core.utils.activities.DebugActivity;

/*
* TO-DO: Refactor with Kotlin
*/

public class RobokApplication extends KoinApplication {

    public static RobokApplication instance;
    public static Context robokContext;
    public static FragmentManager fragmentManager;
    
    public static final int PORTRAIT = Configuration.ORIENTATION_PORTRAIT;
    public static final int LANDSCAPE = Configuration.ORIENTATION_LANDSCAPE;
    
    public static final String ERROR_TAG = "error";
        
    public RobokApplication() { }

    public RobokApplication(FragmentManager fragmentManager) {
         this.fragmentManager = fragmentManager;
    }
    
    public static int getOrientation() {
         Configuration configuration = robokContext.getResources().getConfiguration();
         return configuration.orientation;
    }
            
    @Override
    public void onCreate() {
         super.onCreate();
         instance = this;
         robokContext = getApplicationContext();
         Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
              Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
              intent.putExtra(ERROR_TAG, Log.getStackTraceString(throwable));
              startActivity(intent);
              Process.killProcess(Process.myPid());
              System.exit(1);
         });
         
         DynamicColors.applyToActivitiesIfAvailable(instance);
         
        
    }

    public String getStackTrace(Throwable cause) {
         final Writer result = new StringWriter();
         final PrintWriter printWriter = new PrintWriter(result);
         while (cause != null) {
              cause.printStackTrace(printWriter);
              cause = cause.getCause();
         }
         printWriter.close();
         return result.toString();
    }
}
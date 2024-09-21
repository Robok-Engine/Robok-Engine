package org.robok.model3d.debug;

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

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class Applications extends Application {
	private Thread.UncaughtExceptionHandler uncaughtExceptionHandler; public static int i = 41;
	@Override
	public void onCreate() {
		this.uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread thread, Throwable ex) {
				Intent intent = new Intent(getApplicationContext(), DebugActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				intent.putExtra("error", getStackTrace(ex));
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 11111, intent, PendingIntent.FLAG_ONE_SHOT);
				AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
				am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, 1000, pendingIntent);
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(2);
				uncaughtExceptionHandler.uncaughtException(thread, ex);
			}
		});
		super.onCreate();
	}
	private String getStackTrace(Throwable th){
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		Throwable cause = th;
		while(cause != null){
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		final String stacktraceAsString = result.toString();
		printWriter.close();
		return stacktraceAsString;
	}
}

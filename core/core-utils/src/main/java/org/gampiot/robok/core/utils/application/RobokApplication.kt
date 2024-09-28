package org.gampiot.robok.core.utils.application

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

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Process
import android.util.Log

import com.google.android.material.color.DynamicColors

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

import org.gampiot.robok.core.utils.activities.DebugActivity
import org.gampiot.robok.core.utils.di.appModule
import org.gampiot.robok.core.utils.di.appPreferencesModule

import java.io.PrintWriter
import java.io.StringWriter
import java.io.Writer

class RobokApplication : Application() {

    companion object {
        lateinit var instance: RobokApplication
        lateinit var robokContext: Context
        const val ERROR_TAG = "error"
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        robokContext = applicationContext
        configureKoin()
        configureCrashHandler()
        DynamicColors.applyToActivitiesIfAvailable(instance)
    }
    
    fun configureCrashHandler() {
         Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            val intent = Intent(applicationContext, DebugActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra(ERROR_TAG, Log.getStackTraceString(throwable))
            }
            startActivity(intent)
            Process.killProcess(Process.myPid())
            System.exit(1)
        }
    }
    
    fun configureKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RobokApplication)
            modules(
                appModule,
                appPreferencesModule
            )
        }
    }

    fun getStackTrace(cause: Throwable?): String {
        val result: Writer = StringWriter()
        PrintWriter(result).use { printWriter ->
            var throwable: Throwable? = cause
            while (throwable != null) {
                throwable.printStackTrace(printWriter)
                throwable = throwable.cause
            }
        }
        return result.toString()
    }
}
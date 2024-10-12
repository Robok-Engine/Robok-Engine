package org.robok.engine

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
import java.io.PrintWriter
import java.io.StringWriter
import java.io.Writer
import kotlin.system.exitProcess
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.robok.engine.di.appModule
import org.robok.engine.di.appPreferencesModule
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.ui.activities.debug.AppFailureActivity

/*
 * A Class for basic application management.
 */
class RobokApplication : Application() {

    companion object {
        // Do not place Android context classes in static fields (static reference to
        // RobokApplication which has field robokContext pointing to Context); this is a memory leak
        lateinit var instance: RobokApplication /* Instance of this class  */
        lateinit var robokContext: Context /* A Context of this class */
        const val ERROR_TAG = "error" /* a tag for send error to DebugScreen */
    }

    private lateinit var appPrefsViewModel: AppPreferencesViewModel

    override fun onCreate() {
        super.onCreate()
        instance = this
        robokContext = applicationContext
        configureKoin()
        configureCrashHandler()
    }

    /*
     * Function that configures the error manager.
     */
    fun configureCrashHandler() {
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            val intent =
                Intent(applicationContext, AppFailureActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra(ERROR_TAG, Log.getStackTraceString(throwable))
                }
            startActivity(intent)
            Process.killProcess(Process.myPid())
            exitProcess(1)
        }
    }

    /*
     * Function that configures Koin for Dependency Injection.
     */
    fun configureKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RobokApplication)
            modules(appModule, appPreferencesModule)
        }
    }

    /*
     * Function to get the stack trace.
     */
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

internal fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}

package org.robok.engine

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

import android.app.Application
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
import org.robok.engine.di.AboutModule
import org.robok.engine.di.DatabaseModule
import org.robok.engine.di.EditorModule
import org.robok.engine.di.GeneralModule
import org.robok.engine.di.PreferencesModule
import org.robok.engine.di.ProjectModule
import org.robok.engine.di.SettingsModule
import org.robok.engine.ui.activities.debug.AppFailureActivity

/*
 * A Class for basic application management.
 */
class RobokApplication : Application() {

  companion object {
    const val ERROR_TAG = "error" /* a tag for send error to DebugScreen */
    private var instance: RobokApplication? = null

    @JvmStatic
    @Synchronized
    fun getInstance(): RobokApplication {
      if (instance == null) {
        instance = RobokApplication()
      }

      return instance!!
    }
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
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
      modules(
        AboutModule,
        DatabaseModule,
        EditorModule,
        GeneralModule,
        PreferencesModule,
        ProjectModule,
        SettingsModule,
      )
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

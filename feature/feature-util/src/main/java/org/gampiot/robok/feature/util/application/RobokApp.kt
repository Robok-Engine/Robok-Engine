package org.gampiot.robok.feature.util.application

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Process
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.google.android.material.color.DynamicColors
import org.gampiot.robok.feature.util.activities.DebugActivity

class RobokApp : Application() {

    companion object {
        private lateinit var sInstance: RobokApp
        private var sFragmentManager: FragmentManager? = null
        lateinit var applicationContext: Context

        fun init(fragmentManager: FragmentManager) {
            sFragmentManager = fragmentManager
        }

        fun getOrientation(ctx: Context): String {
            val configuration = ctx.resources.configuration
            return when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> "portrait"
                Configuration.ORIENTATION_LANDSCAPE -> "landscape"
                else -> "undefined"
            }
        }

        fun getApp(): RobokApp {
            return sInstance
        }

        fun getFragmentManager(): FragmentManager? {
            return sFragmentManager
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        applicationContext = this
        DynamicColors.applyToActivitiesIfAvailable(this)  // Esta linha deve estar correta

        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            val intent = Intent(applicationContext, DebugActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra("error", Log.getStackTraceString(throwable))
            }
            startActivity(intent)
            Process.killProcess(Process.myPid())
            System.exit(1)
        }
    }
}

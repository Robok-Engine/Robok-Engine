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

    private lateinit var sInstance: RobokApp
    private var sFragmentManager: FragmentManager? = null
    lateinit var applicatinContext: Context

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        applicatinContext = this
        DynamicColors.applyToActivitiesIfAvailable(this)

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

    fun init(fragmentManager: FragmentManager) {
        sFragmentManager = fragmentManager
    }

    fun getOrientation(ctx: Context): Int {
        val configuration = ctx.resources.configuration
        return when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 0
            Configuration.ORIENTATION_LANDSCAPE -> 1
            else -> 0
        }
    }

    fun getApp(): RobokApp {
        return sInstance
    }

    fun getFragmentManager(): FragmentManager? {
        return sFragmentManager
    }

    companion object {
        // Singleton pattern to provide global access to the instance
        @Volatile
        private var INSTANCE: RobokApp? = null

        fun getInstance(context: Context): RobokApp {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: (context.applicationContext as RobokApp).also { INSTANCE = it }
            }
        }
    }
}

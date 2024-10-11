package org.robok.engine.ui.theme

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.color.DynamicColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoin
import org.robok.engine.R
import org.robok.engine.RobokApplication
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel

/**
 * A helper for applying the correct theme in the app, managing XML themes.
 *
 * This class uses ViewModel to handle theme-related settings.
 *
 * @author Aquiles Trindade
 */
class XMLThemeManager(
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
) {
    const val TAG = "XMLThemeManager"
    private lateinit var appPrefsViewModel: AppPreferencesViewModel

    /**
     * Applies the theme based on user settings.
     *
     * @param activity An instance of an Activity.
     */
    fun apply(activity: Activity) {
        init()

        // Apply themes based on user preferences
        coroutineScope.launch {
            val useMonet = appPrefsViewModel.appIsUseMonet.first()
            val useAmoled = appPrefsViewModel.appIsUseAmoled.first()
            val isDarkMode =
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
                
            Log.d(TAG, useMonet.toString())
            Log.d(TAG, useAmoled.toString())
            Log.d(TAG, isDarkMode.toString())
                
            // Apply AMOLED theme only if dark mode is enabled and user has enabled AMOLED
            if (isDarkMode && useAmoled) {
                if (useMonet) {
                    activity.setTheme(R.style.Theme_Robok_Amoled_Monet)
                    Log.d(TAG, "Amoled Monet Theme Set")
                    return@launch
                }
                activity.setTheme(R.style.Theme_Robok_Amoled)
                Log.d(TAG, "Amoled Theme Set")
                return@launch
            }
            // Apply Monet theme if AMOLED not used but Monet is enabled
            if (useMonet) {
                DynamicColors.applyToActivityIfAvailable(activity)
                Log.d(TAG, "Monet Theme Set")
            }
        }
    }

    /** Initialize ViewModel. */
    private fun init() {
        appPrefsViewModel = RobokApplication.instance.getKoin().get()
    }

    /**
     * Returns the current theme.
     *
     * @param ctx The context from which to get the theme.
     */
    fun getCurrentTheme(ctx: Context): Resources.Theme? = ctx.theme
}

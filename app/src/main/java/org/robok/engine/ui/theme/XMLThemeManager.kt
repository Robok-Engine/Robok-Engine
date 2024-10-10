package org.robok.engine.ui.theme

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.color.DynamicColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.getKoin
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel

/**
 * A helper for applying the correct theme in the app, managing XML themes.
 *
 * This class uses ViewModel to handle theme-related settings.
 * 
 * @author Aquiles Trindade
 */
class XMLThemeManager(private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)) {

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
            val useMonet = appPrefsViewModel.appIsUseMonet.value
            val useAmoled = appPrefsViewModel.appIsUseAmoled.value
            val isDarkMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

            // Apply AMOLED theme only if dark mode is enabled and user has enabled AMOLED
            if (isDarkMode && useAmoled) {
                if (useMonet) {
                    activity.setTheme(R.style.Theme_Robok_Oled_Monet)
                } else {
                    activity.setTheme(R.style.Theme_Robok_Oled)
                }
            } else if (useMonet) {
                // Apply Monet theme if AMOLED not used but Monet is enabled
                DynamicColors.applyToActivityIfAvailable(activity)
            }
        }
    }

    /**
     * Initialize ViewModel.
     */
    private fun init() {
        appPrefsViewModel = getKoin().get()
    }

    /**
     * Returns the current theme.
     *
     * @param ctx The context from which to get the theme.
     */
    fun getCurrentTheme(ctx: Context): Resources.Theme? = ctx.theme
}
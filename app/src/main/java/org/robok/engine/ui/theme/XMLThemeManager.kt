package org.robok.engine.ui.theme

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.google.android.material.color.DynamicColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import org.koin.android.ext.android.getKoin
import org.robok.engine.R
import org.robok.engine.RobokApplication
import org.robok.engine.feature.settings.viewmodels.AppPreferencesViewModel
import org.robok.engine.ui.activities.base.RobokActivity

/**
 * A helper for applying the correct theme in the app, managing XML themes.
 *
 * This class uses ViewModel to handle theme-related settings.
 *
 * @author Aquiles Trindade
 */
const val TAG = "XMLThemeManager"

class XMLThemeManager(
  private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
) {

  private lateinit var appPrefsViewModel: AppPreferencesViewModel

  /**
   * Applies the theme based on user settings.
   *
   * @param activity An instance of an Activity.
   *
   * Runs on main thread
   */
  suspend fun apply(activity: RobokActivity) {
    init()

    // Apply themes based on user preferences
    val useMonet = appPrefsViewModel.appIsUseMonet.first()
    val useAmoled = appPrefsViewModel.appIsUseAmoled.first()

    Log.d(TAG, useMonet.toString())
    Log.d(TAG, useAmoled.toString())
    Log.d(TAG, activity.isDarkMode().toString())

    // Apply AMOLED theme only if dark mode is enabled and user has enabled AMOLED
    if (activity.isDarkMode() && useAmoled) {
      if (useMonet) {
        activity.setTheme(R.style.Theme_Robok_Amoled_Monet)
        Log.d(TAG, "Amoled Monet Theme Set")
        return
      }
      activity.setTheme(R.style.Theme_Robok_Amoled)
      Log.d(TAG, "Amoled Theme Set")
      return
    }
    // Apply Monet theme if AMOLED not used but Monet is enabled
    if (useMonet) {
      DynamicColors.applyToActivityIfAvailable(activity)
      Log.d(TAG, "Monet Theme Set")
    }
  }

  /** Initialize ViewModel. */
  private fun init() {
    appPrefsViewModel = RobokApplication.getInstance().getKoin().get()
  }

  /**
   * Returns the current theme.
   *
   * @param ctx The context from which to get the theme.
   */
  fun getCurrentTheme(ctx: Context): Resources.Theme? = ctx.theme
}

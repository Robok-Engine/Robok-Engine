package org.robok.engine.ui.theme

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.google.android.material.color.DynamicColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import org.koin.android.ext.android.getKoin
import org.robok.engine.Styles
import org.robok.engine.RobokApplication
import org.robok.engine.core.settings.viewmodels.PreferencesViewModel
import org.robok.engine.ui.base.BaseActivity

/**
 * A helper for applying the correct theme in the app, managing XML themes.
 *
 * This class uses ViewModel to handle theme-related settings.
 *
 * @author Aquiles Trindade
 */
const val TAG = "XMLThemeManager"

class XMLThemeManager private constructor() {

  companion object {
    private var instance: XMLThemeManager? = null

    @JvmStatic
    fun getInstance(): XMLThemeManager {
      if (instance == null) instance = XMLThemeManager()
      return instance!!
    }
  }

  private lateinit var appPrefsViewModel: PreferencesViewModel

  /**
   * Applies the theme based on user settings.
   *
   * @param activity An instance of an Activity.
   *
   * Runs on main thread
   */
  suspend fun apply(activity: BaseActivity) {
    init()

    val useMonet = appPrefsViewModel.appIsUseMonet.first()
    val useAmoled = appPrefsViewModel.appIsUseAmoled.first()

    if (activity.isDarkMode() && useAmoled) {
      if (useMonet) {
        activity.setTheme(Styles.Theme_Robok_Amoled_Monet)
        return
      }
      activity.setTheme(Styles.Theme_Robok_Amoled)
      return
    }

    if (useMonet) {
      DynamicColors.applyToActivityIfAvailable(activity)
      Log.d(TAG, "Monet Theme Set")
    }
  }

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

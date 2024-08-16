package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.core.splashscreen.SplashScreen

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.ui.fragments.home.HomeFragment
import org.gampiot.robok.feature.util.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = SplashScreen.installSplashScreen(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentLayoutResId(R.id.fragment_container)
        splashScreen.setKeepOnScreenCondition { isSomeCondition() }
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X))
            //For setOverrideLocaleConfig
val localeManager = applicationContext
    .getSystemService(LocaleManager::class.java)
localeManager.overrideLocaleConfig = LocaleConfig(
LocaleList.forLanguageTags("en-US,ar,fr,es-ES,pt-BR")
)

//For getOverrideLocaleConfig
// The app calls the API to get the override LocaleConfig
val overrideLocaleConfig = localeManager.overrideLocaleConfig
// If the returned overrideLocaleConfig isn't equal to NULL, then the app calls the API to get the supported Locales
val supportedLocales = overrideLocaleConfig.supportedLocales()
        }
    }
    
    fun isSomeCondition(): Boolean {
        return false
    }
}
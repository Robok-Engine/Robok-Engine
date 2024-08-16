package org.gampiot.robok.ui.activities

import android.os.Bundle
import android.os.LocaleList
import android.os.LocaleConfig
import android.content.LocaleManager

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.ui.fragments.home.HomeFragment
import org.gampiot.robok.feature.util.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentLayoutResId(R.id.fragment_container)
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X))
            localeConfigTest()
        }
    }

    fun localeConfigTest() {
        val localeManager = applicationContext
            .getSystemService(LocaleManager::class.java)

        val localeConfig = LocaleConfig(
            LocaleList.forLanguageTags("en-US,ar,fr,es-ES,pt-BR")
        )
        
        localeManager.overrideLocaleConfig = localeConfig
        val overrideLocaleConfig = localeManager.overrideLocaleConfig
        val supportedLocales = overrideLocaleConfig.supportedLocales
    }
}

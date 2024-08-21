package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.annotation.IdRes 
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.ui.fragments.home.HomeFragment
import org.gampiot.robok.feature.util.base.RobokMainActivity

class MainActivity() : RobokMainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        
        if (savedInstanceState == null) {
            openFragment(HomeFragment())
        }
    }
}
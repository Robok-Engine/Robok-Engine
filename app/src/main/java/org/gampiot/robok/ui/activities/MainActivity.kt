package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.annotation.IdRes 
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.ui.fragments.home.HomeFragment
import org.gampiot.robok.feature.util.base.RobokActivity

class MainActivity() : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        installSplashScreen()
        
        if (savedInstanceState == null) {
            openFragment(HomeFragment())
        }
    }
}
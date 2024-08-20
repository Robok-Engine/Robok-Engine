package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.ui.fragments.home.HomeFragment
import org.gampiot.robok.feature.util.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X, R.id.fragment_container))
        }
    }
}
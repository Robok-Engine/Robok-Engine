package org.gampiot.robok.feature.util.activities

import android.os.Bundle

import androidx.annotation.IdRes 
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.feature.util.R

/*
   I don't like leaving the MainActivity here at all, but it's to avoid errors.
*/

class RobokMainActivity() : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
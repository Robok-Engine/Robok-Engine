package dev.trindadeaquiles.robokide.ui.activities

import android.os.Bundle

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindadeaquiles.robokide.R
import dev.trindadeaquiles.robokide.ui.fragments.home.HomeFragment
import dev.trindadeaquiles.robokide.ui.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X))
        }
        
    }
}
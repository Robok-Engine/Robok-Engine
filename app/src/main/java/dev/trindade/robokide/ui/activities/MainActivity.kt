package dev.trindade.robokide.ui.activities

import android.os.Bundle

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.fragments.home.HomeFragment
import dev.trindade.robokide.ui.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.Y))
        }
        
    }
}
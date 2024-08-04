package org.gampiot.robokide.ui.activities

import android.os.Bundle

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robokide.R
import org.gampiot.robokide.ui.fragments.home.HomeFragment
import org.gampiot.robokide.feature.util.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragmentLayoutResId(binding.fragmentContainer.id)
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X))
        }
        
    }
}
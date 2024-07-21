package com.robok.ide.ui.activities

import android.os.Bundle

import com.google.android.material.transition.MaterialSharedAxis

import com.robok.ide.R
import com.robok.ide.ui.fragments.home.HomeFragment
import com.robok.ide.ui.base.RobokActivity

class MainActivity : RobokActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            openFragment(HomeFragment(MaterialSharedAxis.X))
        }
        
    }
}
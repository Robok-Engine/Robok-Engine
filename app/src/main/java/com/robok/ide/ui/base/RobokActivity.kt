package com.robok.ide.ui.base

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis
import com.google.android.material.appbar.MaterialToolbar

import com.robok.ide.R
import com.robok.ide.manage.file.requestPermission
import com.robok.ide.utils.getBackPressedClickListener

open class RobokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPerms()
    }
    
    fun openFragment (fragment: Fragment) {
        supportFragmentManager.commit {
             replace(R.id.fragment_container, fragment)
        }
    }
    
    fun openCustomFragment (layoutId: Int, fragment: Fragment) {
        supportFragmentManager.commit {
             replace(layoutId, fragment)
        }
    }
    
    fun requestPerms() {
        requestPermission(this)
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(this))
    }
}
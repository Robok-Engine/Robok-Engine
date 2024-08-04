package org.gampiot.robokide.feature.util.base

import android.os.Bundle

import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import androidx.annotation.IdRes

import com.google.android.material.appbar.MaterialToolbar

import org.gampiot.robokide.feature.util.requestPermission
import org.gampiot.robokide.feature.util.getBackPressedClickListener

open class RobokActivity : AppCompatActivity() {

    @IdRes var layoutResId: Int = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         requestPermissions()
    }
    
    fun openFragment(fragment: Fragment) {
         supportFragmentManager.commit {
             replace(layoutResId, fragment)
         }
    }
    
    fun openCustomFragment(@IdRes layoutResId: Int, fragment: Fragment) {
         supportFragmentManager.commit {
             replace(layoutResId, fragment)
         }
    }
    
    fun requestPermissions() {
         requestPermission(this)
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
         toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
    
    fun setLayoutResId (@IdRes layoutResId: Int) {
         this.layoutResId = layoutResId
    }
    
    fun getLayoutResId () : Int {
         return layoutResId;
    }
}
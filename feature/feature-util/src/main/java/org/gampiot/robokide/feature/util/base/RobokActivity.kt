package org.gampiot.robokide.feature.util.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager

import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import androidx.annotation.IdRes

import com.google.android.material.appbar.MaterialToolbar

import org.gampiot.robokide.feature.util.requestPermission
import org.gampiot.robokide.feature.util.getBackPressedClickListener
import org.gampiot.robokide.feature.util.ResUtils;

open class RobokActivity : AppCompatActivity() {

    @IdRes var layoutResId: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         requestPermissions()
         configureWindow()
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
    
    fun configureWindow() {
         val resUtils = ResUtils(this)
         val colorBg = resUtils.getAttrColor(android.R.attr.colorBackground)
         window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
         window.statusBarColor = colorBg
         window.navigationBarColor = colorBg
         window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
    
    fun configureToolbarNavigationBack(toolbar: MaterialToolbar) {
         toolbar.setNavigationOnClickListener(getBackPressedClickListener(onBackPressedDispatcher))
    }
    
    fun setFragmentLayoutResId (@IdRes layoutResId: Int) {
         this.layoutResId = layoutResId
    }
    
    fun getFragmentLayoutResId () : Int {
         return layoutResId;
    }
}
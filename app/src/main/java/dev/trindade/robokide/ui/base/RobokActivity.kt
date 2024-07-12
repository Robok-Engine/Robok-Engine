package dev.trindade.robokide.ui.base

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment

import com.google.android.material.transition.MaterialSharedAxis

import dev.trindade.robokide.R
import dev.trindade.robokide.manage.file.requestPermission
import dev.trindade.robokide.utils.getBackPressedClickListener

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
        toolbar.setNavigationOnClickListener(getBackPressedClickListener(requireActivity()))
    }
}
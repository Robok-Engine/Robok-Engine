package dev.trindade.robokide.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import dev.trindade.robokide.R
import dev.trindade.robokide.manage.file.requestPermission

open class MainActivity : AppCompatActivity() {

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
    
    fun requestPerms() {
        requestPermission(this)
    }
}
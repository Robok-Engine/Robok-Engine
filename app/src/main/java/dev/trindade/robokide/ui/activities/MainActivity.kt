package dev.trindade.robokide.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.fragments.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val path = "Parameter path to pass"
        
        if (savedInstanceState == null) {
            val fragment = MainFragment.newInstance(path)
            supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
            }
        }
    }
}
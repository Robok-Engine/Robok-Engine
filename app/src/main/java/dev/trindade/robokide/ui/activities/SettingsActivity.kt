package dev.trindade.robokide.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.fragments.settings.SettingsFragment

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        
        if (savedInstanceState == null) {
            val fragment = SettingsFragment()
            
            supportFragmentManager.commit {
                replace(R.id.settings_fragment_container, fragment)
            }
        }
    }
}
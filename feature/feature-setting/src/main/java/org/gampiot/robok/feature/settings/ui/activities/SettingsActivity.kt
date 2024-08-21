package org.gampiot.robok.feature.settings.ui.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import org.gampiot.robok.feature.settings.R
import org.gampiot.robok.feature.settings.databinding.ActivitySettingsBinding
import org.gampiot.robok.feature.settings.ui.fragments.SettingsFragment
import org.gampiot.robok.feature.util.base.RobokActivity

class SettingsActivity : RobokActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        openFragment(SettingsFragment())
    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.settingFragmentContainer.id, fragment)
            .commit()
    }
}

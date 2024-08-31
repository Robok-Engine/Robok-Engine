package org.gampiot.robok.ui.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import org.gampiot.robok.R
import org.gampiot.robok.databinding.ActivitySettingsBinding
import org.gampiot.robok.feature.util.base.RobokActivity
import org.gampiot.robok.feature.component.log.Log

class SettingsActivity : RobokActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.addView(Log(requireContext(), "Not Ready"))
    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.settingFragmentContainer.id, fragment)
            .commit()
    }
}

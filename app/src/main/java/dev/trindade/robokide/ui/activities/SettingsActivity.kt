package dev.trindade.robokide.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.appbar.MaterialToolbar

import dev.trindade.robokide.R
import dev.trindade.robokide.databinding.ActivitySettingsBinding
import dev.trindade.robokide.ui.fragments.settings.SettingsFragment
import dev.trindade.robokide.utils.getBackPressedClickListener

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationBack(binding.toolbar)
        if (savedInstanceState == null) {
            val fragment = SettingsFragment()
            supportFragmentManager.commit {
                replace(R.id.settings_fragment_container, fragment)
            }
        }
    }

    fun setToolbarTitle(value: String) {
        binding.toolbar.title = value
    }

    private fun navigationBack(toolbar: MaterialToolbar) {
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
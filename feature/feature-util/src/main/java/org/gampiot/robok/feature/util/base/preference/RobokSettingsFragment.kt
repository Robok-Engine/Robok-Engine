package org.gampiot.robok.feature.util.base.preference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.annotation.IdRes

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.util.databinding.FragmentTopSettingsBinding
import org.gampiot.robok.feature.util.base.RobokFragment

abstract class RobokSettingsFragment(
     private val settingsTitle: Int,
     private val fragmentCreator: () -> Fragment
): RobokFragment() {

    private lateinit var binding: FragmentTopSettingsBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View? {
	    binding = FragmentTopSettingsBinding.inflate(layoutInflater)
		binding.collapsingToolbar.title = getString(settingsTitle)
		
		binding.toolbar.setNavigationOnClickListener {
			requireActivity().supportFragmentManager.popBackStack()
		}

		childFragmentManager
			.beginTransaction()
			.addToBackStack(System.currentTimeMillis().toString())
			.add(binding.settingFragmentContainerBase.id, fragmentCreator())
			.commit()

		return binding.root
	}
}

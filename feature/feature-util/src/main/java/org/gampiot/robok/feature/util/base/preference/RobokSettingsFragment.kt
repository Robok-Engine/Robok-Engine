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
import org.gampiot.robok.feature.util.base.RobokFragment

abstract class RobokSettingsFragment(
     private val settingsTitle: Int,
     private val fragmentCreator: () -> Fragment
): RobokFragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View? {
		val rootView = inflater.inflate(R.layout.fragment_top_settings, container, false)
		val topAppBar = rootView.findViewById<MaterialToolbar>(R.id.topAppBar)
		val collapsingToolbar =
			rootView.findViewById<CollapsingToolbarLayout>(R.id.collapsingtoolbar)

		/* rootView.findViewById<AppBarLayout>(R.id.appbarlayout).enableEdgeToEdgePaddingListener() */
		collapsingToolbar.title = getString(settingsTitle)

		topAppBar.setNavigationOnClickListener {
			requireActivity().supportFragmentManager.popBackStack()
		}

		childFragmentManager
			.beginTransaction()
			.addToBackStack(System.currentTimeMillis().toString())
			.add(R.id.settings, fragmentCreator())
			.commit()

		return rootView
	}
}

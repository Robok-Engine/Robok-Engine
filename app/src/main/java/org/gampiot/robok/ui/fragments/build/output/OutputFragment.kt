package org.gampiot.robok.ui.fragments.build.output

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes 

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentOutputBinding
import org.gampiot.robok.feature.component.log.Log
import org.gampiot.robok.feature.util.base.RobokFragment

class OutputFragment () : RobokFragment() {

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding.toolbar)
    }
    
    fun addOutput(context: Context, inflater: LayoutInflater, container: ViewGroup?, log: String) {
        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        val logView = Log(context, log)
        binding.content.addView(logView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
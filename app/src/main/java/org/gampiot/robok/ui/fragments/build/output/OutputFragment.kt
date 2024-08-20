package org.gampiot.robok.ui.fragments.build.output

import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes 

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentOutputBinding
import org.gampiot.robok.feature.component.log.Log
import org.gampiot.robok.feature.util.base.RobokFragment

class OutputFragment (
    private val tansitionAxis : Int = MaterialSharedAxis.X,
    @IdRes private val fragmentLayoutResId: Int = 0
) : RobokFragment(tansitionAxis, fragmentLayoutResId) {

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
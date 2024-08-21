package org.gampiot.robok.ui.fragments.editor.diagnostic

import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes 

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentEditorDiagnosticBinding
import org.gampiot.robok.feature.component.log.Log
import org.gampiot.robok.feature.util.base.RobokFragment

class DiagnosticFragment (
    private val tansitionAxis : Int = MaterialSharedAxis.X
) : RobokFragment(tansitionAxis) {

    private var _binding: FragmentEditorDiagnosticBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditorDiagnosticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    
    fun addDiagnostic(context: Context, inflater: LayoutInflater, container: ViewGroup?, log: String) {
        _binding = FragmentEditorDiagnosticBinding.inflate(inflater, container, false)
        val logView = Log(context, log)
        binding.content.addView(logView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
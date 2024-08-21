package org.gampiot.robok.ui.fragments.editor.logs

import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.IdRes

import com.google.android.material.transition.MaterialSharedAxis

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentEditorLogsBinding
import org.gampiot.robok.feature.component.log.Log
import org.gampiot.robok.feature.util.base.RobokFragment

class LogsFragment (
    private val tansitionAxis : Int = MaterialSharedAxis.X
) : RobokFragment(tansitionAxis) {

    private var _binding: FragmentEditorLogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditorLogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    
    fun addLog(context: Context, inflater: LayoutInflater, container: ViewGroup?, log: String) {
        _binding = FragmentEditorLogsBinding.inflate(inflater, container, false)
        val logView = Log(context, log)
        binding.content.addView(logView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
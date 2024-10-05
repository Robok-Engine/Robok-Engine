package org.robok.engine.ui.activities.editor.diagnostic

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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import org.robok.engine.R
import org.robok.engine.databinding.FragmentEditorDiagnosticBinding
import org.robok.engine.ui.activities.editor.diagnostic.models.DiagnosticItem
import org.robok.engine.ui.activities.editor.diagnostic.adapters.DiagnosticsAdapter

class DiagnosticFragment(private val diagnostics: List<DiagnosticItem>) : Fragment() {

    private var _binding: FragmentEditorDiagnosticBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, 
        container: ViewGroup?, 
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditorDiagnosticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = DiagnosticsAdapter(diagnostics)
    }

    fun getDiagnostics(): List<DiagnosticItem> = diagnostics

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package org.gampiot.robok.ui.activities.editor.diagnostic;

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

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.FragmentEditorDiagnosticBinding;
import org.gampiot.robok.core.utils.base.RobokFragment;
import org.gampiot.robok.ui.activities.editor.diagnostic.models.DiagnosticItem;
import org.gampiot.robok.ui.activities.editor.diagnostic.adapters.DiagnosticsAdapter;

import java.util.List;
import java.util.ArrayList;

public class DiagnosticFragment extends RobokFragment {

     public FragmentEditorDiagnosticBinding binding;
     private List<DiagnosticItem> diagnostics;
     
     public DiagnosticFragment(List<DiagnosticItem> diagnostics) {
          this.diagnostics = diagnostics;
     }

     @Nullable
     @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          binding = FragmentEditorDiagnosticBinding.inflate(LayoutInflater.from(requireContext()), container, false);
          return binding.getRoot();
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated(view, savedInstanceState);
          binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
          binding.recyclerView.setAdapter(new DiagnosticsAdapter(diagnostics));
     }
    
     public List<DiagnosticItem> getDiagnostics() {
          return diagnostics;
     }
}
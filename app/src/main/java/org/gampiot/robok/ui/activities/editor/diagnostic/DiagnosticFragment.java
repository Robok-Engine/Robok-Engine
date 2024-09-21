package org.gampiot.robok.ui.activities.editor.diagnostic;

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
import org.gampiot.robok.feature.util.base.RobokFragment;
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
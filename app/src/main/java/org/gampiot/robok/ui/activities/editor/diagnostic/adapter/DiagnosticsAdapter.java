package org.gampiot.robok.ui.activities.editor.diagnostic.adapters;

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

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.LayoutDiagnosticItemBinding;
import org.gampiot.robok.ui.activities.editor.diagnostic.models.DiagnosticItem;

import java.util.List;

public class DiagnosticsAdapter extends RecyclerView.Adapter<DiagnosticsAdapter.ViewHolder> {
     
     private List<DiagnosticItem> listData;
     private Context context; 
     
     public DiagnosticsAdapter(List<DiagnosticItem> listData) {
          this.listData = listData;
     }
     
     @Override
     public ViewHolder onCreateViewHolder(ViewGroup prt, int vt) {
          LayoutDiagnosticItemBinding binding = LayoutDiagnosticItemBinding.inflate(LayoutInflater.from(prt.getContext()), prt, false);
          return new ViewHolder(binding, prt.getContext());
     }
     
     @Override
	 public void onBindViewHolder (ViewHolder holder, int position) {
	      DiagnosticItem item = listData.get(position);
	      holder.views.name.setText(item.getName());
	      holder.views.description.setText(item.getDescription());
	      holder.views.icon.setImageResource(handleTypes(item.getType()));
	      context = holder.context;
	 }
	 
	 @Override
	 public int getItemCount() {
	      return listData.size();
	 }
	 
	 @IdRes
	 public int handleTypes(int t) {
	      switch (t) {
	          case 0:
	             return R.drawable.ic_warning_24;
	          case 1:
	             return R.drawable.ic_error_24;
	          default: 
	             return R.drawable.ic_warning_24;
	      }
	 }
	 
	 public static class ViewHolder extends RecyclerView.ViewHolder {
          private final LayoutDiagnosticItemBinding views;
          public Context context;
          
          public ViewHolder(@NonNull LayoutDiagnosticItemBinding binding, Context context) {
               super(binding.getRoot());
               this.context = context;
               views = binding;
          }
     }
}
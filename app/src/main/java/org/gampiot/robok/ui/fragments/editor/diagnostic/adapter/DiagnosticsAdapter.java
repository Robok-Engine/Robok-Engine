package org.gampiot.robok.ui.fragments.editor.diagnostic.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gampiot.robok.databinding.LayoutDiagnosticItemBinding;
import org.gampiot.robok.ui.fragments.editor.diagnostic.models.DiagnosticItem;

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
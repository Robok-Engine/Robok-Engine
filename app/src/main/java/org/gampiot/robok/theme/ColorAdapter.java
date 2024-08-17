package org.gampiot.robok.theme;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.LayoutColorItemBinding;

import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

      public final List<Integer> colorArray;
      protected int checkedPosition = -1;

      public ColorAdapter(List<Integer> colorArray) {
           this.colorArray = colorArray;
           setHasStableIds(true);
      }
 
      public void setCheckedPosition(Theme value) {
           int lastCheckedPosition = checkedPosition;
           checkedPosition = value.ordinal();
           notifyItemChanged(lastCheckedPosition);
           notifyItemChanged(checkedPosition);
      }
      
      @Override
      public long getItemId(int position) {
           return colorArray.get(position);
      }
      
      @Override
      public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           return new ViewHolder(
                 LayoutColorItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
      }
      
      @Override
      public void onBindViewHolder(ViewHolder holder, int position) {
           with(holder.binding, position);
      }
      
      public void with(LayoutColorItemBinding binding, int position) {
           binding.colorView.setBackgroundColorRes(colorArray.get(position));
           binding.colorView.setImageResource(checkedPosition == position ? R.drawable.ic_round_check : 0);
      }
      
      @Override
      public int getItemCount() {
           return colorArray.size();
      }
      
      public class ViewHolder extends RecyclerView.ViewHolder {
           public final LayoutColorItemBinding binding;
           
           public ViewHolder(LayoutColorItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
                binding.colorView.setOnClickListener(v -> {
                     int lastCheckedPosition = checkedPosition;
                     checkedPosition = getAdapterPosition();
                     binding.colorView.setImageResource(R.drawable.ic_round_check);
                     notifyItemChanged(lastCheckedPosition);
                });
           }
      }
      
      public int getCheckedPosition() {
           return this.checkedPosition;
      }
}

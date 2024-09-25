package org.robok.aapt2.logger;

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
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.widget.FrameLayout;

import androidx.recyclerview.widget.RecyclerView;
import android.text.SpannableStringBuilder;

import java.util.List;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {
    
	private List<Log> mData;
	
	public LogAdapter(List<Log> data) {
		mData = data;
	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new ViewHolder(new FrameLayout(parent.getContext()));
	}
	
	@Override
	public void onBindViewHolder (ViewHolder holder, int position) {
		Log log = mData.get(position);
		
		SpannableStringBuilder sb = new SpannableStringBuilder();
	//	sb.append("[");
		sb.append(log.getTag());
	//	sb.append("]");
		sb.append(" ");
		sb.append(log.getMessage());
		
		holder.mText.setText(sb);
	}
	
	@Override
	public int getItemCount() {
		return mData.size();
	}
	
	public static class ViewHolder extends RecyclerView.ViewHolder {
	    
		public TextView mText;
		
		public ViewHolder(View view) {
			super(view);
			
			mText = new TextView(view.getContext());
			mText.setTextIsSelectable(true);
			((ViewGroup) view).addView(mText);
		}
	}
}
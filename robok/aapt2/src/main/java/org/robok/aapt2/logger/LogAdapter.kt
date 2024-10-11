package org.robok.aapt2.logger

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

import android.text.SpannableStringBuilder
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LogAdapter(private val mData: List<Log>) : RecyclerView.Adapter<LogAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FrameLayout(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val log = mData[position]

        val sb =
            SpannableStringBuilder().apply {
                // append("[")
                append(log.tag)
                // append("]")
                append(" ")
                append(log.message)
            }

        holder.mText.text = sb
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mText: TextView =
            TextView(view.context).apply {
                setTextIsSelectable(true)
                (view as ViewGroup).addView(this)
            }
    }
}

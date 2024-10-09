package org.robok.engine.ui.activities.editor.diagnostic.adapters

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

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import org.robok.engine.R
import org.robok.engine.databinding.LayoutDiagnosticItemBinding
import org.robok.engine.ui.activities.editor.diagnostic.models.DiagnosticItem

class DiagnosticsAdapter(private val listData: List<DiagnosticItem>) :
  RecyclerView.Adapter<DiagnosticsAdapter.ViewHolder>() {

  private var context: Context? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding = LayoutDiagnosticItemBinding.inflate(
      LayoutInflater.from(parent.context), parent, false
    )
    return ViewHolder(binding, parent.context)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = listData[position]
    holder.binding.name.text = item.name
    holder.binding.description.text = item.description
    holder.binding.icon.setImageResource(handleTypes(item.type))
    context = holder.context
  }

  override fun getItemCount(): Int = listData.size

  @DrawableRes
  private fun handleTypes(t: Int): Int {
    return when (t) {
      0 -> R.drawable.ic_warning_24
      1 -> R.drawable.ic_error_24
      else -> R.drawable.ic_warning_24
    }
  }

  class ViewHolder(
    val binding: LayoutDiagnosticItemBinding,
    val context: Context
  ) : RecyclerView.ViewHolder(binding.root)
}
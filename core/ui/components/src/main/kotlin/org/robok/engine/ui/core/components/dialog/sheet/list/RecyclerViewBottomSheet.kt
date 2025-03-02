package org.robok.engine.ui.core.components.dialog.sheet.list

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

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.robok.engine.ui.core.components.databinding.LayoutRecyclerViewBottomSheetBinding

/*
 * A basic bottom sheet with RecyclerView
 * @author Aquiles Trindade (trindadedev).
 */

open class RecyclerViewBottomSheet(context: Context) : BottomSheetDialog(context) {

  private val binding: LayoutRecyclerViewBottomSheetBinding =
    LayoutRecyclerViewBottomSheetBinding.inflate(LayoutInflater.from(context))

  var recyclerView = binding.recycler
    private set

  var title: String = "trindadedev is goat🐐"
    set(value) {
      field = value
      binding.title.text = value
    }

  init {
    setContentView(binding.root)
    recyclerView.layoutManager = LinearLayoutManager(context)
  }
}

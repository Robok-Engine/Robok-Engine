package org.robok.engine.ui.core.components.dialog.sheet.list

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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

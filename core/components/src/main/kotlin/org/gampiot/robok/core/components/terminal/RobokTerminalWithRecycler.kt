package org.gampiot.robok.core.components.terminal

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

import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.bottomsheet.BottomSheetDialog

import org.gampiot.robok.core.components.R
import org.gampiot.robok.core.components.databinding.LayoutBottomsheetTerminalWithRecyclerBinding
import org.gampiot.robok.core.components.log.Log

/*
* A Basic BottomSheet for Logs, with RecyclerView.
* @author Aquiles Trindade (trindadedev).
*/

open class RobokTerminalWithRecycler(context: Context) : BottomSheetDialog(context) {

    val binding: LayoutBottomsheetTerminalWithRecyclerBinding =
        LayoutBottomsheetTerminalWithRecyclerBinding.inflate(LayoutInflater.from(context))

    val recycler = binding.recycler
    val terminalTitle = binding.terminalTitle

    
    open fun getRecyclerView() : RecyclerView {
         return recycler
    }

    init {
        setContentView(binding.root)
        setCancelable(true)
        binding.recycler.layoutManager = LinearLayoutManager(context)
    }
    
    open fun setTerminalTitle(title: String) {
        terminalTitle.text = title
    }
    
    open fun getTerminalTitle(): String {
        return terminalTitle.text.toString()
    }
}

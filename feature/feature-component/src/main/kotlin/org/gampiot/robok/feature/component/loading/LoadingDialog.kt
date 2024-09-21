package org.gampiot.robok.feature.component.loading

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

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import com.google.android.material.loadingindicator.LoadingIndicator

import org.gampiot.robok.feature.component.databinding.LayoutLoadingDialogBinding

/*
* A Basic Dialog with MDC Loading Indicator.
* @author Aquiles Trindade (trindadedev).
*/

class LoadingDialog(context: Context) : Dialog(context) {

    private lateinit var binding: LayoutLoadingDialogBinding
    private val c: Context = context
    private lateinit var loadingIndicator: LoadingIndicator 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutLoadingDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingIndicator = binding.loadingIndicator
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}

package org.gampiot.robok.feature.component.terminal

import android.content.Context
import android.view.LayoutInflater

import androidx.appcompat.app.AppCompatDelegate
5import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.bottomsheet.BottomSheetDialog

import org.gampiot.robok.feature.component.R
import org.gampiot.robok.feature.component.databinding.LayoutBottomsheetTerminalWithRecyclerBinding
import org.gampiot.robok.feature.component.log.Log

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

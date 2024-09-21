package org.gampiot.robok.feature.util.activities

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

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robok.feature.util.R
import org.gampiot.robok.feature.res.Strings

import java.io.InputStream

class DebugActivity : AppCompatActivity() {
    
    private var madeErrMsg: String = ""
    private lateinit var error: TextView
    private lateinit var toolbar: MaterialToolbar
    
    private val exceptionType = arrayOf(
        "StringIndexOutOfBoundsException",
        "IndexOutOfBoundsException",
        "ArithmeticException",
        "NumberFormatException",
        "ActivityNotFoundException"
    )
    private val errMessage = arrayOf(
        "Invalid string operation\n",
        "Invalid list operation\n",
        "Invalid arithmetical operation\n",
        "Invalid toNumber block operation\n",
        "Invalid intent operation"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debug)
        error = findViewById(R.id.error)
        /* toolbar = findViewById(R.id.toolbar)
        configureToolbarNavigationBack(toolbar)
        */
        
        val intent = intent
        var errMsg = ""
        madeErrMsg = ""
        if (intent != null) {
            errMsg = intent.getStringExtra("error") ?: ""
            val spilt = errMsg.split("\n")
            try {
                for (j in exceptionType.indices) {
                    if (spilt[0].contains(exceptionType[j])) {
                        madeErrMsg = errMessage[j]
                        val addIndex = spilt[0].indexOf(exceptionType[j]) + exceptionType[j].length
                        madeErrMsg += spilt[0].substring(addIndex, spilt[0].length)
                        break
                    }
                }
                if (madeErrMsg.isEmpty()) madeErrMsg = errMsg
            } catch (e: Exception) {
            }
        }
        error.text = madeErrMsg
        MaterialAlertDialogBuilder(this)
            .setTitle(Strings.title_debug_title)
            .setMessage(madeErrMsg)
            .setPositiveButton(Strings.common_word_end) { _, _ ->
                finish()
            }
            .show()
    }
}


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

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Logger {

    private lateinit var adapter: LogAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private val data: MutableList<Log> = mutableListOf()

    private var mRecyclerView: RecyclerView? = null

    fun attach(view: RecyclerView) {
        mRecyclerView = view
        init()
    }

    private fun init() {
        adapter = LogAdapter(data)
        layoutManager = LinearLayoutManager(mRecyclerView?.context).apply { stackFromEnd = true }
        mRecyclerView?.layoutManager = layoutManager
        mRecyclerView?.adapter = adapter
    }

    fun d(tag: String, message: String) {
        mRecyclerView?.post {
            data.add(Log("", message))
            adapter.notifyItemInserted(data.size)
            scroll()
        }
    }

    fun e(tagg: String, message: String) {
        val tag = "" // "[$tagg]"
        mRecyclerView?.post {
            val messageSpan =
                SpannableString(message).apply {
                    setSpan(
                        ForegroundColorSpan(0xffff0000.toInt()),
                        0,
                        message.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                    )
                }

            val tagSpan =
                SpannableString(tag).apply {
                    setSpan(
                        ForegroundColorSpan(0xffff0000.toInt()),
                        0,
                        tag.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                    )
                }

            data.add(Log(tagSpan, messageSpan))
            adapter.notifyItemInserted(data.size)
            scroll()
        }
    }

    fun w(tagg: String, message: String) {
        val tag = "" // "[$tagg]"
        mRecyclerView?.post {
            val messageSpan =
                SpannableString(message).apply {
                    setSpan(
                        ForegroundColorSpan(0xffff7043.toInt()),
                        0,
                        message.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                    )
                }

            val tagSpan =
                SpannableString(tag).apply {
                    setSpan(
                        ForegroundColorSpan(0xffff7043.toInt()),
                        0,
                        tag.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                    )
                }

            data.add(Log(tagSpan, messageSpan))
            adapter.notifyItemInserted(data.size)
            scroll()
        }
    }

    private fun scroll() {
        mRecyclerView?.smoothScrollToPosition(data.size - 1)
    }
}

package org.gampiot.robok.feature.treeview.adapters

/*
 *  This file is part of Xed-Editor (Karbon) © 2024.
 *
 *  Xed-Editor (Karbon) is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Xed-Editor (Karbon) is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Xed-Editor (Karbon).  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.gampiot.robok.feature.treeview.model.Node
import org.gampiot.robok.feature.treeview.R
import org.gampiot.robok.feature.treeview.util.Sorter
import org.gampiot.robok.feature.treeview.model.TreeViewModel
import org.gampiot.robok.feature.treeview.interfaces.FileClickListener
import org.gampiot.robok.feature.treeview.interfaces.FileIconProvider
import org.gampiot.robok.feature.treeview.interfaces.FileLongClickListener
import org.gampiot.robok.feature.treeview.interfaces.FileObject
import org.gampiot.robok.feature.treeview.widget.FileTree

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val expandView: ImageView = v.findViewById(R.id.expand)
    val fileView: ImageView = v.findViewById(R.id.file_view)
    val textView: TextView = v.findViewById(R.id.text_view)
}

class NodeDiffCallback : DiffUtil.ItemCallback<Node<FileObject>>() {
    override fun areItemsTheSame(
        oldItem: Node<FileObject>, newItem: Node<FileObject>
    ): Boolean {
        return oldItem.value.getAbsolutePath() == newItem.value.getAbsolutePath()
    }

    override fun areContentsTheSame(
        oldItem: Node<FileObject>, newItem: Node<FileObject>
    ): Boolean {
        return oldItem == newItem
    }
}

class FileTreeAdapter(private val context: Context,val fileTree: FileTree) :
    ListAdapter<Node<FileObject>, ViewHolder>(NodeDiffCallback()) {

    var onClickListener: FileClickListener? = null
    var onLongClickListener: FileLongClickListener? = null
    var iconProvider: FileIconProvider? = null


    private var animator = fileTree.itemAnimator
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = ViewHolder(view)


        val clickListener = View.OnClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val clickedNode = getItem(adapterPosition)

                if (clickedNode.value.isDirectory()) {
                    if (!clickedNode.isExpand) {
                        fileTree.itemAnimator = animator
                        expandNode(clickedNode)
                    } else {
                        fileTree.itemAnimator = null
                        collapseNode(clickedNode)
                    }
                    notifyItemChanged(adapterPosition)
                }
                onClickListener?.onClick(clickedNode)
            }
        }


        holder.itemView.setOnClickListener(clickListener)

        holder.itemView.setOnLongClickListener {
            val adapterPosition = holder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                val clickedNode = getItem(adapterPosition)
                onLongClickListener?.onLongClick(clickedNode)
            }
            true
        }


        holder.expandView.setOnClickListener(clickListener)
        holder.fileView.setPadding(0, 0, 0, 0)
        return holder
    }

    private fun dpToPx(dpValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val node = getItem(position)
        val isDir = node.value.isDirectory()
        val expandView = holder.expandView
        val fileView = holder.fileView

        // Reset padding and margins to avoid accumulation
        holder.itemView.setPadding(0, 0, 0, 0)
        val layoutParams = fileView.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(0, 0, 0, 0)
        fileView.layoutParams = layoutParams

        // Set padding based on node level
        holder.itemView.setPadding(node.level * dpToPx(17f), dpToPx(5f), 0, 0)
        fileView.setImageDrawable(iconProvider?.getIcon(node))

        val icChevronRight = iconProvider?.getChevronRight()

        if (isDir) {
            expandView.visibility = View.VISIBLE
            if (!node.isExpand) {
                expandView.setImageDrawable(icChevronRight)
            } else {
                expandView.setImageDrawable(iconProvider?.getExpandMore())
            }
        } else {
            layoutParams.setMargins(icChevronRight!!.intrinsicWidth + dpToPx(10f), 0, 0, 0)
            fileView.layoutParams = layoutParams
            expandView.visibility = View.GONE
        }

        holder.textView.text = "  ${node.value.getName()}  "
    }

    fun expandNode(clickedNode: Node<FileObject>) {
        val tempData = currentList.toMutableList()
        val index = tempData.indexOf(clickedNode)
        val children = Sorter.sort(clickedNode.value)
        tempData.addAll(index + 1, children)
        TreeViewModel.add(clickedNode, children)
        clickedNode.isExpand = true
        submitList(tempData)
    }

    private fun collapseNode(clickedNode: Node<FileObject>) {
        val tempData = currentList.toMutableList()
        val children = TreeViewModel.getChildren(clickedNode)
        tempData.removeAll(children.toSet())
        TreeViewModel.remove(clickedNode, clickedNode.child)
        clickedNode.isExpand = false
        submitList(tempData)
    }

}
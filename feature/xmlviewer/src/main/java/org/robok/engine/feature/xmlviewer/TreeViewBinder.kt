package org.robok.engine.feature.xmlviewer

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

abstract class TreeViewBinder<VH : RecyclerView.ViewHolder> : LayoutItemType {

  abstract fun provideViewHolder(itemView: View): VH

  abstract fun bindView(holder: VH, position: Int, node: TreeNode<LayoutItemType>)

  open class ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    protected fun <T : View> findViewById(@IdRes id: Int): T {
      return itemView.findViewById(id)
    }
  }
}

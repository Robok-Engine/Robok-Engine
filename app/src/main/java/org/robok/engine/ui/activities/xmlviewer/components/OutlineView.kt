package org.robok.engine.ui.activities.xmlviewer.components

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

import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.lib.ui.OutlineView as AndroidOutlineView
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import org.robok.engine.feature.xmlviewer.lib.parser.AndroidXmlParser
import org.robok.engine.feature.xmlviewer.lib.parser.ReadOnlyParser
import org.robok.engine.strings.Strings

@Composable
fun OutlineView(
  modifier: Modifier = Modifier,
  nodes: List<TreeNode<ViewBean>>,
  onOutlineClick: (View) -> Unit = {}
) {
  AndroidView(
    modifier = modifier,
    factory = { context ->
      AndroidOutlineView(context).apply {
        setOutlineClickListener(
          object : AndroidOutlineView.OnOutlineClickListener {
            override fun onDown(v: View, displayType: Int) {
            }

            override fun onCancel(v: View, displayType: Int) {
            }

            override fun onClick(v: View, displayType: Int) {
              val bean = findBeanByView(nodes, v)
              bean?.let {
                val sb = StringBuilder()
                it.infoList.forEach { info ->
                  sb.append("${info.attributeName}=${info.attributeValue}\n")
                }
                MaterialAlertDialogBuilder(context)
                  .setTitle(context.getString(Strings.text_see_code))
                  .setMessage(sb.toString())
                  .setPositiveButton(context.getString(Strings.common_word_ok)) { dialog, _ -> dialog.dismiss() }
                  .create()
                  .show()
              }
            }
          }
        )
      }
    }
  )
}

fun findBeanByView(nodes: List<TreeNode<ViewBean>>, v: View): ViewBean? {
  for (node in nodes) {
    val bean = node.content
    if (bean.view == v) {
      return bean
    } else {
      findBeanByView(node.childList as List<TreeNode<ViewBean>>, v)?.let {
        return it
      }
    }
  }
  return null
}
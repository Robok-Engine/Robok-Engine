package org.robok.engine.ui.screens.xmlviewer.components

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
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.viewinterop.AndroidView
import java.util.Stack
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.lib.parser.AndroidXmlParser
import org.robok.engine.feature.xmlviewer.lib.parser.ReadOnlyParser
import org.robok.engine.feature.xmlviewer.lib.ui.OutlineView as AndroidOutlineView
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.strings.Strings

@Composable
fun OutlineView(
  modifier: Modifier = Modifier,
  nodes: List<TreeNode<ViewBean>>,
  treeNodeStack: Stack<TreeNode<ViewBean>>,
  onOutlineClick: (View, ViewBean) -> Unit = {},
  xml: String,
) {
  AndroidView(
    modifier = modifier,
    factory = { context ->
      AndroidOutlineView(context).apply {
        setOutlineClickListener(
          object : AndroidOutlineView.OnOutlineClickListener {
            override fun onDown(v: View, displayType: Int) {}

            override fun onCancel(v: View, displayType: Int) {}

            override fun onClick(v: View, displayType: Int) {
              val bean = findBeanByView(nodes, v)
              bean?.let { bn ->
                val sb = StringBuilder()
                bn.infoList.forEach { info ->
                  sb.append("${info.attributeName}=${info.attributeValue}\n")
                }
                onOutlineClick(v, bn)
              }
            }
          }
        )
        setHoldOutline(false)
        parseXmlAndBuildTree(
          nodes = ArrayList(nodes),
          treeNodeStack = treeNodeStack,
          view = this,
          xml = xml,
        )
      }
    },
  )
}

private fun parseXmlAndBuildTree(
  nodes: ArrayList<TreeNode<ViewBean>>,
  treeNodeStack: Stack<TreeNode<ViewBean>>,
  view: AndroidOutlineView,
  xml: String,
) {
  AndroidXmlParser.with(view)
    .setOnParseListener(
      object : AndroidXmlParser.OnParseListener {
        override fun onAddChildView(v: View, parser: ReadOnlyParser) {
          val bean = ViewBean(v, parser).apply { isViewGroup = v is ViewGroup }
          val child = TreeNode(bean)
          if (treeNodeStack.isEmpty()) {
            nodes.add(child)
          } else {
            treeNodeStack.peek().addChild(child)
          }
        }

        override fun onJoin(viewGroup: ViewGroup, parser: ReadOnlyParser) {
          val bean = ViewBean(viewGroup, parser).apply { isViewGroup = true }
          val child = TreeNode(bean)
          if (treeNodeStack.isEmpty()) {
            treeNodeStack.push(child)
          } else {
            treeNodeStack.peek().addChild(child)
            treeNodeStack.push(child)
          }
        }

        override fun onRevert(viewGroup: ViewGroup, parser: ReadOnlyParser) {
          val node = treeNodeStack.pop()
          if (treeNodeStack.isEmpty()) {
            node.expand()
            nodes.add(node)
          }
        }

        override fun onFinish() {
          /* No additional logic needed for now */
        }

        override fun onStart() {
          /* No additional logic needed for now */
        }
      }
    )
    .parse(xml)
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

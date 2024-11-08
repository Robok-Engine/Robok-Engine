package org.robok.engine.ui.activities.xmlviewer

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

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.ArrayList
import java.util.Stack
import org.robok.easyui.config.Config
import org.robok.engine.R
import org.robok.engine.databinding.ActivityXmlViewerBinding
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.lib.parser.AndroidXmlParser
import org.robok.engine.feature.xmlviewer.lib.parser.ReadOnlyParser
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.ui.OutlineView
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.keys.ExtraKeys
import org.robok.engine.ui.activities.base.RobokActivity

class XMLViewerActivityOld : RobokActivity() {
  private var isEditMode = true
  private lateinit var binding: ActivityXmlViewerBinding
  private var expanded = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityXmlViewerBinding.inflate(layoutInflater)
    setContentView(binding.root)
    handleInsetts(binding.root)

    val nodes = mutableListOf<TreeNode<ViewBean>>()
    val treeNodeStack = Stack<TreeNode<ViewBean>>()

    ProxyResources.init(this)

    clearResources()

    try {
      parseXmlAndBuildTree(ArrayList(nodes), treeNodeStack)
    } catch (e: Exception) {
      e.printStackTrace()
    }

    binding.xmlViewer.setHoldOutline(false)
    setupOutlineClickListener(ArrayList(nodes))
    configureToolbar()
    loadGuiConfig()

    binding.fullScreen.setOnClickListener { v ->
      if (binding.appBarLayout.visibility == View.GONE) {
        binding.appBarLayout.visibility = View.VISIBLE
        return@setOnClickListener
      }
      binding.appBarLayout.visibility = View.GONE
    }
  }

  private fun loadGuiConfig() {
    val config = intent.getSerializableExtra(ExtraKeys.Gui.CONFIG) as? Config
    config?.let {
      when (it.orientation) {
        "landscape",
        "horizontal" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        "portrait",
        "vertical" -> requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
      }
    }
  }

  private fun configureToolbar() {
    binding.toolbar.setOnMenuItemClickListener { item ->
      when (item.itemId) {
        R.id.item_see_code -> {
          MaterialAlertDialogBuilder(this)
            .setTitle(getString(org.robok.engine.strings.R.string.text_see_code))
            .setMessage(intent.getStringExtra(ExtraKeys.Gui.CODE))
            .setPositiveButton(getString(org.robok.engine.strings.R.string.common_word_ok)) { d, _
              ->
              d.dismiss()
            }
            .create()
            .show()
          true
        }
        else -> false
      }
    }
  }

  private fun clearResources() {
    try {
      ProxyResources.getInstance().viewIdMap.takeIf { it.isNotEmpty() }?.clear()
      MessageArray.getInstanse().clear()
    } catch (e: Exception) {
      MaterialAlertDialogBuilder(this)
        .setTitle(getString(org.robok.engine.strings.R.string.title_un_error_ocurred))
        .setMessage(e.toString())
        .setPositiveButton(getString(org.robok.engine.strings.R.string.common_word_ok)) { d, _ ->
          d.dismiss()
        }
        .create()
        .show()
    }
  }

  private fun parseXmlAndBuildTree(
    nodes: ArrayList<TreeNode<ViewBean>>,
    treeNodeStack: Stack<TreeNode<ViewBean>>,
  ) {
    AndroidXmlParser.with(binding.xmlViewer)
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
            // No additional logic needed for now
          }

          override fun onStart() {
            // No additional logic needed for now
          }
        }
      )
      .parse(intent.getStringExtra(ExtraKeys.Gui.CODE))
  }

  private fun setupOutlineClickListener(nodes: ArrayList<TreeNode<ViewBean>>) {
    binding.xmlViewer.setOutlineClickListener(
      object : OutlineView.OnOutlineClickListener {
        override fun onDown(v: View, displayType: Int) {
          if (!isEditMode) {
            // Handle onDown event in non-edit mode
          }
        }

        override fun onCancel(v: View, displayType: Int) {
          // Handle cancel event
        }

        override fun onClick(v: View, displayType: Int) {
          if (isEditMode) {
            findBeanByView(ArrayList(nodes), v)?.let { bean ->
              val sb = StringBuilder()
              bean.infoList.forEach { info ->
                sb.append("${info.attributeName}=${info.attributeValue}\n")
              }
              MaterialAlertDialogBuilder(this@XMLViewerActivityOld).setMessage(sb).show()
            }
          }
        }
      }
    )
  }

  private fun findBeanByView(nodes: ArrayList<TreeNode<ViewBean>>, v: View): ViewBean? {
    for (node in nodes) {
      val bean = node.content
      if (bean.view == v) {
        return bean
      } else {
        findBeanByView(node.childList as ArrayList<TreeNode<ViewBean>>, v)?.let {
          return it
        }
      }
    }
    return null
  }
}
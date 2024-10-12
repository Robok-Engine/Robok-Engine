package org.robok.engine

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList
import java.util.Collections
import java.util.List
import java.util.Stack

import org.robok.engine.R
import org.robok.engine.feature.xmlviewer.lib.parser.AndroidXmlParser
import org.robok.engine.feature.xmlviewer.lib.parser.ReadOnlyParser
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources
import org.robok.engine.feature.xmlviewer.lib.ui.OutlineView
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray
import org.robok.engine.feature.xmlviewer.lib.utils.Utils
import org.robok.engine.feature.xmlviewer.ui.adapter.ErrorMessageAdapter
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean
import org.robok.engine.feature.xmlviewer.ui.menu.CheckBoxActionProvider
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewNodeBinder
import org.robok.engine.feature.xmlviewer.TreeNode
import org.robok.engine.feature.xmlviewer.TreeViewAdapter
import org.robok.engine.databinding.ActivityXmlViewerBinding

class XMLViewerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityXmlViewerBinding
    private var isEditMode = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlViewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        clearResources()

        val nodes = mutableListOf<TreeNode>()
        val treeNodeStack = Stack<TreeNode>()

        try {
            parseXmlAndBuildTree(nodes, treeNodeStack)
            loadViewTree(nodes)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        
        binding.outlineView.setHoldOutline(false)
        setupOutlineClickListener(nodes)
    }

    

    private fun clearResources() {
        ProxyResources.getInstance().viewIdMap.clear()
        MessageArray.getInstance().clear()
    }

    private fun parseXmlAndBuildTree(nodes: MutableList<TreeNode>, treeNodeStack: Stack<TreeNode>) {
        AndroidXmlParser.with(binding.outlineView)
            .setOnParseListener(object : AndroidXmlParser.OnParseListener {
                override fun onAddChildView(view: View, parser: ReadOnlyParser) {
                    val bean = ViewBean(view, parser).apply { isViewGroup = view is ViewGroup }
                    val child = TreeNode(bean)
                    if (treeNodeStack.isEmpty()) nodes.add(child)
                    else treeNodeStack.peek().addChild(child)
                }

                override fun onJoin(viewGroup: ViewGroup, parser: ReadOnlyParser) {
                    val bean = ViewBean(viewGroup, parser).apply { isViewGroup = true }
                    val child = TreeNode(bean)
                    if (treeNodeStack.isEmpty()) treeNodeStack.push(child)
                    else {
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

                override fun onFinish() {}
                override fun onStart() {}
            })
            .parse(intent.getStringExtra("xml"))
    }

    
    private fun setupOutlineClickListener(nodes: List<TreeNode>) {
        binding.outlineView.setOutlineClickListener(object : OutlineView.OnOutlineClickListener {
            override fun onDown(view: View, displayType: Int) {
                if (!isEditMode) {
                    // Handle onDown event
                }
            }

            override fun onCancel(view: View, displayType: Int) {}

            override fun onClick(view: View, displayType: Int) {
                if (isEditMode) {
                    findBeanByView(nodes, view)?.let { bean ->
                        val message = bean.infoList.joinToString("") { "${it.attributeName}=${it.attributeValue}" }
                        AlertDialog.Builder(this@XMLViewerActivity)
                            .setMessage(message)
                            .show()
                    }
                }
            }
        })
    }

    private fun findBeanByView(nodes: List<TreeNode>, view: View): ViewBean? {
        nodes.forEach { node ->
            val bean = node.content as ViewBean
            if (bean.view == view) return bean
            findBeanByView(node.childList, view)?.let { return it }
        }
        return null
    }

    
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.debug -> toggleDrawer(binding.drawerSub)
            R.id.component_tree -> toggleDrawer(binding.drawerSub2)
            R.id.display_view -> binding.outlineView.displayType = OutlineView.DISPLAY_VIEW
            R.id.display_design -> binding.outlineView.displayType = OutlineView.DISPLAY_DESIGN
            R.id.display_blueprint -> binding.outlineView.displayType = OutlineView.DISPLAY_BLUEPRINT
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
    */

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.view, menu)
        val provider = menu.findItem(R.id.toggle_edit).actionProvider as CheckBoxActionProvider
        provider.setOnCheckedChangeListener { _, isChecked ->
            isEditMode = !isChecked
            if (isEditMode) binding.outlineView.removeSelect()
            binding.outlineView.setHoldOutline(isChecked)
        }
        return true
    }
    */
}

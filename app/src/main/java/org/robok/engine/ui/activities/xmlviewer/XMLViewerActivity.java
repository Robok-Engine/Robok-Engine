package org.robok.engine.ui.activities.xmlviewer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.robok.engine.databinding.ActivityXmlViewerBinding;
import org.robok.engine.ui.activities.base.RobokActivity;
import org.robok.engine.feature.xmlviewer.lib.parser.AndroidXmlParser;
import org.robok.engine.feature.xmlviewer.lib.parser.ReadOnlyParser;
import org.robok.engine.feature.xmlviewer.lib.proxy.ProxyResources;
import org.robok.engine.feature.xmlviewer.lib.ui.OutlineView;
import org.robok.engine.feature.xmlviewer.lib.utils.MessageArray;
import org.robok.engine.feature.xmlviewer.lib.utils.Utils;
import org.robok.engine.feature.xmlviewer.ui.adapter.ErrorMessageAdapter;
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewBean;
import org.robok.engine.feature.xmlviewer.ui.menu.CheckBoxActionProvider;
import org.robok.engine.feature.xmlviewer.ui.treeview.ViewNodeBinder;
import org.robok.engine.feature.xmlviewer.TreeNode;
import org.robok.engine.feature.xmlviewer.TreeViewAdapter;

public class XMLViewerActivity extends RobokActivity {
    private boolean isEditMode = true;
    
    private ActivityXmlViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXmlViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        handleInsetts(binding.getRoot());
        
        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        
        clearResources();
        
        try {
            parseXmlAndBuildTree(nodes, treeNodeStack);
        } catch (Exception e) {
            e.printStackTrace();
        }

        binding.xmlViewer.setHoldOutline(false);
        setupOutlineClickListener(nodes);
    }
    
    private void clearResources() {
        try {
            ProxyResources.getInstance().getViewIdMap().clear();
            MessageArray.getInstanse().clear();
        } catch(Exception e) {
            var dia = new 
                 MaterialAlertDialogBuilder(this)
                    .setTitle(getString(org.robok.engine.strings.R.string.title_un_error_ocurred))
                    .setMessage(e.toString())
                    .setPositiveButton(getString(org.robok.engine.strings.R.string.common_word_ok), (d, i) -> {
                       d.dismiss();
                    })
                    .create();
            dia.show();
        }
    }

    private void parseXmlAndBuildTree(List<TreeNode> nodes, Stack<TreeNode> treeNodeStack) {
        AndroidXmlParser.with(binding.xmlViewer)
            .setOnParseListener(new AndroidXmlParser.OnParseListener() {
                @Override
                public void onAddChildView(View v, ReadOnlyParser parser) {
                    ViewBean bean = new ViewBean(v, parser);
                    bean.setViewGroup(v instanceof ViewGroup);

                    TreeNode<ViewBean> child = new TreeNode<>(bean);
                    if (treeNodeStack.isEmpty()) {
                        nodes.add(child);
                    } else {
                        treeNodeStack.peek().addChild(child);
                    }
                }

                @Override
                public void onJoin(ViewGroup viewGroup, ReadOnlyParser parser) {
                    ViewBean bean = new ViewBean(viewGroup, parser);
                    bean.setViewGroup(true);

                    TreeNode<ViewBean> child = new TreeNode<>(bean);
                    if (treeNodeStack.isEmpty()) {
                        treeNodeStack.push(child);
                    } else {
                        treeNodeStack.peek().addChild(child);
                        treeNodeStack.push(child);
                    }
                }

                @Override
                public void onRevert(ViewGroup viewGroup, ReadOnlyParser parser) {
                    TreeNode node = treeNodeStack.pop();
                    if (treeNodeStack.isEmpty()) {
                        node.expand();
                        nodes.add(node);
                    }
                }

                @Override
                public void onFinish() {
                    // No additional logic needed for now
                }

                @Override
                public void onStart() {
                    // No additional logic needed for now
                }
            })
            .parse(getIntent().getStringExtra("xml"));
    }
    
    private void setupOutlineClickListener(final List<TreeNode> nodes) {
        binding.xmlViewer.setOutlineClickListener(new OutlineView.OnOutlineClickListener() {
            @Override
            public void onDown(View v, int displayType) {
                if (!isEditMode) {
                    // Handle onDown event in non-edit mode
                }
            }

            @Override
            public void onCancel(View v, int displayType) {
                // Handle cancel event
            }

            @Override
            public void onClick(View v, int displayType) {
                if (isEditMode) {
                    ViewBean bean = findBeanByView(nodes, v);
                    if (bean != null) {
                        StringBuilder sb = new StringBuilder();
                        for (ViewBean.ViewInfo info : bean.getInfoList()) {
                            sb.append(info.getAttributeName()).append("=").append(info.getAttributeValue()).append("\n");
                        }
                        new MaterialAlertDialogBuilder(XMLViewerActivity.this)
                            .setMessage(sb)
                            .show();
                    }
                }
            }
        });
    }

    private ViewBean findBeanByView(List<TreeNode> nodes, View v) {
        for (TreeNode node : nodes) {
            ViewBean bean = (ViewBean) node.getContent();
            if (bean.getView() == v) {
                return bean;
            } else {
                bean = findBeanByView(node.getChildList(), v);
                if (bean != null) return bean;
            }
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_see_code) {
            var dialog = MaterialAlertDialogBuilder(this)
                    .setTitle(getString(org.robok.engine.strings.R.string.text_see_code))
                    .setMessage(getIntent().getStringExtra("xml"))
                    .setPositiveButton(getString(org.robok.engine.strings.R.string.common_word_ok), (d, i) -> {
                       d.dismiss();
                    })
                    .create();
            dialog.show();
            return true;
       }
       return super.onOptionsItemSelected(item);
    }
}
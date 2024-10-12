package org.robok.engine;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.robok.engine.databinding.ActivityXmlViewerBinding;
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

public class ViewActivity extends AppCompatActivity {
    private boolean isEditMode = true;
    
    private ActivityXmlViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityXmlViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecyclerView();
        clearResources();

        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();

        try {
            parseXmlAndBuildTree(nodes, treeNodeStack);
            loadViewTree(nodes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        binding.xmlViewer.setHoldOutline(false);
        setupOutlineClickListener(nodes);
    }

    private void setupRecyclerView() {
        RecyclerView rv = findViewById(R.id.err_list);
        rv.setAdapter(new ErrorMessageAdapter());
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void clearResources() {
        ProxyResources.getInstance().getViewIdMap().clear();
        MessageArray.getInstanse().clear();
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

    private void loadViewTree(List<TreeNode> nodes) {
        RecyclerView rv = findViewById(R.id.view_tree);
        rv.setLayoutManager(new LinearLayoutManager(this));

        TreeViewAdapter adapter = new TreeViewAdapter(nodes, Collections.singletonList(new ViewNodeBinder()));
        adapter.setPadding((int) Utils.dp2px(this, 16));
        adapter.setOnTreeNodeListener(new TreeViewAdapter.OnTreeNodeListener() {
            @Override
            public boolean onLongClick(TreeNode node, RecyclerView.ViewHolder holder) {
                ViewBean viewBean = (ViewBean) node.getContent();
                // Handle long click logic here
                return true;
            }

            @Override
            public boolean onClick(TreeNode node, RecyclerView.ViewHolder holder) {
                ViewBean type = (ViewBean) node.getContent();
                if (type.isViewGroup()) {
                    onToggle(!node.isExpand(), holder);
                }
                return false;
            }

            @Override
            public void onToggle(boolean isExpand, RecyclerView.ViewHolder holder) {
                ViewNodeBinder.ViewHolder dirViewHolder = (ViewNodeBinder.ViewHolder) holder;
                ImageView ivArrow = dirViewHolder.arrow;
                int rotateDegree = isExpand ? 90 : -90;
                ivArrow.animate().rotationBy(rotateDegree).start();
            }
        });
        rv.setAdapter(adapter);
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
                        new AlertDialog.Builder(ViewActivity.this)
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

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         if (item.getItemId() == R.id.display_view) {
            binding.xmlViewer.setDisplayType(OutlineView.DISPLAY_VIEW);
        } else if (item.getItemId() == R.id.display_design) {
            binding.xmlViewer.setDisplayType(OutlineView.DISPLAY_DESIGN);
        } else if (item.getItemId() == R.id.display_blueprint) {
            binding.xmlViewer.setDisplayType(OutlineView.DISPLAY_BLUEPRINT);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view, menu);
        CheckBoxActionProvider p = (CheckBoxActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.toggle_edit));
        p.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isEditMode = !isChecked;
            if (isEditMode) {
                binding.xmlViewer.removeSelect();
            }
            binding.xmlViewer.setHoldOutline(isChecked);
        });
        return true;
    }
    */
}
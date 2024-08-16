package org.gampiot.robok.feature.treeview.view;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.gampiot.robok.feature.treeview.R;
import org.gampiot.robok.feature.treeview.model.TreeNode;

public class TreeNodeWrapperView extends LinearLayout {
    private LinearLayout nodeItemsContainer;
    private ViewGroup nodeContainer;
    private final int containerStyle;

    public TreeNodeWrapperView(Context context, int containerStyle) {
        super(context);
        this.containerStyle = containerStyle;
        init();
    }

    private void init() {
        setOrientation(LinearLayout.VERTICAL);

        nodeContainer = new RelativeLayout(getContext());
        nodeContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        nodeContainer.setId(R.id.node_header);

        ContextThemeWrapper newContext = new ContextThemeWrapper(getContext(), containerStyle);
        nodeItemsContainer = new LinearLayout(newContext, null, containerStyle);
        nodeItemsContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        nodeItemsContainer.setId(R.id.node_items);
        nodeItemsContainer.setOrientation(LinearLayout.VERTICAL);
        nodeItemsContainer.setVisibility(View.GONE);

        addView(nodeContainer);
        addView(nodeItemsContainer);
    }

    public void insertNodeView(View nodeView) {
        if (nodeView != null) {
             nodeContainer.addView(nodeView);
        }
    }

    public void expandNode(TreeNode node) {
        if (node != null) {
            if (nodeItemsContainer.getVisibility() == View.GONE) {
                nodeItemsContainer.setVisibility(View.VISIBLE);
                for (TreeNode child : node.getChildren()) {
                    View childView = child.getViewHolder().createNodeView(child, child.getValue());
                    nodeItemsContainer.addView(childView);
                }
            }
        }
    }

    public void collapseNode(TreeNode node) {
        if (node != null) {
            if (nodeItemsContainer.getVisibility() == View.VISIBLE) {
                nodeItemsContainer.setVisibility(View.GONE);
            }
        }
    }

    public ViewGroup getNodeContainer() {
        return nodeContainer;
    }
}

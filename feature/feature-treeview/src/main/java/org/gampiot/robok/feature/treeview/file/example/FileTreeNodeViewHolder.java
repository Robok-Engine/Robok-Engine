package org.gampiot.robok.feature.treeview.file.example;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.gampiot.robok.feature.treeview.R;
import org.gampiot.robok.feature.treeview.model.TreeNode;
import org.gampiot.robok.feature.treeview.view.TreeNodeWrapperView;

public class FileTreeNodeViewHolder extends TreeNode.BaseNodeViewHolder<FileNode> {
    private final TreeNodeWrapperView treeView;

    public FileTreeNodeViewHolder(FileTreeViewActivity context, TreeNodeWrapperView treeView) {
        super(context);
        this.treeView = treeView;
    }

    @Override
    public View createNodeView(TreeNode node, FileNode value) {
        if (node != null || value != null) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final View view = inflater.inflate(R.layout.tree_node_item, null, false);

            LinearLayout layout = view.findViewById(R.id.layout);
            TextView textView = view.findViewById(R.id.path);
            textView.setText(value.name);
            ImageView iconView = view.findViewById(R.id.icon);
            if (value.isDirectory) {
                iconView.setImageResource(R.drawable.ic_folder);
            } else {
                iconView.setImageResource(R.drawable.ic_file);
            }

            ImageView expandCollapseIcon = view.findViewById(R.id.expandCollapse);
            if (node.isLeaf()) {
                expandCollapseIcon.setVisibility(View.GONE);
            } else {
                expandCollapseIcon.setVisibility(View.VISIBLE);
                expandCollapseIcon.setImageResource(node.isExpanded() ? R.drawable.ic_collapse : R.drawable.ic_expand);
                expandCollapseIcon.setOnClickListener(v -> {
                    if (node != null) {
                         if (node.isExpanded()) {
                              treeView.collapseNode(node);
                         } else {
                              treeView.expandNode(node);
                         }
                         updateExpandCollapseIcon(expandCollapseIcon, node.isExpanded());
                    }
                });
            }
        }
        return view;
    }

    private void updateExpandCollapseIcon(ImageView imageView, boolean isExpanded) {
        imageView.setImageResource(isExpanded ? R.drawable.ic_collapse : R.drawable.ic_expand);
    }
}

package org.gampiot.robok.feature.treeview.file.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.gampiot.robok.feature.treeview.R;
import org.gampiot.robok.feature.treeview.model.TreeNode;
import org.gampiot.robok.feature.treeview.view.TreeNodeWrapperView;

import java.io.File;

public class FileTreeViewActivity extends AppCompatActivity {

    private LinearLayout listContainer;
    private TreeNode root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_tree_view);

        listContainer = findViewById(R.id.listContainer);
        
        File directory = new File("/sdcard/Robok/.projects/A/");
        setupFileTree(directory);
    }

    private void setupFileTree(File rootDir) {
        root = TreeNode.root();
        buildFileTree(rootDir, root);

        // Utilizando TreeNodeWrapperView para exibir a árvore
        TreeNodeWrapperView treeView = new TreeNodeWrapperView(this, R.style.TreeNodeStyle);
        
        for (TreeNode child : root.getChildren()) {
            treeView.insertNodeView(createNodeView(child));
        }

        listContainer.addView(treeView);
    }

    private void buildFileTree(File dir, TreeNode parent) {
        if (dir != null && dir.isDirectory()) {
            TreeNode dirNode = new TreeNode(new FileNode(dir.getName(), true)).setViewHolder(new FileTreeNodeViewHolder(this));
            parent.addChild(dirNode);

            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        buildFileTree(file, dirNode);
                    } else {
                        TreeNode fileNode = new TreeNode(new FileNode(file.getName(), false)).setViewHolder(new FileTreeNodeViewHolder(this));
                        dirNode.addChild(fileNode);
                    }
                }
            }
        }
    }

    private View createNodeView(TreeNode node) {
        FileTreeNodeViewHolder viewHolder = new FileTreeNodeViewHolder(this);
        return viewHolder.createNodeView(node, (FileNode) node.getValue());
    }

    private static class FileNode {
        String name;
        boolean isDirectory;

        FileNode(String name, boolean isDirectory) {
            this.name = name;
            this.isDirectory = isDirectory;
        }
    }

    private class FileTreeNodeViewHolder extends TreeNode.BaseNodeViewHolder<FileNode> {

        public FileTreeNodeViewHolder(FileTreeViewActivity context) {
            super(context);
        }

        @Override
        public View createNodeView(TreeNode node, FileNode value) {
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

                layout.setOnClickListener(v -> {
                    if (node.isExpanded()) {
                         node.setExpanded(false);
                    } else {
                         node.setExpanded(true);
                    }
                });
            }

            return view;
        }
    }
}

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

    public LinearLayout listContainer;
    public TreeNode root;
    public TreeNodeWrapperView treeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_tree_view);

        listContainer = findViewById(R.id.listContainer);

        File directory = new File("/sdcard/Robok/.projects/A/");
        setupFileTree(directory);
    }

    public void setupFileTree(File rootDir) {
         root = TreeNode.root();
         buildFileTree(rootDir, root);
         treeView = new TreeNodeWrapperView(this, R.style.TreeNodeStyle);
         for (TreeNode child : root.getChildren()) {
               treeView.insertNodeView(createNodeView(child));
         } 
         listContainer.addView(treeView);
    }


    public void buildFileTree(File dir, TreeNode parent) {
         if (dir != null && dir.isDirectory()) {
             TreeNode dirNode = new TreeNode(new FileNode(dir.getName(), true))
                     .setViewHolder(new FileTreeNodeViewHolder(this, treeView));
             parent.addChild(dirNode);
  
             File[] files = dir.listFiles();
             if (files != null) {
                 for (File file : files) {
                     if (file.isDirectory()) {
                         buildFileTree(file, dirNode);
                     } else {
                         TreeNode fileNode = new TreeNode(new FileNode(file.getName(), false))
                                 .setViewHolder(new FileTreeNodeViewHolder(this, treeView));
                         dirNode.addChild(fileNode);
                     }
                 }
             }
         }
    }

    public View createNodeView(TreeNode node) {
         FileTreeNodeViewHolder viewHolder = new FileTreeNodeViewHolder(this, treeView);
         return viewHolder.createNodeView(node, (FileNode) node.getValue());
    }
}

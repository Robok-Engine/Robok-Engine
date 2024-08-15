package org.gampiot.robok.feature.treeview.file.example;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.gampiot.robok.feature.treeview.model.TreeNode;
import org.gampiot.robok.feature.treeview.view.AndroidTreeView;
import org.gampiot.robok.feature.treeview.view.TreeNodeWrapperView;

import java.io.File;

public class FileTreeViewActivity extends AppCompatActivity {

    private LinearLayout listContainer;
    private TreeNode root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_tree_view); // Certifique-se de que existe um layout chamado activity_file_tree_view.xml

        listContainer = findViewById(R.id.listContainer); // Certifique-se de que existe um LinearLayout com o id listContainer no layout

        // Caminho para o diretório que você deseja exibir na árvore
        File directory = new File("/path/to/your/directory");

        // Inicialize a árvore de arquivos
        setupFileTree(directory);
    }

    private void setupFileTree(File rootDir) {
        // Crie o nó raiz da árvore
        root = TreeNode.root();

        // Construa a árvore de arquivos a partir do diretório fornecido
        buildFileTree(rootDir);

        // Crie a visualização da árvore
        AndroidTreeView tView = new AndroidTreeView(this, root);
        tView.setDefaultAnimation(true);

        // Adicione a visualização da árvore ao contêiner da lista
        listContainer.addView(tView.getView());
    }

    private void buildFileTree(File dir) {
        // Verifique se o diretório existe e é realmente um diretório
        if (dir != null && dir.isDirectory()) {
            // Crie um nó para o diretório
            TreeNode dirNode = new TreeNode(dir.getName());

            // Adicione o nó do diretório à raiz
            root.addChild(dirNode);

            // Adicione os arquivos e subdiretórios como filhos do diretório atual
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Se for um subdiretório, recursivamente crie nós para ele
                        buildFileTree(file);
                    } else {
                        // Se for um arquivo, crie um nó para ele
                        TreeNode fileNode = new TreeNode(file.getName());
                        dirNode.addChild(fileNode);
                    }
                }
            }
        }
    }
}

package org.gampiot.robok.feature.template.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.MaterialSharedAxis;

import org.gampiot.robok.feature.template.R;
import org.gampiot.robok.feature.template.project.model.ProjectTemplate;
import org.gampiot.robok.feature.template.project.adapter.ProjectTemplateAdapter;
import org.gampiot.robok.feature.template.util.base.RobokFragment;

import java.util.ArrayList;
import java.util.List;

public class ProjectTemplatesFragment extends RobokFragment {

    public ProjectTemplatesFragment () {
         super(MaterialSharedAxis.X);
    }

    public ProjectTemplatesFragment (@NonNull int transitionAxisMode) {
         super(transitionAxisMode);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_project_templates, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);

         RecyclerView recyView = view.findViewById(R.id.recycler_view);
         recyView.setLayoutManager(new LinearLayoutManager(getContext()));

         List<ProjectTemplate> templates = createTemplates();
         ProjectTemplateAdapter adapter = new ProjectTemplateAdapter(templates);
         recyView.setAdapter(adapter);
    }

    private List<ProjectTemplate> createTemplates() {
         List<ProjectTemplate> templates = new ArrayList<>();
         templates.add(createTemplate(
               "Empty game",
               true, 
               false, 
               R.drawable.ic_empty_game
         ));
         return templates;
    }

    private ProjectTemplate createTemplate(String name, boolean javaSupport, boolean kotlinSupport, @DrawableRes int imageResId) {
         ProjectTemplate template = new ProjectTemplate();
         template.setName(name);
         template.setJavaSupport(javaSupport);
         template.setKotlinSupport(kotlinSupport);
         template.setImage(imageResId);
         return template;
    }
}

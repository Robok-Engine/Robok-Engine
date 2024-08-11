package org.gampiot.robok.ui.fragments.project.template;

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

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.FragmentProjectTemplatesBinding;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;
import org.gampiot.robok.ui.fragments.project.template.adapter.ProjectTemplateAdapter;
import org.gampiot.robok.ui.fragments.project.create.CreateProjectFragment;
import org.gampiot.robok.feature.util.base.RobokFragment;

import java.util.ArrayList;
import java.util.List;

public class ProjectTemplatesFragment extends RobokFragment {

    private FragmentProjectTemplatesBinding binding;

    public ProjectTemplatesFragment () {
         super(MaterialSharedAxis.X);
    }

    public ProjectTemplatesFragment (@NonNull int transitionAxisMode) {
         super(transitionAxisMode);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         binding = FragmentProjectTemplatesBinding.inflate(LayoutInflater.from(requireContext()), container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         setFragmentLayoutResId(R.id.fragment_container);
         
         binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

         List<ProjectTemplate> templates = createTemplates();
         ProjectTemplateAdapter adapter = new ProjectTemplateAdapter(templates, requireContext());
         binding.recyclerView.setAdapter(adapter);
    }

    private List<ProjectTemplate> createTemplates() {
         List<ProjectTemplate> templates = new ArrayList<>();
         templates.add(createTemplate(
               getString(org.gampiot.robok.feature.res.R.string.template_name_empty_game),
               "com.robokgame.empty",
               true,
               false,
               R.drawable.ic_empty_game
         ));
         return templates;
    }

    private ProjectTemplate createTemplate(String name, String packageName, boolean javaSupport, boolean kotlinSupport, @DrawableRes int imageResId) {
         ProjectTemplate template = new ProjectTemplate();
         template.setName(name);
         template.setPackageName(packageName);
         template.setJavaSupport(javaSupport);
         template.setKotlinSupport(kotlinSupport);
         template.setImage(imageResId);
         return template;
    }
}

package org.gampiot.robok.ui.fragments.project.template;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
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

    public FragmentProjectTemplatesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         binding = FragmentProjectTemplatesBinding.inflate(LayoutInflater.from(requireContext()), container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         configureToolbarNavigationBack(binding.toolbar);
         
         binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         
         List<ProjectTemplate> templates = createTemplates();
         ProjectTemplateAdapter adapter = new ProjectTemplateAdapter(templates, requireContext());
         binding.recyclerView.setAdapter(adapter);
    }

    public List<ProjectTemplate> createTemplates() {
         List<ProjectTemplate> templates = new ArrayList<>();
         templates.add(createTemplate(
               getString(org.gampiot.robok.feature.res.R.string.template_name_empty_game),
               "com.robok.empty",
               "empty_game",
               true,
               false,
               R.drawable.ic_empty_game
         ));
         return templates;
    }

    public ProjectTemplate createTemplate(String name, String packageName, String zipFileName, boolean javaSupport, boolean kotlinSupport, @DrawableRes int imageResId) {
         ProjectTemplate template = new ProjectTemplate();
         template.setName(name);
         template.setPackageName(packageName);
         template.setZipFileName(zipFileName);
         template.setJavaSupport(javaSupport);
         template.setKotlinSupport(kotlinSupport);
         template.setImage(imageResId);
         return template;
    }
}

package org.gampiot.robok.ui.fragments.project.template.adapter;

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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.MaterialSharedAxis;

import org.gampiot.robok.R;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;
import org.gampiot.robok.ui.fragments.project.template.view.ProjectTemplateView;
import org.gampiot.robok.ui.fragments.project.create.CreateProjectFragment;

import java.util.List;

public class ProjectTemplateAdapter extends RecyclerView.Adapter<ProjectTemplateAdapter.ViewHolder> {

    private final List<ProjectTemplate> projectTemplates;
    private final Context context;
    
    public ProjectTemplateAdapter(List<ProjectTemplate> projectTemplates, Context context) {
         this.projectTemplates = projectTemplates;
         this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_template, parent, false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         ProjectTemplate template = projectTemplates.get(position);
         holder.bind(template);
    }

    @Override
    public int getItemCount() {
         return projectTemplates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    
         public ProjectTemplate projectTemplate;
         public ProjectTemplateView projectTemplateView;
         
         public ViewHolder(@NonNull View itemView) {
              super(itemView);
              projectTemplateView = itemView.findViewById(R.id.project_template_view);
              projectTemplateView.setClick(this);
         }
         
         @Override
         public void onClick(View view) {
              if (projectTemplate != null) {
                   goToCreateProject(projectTemplate);
              } 
         }

         public void bind(ProjectTemplate template) {
              projectTemplate = template;
              projectTemplateView.setProjectTemplate(template);
         }
         
         public void goToCreateProject(ProjectTemplate template) {
              FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
              CreateProjectFragment createProjectFragment = new CreateProjectFragment(template);
              fragmentTransaction.replace(R.id.fragment_container, createProjectFragment);
              fragmentTransaction.addToBackStack(null);
              fragmentTransaction.commit();
          }
    }
}

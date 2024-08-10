package org.gampiot.robok.ui.fragments.project.template.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gampiot.robok.R;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;
import org.gampiot.robok.ui.fragments.project.template.view.ProjectTemplateView;

import java.util.List;

public class ProjectTemplateAdapter extends RecyclerView.Adapter<ProjectTemplateAdapter.ViewHolder> {

    private final List<ProjectTemplate> projectTemplates;

    public ProjectTemplateAdapter(List<ProjectTemplate> projectTemplates) {
        this.projectTemplates = projectTemplates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_project_template, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectTemplate template = projectTemplates.get(position);
        holder.projectTemplateView.setProjectTemplate(template);
        holder.projectTemplateView.setOnClickListener(v -> {
              
        });
    }

    @Override
    public int getItemCount() {
        return projectTemplates.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ProjectTemplateView projectTemplateView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            projectTemplateView = (ProjectTemplateView) itemView;
        }
    }
    
    public void goToCreateProject (ProjectTemplate template) {
         FragmentManager fragmentManager = getSupportFragmentManager();
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         fragmentTransaction.replace(R.id.fragment_container, new CreateProjectFragment(MaterialSharedAxis.X, template));
         fragmentTransaction.addToBackStack(null);
         fragmentTransaction.commit();
    }
}

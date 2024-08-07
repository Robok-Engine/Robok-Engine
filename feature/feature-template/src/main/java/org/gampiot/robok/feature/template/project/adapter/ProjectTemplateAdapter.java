package org.gampiot.robok.feature.template.project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.gampiot.robok.feature.template.R;
import org.gampiot.robok.feature.template.project.model.ProjectTemplate;
import org.gampiot.robok.feature.template.project.view.ProjectTemplateView;

import java.util.List;

public class ProjectTemplateAdapter extends RecyclerView.Adapter<ProjectTemplateAdapter.ViewHolder> {

    private final List<ProjectTemplate> projectTemplates;

    public ProjectTemplateAdapter(List<ProjectTemplate> projectTemplates) {
        this.projectTemplates = projectTemplates;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_template_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectTemplate template = projectTemplates.get(position);
        holder.projectTemplateView.setProjectTemplate(template);
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
}

package org.gampiot.robok.ui.fragments.project.template.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.card.MaterialCardView;

import org.gampiot.robok.R;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;

public class ProjectTemplateView extends LinearLayout {

    private MaterialCardView container;
    private ShapeableImageView iconView;
    private TextView nameView;
    private ProjectTemplate template;
    
    public ProjectTemplateView(Context context) {
         super(context);
         init(context);
    }

    public ProjectTemplateView(Context context, AttributeSet attrs) {
         super(context, attrs);
         init(context);
    }

    public ProjectTemplateView(Context context, AttributeSet attrs, int defStyleAttr) {
         super(context, attrs, defStyleAttr);
         init(context);
    }

    public void init(Context context) {
         LayoutInflater inflater = LayoutInflater.from(context);
         inflater.inflate(R.layout.layout_template_view, this, true);
         iconView = findViewById(R.id.template_icon);
         nameView = findViewById(R.id.template_name);
         container = findViewById(R.id.container);
    }

    public void setProjectTemplate(@NonNull ProjectTemplate template) {
         if (template != null) {
             this.template = template;
             iconView.setImageResource(template.imageResId);
             nameView.setText(template.name);
         }
    }
    
    public void setClick (View.OnClickListener ls) {
         container.setOnClickListener(ls);
    }
    
    public ProjectTemplate getTemplate() {
         if (template != null) {
             return template;
         }
         return null;
    }
}

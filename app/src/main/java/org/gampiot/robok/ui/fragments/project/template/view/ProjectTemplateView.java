package org.gampiot.robok.ui.fragments.project.template.view;

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
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

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

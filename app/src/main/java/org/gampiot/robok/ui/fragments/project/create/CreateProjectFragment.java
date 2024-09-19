package org.gampiot.robok.ui.fragments.project.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.IdRes;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.transition.MaterialSharedAxis;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.FragmentCreateProjectBinding;
import org.gampiot.robok.ui.fragments.editor.EditorFragment;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;
import org.gampiot.robok.ui.fragments.project.create.util.ProjectManager;
import org.gampiot.robok.feature.util.base.RobokFragment;
import org.gampiot.robok.feature.util.Helper;

import java.io.File;

public class CreateProjectFragment extends RobokFragment implements ProjectManager.Listener {

    private FragmentCreateProjectBinding binding;
    
    private ProjectTemplate template;
    private ProjectManager projectManager;
    
    public CreateProjectFragment() {
         this.template = defaultProjectTemplate();
    }
    
    public CreateProjectFragment(@NonNull ProjectTemplate template) {
         this.template = template;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         binding = FragmentCreateProjectBinding.inflate(inflater, container, false);
         return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         configureToolbarNavigationBack(binding.toolbar);
         
         loadTemplate();
         
         OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
         
         projectManager = new ProjectManager(requireContext());
         projectManager.setListener(this);
         
         var helper = new Helper();
         binding.buttonBack.setOnClickListener(helper.getBackPressedClickListener(onBackPressedDispatcher));
         binding.buttonNext.setOnClickListener(v -> create());
    }

    @Override
    public void onDestroyView() {
         super.onDestroyView();
         binding = null;
    }
    
    public void loadTemplate() {
         binding.projectName.setText(template.name);
         binding.projectPackageName.setText(template.packageName);
    }
    
    public void create () {
         projectManager.create(
               binding.projectName.getText().toString(),
               binding.projectPackageName.getText().toString(),
               template
         );
    }
    
    public ProjectTemplate defaultProjectTemplate () {
         var template = new ProjectTemplate();
         template.setName(getString(org.gampiot.robok.feature.res.R.string.template_name_empty_game));
         template.setPackageName("com.robok.empty");
         template.setZipFileName("empty_game");
         template.setJavaSupport(true);
         template.setKotlinSupport(false);
         template.setImage(R.drawable.ic_empty_game);
         return template;
    }
    
    @Override
    public void onProjectCreate() {
         var dialog = 
             new MaterialAlertDialogBuilder(requireContext())
                  .setTitle(getString(org.gampiot.robok.feature.res.R.string.warning_project_created_title))
                  .setMessage(getString(org.gampiot.robok.feature.res.R.string.warning_project_created_message))
                  .setPositiveButton(getString(org.gampiot.robok.feature.res.R.string.title_open_project), (d, i) -> {
                        openFragment(new EditorFragment(projectManager.projectDir));
                  })
                  .setNegativeButton(getString(org.gampiot.robok.feature.res.R.string.common_word_ok), (dd, ii) -> {
                        dd.dismiss();
                  })
                  .create();
         dialog.show();         
    }
        
    @Override
    public void onProjectCreateError() {
         //
    }
}

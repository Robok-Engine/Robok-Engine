package org.gampiot.robok.ui.fragments.project.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.activity.OnBackPressedDispatcher;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.transition.MaterialSharedAxis;

import org.gampiot.robok.R;
import org.gampiot.robok.databinding.FragmentCreateProjectBinding;
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate;
import org.gampiot.robok.ui.fragments.project.create.util.ProjectCreator;
import org.gampiot.robok.feature.util.base.RobokFragment;
import org.gampiot.robok.feature.util.Helper;
import org.gampiot.robok.feature.component.terminal.RobokTerminalWithRecycler;

import java.io.File;

import robok.aapt2.compiler.CompilerTask;
import robok.aapt2.model.Project;
import robok.aapt2.model.Library;
import robok.aapt2.logger.Logger;

public class CreateProjectFragment extends RobokFragment implements ProjectCreator.Listener {

    private FragmentCreateProjectBinding binding;
    
    private ProjectTemplate template;
    
    public CreateProjectFragment() {
         this(MaterialSharedAxis.X);
         this.template = defaultProjectTemplate();
    }
    
    public CreateProjectFragment(int transitionAxis) {
         super(transitionAxis);
         this.template = defaultProjectTemplate();
    }
    
    public CreateProjectFragment(int transitionAxis, ProjectTemplate template) {
         super(transitionAxis);
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
         setFragmentLayoutResId(R.id.fragment_container);
         
         loadTemplate();
         var helper = new Helper();
         OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
         
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
         var projectCreator = new ProjectCreator();
         projectCreator.setListener(this);
         projectCreator.create(
               requireContext(),
               binding.projectName.getText().toString(),
               binding.projectPackageName.getText().toString(),
               template
         );
    }
    
    public ProjectTemplate defaultProjectTemplate () {
         ProjectTemplate template = new ProjectTemplate();
         template.setName(getString(org.gampiot.robok.feature.res.R.string.template_name_empty_game));
         template.setPackageName("com.robokgame.empty");
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
                  .setPositiveButton(getString(org.gampiot.robok.feature.res.R.string.common_word_ok), (d, i) -> {
                        d.dismiss();
                  })
                  .setNegativeButton("Build", (dd, ii) -> {
                       build();
                  })
                  .create();
         dialog.show();         
    }
    
    public void build () {
         var terminal = new RobokTerminalWithRecycler(requireContext());
         var logger = new Logger();
         logger.attach(terminal.getRecyclerView());
         Project project = new Project();
         project.setLibraries(Library.fromFile(new File("")));
         project.setResourcesFile(new File("/sdcard/Robok/.projects/project/res/"));
         project.setOutputFile(new File("/sdcard/Robok/.projects/project/build/"));
         project.setJavaFile(new File("/sdcard/Robok/.projects/project/logic/"));
         project.setManifestFile(new File("/sdcard/Robok/.projects/project/res"));
         project.setLogger(logger);
         project.setMinSdk(21);
         project.setTargetSdk(28);
         CompilerTask task = new CompilerTask(requireContext());
         task.execute(project);
         terminal.show();
    }
        
    @Override
    public void onProjectCreateError() {
         //
    }
}

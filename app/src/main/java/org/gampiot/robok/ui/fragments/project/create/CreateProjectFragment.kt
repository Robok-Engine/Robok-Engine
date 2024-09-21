package org.gampiot.robok.ui.fragments.project.create

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

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent

import androidx.activity.OnBackPressedDispatcher
import androidx.annotation.NonNull
import androidx.annotation.Nullable

import com.google.android.material.dialog.MaterialAlertDialogBuilder

import org.gampiot.robok.R
import org.gampiot.robok.databinding.FragmentCreateProjectBinding
import org.gampiot.robok.ui.activities.editor.EditorActivity
import org.gampiot.robok.ui.fragments.project.template.model.ProjectTemplate
import org.gampiot.robok.ui.fragments.project.create.util.ProjectManager
import org.gampiot.robok.feature.util.base.RobokFragment
import org.gampiot.robok.feature.util.Helper

import java.io.File

class CreateProjectFragment(
    private val template: ProjectTemplate
) : RobokFragment(), ProjectManager.CreationListener {

    private var binding: FragmentCreateProjectBinding? = null
    private lateinit var projectManager: ProjectManager

    @Nullable
    override fun onCreateView(@NonNull inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View {
        binding = FragmentCreateProjectBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(@NonNull view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureToolbarNavigationBack(binding!!.toolbar)

        loadTemplate()

        val onBackPressedDispatcher = requireActivity().onBackPressedDispatcher

        projectManager = ProjectManager(requireContext())
        projectManager.setListener(this)

        val helper = Helper()
        binding!!.buttonBack.setOnClickListener(helper.getBackPressedClickListener(onBackPressedDispatcher))
        binding!!.buttonNext.setOnClickListener { create() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun loadTemplate() {
        binding!!.projectName.setText(template.name)
        binding!!.projectPackageName.setText(template.packageName)
    }

    private fun create() {
        val projectPath = File(Environment.getExternalStorageDirectory(), "Robok/.projects/${binding!!.projectName.text}")
        projectManager.setProjectPath(projectPath)
        projectManager.create(
            binding!!.projectName.text.toString(),
            binding!!.projectPackageName.text.toString(),
            template
        )
    }

    private fun defaultProjectTemplate(): ProjectTemplate {
        return ProjectTemplate().apply {
            name = getString(org.gampiot.robok.feature.res.R.string.template_name_empty_game)
            packageName = "com.robok.empty"
            zipFileName = "empty_game"
            javaSupport = true
            kotlinSupport = false
            imageResId = R.drawable.ic_empty_game
        }
    }

    override fun onProjectCreate() {
         val dialog = MaterialAlertDialogBuilder(requireContext())
             .setTitle(getString(org.gampiot.robok.feature.res.R.string.warning_project_created_title))
             .setMessage(getString(org.gampiot.robok.feature.res.R.string.warning_project_created_message))
             .setPositiveButton(getString(org.gampiot.robok.feature.res.R.string.title_open_project)) { _, _ ->
                 val bundle = Bundle().apply {
                     putString("projectPath", projectManager.getProjectPath().absolutePath)
                 }
              
                 val intent = Intent(requireContext(), EditorActivity::class.java).apply {
                      putExtras(bundle)
                 }
                 startActivity(intent)
             }
             .setNegativeButton(getString(org.gampiot.robok.feature.res.R.string.common_word_ok)) { dialog, _ ->
                 dialog.dismiss()
             }
             .create()
        dialog.show()
    }

    override fun onProjectCreateError() {
    }
}
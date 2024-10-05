package org.robok.engine.ui.screens.project.manage

import android.content.Intent
import android.os.Environment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import org.robok.engine.ui.activities.editor.EditorActivity
import java.io.File

val projectPath = File(Environment.getExternalStorageDirectory(), "Robok/.projects")

//check if a given file is a robok project or not
private fun isProject(file: File):Boolean{
  //simple check for now
  return file.isDirectory and (file.listFiles().isNullOrEmpty().not())
}

class ProjectViewModel : ViewModel() {
  private val _projects = MutableStateFlow<Array<File>>(emptyArray())
  val projects: StateFlow<Array<File>> = _projects
  fun updateProjects(projects: Array<File>) {
    _projects.update { projects.filter { isProject(it) }.toTypedArray() }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageProjects(navController: NavController) {
  val projectViewModel: ProjectViewModel = viewModel()
  val projects by projectViewModel.projects.collectAsState()

  LaunchedEffect(Unit) {
    withContext(Dispatchers.IO) {
      projectViewModel.updateProjects(projectPath.listFiles() ?: emptyArray<File>())
    }
  }


  Scaffold(topBar = {
    TopAppBar(
    title = {
      //todo string
      Text(text = "Projects")
    },
    navigationIcon = {
      IconButton(onClick = { navController.popBackStack() }) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowBack,
          contentDescription = "Back"
        )
      }
    }
  )
  }) { padding ->
    LazyColumn(modifier = Modifier.padding(padding)) {
      items(projects) { project ->
        Project(projectFile = project)
      }
    }
  }
}

@Composable
fun Project(projectFile: File) {
  val context = LocalContext.current
  Card(modifier = Modifier
    .fillMaxWidth()
    .padding(8.dp), onClick = {
    context.startActivity(Intent(context, EditorActivity::class.java).apply {
      putExtras(android.os.Bundle().apply {
        putString("projectPath", projectFile.absolutePath)
      })
    })
  }) {
    Row(
      modifier = Modifier.padding(8.dp)
    ) {
      Spacer(modifier = Modifier.width(8.dp))
      Column(
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = projectFile.name, style = MaterialTheme.typography.titleMedium
        )
        Text(
          text = projectFile.path, style = MaterialTheme.typography.titleSmall
        )
      }
    }
  }
}
package org.robok.engine.ui.screens.project.manage

import android.content.Intent
import android.os.Environment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import org.robok.engine.R

val projectPath = File(Environment.getExternalStorageDirectory(), "Robok/.projects")

class ProjectViewModel : ViewModel() {
  private val _projects = MutableStateFlow<Array<File>>(emptyArray())
  val projects: StateFlow<Array<File>> = _projects
  fun updateProjects(songs: Array<File>) {
    _projects.update { songs }
  }
}

@Composable
fun ManageProjects() {
  val projectViewModel: ProjectViewModel = viewModel()
  val projects by projectViewModel.projects.collectAsState()

  LaunchedEffect(Unit) {
    withContext(Dispatchers.IO) {
      projectViewModel.updateProjects(projectPath.listFiles() ?: emptyArray<File>())
    }
  }

  LazyColumn {
    items(projects) { project ->
      Project(projectFile = project)
    }
  }

}


//todo : modify project composable to make it look good
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
          text = projectFile.name, style = MaterialTheme.typography.titleLarge
        )
        Text(
          text = projectFile.path, style = MaterialTheme.typography.titleMedium
        )
      }
    }
  }
}
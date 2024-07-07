package dev.trindade.robokide.ui.activities.main

import android.os.Bundle
import androidx.activity.*
import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.draw.*
import androidx.activity.compose.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.foundation.*
import androidx.compose.ui.graphics.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import dev.trindade.robokide.ui.screen.editor.*
import robok.trindade.compiler.*

@Composable
fun Content(compiler: RobokCompiler) {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen()
        }
        composable(
            route = "editor/{projectPath}",
            arguments = listOf(navArgument("projectPath") { type = NavType.StringType })
        ) { entry ->
            val projectPath = entry.arguments?.getString("projectPath")
            projectPath?.let {
                EditorScreen(it)
            }
        }
    }
}
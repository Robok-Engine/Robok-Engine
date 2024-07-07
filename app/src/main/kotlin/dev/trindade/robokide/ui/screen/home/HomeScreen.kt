package dev.trindade.robokide.ui.screen.home

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
import androidx.compose.ui.text.input.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.*

import dev.trindade.robokide.R
import dev.trindade.robokide.ui.theme.*
import dev.trindade.robokide.ui.models.toolbar.*
import dev.trindade.robokide.ui.editor.*
import dev.trindade.robokide.terminal.*

import robok.trindade.compiler.*

@Composable
fun HomeScreen() {
    Box(
       modifier = Modifier
           .fillMaxSize()
           .padding(16.dp)
       ) {
         
          Button(
              onClick = {  },
              modifier = Modifier
                  .align(Alignment.BottomEnd)
          ) {
              Text(
                 text = "Create new Project"
              )
          }
       }
}
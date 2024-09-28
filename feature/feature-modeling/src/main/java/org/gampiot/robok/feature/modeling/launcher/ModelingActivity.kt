package org.gampiot.robok.feature.modeling.launcher

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
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.badlogic.gdx.backends.android.AndroidApplication

import org.gampiot.robok.feature.modeling.view.Model3DView

class ModelingActivity : AndroidApplication() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Model3DViewScreen()
        }
    }
    @Composable
    fun Model3DViewScreen() {
         val config = AndroidApplicationConfiguration()
         Column(
             modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
         ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { /* Comando para criar cubo */ }) {
                     Text("Criar Cubo")
                }
                Button(onClick = { /* Comando para criar triângulo */ }) {
                     Text("Criar Triângulo")
                }
                Button(onClick = { /* Comando para criar esfera */ }) {
                    Text("Criar Esfera")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { /* Comando para criar cilindro */ }) {
                    Text("Criar Cilindro")
                }
                Button(onClick = { /* Comando para criar cone */ }) {
                    Text("Criar Cone")
                }
                Button(onClick = { /* Comando para criar plano */ }) {
                    Text("Criar Plano")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            AndroidView(
                factory = { context ->
                    val model3DView = Model3DView()
                    initializeForView(model3DView, config)
                },
                modifier = Modifier.fillMaxSize()
            )
         }
    }
}
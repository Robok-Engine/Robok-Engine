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

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController

import androidx.appcompat.app.AppCompatActivity

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration

import org.gampiot.robok.feature.modeling.databinding.Activity3dModelBinding
import org.gampiot.robok.feature.modeling.view.Model3DView

/*
* TO-DO: Refactor with JetPack Compose.
*/

class AndroidLauncher : AndroidApplication() {
    
    private lateinit var binding: Activity3dModelBinding

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = Activity3dModelBinding.inflate(layoutInflater)

        val config = AndroidApplicationConfiguration()
        val libgdxView = initializeForView(Model3DView(), config)
        
        binding.criarCubo.setOnClickListener { model3dView.command = "createCube" }
        binding.criarTriangulo.setOnClickListener { model3dView.command = "createTriangle" }
        binding.criarEsfera.setOnClickListener { model3dView.command = "createSphere" }
        binding.criarCilindro.setOnClickListener { model3dView.command = "createCylinder" }
        binding.criarCone.setOnClickListener { model3dView.command = "createCone" }
        binding.criarPlano.setOnClickListener { model3dView.command = "createPlane" }

        binding.linearLibGdx.addView(libgdxView)
        setContentView(binding.root)
        hideSystemUI()
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
            window.insetsController?.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE)
        } else {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}
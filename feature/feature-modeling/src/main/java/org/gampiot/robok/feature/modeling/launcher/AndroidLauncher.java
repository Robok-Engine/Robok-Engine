package org.gampiot.robok.feature.modeling.launcher;

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
 
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import org.gampiot.robok.feature.modeling.databinding.Activity3dModelBinding;
import org.gampiot.robok.feature.modeling.view.Model3DView;
import org.gampiot.robok.feature.modeling.fragment.LibGDXFragment;


import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class AndroidLauncher extends AppCompatActivity implements AndroidFragmentApplication.Callbacks {
    
    private ActivityMainBinding binding;
    private LibGDXFragment libGDXFragment;
    private Model3DView model3dView;
    
    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflar o layout usando View Binding
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
        
        // Adicionar o Fragmento LibGDX
        libGDXFragment = new LibGDXFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.linearLibGdx, libGDXFragment);
        fragmentTransaction.commit();

        // Garantir que o fragmento seja adicionado antes de prosseguir
        fragmentManager.executePendingTransactions();
        model3dView = libGDXFragment.getModel3DView().clazz;
        
        // Configurar os listeners dos botões
        setupButtonListeners();
        
        // Ocultar a UI do sistema
        hideSystemUI();
    }
    
    private void setupButtonListeners() {
        
        
      /*  binding.criarCubo.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createCube");
        });
        
        binding.criarTriangulo.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createTriangle");
        });
        
        binding.criarEsfera.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createSphere");
        });
        
        binding.criarCilindro.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createCylinder");
        });
        
        binding.criarCone.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createCone");
        });
        
        binding.criarPlano.setOnClickListener(v -> {
            verifyIfMy3dGameIsNull();
            model3dView.setCommand("createPlane");
        });
        */
    }
    
    private void verifyIfMy3dGameIsNull(){
        if(model3dView == null){
                model3dView = libGDXFragment.getModel3DView().clazz;
            } 
    }
    
    private void hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
    
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }
    }

    /**
     * Implementação do método exit() da interface AndroidFragmentApplication.Callbacks
     */
    @Override
    public void exit() {
        finish();
    }
}

/*
em compose, de acordo com o chatGpt

// AndroidLauncher.kt
package com.example.libgdxtest.launcher

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.libgdxtest.fragment.LibGDXFragment
import com.example.libgdxtest.view.Model3DView
import com.example.libgdxtest.ui.theme.LibGdxTestTheme
import com.badlogic.gdx.backends.android.AndroidFragmentApplication

class AndroidLauncher : ComponentActivity(), AndroidFragmentApplication.Callbacks {

    private lateinit var libGDXFragment: LibGDXFragment
    private var model3dView: Model3DView? = null

    override fun onDestroy() {
        super.onDestroy()
        // Limpeza se necessário
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar o Fragmento LibGDX
        libGDXFragment = LibGDXFragment()
        supportFragmentManager.commit {
            replace(android.R.id.content, libGDXFragment, "LibGDXFragment")
        }

        setContent {
            LibGdxTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LibGDXScreen(libGDXFragment = libGDXFragment, onCommand = { command ->
                        model3dView?.setCommand(command)
                    })
                }
            }
        }
    }

    override fun exit() {
        finish()
    }
}

@Composable
fun LibGDXScreen(libGDXFragment: LibGDXFragment, onCommand: (String) -> Unit) {
    val fragmentManager = (LocalContext.current as ComponentActivity).supportFragmentManager
    val libGdxView = remember { mutableStateOf<View?>(null) }

    LaunchedEffect(libGDXFragment) {
        // Assegurar que o fragmento está adicionado
        if (fragmentManager.findFragmentByTag("LibGDXFragment") == null) {
            fragmentManager.commit {
                replace(android.R.id.content, libGDXFragment, "LibGDXFragment")
            }
        }
        // Obter a view do fragmento
        libGdxView.value = libGDXFragment.view
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Seção de Botões
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { onCommand("createCube") }) {
                Text("Cubo")
            }
            Button(onClick = { onCommand("createTriangle") }) {
                Text("Triângulo")
            }
            Button(onClick = { onCommand("createSphere") }) {
                Text("Esfera")
            }
            Button(onClick = { onCommand("createCylinder") }) {
                Text("Cilindro")
            }
            Button(onClick = { onCommand("createCone") }) {
                Text("Cone")
            }
            Button(onClick = { onCommand("createPlane") }) {
                Text("Plano")
            }
        }

        // Contêiner para o Fragmento LibGDX
        Box(modifier = Modifier.weight(1f)) {
            AndroidView(factory = { context ->
                libGDXFragment.view ?: View(context).apply {
                    // Aqui você pode configurar a view se necessário
                }
            }, modifier = Modifier.fillMaxSize())
        }
    }
}

*/
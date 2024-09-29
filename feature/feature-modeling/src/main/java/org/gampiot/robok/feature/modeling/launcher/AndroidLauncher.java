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
    
    private Activity3dModelBinding binding;
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
        binding = Activity3dModelBinding.inflate(getLayoutInflater());
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

    /*
    * Implementação do método exit() da interface AndroidFragmentApplication.Callbacks
    */
    @Override
    public void exit() {
        finish();
    }
}

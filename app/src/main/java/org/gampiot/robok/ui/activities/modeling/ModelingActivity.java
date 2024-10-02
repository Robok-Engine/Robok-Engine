package org.gampiot.robok.ui.activities.modeling;

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

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.compose.ui.platform.ComposeView;

import org.gampiot.robok.core.utils.base.RobokActivity;
import org.gampiot.robok.feature.modeling.databinding.Activity3dModelBinding;
import org.gampiot.robok.feature.modeling.view.Model3DView;
import org.gampiot.robok.feature.modeling.fragment.LibGDXFragment;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class ModelingActivity extends RobokActivity implements AndroidFragmentApplication.Callbacks {
    
     private Activity3dModelBinding binding;
     private LibGDXFragment libGDXFragment;
     private Model3DView model3dView;
     
     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          binding = Activity3dModelBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());
        
          libGDXFragment = new LibGDXFragment();
          FragmentManager fragmentManager = getSupportFragmentManager();
          FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
          fragmentTransaction.replace(binding.frameLibGdx.getId(), libGDXFragment);
          fragmentTransaction.commit();

          fragmentManager.executePendingTransactions();
          model3dView = libGDXFragment.getModel3DView().clazz;
          
          var activityHelper = new ModelingActivityHelper(this);
          ComposeView composeUI = activityHelper.createComposeView();

          binding.layoutParent.addView(composeUI);
          hideSystemUI();
     }
    
     /*
     public void setupButtonListeners() {
          binding.criarCubo.setOnClickListener(v -> {
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
     }
    */
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
    * Implementation of the exit() method of the AndroidFragmentApplication.Callbacks interface
    */
    @Override
    public void exit() {
        finish();
    }
    
    @Override
     protected void onDestroy() {
         binding = null;
         super.onDestroy();
     }
    
}
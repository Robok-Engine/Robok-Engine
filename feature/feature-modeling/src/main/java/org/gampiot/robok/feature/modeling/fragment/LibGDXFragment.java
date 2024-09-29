package org.gampiot.robok.feature.modeling.fragment;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.gampiot.robok.feature.modeling.view.Model3DView;

public class LibGDXFragment extends AndroidFragmentApplication {
    
    private Model3DView model3dView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useGL30 = true; // Configuração GL30 conforme necessário

        model3dView = new Model3DView(); // Sua classe que implementa ApplicationListener

        View libgdxView = initializeForView(model3dView, config);
        return libgdxView;
    }

    public Model3DView getModel3DView() {
        return model3dView;
    }
}
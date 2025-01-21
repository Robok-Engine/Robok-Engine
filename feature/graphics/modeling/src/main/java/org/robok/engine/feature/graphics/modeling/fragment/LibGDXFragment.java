package org.robok.engine.feature.graphics.modeling.fragment;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import org.robok.engine.feature.graphics.modeling.view.Model3DView;

public class LibGDXFragment extends AndroidFragmentApplication {

  private Model3DView model3dView;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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

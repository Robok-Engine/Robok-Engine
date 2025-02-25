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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import org.robok.engine.feature.graphics.modeling.view.Model3DView

class LibGDXFragment : AndroidFragmentApplication() {

  @JvmField
  private lateinit var model3dView: Model3DView

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    val config = AndroidApplicationConfiguration().apply {
      useGL30 = true
    }
    model3dView = Model3DView()
    return initializeForView(model3dView, config)
  }

  fun getModel3DView(): Model3DView {
    return model3dView
  }
}
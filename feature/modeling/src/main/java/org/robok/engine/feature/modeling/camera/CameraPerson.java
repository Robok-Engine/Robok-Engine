package org.robok.engine.feature.modeling.camera;

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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class CameraPerson extends InputAdapter {
  private final PerspectiveCamera camera;
  private final float maxVerticalAngle = 90f; // 180 graus divididos por 2

  public CameraPerson(PerspectiveCamera camera) {
    this.camera = camera;
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    float deltaX = -Gdx.input.getDeltaX();
    float deltaY = -Gdx.input.getDeltaY();

    camera.direction.rotate(Vector3.Y, deltaX);

    // Calcula o novo ângulo de inclinação
    Vector3 right = camera.direction.crs(Vector3.Y).nor();
    float angleX =
        MathUtils.radiansToDegrees
            * MathUtils.atan2(
                camera.direction.y, new Vector3(camera.direction.x, 0, camera.direction.z).len());

    // Limita a rotação vertical
    float newAngleX = MathUtils.clamp(angleX - deltaY, -maxVerticalAngle, maxVerticalAngle);
    camera.direction.rotate(right, newAngleX - angleX);

    return true;
  }
}

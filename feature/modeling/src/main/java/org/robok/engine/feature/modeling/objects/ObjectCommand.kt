package org.robok.engine.feature.modeling.objects

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

/*
 * Command to create object on ModelingScreen.
 * see {@link ObjectsCreator} for see that methods.
 * see {@link Model3DView} for see that methods call.
 * @author Aquiles Trindade (trindadedev).
 */
object ObjectCommand {
  const val CREATE_CUBE = "createCube"
  const val CREATE_TRIANGLE = "createTriangle"
  const val CREATE_SPHERE = "createSphere"
  const val CREATE_CYLINDER = "createCylinder"
  const val CREATE_CONE = "createCone"
  const val CREATE_PLANE = "createPlane"
  const val CREATE_TRIANGLE_2D = "createTriangle2D"
}

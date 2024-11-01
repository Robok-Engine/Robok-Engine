package org.robok.engine.feature.modeling.controller.config.position;

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

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import java.util.ArrayList;
import java.util.List;
import org.robok.engine.feature.modeling.objects.SceneObject;

public class MovimentObject {

  private Camera camera;
  private List<Arrow> movementArrows = new ArrayList<>();
  private SceneObject selectedObject;
  private Arrow draggedArrow = null;
  private Vector3 dragStartPosition = new Vector3();
  private Vector2 lastTouchPosition = new Vector2();
  private boolean isDragging = false;

  public MovimentObject(Camera camera) {
    this.camera = camera;
  }

  public List<Arrow> getMovimentArrows() {
    return movementArrows;
  }

  public void touchUp() {
    isDragging = false;
    draggedArrow = null;
    if (selectedObject != null) {
      updateMovementArrows();
    } else {
      movementArrows.clear();
      // CameraInputController2.teste = true;
    }
  }

  public void handleInput(float x, float y) {
    Vector2 touchPos = new Vector2(x, y);
    Ray ray = getRayFromScreenCoordinates(touchPos);

    if (!isDragging) {
      // Selecionar objeto
      selectedObject = getObjectAtRay(ray);
      if (selectedObject != null) {
        updateMovementArrows();
        draggedArrow = getArrowAtScreenCoordinates(touchPos);
        if (draggedArrow != null) {
          // CameraInputController2.teste = false;
          isDragging = true;
          dragStartPosition.set(
              selectedObject.getModelInstance().transform.getTranslation(new Vector3()));
          lastTouchPosition.set(touchPos.cpy());
        }
      }
    } else {
      if (selectedObject != null && draggedArrow != null) {
        // Calcular o movimento
        Vector3 dragDirection = projectDragToAxis(touchPos, draggedArrow.direction);
        moveSelectedObject(dragDirection);
        lastTouchPosition.set(touchPos);
      }
    }
  }

  private Arrow getArrowAtScreenCoordinates(Vector2 touchPos) {
    for (Arrow arrow : movementArrows) {
      Vector3 screenStart = camera.project(arrow.position.cpy());
      Vector3 screenEnd =
          camera.project(arrow.position.cpy().add(arrow.direction.cpy().scl(arrow.length)));

      if (touchPos.dst(screenStart.x, screenStart.y) < 100
          || touchPos.dst(screenEnd.x, screenEnd.y) < 100) {
        return arrow;
      }
    }
    return null;
  }

  private void updateMovementArrows() {
    movementArrows.clear();

    BoundingBox bbox = new BoundingBox();
    selectedObject.getModelInstance().calculateBoundingBox(bbox);
    bbox.mul(selectedObject.getModelInstance().transform);

    Vector3 center = bbox.getCenter(new Vector3());
    Vector3 dimensions = bbox.getDimensions(new Vector3());

    float arrowLength = 2; // Math.max(dimensions.x, Math.max(dimensions.y, dimensions.z)) * 0.2f;

    movementArrows.add(
        new Arrow(
            center.cpy().add(dimensions.x / 2 + arrowLength / 2, 0, 0),
            Vector3.X,
            Color.RED,
            arrowLength));
    movementArrows.add(
        new Arrow(
            center.cpy().add(0, dimensions.y / 2 + arrowLength / 2, 0),
            Vector3.Y,
            Color.GREEN,
            arrowLength));
    movementArrows.add(
        new Arrow(
            center.cpy().add(0, 0, dimensions.z / 2 + arrowLength / 2),
            Vector3.Z,
            Color.BLUE,
            arrowLength));
  }

  private Vector3 projectDragToAxis(Vector2 currentTouchPos, Vector3 axis) {
    Ray rayStart = getRayFromScreenCoordinates(lastTouchPosition);
    Ray rayEnd = getRayFromScreenCoordinates(currentTouchPos);

    Vector3 dragVector = rayEnd.origin.sub(rayStart.origin);
    float projection = dragVector.dot(axis) / axis.len2();
    return axis.cpy().scl(projection + 0.01f);
  }

  private void moveSelectedObject(Vector3 translation) {
    selectedObject.getModelInstance().transform.trn(translation);
  }

  private SceneObject getObjectAtRay(Ray ray) {
    SceneObject closestObject = null;
    float closestDistance = Float.MAX_VALUE;

    for (SceneObject scene : SceneObject.sceneObjects) {
      BoundingBox bbox = new BoundingBox();
      scene.getModelInstance().calculateBoundingBox(bbox);
      bbox.mul(scene.getModelInstance().transform);

      Vector3 intersection = new Vector3();
      if (Intersector.intersectRayBounds(ray, bbox, intersection)) {
        float distance = ray.origin.dst(intersection);
        if (distance < closestDistance) {
          closestDistance = distance;
          closestObject = scene;
        }
      }
    }
    return closestObject;
  }

  private Ray getRayFromScreenCoordinates(Vector2 touchPos) {
    Vector3 nearPoint = new Vector3(touchPos.x, touchPos.y, 0);
    Vector3 farPoint = new Vector3(touchPos.x, touchPos.y, 1);

    camera.unproject(nearPoint);
    camera.unproject(farPoint);

    return new Ray(nearPoint, farPoint.sub(nearPoint).nor());
  }

  public void renderEdges(ShapeRenderer shapeRenderer) {
    if (selectedObject != null) {
      for (Arrow arrow : movementArrows) {
        arrow.render(shapeRenderer);
      }
    }
  }
}

package org.robok.engine.feature.graphics.modeling.controller;

/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import org.robok.engine.feature.graphics.modeling.objects.SceneObject;

public class CameraInputController2 extends GestureDetector {
  /** The button for rotating the camera. */
  public int rotateButton = Buttons.LEFT;

  /** The angle to rotate when moved the full width or height of the screen. */
  public float rotateAngle = 360f;

  /** The button for translating the camera along the up/right plane */
  public int translateButton = Buttons.RIGHT;

  /** The units to translate the camera when moved the full width or height of the screen. */
  public float translateUnits = 10f; // FIXME auto calculate this based on the target

  /** The button for translating the camera along the direction axis */
  public int forwardButton = Buttons.MIDDLE;

  /**
   * The key which must be pressed to activate rotate, translate and forward or 0 to always
   * activate.
   */
  public int activateKey = 0;

  /** Indicates if the activateKey is currently being pressed. */
  protected boolean activatePressed;

  /**
   * Whether scrolling requires the activeKey to be pressed (false) or always allow scrolling
   * (true).
   */
  public boolean alwaysScroll = true;

  /** The weight for each scrolled amount. */
  public float scrollFactor = -0.1f;

  /** World units per screen size */
  public float pinchZoomFactor = 20f; // 20f modified (10f)

  /** Whether to update the camera after it has been changed. */
  public boolean autoUpdate = true;

  /** The target to rotate around. */
  public Vector3 target = new Vector3();

  /** Whether to update the target on translation */
  public boolean translateTarget = true;

  /** Whether to update the target on forward */
  public boolean forwardTarget = true;

  /** Whether to update the target on scroll */
  public boolean scrollTarget = false;

  public int forwardKey = Keys.W;
  protected boolean forwardPressed;
  public int backwardKey = Keys.S;
  protected boolean backwardPressed;
  public int rotateRightKey = Keys.A;
  protected boolean rotateRightPressed;
  public int rotateLeftKey = Keys.D;
  protected boolean rotateLeftPressed;
  protected boolean controlsInverted;

  /** The camera. */
  private static Camera camera;

  /** The current (first) button being pressed. */
  protected int button = -1;

  public boolean ammount;

  private float startX, startY;
  private final Vector3 tmpV1 = new Vector3();
  private final Vector3 tmpV2 = new Vector3();

  // selected object
  public SceneObject selectedObject;

  protected static class CameraGestureListener extends GestureAdapter {
    public static CameraInputController2 controller;
    private float previousZoom;
    private Vector2 initialPointer1, initialPointer2;
    private Vector2 currentPointer1, currentPointer2;
    private boolean isZoom;
    private CameraInputController2.Object object;

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
      previousZoom = 0;
      isZoom = false;
      return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

      if (count == 1) {

        object = new CameraInputController2.Object(controller.camera);
        SceneObject sc = object.getObjectFromTap(x, y);
        if (sc != null) {
          //  object = new CameraInputController2.Object(controller.camera);
          controller.selectedObject = sc;
        }
      }
      if (count == 2) {
        object = new CameraInputController2.Object(controller.camera);
        controller.selectedObject = object.getObjectFromTap(x, y);
        if (controller.selectedObject != null) focarCameraNoObject(controller.selectedObject);

        controller.ammount = true;
      }
      return false;
    }

    @Override
    public boolean longPress(float x, float y) {
      return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
      return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
      return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
      float newZoom = distance - initialDistance;
      float amount = newZoom - previousZoom;
      previousZoom = newZoom;

      // Define um limiar para considerar o movimento como zoom
      float zoomThreshold = 8f; // Ajuste este valor conforme necessário

      if (Math.abs(amount) > zoomThreshold) {
        // Zoom detectado
        isZoom = true;
        float w = Gdx.graphics.getWidth(), h = Gdx.graphics.getHeight();
        return controller.pinchZoom(amount / ((w > h) ? h : w));
      } else {
        // Movimento insignificante, provavelmente pan
        isZoom = false;
        return false;
      }
    }

    @Override
    public boolean pinch(
        Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
      if (!controller.multiTouch) return false;

      if (previousZoom == 0) {
        this.initialPointer1 = initialPointer1.cpy();
        this.initialPointer2 = initialPointer2.cpy();
        previousZoom = 1; // Indica que o gesto de pinch começou
      }

      // Calcula o delta entre a posição inicial e a atual para os dois dedos
      Vector2 deltaPointer1 = pointer1.cpy().sub(initialPointer1);
      Vector2 deltaPointer2 = pointer2.cpy().sub(initialPointer2);

      // Calcula o movimento médio (average) dos dois dedos
      Vector2 averageDelta = deltaPointer1.cpy().add(deltaPointer2).scl(0.5f);

      // Calcula o movimento do meio da tela (midpoint) entre os dois dedos
      Vector2 initialMidpoint =
          new Vector2(
              (initialPointer1.x + initialPointer2.x) / 2,
              (initialPointer1.y + initialPointer2.y) / 2);
      Vector2 currentMidpoint =
          new Vector2((pointer1.x + pointer2.x) / 2, (pointer1.y + pointer2.y) / 2);

      // Calcula o delta de movimento do midpoint
      Vector2 movementDelta = currentMidpoint.sub(initialMidpoint);

      // Diminui a velocidade de movimento da câmera
      float sensitivity = 0.00004f; // Ajuste a sensibilidade conforme necessário

      // Aplica o movimento proporcional à câmera com sensibilidade ajustada
      Vector3 right = controller.camera.direction.cpy().crs(controller.camera.up).nor();
      Vector3 up = controller.camera.up.cpy();
      Vector3 cameraMovement =
          right
              .scl(-movementDelta.x * sensitivity * controller.translateUnits)
              .add(up.scl(movementDelta.y * sensitivity * controller.translateUnits));
      controller.camera.translate(cameraMovement);

      // Atualiza o alvo da câmera se necessário
      if (controller.translateTarget) {
        controller.target.add(cameraMovement);
      }

      // Atualiza a câmera
      if (controller.autoUpdate) {
        controller.camera.update();
      }

      return true;
    }

    /*	@Override
    public boolean pinch (Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
    	return false;
    }*/

    public static void focarCameraNoObject(SceneObject sceneObject) {
      // Supondo que getModelInstance() retorne um objeto do tipo ModelInstance
      ModelInstance modelInstance = sceneObject.getModelInstance();

      // ModelInstance contém uma matriz de transformação (transform), que podemos usar para obter a
      // posição do objeto
      Vector3 objectPosition = new Vector3();
      modelInstance.transform.getTranslation(objectPosition);

      // Defina a distância desejada da câmera em relação ao objeto
      float distance = 10f;

      // Define o ponto alvo para a câmera
      controller.target.set(objectPosition);

      // Posicione a câmera a uma certa distância do objeto no eixo Z (ou outro eixo se preferir)
      controller.camera.position.set(
          objectPosition.x + distance, objectPosition.y + distance, objectPosition.z + distance);

      // A câmera deve olhar para o objeto
      controller.camera.lookAt(objectPosition);

      // Ajusta o vetor "up" da câmera para garantir que ela esteja orientada corretamente
      controller.camera.up.set(0, 1, 0);

      // Atualize a câmera para aplicar as mudanças
      controller.camera.update();
    }
  }
  ;

  public static class Object {
    private Camera camera;

    public Object(Camera camera) {
      this.camera = camera;
    }

    public SceneObject getObjectFromTap(float x, float y) {
      Vector2 touchPos = new Vector2(x, y);
      Ray ray = getRayFromScreenCoordinates(touchPos);
      return getObjectAtRay(ray);
    }

    private SceneObject getObjectAtRay(Ray ray) {
      SceneObject closestObject = null;
      float closestDistance = Float.MAX_VALUE;

      for (SceneObject scene : SceneObject.getSceneObjects()) {
        BoundingBox bbox = new BoundingBox();
        scene.getModelInstance().calculateBoundingBox(bbox);
        bbox.mul(scene.getModelInstance().transform); // Aplicar transformação

        Vector3 intersection = new Vector3();
        if (Intersector.intersectRayBounds(ray, bbox, intersection)) {
          float distance = ray.origin.dst(intersection);

          if (distance < closestDistance + 0.01f) { // Tolerância
            closestDistance = distance;
            closestObject = scene;
          }
        }
      }

      return closestObject;
    }

    private Ray getRayFromScreenCoordinates(Vector2 touchPos) {
      // Cria vetores para os pontos perto e longe da tela
      Vector3 nearPoint = new Vector3(touchPos.x, touchPos.y, 0);
      Vector3 farPoint = new Vector3(touchPos.x, touchPos.y, 1);

      // Converte os pontos para o espaço do mundo
      camera.unproject(nearPoint);
      camera.unproject(farPoint);

      // Cria um raio a partir dos pontos
      return new Ray(nearPoint, farPoint.sub(nearPoint).nor());
    }
  }

  protected final CameraGestureListener gestureListener;

  protected CameraInputController2(
      final CameraGestureListener gestureListener, final Camera camera) {
    super(gestureListener);
    this.gestureListener = gestureListener;
    this.gestureListener.controller = this;
    this.camera = camera;
  }

  public CameraInputController2(final Camera camera) {
    this(new CameraGestureListener(), camera);
    // this.movimentObject = new MovimentObject(camera);
  }

  public void update() {
    if (rotateRightPressed || rotateLeftPressed || forwardPressed || backwardPressed) {
      final float delta = Gdx.graphics.getDeltaTime();
      if (rotateRightPressed) camera.rotate(camera.up, -delta * rotateAngle);
      if (rotateLeftPressed) camera.rotate(camera.up, delta * rotateAngle);
      if (forwardPressed) {
        camera.translate(tmpV1.set(camera.direction).scl(delta * translateUnits));
        if (forwardTarget) target.add(tmpV1);
      }
      if (backwardPressed) {
        camera.translate(tmpV1.set(camera.direction).scl(-delta * translateUnits));
        if (forwardTarget) target.add(tmpV1);
      }
      if (autoUpdate) camera.update();
    }
  }

  public void updateRenderer(ShapeRenderer shapeRenderer) {
    // renderEdges(shapeRenderer, ob.getModelInstance());
    if (this.selectedObject != null) {
      Matrix4 matrix = this.selectedObject.getModelInstance().transform;
      Vector3 position = new Vector3(0f, 0f, 0f);
      matrix.getTranslation(position);
      float x, y, z;
      x = position.x;
      y = position.y;
      z = position.z;

      // scala
      Vector3 dimensions = this.selectedObject.getSize();

      float scaleX, scaleY, scaleZ;
      scaleX = dimensions.x;
      scaleY = dimensions.y;
      scaleZ = dimensions.z;

      drawCubeEdges2(shapeRenderer, scaleX, scaleY, scaleZ, x, y, z);
    }

    //  } //else movimemtObject is null
  }

  private int touched;
  private boolean multiTouch;

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    touched |= (1 << pointer);
    multiTouch = !MathUtils.isPowerOfTwo(touched);
    if (multiTouch) this.button = -1;
    else if (this.button < 0 && (activateKey == 0 || activatePressed)) {
      startX = screenX;
      startY = screenY;
      this.button = button;
    }
    return super.touchDown(screenX, screenY, pointer, button)
        || (activateKey == 0 || activatePressed);
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    // if(movimentObject != null) movimentObject.touchUp(); //MovimentObject
    // this.selectedObject = null;
    touched &= -1 ^ (1 << pointer);
    multiTouch = !MathUtils.isPowerOfTwo(touched);
    if (button == this.button) this.button = -1;
    return super.touchUp(screenX, screenY, pointer, button) || activatePressed;
  }

  /**
   * Sets the CameraInputController2s' control inversion.
   *
   * @param invertControls Whether or not to invert the controls
   */
  public void setInvertedControls(boolean invertControls) {
    if (this.controlsInverted != invertControls) {
      // Flip the rotation angle
      this.rotateAngle = -this.rotateAngle;
    }
    this.controlsInverted = invertControls;
  }

  protected boolean process(float deltaX, float deltaY, int button) {

    if (button == rotateButton) {
      tmpV1.set(camera.direction).crs(camera.up).y = 0f;
      camera.rotateAround(target, tmpV1.nor(), deltaY * rotateAngle);
      camera.rotateAround(target, Vector3.Y, deltaX * -rotateAngle);
    } else if (button == translateButton) {
      camera.translate(
          tmpV1.set(camera.direction).crs(camera.up).nor().scl(-deltaX * translateUnits));
      camera.translate(tmpV2.set(camera.up).scl(-deltaY * translateUnits));
      if (translateTarget) target.add(tmpV1).add(tmpV2);
    } else if (button == forwardButton) {
      camera.translate(tmpV1.set(camera.direction).scl(deltaY * translateUnits));
      if (forwardTarget) target.add(tmpV1);
    }

    if (autoUpdate) camera.update();
    return true;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    // this.movimentObject.handleInput(screenX,screenY);
    boolean result = super.touchDragged(screenX, screenY, pointer);
    if (result || this.button < 0 || multiTouch) return result;
    final float deltaX = (screenX - startX) / Gdx.graphics.getWidth();
    final float deltaY = (startY - screenY) / Gdx.graphics.getHeight();
    startX = screenX;
    startY = screenY;
    return process(deltaX, deltaY, button);
  }

  @Override
  public boolean scrolled(float amountX, float amountY) {
    return zoom(amountY * scrollFactor * translateUnits);
  }

  public boolean zoom(float amount) {
    if (!alwaysScroll && activateKey != 0 && !activatePressed) return false;
    camera.translate(tmpV1.set(camera.direction).scl(amount));
    if (scrollTarget) target.add(tmpV1);
    if (autoUpdate) camera.update();
    return true;
  }

  protected boolean pinchZoom(float amount) {
    return zoom(pinchZoomFactor * amount);
  }

  @Override
  public boolean keyDown(int keycode) {
    if (keycode == activateKey) activatePressed = true;
    if (keycode == forwardKey) forwardPressed = true;
    else if (keycode == backwardKey) backwardPressed = true;
    else if (keycode == rotateRightKey) rotateRightPressed = true;
    else if (keycode == rotateLeftKey) rotateLeftPressed = true;
    return false;
  }

  @Override
  public boolean keyUp(int keycode) {
    if (keycode == activateKey) {
      activatePressed = false;
      button = -1;
    }
    if (keycode == forwardKey) forwardPressed = false;
    else if (keycode == backwardKey) backwardPressed = false;
    else if (keycode == rotateRightKey) rotateRightPressed = false;
    else if (keycode == rotateLeftKey) rotateLeftPressed = false;
    return false;
  }

  // shapeRenderer
  // Desenhar cubo detalhado
  private void drawCubeEdges2(
      ShapeRenderer shapeRenderer,
      float scaleX,
      float scaleY,
      float scaleZ,
      float centerX,
      float centerY,
      float centerZ) {
    // Calcula os tamanhos no cubo
    float halfScaleX = scaleX / 2;
    float halfScaleY = scaleY / 2;
    float halfScaleZ = scaleZ / 2;

    // Define os pontos do cubo com escalas e posição central
    float[][] points = {
      {centerX - halfScaleX, centerY - halfScaleY, centerZ - halfScaleZ},
      {centerX + halfScaleX, centerY - halfScaleY, centerZ - halfScaleZ},
      {centerX + halfScaleX, centerY + halfScaleY, centerZ - halfScaleZ},
      {centerX - halfScaleX, centerY + halfScaleY, centerZ - halfScaleZ},
      {centerX - halfScaleX, centerY - halfScaleY, centerZ + halfScaleZ},
      {centerX + halfScaleX, centerY - halfScaleY, centerZ + halfScaleZ},
      {centerX + halfScaleX, centerY + halfScaleY, centerZ + halfScaleZ},
      {centerX - halfScaleX, centerY + halfScaleY, centerZ + halfScaleZ}
    };

    shapeRenderer.setColor(Color.WHITE);
    // Desenha as arestas do cubo
    for (int i = 0; i < 4; i++) {
      shapeRenderer.line(
          points[i][0],
          points[i][1],
          points[i][2],
          points[(i + 1) % 4][0],
          points[(i + 1) % 4][1],
          points[(i + 1) % 4][2]);
      shapeRenderer.line(
          points[i + 4][0],
          points[i + 4][1],
          points[i + 4][2],
          points[((i + 1) % 4) + 4][0],
          points[((i + 1) % 4) + 4][1],
          points[((i + 1) % 4) + 4][2]);
      shapeRenderer.line(
          points[i][0],
          points[i][1],
          points[i][2],
          points[i + 4][0],
          points[i + 4][1],
          points[i + 4][2]);
    }
  }
}

package robok.dev.opengl.Scene;

import android.opengl.Matrix;
import android.util.Log;

import robok.dev.opengl.Utils.Vector3D;

import static robok.dev.opengl.Scene.CharacterController.DIRECTION.IDLE;
import static robok.dev.opengl.Scene.CharacterController.DIRECTION.fromInt;

public class CharacterController {
    private Vector3D eyePos = new Vector3D();
    private Vector3D targetPos = new Vector3D(1.0f, 0.0f, 0.0f);
    private Vector3D upDirection = new Vector3D(0.0f, 1.0f, 0.0f);;
    private Vector3D moveDirection = new Vector3D();;

    private final static float CHAR_SPEED = 10.f;

    public enum DIRECTION {
        IDLE(-1), LEFT(0), RIGHT(1), FORWARD(2), BACKWARD(3);
        private int value;
        private DIRECTION(int i) {
            value = i;
        }
        public int getValue() {
            return value;
        }
        public static DIRECTION fromInt(int i) {
            switch (i) {
                case 0:
                    return LEFT;
                case 1:
                    return RIGHT;
                case 2:
                    return FORWARD;
                case 3:
                    return BACKWARD;
                default:
                    return IDLE;
            }
        }
    };
    private DIRECTION direction = IDLE;
    /**
     *
     * Store the view matrix. This can be thought of as our camera. This matrix transforms world space to eye space;
     * it positions things relative to our eye.
     */
    private final float[] mViewMatrix = new float[16];

    // keep a ref to scene manager
    private SceneManager sceneManager;

    public CharacterController(SceneManager sm) {
        sceneManager = sm;

        // View matrix
        eyePos.setXYZ(sceneManager.getStartPos().x, sceneManager.getStartPos().y, sceneManager.getStartPos().z);
        Matrix.setLookAtM(mViewMatrix, 0, eyePos.x, eyePos.y, eyePos.z,
                eyePos.x + targetPos.x, eyePos.y + targetPos.y, eyePos.z + targetPos.z,
                upDirection.x, upDirection.y, upDirection.z);
        sceneManager.setViewMatrix(mViewMatrix);

        // Move direction vector
        moveDirection = new Vector3D();
    }

    public float[] getViewMatrix() {
        return mViewMatrix;
    }

    public Vector3D getEyePos() { return eyePos; }
    public Vector3D getTargetPos() { return targetPos; }

    public void updateTarget(Vector3D t) {
        targetPos = t;
    }

    public void updateEyePos(Vector3D e) {
        eyePos = e;
    }

    public void update(float delta) {
        // if moving
        if (direction != IDLE) {
            updateDirection();
            Vector3D destination = new Vector3D();
            Vector3D.add(destination, eyePos, Vector3D.multiplyVF(moveDirection, 3));
            Log.v("CharacterController", destination.toString());
            if (!sceneManager.checkForCollision(destination.x, destination.z))
                Vector3D.add(eyePos, eyePos, Vector3D.multiplyVF(moveDirection, delta * CHAR_SPEED));
        }
        updateViewMatrix();
    }

    public void onKeyDown(int d) {
        direction = fromInt(d);
    }

    public void onKeyUp() {
        direction = IDLE;
    }

    private void updateViewMatrix() {
        Matrix.setLookAtM(mViewMatrix, 0, eyePos.x, eyePos.y, eyePos.z,
                targetPos.x + eyePos.x, targetPos.y + eyePos.y, targetPos.z + eyePos.z,
                upDirection.x, upDirection.y, upDirection.z);
    }

    private void updateDirection() {
        switch (direction) {
            case LEFT:
                moveDirection = new Vector3D(targetPos.z, 0.0f, -targetPos.x).normalize();
                break;
            // right
            case RIGHT:
                moveDirection = new Vector3D(-targetPos.z, 0.0f, targetPos.x).normalize();
                break;
            // up
            case FORWARD:
                moveDirection = new Vector3D(targetPos.x, 0.0f, targetPos.z).normalize();
                break;
            // down
            case BACKWARD:
                moveDirection = new Vector3D(-targetPos.x, 0.0f, -targetPos.z).normalize();
                break;
            default:
                moveDirection = new Vector3D();
        }
    }
}

package robok.dev.opengl.GameView;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.util.Log;

import robok.dev.opengl.Objects.BasicObject;
import robok.dev.opengl.Objects.Cube;
import robok.dev.opengl.Objects.Plane;
import robok.dev.opengl.Scene.CharacterController;
import robok.dev.opengl.Scene.SceneManager;
import robok.dev.opengl.Utils.Vector3D;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameRenderer implements GLSurfaceView.Renderer{

    private BasicObject object;
    private BasicObject plane;
    private BasicObject wall;
    private BasicObject roof;

    /** CharacterController */
    private CharacterController characterController;

    /** Store the projection matrix. This is used to project the scene onto a 2D viewport. */
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mOrthoProjectionMatrix = new float[16];

    /**
     * Store the view matrix. This can be thought of as our camera. This matrix transforms world space to eye space;
     * it positions things relative to our eye.
     */
    private float[] mViewMatrix;
    /**
     * Store the model matrix. This matrix is used to move models from object space (where each model can be thought
     * of being located at the center of the universe) to world space.
     */
    private float[] mModelMatrix = new float[16];

    /**
     * Stores a copy of the model matrix specifically for the light position.
     */
    private float[] mLightModelMatrix = new float[16];

    /** Used to hold a light centered on the origin in model space. We need a 4th coordinate so we can get translations to work when
     *  we multiply this by our transformation matrices. */
    private final float[] mLightPosInModelSpace = new float[] {0.0f, 0.0f, 0.0f, 1.0f};

    /** Used to hold the current position of the light in world space (after transformation via model matrix). */
    private final float[] mLightPosInWorldSpace = new float[4];

    /** Used to hold the transformed position of the light in eye space (after transformation via modelview matrix) */
    private final float[] mLightPosInEyeSpace = new float[4];

    /** Context */
    private final Context mContextHandle;

    /** SceneManger */
    private SceneManager sceneManager;

    /** Render time */
    private float startTime = 0.f;

    private GameSurfaceView mGameSurfaceView;
    private int mGameState = -1;
    private final static int GAME_START = 0;


    public GameRenderer(Context context, GameSurfaceView g) { mContextHandle = context; mGameSurfaceView = g;}

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Set the background clear color to gray.
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

        // Use culling to remove back faces.
   //     GLES20.glEnable(GLES20.GL_CULL_FACE);

        // Enable depth testing
        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        // Culling back
        GLES20.glCullFace(GLES20.GL_BACK);

        // Front face
        GLES20.glFrontFace(GLES20.GL_CCW);

        // Create scene
        object = new Cube(mContextHandle);
        plane = new Plane(mContextHandle, 60.f, 60.f);
        roof = new Plane(mContextHandle, 60.f, 60.f);

        sceneManager = new SceneManager(mContextHandle);
        sceneManager.addObject(plane);
        plane.setPosition(new Vector3D(0.0f, -5.0f, 0.0f));
        sceneManager.addObject(roof);
        roof.setPosition(new Vector3D(0.0f, 5.0f, 0.0f));

        // Create character controller
        characterController = new CharacterController(sceneManager);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Set the OpenGL viewport to the same size as the surface.
        GLES20.glViewport(0, 0, width, height);

        // Create a new perspective projection matrix. The height will stay the same
        // while the width will vary as per aspect ratio.
        final float ratio = (float) width / height;
        final float left = -ratio;
        final float right = ratio;
        final float bottom = -1.0f;
        final float top = 1.0f;
        final float near = 1.0f;
        final float far = 866.0f;

        Log.v("GameRenderer", width + " " + height + " ratio" + ratio);
        Matrix.frustumM(mProjectionMatrix, 0, -1, 1, bottom, top, near, far);
        Matrix.orthoM(mOrthoProjectionMatrix, 0, 0f, width, 0.0f, height, 0, 50);
        // Set Projection matrix for scenemanager
        sceneManager.setProjectionMatrix(mProjectionMatrix);
        sceneManager.setGamePadProjectionMatrix(mOrthoProjectionMatrix);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Game state: START
        if (mGameState != GAME_START) {
            mGameState = GAME_START;
            mGameSurfaceView.gameStart();
        }

        float elapsedTime = SystemClock.elapsedRealtime() - startTime;
        if (elapsedTime < 8.3f) {
            //     return;
        }
        startTime = SystemClock.elapsedRealtime();

        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);

        // Update camera position
        characterController.update(1/60f);
        mViewMatrix = characterController.getViewMatrix();

        // Calculate position of the light. Rotate and then push into the distance.
        Matrix.setIdentityM(mLightModelMatrix, 0);
        Matrix.translateM(mLightModelMatrix, 0, 0.0f, 0.0f, -5.0f);

        Matrix.translateM(mLightModelMatrix, 0, 0.0f, 0.0f, 2.0f);

        Matrix.multiplyMV(mLightPosInWorldSpace, 0, mLightModelMatrix, 0, mLightPosInModelSpace, 0);
        Matrix.multiplyMV(mLightPosInEyeSpace, 0, mViewMatrix, 0, mLightPosInWorldSpace, 0);

        sceneManager.setLightPosInEyeSpace(mLightPosInEyeSpace);
        sceneManager.render();
    }

    private float theta = 0, phi = 0;

    public void updateCamera(float x, float y) {
        theta += x / 300;
        phi += y / 300;

        Vector3D target = new Vector3D();
        target.x = (float) (Math.cos(theta) * Math.sin(phi));
        target.y = (float) Math.cos(-phi);
        target.z = (float) (Math.sin(theta) * Math.sin(phi));

        characterController.updateTarget(target);
        mViewMatrix = characterController.getViewMatrix();
    }

    public void onKeyDown(int direction) {
        characterController.onKeyDown(direction);
        mViewMatrix = characterController.getViewMatrix();
    }

    public void onKeyUp() {
        characterController.onKeyUp();
    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
package robok.dev.opengl.Scene;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

import robok.dev.opengl.GameView.GameRenderer;
import robok.dev.opengl.Objects.BasicObject;
import robok.dev.opengl.Objects.GamePad;
import robok.dev.opengl.Objects.SkyBox;
import robok.dev.opengl.R;
import robok.dev.opengl.Utils.Vector3D;

import java.util.Vector;

public class SceneManager {

    private Context mContextHandle;
    private int mProgramHandle;
    private int mGamePadProgramHandle;
    private int mSkyboxProgramHandle;

    private MazeMap mazeMap;
    private Vector<BasicObject> mazeObjects;

    private float[] mViewMatrix;
    private float[] mProjectionMatrix;
    private float[] mLightPosInEyeSpace;
    private float[] mModelMatrix = new float[16];

    private GamePad gamePad;
    private float[] mGamePadModelMatrix = new float[16];
    private float[] mGamePadViewMatrix = new float[16];
    private float[] mGamePadProjectionMatrix = new float[16];

    private SkyBox skyBox;

    public SceneManager(Context context) {
        mContextHandle = context;

        // initialize scene object
        mazeObjects = new Vector<BasicObject>();

        // shader
        mProgramHandle = generateShader();
        mGamePadProgramHandle = generateGamePadShader();
        mSkyboxProgramHandle = generateSkyboxShader();

        // scene map
        mazeMap = new MazeMap(this);
        mazeMap.readMazeMap(mContextHandle, R.raw.testmap);

        // game pad
        gamePad = new GamePad(mContextHandle);
        gamePad.setShaderHandles(mGamePadProgramHandle);

        // skybox
        skyBox = new SkyBox(mContextHandle);
        skyBox.setShaderHandle(mSkyboxProgramHandle);

    }

    public void setViewMatrix(float[] viewMatrix) {
        this.mViewMatrix = viewMatrix;
    }

    public void setProjectionMatrix(float[] projectionMatrix) {
        this.mProjectionMatrix = projectionMatrix;
    }

    public void setGamePadProjectionMatrix(float[] projectionMatrix) {
        this.mGamePadProjectionMatrix = projectionMatrix;
    }

    public void setGamePadViewMatrix(float[] viewMatrix) {
        this.mGamePadViewMatrix = viewMatrix;
    }

    public void setLightPosInEyeSpace(float[] lightPosInEyeSpace) {
        this.mLightPosInEyeSpace = lightPosInEyeSpace;
    }

    public void setRenderMatrices(float[] mViewMatrix, float[] mProjectionMatrix, float[] mLightPosInEyeSpace) {
        this.mViewMatrix = mViewMatrix;
        this.mProjectionMatrix = mProjectionMatrix;
        this.mLightPosInEyeSpace = mLightPosInEyeSpace;
    }

    // render scene
    public void render() {
        // Tell OpenGL to use this program when rendering.
        GLES20.glUseProgram(mProgramHandle);

        // Draw objects in current scene
        for (BasicObject obj : mazeObjects) {
            // Draw plane
            Matrix.setIdentityM(mModelMatrix, 0);
            Matrix.translateM(mModelMatrix, 0, obj.getX(), obj.getY(), obj.getZ());
            Matrix.rotateM(mModelMatrix, 0, obj.getAngle(), 0, 1.0f, 0);
            obj.draw(mViewMatrix, mProjectionMatrix, mModelMatrix, mLightPosInEyeSpace);
        }

        // Render game pad
        GLES20.glUseProgram(mGamePadProgramHandle);
        gamePad.draw(mGamePadProjectionMatrix);

        // Render skybox
        Matrix.setIdentityM(mModelMatrix, 0);
        GLES20.glUseProgram(mSkyboxProgramHandle);
        skyBox.draw(mViewMatrix, mProjectionMatrix, mModelMatrix);
    }

    public void addObject(BasicObject obj) {
        // set program shader
        obj.setShaderHandles(mProgramHandle);

        // add
        mazeObjects.add(obj);
    }

    public void removeObject(BasicObject obj) {
        mazeObjects.remove(obj);
    }

    public boolean checkForCollision(float x, float y) {
        return mazeMap.checkForCollision(x, y);
    }

    public Vector3D getStartPos() { return mazeMap.getStartPos(); }
    public Vector3D getEndPos() { return mazeMap.getEndPos(); }

    public int generateShader() {
        //
        int vertexShader = GameRenderer.loadShader(GLES20.GL_VERTEX_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.vertex_shader));
        int fragmentShader = GameRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.fragment_shader));

        int programHandle = GLES20.glCreateProgram();             // create empty OpenGL Program
        if (programHandle != 0) {
            GLES20.glAttachShader(programHandle, vertexShader);   // add the vertex shader to program
            GLES20.glAttachShader(programHandle, fragmentShader); // add the fragment shader to program

            GLES20.glBindAttribLocation(programHandle, 0, "a_Position");
            GLES20.glBindAttribLocation(programHandle, 1, "a_Color");
            GLES20.glBindAttribLocation(programHandle, 2, "a_Normal");
            GLES20.glBindAttribLocation(programHandle, 3, "a_TexCoordinate");
        }
        GLES20.glLinkProgram(programHandle);                  // create OpenGL program executables

        return programHandle;
    }

    public int generateGamePadShader() {
        //
        int vertexShader = GameRenderer.loadShader(GLES20.GL_VERTEX_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.gamepad_vertex_shader));
        int fragmentShader = GameRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.gamepad_fragment_shader));

        int programHandle = GLES20.glCreateProgram();             // create empty OpenGL Program
        if (programHandle != 0) {
            GLES20.glAttachShader(programHandle, vertexShader);   // add the vertex shader to program
            GLES20.glAttachShader(programHandle, fragmentShader); // add the fragment shader to program

            GLES20.glBindAttribLocation(programHandle, 0, "a_Position");
        }
        GLES20.glLinkProgram(programHandle);                  // create OpenGL program executables

        return programHandle;
    }
    public int generateSkyboxShader() {
        //
        int vertexShader = GameRenderer.loadShader(GLES20.GL_VERTEX_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.skybox_vertex_shader));
        int fragmentShader = GameRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, RawResourceReader.readTextFileFromRawResource(mContextHandle, R.raw.fragment_shader));

        int programHandle = GLES20.glCreateProgram();             // create empty OpenGL Program
        if (programHandle != 0) {
            GLES20.glAttachShader(programHandle, vertexShader);   // add the vertex shader to program
            GLES20.glAttachShader(programHandle, fragmentShader); // add the fragment shader to program

            GLES20.glBindAttribLocation(programHandle, 0, "a_Position");
            GLES20.glBindAttribLocation(programHandle, 1, "a_TexCoordinate");
        }
        GLES20.glLinkProgram(programHandle);                  // create OpenGL program executables

        return programHandle;
    }



    // get context
    public Context getContext() { return mContextHandle; }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    //      Rendering
    //
    /** This will be used to pass in the transformation matrix. */
    public int mMVPMatrixHandle;

    /** This will be used to pass in the modelview matrix. */
    public int mMVMatrixHandle;

    /** This will be used to pass in the light position. */
    public int mLightPosHandle;

    /** This will be used to pass in model position information. */
    public int mPositionHandle;

    /** This will be used to pass in model color information. */
    public int mColorHandle;

    /** This will be used to pass in model normal information. */
    public int mNormalHandle;

    /** This will be used to pass in model texture coordinate information. */
    public int mTextureCoordinateHandle;

    /** This will be used to pass in the texture. */
    public int mTextureUniformHandle;

    /** This is a handle to our texture data. */
    public int mTextureDataHandle;
}

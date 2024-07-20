package robok.dev.opengl.Objects;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

import robok.dev.opengl.R;
import robok.dev.opengl.Scene.RawResourceReader;
import robok.dev.opengl.Utils.Vector3D;

public class Wall extends BasicObject{

    private final static float WALL_HEIGHT = 10.f;

    float width, height;

    /** Allocate storage for the final combined matrix. This will be passed into the shader program. */
    private float[] mMVPMatrix = new float[16];

    public Wall(Context context){
        super(context);
    }

    public Wall(Context context, float w, float h) {
        super(context);
        width = w;
        height = h;

        // Initialize the data: pos, color, normal, index and texture
        generatePlaneData(w, h);

        // Initialize buffers
        initializeBuffers();

        mTextureDataHandle = RawResourceReader.loadTexture(context, R.drawable.wall);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_REPEAT);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_REPEAT);
        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);
    }

    public Wall(Context context, Vector3D pos, float a, float h) {
        super(context);

        position = pos;
        angle = a;
        height = h;

    }

    public void setPosition(Vector3D pos, float a) {
        position = pos;
        angle = a;
    }

    @Override
    public void setShaderHandles(int ph) {
        mProgramHandle = ph;

        // Set program handles. These will later be used to pass in values to the program.
        // Set program handles for cube drawing.
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVPMatrix");
        mMVMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVMatrix");
        mLightPosHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_LightPos");
        mTextureUniformHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_Texture");
        mPositionHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Position");
        mColorHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Color");
        mNormalHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Normal");
        mTextureCoordinateHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_TexCoordinate");
    }
    @Override
    public void draw(float[] mViewMatrix, float[] mProjectionMatrix, float[] mModelMatrix, float[] mLightPosInEyeSpace) {
        GLES20.glUseProgram(mProgramHandle);

        // Set the active texture unit to texture unit 0.
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        // Bind the texture to this unit.
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mTextureDataHandle);

        // Tell the texture uniform sampler to use this texture in the shader by binding to texture unit 0.
        GLES20.glUniform1i(mTextureUniformHandle, 0);

        // Pass in the position information
        vertexBuffer.position(0);
        GLES20.glVertexAttribPointer(mPositionHandle, mPositionDataSize, GLES20.GL_FLOAT, false,
                0, vertexBuffer);
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Pass in the texture coordinate information
        textureBuffer.position(0);
        GLES20.glVertexAttribPointer(mTextureCoordinateHandle, mTextureCoordinateDataSize, GLES20.GL_FLOAT, false,
                0, textureBuffer);
        GLES20.glEnableVertexAttribArray(mTextureCoordinateHandle);

        // Pass in the color information
        colorBuffer.position(0);
        GLES20.glVertexAttribPointer(mColorHandle, mColorDataSize, GLES20.GL_FLOAT, false,
                0, colorBuffer);
        GLES20.glEnableVertexAttribArray(mColorHandle);

        // Pass in the normal information
        normalBuffer.position(0);
        GLES20.glVertexAttribPointer(mNormalHandle, mNormalDataSize, GLES20.GL_FLOAT, false,
                0, normalBuffer);
        GLES20.glEnableVertexAttribArray(mNormalHandle);

        // This multiplies the view matrix by the model matrix, and stores the result in the MVP matrix
        // (which currently contains model * view).
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);

        // Pass in the modelview matrix.
        GLES20.glUniformMatrix4fv(mMVMatrixHandle, 1, false, mMVPMatrix, 0);

        // This multiplies the modelview matrix by the projection matrix, and stores the result in the MVP matrix
        // (which now contains model * view * projection).
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);

        // Pass in the combined matrix.
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Pass in the light position in eye space.
        GLES20.glUniform3f(mLightPosHandle, mLightPosInEyeSpace[0], mLightPosInEyeSpace[1], mLightPosInEyeSpace[2]);

        // indices
        //     GLES20.glDrawElements(GLES20.GL_LINE_LOOP, 2 * 3, GLES20.GL_UNSIGNED_SHORT, indexBuffer);
        // Draw the square
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 6);
    }

    @Override
    public void draw(float[] mMVPMatrix) {

    }

    private void generateWallData(Vector3D bl, Vector3D br) {

        // X Y Z
        positionData = new float[]
                {
                        bl.x, bl.y + WALL_HEIGHT, bl.z,      // top left     0
                        br.x, br.y, br.z,               // bot right    1
                        bl.x, bl.y, bl.z,               // bot left     2
                        bl.x, bl.y + WALL_HEIGHT, bl.z,      // top left     3
                        br.x, br.y + WALL_HEIGHT, br.z,      // top right    4
                        br.x, br.y, br.z                // bot right    5
                };
        colorData = new float[]
                {
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f
                };
        normalData = new float[]
                {
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f
                };
        indexData = new short[]
                {
                        0, 1, 2,
                        0, 2, 3
                };
        textureData = new float[]
                {
                        0.0f, 0.0f,
                        1.0f, 1.0f,
                        0.0f, 1.0f,
                        0.0f,  0.0f,
                        1.0f,  0.0f,
                        1.0f, 1.0f,
                };
    }

    private void generatePlaneData(float hWidth, float hHeight) {

        // X Y Z
        positionData = new float[]
                {
                        -hWidth, hHeight, 0.0f,
                        hWidth, -hHeight, 0.0f,
                        -hWidth, -hHeight, 0.0f,
                        -hWidth,  hHeight, 0.0f,
                        hWidth,  hHeight, 0.0f,
                        hWidth, -hHeight, 0.0f
                };
        colorData = new float[]
                {
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f,
                        0.5f, 0.5f, 0.5f, 1.0f
                };
        normalData = new float[]
                {
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f,
                        0.0f, 0.0f, 1.0f
                };
        indexData = new short[]
                {
                        0, 1, 2,
                        0, 2, 3
                };
        textureData = new float[]
                {
                        0.0f, 0.0f,
                        1.0f, 1.0f,
                        0.0f, 1.0f,
                        0.0f,  0.0f,
                        1.0f,  0.0f,
                        1.0f, 1.0f,
                };
    }
}

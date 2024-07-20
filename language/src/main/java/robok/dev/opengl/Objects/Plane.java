package robok.dev.opengl.Objects;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

import robok.dev.opengl.R;
import robok.dev.opengl.Scene.RawResourceReader;

public class Plane extends BasicObject {

    /** Allocate storage for the final combined matrix. This will be passed into the shader program. */
    private float[] mMVPMatrix = new float[16];

    public Plane(Context context) {
        super(context);

        // Initialize the data: pos, color, normal, index and texture
        generatePlaneData(10.f, 10.f);

        // Initialize buffers
        initializeBuffers();

        mTextureDataHandle = RawResourceReader.loadTexture(context, R.drawable.floor);
//        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_REPEAT);
//        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_REPEAT);
//        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);
    }

    public Plane(Context context, float hWidth, float hHeight) {
        super(context);

        // Initialize the data: pos, color, normal, index and texture
        generatePlaneData(hWidth, hHeight);

        // Initialize buffers
        initializeBuffers();

        mTextureDataHandle = RawResourceReader.loadTexture(context, R.drawable.floor);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_REPEAT);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_REPEAT);
        GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);
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
    public void draw(float[] p) {

    }

    private void generatePlaneData(float hWidth, float hHeight) {


        // X Y Z
        positionData = new float[]
//                {
//                        -hWidth, 0.0f, -hHeight,
//                         hWidth, 0.0f, -hHeight,
//                         hWidth, 0.0f,  hHeight,
//                        -hWidth, 0.0f,  hHeight
//                };
                {
                        -hWidth, 0.0f,  hHeight,
                         hWidth, 0.0f, -hHeight,
                        -hWidth, 0.0f, -hHeight,
                        -hWidth, 0.0f,  hHeight,
                         hWidth, 0.0f,  hHeight,
                         hWidth, 0.0f, -hHeight
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
                        0.0f, 1.0f, 0.0f,
                        0.0f, 1.0f, 0.0f,
                        0.0f, 1.0f, 0.0f,
                        0.0f, 1.0f, 0.0f,
                        0.0f, 1.0f, 0.0f,
                        0.0f, 1.0f, 0.0f
                };
        indexData = new short[]
                {
                        0, 1, 2,
                        0, 2, 3
                };
        textureData = new float[]
                {
                        0.0f, 0.0f,
                        4.0f, 4.0f,
                        0.0f, 4.0f,
                        0.0f,  0.0f,
                        4.0f,  0.0f,
                        4.0f, 4.0f,
                };
    }
}

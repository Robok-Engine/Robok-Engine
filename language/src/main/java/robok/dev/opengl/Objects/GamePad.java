package robok.dev.opengl.Objects;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

public class GamePad extends BasicObject{

    private final float[] mMVPMatrix = new float[16];

    private final float[] mViewMatrix = new float[16];
    private final float[] mModelMatrix = new float[16];

    public GamePad(Context context) {
        super(context);

        generatePadPosData();

        // Initialize buffers
        initializeBuffers();

        Matrix.setLookAtM(mViewMatrix, 0, 0f, 0f, 1f, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
    }

    @Override
    public void setShaderHandles(int ph) {
        mProgramHandle = ph;

        mPositionHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Position");
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVPMatrix");
        mTextureDataHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_TexCoordinate");
        mPointThickness = GLES20.glGetUniformLocation(mProgramHandle, "u_Thickness");
    }

    @Override
    public void draw(float[] mViewMatrix, float[] mProjectionMatrix, float[] mModelMatrix, float[] mLightPosInEyeSpace) {
        GLES20.glUseProgram(mProgramHandle);

        // Enable generic vertex attribute array
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, 3,
                GLES20.GL_FLOAT, false,
                0, vertexBuffer);

        // Pass in the texture coordinate information
        textureBuffer.position(0);
        GLES20.glVertexAttribPointer(mTextureCoordinateHandle, mTextureCoordinateDataSize, GLES20.GL_FLOAT, false,
                0, textureBuffer);
        GLES20.glEnableVertexAttribArray(mTextureCoordinateHandle);

        // This multiplies the view matrix by the model matrix, and stores the result in the MVP matrix
        // (which currently contains model * view).
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);

        // This multiplies the modelview matrix by the projection matrix, and stores the result in the MVP matrix
        // (which now contains model * view * projection).
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Draw the triangle
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, indexData.length,
                GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }

    @Override
    public void draw(float[] projectionMatrix) {
        GLES20.glUseProgram(mProgramHandle);

        // Enable generic vertex attribute array
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, 3,
                GLES20.GL_FLOAT, false,
                0, vertexBuffer);

        // set point size
        GLES20.glUniform1f(mPointThickness, 50.f);

        // set model view matrix
        Matrix.setIdentityM(mModelMatrix, 0);
        // This multiplies the view matrix by the model matrix, and stores the result in the MVP matrix
        // (which currently contains model * view).
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);

        // This multiplies the modelview matrix by the projection matrix, and stores the result in the MVP matrix
        // (which now contains model * view * projection).
        Matrix.multiplyMM(mMVPMatrix, 0, projectionMatrix, 0, mMVPMatrix, 0);

        // Apply the projection and view transformation
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Draw the triangle
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, indexData.length,
                GLES20.GL_UNSIGNED_SHORT, indexBuffer);

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }

    private void generatePadPosData() {
        // We have create the vertices of our view.
        positionData = new float[]
                {
                        10.0f, 200f, 0.0f,
                        10.0f, 100f, 0.0f,
                        100f, 100f, 0.0f,
                        100f, 200f, 0.0f
                };

        textureData = new float[]
                {
                        0.0f, 0.0f,
                        0.0f, 1.0f,
                        1.0f, 1.0f,
                        1.0f, 0.0f
                };

        indexData = new short[] {0, 1, 2, 0, 2, 3};
    }
}

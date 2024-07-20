package robok.dev.opengl.Objects;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;

import robok.R;
import robok.dev.opengl.Scene.RawResourceReader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class SkyBox{

    private int mProgramHandle;

    public FloatBuffer[] vertexBuffer = new FloatBuffer[5];
    public FloatBuffer textureBuffer;

    private final static float SKYBOX_WIDTH = 500.f;

    private float[][] positionData = {
            // Left face
            {
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH
            },
            // Right face
            {
                    SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH
            },

            // Front face
            {
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH
            },

            // Back face
            {
                    SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, -SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH
            },



            // Top face
            {
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH,
                    -SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, SKYBOX_WIDTH,
                    SKYBOX_WIDTH, SKYBOX_WIDTH, -SKYBOX_WIDTH
            }
    };

    private float[] textureData = {
//            0.0f, 0.0f,
//            0.0f, 1.0f,
//            1.0f, 0.0f,
//            0.0f, 1.0f,
//            1.0f, 1.0f,
//            1.0f, 0.0f
            1.0f, 0.0f,
            1.0f, 1.0f,
            0.0f, 0.0f,
            1.0f, 1.0f,
            0.0f, 1.0f,
            0.0f, 0.0f
    };

    private int[] mTextureDataHandle = new int[5];

    private static final int LEFT = 0, RIGHT = 1, BACK = 2, FRONT = 3, TOP = 4;

    private float[] mMVPMatrix = new float[16];

    /** This will be used to pass in the transformation matrix. */
    public int mMVPMatrixHandle;

    /** This will be used to pass in model position information. */
    public int mPositionHandle;

    /** This will be used to pass in model texture coordinate information. */
    public int mTextureCoordinateHandle;

    /** This will be used to pass in the texture. */
    public int mTextureUniformHandle;

    public final int mPositionDataSize = 3;

    public final int mTextureCoordinateDataSize = 2;

    public void initializeBuffers() {
        //
        for (int i = 0; i< 5; i++) {
            vertexBuffer[i] = ByteBuffer.allocateDirect(positionData[i].length * BasicObject.BYTES_PER_FLOAT)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            vertexBuffer[i].put(positionData[i]).position(0);
        }
        textureBuffer = ByteBuffer.allocateDirect(textureData.length * BasicObject.BYTES_PER_FLOAT)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        textureBuffer.put(textureData).position(0);
    }

    public void setShaderHandle(int ph) {
        mProgramHandle = ph;

        // Set program handles. These will later be used to pass in values to the program.
        // Set program handles for cube drawing.
        mMVPMatrixHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_MVPMatrix");
        mTextureUniformHandle = GLES20.glGetUniformLocation(mProgramHandle, "u_Texture");
        mPositionHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_Position");
        mTextureCoordinateHandle = GLES20.glGetAttribLocation(mProgramHandle, "a_TexCoordinate");
    }

    public SkyBox(Context context) {
        //
        mTextureDataHandle[LEFT] = RawResourceReader.loadTexture(context, R.drawable.skybox_left);
        mTextureDataHandle[RIGHT] = RawResourceReader.loadTexture(context, R.drawable.skybox_right);
        mTextureDataHandle[BACK] = RawResourceReader.loadTexture(context, R.drawable.skybox_back);
        mTextureDataHandle[FRONT] = RawResourceReader.loadTexture(context, R.drawable.skybox_front);
        mTextureDataHandle[TOP] = RawResourceReader.loadTexture(context, R.drawable.skybox_top);

        // buffers
        initializeBuffers();
    }

    public void draw(float[] mViewMatrix, float[] mProjectionMatrix, float[] mModelMatrix ) {
        Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0);

        GLES20.glUseProgram(mProgramHandle);
        for (int i = 0; i< 5; i++) {
            drawFace(i);
        }
    }

    private void drawFace(int faceIndex) {
        // Set the active texture unit to texture unit 0.
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        // Bind the texture to this unit.
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, mTextureDataHandle[faceIndex]);

        // Tell the texture uniform sampler to use this texture in the shader by binding to texture unit 0.
        GLES20.glUniform1i(mTextureUniformHandle, 0);

        // Pass in the position information
        vertexBuffer[faceIndex].position(0);
        GLES20.glVertexAttribPointer(mPositionHandle, mPositionDataSize, GLES20.GL_FLOAT, false,
                0, vertexBuffer[faceIndex]);
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Pass in the texture coordinate information
        textureBuffer.position(0);
        GLES20.glVertexAttribPointer(mTextureCoordinateHandle, mTextureCoordinateDataSize, GLES20.GL_FLOAT, false,
                0, textureBuffer);
        GLES20.glEnableVertexAttribArray(mTextureCoordinateHandle);

        // Pass in the combined matrix.
        GLES20.glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mMVPMatrix, 0);

        // Draw the cube.
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 6);
    }

}

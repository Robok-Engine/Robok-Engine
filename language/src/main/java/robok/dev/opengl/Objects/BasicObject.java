package robok.dev.opengl.Objects;

import android.content.Context;

import robok.dev.opengl.Utils.Vector3D;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public abstract class BasicObject {
    public float[] positionData;
    public float[] colorData;
    public float[] normalData;
    public short[] indexData;
    public float[] textureData;


    public FloatBuffer vertexBuffer;
    public ShortBuffer indexBuffer;
    public FloatBuffer normalBuffer;
    public FloatBuffer colorBuffer;
    public FloatBuffer textureBuffer;

    public int mProgramHandle;

    public Context contextHandle;

    /** How many bytes per float. */
    public static final int BYTES_PER_FLOAT = 4;

    public static final int BYTES_PER_SHORT = 2;

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

    /** This is a handle to pass in the point size */
    public int mPointThickness;

    /** Size of the position data in elements. */
    public final int mPositionDataSize = 3;

    /** Size of the color data in elements. */
    public final int mColorDataSize = 4;

    /** Size of the normal data in elements. */
    public final int mNormalDataSize = 3;

    /** Size of the texture coordinate data in elements. */
    public final int mTextureCoordinateDataSize = 2;

    /** Position of the obejct*/
    protected Vector3D position;

    /** Angle for wall rotate */
    protected float angle  = 0;

    /** set get position */
    public void setPosition(Vector3D pos) { position = pos; }
    public Vector3D getPosition() { return position; }
    public float getX() { return position.x; }
    public float getY() { return position.y; }
    public float getZ() { return position.z; }
    public float getAngle() { return angle; }

    public BasicObject(Context context) {
        contextHandle = context;
        position = new Vector3D(0, 0, 0);
    }

    // shader
    public abstract void setShaderHandles(int ph);

    // draw
    public abstract void draw(float[] mViewMatrix, float[] mProjectionMatrix, float[] mModelMatrix, float[] mLightPosInEyeSpace);

    public abstract void draw(float[] p);

    public void initializeBuffers() {
        // Initialize the buffers.
        if (positionData != null) {
            vertexBuffer = ByteBuffer.allocateDirect(positionData.length * BYTES_PER_FLOAT)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            vertexBuffer.put(positionData).position(0);
        }

        if (colorData != null) {
            colorBuffer = ByteBuffer.allocateDirect(colorData.length * BYTES_PER_FLOAT)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            colorBuffer.put(colorData).position(0);
        }

        if(normalData != null) {
            normalBuffer = ByteBuffer.allocateDirect(normalData.length * BYTES_PER_FLOAT)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            normalBuffer.put(normalData).position(0);
        }

        if (indexData != null) {
            indexBuffer = ByteBuffer.allocateDirect(indexData.length * BYTES_PER_SHORT)
                    .order(ByteOrder.nativeOrder()).asShortBuffer();
            indexBuffer.put(indexData).position(0);
        }

        if (textureData != null) {
            textureBuffer = ByteBuffer.allocateDirect(textureData.length * BYTES_PER_FLOAT)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            textureBuffer.put(textureData).position(0);
        }
    }
}

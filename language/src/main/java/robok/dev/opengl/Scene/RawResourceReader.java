package robok.dev.opengl.Scene;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RawResourceReader {
    public static String readTextFileFromRawResource(final Context context, final int resourceId){
        {
            final InputStream inputStream = context.getResources().openRawResource(
                    resourceId);
            final InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream);
            final BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            String nextLine;
            final StringBuilder body = new StringBuilder();

            try
            {
                while ((nextLine = bufferedReader.readLine()) != null)
                {
                    body.append(nextLine);
                    body.append('\n');
                }
            }
            catch (IOException e)
            {
                return null;
            }

            return body.toString();
        }
    }

    public static int loadTexture(final Context context, final int resourceId){
        final int[] textureHandle = new int[1];

        GLES20.glGenTextures(1, textureHandle, 0);

        if (textureHandle[0] != 0){
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false; // no pre-scaling

            // read in the resource
            final Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                    resourceId, options);

            // bind to texture
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle[0]);

            // Set filtering
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
            GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);

            // Load the bitmap into the bound texture.
            GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);

            // Recycle the bitmap, since its data has been loaded into OpenGL.
            bitmap.recycle();
        }
        else{
            throw new RuntimeException("Error loading texture.");
        }

        return textureHandle[0];
    }
}

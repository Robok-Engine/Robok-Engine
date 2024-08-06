package robok.aapt2.compiler.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils2 {

    public static void copyFileFromAssets(Context context, String assetFileName, File outFile) throws IOException {
        try (InputStream in = context.getAssets().open(assetFileName);
             FileOutputStream out = new FileOutputStream(outFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
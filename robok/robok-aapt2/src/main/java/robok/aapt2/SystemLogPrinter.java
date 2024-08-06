package robok.aapt2;

import java.io.PrintStream;
import java.io.OutputStream;

import robok.aapt2.logger.Logger;

public class SystemLogPrinter {

    public static void start(Logger logger) {
        //reset
        FileUtil.writeFile(ApplicationLoader.applicationContext.getExternalFilesDir(null) + "/logs.txt", "");

        PrintStream ps = new PrintStream(new OutputStream() {
            private String cache;

            @Override
            public void write(int b) {
                if (cache == null) cache = "";

                if (((char) b) == '\n') {
                    //write each line printed to the specified path
                    logger.d("System.out", cache);
                    cache = "";
                } else {
                    cache += (char) b;
                }
            }
        });

        System.setOut(ps);
        System.setErr(ps);
    }
}
package org.robok.aapt2;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import java.io.PrintStream;
import java.io.OutputStream;

import org.robok.aapt2.logger.Logger;
import org.robok.aapt2.util.FileUtil;

import org.gampiot.robok.core.utils.application.RobokApplication;

public class SystemLogPrinter {

    public static void start(Logger logger) {
        //reset
        FileUtil.writeFile(RobokApplication.robokContext.getExternalFilesDir(null) + "/logs.txt", "");

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
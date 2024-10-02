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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryExecutor {

    private final ProcessBuilder mProcess = new ProcessBuilder();
    private final StringWriter mWriter = new StringWriter();

    public void setCommands(ArrayList<String> arrayList) {
        mProcess.command(arrayList);
    }

    public String execute() {
		
        try {
			Process process = mProcess.start();
            Scanner scanner = new Scanner(process.getErrorStream());
            while (scanner.hasNextLine()) {
                mWriter.append(scanner.nextLine());
                mWriter.append(System.lineSeparator());
            }
			
			process.waitFor();
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(mWriter));
        }
        return mWriter.toString();
    }

    public String getLog() {
        return mWriter.toString();
    }
}
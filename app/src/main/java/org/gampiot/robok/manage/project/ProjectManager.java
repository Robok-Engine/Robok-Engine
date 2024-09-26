package org.gampiot.robok.manage.project;

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

import android.content.Context;
import android.os.Environment;

import org.gampiot.robok.models.project.ProjectTemplate;
import org.gampiot.robok.feature.template.code.java.JavaClassTemplate;
import org.gampiot.robok.feature.template.code.android.game.logic.GameScreenLogicTemplate;
import org.gampiot.robok.feature.component.terminal.RobokTerminalWithRecycler;

import org.robok.aapt2.compiler.CompilerTask;
import org.robok.aapt2.model.Project;
import org.robok.aapt2.model.Library;
import org.robok.aapt2.logger.Logger;
import org.robok.aapt2.SystemLogPrinter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundExeception;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ProjectManager {

    private CreationListener creationListener;
    private Context context;
    private File outputPath;
    
    public ProjectManager () {}
    
    public ProjectManager (Context context) {
         this.context = context;
    }
    
    public void setProjectPath(File value) {
         outputPath = value;
    }
    
    public File getProjectPath() {
         return outputPath;
    }
    
    public void create(String projectName, String packageName, ProjectTemplate template) {
        try {
            InputStream zipFileInputStream = context.getAssets().open(template.getZipFileName());
            
            if (!outputPath.exists()) {
                outputPath.mkdirs();
            }

            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(zipFileInputStream));
            ZipEntry zipEntry;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (!zipEntry.isDirectory()) {
                    String entryName = zipEntry.getName();
                    String outputFileName = entryName
                            .replace(template.getName(), projectName)
                            .replace("game/logic/$pkgName", "game/logic/" + packageName.replace('.', '/'));
                    
                    File outputFile = new File(outputPath, outputFileName);

                    if (!outputFile.getParentFile().exists()) {
                        outputFile.getParentFile().mkdirs();
                    }

                    FileOutputStream fos = new FileOutputStream(outputFile);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = zipInputStream.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                    fos.close();
                }
                zipInputStream.closeEntry();
            }

            zipInputStream.close();
            
            createJavaClass(projectName, packageName);

        } catch (FileNotFoundExeception e) {
            e.printStackTrace();
            creationListener.onProjectCreateError(e.toString() + " Method: create, line: 103");
        }
    }

    private void createJavaClass(String projectName, String packageName) {
        try {
            GameScreenLogicTemplate template = new GameScreenLogicTemplate();
            template.setCodeClassName("MainScreen");
            template.setCodeClassPackageName(packageName);
            template.configure();
            
            String classFilePath = "game/logic/" + packageName.replace('.', '/') + "/" + template.getClassName() + ".java";
            File javaFile = new File(outputPath, classFilePath);

            if (!javaFile.getParentFile().exists()) {
                javaFile.getParentFile().mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(javaFile);
            fos.write(template.getCodeClassContent().getBytes());
            fos.close();
            creationListener.onProjectCreate();

        } catch (FileNotFoundExeception e) {
            e.printStackTrace();
            creationListener.onProjectCreateError(e.toString() + " Method: create, line: 128");
        }
    }
    
    public void build () {
         var terminal = new RobokTerminalWithRecycler(context);
         var logger = new Logger();
         logger.attach(terminal.getRecyclerView());
         SystemLogPrinter.start(logger);
         Project project = new Project();
         project.setLibraries(Library.fromFile(new File("")));
         project.setResourcesFile(new File(getProjectPath().getAbsolutePath() + "/game/res/"));
         project.setOutputFile(new File(getProjectPath().getAbsolutePath() + "/build/"));
         project.setJavaFile(new File(getProjectPath().getAbsolutePath() + "/game/logic/"));
         project.setManifestFile(new File(getProjectPath().getAbsolutePath() + "/game/AndroidManifest.xml"));
         project.setLogger(logger);
         project.setMinSdk(21);
         project.setTargetSdk(28);
         CompilerTask task = new CompilerTask(context);
         task.execute(project);
         terminal.show();
    }
    
    public void setListener (CreationListener creationListener) {
         this.creationListener = creationListener;
    }
    
    public interface CreationListener {
         public void onProjectCreate();
         public void onProjectCreateError(String error);
    }
}

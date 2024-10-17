package org.robok.engine.manage.project;

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
 *  along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.robok.engine.models.project.ProjectTemplate;
import org.robok.engine.core.templates.code.android.game.logic.GameScreenLogicTemplate;
import org.robok.engine.core.components.terminal.RobokTerminalWithRecycler;
import org.robok.engine.core.utils.ZipUtilsKt

import org.robok.engine.feature.compiler.CompilerTask;
import org.robok.engine.feature.compiler.model.Project;
import org.robok.engine.feature.compiler.model.Library;
import org.robok.engine.feature.compiler.logger.Logger;
import org.robok.engine.feature.compiler.SystemLogPrinter;

public class ProjectManager {

    private CreationListener creationListener;
    public static final String TAG = "ProjectManager";
    private Context context;
    private File outputPath;

    public ProjectManager() {}

    public ProjectManager(Context context) {
        this.context = context;
    }

    public void setProjectPath(File value) {
        outputPath = value;
    }

    public File getProjectPath() {
        return outputPath;
    }
    
    public String getProjectName() {
        return getProjectPath().substring(getProjectPath().lastIndexOf("/") + 1);
    }
    
    public File getLibsPath() {
        return new File(context.getFilesDir(), getProjectName());
    }

    public void create(String projectName, String packageName, ProjectTemplate template) {
        Log.e(TAG, "ProjectName" + projectName);
        Log.e(TAG, "PackageName" + packageName);
        Log.e(TAG, template.toString());
        
        if (outputPath == null) {
            throw new IllegalStateException("outputPath has not been initialized.");
        }

        try (InputStream zipFileInputStream = context.getAssets().open(template.getZipFileName());
             ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(zipFileInputStream))) {

            if (!outputPath.exists()) {
                outputPath.mkdirs();
            }

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

                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                zipInputStream.closeEntry();
            }

            createJavaClass(projectName, packageName);
            extractLibs(projectName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            notifyCreationError(e, "create");
        } catch (IOException e) {
            e.printStackTrace();
            notifyCreationError(e, "create");
        }
    }

    private void createJavaClass(String projectName, String packageName) {
        if (outputPath == null) {
            throw new IllegalStateException("outputPath has not been initialized.");
        }

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

            try (FileOutputStream fos = new FileOutputStream(javaFile)) {
                fos.write(template.getCodeClassContent().getBytes());
            }

            if (creationListener != null) {
                creationListener.onProjectCreate();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            notifyCreationError(e, "createJavaClass");
        } catch (IOException e) {
            e.printStackTrace();
            notifyCreationError(e, "createJavaClass");
        }
    }
    
    private void extractLibs(String projectName) {
        ZipUtilsKt.extractZipFromAssets(context, "libs.zip", getLibsPath());
    }

    public void build(CompilerTask.OnCompileResult result) {
        if (outputPath == null) {
            throw new IllegalStateException("outputPath has not been initialized.");
        }

        try {
            RobokTerminalWithRecycler terminal = new RobokTerminalWithRecycler(context);
            Logger logger = new Logger();
            logger.attach(terminal.getRecyclerView());
            SystemLogPrinter.start(context, logger);
            
            Project project = new Project();
            project.setLibraries(Library.fromFile(new File(getProjectPath().getAbsolutePath() + "/libs/")));
            project.setResourcesFile(new File(getProjectPath().getAbsolutePath() + "/game/res/"));
            project.setOutputFile(new File(getProjectPath().getAbsolutePath() + "/build/"));
            project.setJavaFile(new File(getProjectPath().getAbsolutePath() + "/game/logic/"));
            project.setManifestFile(new File(getProjectPath().getAbsolutePath() + "/game/AndroidManifest.xml"));
            project.setLogger(logger);
            project.setMinSdk(21);
            project.setTargetSdk(28);

            CompilerTask task = new CompilerTask(context, result);
            task.execute(project);

            terminal.show();

        } catch (Exception e) {
            e.printStackTrace();
            notifyCreationError(e, "build");
        }
    }

    public void setListener(CreationListener creationListener) {
        this.creationListener = creationListener;
    }

    private void notifyCreationError(Exception e, String methodName) {
        if (creationListener != null) {
            creationListener.onProjectCreateError(e.toString() + " Method: " + methodName);
        }
    }

    public interface CreationListener {
        void onProjectCreate();
        void onProjectCreateError(String error);
    }
}
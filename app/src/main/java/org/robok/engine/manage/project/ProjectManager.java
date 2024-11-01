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

import android.os.Environment;
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.robok.engine.models.project.ProjectTemplate;
import org.robok.engine.templates.logic.ScreenLogicTemplate;
import org.robok.engine.templates.xml.AndroidManifestTemplate;
import org.robok.engine.core.components.terminal.RobokTerminalWithRecycler;
import org.robok.engine.core.utils.ZipUtilsKt;
import org.robok.engine.core.utils.FileUtil;

import org.robok.engine.feature.compiler.CompilerTask;
import org.robok.engine.feature.compiler.model.Project;
import org.robok.engine.feature.compiler.model.Library;
import org.robok.engine.feature.compiler.logger.Logger;
import org.robok.engine.feature.compiler.SystemLogPrinter;

public class ProjectManager {

    private static final String TAG = "ProjectManager";
    private static final File PROJECTS_PATH = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Robok/Projects/");
    
    private Context context;
    private File projectPath;
    private CreationListener creationListener;

    public ProjectManager() {}

    public ProjectManager(Context context) {
        this.context = context;
    }
    
    /*
     * Create Project Folders & Extract Template
     * @param projectName: Name of Project
     * @param packageName: Package Name of Project
     * @param template: A Instance of Template selected from user
     */
    public void create(String projectName, String packageName, ProjectTemplate template) {
        if (projectPath == null) {
            notifyCreationError("projectPath has not been initialized.", "create");
        }

        try (InputStream zipFileInputStream = context.getAssets().open(template.getZipFileName());
             ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(zipFileInputStream))) {

            if (!projectPath.exists()) {
                projectPath.mkdirs();
            }

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (!zipEntry.isDirectory()) {
                    String entryName = zipEntry.getName();
                    String outputFileName = entryName
                            .replace(template.getName(), projectName)
                            .replace("game/logic/$pkgName", "game/logic/" + packageName.replace('.', '/'));

                    File outputFile = new File(projectPath, outputFileName);

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

            createMainScreen(projectName, packageName);
            createAndroidManifest(packageName);
            extractLibs(projectName);

        } catch (FileNotFoundException e) {
            notifyCreationError(e, "create");
        } catch (IOException e) {
            notifyCreationError(e, "create");
        }
    }
    
    /*
     * Create Main Screen .
     * @param projectName, Name of actually project.
     * @parsm packageName, Package Name of actually project.
     */
    private void createMainScreen(
        String projectName, 
        String packageName
    ) {
        if (projectPath == null) {
            notifyCreationError("projectPath has not been initialized.", "createMainScreen");
        }

        try {
            ScreenLogicTemplate template = new ScreenLogicTemplate();
            template.setName("MainScreen");
            template.setPackageName(packageName);

            String classFilePath = "game/logic/" + packageName.replace('.', '/') + "/" + template.getName() + ".java";
            File javaFile = new File(projectPath, classFilePath);

            if (!javaFile.getParentFile().exists()) {
                javaFile.getParentFile().mkdirs();
            }

            try (FileOutputStream fos = new FileOutputStream(javaFile)) {
                fos.write(template.getCode().getBytes());
            }

        } catch (FileNotFoundException e) {
            notifyCreationError(e, "createMainScreen");
        } catch (IOException e) {
            notifyCreationError(e, "createMainScreen");
        }
    }
    
    /*
     * Create AndroidManifest.xml
     * @param packageName A Package Name of Current Project 
     */
    private void createAndroidManifest(String packageName) {
        var androidManifest = new AndroidManifestTemplate();
        androidManifest.setPackageName(packageName);
        FileUtil.writeFile(getAndroidManifestPath().getAbsolutePath() + "/AndroidManifest.xml", androidManifest.getCode());
    }
    
    /*
     * Extract some necessary libraries to the private directory.
     * TODO: 
     *  A better way to deal with libs, because when the user deletes the project, the libs persist.
     *  When the user imports a project outside of robok, the libs will not be found.
     */
    private void extractLibs(String projectName) {
        ZipUtilsKt.extractZipFromAssets(context, "libs.zip", getLibsPath());
        
        if (creationListener != null) {
            creationListener.onProjectCreate();
        }
    }
    
    /*
     * Build Project APK
     * Uses AAPT2
     * See {@link feature/compiler module}
     * @param result A Instance of CompilerTask.OnCompileResult, that returns apk.
     */
    public void build(CompilerTask.OnCompileResult result) {
        if (projectPath == null) {
            notifyCreationError("projectPath has not been initialized.", "build");
        }

        try {
            RobokTerminalWithRecycler terminal = new RobokTerminalWithRecycler(context);
            Logger logger = new Logger();
            logger.attach(terminal.getRecyclerView());
            SystemLogPrinter.start(context, logger);
            
            Project project = new Project();
            project.setLibraries(Library.fromFile(getLibsPath()));
            project.setResourcesFile(getAndroidResPath());
            project.setOutputFile(new File(getProjectPath().getAbsolutePath() + "/build/"));
            project.setJavaFile(new File(getProjectPath().getAbsolutePath() + "/game/logic/"));
            project.setManifestFile(new File(getAndroidManifestPath().getAbsolutePath() + "/AndroidManifest.xml"));
            project.setLogger(logger);
            project.setMinSdk(Config.MIN_SDK);
            project.setTargetSdk(Config.TARGET_SDK);

            CompilerTask task = new CompilerTask(context, result);
            task.execute(project);

            terminal.show();

        } catch (Exception e) {
            notifyCreationError(e, "build");
        }
    }
    
    /*
     * Define listener for creationListener
     * @param instance of CreationListener interface
     */
    public void setListener(CreationListener creationListener) {
        this.creationListener = creationListener;
    }
    
    /*
     * Define projectPath Variable
     * @param value New File of Project Path
     */
    public void setProjectPath(File value) {
        projectPath = value;
    }
    
    /*
     * Method to get current project path
     * @return File instance of ProjectPath.
     */
    public File getProjectPath() {
        return projectPath;
    }
    
    /*
     * Method to get current project name
     * @return String of ProjectName.
     */
    public String getProjectName() {
        var v = getProjectPath().getAbsolutePath().substring(getProjectPath().getAbsolutePath().lastIndexOf("/") + 1);
        return v;
    }
    
    /*
     * Method to get current project libs path
     * @return File instance of ProjectLibsPath.
     */
    public File getLibsPath() {
        var path = new File(context.getFilesDir(), getProjectName() + "/libs/");
        return path;
    }
    
    /*
     * Method to get all projects path
     * @return A File instance ot Projects Path
     */
    public static File getProjectsPath() {
        return PROJECTS_PATH;
    }
    
    /*
     * Method to get AndroidManifest file path
     * @return A File instance of AndroidManifest path
     */
    private File getAndroidManifestPath() {
        var path = new File(context.getFilesDir(), getProjectName() + "/xml/");
        return path;
    }
    
    /*
     * Method to get Android Res file path
     * @return A File instance of Android Res path
     */
    private File getAndroidResPath() {
        var path = new File(context.getFilesDir(), getProjectName() + "/xml/res/");
        return path;
    }
    
    /*
     * Notify Error method to CreateProjectScreen 
     * @param value A Message of Error
     */
    private void notifyCreationError(String value) {
        if (creationListener != null) {
            creationListener.onProjectCreateError(value);
        }
    }
    
    /*
     * Notify Error method to CreateProjectScreen 
     * @param value A Message of Error
     * @param methodName Name of the method where the error occurred
     */
    private void notifyCreationError(
        String value,
        String methodName
    ) {
        if (creationListener != null) {
            creationListener.onProjectCreateError(value + " Method: " + methodName);
        }
    }
    
    /*
     * Notify Error method to CreateProjectScreen 
     * @param e, A Exeception of error 
     * @param methodName Name of the method where the error occurred
     */
    private void notifyCreationError(
        Exception e,
        String methodName
    ) {
        if (creationListener != null) {
            creationListener.onProjectCreateError(e.toString() + " Method: " + methodName);
        }
    }

    public interface CreationListener {
        void onProjectCreate();
        void onProjectCreateError(String error);
    }
    
    public static final class Config {
        public static final int MIN_SDK = 21;
        public static final int TARGET_SDK = 28;
    }
}
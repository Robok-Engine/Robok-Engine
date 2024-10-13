package org.robok.engine.feature.compiler.incremental;

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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.android.tools.r8.D8;

import org.robok.engine.feature.compiler.model.Project;
import org.robok.engine.feature.compiler.model.Library;
import org.robok.engine.feature.compiler.Compiler;
import org.robok.engine.feature.compiler.exception.*;

public class IncrementalD8Compiler extends Compiler {
    
	private static final String TAG = "Incremental D8";
	
    private Project mProject;
    
    private Context glbContext;
    
    public IncrementalD8Compiler(Context context, Project project) {
        super(context);
        glbContext = context;
        mProject = project;
        setTag(TAG);
    }
    
    @Override
    public void prepare() {
    
    }
    
    @Override
    public void run() throws CompilerException {
        onProgressUpdate("Running...");
	//	mProject.getLogger().d(TAG, "Running...");
     
        List<String> args = new ArrayList<>();
        
        args.add("--release");
        args.add("--min-api"); 
        args.add(String.valueOf(mProject.getMinSdk()));
        args.add("--lib");
        args.add(getAndroidJarFile().getAbsolutePath());
        args.add("--output");
        args.add(mProject.getOutputFile() + "/bin/");
        
        List<File> classes = getClassFiles(new File(mProject.getOutputFile() + "/intermediate/classes/"));
		for (File file : classes) {
		    args.add(file.getAbsolutePath());
		}
		
		for (Library library : mProject.getLibraries()) {
			
			if (library.getDexFiles().isEmpty()) {
				try {
				    dexLibrary(library);
				} catch (Exception e) {
				    //throw new CompilerException(e.getMessage());
                    mProject.getLogger().e(TAG, e.getMessage());
                    setIsCompilationSuccessful(false);
				}
			}
            for (File dexFile : library.getDexFiles()) {
                args.add(dexFile.getAbsolutePath());
            }
        }
        
        try {
            D8.main(args.toArray(new String[0]));
        } catch (Exception e) {
            //throw new CompilerException(e.getMessage());
            mProject.getLogger().e(TAG, e.getMessage());
            setIsCompilationSuccessful(false);
        }
        
        args.clear();
       /* onProgressUpdate("D8 > Merging dex files");
        
        for (File file : getDexFiles()) {
            args.add(file.getAbsolutePath());
        }
        args.add("--output");
		
		File dexPath = new File(mProject.getWorkingDirectory() + "/bin/dex/");
		dexPath.mkdirs();
        args.add(dexPath.getAbsolutePath());
        
        for (Library library : mProject.getLibraries()) {
            for (File dexFile : library.getDexFiles()) {
                args.add(dexFile.getAbsolutePath());
            }
        }
        try {
            D8.main(args.toArray(new String[0]));
        } catch (Exception e) {
            throw new CompilerException(e.getMessage());
        }*/
        
    }
    
    public List<File> getDexFiles() {
        List<File> files = new ArrayList<>();
        
        File[] fileArr = new File(mProject.getOutputFile(), "/bin/classes/").listFiles();
        
        if (fileArr == null) {
            return files;
        }
        
        for (File file : fileArr) {
            if (file.getName().startsWith("classes") && file.getName().endsWith(".dex")) {
                files.add(file);
            }
        }
        
        return files;
    }
    
    private List<File> getClassFiles(File dir) {
        List<File> files = new ArrayList<>();
        File[] fileArr = dir.listFiles();
        if (fileArr == null) {
            return files;
        }
        
        for (File file : fileArr) {
            if (file.isDirectory()) {
                files.addAll(getClassFiles(file));
            } else {
                files.add(file);
            }
        }
        
        return files;
    }
	
	private void dexLibrary(Library library) throws Exception {
		
		mProject.getLogger().d(TAG, "Library " + library.getName() + " does not have a dex file, generating one");
		
		List<String> args = new ArrayList<>();
		args.add("--release");
        args.add("--min-api"); 
        args.add(String.valueOf(mProject.getMinSdk()));
		args.add("--lib");
		args.add(getAndroidJarFile().getAbsolutePath());
		args.add("--output");
		args.add(library.getPath().getAbsolutePath());
		args.add(library.getClassJarFile().getAbsolutePath());
	
        D8.main(args.toArray(new String[0]));
        
	}
}
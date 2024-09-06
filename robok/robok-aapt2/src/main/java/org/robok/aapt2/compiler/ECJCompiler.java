package org.robok.aapt2.compiler;

import org.eclipse.jdt.internal.compiler.batch.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;

import org.robok.aapt2.util.FileUtil;
import org.robok.aapt2.util.Decompress;
import org.robok.aapt2.model.Project;
import org.robok.aapt2.model.Library;
import org.robok.aapt2.compiler.exception.CompilerException;
import org.robok.aapt2.compiler.exception.AAPT2CompileException;

public class ECJCompiler extends Compiler {
    
	private static final String TAG = "ECJ";
	
	private Project mProject;
	
	public ECJCompiler(Project project) {
		mProject = project;
        setTag(TAG);
	}
	
	@Override
	public void prepare() {
		
	}
	
	@Override
	public void run() throws CompilerException {
		
		onProgressUpdate("Compiling java files...");
        onProgressUpdate("Running...");
	//	mProject.getLogger().d(TAG, "Running...");
		
		CompilerOutputStream errorOutputStream = new CompilerOutputStream(new StringBuffer());
        PrintWriter errWriter = new PrintWriter(errorOutputStream);

        CompilerOutputStream outputStream = new CompilerOutputStream(new StringBuffer());
        PrintWriter outWriter = new PrintWriter(outputStream);

        ArrayList<String> args = new ArrayList<>();
		
		args.add("-1.8");
		args.add("-proc:none");
		args.add("-nowarn");
		args.add("-d");
		File file = new File(mProject.getOutputFile() + "/bin/classes/");
		file.mkdir();
		args.add(file.getAbsolutePath());
		
		args.add("-cp");
		StringBuilder libraryString = new StringBuilder();
		
		libraryString.append(getAndroidJarFile().getAbsolutePath());
		libraryString.append(":");
		for (Library library : mProject.getLibraries()) {
			File classFile = library.getClassJarFile();
			if (classFile.exists()) {
				libraryString.append(classFile.getAbsolutePath());
				libraryString.append(":");
			}
		}
		libraryString.append(getLambdaFactoryFile().getAbsolutePath());
		args.add(libraryString.toString());
		
		args.add("-sourcepath");
		args.add(" ");
		
	    args.add(mProject.getJavaFile().getAbsolutePath());
		
		
		for (File resourceFile : getJavaFiles(new File(mProject.getOutputFile() + "/gen"))) {
			args.add(resourceFile.getAbsolutePath());
		}
		
		Main main = new Main(outWriter, errWriter, false, null, null);
		
		main.compile(args.toArray(new String[0]));
		
		if (main.globalErrorsCount > 0) {
			//throw new CompilerException(errorOutputStream.buffer.toString());
            mProject.getLogger().e(TAG, errorOutputStream.buffer.toString());
            setIsCompilationSuccessful(false);
		}
		
	}
	
	private List<File> getJavaFiles(File dir) {
		
		List<File> files = new ArrayList<>();
		
		File[] childs = dir.listFiles();
		
		if (childs != null) {
			for (File child : childs) {
				
				if (child.isDirectory()) {
					files.addAll(getJavaFiles(child));
					continue;
				}
				if (child.getName().endsWith(".java"));{
					files.add(child);
				}
			}
		}
		return files;
	}
	
	private class CompilerOutputStream extends OutputStream {

        public StringBuffer buffer;
	
        public CompilerOutputStream(StringBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void write(int b) {
			
			if (b == '\n') {
				mProject.getLogger().d(TAG, buffer.toString());
				buffer = new StringBuffer();
				return;
			}
            buffer.append((char) b);
        }
    }
}
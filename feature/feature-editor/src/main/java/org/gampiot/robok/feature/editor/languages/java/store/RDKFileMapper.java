package org.gampiot.robok.feature.editor.languages.java.store;

/*
* JavaClasses
* Class used to store robok classes
* Only those necessary for development with Robok.
* @author ThDev-Only
*/

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import org.gampiot.robok.feature.util.application.RobokApplication;

public class RDKFileMapper {
    
    private HashMap<String, String> robokClass;
    private String rdkAtual = "RDK-1";
    File rdkDirectory;
    
    public RDKFileMapper(){
        robokClass = new HashMap<>();
        rdkDirectory = new File(RobokApplication.robokContext.getFilesDir(), rdkAtual + "/rdk/");
        
    }
    
    public void load(){
        this.robokClass = mapRdkClasses();
    }
    
    public HashMap<String, String> getClasses() {
        return this.robokClass;
    }
    
    // Method that returns a HashMap with the names of the classes and their formatted directories
    public HashMap<String, String> mapRdkClasses() {
        File rdkFolder = rdkDirectory;

        if (rdkFolder.exists() && rdkFolder.isDirectory()) {
            mapClassesRecursively(rdkFolder, "", robokClass);
        }else{
            robokClass.put("ErrorRdkNaoExiste", "com.error.rdk.ErrorRdkNaoExiste");
        }

        return robokClass;
    }

    // Recursive method to map .class classes into the directory
    private void mapClassesRecursively(File folder, String packageName, HashMap<String, String> robokClass) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // Update package name as you cycle through folders
                String newPackageName = packageName.isEmpty() ? file.getName() : packageName + "." + file.getName();
                mapClassesRecursively(file, newPackageName, robokClass);
            } else if (file.getName().endsWith(".class")) {
                // Remove the .class extension and map the class
                String className = file.getName().replace(".class", "");
                String classPath = packageName + "." + className;
                robokClass.put(className, classPath);
            }
        }
    }

    //Method to create URLClassLoader from base directory
    public URLClassLoader getClassLoader() throws Exception {
        File file = new File(rdkDirectory);

        // Converts the base directory to a URL
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        // Returns the URLClassLoader for loading classes
        return new URLClassLoader(urls);
    }

    /*public static void main(String[] args) throws Exception {
        // Diretório base onde os arquivos .class estão localizados
        String rdkDirectory = "/caminho/para/sua/classe/";

        // Cria o HashMap mapeando os arquivos .class
        HashMap<String, String> robokClass = 

        // Exemplo de uso do HashMap
        System.out.println(robokClass.get("Physics")); // Exemplo: robok.physics.Physics

        // Cria o URLClassLoader
        URLClassLoader classLoader = getClassLoader(rdkDirectory);

        // Carrega as classes com base no nome completo (pacote + nome da classe)
        Class<?> class1 = classLoader.loadClass(robokClass.get("Physics"));
        Class<?> class2 = classLoader.loadClass(robokClass.get("Graphic"));
        Class<?> class3 = classLoader.loadClass(robokClass.get("Util"));

        // Exibe os nomes das classes carregadas
        System.out.println("Classe 1: " + class1.getName());
        System.out.println("Classe 2: " + class2.getName());
        System.out.println("Classe 3: " + class3.getName());

        // Fecha o classLoader após o uso
        classLoader.close();
    }*/
}
package org.gampiot.robokide.feature.template.code.java;

import android.os.Parcel;

import org.gampiot.robokide.feature.template.code.CodeTemplate;

public class JavaClassTemplate extends CodeTemplate {

     public JavaClassTemplate() {}

     public JavaClassTemplate(Parcel in) {
          super(in);
     }
     
     @Override
     public String getName() {
          return "Java class";
     }
     
     @Override
     public void configure() {
          setContent(
               "package "
               + CodeTemplate.PACKAGE_NAME
               + ";\n"
               + "\npublic class "
               + CodeTemplate.CLASS_NAME
               + " {\n\t\n}"
          );
     }
     
     @Override
     public String getExtension() {
          return ".java";
     }
}

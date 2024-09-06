package org.robok.lang.method;

public class Method {

     private String name;
     private String parameters;
     private String code;

     public Method(String name, String parameters, String code) {
          this.name = name;
          this.parameters = parameters;
          this.code = code;
     }

     public String getName() {
          return this.name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getParameters() {
          return this.parameters;
     }

     public void setParameters(String parameters) {
          this.parameters = parameters;
     }

     public String getCode() {
          return this.code;
     }

     public void setCode(String code) {
          this.code = code;
     }
}
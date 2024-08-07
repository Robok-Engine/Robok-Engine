package org.gampiot.robokide.feature.template.code.rbk;

import android.os.Parcel;

import org.gampiot.robokide.feature.template.code.CodeTemplate;

public class RBKLayoutTemplate extends CodeTemplate {

     public RBKLayoutTemplate() {}

     public RBKLayoutTemplate(Parcel in) {
          super(in);
     }
     
     @Override
     public String getName() {
          return "RBK Layout File";
     }
     
     @Override
     public void configure() {
          setContent("not ready");
     }
     
     @Override
     public String getExtension() {
          return ".rbk";
     }
}

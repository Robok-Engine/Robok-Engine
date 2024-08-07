package org.gampiot.robokide.feature.template.code;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CodeTemplate implements Parcelable {

      public static final Parcelable.Creator<CodeTemplate> CREATOR =
          new Parcelable.Creator<CodeTemplate>() {
               @Override
               public CodeTemplate createFromParcel(Parcel parcel) {
                    return new CodeTemplate(parcel);
               }
               
               @Override
               public CodeTemplate[] newArray(int ji) {
                    return new CodeTemplate[ji];
               }
          };
          
      public static final String PACKAGE_NAME = "${packageName}";
      public static final String CLASS_NAME = "${className}";
      
      protected String codeContent;
          
      public CodeTemplate() {}
          
      public CodeTemplate(Parcel in) {
           codeContent = in.readString();
      }
          
      public final String get() {
           configure();
           return codeContent;
      }
      
      public final void setContent(String contents) {
           codeContent = contents;
      }
      
      public void configure() {}
      
      public String getName() {
           throw new IllegalStateException("getName() is not subclassed");
      }
      
      public String getExtension() {
           throw new IllegalStateException("getExtension() is not subclassed");
      }
      
      @NonNull
      @Override
      public String toString() {
           return getName();
      }
      
      @Override
      public int describeContents() {
           return 0;
      }
      
      @Override
      public void writeToParcel(Parcel parcel, int ji) {
           parcel.writeString(codeContent);
      }
}

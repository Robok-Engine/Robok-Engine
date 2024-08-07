package org.gampiot.robokide.feature.template.code.android;

import android.os.Parcel;

import org.gampiot.robokide.feature.template.code.CodeTemplate;
import org.gampiot.robokide.feature.template.code.java.JavaClassTemplate;

public class GameScreen extends JavaClassTemplate {

     public GameScreen() {
           super();
     }

     public GameScreen(Parcel in) {
          super(in);
     }
     
     @Override
     public String getName() {
          return "GameScreen";
     }
     
     @Override
     public void configure() {
          setContents(
               "package "
                + CodeTemplate.PACKAGE_NAME
                + ";\n\n"
                + "import robok.game.GameScreen;\n\n"
                + "public class "
                + CodeTemplate.CLASS_NAME
                + " extends GameScreen {\n\n"
                + "   @Override\n"
                + "   public void onScreenCreated() {\n"
                + "       super.onScreenCreated();\n"
            + "   }\n"
            + "}");
     }
}

package org.gampiot.robokide.feature.template.code.android-game.logic;

import android.os.Parcel;

import org.gampiot.robokide.feature.template.code.CodeTemplate;
import org.gampiot.robokide.feature.template.code.java.JavaClassTemplate;

public class GameScreenLogicTemplate extends JavaClassTemplate {

     public GameScreenLogicTemplate() {
           super();
     }

     public GameScreenLogicTemplate(Parcel in) {
          super(in);
     }
     
     @Override
     public String getName() {
          return "GameScreenLogicTemplate";
     }
     
     @Override
     public void configure() {
          setContent(
               "package "
                + CodeTemplate.PACKAGE_NAME
                + ";\n\n"
                + "import robok.game.screen.GameScreen;\n\n"
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

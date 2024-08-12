package org.gampiot.robok.feature.template.code.android.game.logic;

import android.os.Parcel;

import org.gampiot.robok.feature.template.code.CodeTemplate;
import org.gampiot.robok.feature.template.code.java.JavaClassTemplate;

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
                + "import robok.game.screen.GameScreen;\n"
                + "import robok.game.gui.GUIViewListener;\n"
                + CodeTemplate.PACKAGE_NAME + ".datagui.MainGui;\n\n"
                + "public class "
                + CodeTemplate.CLASS_NAME
                + " extends GameScreen implements GUIViewListener {\n\n"
                + "   MainGui views;\n\n"
                + "   @Override\n"
                + "   public void onScreenCreated() {\n"
                + "       views = MainGui.inflate(this);\n"
                + "       views.shootButton.setGUIViewListener(this);\n"
                + "   }\n\n"
                + "   @Override\n"
                + "   public void onClick(GUIView view) {\n"
                + "       if (view == views.shootButton) {\n"
                + "           \n"
                + "       }\n"
                + "   }\n"
                + "}");
     }
}

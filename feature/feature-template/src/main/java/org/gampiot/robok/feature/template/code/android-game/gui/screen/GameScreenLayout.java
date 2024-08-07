package org.gampiot.robok.feature.template.code.android-game.gui.screen;

import android.os.Parcel;

import org.gampiot.robokide.feature.template.code.rbk.RBKLayoutTemplate;

public class GameScreenLayoutTemplate extends RBKLayoutTemplate {

     public GameScreenLayoutTemplate () {
          super();
     }
    
     public GameScreenLayoutTemplate (Parcel parcel) {
          super(parcel);
     }
    
     @Override
     public String getName () {
          return "GameScreenLayoutTemplate";
     }
    
     @Override
     public void configure() {
          setContent(
               "GameScreenLayoutTemplate {" 
               + "     Button(" 
               + "        id = \"shoot_button\"," 
               + "        text = \"Shoot\"," 
               + "        width = px(20)," 
               + "        height = px(20)" 
               + "     )" 
               + "}"
          );
     }
}
package robok.game.gui;

import android.view.View;

public class GUIView implements GUIViewListener {
     
     public String name;
     public String id;
     
     public int width;
     public int height;
     
     public GUIView () {
     
     }
     
     public void onViewCreated () {
         
     }
     
     @Override
     public String toString () {
          return 
              "GUI View ID: "
              + getID()
              + "\nName: "
              + getName()
              + "\nWidth: "
              + Integer.toString(getWidth())
              + "\nHeight: "
              + Integer.toString(getHeight());
     }
      
     @Override
     public void onClick (GUIView view) {
          // example
          if (view.getID().equals(getID())) { /* any action */}
     }
     
     @Override
     public void onLongClick (GUIView view) {
          // example
          if (view.getID().equals(getID())) { /* any action */}
     }
     
     public void setName (String name) {
          this.name = name;
     }
     
     public void setID (String id) {
          this.id = id;
     }
     
     public setHeight (int height) {
          this.height = height;
     }
     
     public setWidth (int width) {
          this.width = width;
     }
     
     public String getName() {
          return name;
     } 
     
     public String getID() {
          return id;
     }
     
     public int getWidth () {
          return width;
     }
     
     public int getHeight () {
          return height;
     }
}
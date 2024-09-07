package org.robok.game.gui;

import android.view.View;

public class GUIView {
     
     public String name;
     public String id;
     
     public int width;
     public int height;
     
     public GUIViewListener listener;
     
     public GUIView () {
     
     }
     
     public void onViewCreated () {
         // TO-DO logic to create base view
         /* a theoretical idea of how to program the click 
         * view.setOnClickListener(v - > {
         *      listener.onClick(view);
         * });
         * this code doesn't work, because GUIView is just an object, not a view.
         */
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
      
     public void setGUIViewListener (GUIViewListener listener) {
          this.listener = listener;
     }
     
     public void setName (String name) {
          this.name = name;
     }
     
     public void setID (String id) {
          this.id = id;
     }
     
     public void setHeight (int height) {
          this.height = height;
     }
     
     public void setWidth (int width) {
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
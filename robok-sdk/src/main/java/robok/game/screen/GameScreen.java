package robok.game.screen;

import android.app.Activity;
import android.os.Bundle;

public class GameScreen extends Activity {

     /* This screen will be used on all game screens.
     * TO-DO: System to 3D Game Activity.
     */

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          onScreenCreated();
     }
     
     public void onScreenCreated () {
         // same as onCreate.
     }
}
package packageName;

import robok.game.screen.GameScreen;
import robok.game.gui.GUIViewListener;
import packageName.datagui.MainGui;

public class MainScreen extends GameScreen implements GUIViewListener {

    private MainGui views;

    @Override
    public void onScreenCreated() {
        views = MainGui.inflate(this);
        views.shootButton.setGUIViewListener(this);
    }
    
    @Override
    public void onClick(GUIView view) {
        if (view == views.shootButton) {
            
        }
    }
}
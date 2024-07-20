package robok.dev.opengl.GamePad;

public interface GamePadMoveCallback {
    public void onMove(float x, float y);
    public void onKeyDown(int direction);
    public void onKeyUp();
}

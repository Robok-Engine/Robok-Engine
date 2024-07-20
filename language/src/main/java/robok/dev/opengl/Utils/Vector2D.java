package robok.dev.opengl.Utils;

public class Vector2D {

    public float x, y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D v) {
        this.x = v.x;
        this.y = v.y;
    }

    public float[] toFloatArray() {
        return new float[]{x, y};
    }

    public static boolean isInRect(Vector2D p, Vector2D c, float w, float h) {
        if (Math.abs(p.x - c.x) < w && Math.abs(p.y - c.y) < h) {
            return true;
        } else
            return false;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

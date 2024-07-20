package robok.dev.opengl.Utils;

public class Vector3D {
    public float x, y, z;

    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Vector3D t) {
        this.x = t.x;
        this.y = t.y;
        this.z = t.z;
    }

    public float[] toFloatArray() {
        return new float[]{x, y, z};
    }

    public String toString() {
        return "x=" + x + ", y=" + y +", z=" + z;
    }

    public void setXYZ(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /** Get Length */
    public float length() {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public boolean checkZero() {
        return (this.x == 0 && this.y == 0 && this.z == 0);
    }

    /** Vector add */
    public static void add(Vector3D result, Vector3D a, Vector3D b) {
        result.x = a.x + b.x;
        result.y = a.y + b.y;
        result.z = a.z + b.z;
    }

    /** Vector minus */
    public static void minus(Vector3D result, Vector3D a, Vector3D b) {
        result.x = a.x - b.x;
        result.y = a.y - b.y;
        result.z = a.z - b.z;
    }

    public static Vector3D multiplyVF(Vector3D a, float b) {
        Vector3D result = new Vector3D(a.x * b, a.y * b, a.z * b);
        return result;
    }

    /** Vector normalize */
    public Vector3D normalize() {
        float l = this.length();
        Vector3D result = new Vector3D(this.x / l, this.y / l, this.z / l);
        return result;
    }
}

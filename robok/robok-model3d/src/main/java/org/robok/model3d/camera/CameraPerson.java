package org.robok.model3d.camera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class CameraPerson extends InputAdapter {
    private final PerspectiveCamera camera;
    private final float maxVerticalAngle = 90f; // 180 graus divididos por 2

    public CameraPerson(PerspectiveCamera camera) {
        this.camera = camera;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        float deltaX = -Gdx.input.getDeltaX();
        float deltaY = -Gdx.input.getDeltaY();

        camera.direction.rotate(Vector3.Y, deltaX);

        // Calcula o novo ângulo de inclinação
        Vector3 right = camera.direction.crs(Vector3.Y).nor();
        float angleX = MathUtils.radiansToDegrees * MathUtils.atan2(camera.direction.y, new Vector3(camera.direction.x, 0, camera.direction.z).len());

        // Limita a rotação vertical
        float newAngleX = MathUtils.clamp(angleX - deltaY, -maxVerticalAngle, maxVerticalAngle);
        camera.direction.rotate(right, newAngleX - angleX);

        return true;
    }
}
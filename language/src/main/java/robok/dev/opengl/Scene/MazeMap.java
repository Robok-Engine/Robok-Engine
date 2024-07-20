package robok.dev.opengl.Scene;

import android.content.Context;
import android.util.Log;

import robok.dev.opengl.Objects.Cube;
import robok.dev.opengl.Utils.Vector3D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class MazeMap {

    public final static float MAZE_UNIT_WIDTH = 10.f;
    public final static float MAZE_UNIT_HEIGHT = 10.0f;

    private final static int MAZE_WIDTH = 11;
    private final static int MAZE_HEIGHT = 11;

    private static char[][] rawMap = new char[MAZE_WIDTH][MAZE_HEIGHT];

    private final static float mapOffsetX = 5.5f * MAZE_UNIT_WIDTH;
    private final static float mapOffsetY = 5.5f * MAZE_UNIT_WIDTH;

    // map unit
    private class MazeMapUnit {
        public Vector3D position;
        public MazeMapUnit(Vector3D pos) {
            position = pos;
        }
        public String toString() { return position.toString();}
    }

    // game start and end position.
    private Vector3D startPos = new Vector3D();
    private Vector3D endPos = new Vector3D();

    private Vector<MazeMapUnit> mazeMap;

    private SceneManager sceneManager;

    public MazeMap(SceneManager sm) {
        mazeMap = new Vector<MazeMapUnit>();
        sceneManager = sm;
    }

    public boolean readMazeMap(Context context, int resourceId) {
        final InputStream inputStream = context.getResources().openRawResource(
                resourceId);
        final InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream);
        final BufferedReader bufferedReader = new BufferedReader(
                inputStreamReader);

        String nextLine;
        int i = 0, j = 0;  // row, column
        try
        {
            while ((nextLine = bufferedReader.readLine()) != null)
            {
                for (j = 0; j< nextLine.length(); j++) {
                    char tempChar = nextLine.charAt(j);
                    rawMap[i][j] = tempChar;
                    // maze map
                    if (tempChar == '#') {
                        MazeMapUnit tempUnit = new MazeMapUnit(new Vector3D( (j- 5.5f) * MAZE_UNIT_WIDTH, 0.0f, (i - 5.5f) * MAZE_UNIT_WIDTH));
                        mazeMap.add(tempUnit);
                    } else if (tempChar == '+') { // maze start
                        startPos.setXYZ((j- 5.5f) * MAZE_UNIT_WIDTH, 0.0f, (i - 5.5f) * MAZE_UNIT_WIDTH);
                    } else if (tempChar == '-') { // maze end
                        endPos.setXYZ((j- 5.5f) * MAZE_UNIT_WIDTH, 0.0f, (i - 5.5f) * MAZE_UNIT_WIDTH);
                    }
                }
                i++;
            }
        }
        catch (IOException e)
        {
            return false;
        }

        for (MazeMapUnit unit: mazeMap) {
        //    Wall tempWall = new Wall(sceneManager.getContext(), MAZE_UNIT_WIDTH, MAZE_UNIT_HEIGHT);
            Cube tempCube = new Cube(sceneManager.getContext());
            Log.v("MazeMap", unit.toString());
            tempCube.setPosition(unit.position);
            sceneManager.addObject(tempCube);
        }

        return true;
    }

    public Vector<MazeMapUnit> getMazeMap() {
        return mazeMap;
    }

    public Vector3D getStartPos() { return startPos; }
    public Vector3D getEndPos() { return endPos; }

    public static boolean checkForCollision(float x, float y) {
        int tUnitX = (int) ((x + 60)/ MAZE_UNIT_WIDTH);
        int tUnitY = (int) ((y + 60)/ MAZE_UNIT_WIDTH);

        // out of the maze map
        if (tUnitX < 0 || tUnitY < 0)
            return false;
        else
            return (rawMap[tUnitY][tUnitX] == '#');
    }
}

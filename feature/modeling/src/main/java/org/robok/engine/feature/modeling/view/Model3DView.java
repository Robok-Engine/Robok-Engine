package org.robok.engine.feature.modeling.view;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */ 

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.ScreenUtils;

import org.robok.engine.feature.modeling.controller.CameraInputController2;
import org.robok.engine.feature.modeling.objects.Plan;
import org.robok.engine.feature.modeling.objects.SceneObject;
import org.robok.engine.feature.modeling.objects.ObjectsCreator;

import java.lang.reflect.Method;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

public class Model3DView extends ApplicationAdapter {

    public static Model3DView clazz;

    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelInstance instance;
    private CameraInputController2 camController;

    // bordas
    private ShapeRenderer shapeRenderer;
    ModelInstance planeInstance;
    private float cameraPitch = 0; // Ângulo de inclinação vertical da câmera
    private float cameraYaw = 0; // Ângulo de rotação horizontal da câmera

    // Lista de todos os objetos

    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private GlyphLayout layout;
    public String objectCommand = null;

    private boolean isDragging = false;

    public Model3DView() {
        clazz = this;
        SceneObject.sceneObjects = new ArrayList<>();
    }

    @Override
    public void create() {
        // Inicializa o batch e a fonte
        spriteBatch = new SpriteBatch();
        font = new BitmapFont(); // Cria uma fonte padrão
        layout = new GlyphLayout();

        // Declara o SceneObject comk um arrayList

        // Configura a câmera
        camera = new PerspectiveCamera(80, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 10f, 0f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        // Cria o batch para desenhar o modelo
        modelBatch = new ModelBatch();
        Vector3 size = new Vector3(4f,4f,4f);

        // Cria um modelo
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        modelBuilder.node().id = "cube";
        modelBuilder
                .part(
                        "cube",
                        GL20.GL_TRIANGLES,
                        new VertexAttributes(
                                new VertexAttribute(
                                        VertexAttributes.Usage.Position, 3, "a_position"),
                                new VertexAttribute(VertexAttributes.Usage.Normal, 3, "a_normal")),
                        new Material(ColorAttribute.createDiffuse(Color.GREEN)))
                .box(4f, 4f, 4f);
        Model modelB = modelBuilder.end();
        instance = new ModelInstance(modelB);
        instance.transform.setToTranslation(0f, 0f, 0f);

        SceneObject.sceneObjects.add(new SceneObject(instance.model,size, instance));

        /*criar plano */

        /* Plan plane = new Plan(20f, 20f, 0f, true);
        plane.createObject();
        planeInstance = plane.getInstance();//createPlane(10, 10);
        planeInstance.transform.setToTranslation(0f,0f,0f);*/

        // sceneObjects.add(new SceneObject(plane.getModel(), planeInstance));
        
        // Configura o controle da câmera
        camController = new CameraInputController2(camera);
        // camController.setListObject(sceneObjects);
        Gdx.input.setInputProcessor(camController);

        shapeRenderer = new ShapeRenderer();
        // createCube();
    }

    @Override
    public void render() {

        Gdx.gl.glViewport(1, 1, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1f);

        // if(start)createCube(); start = false;
        camController.update();
        camera.update();

        // Renderizar os objetos 3D primeiro
        modelBatch.begin(camera);

        onTime();
        //   camController.setListObject(sceneObjects);
        //   handleInput();
        String text = "Objetos na cena: ";
        int p = 0;
        for (SceneObject scene : SceneObject.sceneObjects) {

            modelBatch.render(scene.getModelInstance());
            p++;
            text +=
                    "\nObjetos adicionados: "
                            + p
                            + "\nModelo: "
                            + scene.getModelInstance().model.toString();
        }

        modelBatch.end();

        // Habilitar Depth Test para garantir que as linhas respeitem a profundidade dos objetos
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
        Gdx.gl.glDepthFunc(GL20.GL_LEQUAL);

        // Desenhar as linhas da grade
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
       
        camController.updateRenderer(shapeRenderer);
        // drawGridAroundModel(instance);
       // drawCubeEdges2(4f, 4f, 4f, 0f, 0f, 0f);
        // shapeRenderer.setColor(Color.GRAY);
        drawGrid3D(0, 0, 0, 200, 200, 1, 0.1f); // Ajuste as dimensões conforme necessário

        shapeRenderer.end();
        // Desabilitar o Depth Test após desenhar as linhas
        Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);

        // Desenhar o texto na tela
        spriteBatch.begin();

        String clck = "\nClique " + isDragging + "\nAmount: " + camController.ammount;

        layout.setText(font, text + clck);
        font.draw(spriteBatch, text + clck, 10, Gdx.graphics.getHeight() - 10);
        spriteBatch.end();
    }

    public static Vector3 getModelDimensions(Model model) {
        Vector3 min = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        Vector3 max = new Vector3(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);

        for (MeshPart meshPart : model.meshParts) {
            int numVertices = meshPart.mesh.getNumVertices();
            float[] vertices = new float[numVertices];
            meshPart.mesh.getVertices(vertices);

            for (int i = 0; i < numVertices; i += 3) {
                float x = vertices[i];
                float y = vertices[i + 1];
                float z = vertices[i + 2];

                if (x < min.x) min.x = x;
                if (y < min.y) min.y = y;
                if (z < min.z) min.z = z;

                if (x > max.x) max.x = x;
                if (y > max.y) max.y = y;
                if (z > max.z) max.z = z;
            }
        }

        Vector3 dimensions = new Vector3();
        dimensions.set(max).sub(min);
        return dimensions;
    }

    
    
    public void renderEdges(ShapeRenderer shapeRenderer, ModelInstance modelInstance) {
        
        if(modelInstance != null){
        Model model = modelInstance.model;
        
      //  shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        
        for (int i = 0; i < model.meshes.size; i++) {
            Mesh mesh = model.meshes.get(i);
            float[] vertices = new float[mesh.getMaxVertices()];
            short[] indices = new short[mesh.getMaxIndices()];
            mesh.getVertices(vertices);
            mesh.getIndices(indices);
            
            for (int j = 0; j < indices.length; j += 2) {
                Vector3 v1 = new Vector3(vertices[indices[j] * 3], vertices[indices[j] * 3 + 1], vertices[indices[j] * 3 + 2]);
                Vector3 v2 = new Vector3(vertices[indices[j + 1] * 3], vertices[indices[j + 1] * 3 + 1], vertices[indices[j + 1] * 3 + 2]);
                
                shapeRenderer.line(v1, v2);
            }
        }
        
      //  shapeRenderer.end();
    }
        }

    @Override
    public void dispose() {
        modelBatch.dispose();

        for (SceneObject scene : SceneObject.sceneObjects) {
            scene.getModelInstance().model.dispose();
        }
    }

    public void setCommand(String objectCommand) {
        this.objectCommand = objectCommand;
    }

    private void invokeObject(String objectCommand) {
        try {
            ObjectsCreator createObjects = new ObjectsCreator(camController, SceneObject.sceneObjects);
            Class<?> clazz = createObjects.getClass();
            Method method = clazz.getDeclaredMethod(objectCommand);
            method.invoke(createObjects);
            // sceneObjects = createObjects.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onTime() {
        if (objectCommand != null) {
            invokeObject(objectCommand);
            objectCommand = null;
        }
    }

    // Desenhar cubo simples
    private void drawCubeEdges(float size) {
        float halfSize = size / 2;

        // Define os pontos do cubo
        float[][] points = {
            {-halfSize, -halfSize, -halfSize},
            {halfSize, -halfSize, -halfSize},
            {halfSize, halfSize, -halfSize},
            {-halfSize, halfSize, -halfSize},
            {-halfSize, -halfSize, halfSize},
            {halfSize, -halfSize, halfSize},
            {halfSize, halfSize, halfSize},
            {-halfSize, halfSize, halfSize}
        };

        // Desenha as arestas do cubo
        for (int i = 0; i < 4; i++) {
            shapeRenderer.line(
                    points[i][0],
                    points[i][1],
                    points[i][2],
                    points[(i + 1) % 4][0],
                    points[(i + 1) % 4][1],
                    points[(i + 1) % 4][2]);
            shapeRenderer.line(
                    points[i + 4][0],
                    points[i + 4][1],
                    points[i + 4][2],
                    points[((i + 1) % 4) + 4][0],
                    points[((i + 1) % 4) + 4][1],
                    points[((i + 1) % 4) + 4][2]);
            shapeRenderer.line(
                    points[i][0],
                    points[i][1],
                    points[i][2],
                    points[i + 4][0],
                    points[i + 4][1],
                    points[i + 4][2]);
        }
    }

    // Desenhar cubo detalhado
    private void drawCubeEdges2(
            float scaleX, float scaleY, float scaleZ, float centerX, float centerY, float centerZ) {
        // Calcula os tamanhos no cubo
        float halfScaleX = scaleX / 2;
        float halfScaleY = scaleY / 2;
        float halfScaleZ = scaleZ / 2;

        // Define os pontos do cubo com escalas e posição central
        float[][] points = {
            {centerX - halfScaleX, centerY - halfScaleY, centerZ - halfScaleZ},
            {centerX + halfScaleX, centerY - halfScaleY, centerZ - halfScaleZ},
            {centerX + halfScaleX, centerY + halfScaleY, centerZ - halfScaleZ},
            {centerX - halfScaleX, centerY + halfScaleY, centerZ - halfScaleZ},
            {centerX - halfScaleX, centerY - halfScaleY, centerZ + halfScaleZ},
            {centerX + halfScaleX, centerY - halfScaleY, centerZ + halfScaleZ},
            {centerX + halfScaleX, centerY + halfScaleY, centerZ + halfScaleZ},
            {centerX - halfScaleX, centerY + halfScaleY, centerZ + halfScaleZ}
        };

        shapeRenderer.setColor(Color.WHITE);
        // Desenha as arestas do cubo
        for (int i = 0; i < 4; i++) {
            shapeRenderer.line(
                    points[i][0],
                    points[i][1],
                    points[i][2],
                    points[(i + 1) % 4][0],
                    points[(i + 1) % 4][1],
                    points[(i + 1) % 4][2]);
            shapeRenderer.line(
                    points[i + 4][0],
                    points[i + 4][1],
                    points[i + 4][2],
                    points[((i + 1) % 4) + 4][0],
                    points[((i + 1) % 4) + 4][1],
                    points[((i + 1) % 4) + 4][2]);
            shapeRenderer.line(
                    points[i][0],
                    points[i][1],
                    points[i][2],
                    points[i + 4][0],
                    points[i + 4][1],
                    points[i + 4][2]);
        }
    }

    // Grades planos com linhas no centro
    private void drawGrid3D(
            float centerX,
            float centerY,
            float centerZ,
            float width,
            float depth,
            float cellSize,
            float lineThickness) {
        // Calcular os limites do plano
        float startX = centerX - width / 2;
        float endX = centerX + width / 2;
        float startZ = centerZ - depth / 2;
        float endZ = centerZ + depth / 2;
        shapeRenderer.setColor(Color.GRAY);

        // Desenha linhas horizontais (ao longo do eixo X)
        for (float z = startZ; z <= endZ; z += cellSize) {
            if (Math.abs(z - centerZ) < cellSize / 2) {
                // define cor
                //  shapeRenderer.setColor(Color.GRAY);
                // Desenha a linha central mais grossa com múltiplas linhas próximas
                shapeRenderer.line(
                        startX,
                        centerY,
                        z - lineThickness / 2,
                        endX,
                        centerY,
                        z - lineThickness / 2);
                shapeRenderer.line(
                        startX,
                        centerY,
                        z + lineThickness / 2,
                        endX,
                        centerY,
                        z + lineThickness / 2);
            } else {
                shapeRenderer.line(startX, centerY, z, endX, centerY, z);
            }
        }

        // Desenha linhas verticais (ao longo do eixo Z)
        for (float x = startX; x <= endX; x += cellSize) {
            if (Math.abs(x - centerX) < cellSize / 2) {
                // define cor
                //   shapeRenderer.setColor(Color.GRAY);
                // Desenha a linha central mais grossa com múltiplas linhas próximas
                shapeRenderer.line(
                        x - lineThickness / 2,
                        centerY,
                        startZ,
                        x - lineThickness / 2,
                        centerY,
                        endZ);
                shapeRenderer.line(
                        x + lineThickness / 2,
                        centerY,
                        startZ,
                        x + lineThickness / 2,
                        centerY,
                        endZ);
            } else {
                shapeRenderer.line(x, centerY, startZ, x, centerY, endZ);
            }
        }
    }

    // Grades planos sem linhas no centro
    private void drawGrid3D(
            float centerX, float centerY, float centerZ, float width, float depth, float cellSize) {
        // Calcular os limites do plano
        float startX = centerX - width / 2;
        float endX = centerX + width / 2;
        float startZ = centerZ - depth / 2;
        float endZ = centerZ + depth / 2;

        // Desenha linhas horizontais (ao longo do eixo X)
        for (float z = startZ; z <= endZ; z += cellSize) {
            shapeRenderer.line(startX, centerY, z, endX, centerY, z);
        }

        // Desenha linhas verticais (ao longo do eixo Z)
        for (float x = startX; x <= endX; x += cellSize) {
            shapeRenderer.line(x, centerY, startZ, x, centerY, endZ);
        }
    }

    // desenha de forma vertical
    private void drawGridParede(
            float startX, float startY, float width, float height, float cellSize) {
        // Desenha linhas horizontais
        for (float y = startY; y <= startY + height; y += cellSize) {
            shapeRenderer.line(startX, y, startX + width, y);
        }

        // Desenha linhas verticais
        for (float x = startX; x <= startX + width; x += cellSize) {
            shapeRenderer.line(x, startY, x, startY + height);
        }
    }
}

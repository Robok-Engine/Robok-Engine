package org.robok.model3d.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import java.util.List;

public class SceneObject {

    //Liatas de Objetos
    public static List<SceneObject> sceneObjects;
    public Vector3 size;
    // Variáveis globais para armazenar o Model e ModelInstance
    private Model model;
    private ModelInstance modelInstance;

    // Construtor vazio
    


    // Construtor com parâmetros
    public SceneObject(Model model, Vector3 size, ModelInstance modelInstance) {
        this.model = model;
        this.size = size;
        this.modelInstance = modelInstance;
    }

    // Getters e Setters para o Model
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    // Getters e Setters para o ModelInstance
    public ModelInstance getModelInstance() {
        return modelInstance;
    }

    public void setModelInstance(ModelInstance modelInstance) {
        this.modelInstance = modelInstance;
    }

    // Exemplo de método para atualizar a transformação da ModelInstance
    public void updateTransform(float x, float y, float z) {
        if (modelInstance != null) {
            modelInstance.transform.setToTranslation(x, y, z);
        }
    }
    
    public Vector3 getScale() {
        Matrix4 transform = modelInstance.transform;
        Vector3 scale = new Vector3();

        // Extraia a escala da matriz de transformação
        transform.getScale(scale);

        return scale;
    }
}
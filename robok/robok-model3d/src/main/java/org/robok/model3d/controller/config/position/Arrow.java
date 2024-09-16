package org.robok.model3d.controller.config.position;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class Arrow {
    public Vector3 position;
    public Vector3 direction;
    public Color color;
    public float length;

    public Arrow(Vector3 position, Vector3 direction, Color color, float i) {
        this.position = position;
        this.direction = direction;
        this.color = color;
        this.length = i;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);

             // ... (código para desenhar o corpo da flecha com linhas paralelas, se necessário)
     //   float cylinderRadius = 5;
        // Parâmetros do cilindro
        float cylinderRadius = 0.1f; // Raio do cilindro (ajuste conforme necessário)
        int cylinderSegments = 64; // Número de segmentos do círculo da base (ajuste conforme necessário)

        // Desenhar o cilindro do corpo da flecha
        Matrix4 transformm = new Matrix4();

        // Calcular o ponto final da flecha (onde o cone começa)
        
        Vector3 endPoint = position.cpy().add(direction.cpy().scl(length + 1f)); // Ajuste o 0.3f conforme o tamanho do cone

        // Posicionar o cilindro no meio da flecha
        transformm.setToTranslation(position.cpy().add(endPoint).scl(0.5f)); // Centralizar na seta

        // Rotacionar o cilindro para alinhar com a direção da seta
        transformm.rotate(Vector3.Z, direction);

        // Aplicar a transformação ao ShapeRenderer
        shapeRenderer.setTransformMatrix(transformm);

        // Desenhar as bases do cilindro
        shapeRenderer.circle(0, 0,0); // Base inferior
        // Aplicar uma translação para desenhar a base superior
        transformm.translate(0, 0, length - 2f); // Ajuste o 0.3f conforme o tamanho do cone
        shapeRenderer.setTransformMatrix(transformm);
        shapeRenderer.circle(0, 0, 0); // Base superior

        // Resetar a transformação do ShapeRenderer para a posição original
        transformm.translate(0, 0, -(length - 1f)); // Ajuste o 0.3f conforme o tamanho do cone
        shapeRenderer.setTransformMatrix(transformm);

        // Desenhar as linhas laterais do cilindro
        for (int i = 0; i < cylinderSegments; i++) {
            float angle1 = (2 * MathUtils.PI * i) / cylinderSegments;
            float angle2 = (2 * MathUtils.PI * (i + 1)) / cylinderSegments;

            float x1 = cylinderRadius * MathUtils.cos(angle1);
            float y1 = cylinderRadius * MathUtils.sin(angle1);
            float x2 = cylinderRadius * MathUtils.cos(angle2);
            float y2 = cylinderRadius * MathUtils.sin(angle2);

            shapeRenderer.line(x1, y1, 0, x2, y2, 0); // Linha na base inferior
            shapeRenderer.line(x1, y1, length - 0.3f, x2, y2, length - 0.3f); // Linha na base superior (ajuste o 0.3f)
            shapeRenderer.line(x1, y1, 0, x1, y1, length - 0.3f); // Linha lateral (ajuste o 0.3f)
        }

        // Resetar a transformação do ShapeRenderer
        shapeRenderer.setTransformMatrix(new Matrix4());


        // Desenhar a ponta da seta (cone)
        // (Implementação do cone pode ser um pouco mais complexa, você pode usar um modelo 3D ou desenhar manualmente com ShapeRenderer)
        // ... 
        // Parâmetros dos cones
    int numSegments = 512; // Número de segmentos do círculo da base (ajuste conforme necessário)
    float coneRadius = 0.5f; // Raio da base do cone (ajuste conforme necessário)
    float coneHeight = 0.6f; // Altura do cone (ajuste conforme necessário)

    // Desenhar o cone na ponta da seta

// Desenhar a ponta da seta (cone)
        Matrix4 transform = new Matrix4(); // Matriz de transformação para o cone
        
        // Posicionar o cone na ponta da seta
        transform.setToTranslation(endPoint); 

        // Rotacionar o cone para alinhar com a direção da seta
        transform.rotate(Vector3.Z, direction); 
        transform.translate(0, 0, length - 2.8f); // Ajuste o 0.3f conforme o tamanho do cone

        // Aplicar a transformação ao ShapeRenderer
        shapeRenderer.setTransformMatrix(transform); 

        // Desenhar o cone
        shapeRenderer.cone(0, 0, 0, coneRadius, coneHeight, numSegments);

        // Resetar a transformação do ShapeRenderer
        shapeRenderer.setTransformMatrix(new Matrix4()); 
    }
}

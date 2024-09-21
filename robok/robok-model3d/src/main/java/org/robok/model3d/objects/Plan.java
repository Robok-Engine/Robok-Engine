package org.robok.model3d.objects;

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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class Plan {

    Mesh planeMesh;
    Model model;
    ModelBuilder modelBuilder;

    public Plan(float width, float height, float profundity, boolean invertSide) {
        planeMesh = new Mesh(true, 4, 6,
            new VertexAttribute(VertexAttributes.Usage.Position, 3, "a_position"),
            new VertexAttribute(VertexAttributes.Usage.Normal, 3, "a_normal"));

        // Define os vértices e índices
        float[] vertices;
        short[] indices;

        if (profundity == 0) {
            // Plano horizontal
            vertices = new float[] {
                -width / 2, 0, -height / 2, 0, 1, 0, // Vertex 1
                 width / 2, 0, -height / 2, 0, 1, 0, // Vertex 2
                 width / 2, 0,  height / 2, 0, 1, 0, // Vertex 3
                -width / 2, 0,  height / 2, 0, 1, 0  // Vertex 4
            };
            // Definindo a ordem dos índices para a face visível
            indices = invertSide ? new short[] { 0, 3, 2, 2, 1, 0 } : new short[] { 0, 1, 2, 2, 3, 0 };
        } else {
            // Plano vertical
            vertices = new float[] {
                -width / 2, -height / 2, 0, 0, 0, 1, // Vertex 1
                 width / 2, -height / 2, 0, 0, 0, 1, // Vertex 2
                 width / 2,  height / 2, 0, 0, 0, 1, // Vertex 3
                -width / 2,  height / 2, 0, 0, 0, 1  // Vertex 4
            };
            // Definindo a ordem dos índices para a face visível
            indices = invertSide ? new short[] { 0, 3, 2, 2, 1, 0 } : new short[] { 0, 1, 2, 2, 3, 0 };
        }

        planeMesh.setVertices(vertices);
        planeMesh.setIndices(indices);
    }

    public void createObject() {
        // Cria o ModelBuilder e constrói o modelo
        modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        modelBuilder.part(
                "plane",
                planeMesh,
                GL20.GL_TRIANGLES,
                new Material(ColorAttribute.createDiffuse(Color.BLUE)));
        model = modelBuilder.end();
    }

    public ModelInstance getInstance() {
        return new ModelInstance(model);
    }
    public Model getModel() {
        return this.model;
    }
}
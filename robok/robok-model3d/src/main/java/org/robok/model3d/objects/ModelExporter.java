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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

public class ModelExporter {

    public static class ModelJson {
        public String id;
        public float[] vertices;
        public float[] normals;
        public short[] indices;
        public String material;
    }

    // Método para exportar o modelo em formato JSON
    public void exportModelAsJson(Model model, String outputPath) {
        ModelJson modelJson = new ModelJson();

        // Obtenha os dados do modelo
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();
        Model modelData = modelBuilder.end();
        
        // Aqui você precisa converter os dados do modelo para o formato JSON desejado
        // Exemplo básico de preenchimento de dados
        modelJson.id = "exampleModel";
        modelJson.vertices = extractVertices(modelData);
        modelJson.normals = extractNormals(modelData);
        modelJson.indices = extractIndices(modelData);
        modelJson.material = "exampleMaterial";

        // Serializa para JSON
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        String jsonString = json.toJson(modelJson);

        // Salva o JSON no arquivo
        FileHandle fileHandle = Gdx.files.local(outputPath);
        fileHandle.writeString(jsonString, false);

        // Libere os recursos do modelo
        model.dispose();
    }

    private float[] extractVertices(Model model) {
        // Lógica para extrair os vértices do modelo
        // Implementar conforme o formato do seu modelo
        return new float[]{};
    }

    private float[] extractNormals(Model model) {
        // Lógica para extrair as normais do modelo
        // Implementar conforme o formato do seu modelo
        return new float[]{};
    }

    private short[] extractIndices(Model model) {
        // Lógica para extrair os índices do modelo
        // Implementar conforme o formato do seu modelo
        return new short[]{};
    }

    // Exemplo de uso
    public static void main(String[] args) {
        ModelBuilder modelBuilder = new ModelBuilder();
        Model model = modelBuilder.createBox(1, 1, 1, 
                new Material(ColorAttribute.createDiffuse(Color.RED)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);

        ModelExporter exporter = new ModelExporter();
        exporter.exportModelAsJson(model, "myModel.g3dj");
    }
}
package es.ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class EjemploGson2 {
public static void main(String[] args) {
        Path fichero = Path.of("persona2.bin");

        try {
            //1. creamos el fichero
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);    
            }

            // JsonObject para crear una representación JSON de una persona
            // con addProperty() asigno un atributo al objeto JSON
            JsonObject p1 = new JsonObject();
            p1.addProperty("nombre", "Pedro");
            p1.addProperty("edad", "22");

            JsonObject p2 = new JsonObject();
            p2.addProperty("nombre", "Maria");
            p2.addProperty("edad", "35");

            // JsonArray para crear una representación JSON de un array de cosas
            JsonArray listaPersonas = new JsonArray();

            listaPersonas.add(p1);
            listaPersonas.add(p2);

            BufferedWriter bw = new BufferedWriter(new FileWriter("persona2.json"));
            BufferedReader br = new BufferedReader(new FileReader("persona2.json"));

            Gson gson = new Gson();

            // Escribimos nuestro JsonArray a un documento
            gson.toJson(listaPersonas, bw);

            bw.close();

            // Leemos el documento creado previamnete
            JsonArray listaPersonasGuardadas = gson.fromJson(br, JsonArray.class);


            System.out.println(listaPersonasGuardadas);

            br.close();

            for(JsonElement persona : listaPersonasGuardadas){
                JsonObject personaObjeto = persona.getAsJsonObject();
                String nombrePersona = personaObjeto.get("nombre").getAsString();
                int edadPersona = personaObjeto.get("edad").getAsInt();

                System.out.println(nombrePersona + " - " + edadPersona);
            }

            
        } catch (IOException e) {
            e.printStackTrace();

        }

    // 3. escribir la lista de personas en "personas2.json"
    }
    // 4. escribir la lista de personas en "personas2.json"
}

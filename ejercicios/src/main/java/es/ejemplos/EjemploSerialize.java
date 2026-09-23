package es.ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.clases.Persona;

public class EjemploSerialize {
    public static void main(String[] args) {
        Path fichero = Path.of("persona.json");

        try {
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);    
            }
            
            Persona p1 = new Persona("Pedro", 22);
            Persona p2 = new Persona("Ana", 35);

            ArrayList<Persona> personas = new ArrayList<Persona>();

            personas.add(p1);
            personas.add(p2);

            Gson gson = new Gson();

            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero.toString()));

            // Transforma la lista de personas a un array JSON y lo mete en el fichero utilizando un buffered writer
            gson.toJson(personas, bw);

            // Para que se apliquen los cambios se debe cerrar el flujo de escritura
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(fichero.toString()));

            //Método sin array lists (gaspar)
            //Persona[] personasLeidas = gson.fromJson(br, Persona[].class);
            //for (Persona p : personasLeidas) {
            //    System.out.println(p);
            //}

            //Método con array lists
            // Me creo un tipo específico para que gson coprenda el contenido del fichero json
            Type tipoListaPersonas = new TypeToken<List<Persona>>() {}.getType();
            // Leo el fichero json y transformo el contenido en una lista de personas
            List<Persona> listaPersonasGuardadas = gson.fromJson(br,tipoListaPersonas);

            System.out.println(listaPersonasGuardadas);



            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package es.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Ejercicio12 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;

        JsonArray videojuegos = new JsonArray();
        int numLinea = 0;
        String[] valores = null;
        Path archivo = Path.of("videojuegos.csv");
        String linea = null;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo.toFile()))) {
            linea = br.readLine();
                while (linea != null) {
                   if (numLinea != 0) {
                        JsonObject videojuego = new JsonObject();
                        valores = linea.split(";");
                        videojuego.addProperty("titulo", valores[0]);
                        videojuego.addProperty("plataforma", valores[1]);
                        videojuego.addProperty("genero", valores[2]);
                        videojuego.addProperty("precio", Double.parseDouble(valores[3]));
                        videojuego.addProperty("multijugador", Boolean.parseBoolean(valores[4]));

                        videojuegos.add(videojuego);
                        
                   }
                   numLinea++;
                   linea = br.readLine();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("videojuegos.json", false))){
            gson.toJson(videojuegos, bw);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

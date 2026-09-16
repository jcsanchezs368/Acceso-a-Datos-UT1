package com.ejemplosut1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EjemploIO {
    public static void main(String[] args) {
        String rutaStr = "./ejemplosIO/notas.txt";
        Path rutaNotas = Path.of(rutaStr);
        try {
            //Creamos el fichero nuevo
            if(!Files.exists(rutaNotas)) {
                Files.createFile(rutaNotas);
            }
            //Utilizamos la clase BufferedWriter para poder escribir en un fichero, en este caso, no binario
            // RECORDATORIO, para evitar que todo el contenido se sobreescriba, se debe especificar al momento de crear el FileWriter si el modo append estará activado o desactivado (true or false)
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaStr, true));
            bw.write("Hola mundo!\n");
            bw.close(); //Cerramos el buffer para liberar espacio en memoria

            BufferedReader br = new BufferedReader(new FileReader(rutaStr));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            String linea2 = null;
            do{
                linea2 = br.readLine();
                if(linea2 != null){
                    System.out.println(linea2);
                }
            }while(linea2 != null);

            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

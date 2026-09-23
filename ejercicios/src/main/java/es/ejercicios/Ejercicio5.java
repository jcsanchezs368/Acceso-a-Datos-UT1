package es.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        String nombre = null;
        String contenido = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        if (nombre.contains(" ")) {
            nombre = nombre.replace(" ", "_");
        }

        Path bloc_usuario = Path.of("./blocs/bloc_" + nombre + ".txt");

        if (!Files.exists(bloc_usuario)) {
            System.out.println("No se ha encontrado su bloc personal, se ha creado un nuevo bloc personal con el nombre: bloc_" + nombre + ".txt");
        }
    
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(bloc_usuario.toString(), true))){
            System.out.println("Escribe lo que deseas añadir al bloc (Escribir BYE para finalizar)");
            do{
                contenido = scanner.nextLine();
                if (contenido.equalsIgnoreCase("BYE")) {
                    System.out.println("Se han escrito todas las líneas en su bloc personal.");
                    System.out.println("Saliendo de la app...");
                }else{
                    bw.write(contenido + "\n");
                }

            }while(!contenido.equalsIgnoreCase("BYE"));
        
        }catch(IOException e){
            e.printStackTrace();
        }
        scanner.close();

    }
}

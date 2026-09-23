package es.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String busqueda = null;
        String rutaStr = null;
        String lineaLeida = null;
        int numLinea = 1;
        int numCoincidencias = 0;
        Path ruta = null;
        
        System.out.print("Introduzca la frase o palabra a buscar:");
        busqueda = scanner.nextLine();
        System.out.println("Introduzca la ruta ABSOLUTA al archivo a leer");
        rutaStr = scanner.nextLine();
        ruta = Path.of(rutaStr);
        System.out.println(ruta);
        if (!Files.exists(ruta)) {
            System.err.println("El archivo no existe o la ruta proporcionada al archivo no es válida");
        }else{
            System.out.println("Se ha encontrado el archivo " + ruta);
            try (BufferedReader br = new BufferedReader(new FileReader(rutaStr))) {
                lineaLeida = br.readLine();
                while (lineaLeida != null) {
                    numCoincidencias = 0;
                    if (lineaLeida.contains(busqueda)) {

                        do{
                            numCoincidencias++;
                            lineaLeida = lineaLeida.substring(lineaLeida.indexOf(busqueda) + busqueda.length());
                        }while(lineaLeida.contains(busqueda));
                        
                        System.out.println("Línea " + numLinea + " -> " + numCoincidencias + " coincidencias");
                    }
                    numLinea++;
                    lineaLeida = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        scanner.close();

    }
}

package es.ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class Ejercicio2 {
    public static void main(String[] args) {
        Path ruta = Path.of("./empresa/nominas/2025_26");
        Path ruta2 = Path.of("./empresa/nominas/2026_27");
        Path ruta3 = Path.of("./empresa/imagenes");

        try {
            Files.createDirectories(ruta);
            Files.createDirectories(ruta2);
            Files.createDirectories(ruta3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createFile(ruta2.resolve("enero.pdf"));
            Files.createFile(ruta2.resolve("febrero.pdf"));
            Files.createFile(ruta2.resolve("marzo.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Path> rutas = new ArrayList<Path>();
        rutas.add(ruta);
        rutas.add(ruta3);
        rutas.add(Path.of("2025_26"));
        rutas.add(ruta2.resolve("febrero.pdf"));
        rutas.add(Path.of("nomina_enero.pdf"));

        for (Path path : rutas) {
            System.out.println("=============================================");
            System.out.println("RUTA: " + path);
            System.out.println("¿Existe?: " + (Files.exists(path) ? "Sí":"No")); 
            System.out.println("¿Es un archivo? " + (Files.isRegularFile(path) ? "Sí":"No"));
            System.out.println("¿Es un directorio?: " + (Files.isDirectory(path) ? "Sí":"No"));
            System.out.println("=============================================");
            
        }

        try {
            Files.copy(ruta2.resolve("marzo.pdf"), ruta.resolve("marzoCopia.pdf"));
            Files.move(ruta2.resolve("enero.pdf"), ruta.resolve("enero.pdf"));
            Files.delete(ruta2.resolve("febrero.pdf"));
            //Si intentamos borrar de nuevo el archivo nos saltará una IOException ya que no encontrará el archivo
            Files.delete(ruta2.resolve("febrero.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        try {
            System.out.println("Elementos de la ruta: " + ruta);
            Stream<Path> listas = Files.list(ruta);
            
            Iterator<Path> it = listas.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
            listas.close();
            
            Iterator<Path> it2 = Files.list(ruta).iterator();
            int numFicheros = 0;
            while (it2.hasNext()) {
                if (Files.isRegularFile(it2.next())) {
                    numFicheros++;
                }
            }

            System.out.println("Número de ficheros del directorio " + ruta + ": " + numFicheros);
            



            
        } catch (IOException e) {

            e.printStackTrace();
        }
        


    }
}

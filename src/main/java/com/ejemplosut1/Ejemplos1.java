package com.ejemplosut1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejemplos1 {
    public static void main(String[] args) {
        // Creo un objeto Path para representar la ruta "/documentos/actividad.pdf"
        // .of() es un método estático y por eso lo invoco directamente
        Path ruta1 = Path.of("documentos/actividad.pdf");
        // Imprimo por pantalla el objeto
        System.out.println(ruta1.toString());
        
        //Comprobar si ruta1 termina exactamente igual que ruta2
        Path ruta2 = Path.of("actividad.pdf");

        if (ruta1.endsWith(ruta2)) {
            System.out.println("El final de las rutas coinciden");

            System.out.println("Ruta 1:" + ruta1);

            System.out.println("Ruta 2:" + ruta2);
        } else{
            System.out.println("El final de las rutas no coinciden");
        }

        //Para obtener el nombre del archivo, uilizamos el método getFileName()

        System.out.println("Nombre del archivo de ruta1: " + ruta1.getFileName());

        //Para obtener la raíz de ruta2, utilizaremos el método .getParent() (no devolverá el nombre del archivo)

        System.out.println("Raíz de ruta2: " + ruta2.getParent());

        //Saldrá null ya que ruta2 no tiene raíz

        //La clase Files nos proporciona métodos para trabajar con ficheros
        Path ruta3 = Path.of("documentos/archivo1.jpg");
        if(Files.exists(ruta3)){
            System.out.println("El archivo " + ruta3 + " existe en mi sistema de ficheros");
        } else{
            System.out.println("El archivo " + ruta3 + " no existe");
        }

        //Métodos para comprobar si la ruta apunta a un directorio o a un archivo
        System.out.println("¿ruta3 es un directorio? " + (Files.isDirectory(ruta3) ? "Sí":"No"));
        System.out.println("¿ruta3 es un archivo? " + (Files.isRegularFile(ruta3) ? "Sí":"No"));

        //Para crear un archivo utilizaremos el método createFile de la clase Files
        Path ruta4 = Path.of("documentos/archivoNuevo.jpg");
        try {
            if (Files.exists(ruta4)) {
                System.err.println("El archivo " + ruta4 + " ya existe.");
            } else{
                Files.createFile(ruta4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Para crear directorios utilizaremos el método createDirectory de la clase
        Path ruta5 = Path.of("documentos/2026/acceso-datos");

        try{
            //Si el objeto path contiene más de un directorio y utilizamos el método createDirectory, nos saltará una excepción
            //para evitar eso, deberemos usar el método createDirectories, para crear varios directorios a la vez
            //Files.createDirectory(ruta5);
            Files.createDirectories(ruta5);

        } catch (IOException e){
            e.printStackTrace();
        }

        //Para borrar archivos utilizaremos el método delete y deleteIfExists
        try{
            Files.delete(ruta5);
            Files.deleteIfExists(ruta5);
        } catch(IOException e){
            e.printStackTrace();
        }

        //para copiar un archivo a otro directorio utilizaremos el método
        Path ruta6 = Path.of("documentos/2027");
        try {
            //Creamos el directorio donde pegaremos el archivo
            if(!Files.exists(ruta6)){
                Files.createDirectories(ruta6);
            };
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            //Para pegar el archivo original en el destino, utilizaremos el método copy() y el método resolve()
            //El método copy requiere una ruta origen con el archivo y una ruta destino
            //Ya que ruta6 es documentos/2027, necesitaremos añadir el nombre deseado del archivo copiado, es decir, añadirle documentos/2027/archivoCopiado.pdf
            Files.copy(ruta1, ruta6.resolve("archivoCopiado.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Para mover un archivo de una ruta origen a una ruta destino utilizaremos el método move()
        
        try {
            Files.move(ruta6.resolve("archivoCopiado.pdf"), ruta5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
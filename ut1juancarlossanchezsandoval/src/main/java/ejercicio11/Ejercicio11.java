package ejercicio11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import com.google.gson.Gson;


public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreContacto;
        Gson gson = new Gson();
        Contacto contactos = null;
        Path agenda = Path.of("agenda.json");
        int opcion;

        if(!Files.exists(agenda)){
            contactos = new Contacto();
            System.out.println("No se encontró el archivo \"" + agenda.toFile() + "\". Se ha creado el archivo.");
        }else{
            try (BufferedReader br = new BufferedReader(new FileReader(agenda.toFile()))) {
                contactos = gson.fromJson(br, Contacto.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(contactos != null){
            do{
                System.out.println("1. Mostrar lista de contactos");
                System.out.println("2. Insertar nuevo contacto");
                System.out.println("3. Borrar contacto");
                System.out.println("4. Guardar cambios y salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        if(contactos.numContactos() == 0){
                            System.out.println("No hay ningún contacto registrado");
                        }else{
                            System.out.println(contactos);
                        }

                        break;
                    case 2:
                        System.out.print("Escribe el nombre del contacto a insertar: ");
                        nombreContacto = scanner.nextLine();
                        if(contactos.agregarContacto(nombreContacto)){
                            System.out.println("Nuevo contacto registrado: " + nombreContacto);
                        }else{
                            System.err.println("Error al añadir el contacto: " + nombreContacto);
                        }
                        
                        break;
                    case 3:
                        System.out.print("Escribe el nombre del contacto a borrar: ");
                        nombreContacto = scanner.nextLine();
                        if(contactos.eliminarContacto(nombreContacto)){
                            System.out.println("Contacto eliminado: " + nombreContacto);
                        }else{
                            System.err.println("Error al eliminar el contacto: " + nombreContacto);
                        }
                        
                        break;
                    case 4:
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(agenda.toFile(), false))) {
                            gson.toJson(contactos, bw);
                        } catch (Exception e) {
                        }
                        break;
                
                    default:
                        System.err.println("Opcion incorrecta");
                        break;
                }
            }while(opcion != 4);
        }else{
            System.err.println("Ha ocurrido un error al crear o leer su agenda de contactos");
        }
        
        scanner.close();
    }

}

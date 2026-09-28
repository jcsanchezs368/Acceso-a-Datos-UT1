package es.ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import es.clases.Contacto;

public class Ejercicio9 {
    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Path agenda = Path.of("agenda.bin");
        String nombreContacto;
        Contacto contactos = null;

        if(!Files.exists(agenda)){
            System.out.println("No se ha encontrado el archivo \"" + agenda + "\". Se ha creado una agenda vacía.");
            contactos = new Contacto();
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(agenda.toFile()))){
                contactos = (Contacto) ois.readObject();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
                        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(agenda.toFile()))){
                            oos.writeObject(contactos);
                            System.out.println("Se han guardado todos los cambios.");
                        }catch(IOException e){
                            e.printStackTrace();
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

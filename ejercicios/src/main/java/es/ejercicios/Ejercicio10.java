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

import es.clases.Mascota;

public class Ejercicio10 {
    public static void main(String[] args) {
        Path fichero = Path.of("mascota.bin");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        Mascota mascota = null;
        if (!Files.exists(fichero)) {
            System.out.println("No se ha encontrado el fichero \"mascota.bin\"");
            
            try {
                Files.createFile(fichero);
                System.out.println("Se ha creado el fichero \"mascota.bin\"");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            mascota = new Mascota();
        }else{
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero.toFile()))){
                mascota = (Mascota) ois.readObject();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        mascota.iniciar();

        do{
            do{
            System.out.println("1. Consultar el estado de la mascota");
            System.out.println("2. Alimentar a la mascota");
            System.out.println("3. Descansar");
            System.out.println("4. Guardar y salir");

            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if(opcion < 0 || opcion > 4){
                System.out.println("Opción inválida");
            }
            }while(opcion < 0 || opcion > 4);

            switch (opcion) {
                case 1:
                    System.out.println(mascota);
                    break;
                case 2:
                    mascota.alimentar();
                    System.out.println(mascota);
                    break;
                case 3:
                    mascota.descansar();
                    System.out.println(mascota);
                    break;
                case 4:
                    System.out.println("Se ha guardado el estado de la mascota:");
                    System.out.println(mascota);
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero.toFile()))){
                        oos.writeObject(mascota);
                        
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                default:
                    break;
            }
        }while (opcion != 4);

        scanner.close();
    }
}

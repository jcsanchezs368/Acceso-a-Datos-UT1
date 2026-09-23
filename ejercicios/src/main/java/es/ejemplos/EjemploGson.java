package es.ejemplos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import es.clases.Persona;

public class EjemploGson {
    //Antes de empezar deberemos añadir el repositorio maven en nuestro pom.xml
        public static void main(String[] args) {
        Path fichero = Path.of("persona.bin");

        try {
            //1. creamos el fichero
            if (!Files.exists(fichero)) {
                Files.createFile(fichero);    
            }
            

            Persona p1 = new Persona("Pedro", 22);
            Persona p2 = new Persona("Ana", 35);

            FileOutputStream fos = new FileOutputStream(fichero.toString());

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Manera más corta:
            // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persona.bin"));

            oos.writeObject(p1);
            oos.writeObject(p2);

            fos.close();
            oos.close();

            // 4. crear flujos para la lectura de los objetos Java
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persona.bin"));
            // .readObject() lanza la excepción ClassNotFoundException, por lo que se deberá añadir en el catch
            Persona p11 = (Persona) ois.readObject();
            Persona p22 = (Persona) ois.readObject();

            System.out.println(p11);
            System.out.println(p22);

            // Liberamos recursos de memoria
            ois.close();
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}

package es.ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("hola.txt"))){
            int numCaracteres = 0;

            while (br.read() != -1) {
                numCaracteres++;
            }

            System.out.println("El documento tiene un total de: " + numCaracteres + " caracteres." );

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

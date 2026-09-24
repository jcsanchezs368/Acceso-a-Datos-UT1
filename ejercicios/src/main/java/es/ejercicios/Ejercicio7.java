package es.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import es.clases.Tablero;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tictactoe.txt", false))) {
            Tablero tablero = new Tablero();
            int x1;
            int y1;

            int x2;
            int y2;

            while (!tablero.esPartidaFinalizada()) {
            
            do{
                System.out.print(" [JUGADOR X]: ¿En qué fila quieres colocar el símbolo X? {1, 2, 3}: ");
                y1 = scanner.nextInt() -1;
                scanner.nextLine();
                System.out.print(" [JUGADOR X]: ¿En qué columna quieres colocar el símbolo X? {1, 2, 3}: ");
                x1 = scanner.nextInt() -1;
                scanner.nextLine();
            }while(tablero.esCasillaOcupada(y1, x1));
            
            tablero.getTablero()[y1][x1] = 'X';

            System.out.println(tablero);

            do{
                System.out.print(" [JUGADOR O]: ¿En qué fila quieres colocar el símbolo O? {1, 2, 3}: ");
                y2 = scanner.nextInt() -1;
                scanner.nextLine();
                System.out.print(" [JUGADOR O]: ¿En qué columna quieres colocar el símbolo O? {1, 2, 3}: ");
                x2 = scanner.nextInt() -1;
                scanner.nextLine();
            }while(tablero.esCasillaOcupada(y2, x2));
            
            tablero.getTablero()[y2][x2] = 'O';
            System.out.println(tablero);
            }

            bw.write(tablero.toString());;

        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}

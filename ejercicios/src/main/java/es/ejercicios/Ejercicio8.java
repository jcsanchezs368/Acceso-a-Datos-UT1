package es.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numMaterias;
        int numAlumnos;
        ArrayList<String> materias = new ArrayList<String>();
        ArrayList<String> alumnos = new ArrayList<String>();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("curso.csv", true))){
            
            do{
                System.out.print("¿Cuantas materias hay?: ");
                numMaterias = scanner.nextInt();
                scanner.nextLine();
            }while(numMaterias <= 0);

            for(int i = 0; i < numMaterias; i++){
                System.out.println("Nombre de la materia " + (i+1) + ": ");
                materias.add(scanner.nextLine());
            }

            do{
                System.out.print("¿Cuantos alumnos hay?: ");
                numAlumnos = scanner.nextInt();
                scanner.nextLine();
            }while(numAlumnos <= 0);

            for(int i = 0; i < numAlumnos; i++){
                System.out.println("Nombre del alumno " + (i+1) + ": ");
                alumnos.add(scanner.nextLine());
            }

            bw.write("Alumno");
            for (String materia : materias) {
                bw.write(";" + materia);
            }
            bw.write(";Media");
            bw.newLine();
            int nota;
            double suma;
            for (String alumno : alumnos) {
                suma = 0;
                bw.write(alumno);
                for (String materia : materias) {
                    
                    System.out.print("[ALUMNO: " + alumno + "] Introduzca la nota de la materia " + materia + ": ");
                    nota = scanner.nextInt();
                    scanner.nextLine();
                    suma += nota;
                    bw.write(";" + nota);
                }

                bw.write(";" + suma / (double) materias.size());
                bw.newLine();
                bw.flush();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

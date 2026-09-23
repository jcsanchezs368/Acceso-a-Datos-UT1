package es.ejercicios;

import java.nio.file.Path;

public class Ejercicio1 {
    public static void main(String[] args) {
        Path ruta = Path.of("fotos/2026/gamba.png");
        System.out.println("Nombre del archivo: " + ruta.getFileName());
        System.out.println("Directorio padre: " + ruta.getParent());
        System.out.println("¿Es una ruta absoluta? " + (ruta.isAbsolute() ? "Sí":"No"));
        System.out.println("Ruta completa: " + ruta);
    }
}
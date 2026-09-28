package ejercicio3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class Ejercicio3 {
    public static void main(String[] args) {
        imprimirHijosDeDirectorio(Path.of("biblioteca"), 0);
    }
    public static void imprimirHijosDeDirectorio(Path padre, int nivel){
        if (nivel == 0) {
            System.out.println(padre);
        }
        try {

            Iterator<Path> it = Files.list(padre).iterator();
            
            while (it.hasNext()) {
                Path dir = it.next();
                for(int i = 0; i <= nivel; i++){
                    System.out.print("\t");
                }
                System.out.print(dir.getFileName() + "\n");

                imprimirHijosDeDirectorio(dir, nivel+1);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}

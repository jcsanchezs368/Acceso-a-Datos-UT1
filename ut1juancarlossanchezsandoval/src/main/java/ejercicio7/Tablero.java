package ejercicio7;

public class Tablero {
    private char tablero[][];

    public Tablero(){
        this.tablero = new char[3][3];
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[0].length; j++){
                this.tablero[i][j] = '-';
            }
        }

    }

    public boolean esCasillaOcupada(int x, int y){
        if(x < 0 || x > this.tablero[0].length){
            System.out.println("columna inválida");
            return true;
        }

        if(y < 0 || y > this.tablero.length){
            System.out.println("fila inválida");
            return true;
        }
        if (this.tablero[x][y] != '-') {
            System.out.println("La casilla ["+ (x+1) + ", "+ (y+1) + "] está ocupada");
            return true;
        }
        
        return false;
    }

    public boolean esPartidaFinalizada(){
        boolean hayHueco = false;

        if(tienenMismoSimbolo(this.tablero[0][0], this.tablero[1][1], this.tablero[2][2])){
            System.out.println("HA GANADO EL JUGADOR " + this.tablero[0][0]);
            return true;
        }

        
        if(tienenMismoSimbolo(this.tablero[2][0], this.tablero[1][1], this.tablero[0][2])){
            System.out.println("HA GANADO EL JUGADOR " + this.tablero[2][0]);
            return true;
        }

        for(int i = 0; i < this.tablero.length; i++){
            if(tienenMismoSimbolo(this.tablero[i][0], this.tablero[i][1], this.tablero[i][2])){
                System.out.println("HA GANADO EL JUGADOR " + this.tablero[i][0]);
                return true;
            }

            if(tienenMismoSimbolo(this.tablero[0][i], this.tablero[1][i], this.tablero[2][i])){
                System.out.println("HA GANADO EL JUGADOR " + this.tablero[0][i]);
                return true;
            }

            for(int j = 0; j < this.tablero[0].length; j++){
            
                if (this.tablero[i][j] == '-') {
                    hayHueco = true;
                }
            }
        }

        if (hayHueco) {
            return false;
        }else{
            System.out.println("EMPATE. Fin de la partida");
        }
        return true;
    }

    private boolean tienenMismoSimbolo(char casilla1, char casilla2, char casilla3){
        if (casilla1 != '-' && casilla1 == casilla2 && casilla1 == casilla3) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String texto = "";
        for(int i = 0; i < this.tablero.length; i++){
            for(int j = 0; j < this.tablero[0].length; j++){
                texto += " | " + this.tablero[i][j];
            }
            texto += " |\n";
        }
        
        return texto;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }
    




}

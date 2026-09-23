package es.clases;

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
        if (this.tablero[y][x] != '-') {
            System.out.println("La casilla ["+ x + ", "+ y + "] está ocupada");
            return true;
        }
        
        return false;
    }

    public boolean esPartidaFinalizada(){
        boolean hayHueco = false;

        if(tienenMismoSimbolo(this.tablero[0][0], this.tablero[1][1], this.tablero[2][2])){
            return true;
        }

        
        if(tienenMismoSimbolo(this.tablero[2][0], this.tablero[1][1], this.tablero[0][2])){
            return true;
        }

        for(int i = 0; i < this.tablero.length; i++){
            if(tienenMismoSimbolo(this.tablero[i][0], this.tablero[i][1], this.tablero[i][2])){
                return true;
            }

            if(tienenMismoSimbolo(this.tablero[0][i], this.tablero[1][i], this.tablero[2][i])){
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

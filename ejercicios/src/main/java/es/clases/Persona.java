package es.clases;

import java.io.Serializable;
//La clase Serializable nos permite traducir una clase java a código binario.
public class Persona implements Serializable{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString(){
        return nombre + " - " + edad + " años";
    }
}

package es.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Contacto implements Serializable{
    private ArrayList<String> contactos;

    public Contacto(){
        this.contactos = new ArrayList<String>();
    }

    public boolean agregarContacto(String contacto){
        if (!this.contactos.contains(contacto)) {
            return contactos.add(contacto);
            
        }

        return false;
    }
    public int numContactos(){
        return this.contactos.size();
    }
    public boolean eliminarContacto(String contacto){
        if (this.contactos.contains(contacto)) {
            return this.contactos.remove(contacto);
        }
        return false;
    }

    public ArrayList<String> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<String> contactos) {
        this.contactos = contactos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contacto other = (Contacto) obj;
        if (contactos == null) {
            if (other.contactos != null)
                return false;
        } else if (!contactos.equals(other.contactos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.contactos.toString();
    }
    
    
}

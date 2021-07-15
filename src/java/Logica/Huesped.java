

package Logica;

import java.util.Date;



public class Huesped extends Persona {
    //pk
    int idHuesped;
    String profesion;

    
    //constructores
    public Huesped() {
    }

    public Huesped(int idHuesped, String profesion, int dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(dni, nombre, apellido, fechaNac, direccion);
        this.idHuesped = idHuesped;
        this.profesion = profesion;
    }

    //getters y setters

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
    
}

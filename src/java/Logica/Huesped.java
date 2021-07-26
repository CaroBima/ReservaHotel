package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
//import javax.persistence.OneToOne;



@Entity
public class Huesped extends Persona implements Serializable {
    

    
    @Basic
    private String profesion;

    
    //constructores
    public Huesped() {
    }

    public Huesped(String profesion, int idPersona, String dni, String nombre, String apellido, String direccion, Date fechaNac) {
        super(idPersona, dni, nombre, apellido, direccion, fechaNac);
        this.profesion = profesion;
    }

   

   

    //getters y setters
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
    
}

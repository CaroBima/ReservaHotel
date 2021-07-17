package Logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
//import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity(name = "huesped")
@PrimaryKeyJoinColumn( referencedColumnName = "idHuesped")
public class Huesped extends Persona {
    
//    @OneToOne
//    int idHuesped;
    
    @Basic
    String profesion;

    
    //constructores
    public Huesped() {
    }

    public Huesped(String profesion, int dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(dni, nombre, apellido, fechaNac, direccion);
        this.profesion = profesion;
    }

    
    
    /*constructor con el idHuesped aca
    public Huesped(int idHuesped, String profesion, int dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(dni, nombre, apellido, fechaNac, direccion);
        this.idHuesped = idHuesped;
        this.profesion = profesion;
    }*/

    //getters y setters
    
    /*getter y setter con idHuesped 
    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }
    */
    
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
    
}

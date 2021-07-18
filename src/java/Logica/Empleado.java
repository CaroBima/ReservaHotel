
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "empleado")
@PrimaryKeyJoinColumn(referencedColumnName = "idEmpleado")
public class Empleado extends Persona implements Serializable{
    
    @Basic
    private String usuario;
    private String contrasenia; //ver como tratar contraseña

    @OneToOne
    private Cargo idCargo; 

    //constructores
    public Empleado() {
    }

    public Empleado(String usuario, String contrasenia, Cargo idCargo, int idPersona, int dni, String nombre, String apellido, String direccion, Date fechaNac) {
        super(idPersona, dni, nombre, apellido, direccion, fechaNac);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.idCargo = idCargo;
    }

   

   
    //getters y setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

   

}
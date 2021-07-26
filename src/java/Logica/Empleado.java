package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable{
    
    @OneToOne (cascade = CascadeType.PERSIST)
    private Usuario usuario;
    

    @OneToOne
    private Cargo idCargo; 

    //constructores
    public Empleado() {
    }

    public Empleado(Usuario usuario, Cargo idCargo, int idPersona, String dni, String nombre, String apellido, String direccion, Date fechaNac) {
        super(idPersona, dni, nombre, apellido, direccion, fechaNac);
        this.usuario = usuario;
        this.idCargo = idCargo;
    }

  

    
    //getters y setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

}

package Logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity(name = "Empleado")
public class Empleado extends Persona{
    //pk
    //private int idEmpleado;
    
    @Basic
    private String cargo;
    private String nombreUsuario;
    private String contrasenia; //ver esto 

    //constructores
    public Empleado() {
    }

    public Empleado(String cargo, String nombreUsuario, String contrasenia, int dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(dni, nombre, apellido, fechaNac, direccion);
        this.cargo = cargo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    
   /*  constructo con pk idEmpleado
    public Empleado(int idEmpleado, String cargo, String nombreUsuario, String contrasenia, int dni, String nombre, String apellido, Date fechaNac, String direccion) {
        super(dni, nombre, apellido, fechaNac, direccion);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }*/
    
    //getters y setters

    /*getters y setters con pk idEmpleado
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
*/
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}

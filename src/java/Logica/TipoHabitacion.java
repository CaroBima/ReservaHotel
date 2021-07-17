
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TipoHabitacion  {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idTipoHabitacion;
    
    @Basic
    private String NombreTipo; //single, doble, triple, multiple
    private int cantidadPersonas; //8 como máximo

    
    
    //constructores
    public TipoHabitacion() {
    }

    public TipoHabitacion(int idTipoHabitacion, String NombreTipo, int cantidadPersonas) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.NombreTipo = NombreTipo;
        this.cantidadPersonas = cantidadPersonas;
    }

    //getters y setters
    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombreTipo() {
        return NombreTipo;
    }

    public void setNombreTipo(String NombreTipo) {
        this.NombreTipo = NombreTipo;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }
    
    
}

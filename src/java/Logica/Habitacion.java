package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Habitacion implements Serializable  {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idHabitacion;
    
    @Basic
    private String nombreTematica;
    private int piso; //8 pisos como maximo
    private int nroHabitacion; // 4 habitaciones por piso
    private Double precioHabitacion;
    private String tipoHab; //tipoHabitacion, si es single, doble

    
    //constructores
    public Habitacion() {
    }

    public Habitacion(int idHabitacion, String nombreTematica, int piso, int nroHabitacion, Double precioHabitacion, String tipoHab) {
        this.idHabitacion = idHabitacion;
        this.nombreTematica = nombreTematica;
        this.piso = piso;
        this.nroHabitacion = nroHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.tipoHab = tipoHab;
    }


    
    //getters y setters

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombreTematica() {
        return nombreTematica;
    }

    public void setNombreTematica(String nombreTematica) {
        this.nombreTematica = nombreTematica;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public Double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(String tipoHab) {
        this.tipoHab = tipoHab;
    }

    

   
}

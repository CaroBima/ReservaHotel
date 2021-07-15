package Logica;

public class Habitacion {
    
    //pk
    private int idHabitacion;
    
    //basic
    private int piso;
    private String nombreTematica;
    private Double precioHabitacion;
    
    private int idTipoHab; //fk de tipoHabitacion

    
    //constructores
    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int piso, String nombreTematica, Double precioHabitacion, int idTipoHab) {
        this.idHabitacion = idHabitacion;
        this.piso = piso;
        this.nombreTematica = nombreTematica;
        this.precioHabitacion = precioHabitacion;
        this.idTipoHab = idTipoHab;
    }
    
    //getters y setters

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getNombreTematica() {
        return nombreTematica;
    }

    public void setNombreTematica(String nombreTematica) {
        this.nombreTematica = nombreTematica;
    }

    public Double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Double precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public int getIdTipoHab() {
        return idTipoHab;
    }

    public void setIdTipoHab(int idTipoHab) {
        this.idTipoHab = idTipoHab;
    }
    
}

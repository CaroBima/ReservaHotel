package Logica;

import java.util.Date;

public class Reserva {
    
    //pk
    private int idReserva;
    
    //basic
    private Date fechaCheckIn;
    private Date fechaCheckOut;
    private int cantPersonas;
    
    //FK
    private int idHabitación;
    private int idEmpleado;
    
    
    //constructores
   
    public Reserva() {
    }

    public Reserva(int idReserva, Date fechaCheckIn, Date fechaCheckOut, int cantPersonas, int idHabitación, int idEmpleado) {
        this.idReserva = idReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cantPersonas = cantPersonas;
        this.idHabitación = idHabitación;
        this.idEmpleado = idEmpleado;
    }
    
     
    //getters y setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(Date fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public Date getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(Date fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public int getIdHabitación() {
        return idHabitación;
    }

    public void setIdHabitación(int idHabitación) {
        this.idHabitación = idHabitación;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}

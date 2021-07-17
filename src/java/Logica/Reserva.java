package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReserva;
    
    @Basic
    private int cantPersonas;
    private int montoTotalReserva;
    @Temporal(TemporalType.DATE)
    private Date fechaCheckIn;
    @Temporal(TemporalType.DATE)
    private Date fechaCheckOut;
    
    
    @OneToOne
    private int idHabitación;
    
    @OneToOne
    private int idEmpleado;
    
    
    //constructores
   
    public Reserva() {
    }

    public Reserva(int idReserva, Date fechaCheckIn, Date fechaCheckOut, int cantPersonas, int montoTotalReserva, int idHabitación, int idEmpleado) {
        this.idReserva = idReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.cantPersonas = cantPersonas;
        this.montoTotalReserva = montoTotalReserva;
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

    public int getMontoTotalReserva() {
        return montoTotalReserva;
    }

    public void setMontoTotalReserva(int montoTotalReserva) {
        this.montoTotalReserva = montoTotalReserva;
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

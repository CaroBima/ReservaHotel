package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReserva;
    
    @Basic
    private int cantPersonas;
    private double montoTotalReserva;
    private Date fechaReserva;
    
    @Temporal(TemporalType.DATE)
    private Date fechaCheckIn;
    @Temporal(TemporalType.DATE)
    private Date fechaCheckOut;
    
    
    @JoinColumn
    @OneToOne (cascade = CascadeType.MERGE)
    private Huesped huesped;
     
    @JoinColumn
    @ManyToOne (cascade = CascadeType.MERGE)
    private Habitacion idHabitación;
    
    @JoinColumn
    @ManyToOne (cascade = CascadeType.MERGE)
    private Empleado idEmpleado;
    
    
    //constructores
   
    public Reserva() {
    }

    public Reserva(int idReserva, int cantPersonas, double montoTotalReserva, Date fechaReserva, Date fechaCheckIn, Date fechaCheckOut, Huesped huesped, Habitacion idHabitación, Empleado idEmpleado) {
        this.idReserva = idReserva;
        this.cantPersonas = cantPersonas;
        this.montoTotalReserva = montoTotalReserva;
        this.fechaReserva = fechaReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.huesped = huesped;
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

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public double getMontoTotalReserva() {
        return montoTotalReserva;
    }

    public void setMontoTotalReserva(double montoTotalReserva) {
        this.montoTotalReserva = montoTotalReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
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

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getIdHabitación() {
        return idHabitación;
    }

    public void setIdHabitación(Habitacion idHabitación) {
        this.idHabitación = idHabitación;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

   
}

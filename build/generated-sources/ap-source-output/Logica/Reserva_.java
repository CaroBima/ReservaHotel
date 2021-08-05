package Logica;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-05T10:00:14")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Huesped> huesped;
    public static volatile SingularAttribute<Reserva, Double> montoTotalReserva;
    public static volatile SingularAttribute<Reserva, Empleado> idEmpleado;
    public static volatile SingularAttribute<Reserva, Date> fechaCheckOut;
    public static volatile SingularAttribute<Reserva, Habitacion> idHabitación;
    public static volatile SingularAttribute<Reserva, Integer> cantPersonas;
    public static volatile SingularAttribute<Reserva, Integer> idReserva;
    public static volatile SingularAttribute<Reserva, Date> fechaReserva;
    public static volatile SingularAttribute<Reserva, Date> fechaCheckIn;

}
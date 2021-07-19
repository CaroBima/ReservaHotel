package Logica;

import Persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearHabitación(String nombreTematico, int nroHabitacion, int pisoHabitacion, String tipoHabitación, double precio){
        Habitacion habitacion = new Habitacion();
        
        habitacion.setNombreTematica(nombreTematico);
        habitacion.setNroHabitacion(nroHabitacion);
        habitacion.setPiso(pisoHabitacion);
        habitacion.setTipoHab(tipoHabitación);
        habitacion.setPrecioHabitacion(precio);
        
        controlPersis.crearHabitacion(habitacion);
        System.out.println("llega a controladora");
    }
    
    //métodos para la gestion de cargos
    public void crearCargo(String cargoEmpleado){
       Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoEmpleado);
        controlPersis.crearCargo(cargo);
    }
}

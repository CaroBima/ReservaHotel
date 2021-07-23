
package Persistencia;

import Logica.Cargo;
import Logica.Empleado;
import Logica.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    //metodos para la Habitación
    public void crearHabitacion(Habitacion cuarto){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        controlHabitacion.create(cuarto);
    }
    
    public List<Habitacion> recuperarHabitaciones(){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        List<Habitacion> listaHab = new ArrayList();
        listaHab = controlHabitacion.findHabitacionEntities();
        return listaHab;
    }
    
    
    
    //metodos para dar de alta un nuevo empleado
    public void crearEmpleado(Empleado empleado){
        EmpleadoJpaController controlEmple = new EmpleadoJpaController();
        controlEmple.create(empleado);
    }
    
   
    
    
    //metodos para el cargo
    public void crearCargo(Cargo cargo){
        CargoJpaController controlCargo = new CargoJpaController();
        controlCargo.create(cargo);
    }
    
     public List<Cargo> recuperarCargos(){
       CargoJpaController controlCargo = new CargoJpaController();
        List<Cargo> listaCargos = new ArrayList();
        listaCargos = controlCargo.findCargoEntities();
        return listaCargos;
    }
}

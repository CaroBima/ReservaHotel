
package Persistencia;

import Logica.Cargo;
import Logica.Empleado;
import Logica.Habitacion;

public class ControladoraPersistencia {
    //metodos para la Habitación
    public void crearHabitacion(Habitacion cuarto){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        controlHabitacion.create(cuarto);
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
}

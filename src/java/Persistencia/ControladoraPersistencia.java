
package Persistencia;

import Logica.Habitacion;

public class ControladoraPersistencia {
    
    
    //metodos para la Habitación
    public void altaHabitacion(Habitacion cuarto){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        controlHabitacion.create(cuarto);
    }
    
}

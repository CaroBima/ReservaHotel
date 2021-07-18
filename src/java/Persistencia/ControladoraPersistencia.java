
package Persistencia;

import Logica.Habitacion;

public class ControladoraPersistencia {
    
    
    //metodos para la Habitación
    public void crearHabitacion(Habitacion cuarto){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        controlHabitacion.create(cuarto);
        
        
    }
    
}

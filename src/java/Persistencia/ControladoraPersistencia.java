
package Persistencia;

import Logica.Cargo;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Reserva;
import Logica.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    
    //métodos para la reserva
    
    public void crearReserva(Reserva reserva){
        ReservaJpaController controlReserva = new ReservaJpaController();
        controlReserva.create(reserva);
    }
    
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
    
        //método para buscar una habitacion por su id y retornarla
    public Habitacion buscarUnaHabitacion(int idHabitacion){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        Habitacion habitacion = new Habitacion();
        
        habitacion = controlHabitacion.findHabitacion(idHabitacion);
        
        return habitacion;
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
     
     
    public void agregarAdmin(){
        UsuarioJpaController controlUsuario = new UsuarioJpaController();
        Usuario usuario = new Usuario();
        List<Usuario> listaUsuarios;
        
        //asigno los datos para poder pasarlo a la controladora de usuario al guardarlo
        usuario.setNombreUsuario("admin");
        usuario.setContrasenia("admin");
        
        //recupero la lista de usuarios
        listaUsuarios = controlUsuario.findUsuarioEntities();
        
        if(listaUsuarios == null){
            controlUsuario.create(usuario);
        }
        
    }

}
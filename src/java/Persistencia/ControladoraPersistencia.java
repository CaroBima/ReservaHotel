
package Persistencia;

import Logica.Cargo;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    //métodos para la reserva
    public void crearReserva(Reserva reserva){
        ReservaJpaController controlReserva = new ReservaJpaController();
        controlReserva.create(reserva);
    }
    
    public List recuperarReservas(){
        ReservaJpaController controlReserva = new ReservaJpaController();
        List<Reserva> listaReservas;
        listaReservas = controlReserva.findReservaEntities();
        
        return listaReservas;
    
    }
    
    public void borrarReserva(int idReserva){
        ReservaJpaController controlReserva = new ReservaJpaController();
        try {
            controlReserva.destroy(idReserva);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //recupero una reserva por su id y la devuelvo
    public Reserva buscarUnaReserva(int idReserva){
        ReservaJpaController controlReserva =  new ReservaJpaController();
        Reserva reserva = new Reserva();
        
        reserva = controlReserva.findReserva(idReserva);
        
        return reserva;
    }
    
    
    //busco un huesped por su id
    public Huesped buscarHuespedxId(int idHuesped){
        HuespedJpaController controlHuesped = new HuespedJpaController();
        Huesped huesped = new Huesped();
        
        huesped = controlHuesped.findHuesped(idHuesped);
        
        return huesped;
    }
    
    //guardo el huesped en la base de datos
    public void crearHuesped(Huesped huesped){
        HuespedJpaController controlHuesped = new HuespedJpaController();
        
        controlHuesped.create(huesped);
    }
    
    
    //devuelve la lista de huespedes
    public List recuperarHuespedes(){
        List <Huesped> listaHuesped;
        HuespedJpaController controlHuesped = new HuespedJpaController();
        
        listaHuesped = controlHuesped.findHuespedEntities();
        
        return listaHuesped;
    }
    
    //metodos para la Habitación
    public void crearHabitacion(Habitacion cuarto){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        controlHabitacion.create(cuarto);
    }
    
    public void modificarHabitacion(Habitacion habitacion){
        HabitacionJpaController control = new HabitacionJpaController();
        try {
            control.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //recupera una lista de habitaciones
    public List<Habitacion> recuperarHabitaciones(){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        List<Habitacion> listaHab;
        listaHab = controlHabitacion.findHabitacionEntities();
        return listaHab;
    }
    
        //método para buscar una habitacion por su id y retornarla
    public Habitacion buscarUnaHabitacion(int idHabitacion){
        HabitacionJpaController controlHabitacion = new HabitacionJpaController();
        Habitacion habitacion;
        
        habitacion = controlHabitacion.findHabitacion(idHabitacion);
        
        return habitacion;
    }
    
    public void borrarHabitacion(int idHabitacion){
        try {
            HabitacionJpaController controlHabitacion = new HabitacionJpaController();
            controlHabitacion.destroy(idHabitacion);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //metodos para dar de alta un nuevo empleado
    public void crearEmpleado(Empleado empleado){
        EmpleadoJpaController controlEmple = new EmpleadoJpaController();
        controlEmple.create(empleado);
    }
    
   public List recuperarEmpleados(){
       List<Empleado> listaEmple;
       
       EmpleadoJpaController controlEmple = new EmpleadoJpaController();
       listaEmple = controlEmple.findEmpleadoEntities();
       
       return listaEmple;
   }
    
    
    //metodos para el cargo
    public void crearCargo(Cargo cargo){
        CargoJpaController controlCargo = new CargoJpaController();
        controlCargo.create(cargo);
    }
    
     public List<Cargo> recuperarCargos(){
       CargoJpaController controlCargo = new CargoJpaController();
        List<Cargo> listaCargos;
        listaCargos = controlCargo.findCargoEntities();
        return listaCargos;
    }
     
     //busco un determinado cargo pasando por parametro el nombre 
     public Cargo buscarUnCargo(String nombreCargo){
         List<Cargo> listaCargos;
         Cargo cargo = new Cargo();
                 
         listaCargos = recuperarCargos();
         
         if(!listaCargos.isEmpty()){
             for(Cargo c : listaCargos){
                if(c.getNombreCargo().equals(nombreCargo)){
                     cargo = c;
                     return cargo;
                 }
             }
         }
         
        if(cargo.getNombreCargo() == null){
            //si no se encuentra el cargo en la bd lo asigna al cargo para devolverlo
            CargoJpaController controlCargo = new CargoJpaController();
            cargo.setNombreCargo(nombreCargo);
            //lo guardo en la bd
            controlCargo.create(cargo);
             
         }
         
         return cargo;
     }
     
     
    //metodos para usuario
     
     public List recuperarUsuarios(){
         UsuarioJpaController controlUsuario = new UsuarioJpaController();
         List <Usuario> listaUsuarios;
         
         //recupero la lista de usuarios y la devuelvo
         listaUsuarios = controlUsuario.findUsuarioEntities();
         return listaUsuarios;
     }
     
     
     public void agregarAdmin(Empleado empleado){
       EmpleadoJpaController controlEmpleado = new EmpleadoJpaController();
       controlEmpleado.create(empleado);
         
     }
     /*
     //FUNCIONAAAAAA, para agregar solo el usuario admin
    public void agregarAdmin(){
        UsuarioJpaController controlUsuario = new UsuarioJpaController();
        Usuario usuario = new Usuario();
        List<Usuario> listaUsuarios;
        
        //asigno los datos para poder pasarlo a la controladora de usuario al guardarlo
        usuario.setNombreUsuario("admin");
        usuario.setContrasenia("admin");
        
        //recupero la lista de usuarios
        listaUsuarios = controlUsuario.findUsuarioEntities();
        
        if(listaUsuarios.isEmpty()){
            controlUsuario.create(usuario);
        }
        
    }
    */

}
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
//Métodos para la reserva
    public void crearReserva(String nombreHuesped, String apellidoHuesped, String dniHuesped, String fechaNacHuesped,  String direccionHuesped, String profesionHuesped, String  cantidadPersonas, String habitacionReserva, String fechaCheckIn, String fechaCheckOut, String importeTotalReserva){
        
    }
    
    
//Métodos para el empleado
    public void crearEmpleado(String usuarioEmpleado, String contrasenia, String nombreEmpleado, String apellidoEmpleado, String dniEmpleado, String direccionEmpleado, String fechaNacimiento, String cargoEmpleado){
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Cargo cargoEmple = new Cargo();
        
        //busco el cargo de empleado en la base de datos utilizando el metodo definido mas abajo
        //si el cargo no se encuentra en la base de datos, lo crea
        cargoEmple = this.buscarCargo(cargoEmpleado);
        
        //convierto la fecha en date
        Date fechaNac = this.ParseFecha(fechaNacimiento);
        
        //tomo los datos de usuario y contraseña y los guardo en un objeto usuario para pasarlo por parametro
        usuario.setNombreUsuario(usuarioEmpleado);
        usuario.setContrasenia(contrasenia);
       
        //seteo los datos en el objeto usuario para poder pasarlo como parametro a la controladora de la persistencia
        empleado.setUsuario(usuario);
        empleado.setNombre(nombreEmpleado);
        empleado.setApellido(apellidoEmpleado);
        empleado.setDni(dniEmpleado);
        empleado.setDireccion(direccionEmpleado);
        empleado.setFechaNac(fechaNac);
        empleado.setIdCargo(cargoEmple);
        
        controlPersis.crearEmpleado(empleado);
    }


    
//método para convertir el string en formato fecha para poder pasarlo a la controladora de persistencia
     public Date ParseFecha(String fechaNacimiento){
        Date fechaNac = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        try {
            fechaNac = formato.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaNac;
    }
    

//Métodos para la habitación
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
   
    public List<Habitacion> recuperarHabitacion(){
    //para traer el listado de habitaciones
        List<Habitacion> listaHabit = new ArrayList();
        listaHabit = controlPersis.recuperarHabitaciones();
        return listaHabit;
    }
    

//métodos para la gestion de cargos
    public void crearCargo(String cargoEmpleado){
       Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoEmpleado);
        controlPersis.crearCargo(cargo);
    }
    
    //método utilizado para recuperar la lista de cargos en un array, para pasarlos al combobox
    public List<Cargo> recuperarCargos(){
        List<Cargo> listaCargos;
        listaCargos = controlPersis.recuperarCargos();
        return listaCargos;
    }
    
    //método para buscar el cargo en la bd, para poder pasar el empleado a la controladora 
    // de persistencia si el cargo no esta, lo agrega    
    public Cargo buscarCargo(String nombreCargo){
        System.out.println("entra a buscar cargo");
        List<Cargo> listaCargos;
        Cargo cargo = new Cargo();
        listaCargos = this.recuperarCargos();
        
        //verifico si la lista esta vacía o no, para ver si hay registros en la base de datos
        if(!listaCargos.isEmpty()){
            //recorro la lista buscando si esta el cargo
            for( Cargo c : listaCargos){
                if(c.getNombreCargo().equals(nombreCargo)){
                    cargo = c;
                    break;
                } 
            }
        }
        
        //si el cargo no esta guardado, lo crea
        if (listaCargos.isEmpty() || cargo.getNombreCargo() == null){
            this.crearCargo(nombreCargo);
        } 
        
        return cargo;
    }
    
}

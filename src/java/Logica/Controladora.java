package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    
//Métodos para el empleado
    public void crearEmpleado(String usuarioEmpleado, String contrasenia, String nombreEmpleado, String apellidoEmpleado, String dniEmpleado, String direccionEmpleado, String fechaNacimiento, String cargoEmpleado){
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        
        System.out.println("desde controladora: " + usuarioEmpleado + " " +contrasenia + " " +nombreEmpleado + " " + apellidoEmpleado + " " + dniEmpleado + " " + direccionEmpleado + " " + fechaNacimiento + " " + cargoEmpleado);
        Cargo cargoEmple = new Cargo();
        
        //busco el cargo de empleado en la base de datos utilizando el metodo definido mas abajo
        cargoEmple = this.buscarCargo(cargoEmpleado);
        
        //compruebo que el cargo del empleado este en la base de datos, utilizo el 
        //cargoEmple recuperado de la bd y el string cargoEmpleado pasado desde el front
        if(cargoEmple.equals(null) || (!cargoEmpleado.equals("-")) ){ 
            this.crearCargo(cargoEmpleado);
            System.out.println("llega");
            //vuelvo a buscarlo para obtener el id que se le asigno automaticamente, 
            //para poder pasarlo como parametro en empleado
            cargoEmple = this.buscarCargo(cargoEmpleado);
        }
            
        //tomo los datos de usuario y contraseña y los guardo en un objeto usuario para pasarlo por parametro
        System.out.println("cargo " + cargoEmple.getNombreCargo() + cargoEmple.getIdCargo() );
        usuario.setNombreUsuario(usuarioEmpleado);
        usuario.setContrasenia(contrasenia);
       
        //seteo los datos en el objeto usuario para poder pasarlo como parametro a la controladora de la persistencia
        empleado.setUsuario(usuario);
        empleado.setNombre(nombreEmpleado);
        empleado.setApellido(apellidoEmpleado);
        empleado.setDni(dniEmpleado);
        empleado.setDireccion(direccionEmpleado);
        //empleado.setFechaNac(fechaNac);
        empleado.setIdCargo(cargoEmple);
        
       
    }


    
//método para convertir el string en formato fecha para poder pasarlo a la controladora de persistencia
     public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
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
   

//métodos para la gestion de cargos
    public void crearCargo(String cargoEmpleado){
       Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoEmpleado);
        controlPersis.crearCargo(cargo);
    }
    
//método utilizado para recuperar la lista de cargos en un array, para pasarlos al combobox
    public List<Cargo> recuperarCargos(){
        List<Cargo> listaCargos = new ArrayList();
        listaCargos = controlPersis.recuperarCargos();
        return listaCargos;
    }
    
//método para buscar el cargo en la bd, para poder pasar el empleado a la controladora de persistencia    
    public Cargo buscarCargo(String nombreCargo){
        List<Cargo> listaCargos = new ArrayList();
        Cargo cargo = new Cargo();
        listaCargos = this.recuperarCargos();
        
        //recorro la lista buscando si esta el cargo
        for( Cargo c : listaCargos){
            if(c.getNombreCargo().equals(nombreCargo)){
                cargo = c;
                break;
            }
        }
        return cargo;
    }
    
}

package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
//Métodos para la reserva
    public void crearReserva(String nombreHuesped, String apellidoHuesped, String dniHuesped, String fechaNacHuesped,  String direccionHuesped, String profesionHuesped, String  cantidadPersonas, String habitacionReserva, String fechaCheckIn, String fechaCheckOut, String importeTotalReserva){
        Huesped huesped = new Huesped();
        Date fechaNac;
        Date fCheckIn;
        Date fCheckOut;
        Habitacion habitacion;
        Reserva reserva = new Reserva();
        int cantidadPers;
        double montoTot;
        int idHab;
        
        
        //falta obtener el usuario para poder pasarlo a la bd <<< this.idEmpleado = idEmpleado;
        
        //convierto los strings en date y float
        cantidadPers = Integer.parseInt(cantidadPersonas);
        montoTot = Double.parseDouble(importeTotalReserva);
        idHab = Integer.parseInt(habitacionReserva);
        
        //convierto los strings de fechas en Date
        fechaNac = parseFecha(fechaNacHuesped);
        fCheckIn = parseFecha(fechaCheckIn);
        fCheckOut = parseFecha(fechaCheckOut);
        
        //busco la habitacion
        habitacion = buscarUnaHabitacion(idHab);
               
        //guardo los datos correspondientes al huesped 
        huesped.setNombre(nombreHuesped);
        huesped.setApellido(apellidoHuesped);
        huesped.setDni(dniHuesped);
        huesped.setFechaNac(fechaNac);
        huesped.setProfesion(profesionHuesped);
        huesped.setDireccion(direccionHuesped);
        
        
        //asigno los datos en reserva para pasarlos al jpacontroller
        reserva.setHuesped(huesped);
        reserva.setCantPersonas(cantidadPers);
        reserva.setMontoTotalReserva(montoTot);
        reserva.setFechaCheckIn(fCheckIn);
        reserva.setFechaCheckOut(fCheckOut);
        reserva.setIdHabitación(habitacion);
        
 }
    
    
//Métodos para el empleado
    public void crearEmpleado(String usuarioEmpleado, String contrasenia, String nombreEmpleado, String apellidoEmpleado, String dniEmpleado, String direccionEmpleado, String fechaNacimiento, String cargoEmpleado){
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Cargo cargoEmple = new Cargo();
        
        //busco el cargo de empleado en la base de datos utilizando el metodo definido mas abajo
        //si el cargo no se encuentra en la base de datos, lo crea
        cargoEmple = buscarUnCargo(cargoEmpleado);
        System.out.println(cargoEmple.getNombreCargo() + cargoEmple.getIdCargo());
        
        //convierto la fecha en date
        Date fechaNac = parseFecha(fechaNacimiento);
        
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
        
        System.out.println(cargoEmple.getNombreCargo() + cargoEmple.getIdCargo());
        controlPersis.crearEmpleado(empleado);
    }


    
//método para convertir el string en formato fecha para poder pasarlo a la controladora de persistencia
     public Date parseFecha(String fechaNacimiento){
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
        
    }
    
    public double calcularMontoTotal(String fechaDesde, String fechaHasta, String habitacionReserva){
        double montoTotal = 0;
        double montoPorDia = 0;
        Date fechaDesdeCalc;
        Date fechaHastaCalc;
        int cantidadDias;
        int idHab;
        Controladora control = new Controladora();
        
        //parseo las fechas de string a date
        fechaDesdeCalc = parseFecha(fechaDesde);
        fechaHastaCalc = parseFecha(fechaHasta);
        
        idHab = Integer.parseInt(habitacionReserva);
        
        //calculo la cantidad de dias
        int milisegundosPorDia = 86400000;
        cantidadDias = (int) ((fechaHastaCalc.getTime()-fechaDesdeCalc.getTime()) / milisegundosPorDia);
        
        //recupero el costo de la habitacion y calculo el total para retornarlo
        montoPorDia = control.buscarPrecioHabitacion(idHab);
        montoTotal = montoPorDia * cantidadDias;
        
        return montoTotal;
    }
   
    //para devolver el listado de habitaciones
    public List<Habitacion> recuperarHabitaciones(){
    
        return controlPersis.recuperarHabitaciones();
    }
    
        //recupera la habitacion segun su id de habitacion
    public Habitacion buscarUnaHabitacion(int id){
        
        return controlPersis.buscarUnaHabitacion(id);
    }
    
    //utilizada para consultar el precio de una determinada habitacion
    public double buscarPrecioHabitacion(int id){
        double importeHabitacion;
        Habitacion habitacion;
        
        //recupero la habitacion y obtengo el precio por dia
        habitacion = buscarUnaHabitacion(id);
        importeHabitacion = habitacion.getPrecioHabitacion();
        
        return importeHabitacion;
    }

////métodos para la gestion de cargos
    
    //método utilizado para recuperar la lista de cargos en un array, para pasarlos al combobox
    public List<Cargo> recuperarCargos(){
        List<Cargo> listaCargos;
        listaCargos = controlPersis.recuperarCargos();
        return listaCargos;
    }

    
    public void crearCargo(String cargoEmpleado){
       Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoEmpleado);
        
        controlPersis.crearCargo(cargo);
    }
    
    
    public Cargo buscarUnCargo(String nombreCargo){
        Cargo cargo = new Cargo();
        cargo = controlPersis.buscarUnCargo(nombreCargo);
        return cargo;
    }
    

    
    //para agregar el usuario admin cuando se carga por primera vez
    public void agregarAdmin(){
        controlPersis.agregarAdmin();
    }
    
    
    //metodo para el logueo del usuario, verifica si existe en la base de datos
    //si no hay ningun usuario, crea el usuario admin, clave admin
    public boolean verificarUsuario(String usuario, String contrasenia){
        List<Usuario> listaUsuarios; 
        listaUsuarios = controlPersis.recuperarUsuarios();
        
        if(!listaUsuarios.isEmpty()){
            for( Usuario usu : listaUsuarios){
                if(usu.getNombreUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)){
                    return true;
                }
                    
            }
        }else{ //si la lista está vacía agrego el usuario admin / clave admin
            agregarAdmin();
        }
    
        return false;
    }
    
}

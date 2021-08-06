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
    public void crearReserva(String nombreHuesped, String apellidoHuesped, String dniHuesped, String fechaNacHuesped, String direccionHuesped, String profesionHuesped, String cantidadPersonas, String habitacionReserva, String fechaCheckIn, String fechaCheckOut, String usuario) {
        Huesped huesped = new Huesped();
        Date fechaNac;
        Date fCheckIn;
        Date fCheckOut;
        Habitacion habitacion;
        Empleado emple;
        Reserva reserva = new Reserva();
        int cantidadPers;
        double montoTot;
        int idHab;
        Date fechaHoy = new Date();

        //convierto los strings en date y float
        cantidadPers = Integer.parseInt(cantidadPersonas);
        idHab = Integer.parseInt(habitacionReserva);

        //convierto los strings de fechas en Date
        fechaNac = parseFecha(fechaNacHuesped);
        fCheckIn = parseFecha(fechaCheckIn);
        fCheckOut = parseFecha(fechaCheckOut);

        //busco la habitacion
        habitacion = buscarUnaHabitacion(idHab);

        //busco el empleado que hizo la reserva
        emple = buscarUnEmpleado(usuario);

        //guardo los datos correspondientes al huesped 
        huesped.setNombre(nombreHuesped);
        huesped.setApellido(apellidoHuesped);
        huesped.setDni(dniHuesped);
        huesped.setFechaNac(fechaNac);
        huesped.setProfesion(profesionHuesped);
        huesped.setDireccion(direccionHuesped);

        //cálculo del monto total de la reserva
        montoTot = calcularMontoTotal(fCheckIn, fCheckOut, habitacion);

        //asigno los datos en reserva para pasarlos al jpacontroller
        reserva.setHuesped(huesped);
        reserva.setCantPersonas(cantidadPers);
        reserva.setMontoTotalReserva(montoTot);
        reserva.setFechaCheckIn(fCheckIn);
        reserva.setFechaCheckOut(fCheckOut);
        reserva.setIdHabitación(habitacion);
        reserva.setMontoTotalReserva(montoTot);
        reserva.setIdEmpleado(emple);
        reserva.setFechaReserva(fechaHoy);

        controlPersis.crearReserva(reserva);
    }

    //recuperar listado de reservas
    public List recuperarReservas() {
        Reserva reserva = new Reserva();
        List<Reserva> listaReservas;

        listaReservas = controlPersis.recuperarReservas();

        return listaReservas;
    }
    
    //recupero una reserva por su id y la devuelvo
    public Reserva buscarUnaReserva(int idReserva){
        Reserva reser;
        reser = controlPersis.buscarUnaReserva(idReserva);
        return reser;
    }
    
    public void borrarReserva(int idReserva){
        controlPersis.borrarReserva(idReserva);
    }

//Métodos para el empleado
    public void crearEmpleado(String usuarioEmpleado, String contrasenia, String nombreEmpleado, String apellidoEmpleado, String dniEmpleado, String direccionEmpleado, String fechaNacimiento, String cargoEmpleado) {
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Cargo cargoEmple;

        //busco el cargo de empleado en la base de datos utilizando el metodo definido mas abajo
        //si el cargo no se encuentra en la base de datos, lo crea
        cargoEmple = buscarUnCargo(cargoEmpleado);

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

        controlPersis.crearEmpleado(empleado);
    }

    public Empleado buscarUnEmpleado(String usuario) {
        Empleado empleado = new Empleado();
        List<Empleado> listaEmple;
        Usuario usu;

        //traigo la lista de empleados
        listaEmple = controlPersis.recuperarEmpleados();

        //recorro la lista y recupero los usuarios. Verifico si el nombre de usuario 
        //coincide con el buscado y lo devuelvo
        if (!listaEmple.isEmpty()) {
            for (Empleado e : listaEmple) {
                usu = e.getUsuario();
                if (usu != null) {
                    if (usu.getNombreUsuario().equals(usuario)) {
                        empleado = e;
                        return empleado;
                    }
                }
            }
        }
        return empleado;
    }

    public List recuperarEmpleados() {
        List<Empleado> listaEmpleados;
        listaEmpleados = controlPersis.recuperarEmpleados();

        return listaEmpleados;
    }

//método para convertir el string en formato fecha para poder pasarlo a la controladora de persistencia
    public Date parseFecha(String fechaAParsear) {
        Date fechaParse = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fechaParse = formato.parse(fechaAParsear);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        formato.format(fechaParse);
        return fechaParse;
    }

    //permite darle el formato a la fecha
    public String formatearFecha(Date fecha) {
        String fechaFormateada;
        
        //le doy el formato a la fecha para poder devolverla y mostrarla
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        fechaFormateada = formato.format(fecha);
        
        return fechaFormateada;

    }

    //devuelve la lista de huespedes registrados
    public List recuperarHuespedes() {
        List<Huesped> listaHuesped;
        listaHuesped = controlPersis.recuperarHuespedes();
        return listaHuesped;
    }

//Métodos para la habitación
    public void crearHabitación(String nombreTematico, int nroHabitacion, int pisoHabitacion, String tipoHabitación, double precio) {
        Habitacion habitacion = new Habitacion();

        habitacion.setNombreTematica(nombreTematico);
        habitacion.setNroHabitacion(nroHabitacion);
        habitacion.setPiso(pisoHabitacion);
        habitacion.setTipoHab(tipoHabitación);
        habitacion.setPrecioHabitacion(precio);

        controlPersis.crearHabitacion(habitacion);

    }

    public void modificarHabitacion(Habitacion habitacion) {
        controlPersis.modificarHabitacion(habitacion);
    }

    public void borrarHabitacion(int idHabitacion) {
        controlPersis.borrarHabitacion(idHabitacion);
    }

    public double calcularMontoTotal(Date fCheckIn, Date fCheckout, Habitacion habitacion) {
        double montoTotal = 0;
        double montoPorDia = 0;
        int cantidadDias;

        //calculo la cantidad de dias
        int milisegundosPorDia = 86400000;
        cantidadDias = (int) ((fCheckout.getTime() - fCheckIn.getTime()) / milisegundosPorDia);

        //recupero el costo de la habitacion y calculo el total para retornarlo
        montoPorDia = habitacion.getPrecioHabitacion();
        montoTotal = montoPorDia * cantidadDias;

        return montoTotal;
    }

    //para devolver el listado de habitaciones
    public List<Habitacion> recuperarHabitaciones() {

        return controlPersis.recuperarHabitaciones();
    }
    
    //devuelve las habitaciones disponibles entre las fechas seleccionadas
    public List<Habitacion> buscarHabitacionesDisponibles(Date fCheckIn, Date fCheckOut){
        List<Habitacion> listaHabDisponibles = new ArrayList();
        List<Reserva> listaReservas;
        //traigo las reservas guardadas
        listaReservas = controlPersis.recuperarReservas();
           
        //verifico que la lista no este vacía y la recorro
            if(listaReservas != null){
                for( Reserva reser : listaReservas){
                    //comparo si la fecha de checkin nueva es posterio a la fecha de la reserva 
                    //guardada o si la fecha de checkOut nueva es anterior a la fecha de 
                    //reserva guardada
                    if( (fCheckIn.compareTo(reser.getFechaCheckOut())>= 0) || (fCheckOut.compareTo(reser.getFechaCheckIn())<=0) ){
                        //agrego la habitacion disponible a la lista de habitaciones a retornar
                        System.out.println("llega a comparar habitaciones y guarda la disponible");
                        listaHabDisponibles.add(reser.getIdHabitación());
                    }
                    
                }
            }
       
        return listaHabDisponibles;
    }

    //recupera la habitacion segun su id de habitacion
    public Habitacion buscarUnaHabitacion(int id) {

        return controlPersis.buscarUnaHabitacion(id);
    }

    //utilizada para consultar el precio de una determinada habitacion
    public double buscarPrecioHabitacion(int id) {
        double importeHabitacion;
        Habitacion habitacion;

        //recupero la habitacion y obtengo el precio por dia
        habitacion = buscarUnaHabitacion(id);
        importeHabitacion = habitacion.getPrecioHabitacion();

        return importeHabitacion;
    }

////métodos para la gestion de cargos
    //método utilizado para recuperar la lista de cargos en un array, para pasarlos al combobox
    public List<Cargo> recuperarCargos() {
        List<Cargo> listaCargos;
        listaCargos = controlPersis.recuperarCargos();
        return listaCargos;
    }

    public void crearCargo(String cargoEmpleado) {
        Cargo cargo = new Cargo();
        cargo.setNombreCargo(cargoEmpleado);

        controlPersis.crearCargo(cargo);
    }

    public Cargo buscarUnCargo(String nombreCargo) {
        Cargo cargo;
        cargo = controlPersis.buscarUnCargo(nombreCargo);
        return cargo;
    }

    //para agregar el usuario admin cuando se carga por primera vez
    public void agregarAdmin() {
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();
        Cargo cargo = new Cargo();

        usuario.setNombreUsuario("admin");
        usuario.setContrasenia("admin");

        cargo = buscarUnCargo("admin");

        empleado.setNombre("admin");
        empleado.setApellido("admin");
        empleado.setUsuario(usuario);
        empleado.setIdCargo(cargo);

        controlPersis.agregarAdmin(empleado);
    }

    //metodo para el logueo del usuario, verifica si existe en la base de datos
    //si no hay ningun usuario, crea el usuario admin, clave admin
    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios;
        listaUsuarios = controlPersis.recuperarUsuarios();

        if (listaUsuarios.isEmpty()) {
            agregarAdmin();

        } else { //si la lista está vacía agrego el usuario admin / clave admin

            for (Usuario usu : listaUsuarios) {
                if (usu.getNombreUsuario().equals(usuario) && usu.getContrasenia().equals(contrasenia)) {
                    return true;
                }

            }
        }
        return false;
    }

}

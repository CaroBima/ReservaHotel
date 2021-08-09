package Logica;

import Persistencia.ControladoraPersistencia;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
        List<Reserva> listaReservas;

        listaReservas = controlPersis.recuperarReservas();

        return listaReservas;
    }

    //recupero una reserva por su id y la devuelvo
    public Reserva buscarUnaReserva(int idReserva) {
        Reserva reser;
        reser = controlPersis.buscarUnaReserva(idReserva);
        return reser;
    }

    //verifica si la habitacion está disponible en la fecha seleccionada y si
    //no lo está devuelve una lista de habitaciones que si lo estan
    public List verificarDisponibilidad(String fechaCheckIn, String fechaCheckOut, int habitacionReserva) {
        List<Reserva> listaReservas;
        List<Habitacion> listaHabDisponibles = new ArrayList();
        Date ingreso;
        Date egreso;

        //recupero la lista de reservas y de habitaciones
        listaReservas = controlPersis.recuperarReservas();
        //listaHabDisponibles = controlPersis.recuperarHabitaciones();

        //convierto los datos en el formato necesario para buscarlos 
        ingreso = parseFecha(fechaCheckIn);
        egreso = parseFecha(fechaCheckOut);

        //recorro la lista de reservas comparando las fechas de ingreso/egreso si las 
        //fechas se superponen quito la habitacion de la lista de habitaciones disponibles
        if (listaReservas != null) {
            Iterator<Reserva> iterador = listaReservas.iterator();
            if (listaReservas != null) {
                while (iterador.hasNext()) {
                    Reserva reser = iterador.next();
                    if ((reser.getFechaCheckOut().after(ingreso)) || reser.getFechaCheckIn().before(egreso)) { //busco las reservas en donde coincida el id de la habitacion
                        if (reser.getIdHabitación().getIdHabitacion() != habitacionReserva) { //compruebo si las fechas no se superponen
                            Habitacion hab = reser.getIdHabitación();
                            listaHabDisponibles.add(hab);
                            System.out.println("agrega hab " + hab.getNombreTematica());
                        }
                    }
                }
            }

        }
        return listaHabDisponibles;
    }

    public List buscarHabitacionesDisponibles(String fCheckin, String fCheckout, String cantidadPersonas) {

        Date checkin = parseFecha(fCheckin);
        Date checkout = parseFecha(fCheckout);
        int cantPers = parseInt(cantidadPersonas);

        List<Habitacion> listaHabitaciones = controlPersis.recuperarHabitaciones();
        List<Reserva> listaReservas = controlPersis.recuperarReservas();
        List<Reserva> listaResxFecha = new ArrayList();

        //recupero la habitacion cuya capacidad coincida con la de huespedes
        Iterator<Habitacion> iterador = listaHabitaciones.iterator();
        if (listaHabitaciones != null) {
            while (iterador.hasNext()) {
                Habitacion hab = iterador.next();
                //verifico de acuerdo al tipo la cantidad de huespedes (en la base de datos guardo single, doble, etc)
                String cantHues = hab.getTipoHab();
                int cantidadH = 0;
                switch (cantHues) {
                    case "Single":
                        cantidadH = 1;
                        break;
                    case "Doble":
                        cantidadH = 2;
                        break;
                    case "Triple":
                        cantidadH = 3;
                        break;
                    case "Multiple":
                        cantidadH = 8;
                        break;
                }

                //Si la cantidad de huéspedes es mayor a la capacidad de la habitacion, borro la habitacion de la lista
                if (cantPers > cantidadH) {
                    iterador.remove();
                }
            }
        }

        //armo una lista de reservas cuyas fechas coincidan con la de checkin y checkout
        Iterator<Reserva> iteradorRes = listaReservas.iterator();

        while (iteradorRes.hasNext()) {
            Reserva res = iteradorRes.next();
            //le doy formato a la fecha para poder compararla con la otra
            String fechaRes = formatearFecha(res.getFechaCheckIn());
            Date fechaR = parseFecha(fechaRes);

            if (!(fechaR.after(checkin) && fechaR.before(checkout))) {
            } else {
                listaResxFecha.add(res);

            }
        }

        //verifico las habitaciones ocupadas que se guardaron de acuerdo a la fecha y las borro   
        Iterator<Reserva> iterRes = listaResxFecha.iterator();
        Iterator<Habitacion> iterHab = listaHabitaciones.iterator();
        //recorro las listas comparando las habitaciones y borrando las habitaciones reservadas de la lista de habitacionees que voy a devolver
        while (iterRes.hasNext()) {
            Reserva res = iterRes.next();
            int idHabRes = res.getIdHabitación().getIdHabitacion();
            while (iterHab.hasNext()) {
                Habitacion hab = iterHab.next();
                int idHab = hab.getIdHabitacion();
                if(idHabRes == idHab){
                    iterHab.remove();
                }
            }
        }

        return listaHabitaciones;
    }

    //permite recuperar las reservas realizadas en una fecha determinada
    public List recuperarReservaXFecha(String fechaCons) {
        List<Reserva> listaReservas;
        //List<Reserva> reservasXFecha = new ArrayList();
        listaReservas = controlPersis.recuperarReservas();

        //convierto la fecha para poder usarla
        Date fechaConsulta = parseFecha(fechaCons);

        //recorro la lista de reservas buscando aquellas cuya fecha coincidan con la buscada
        Iterator<Reserva> iterador = listaReservas.iterator();
        if (listaReservas != null) {
            while (iterador.hasNext()) {
                Reserva res = iterador.next();
                //le doy formato a la fecha para poder compararla con la otra
                String fechaRes = formatearFecha(res.getFechaReserva());
                Date fechaR = parseFecha(fechaRes);
                //Borro de la lista las reservas que no coinciden con la de la fecha buscada
                if (fechaR.compareTo(fechaConsulta) != 0) {
                    iterador.remove();
                }
            }

        }

        return listaReservas;
    }

    //borra una reserva de acuerdo a su id
    public void borrarReserva(int idReserva) {
        controlPersis.borrarReserva(idReserva);
    }

    //Permite buscar las reservas realizadas por un determinado empleado
    public List recuperarReservasxEmpleado(String idEmpleado) {
        List<Reserva> listaReservas;
        int idEmple = parseInt(idEmpleado);

        //traigo la lista de reservas
        listaReservas = controlPersis.recuperarReservas();

        //recorro la lista borrando de la misma las reservas que no sean de ese empleado 
        Iterator<Reserva> iterador = listaReservas.iterator();
        if (listaReservas != null) {
            while (iterador.hasNext()) {
                Reserva res = iterador.next();
                int idEmLista = res.getIdEmpleado().getIdPersona();

                //Borro las reservas que no corresponden a ese empleado
                if (idEmple != idEmLista) {
                    iterador.remove();
                }
            }
        }

        return listaReservas;
    }

    public List recuperarReservasxHuesped(String idHuesped, String fechaDesde, String fechaHasta) {
        List<Reserva> listaReservas;
        List<Reserva> listaReserxHuesped = new ArrayList();
        //convierto los datos que traigo por parametro
        int idHues = parseInt(idHuesped);
        Date fDesde = parseFecha(fechaDesde);
        Date fHasta = parseFecha(fechaHasta);

        //recupero la lista de reservas
        listaReservas = controlPersis.recuperarReservas();

        //recorro la lista borrando de la misma las reservas que no sean de ese huesped 
        Iterator<Reserva> iterador = listaReservas.iterator();
        if (listaReservas != null) {
            while (iterador.hasNext()) {
                Reserva res = iterador.next();
                int idHuespedLista = res.getHuesped().getIdPersona();

                //Borro las reservas que no corresponden a ese huesped
                if (idHues != idHuespedLista) {
                    iterador.remove();
                }
            }
        }

        //filtro la lista por fecha desde y hasta
        Iterator<Reserva> iterador2 = listaReservas.iterator();

        while (iterador2.hasNext()) {
            Reserva res = iterador2.next();
            // Date fCheckIn = res.getFechaCheckIn();
            //le doy formato a la fecha para poder compararla con la otra
            String fechaRes = formatearFecha(res.getFechaCheckIn());
            Date fechaR = parseFecha(fechaRes);

            if (!(fechaR.after(fDesde) && fechaR.before(fHasta))) {
            } else {
                listaReserxHuesped.add(res);
            }
        }

        return listaReserxHuesped;
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

    //devuelve una lista de empleados
    public List recuperarEmpleados() {
        List<Empleado> listaEmpleados;
        listaEmpleados = controlPersis.recuperarEmpleados();

        return listaEmpleados;
    }

//método para convertir el string en formato fecha para poder pasarlo a la controladora de persistencia
    public Date parseFecha(String fechaAParsear) {
        Date fechaParse = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
    public List<Habitacion> buscarHabitacionesDisponibles(Date fCheckIn, Date fCheckOut) {
        List<Habitacion> listaHabDisponibles = new ArrayList();
        List<Reserva> listaReservas;
        //traigo las reservas guardadas
        listaReservas = controlPersis.recuperarReservas();

        //verifico que la lista no este vacía y la recorro
        if (listaReservas != null) {
            for (Reserva reser : listaReservas) {
                //comparo si la fecha de checkin nueva es posterio a la fecha de la reserva 
                //guardada o si la fecha de checkOut nueva es anterior a la fecha de 
                //reserva guardada
                if ((fCheckIn.compareTo(reser.getFechaCheckOut()) >= 0) || (fCheckOut.compareTo(reser.getFechaCheckIn()) <= 0)) {
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

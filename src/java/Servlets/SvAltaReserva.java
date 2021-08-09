//Sv para gestionar el alta de la reserva, validar los datos y guardarlos. En el
//caso de que haya algun error no filtrado por el js avisa para que sea corregido

package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvAltaReserva", urlPatterns = {"/SvAltaReserva"})
public class SvAltaReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //recupero la lista de habitaciones para mostrarla en la tabla
        Controladora control = new Controladora();
        List<Habitacion> listaHabitaciones;
        listaHabitaciones = control.recuperarHabitaciones();
        
        
        
        
        //paso la lista a la sesion
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("listaHabitaciones", listaHabitaciones);
        
        response.sendRedirect("altaReserva.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String fechaCheckIn = request.getParameter("fechaCheckIn");
        String fechaCheckOut = request.getParameter("fechaCheckOut");
        String cantidadPersonas = request.getParameter("cantidadPersonas");
        
         Controladora control = new Controladora();
        List<Habitacion> listaHabitaciones;
        listaHabitaciones = control.buscarHabitacionesDisponibles(fechaCheckIn, fechaCheckOut, cantidadPersonas);
        
        List<Huesped> listaHuespedes = control.recuperarHuespedes();
         
        //paso la lista a la sesion
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("listaHabitaciones", listaHabitaciones);
        misesion.setAttribute("fechaCheckIn", fechaCheckIn);
        misesion.setAttribute("fechaCheckOut", fechaCheckOut);
        misesion.setAttribute("cantidadPersonas", cantidadPersonas);
        misesion.setAttribute("listaHuespedes", listaHuespedes);
        
        response.sendRedirect("altaReserxHab.jsp");
        
        /*
        //traigo los datos del JSP
        String nombreHuesped = request.getParameter("nombreHuesped");
        String apellidoHuesped = request.getParameter("apellidoHuesped");
        String dniHuesped = request.getParameter("dniHuesped");
        String fechaNacHuesped = request.getParameter("fechaNacHuesped");
        String direccionHuesped = request.getParameter("direccionHuesped");
        String profesionHuesped = request.getParameter("profesionHuesped");
        String cantidadPersonas = request.getParameter("cantidadPersonas");
        String habitacionReserva = request.getParameter("habitacionReserva");
        String fechaCheckIn = request.getParameter("fechaCheckIn");
        String fechaCheckOut = request.getParameter("fechaCheckOut");
        String usuario = (String) request.getSession().getAttribute("usuario");

        //traigo la sesion y asigno  los atributos para abrir en cualquier JSP
        request.getSession().setAttribute("nombreHuesped", nombreHuesped);
        request.getSession().setAttribute("apellidoHuesped", apellidoHuesped);
        request.getSession().setAttribute("dniHuesped", dniHuesped);
        request.getSession().setAttribute("fechaNacHuesped", fechaNacHuesped);
        request.getSession().setAttribute("direccionHuesped", direccionHuesped);
        request.getSession().setAttribute("profesionHuesped", profesionHuesped);
        request.getSession().setAttribute("cantidadPersonas", cantidadPersonas);
        request.getSession().setAttribute("habitacionReserva", habitacionReserva);
        request.getSession().setAttribute("fechaCheckIn", fechaCheckIn);
        request.getSession().setAttribute("fechaCheckOut", fechaCheckOut);
        request.getSession().setAttribute("usuario", usuario);

        //verifico si la habitacion está disponible, si no redirecciono para poder cargar la habitacion nuevamente
        Controladora control = new Controladora();
        int habitConsul = parseInt(habitacionReserva);
        List<Habitacion> listaHabDisponibles;
        
        listaHabDisponibles = control.verificarDisponibilidad(fechaCheckIn, fechaCheckOut, habitConsul);
        
        //request.getSession().setAttribute("listaHabDisponibles", listaHabDisponibles);
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaHabDisponibles", listaHabDisponibles);

        control.crearReserva(nombreHuesped, apellidoHuesped, dniHuesped, fechaNacHuesped, direccionHuesped, profesionHuesped, cantidadPersonas, habitacionReserva, fechaCheckIn, fechaCheckOut, usuario);
        response.sendRedirect("altaReserva.jsp");
                    
        //recorro la lista
        /*
        System.out.println("antes de entrar al if");
        
        if (listaHabDisponibles != null &&  listaHabDisponibles.size()>0) {
            int tamanio = listaHabDisponibles.size();
            System.out.println("Entra al if del sv, cant items en la lista " + tamanio);
            for (Habitacion h : listaHabDisponibles) {
                System.out.println("entra al for");
                if (habitConsul == h.getIdHabitacion()) {
                    //si la habitacion está disponible guardo la reserva
                    System.out.println("habitacion disponible");
                    control.crearReserva(nombreHuesped, apellidoHuesped, dniHuesped, fechaNacHuesped, direccionHuesped, profesionHuesped, cantidadPersonas, habitacionReserva, fechaCheckIn, fechaCheckOut, usuario);

                    //redirecciono a la página de confirmacion
                    response.sendRedirect("confirmacionReserva.jsp");
                    break;
                    
                } else {
                    System.out.println("habitacion no disponible");
                    //si la pagina no esta disponible cargo la lista en la sesion y redirijo 
                    //para poder cambiar la habitacion o la fecha

                    //paso la lista a la sesion y redirijo a la pagina para poder cambiar la hab
                    request.getSession().setAttribute("listaHabDisponibles", listaHabDisponibles);
                    HttpSession misesion = request.getSession();
                    misesion.setAttribute("listaHabDisponibles", listaHabDisponibles);
                    
                    response.sendRedirect("altaReserxHab.jsp");
                }
            }
        }
        */
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    //Para convertir las fechas
    public Date parseFecha(String fecha) {
        Date fechaNac = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fechaNac = formato.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaNac;
    }

}

//permite realizar la modificacion de los datos de una habitacion, guarda los datos modificados

package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvModifHabitacion", urlPatterns = {"/SvModifHabitacion"})
public class SvModifHabitacion extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
     
    }


        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //recupero los datos para pasar las modificaciones a la controladora
        int idHab = parseInt(request.getParameter("idHabitacion"));
        String tipoHabitacion = request.getParameter("tipoHabitacion");
        String nombreTematico = request.getParameter("nombreTematico");
        Double precioHabitacion = parseDouble(request.getParameter("precioHabitacion"));
        int pisoHabitacion = parseInt(request.getParameter("pisoHabitacion"));
        int nroHabitacion = parseInt(request.getParameter("nroHabitacion"));
        
        //creo la habitacion para pasarla por parametros a la controladora
        Habitacion habitacion = new Habitacion();
        
        habitacion.setIdHabitacion(idHab);
        habitacion.setTipoHab(tipoHabitacion);
        habitacion.setNombreTematica(nombreTematico);
        habitacion.setPiso(pisoHabitacion);
        habitacion.setNroHabitacion(nroHabitacion);
        habitacion.setPrecioHabitacion(precioHabitacion);
        
       Controladora control = new Controladora();
       
       //modifico la habitacion
       control.modificarHabitacion(habitacion);
       
       request.getSession().setAttribute("listaHabitaciones", control.recuperarHabitaciones());
       response.sendRedirect("edicionHabitacion.jsp");
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //obtengo el numero de habitacion
        int idHabitacion = parseInt(request.getParameter("idHabitacion"));
        
        
        //recupero la habitación a modificar buscándola por el id
        Controladora control = new Controladora();
        Habitacion habitacion = new Habitacion();
        habitacion = control.buscarUnaHabitacion(idHabitacion);
        
        //importo la sesion y le agrego la habitacion que trajo la controladora
        HttpSession misesion = request.getSession();
        misesion.setAttribute("habitacion", habitacion);
        
        //redirecciono al jsp para modificar la habitacion
        response.sendRedirect("modificarHabitacion.jsp");
        
    }

 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}

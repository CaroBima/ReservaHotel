

package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
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
        response.setContentType("text/html;charset=UTF-8");
        
        
     
    }


        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
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

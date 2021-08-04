
package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvModificarHabitacion", urlPatterns = {"/SvModificarHabitacion"})
public class SvEdicionHabitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Controladora control = new Controladora();
        List<Habitacion> listaHabitaciones = control.recuperarHabitaciones();
        
        HttpSession misesion = request.getSession();
        
        misesion.setAttribute("listaHabitaciones", listaHabitaciones);
        
        response.sendRedirect("edicionHabitacion.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

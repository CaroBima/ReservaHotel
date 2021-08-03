
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarHabitacion", urlPatterns = {"/SvEliminarHabitacion"})
public class SvEliminarHabitacion extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
       int idHabitacion = parseInt(request.getParameter("idHab"));
        
       Controladora control = new Controladora();
       control.borrarHabitacion(idHabitacion);
       
       request.getSession().setAttribute("listaHabitaciones", control.recuperarHabitaciones());
       response.sendRedirect("modificarHabitacion.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

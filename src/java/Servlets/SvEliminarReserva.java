//permite eliminar una reserva

package Servlets;

import Logica.Controladora;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarReserva", urlPatterns = {"/SvEliminarReserva"})
public class SvEliminarReserva extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        int idReserva = parseInt(request.getParameter("idReserva"));
        
        Controladora control = new Controladora();
        control.borrarReserva(idReserva);
        
        request.getSession().setAttribute("listaReservas", control.recuperarReservas());
        response.sendRedirect("edicionReservas.jsp");
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

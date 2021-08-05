/*
Permite editar una reserva seleccionada en modificarReserva
 */
package Servlets;

import Logica.Controladora;
import Logica.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(name = "SvEditarReserva", urlPatterns = {"/SvEditarReserva"})
public class SvEditarReserva extends HttpServlet {

 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Controladora control = new Controladora();
        List<Reserva> listaReservas = control.recuperarReservas();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("edicionReservas.jsp");
        
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

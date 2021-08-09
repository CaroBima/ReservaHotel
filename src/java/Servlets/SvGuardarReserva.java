

package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvGuardarReserva", urlPatterns = {"/SvGuardarReserva"})
public class SvGuardarReserva extends HttpServlet {

 
    
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
        
        //String fCheckin = request.getParameter("fCheckIn");
        //String fCheckout = request.getParameter("fCheckOut");
        //String cantPersonas = request.getParameter("cantPers");
        String habitacionReserva = request.getParameter("habitacionReserva");
        String huesped = request.getParameter("seleccionHuesped");
        String usuario = (String) request.getSession().getAttribute("usuario");
        
        
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("habitacionReserva", habitacionReserva);
        String fChekIn = (String) misesion.getAttribute("fechaCheckIn");
        String fChekOut = (String) misesion.getAttribute("fechaCheckOut");
        String cantPers = (String) misesion.getAttribute("cantidadPersonas");
        
        Controladora control = new Controladora();
        
     
        
        control.crearReserva(huesped, cantPers, habitacionReserva, fChekIn, fChekOut, usuario);
        
        
        response.sendRedirect("confirmacionReserva.jsp");
        
        
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

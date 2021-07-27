package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvAltaReserva", urlPatterns = {"/SvAltaReserva"})
public class SvAltaReserva extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
  
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        //traigo los datos del JSP
        String nombreHuesped = request.getParameter("nombreHuesped");
        String apellidoHuesped = request.getParameter("apellidoHuesped");
        String dniHuesped = request.getParameter("dniHuesped");
        String fechaNacHuesped = request.getParameter("fechaNacHuesped");
        String direccionHuesped = request.getParameter("direccionHuesped");
        String profesionHuesped = request.getParameter("profesionHuesped");
        String cantidadPersonas = request.getParameter("cantidadPersonas"); //(castear)
        String habitacionReserva = request.getParameter("habitacionReserva");
        String fechaCheckIn = request.getParameter("fechaCheckIn");
        String fechaCheckOut = request.getParameter("fechaChekOut");
        String importeTotalReserva = request.getParameter("importeTotalReserva");
        

        
        
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
        request.getSession().setAttribute("importeTotalReserva", importeTotalReserva);
        
        Controladora control = new Controladora();
       
        control.crearReserva(nombreHuesped, apellidoHuesped, dniHuesped, fechaNacHuesped,  direccionHuesped, profesionHuesped, cantidadPersonas, habitacionReserva, fechaCheckIn,  fechaCheckOut, importeTotalReserva);
        
        
         
}

@Override
public String getServletInfo() {
        return "Short description";
    }

}


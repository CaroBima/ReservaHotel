

package Servlets;

import Logica.Controladora;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvConsResxHuesped", urlPatterns = {"/SvConsResxHuesped"})
public class SvConsResxHuesped extends HttpServlet {

 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
         //recupero la lista de habitaciones para mostrarla en la tabla
        Controladora control = new Controladora();
        List<Huesped> listaHuespedes;
        listaHuespedes = control.recuperarHuespedes();
        
        
         //recupero la lista de habitaciones para mostrarla en la tabla
        List<Reserva> listaReservas;
        listaReservas = control.recuperarReservas();
        
       
        
        
        
        //paso la lista a la sesion
        HttpSession sesion = request.getSession();
       
        sesion.setAttribute("listaReservas", listaReservas);
        sesion.setAttribute("listaHuespedes", listaHuespedes);
        
        response.sendRedirect("consultaResxHuesped.jsp");
        
    }
    


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String idHuesped = request.getParameter("CboHuesped");
        String fechaDesde = request.getParameter("fechaDesde");
        String fechaHasta = request.getParameter("fechaHasta");
        
        System.out.println("desde " + fechaDesde);
        System.out.println("hasta " + fechaHasta);
        
        Controladora control = new Controladora();
        List<Reserva> listaReservas;
        
        listaReservas = control.recuperarReservasxHuesped(idHuesped, fechaDesde, fechaHasta);
        
         HttpSession sesion = request.getSession();
       
        sesion.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("consultaResxHuesped.jsp");
        
    }

 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    

}

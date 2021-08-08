

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



@WebServlet(name = "SvConsultaReservaxDia", urlPatterns = {"/SvConsultaReservaxDia"})
public class SvConsultaReservaxDia extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //recupero la lista de habitaciones para mostrarla en la tabla
        Controladora control = new Controladora();
        List<Reserva> listaReservas;
        listaReservas = control.recuperarReservas();
        
        
        
        
        //paso la lista a la sesion
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("consultaReservaXdia.jsp");
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
   
        //recupero la fecha para buscar en la base de datos
        
        String fechaBusqueda = request.getParameter("fechaReserva");
        
        Controladora control = new Controladora();
        List<Reserva> listaReservas;
        listaReservas = control.recuperarReservaXFecha(fechaBusqueda);
        
       
        
        HttpSession sesion = request.getSession();
        
        sesion.setAttribute("listaReservas", listaReservas);
        
        response.sendRedirect("consultaReservaXdia.jsp");
        
        
               
    
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

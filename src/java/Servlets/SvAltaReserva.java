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

@WebServlet(name = "SvAltaReserva", urlPatterns = {"/SvAltaReserva"})
public class SvAltaReserva extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
             //traigo las habitaciones disponibles para poder pasarlas al combobox de habitaciones del altaReserva.jps
            
            
            List<Habitacion> listaHab = llenarListaHabitaciones();
            System.out.println("entra al servlet"); //no entra al servlet tampoco
            if (listaHab != null){
                System.out.println("Entra al if del servlet");  
                //no entra, llenarhabitaciones no devuelve nada
            }
           
            request.setAttribute("listaHab", listaHab );
            
            request.getRequestDispatcher("/altaReserva.jsp").forward(request, response);
            
        }
    
    private List<Habitacion> llenarListaHabitaciones(){
           
        Controladora control = new Controladora();
        List<Habitacion> listaHabitacion;
        listaHabitacion = control.recuperarHabitacion();
        System.out.println("llega a llenar habitaciones");
        return listaHabitacion;
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


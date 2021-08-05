//permite cargar los datos para el jsp de edicionReservas (recupera los datos de las reservas
// y los pasa a la sesion para mostrarlos en edicionReservas

package Servlets;

import Logica.Controladora;
import Logica.Reserva;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvModificarReserva", urlPatterns = {"/SvModificarReserva"})
public class SvModificarReserva extends HttpServlet {

 
    
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
       
          //recupero el valor del id de la reserva a modificar
        int idReserva = parseInt(request.getParameter("idReserva"));
        Controladora control = new Controladora();
        
        System.out.println(idReserva);
        
        //busco la reserva por su id y la traigo
        Reserva reservaMod = control.buscarUnaReserva(idReserva);
        
        //le doy formato a las fechas para pasarlos
        String fNacimiento = control.formatearFecha(reservaMod.getHuesped().getFechaNac());
        String fChechIn = control.formatearFecha(reservaMod.getFechaCheckIn());
        String fCheckOut = control.formatearFecha(reservaMod.getFechaCheckOut());
        
        //paso los valores de la reserva a la sesion 
        HttpSession misesion = request.getSession();
        misesion.setAttribute("fNacimiento", fNacimiento);
        misesion.setAttribute("fChechIn", fChechIn); 
        misesion.setAttribute("fCheckOut", fCheckOut);
        misesion.setAttribute("reservaMod", reservaMod);
        
        
        
        
        
        //redirecciono al jsp para modificar la habitacion
        response.sendRedirect("modificarReserva.jsp");
       
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

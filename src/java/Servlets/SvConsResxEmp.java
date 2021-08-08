

package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvConsResxEmp", urlPatterns = {"/SvConsResxEmp"})
public class SvConsResxEmp extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       //recupero la lista de habitaciones para mostrarla en la tabla
        Controladora control = new Controladora();
        List<Empleado> listaEmpleados;
        listaEmpleados = control.recuperarEmpleados();
        
        
         //recupero la lista de habitaciones para mostrarla en la tabla
        List<Reserva> listaReservas;
        listaReservas = control.recuperarReservas();
        
        
        
        
        //paso la lista a la sesion
        HttpSession sesion = request.getSession();
       
        sesion.setAttribute("listaReservas", listaReservas);
        sesion.setAttribute("listaEmpleados", listaEmpleados);
        
        response.sendRedirect("consResxEmp.jsp");
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //recupero el id de empleado del jsp
        String idEmpleado = request.getParameter("CboEmpleado");
        
        System.out.println("idEmple" + idEmpleado);
        
        //busco las reservas que haya cargado a ese empleado
        Controladora control = new Controladora();
        List<Reserva> listaReservas;
       
        listaReservas= control.recuperarReservasxEmpleado(idEmpleado);

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listaReservas", listaReservas);

        response.sendRedirect("consResxEmp.jsp");
        
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

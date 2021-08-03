
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caro
 */
@WebServlet(name = "SvAltaHabitacion", urlPatterns = {"/SvAltaHabitacion"})
public class SvAltaHabitacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
   
       //traigo los datos del JSP
        String nombreTematico = request.getParameter("nombreTematico");
        int nroHabitacion = parseInt(request.getParameter("nroHabitacion"));
        int pisoHabitacion = parseInt( request.getParameter("pisoHabitacion"));
        String tipoHabitacion = request.getParameter("tipoHabitacion");
        double precioHabitacion = parseDouble(request.getParameter("precioHabitacion"));
        
        //traigo la sesion y asigno  los atributos para abrir en cualquier JSP
        request.getSession().setAttribute("nombreTematico", nombreTematico);
        request.getSession().setAttribute("nroHabitacion", nroHabitacion);
        request.getSession().setAttribute("pisoHabitacion", pisoHabitacion);
        request.getSession().setAttribute("tipoHabitacion", tipoHabitacion); //single, doble, etc
        request.getSession().setAttribute("precioHabitacion", precioHabitacion);
        
        
        
        Controladora control = new Controladora();
       
        
        control.crearHabitación(nombreTematico, nroHabitacion, pisoHabitacion, tipoHabitacion, precioHabitacion);
      
        
         //redirecciono a la página de confirmacion
        response.sendRedirect("confirmacionAltaHabitacion.jsp");
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

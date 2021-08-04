package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvAltaEmpleado", urlPatterns = {"/SvAltaEmpleado"})
public class SvAltaEmpleado extends HttpServlet {

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

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //traigo los datos del JSP
        String usuarioEmpleado = request.getParameter("usuarioEmpleado");
        String contraseniaEmpleado = request.getParameter("contraseniaEmpleado");
        String nombreEmpleado = request.getParameter("nombreEmpleado");
        String apellidoEmpleado = request.getParameter("apellidoEmpleado");
        String dniEmpleado = request.getParameter("dniEmpleado");
        String direccionEmpleado = request.getParameter("direccionEmpleado");
        String fechaNacEmpleado = request.getParameter("fechaNacEmpleado");  //ver como hacer con date
        String cargoEmpleado = request.getParameter("cargoEmpleado");
        
        

        //traigo la sesion y asigno  los atributos para abrir en cualquier JSP
        request.getSession().setAttribute("usuarioEmpleado", usuarioEmpleado);
        request.getSession().setAttribute("contraseniaEmpleado", contraseniaEmpleado);
        request.getSession().setAttribute("nombreEmpleado", nombreEmpleado);
        request.getSession().setAttribute("apellidoEmpleado", apellidoEmpleado);
        request.getSession().setAttribute("dniEmpleado", dniEmpleado);
        request.getSession().setAttribute("direccionEmpleado", direccionEmpleado);
        request.getSession().setAttribute("fechaNacEmpleado", fechaNacEmpleado);
        request.getSession().setAttribute("cargoEmpleado", cargoEmpleado);
        
        Controladora control = new Controladora();
        
        
        //paso los datos a la lógica
        control.crearEmpleado(usuarioEmpleado, contraseniaEmpleado, nombreEmpleado, apellidoEmpleado, dniEmpleado, direccionEmpleado, fechaNacEmpleado, cargoEmpleado);
        
        
        //redirecciono a la página de confirmacion
        response.sendRedirect("confirmAltaEmpleado.jsp");
    }

  
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

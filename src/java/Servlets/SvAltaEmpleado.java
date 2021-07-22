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
        String usuarioEmpleado = request.getParameter("usuarioEmpleado");
        String contraseniaEmpleado = request.getParameter("contraseniaEmpleado");
        String nombreEmpleado = request.getParameter("nombreEmpleado");
        String apellidoEmpleado = request.getParameter("apellidoEmpleado");
        String dniEmpleado = request.getParameter("dniEmpleado");
        String direccionEmpleado = request.getParameter("direccionEmpleado");
        String fechaNacEmpleado = request.getParameter("fechaNacEmpleado");  //ver como hacer con date
        String cargoEmpleado = request.getParameter("cargoEmpleado");
       
       
        
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
//        Date fechaNacimiento = new Date();
//        
//        try {
//            Date fechaNacimiento = formato.parse(fechaNacEmpleado);
//        } catch (ParseException ex) {
//            Logger.getLogger(SvAltaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
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
       
        control.crearEmpleado(usuarioEmpleado, contraseniaEmpleado, nombreEmpleado, apellidoEmpleado, dniEmpleado, direccionEmpleado, fechaNacEmpleado, cargoEmpleado);
        //llega ok
        System.out.println(usuarioEmpleado + " " +contraseniaEmpleado + " " +nombreEmpleado + " " + apellidoEmpleado + " " + dniEmpleado + " " + direccionEmpleado + " " + fechaNacEmpleado + " " + cargoEmpleado);
        
    //armo la respuesta
        //response.sendRedirect("confirmacion.jsp");
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

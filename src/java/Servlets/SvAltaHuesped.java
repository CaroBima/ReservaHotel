

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "SvAltaHuesped", urlPatterns = {"/SvAltaHuesped"})
public class SvAltaHuesped extends HttpServlet {

   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        response.sendRedirect("nuevoHuesped.jsp");
    }

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String nombreHuesped = request.getParameter("nombreHuesped");
        String apellidoHuesped = request.getParameter("apellidoHuesped");
        String dniHuesped = request.getParameter("dniHuesped");
        String fechaNacHuesped = request.getParameter("fechaNacHuesped");
        String direccionHuesped = request.getParameter("direccionHuesped");
        String profesionHuesped = request.getParameter("profesionHuesped");
        
         //traigo la sesion y asigno  los atributos para abrir en cualquier JSP
        request.getSession().setAttribute("nombreHuesped", nombreHuesped);
        request.getSession().setAttribute("apellidoHuesped", apellidoHuesped);
        request.getSession().setAttribute("dniHuesped", dniHuesped);
        request.getSession().setAttribute("fechaNacHuesped", fechaNacHuesped);
        request.getSession().setAttribute("direccionHuesped", direccionHuesped);
        request.getSession().setAttribute("profesionHuesped", profesionHuesped);
        
        
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

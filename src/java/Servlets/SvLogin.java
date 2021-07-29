

package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {


    
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
        String usuario = request.getParameter("nombreUsuario");
        String contrasenia = request.getParameter("contraUsuario");
        
        Controladora control = new Controladora();
        
        boolean autorizado = control.verificarUsuario(usuario, contrasenia);
        
        if(autorizado == true){
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("usuario", usuario);
            misesion.setAttribute("contrasenia", contrasenia);
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("login.jsp");
        }
    }

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

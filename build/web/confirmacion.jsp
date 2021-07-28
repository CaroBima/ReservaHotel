<%-- 
    Document   : confirmacion
    Created on : 19 jul. 2021, 19:10:10
    Author     : Caro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        HttpSession sesion = request.getSession();
        String loginusuario = (String) sesion.getAttribute("usuario");
        
        //verifico si el usuario admin esta creado y si no lo agrego
            if(loginusuario == null){
                response.sendRedirect("login.jsp");
            }else{
               
        %>
        <form>
            <h1>Cargo guardado correctamente!</h1>
            <input type="submit" name="btnNuevoCargo" value="Cerrar" onclick='window.close()'> 
        </form>
        
        
        <%
            }
        %>
    </body>
</html>

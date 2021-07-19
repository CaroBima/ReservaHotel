<%-- 
    Document   : altaCargo
    Created on : 18 jul. 2021, 22:52:47
    Author     : Caro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Alta de Cargo</title>
    </head>
    <body>
        <form action="SvAltaCargo" method="POST">
            <h1>Alta de nuevo cargo</h1>
            <p>
                   <label for = "cargoEmpleado" >Cargo:</label> 
                   <input type="text" name="cargoEmpleado">
            </p>
           
            <p>
                <input type="submit" name="btnGuardar" value="Guardar"> 
            </p>
        </form>
    </body>
</html>

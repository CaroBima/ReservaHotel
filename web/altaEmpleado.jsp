<%-- 
  Formulario de alta de un nuevo empleado
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Cargo"%>
<%@page import="Logica.Controladora"%>
<%@page import ="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/scripts.js"></script>
        <title>Alta de Nuevo Empleado</title>
    </head>
    <body>
        <form name="formAltaEmple" action="SvAltaEmpleado" method="POST">
            <h1>Alta de empleado</h1>
            <br>
            
                <p>
                   <label for = "usuarioEmpleado" >Nombre de usuario:</label> 
                   <input type="text" name="usuarioEmpleado">
                </p>
            
                <p>
                    <label for = "contraseniaEmpleado" >Contraseña:</label> 
                    <input type="password" name="contraseniaEmpleado">
                </p>
            
            
                <p>
                    <label for = "nombreEmpleado" >Nombre:</label> 
                    <input type="text" name="nombreEmpleado">
                </p>
            
                <p>
                   <label for = "apellidoEmpleado" >Apellido:</label> 
                   <input type="text" name="apellidoEmpleado">
                </p>
            
                <p>  
                    <label for = "dniEmpleado" >Dni: </label>
                    <input type="text" name="dniEmpleado">
                </p>
            
                <p>
                    <label for = "direccionEmpleado" >Dirección: </label>
                    <input type="text" name="direccionEmpleado">
                </p>
                
                <p>
                    <label for = "fechaNacEmpleado" >Fecha de nacimiento: </label>
                    <input type="date" name="fechaNacEmpleado" >
                </p>
                
                <p>
                    <label for = "cargoEmpleado" >Cargo: </label>
                     <select name ="cargoEmpleado">
                         <option value="-">-</option>
                        <%
                            //Cargo los valores de la tabla de cargos en el combobox
                            Controladora control = new Controladora();
                            List<Cargo> listaCargos = new ArrayList();
                            Cargo cargo = new Cargo();
                            listaCargos = control.recuperarCargos();
                            for (int i = 0; i < listaCargos.size(); i++) {
                                cargo = listaCargos.get(i);
                                out.println("<option value=\"" + cargo.getNombreCargo() + "\"" + ">" + cargo.getNombreCargo() + "</option>");
                            }
                        %>
                      </select>
                      <input type="button" name="btnNuevoCargo" value="+" onclick='ingresoCargo()'> 
                        
                </p>
            <br>
            <p>
                <input type="submit" name="btnGuardar" value="Guardar"> 
              
            </p>
            
            
        </form>
        
    </body>
</html>

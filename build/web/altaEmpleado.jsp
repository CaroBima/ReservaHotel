<%-- 
  Formulario de alta de un nuevo empleado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Alta de Nuevo Empleado</title>
    </head>
    <body>
        <form>
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
                    <input type="date" name="fechaNacEmpleado">
                </p>
                
                <p>
                    <label for = "cargoEmpleado" >Cargo: </label>
                     <select name ="cargoEmpleado">
                        <option value="-" selected>-</option>
                        <option value="Recepcionista">Recepcionista</option>
                        <option value="Concerje">Concerje</option>
                        <option value="Gobernante">Gobernante</option>
                        <option value="Camarero de Piso">Camarero/a de piso</option>
                        <option value="Mozo">Mozo/a</option>
                        <option value="Personal de cocina">Personal de cocina</option>
                        <option value="Seguridad">Seguridad</option>
                        <option value="Mantenimiento">Mantenimiento</option>
                        <option value="Gerencia">Gerencia</option>
                      </select>
                </p>
            <br>
            <input type="submit" name="btnGuardar" value="Guardar"> 
            
        </form>
        
    </body>
</html>

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
            
            <p>Nombre de usuario:<input type="text" name="usuarioEmpleado"></p>
            <p>Contraseña:<input type="password" name="contraseniaEmpleado"></p>
            <p>Nombre: <input type="text" name="nombreEmpleado"></p>
            <p>Apellido: <input type="text" name="apellidoEmpleado"></p>
            <p>Dni: <input type="text" name="dniEmpleado"></p>
            <p>Dirección: <input type="text" name="direccionEmpleado"></p>
            <p>Fecha de naciemiento: <input type="date" name="fechaNacEmpleado"></p>
            <p>Cargo: <select name ="cargoEmpleado">
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
            
            
            
            <input type="submit" value="Enviar"> 
            
            
        </form>
        
    </body>
</html>

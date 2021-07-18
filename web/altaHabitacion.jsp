<%-- 
    Alta de una habitación
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <title>Alta de habitación</title>
    </head>
    <body>
        <form>
            <h1>Nueva habitación</h1>
            <br>
            
            <p>Nombre: <input type="text" name="nombre"></p>
            <br>
            
            <p>Temática: <input type="text" name="nombre"></p>
            <br>
            
            <p>Tipo:<input type="radio" name="TipoHabitacion" value="Single">Single
                    <input type="radio" name="TipoHabitacion" value="Doble">Doble
                    <input type="radio" name="TipoHabitacion" value="Triple">Triple
                    <input type="radio" name="TipoHabitacion" value="Multiple">Múltiple (8 pers. Máx.)
            </p>
            <br>

            <p>Piso: <select name="pisoHabitacion">
                        <option value="0" selected>-</option>
                        <option value="1">1º Piso</option>
                        <option value="2">2º Piso</option>
                        <option value="3">3º Piso</option>
                        <option value="4">4º Piso</option>
                        <option value="5">5º Piso</option>
                        <option value="6">6º Piso</option>
                        <option value="7">7º Piso</option>
                        <option value="8">8º Piso</option>
            </p>
            <br>
            

            </p>
            <br>
            
            <input type="submit" value="Enviar"> 
            
        </form>
        
    </body>
</html>

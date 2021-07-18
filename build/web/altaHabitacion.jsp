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
        <form action="SvAltaHabitacion" method="POST">
            <h1>Nueva habitación</h1>
            <br>
            
            <p>Nombre temático: <input type="text" name="nombreTematico"></p>
            <br>
            
            <p>Número de Habitación: <select name ="nroHabitacion">
                        <option value="0" selected>-</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        </select>
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
                        </select>
            </p>
            <br>
            
            <p>Tipo:<input type="radio" name="tipoHabitacion" value="Single">Single
                    <input type="radio" name="tipoHabitacion" value="Doble">Doble
                    <input type="radio" name="tipoHabitacion" value="Triple">Triple
                    <input type="radio" name="tipoHabitacion" value="Multiple">Múltiple (8 pers. Máx.)
            </p>
            <br>
             
            <p>Precio: <input type="text" name="precioHabitacion"></p>
            <br>
            
            <input type="submit" value="Enviar"> 
            
        </form>
        
    </body>
</html>

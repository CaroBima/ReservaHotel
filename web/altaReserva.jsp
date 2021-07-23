<%-- 
    Document   : altaReserva
    Created on : 22 jul. 2021, 20:58:35
    Author     : Caro
--%>

<%@page import="Logica.Habitacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Cargo"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/scripts.js"></script>
        <title>Nueva reserva</title>
    </head>
    <body>
       <body>
        <form name="formAltaReserva" action="SvAltaReserva" method="POST">
            <h1>Nueva Reserva</h1>
            <br>
            
                <!-- Seleccion de habitación que se va a reservar -->
                <p>
                   <label for = "habitacionReserva" >Habitación:</label> 
                   <select name ="habitacionReserva">
                         <option value="-" selected>-</option>
                          <%
                            //Cargo los valores de la tabla de habitaciones en el combobox
                            Controladora control = new Controladora();
                            List<Habitacion> listaHabitacion = new ArrayList();
                            Habitacion habitacion = new Habitacion();
                            listaHabitacion = control.recuperarHabitacion();
                            for (int i = 0; i < listaHabitacion.size(); i++) {
                                habitacion = listaHabitacion.get(i);
                                out.println("<option value=\"" + habitacion.getNombreTematica() + "\" " + ">" + habitacion.getTipoHab() + "</option>");
                            }
                        %>
                   </select>
                    <!-- Permite agregar una nueva habitacion sin salir de la pantalla de alta de reserva -->
                   <input type="button" name="btnNuevaHabitacion" value="+" onclick='ingresoHabitacion()'> 
                </p>
                      
                 <!<!-- Fecha de chek in -->
                 <p>
                    <label for = "fechaCheckIn" >Fecha de Check-In: </label>
                    <input type="date" name="fechaCheckIn">
                </p>
                <!<!-- Fecha de chek out -->
                <p>
                    <label for = "fechaCheckOut" >Fecha de Check-Out: </label>
                    <input type="date" name="fechaCheckOut">
                </p>
                <p>
                    <label for = "cargoEmpleado" >Cargo: </label>
                     <select name ="cargoEmpleado">
                         <option value="-" selected>-</option>
                        
                      </select>
                      <input type="button" name="btnNuevoCargo" value="+" onclick='ingresoCargo()'> 
                     
                <p>
                    <label for = "habitacionReserva" >Habitación:</label> 
                    <input type="text" name="habitacionReserva">
                </p>
                        
                </p>
            <br>
            <p>
                <input type="submit" name="btnGuardar" value="Guardar"> 
              
            </p>
            
            
        </form>
    </body>
</html>

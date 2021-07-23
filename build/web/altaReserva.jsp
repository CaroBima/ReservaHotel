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
            <!-- Ingreso de datos del huesped -->
                <!-- Ingreso del dni del huesped -->
            <p>
                <label for = "dniHuesped" >Número de dni: </label>
                <input type="text" name="dniHuesped">
            </p>
            
                <!-- Ingreso de nombre del huesped -->
            <p>
                <label for = "nombreHuesped" >Nombre: </label>
                <input type="text" name="nombreHuesped">
            </p>
            
                <!-- Ingreso del apellido -->
            <p>
                <label for = "apellidoHuesped" >Apellido: </label>
                <input type="text" name="apellidoHuesped">
            
            </p>
            
                <!-- Fecha de nacimiento del huesped -->
            <p>
                <label for = "fechaNacHuesped" >Fecha de nacimiento: </label>
                <input type="date" name="fechaNacHuesped">
            </p>
            
                <!-- ingreso de dirección -->
            <p>
                <label for = "direccionHuesped" >Dirección: </label>
                <input type="text" name="direccionHuesped">
            </p>
            
                <!-- Ingreso de Profesion -->
            <p>
                <label for = "profesionHuesped" >Profesión: </label>
                <input type="text" name="profesionHuesped">
            </p>
            
                 <!-- Ingreso de Cantidad de personas -->
            <p>
                <label for = "cantidadPersonas" >Cantidad de personas:</label> 
                    <select name ="cantidadPersonas">
                        <option value="-" selected>-</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                    </select>
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

            <!-- Seleccion de habitación que se va a reservar -->
            <p>
               <label for = "habitacionReserva" >Habitaciones disponibles:</label> 
               <select name ="habitacionReserva">
                     <option value="-" selected>-</option>
                      <%
                        //Cargo los valores de la tabla de habitaciones en el select
                        Controladora control = new Controladora();
                        List<Habitacion> listaHabitacion = new ArrayList();
                        Habitacion habitacion = new Habitacion();
                        listaHabitacion = control.recuperarHabitacion();
                        for (int i = 0; i < listaHabitacion.size(); i++) {
                            habitacion = listaHabitacion.get(i);
                            out.println("<option value=\"" + habitacion.getNombreTematica() + "\" " + ">" +  habitacion.getNombreTematica() + " - " + habitacion.getTipoHab() + " - $" + habitacion.getPrecioHabitacion() + "</option>");
                        }
                    %>
               </select>
            </p>
            <p>
                <label for = "importeTotalReserva" >Importe total: </label>
                <input type="text" name="importeTotalReserva" value= "$0.0" disabled>
            </p>
            <br>
            <p>
                <input type="submit" name="btnGuardar" value="Guardar"> 
            </p>
        </form>
    </body>
</html>

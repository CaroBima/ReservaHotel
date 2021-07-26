<%-- 
    Document   : altaReserva
    Created on : 22 jul. 2021, 20:58:35
    Author     : Caro
--%>

<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="assets/hotel.svg" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Nueva reserva</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet" />

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <!--<link rel="stylesheet" href="css/style.css">-->
        <script src="js/scripts.js"></script>
        <title>Nueva reserva</title>
    </head>
    <body>

        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">Hotel</span>
                <span class="site-heading-lower">Integrador</span>
            </h1>
        </header>

        <!-- Menú de navegacion-->
        <nav class="navbar navbar-expand-lg navbar-dark py-lg-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Principal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                    <ul class="navbar-nav">

                        <!-- Menú de reservas-->
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Reservas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaReserva.jsp">Nueva Reserva</a></li>
                                <li><a class="dropdown-item" href="#">Consultar</a></li>
                                <li><a class="dropdown-item" href="#">Modificar</a></li>
                            </ul>
                        </li>

                        <!-- Menú de Habitaciones-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Habitaciones
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaHabitacion.jsp">Nueva Habitación</a></li>
                                <li><a class="dropdown-item" href="#">Consultar habitación</a></li>
                                <li><a class="dropdown-item" href="#">Modificar habitación </a></li>
                            </ul>
                        </li>
                        <!-- Menú de Empleado-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Empleados
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaEmpleado.jsp">Alta</a></li>
                                <li><a class="dropdown-item" href="#">Consultar</a></li>
                                <li><a class="dropdown-item" href="#">Modificar</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <section class="page-section cta">
            <div class="container">
                <div class="row">
                    <div class="col-xl-9 mx-auto">
                        <div class="cta-inner bg-faded text-center rounded">
                            <h2 class="section-heading mb-4">
                                <!--<span class="section-heading-upper">Nueva Reserva</span>-->
                                <span class="section-heading-lower">Nueva Reserva</span>
                            </h2>

                            <!-- Formulario de reserva -->
                            <form name="formAltaReserva"  class="border p-3 form" action="SvAltaReserva" method="POST">

                                <!-- Ingreso de datos del huesped -->
                                <!-- Ingreso del dni del huesped -->

                                <p class="mb-3">
                                    <label for = "dniHuesped" class="form-label" >Número de dni: </label>
                                    <input type="text" name="dniHuesped">
                                </p>

                                <!-- Ingreso de nombre del huesped -->

                                <p class="mb-3">
                                    <label for = "nombreHuesped" class="form-label" >Nombre: </label>
                                    <input type="text" name="nombreHuesped">
                                </p>

                                <!-- Ingreso del apellido -->
                                <p class="mb-3">
                                    <label for = "apellidoHuesped" >Apellido: </label>
                                    <input type="text" name="apellidoHuesped">

                                </p>

                                <!-- Fecha de nacimiento del huesped -->
                                <p class="mb-3">
                                    <label for = "fechaNacHuesped" >Fecha de nacimiento: </label>
                                    <input type="date" name="fechaNacHuesped">
                                </p>

                                <!-- ingreso de dirección -->
                                <p class="mb-3">
                                    <label for = "direccionHuesped" >Dirección: </label>
                                    <input type="text" name="direccionHuesped">
                                </p>

                                <!-- Ingreso de Profesion -->
                                <p class="mb-3">
                                    <label for = "profesionHuesped" >Profesión: </label>
                                    <input type="text" name="profesionHuesped">
                                </p>

                                <!-- Ingreso de Cantidad de personas -->
                                <p class="mb-3">
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
                                <p class="mb-3">
                                    <label for = "fechaCheckIn" >Fecha de Check-In: </label>
                                    <input type="date" name="fechaCheckIn">
                                </p>

                                <!<!-- Fecha de chek out -->
                                <p class="mb-3">
                                    <label for = "fechaCheckOut" >Fecha de Check-Out: </label>
                                    <input type="date" name="fechaCheckOut">
                                </p>

                                <!-- Seleccion de habitación que se va a reservar -->
                                <p class="mb-3">
                                    <label for = "habitacionReserva" >Habitaciones disponibles:</label> 
                                    <select name ="habitacionReserva">
                                        <option value="-">-</option>
                                        <c:forEach items="${listaHab}" var="listaHab">
                                            <option value="${listaHab.getNombreTematica()}">${listaHab.getNombreTematica()} </option>
                                        </c:forEach>    
                                    </select>
                                </p>

                                <p class="mb-3">
                                    <label for = "importeTotalReserva" >Importe total: </label>
                                    <input type="text" name="importeTotalReserva" value= "$0.0" disabled>
                                </p>
                                <br>

                                <div class="intro-button mx-auto">
                                    <a class="btn btn-primary btn-xl" href="#!">Guardar</a>
                                </div>
                            </form>


                        </div>
                    </div>
                </div>
        </section>
        <footer class="footer text-faded text-center py-5">
            <div class="container"><p class="m-0 small">Copyright &copy; Hotel Integrador 2021</p></div>
        </footer>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>

    </body>
</html>

<%-- 
    Document   : altaReserva
    Created on : 22 jul. 2021, 20:58:35
    Author     : Caro
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Controladora"%>
<%@page import="Logica.Habitacion"%>
<%@page import="java.util.List"%>



<!DOCTYPE html>
<html lang="es">
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
        <script src="js/validador.js"></script>
        <title>Nueva reserva</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String loginusuario = (String) sesion.getAttribute("usuario");

            //verifico si el usuario admin esta creado y si no lo agrego
            if (loginusuario == null) {
                response.sendRedirect("login.jsp");
            } else {

        %>
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

                        <!-- Menú de Reservas-->
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Reservas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">

                                <li><a class="dropdown-item" href="nuevaReserva.jsp">Nueva Reserva</a></li>

                                <li><a class="dropdown-item" href="consultaReserva.jsp">Listado de reservas</a></li>
                                <form action="SvConsultaReservaxDia" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsultaReservaxDia">Buscar reserva por fecha</a></li>
                                </form>
                                <form action="SvConsResxEmp" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsResxEmp">Buscar reserva por empleado</a></li>
                                </form>
                                <form action="SvConsResxHuesped" method="GET">
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsResxHuesped">Buscar reserva por huésped</a></li>
                                </form>



                            </ul>
                        </li>

                        <!-- Menú de Clientes-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Huéspedes
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="consultaClientes.jsp">Listado de huéspedes</a></li>
                                <!-- <li><a class="dropdown-item" href="modificarCliente.jsp">Editar Clientes</a></li> -->

                            </ul>
                        </li>

                        <!-- Menú de Habitaciones-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Habitaciones
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaHabitacion.jsp">Nueva Habitación</a></li>
                                <li><a class="dropdown-item" href="consultaHabitaciones.jsp">Listado de habitaciones</a></li>
                                <form action="SvEdicionHabitacion" method="GET">
                                    <li><a class="SUBMIT dropdown-item" href="SvEdicionHabitacion">Editar habitaciones</a></li>
                                </form>

                            </ul>
                        </li>

                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Empleados
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaEmpleado.jsp">Alta de Empleado</a></li>
                                <li><a class="dropdown-item" href="consultaEmpleados.jsp">Lista de Empleados</a></li>
                            </ul>
                        </li>

                        <!-- Logout-->
                         <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Salir
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <form action="SvCerrarSesion" method="GET">
                                    <li><a class="dropdown-item" href="SvCerrarSesion">Cerrar Sesión</a></li>
                                </form>
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
                            <form name="formAltaReserva"  class="border p-3 form" action="SvAltaReserva" method="Post" >
                                <!-- Fecha de chek in -->
                                <div class="row">
                                    <div class="col">
                                        <label for = "fechaCheckIn" class="form-label" '>Fecha de Check-In: </label>
                                        <input type="date" class="form-control" name="fechaCheckIn">
                                    </div>

                                    <!-- Fecha de chek out -->    
                                    <div class="col">
                                        <label for = "fechaCheckOut" class="form-label" >Fecha de Check-Out: </label>
                                        <input type="date" class="form-control" name="fechaCheckOut">
                                    </div>
                                </div>
                                <!-- Ingreso de Cantidad de personas -->
                                <div class="row">
                                    <div class="col">
                                        <label for = "cantidadPersonas" class="form-label">Cantidad de personas:</label> 
                                        <select name ="cantidadPersonas" class="form-control">
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
                                    </div>
                                    <div class="col">
                                        <br>
                                        <input type="submit" id="btnBuscarxFecha" name="btnBuscarxFecha" class="btn btn-primary btn-xs" value="Buscar habitaciones disponibles" onclick ="return validarRes();"> 
                                    </div>
                                </div>

                        </div>

                        </form>
                        <script>
                            function validarRes() {
                                var cantPersonas, fCheckin, fCheckout;

                                //recupero los datos del jsp de alta de reserva

                                cantPersonas = document.formAltaReserva.cantidadPersonas.value;
                                fCheckin = document.formAltaReserva.fechaCheckIn.value;
                                fCheckout = document.formAltaReserva.fechaCheckOut.value;

                                //compruebo que no queden campos vacíos
                                if (cantPersonas === "" || fCheckin === "" || fCheckout === "") {
                                    alert("Todos los campos deben estar completos");
                                    return false;
                                }


                                //compruebo que se encuentre selecionada la cantidad de personas que se van a hospedar
                                if (cantPersonas === "-") {
                                    alert("Debe seleccionar la cantidad de personas que se van a hospedar");
                                    return false;
                                }

                                //obtengo la fecha del día para validar la que se esta ingresando de checkin
                                var fechaHoy = new Date();
                                dia = '0' + fechaHoy.getDate();
                                mes = '0' + (fechaHoy.getMonth() + 1);
                                anio = fechaHoy.getFullYear();
                                fHoy = anio + '-' + mes + '-' + dia;


                                //verifica que la fecha de checkin sea a futuro, que no se cargue una fecha pasada
                                if (compararFechas(fHoy, fCheckin)) {
                                    alert("La fecha de CheckIn no puede ser anterior a la fecha de hoy");
                                    return false;
                                }

                                //comparo si la fecha de check in es anterior a la de check out
                                if (compararFechas(fCheckin, fCheckout)) {
                                    alert("La fecha de CheckOut no puede ser anterior al CheckIn");
                                    return false;
                                }

                                //compruebo si las fechas son iguales
                                var ingreso = new Date(fCheckin).getTime();
                                var salida = new Date(fCheckout).getTime();
                                if (ingreso === salida) {
                                    alert("La fecha de CheckIn no puede ser igual a la de CheckOut");
                                    return false;
                                }


                            }

                        </script>

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
        <%            }
        %>
    </body>
</html>

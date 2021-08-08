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

                        <!-- Menú de Altas-->
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Altas
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaReserva.jsp">Nueva Reserva</a></li>
                                <li><a class="dropdown-item" href="altaHabitacion.jsp">Nueva Habitación</a></li>
                                <li><a class="dropdown-item" href="altaEmpleado.jsp">Alta de Empleado</a></li>
                            </ul>
                        </li>

                        <!-- Menú de Consultas-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Consulta
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="consultaReservas.jsp">Reservas</a></li>
                                <li><a class="dropdown-item" href="consultaHabitaciones.jsp">Habitaciones</a></li>
                                <li><a class="dropdown-item" href="consultaEmpleados.jsp">Empleados</a></li>
                                <li><a class="dropdown-item" href="consultaClientes.jsp">Clientes</a></li>
                            </ul>
                        </li>
                        <!-- Menú de Ediciones-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Editar
                            </a>
                          <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <form action="SvEditarReserva" method="GET">
                                    <li><a class="SUBMIT dropdown-item" href="SvEditarReserva">Reserva</a></li>
                                </form>
                                <li><a class="dropdown-item" href="modificarCliente.jsp">Cliente</a></li>
                                <form action="SvEdicionHabitacion" method="GET">
                                    <li><a class="SUBMIT dropdown-item" href="SvEdicionHabitacion">Habitación</a></li>
                                </form>
                                <li><a class="dropdown-item" href="modificarEmpleado.jsp">Empleado</a></li>
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
                            <form name="formAltaReserva"  class="border p-3 form" action="SvAltaReserva" method="POST" >

                                <!-- Ingreso de datos del huesped -->
                                <div class="row">
                                    <!-- Ingreso de nombre del huesped -->
                                    <div class="col">
                                        <label for = "nombreHuesped" class="form-label" >Nombre: </label>
                                        <input type="text" class="form-control" name="nombreHuesped" required>
                                    </div>

                                    <!-- Ingreso del apellido -->
                                    <div class="col">
                                        <label for = "apellidoHuesped" class="form-label" >Apellido: </label>
                                        <input type="text" class="form-control" name="apellidoHuesped" required>
                                    </div>
                                </div>

                                <div class="row">
                                    <!-- Ingreso del dni del huesped -->
                                    <div class="col">
                                        <label for = "dniHuesped" class="form-label" >Número de dni: </label>
                                        <input type="text" class="form-control" name="dniHuesped" required>
                                    </div>

                                    <!-- Fecha de nacimiento del huesped -->
                                    <div class="col">
                                        <label for = "fechaNacHuesped" class="form-label">Fecha de nacimiento: </label>
                                        <input type="date" class="form-control" name="fechaNacHuesped" required>
                                    </div>
                                </div>

                                <!-- ingreso de dirección -->
                                <div class="row">
                                    <div class="col">
                                        <label for = "direccionHuesped" class="form-label" >Dirección: </label>
                                        <input type="text" class="form-control" name="direccionHuesped" required>
                                    </div>

                                    <!-- Ingreso de Profesion -->

                                    <div class="col">
                                        <label for = "profesionHuesped" class="form-label">Profesión: </label>
                                        <input type="text" class="form-control"  name="profesionHuesped" required>
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
                                        <!-- Seleccion de habitación que se va a reservar -->
                                        <label for = "habitacionReserva" class="form-label">Habitaciones disponibles:</label> 
                                        <select name ="habitacionReserva" class="form-control">
                                            <option value="-">-</option>
                                            <%                                                //Cargo los valores de la tabla de habitaciones en el combobox
                                                Controladora control = new Controladora();
                                                List<Habitacion> listaHabitacion = new ArrayList();
                                                Habitacion habitacion = new Habitacion();
                                                listaHabitacion = control.recuperarHabitaciones();
                                                for (int i = 0; i < listaHabitacion.size(); i++) {
                                                    habitacion = listaHabitacion.get(i);
                                                    out.println("<option value=\"" + habitacion.getIdHabitacion() + "\" " + ">" + habitacion.getNombreTematica() + " - " + habitacion.getTipoHab() + " - $" + habitacion.getPrecioHabitacion() + "</option>");
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>

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

                                <br>

                                <div class="intro-button mx-auto">
                                    <input type="submit" name="btnGuardar" class="btn btn-primary btn-xl" value="Guardar" onclick ="return validarReserva();"> 
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
        <%
            }
        %>
    </body>
</html>

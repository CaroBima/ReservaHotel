<%-- 
    Document   : modificarHabitacion
    Created on : 3 ago. 2021, 00:44:44
    Author     : Caro
--%>

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
        <title>Consulta de Empleados</title>
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
                                <li><a class="dropdown-item" href="altaReserva.jsp">Nueva Reserva</a></li>
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
                                 <form action="SvEditarReserva" method="GET">
                                    <li><a class="SUBMIT dropdown-item" href="SvEditarReserva">Editar Reserva</a></li>
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
                                <span class="section-heading-lower">Editar Habitaciones</span>
                            </h2>

                            <!-- comienzo de la tabla que muestra el listado de las habitaciones -->
                            <div class="table-responsive">
                                <table class="table table-striped table-hover">
                                    <thead>
                                        <tr>
                                            <td>Tipo de habitación:</td>
                                            <td>Nombre temático:</td>
                                            <td>Piso:</td>
                                            <td>Número de habitación:</td>
                                            <td>Precio</td>
                                            <td>Eliminar</td>
                                            <td>Modificar</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%  
                                            HttpSession misesion = request.getSession();
                                            
                                            //recorro la lista para cargar los valores en la tabla
                                            List<Habitacion> listaHabitaciones;
                                            listaHabitaciones = (List) misesion.getAttribute("listaHabitaciones");
                                            if (listaHabitaciones != null) {
                                                for (Habitacion hab : listaHabitaciones) {
                                                    
                                        %>
                                        <tr>    
                                            <td><%= hab.getTipoHab()%></td>

                                            <td><%= hab.getNombreTematica()%></td>

                                            <td><%= hab.getPiso()%></td>

                                            <td><%= hab.getNroHabitacion()%></td>

                                            <td><%= hab.getPrecioHabitacion()%></td>
                                            
                                            <% 
                                                int idHab = hab.getIdHabitacion(); 
                                            %>
                                            
                                            <td> 
                                                <form name="frmEliminarHabitacion" action="SvEliminarHabitacion" method="POST" style="display:inline">
                                                    <input  type="Hidden" name="idHabitacion" value="<%=idHab%>">
                                                    <button type="submit" class="btn btn-outline-danger btn-xs" data-title="Delete" style="display:inline"><img src="assets/icons/trash.svg"></button> 
                                                </form>        
                                            </td>
                                            <td>
                                                <form name="frmEditarHabitacion" action="SvModifHabitacion" method="POST" style="display:inline">
                                                    <input  type="Hidden" name="idHabitacion" value="<%=idHab%>">
                                                    <button type="submit" class="btn btn-outline-warning btn-xs" data-title="Edit" style="display:inline"><img src="assets/icons/pencil-square.svg"></button> 
                                                </form>        
                                            </td>
                                        </tr>
                                        <%
                                                } //cierre del for
                                            }//cierre del if
                                        %>
                                    </tbody>
                                </table>
                            </div>


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

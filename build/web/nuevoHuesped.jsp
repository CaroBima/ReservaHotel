<%-- 
    Document   : nuevoHuesped
    Created on : 9 ago. 2021, 10:03:03
    Author     : Caro
--%>



<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/x-icon" href="assets/hotel.svg" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Hotel Integrador</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet" />

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <!--<link rel="stylesheet" href="css/style.css">-->
        <!-- <script src="js/scripts.js"></script>-->
        <script src="js/validador.js"></script>
        <title>Gestion de reservas</title>
    </head>
    <body>
        <%
            HttpSession misesion = request.getSession();
            String usuario = (String) misesion.getAttribute("usuario");

            if (usuario == null) {
                response.sendRedirect("login.jsp");
            } else {

        %>
        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">Hotel</span>
                <span class="site-heading-lower">Integrador</span>
            </h1>
        </header>
   <!-- Men� de navegacion-->
        <nav class="navbar navbar-expand-lg navbar-dark py-lg-3" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">Principal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                    <ul class="navbar-nav">

                        <!-- Men� de Reservas-->
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
                                    <li><a class="SUBMIT dropdown-item"  href="SvConsResxHuesped">Buscar reserva por hu�sped</a></li>
                                </form>
                             
                                
                                
                            </ul>
                        </li>

                        <!-- Men� de Clientes-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Hu�spedes
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="consultaClientes.jsp">Listado de hu�spedes</a></li>
                               <!-- <li><a class="dropdown-item" href="modificarCliente.jsp">Editar Clientes</a></li> -->
                                
                            </ul>
                        </li>
                        
                        <!-- Men� de Habitaciones-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Habitaciones
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
                                <li><a class="dropdown-item" href="altaHabitacion.jsp">Nueva Habitaci�n</a></li>
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
                            <!-- Formulario de reserva -->
                            <form name="frmAltaHuesped"  class="border p-3 form" action="SvAltaHuesped" method="Post" >
                                <!-- Ingreso de datos del huesped -->
                                <div class="row">
                                    <!-- Ingreso de nombre del huesped -->
                                    <div class="col">
                                        <label for = "nombreHuesped" class="form-label" >Nombre: </label>
                                        <input type="text" class="form-control" name="nombreHuesped">
                                    </div>

                                    <!-- Ingreso del apellido -->
                                    <div class="col">
                                        <label for = "apellidoHuesped" class="form-label" >Apellido: </label>
                                        <input type="text" class="form-control" name="apellidoHuesped">
                                    </div>
                                </div>


                                <div class="row">
                                    <!-- Ingreso del dni del huesped -->
                                    <div class="col">
                                        <label for = "dniHuesped" class="form-label" >N�mero de dni: </label>
                                        <input type="text" class="form-control" name="dniHuesped" >
                                    </div>

                                    <!-- Fecha de nacimiento del huesped -->
                                    <div class="col">
                                        <label for = "fechaNacHuesped" class="form-label">Fecha de nacimiento: </label>
                                        <input type="date" class="form-control" name="fechaNacHuesped">
                                    </div>
                                </div>

                                <!-- ingreso de direcci�n -->
                                <div class="row">
                                    <div class="col">
                                        <label for = "direccionHuesped" class="form-label" >Direcci�n: </label>
                                        <input type="text" class="form-control" name="direccionHuesped">
                                    </div>

                                    <!-- Ingreso de Profesion -->

                                    <div class="col">
                                        <label for = "profesionHuesped" class="form-label">Profesi�n: </label>
                                        <input type="text" class="form-control"  name="profesionHuesped">
                                    </div>
                                </div>

                                <br>
                                <div class="intro-button mx-auto">
                                    <input type="submit" class="btn btn-primary btn-xl" value="Guardar" onclick ="return validarHuesped();" > 
                                </div> 

                            </form>  

                            <script>
                                function validarHuesped() {
                                    var nombre, apellido, dni, fechaNac, direccion, profesion;

                                    nombre = document.frmAltaHuesped.nombreHuesped.value;
                                    apellido = document.frmAltaHuesped.apellidoHuesped.value;
                                    dni = document.frmAltaHuesped.dniHuesped.value;
                                    fechaNac = document.frmAltaHuesped.fechaNacHuesped.value;
                                    direccion = document.frmAltaHuesped.direccionHuesped.value;
                                    profesion = document.frmAltaHuesped.profesionHuesped.value;

                                    if (nombre === "" || apellido === "" || dni === "" || fechaNac === "" || direccion === "" || profesion === "") {
                                        alert("Todos los campos deben estar completos");
                                        return false;
                                    }

                                    if (calcularEdad(fechaNac) < 18) {
                                        alert("Debe tener al menos 18 a\u00f1os para poder ser titular de la reserva");
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
        <%         }
        %>   
    </body>
</html>


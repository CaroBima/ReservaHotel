<%-- 
  Formulario de alta de un nuevo empleado
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Logica.Cargo"%>
<%@page import="Logica.Controladora"%>
<%@page import ="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
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
        <script src="js/scripts.js"></script>
        <title>Gestion de reservas</title>
    </head>
    <body>

        <header>
            <h1 class="site-heading text-center text-faded d-none d-lg-block">
                <span class="site-heading-upper text-primary mb-3">Hotel</span>
                <span class="site-heading-lower">Integrador</span>
            </h1>
        </header>

        <!-- Menú de navegación-->
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
                                <span class="section-heading-lower">Alta de nuevo empleado</span>
                            </h2>

                            <!-- Formulario de reserva -->
                            <form name="formAltaEmple" class="border p-3 form" action="SvAltaEmpleado" method="POST">
                                <h1>Nuevo empleado</h1>
                                <br>
                                <div class="row">
                                    <div class="col">
                                        <label for = "usuarioEmpleado" class="form-label">Usuario:</label> 
                                        <input type="text"  class="form-control" name="usuarioEmpleado">
                                    </div>   
                                    <div class="col">
                                        <label for = "contraseniaEmpleado" class="form-label">Contraseña:</label> 
                                        <input type="password"  class="form-control" name="contraseniaEmpleado">
                                    </div>
                                </div> 
                                <br>
                                <div class="row">
                                    <div class="col">
                                        <label for = "nombreEmpleado" class="form-label">Nombre:</label> 
                                        <input type="text"  class="form-control" name="nombreEmpleado">
                                    </div>

                                    <div class="col">
                                        <label for = "apellidoEmpleado" class="form-label">Apellido:</label> 
                                        <input type="text"  class="form-control" name="apellidoEmpleado">
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col"> 
                                        <label for = "dniEmpleado" class="form-label">Dni: </label>
                                        <input type="text"  class="form-control" name="dniEmpleado">
                                    </div>

                                    <div class="col">
                                        <label for = "direccionEmpleado" class="form-label">Dirección: </label>
                                        <input type="text"  class="form-control" name="direccionEmpleado">
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col">
                                        <label for = "fechaNacEmpleado" class="form-label">Fecha de nacimiento: </label>
                                        <input type="date"  class="form-control" name="fechaNacEmpleado" >
                                    </div>

                                    <div class="col">
                                        <label for = "cargoEmpleado" class="form-label">Cargo: </label>
                                        <select name ="cargoEmpleado"  class="form-control">
                                            <option value="-"  class="form-control-lg">-</option>
                                            <%
                                                //Cargo los valores de la tabla de cargos en el combobox
                                                Controladora control = new Controladora();
                                                List<Cargo> listaCargos = new ArrayList();
                                                Cargo cargo = new Cargo();
                                                listaCargos = control.recuperarCargos();
                                                for (int i = 0; i < listaCargos.size(); i++) {
                                                    cargo = listaCargos.get(i);
                                                    out.println("<option value=\"" + cargo.getNombreCargo() + "\"" + ">" + cargo.getNombreCargo() + "</option>");
                                                }
                                            %>
                                        </select>
                                        <input type="button" name="btnNuevoCargo" class="btn btn-primary btn-xs" value="Añadir cargo" onclick='ingresoCargo()'> 

                                    </div>
                                </div>
                                <br>
                                <div class="intro-button mx-auto">
                                    <input type="submit" name="btnGuardar" class="btn btn-primary btn-xl" value="Guardar"> 
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



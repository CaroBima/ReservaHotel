<%-- 
    Document   : modificarHabitacion
    Created on : 3 ago. 2021, 12:37:02
    Author     : Caro
--%>


<%@page import="Logica.Habitacion"%>
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
        <script src="js/scripts.js"></script>
        <title>Gestion de reservas</title>
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
                                <li><a class="dropdown-item" href="modificarReserva.jsp">Reserva</a></li>
                                <li><a class="dropdown-item" href="modificarCliente.jsp">Cliente</a></li>
                                <li><a class="dropdown-item" href="modificarHabitacion.jsp">Habitación</a></li>
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
                                <span class="section-heading-lower">Modificar Habitación</span>
                            </h2>

                            <!-- Formulario de alta de nueva habitación -->
                            <form action="SvModifHabitacion"  class="border p-3 form" method="get">
                                <%                                    
                                    HttpSession misesion = request.getSession();
                                    Habitacion habitacion = (Habitacion) misesion.getAttribute("habitacion");
                                %>
                                <h1>Modificar la habitación</h1>

                                <br>

                                <div class="row">
                                    <div class="col">
                                        
                                        <!-- Ingreso del tipo de habitación -->
                                        <label for = "tipoHabitacion" class="form-label">Tipo:</label>
                                        <%  //verifico que valor corresponde al tipo de habitacion y marco el previamente cargado en la bd
                                            if (habitacion.getTipoHab().equals("Single")) {
                                        %>    
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Single" checked="checked" >Single
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Doble">Doble
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Triple">Triple
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Multiple">Múltiple (8 pers. Máx.)
                                        <%
                                        } else {
                                            if (habitacion.getTipoHab().equals("Doble")) {
                                        %> 
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Single">Single
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Doble" checked="checked" >Doble
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Triple">Triple
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Multiple">Múltiple (8 pers. Máx.)
                                        <%  } else if (habitacion.getTipoHab().equals("Triple")) {
                                        %>
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Single">Single
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Doble">Doble
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Triple" checked="checked" >Triple
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Multiple">Múltiple (8 pers. Máx.)
                                        <% } else {
                                        %>
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Single" >Single
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Doble">Doble
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Triple">Triple
                                        <input type="radio" class="radio-control" name="tipoHabitacion" value="Multiple" checked="checked" >Múltiple (8 pers. Máx.)
                                        <% }
                                            }
                                        %>
                                    </div>  
                                </div>

                                <br>

                                <div class="row">
                                    <div class="col">
                                        <!-- Muestro nombre temático de la habitación ingresado previamente-->
                                        <label for = "nombreTematico" class="form-label">Nombre temático:</label> 
                                        <input type="text" class="form-control" name="nombreTematico" value="<%= habitacion.getNombreTematica()%>">
                                    </div>

                                    <div class="col">
                                        <!-- Muestro el precio de la habitación recuperado-->
                                        <label for = "precioHabitacion" class="form-label">Precio:</label> 
                                        <input type="text" class="form-control" name="precioHabitacion" value="<%= habitacion.getPrecioHabitacion()%>">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col">
                                        <!-- Piso donde esta la habitación -->
                                        <label for = "pisoHabitacion" class="form-label">Piso:</label> 
                                        <select name="pisoHabitacion" class="form-control" required>
                                            <%
                                                //para que quede seleccionado por defecto el piso que estaba guardado
                                                switch (habitacion.getPiso()) {
                                                    case 1:

                                            %>    
                                            <option value="1" selected>1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%   
                                                break;
                                                case 2:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2" selected>2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                break;
                                                case 3:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3" selected>3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                break;
                                                case 4:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4" selected>4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                break;
                                                case 5:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5" selected>5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                break;
                                                case 6:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6" selected>6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                break;
                                                case 7:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7" selected>7º Piso</option>
                                            <option value="8">8º Piso</option>
                                            <%
                                                    break;
                                                case 8:
                                            %>
                                            <option value="1">1º Piso</option>
                                            <option value="2">2º Piso</option>
                                            <option value="3">3º Piso</option>
                                            <option value="4">4º Piso</option>
                                            <option value="5">5º Piso</option>
                                            <option value="6">6º Piso</option>
                                            <option value="7">7º Piso</option>
                                            <option value="8" selected>8º Piso</option>
                                            <%
                                                }//cierre del switch
                                            %>
                                        </select>
                                    </div> 

                                    <!-- Ingreso del número de habitación -->
                                    <div class="col">
                                        <label for = "nroHabitacion" class="form-label">Número de Habitación:</label> 
                                        <select name ="nroHabitacion" class="form-control" required>
                                           <% 
                                               //cargo como selected la habitacion que traigo de la base de datos
                                            switch(habitacion.getNroHabitacion()){
                                                case 1:
                                           %>
                                            <option value="1" selected>1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <% 
                                                break;
                                                case 2:
                                            %>
                                            <option value="1">1</option>
                                            <option value="2" selected>2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <% 
                                                break;
                                                case 3:
                                            %> 
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3" selected>3</option>
                                            <option value="4">4</option>
                                            <% 
                                                break;
                                                case 4:
                                            %>
                                             <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4" selected>4</option>
                                         
                                            <% 
                                                }//cierre del switch de nro de habitacion
                                            %>
                                        </select>
                                    </div>
                                <!-- Guardo el id de la habitacion -->
                                    <input type="hidden" name="idHabitacion" value="<%=habitacion.getIdHabitacion() %>" >
                                </div>

                                            
                                <br>
                                <div class="intro-button mx-auto">
                                    <input type="submit" class="btn btn-primary btn-xl" value="Guardar"> 
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
        <% }%>
    </body>
</html>
